package ks46team01.common.company.contract.repository;

import ks46team01.common.company.contract.entity.CompanyContract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface CompanyContractRepository extends JpaRepository<CompanyContract, Long> {
    @Query("select cc from CompanyContract as cc")
    List<CompanyContract> findAll();


}

