package ks46team01.admin.info.service;

import ks46team01.user.info.entity.User;
import ks46team01.user.info.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
@AllArgsConstructor
public class AdminRestService {
    private final UserRepository userRepository;

    public void modifyUser(User updatedUser) {
    try {
        User user = userRepository.findByUsername(updatedUser.getUsername()).orElseThrow(()
                -> new IllegalArgumentException("유저를 찾을수 없습니다."));
        user.setUsername(updatedUser.getUsername());
        user.setPassword(updatedUser.getPassword());
        user.setRoleIdx(updatedUser.getRoleIdx());
        user.setName(updatedUser.getName());
        user.setBirth(updatedUser.getBirth());
        user.setEmail(updatedUser.getEmail());
        user.setPhone(updatedUser.getPhone());
        user.setAddress(updatedUser.getAddress());
        user.setDate(updatedUser.getDate());
        user.setModifyDate(updatedUser.getModifyDate());
        user.setIsDel(updatedUser.getIsDel());
        user.setIsDelDate(updatedUser.getIsDelDate());
        userRepository.save(user);
    } catch (Exception e) {
        log.error("Error modifying user: {}", updatedUser, e);
        throw e;
    }

    }

}
