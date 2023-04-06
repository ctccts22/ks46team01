package ks46team01.user.repository;

import ks46team01.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    List<User> findAll();

    Optional<User> findByUsername(String username);

    void deleteByUsername(String username);
}
