package ks46team01.user.service;

import ks46team01.user.entity.User;
import ks46team01.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User createUser(User user) {
        user.setDate(new Timestamp(System.currentTimeMillis()));
        return userRepository.save(user);
    }
}
