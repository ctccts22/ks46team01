package ks46team01.user.service;

import ks46team01.auth.entity.Role;
import ks46team01.auth.repository.RoleRepository;
import ks46team01.auth.security.BcryptHashing;
import ks46team01.user.entity.User;
import ks46team01.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User createUser(User user) {
        String hashedPassword = BcryptHashing.hash(user.getPassword());
        user.setPassword(hashedPassword);

        Role userRole = roleRepository.findByRoleName(Role.RoleName.USER);
        user.setRoleIdx(userRole);

        user.setDate(new Timestamp(System.currentTimeMillis()));
        return userRepository.save(user);
    }

    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
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



}
