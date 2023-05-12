package ks46team01.common.company.contract.entity;

import jakarta.persistence.*;
import ks46team01.admin.info.entity.Admin;
import ks46team01.common.company.contract.dto.CompanyContractApproveDTO;
import ks46team01.common.company.info.entity.CompanyInfoApprove;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "company_contract_approve")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class CompanyContractApprove {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_contract_approve_idx")
    private Long companyContractApproveIdx;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_contract_idx")
    @ToString.Exclude
    private CompanyContract companyContractIdx;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "admin_username")
    @ToString.Exclude
    private Admin adminUsername;

    @Column(name = "company_contract_approve_date")
    private Date companyContractApproveDate;

    @Column(name = "company_contract_approve_status")
    private String companyContractApproveStatus;

    @Column(name = "company_contract_approve_content")
    private String companyContractApproveContent;

    @PrePersist
    public void setDefaultCompanyInfoStatus() {
        this.companyContractApproveStatus = (this.companyContractApproveStatus == null) ? "N" : this.companyContractApproveStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CompanyContractApprove companyContractApprove = (CompanyContractApprove) o;
        return Objects.equals(companyContractApproveIdx, companyContractApprove.companyContractApproveIdx);
    }
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    public CompanyContractApproveDTO toCompanyContractApproveDTO() {
        CompanyContractApproveDTO dtoCo = new CompanyContractApproveDTO();
        dtoCo.setCompanyContractApproveIdx(this.getCompanyContractApproveIdx());
        dtoCo.setAdminUsername(this.getAdminUsername().getAdminUsername());
        dtoCo.setCompanyContractApproveDate(this.getCompanyContractApproveDate());
        dtoCo.setCompanyContractApproveStatus(this.getCompanyContractApproveStatus());
        dtoCo.setCompanyContractApproveContent(this.getCompanyContractApproveContent());
        return dtoCo;
    }
}
