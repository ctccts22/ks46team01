package ks46team01.user.service;

import ks46team01.auth.entity.Role;
import ks46team01.auth.repository.RoleRepository;
import ks46team01.user.entity.User;
import ks46team01.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

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
        Role userRole = roleRepository.findByRoleName(Role.RoleName.USER);
        user.setRoleIdx(userRole);


        user.setDate(new Timestamp(System.currentTimeMillis()));
        return userRepository.save(user);


    }
}
