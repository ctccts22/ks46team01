package ks46team01.admin.info.repository;

import ks46team01.admin.info.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Admin, String> {

    @Query("SELECT a FROM Admin a")
    List<Admin> findAll();

//    @Query("SELECT a FROM Admin a WHERE a.adminUsername = :adminUsername")
//    Optional<Admin> findByAdminUsername(@Param("adminUsername") String adminUsername);

    @Query("SELECT a FROM Admin a JOIN FETCH a.roleIdx WHERE a.adminUsername = :adminUsername")
    Optional<Admin> findByAdminUsername(@Param("adminUsername") String adminUsername);




}

