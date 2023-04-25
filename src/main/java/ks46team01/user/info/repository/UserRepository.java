package ks46team01.user.info.repository;

import ks46team01.user.info.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    // 모든 엔티티를 조회한다.

    Optional<User> findByUsername(String username);

    List<User> findByEmail(String email);


}
