package ks46team01.user.info.repository;

import ks46team01.user.info.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    // JPQL은 생략가능하다
    // 파라미터 바인딩은 : 이름기준 바인딩과 ?1 위치기반 바인딩이 있다
    // 이름기준 바인딩이 더 정확하다
    // 파라미터 바인딩을 사용하지 않으면 sql injection 공격에 취약하다
    // @param은 Java8부터 생략가능(이름기반 바인딩)
    @Query("select u from User as u")
    List<User> findAll();

    @Query("select u from User as u where u.username = :username")
    Optional<User> findByUsername(@Param("username") String username);

    @Query("select u from User as u where u.email = :email")
    List<User> findByEmail(@Param("email") String email);

}
