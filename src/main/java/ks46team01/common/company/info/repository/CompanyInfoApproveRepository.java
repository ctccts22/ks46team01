package ks46team01.common.company.info.repository;


import ks46team01.common.company.info.entity.CompanyInfoApprove;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompanyInfoApproveRepository
        extends JpaRepository<CompanyInfoApprove, Long> {

    @Query("select cia from CompanyInfoApprove as cia")
    List<CompanyInfoApprove> findAll();

    Optional<CompanyInfoApprove> findByCompanyInfoApproveIdx(Long companyInfoApproveIdx);

    @Query("SELECT cia FROM CompanyInfoApprove cia JOIN FETCH cia.companyInfoIdx WHERE cia.companyInfoApproveIdx = :companyInfoApproveIdx")
    Optional<CompanyInfoApprove> findWithCompanyInfoAndAdminByUsername(@Param("companyInfoApproveIdx") Long companyInfoApproveIdx);

    @Query("SELECT ci, cia FROM CompanyInfo ci LEFT JOIN FETCH ci.companyInfoApprovals cia LEFT JOIN FETCH cia.adminUsername")
    List<Object[]> findAllCompanyInfoWithApprovals();
}