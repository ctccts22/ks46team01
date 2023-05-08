package ks46team01.common.company.contract.repository;

import ks46team01.common.company.info.entity.CompanyInfoApprove;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CompanyContractApproveRepository
        extends JpaRepository<CompanyInfoApprove, Long> {

    @Query("SELECT cc, cca FROM CompanyContract cc LEFT JOIN FETCH cc.companyContractApprovals cca LEFT JOIN FETCH cca.adminUsername")
    List<Object[]> findAllCompanyContractWithApprovals();
}
