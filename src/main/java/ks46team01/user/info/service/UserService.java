package ks46team01.user.info.service;

import ks46team01.auth.entity.Role;
import ks46team01.auth.repository.RoleRepository;
import ks46team01.auth.security.BcryptHashing;
import ks46team01.user.info.entity.User;
import ks46team01.user.info.repository.UserRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    private final EmailService emailService;

    public UserService(UserRepository userRepository, RoleRepository roleRepository, EmailService emailService) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.emailService = emailService;
    }


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User createUser(User user) {
        String hashedPassword = BcryptHashing.hash(user.getPassword());
        user.setPassword(hashedPassword);

        Role userRole = roleRepository.findByRoleName(Role.RoleName.USER);
        user.setRoleIdx(userRole);

        user.setDate(new Timestamp(System.currentTimeMillis()));
        return userRepository.save(user);
    }


    public User modifyUser(User updatedUser) {
        Optional<User> existingUserOptional = userRepository.findById(updatedUser.getUsername());
        if (existingUserOptional.isPresent()) {
            User existingUser = existingUserOptional.get();
            existingUser.setEmail(updatedUser.getEmail());
            existingUser.setPhone(updatedUser.getPhone());
            existingUser.setAddress(updatedUser.getAddress());
            existingUser.setModifyDate(new Timestamp(System.currentTimeMillis()));

            return userRepository.save(existingUser);
        } else {
            throw new IllegalArgumentException("User not found with username: " + updatedUser.getUsername());
        }
    }

    public void sendTemporaryPassword(String username, String email) {
        List<User> users = userRepository.findByEmail(email);
        boolean userFound = false;

        for (User user : users) {
            if (user.getUsername().equals(username)) {
                userFound = true;
                String temporaryPassword = generateRandomPassword();
                String hashedTemporaryPassword = BcryptHashing.hash(temporaryPassword);
                user.setPassword(hashedTemporaryPassword);
                userRepository.save(user);

                emailService.sendTemporaryPassword(user.getEmail(), "Temporary Password", "Your temporary password is: " + temporaryPassword);
                break;
            }
        }

        if (!userFound) {
            throw new IllegalArgumentException("User not found with email: " + email + " and username: " + username);
        }
    }

    private String generateRandomPassword() {
        int passwordLength = 8;
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_=+";
        StringBuilder passwordBuilder = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < passwordLength; i++) {
            passwordBuilder.append(characters.charAt(random.nextInt(characters.length())));
        }
        return passwordBuilder.toString();
    }




}
