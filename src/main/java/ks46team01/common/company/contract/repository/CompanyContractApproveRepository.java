package ks46team01.common.company.contract.repository;

import ks46team01.common.company.contract.entity.CompanyContractApprove;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CompanyContractApproveRepository
        extends JpaRepository<CompanyContractApprove, Long> {

    @Query("SELECT cc, cca FROM CompanyContract cc LEFT JOIN FETCH cc.companyContractApprovals cca LEFT JOIN FETCH cca.adminUsername")
    List<Object[]> findAllCompanyContractWithApprovals();

    @Query("SELECT cca FROM CompanyContractApprove cca JOIN FETCH cca.companyContractIdx " +
            "WHERE cca.companyContractApproveIdx = :companyContractApproveIdx")
    Optional<CompanyContractApprove> findWithCompanyContractAndAdminByUsername
            (@Param("companyContractApproveIdx") Long companyContractApproveIdx);

    long countByCompanyContractApproveStatus(String y);

}
