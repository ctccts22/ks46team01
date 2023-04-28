package ks46team01.common.company.info.repository;


import ks46team01.common.company.info.entity.CompanyInfoApproval;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyInfoApproveRepository
        extends JpaRepository<CompanyInfoApproval, Long> {

    @Query("select cia from CompanyInfoApproval as cia")
    List<CompanyInfoApproval> findAll();

}