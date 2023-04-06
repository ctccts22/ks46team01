package ks46team01.user.repository;

import ks46team01.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    // 모든 엔티티를 조회한다.
    List<User> findAll();

    Optional<User> findByUsername(String username);


}
