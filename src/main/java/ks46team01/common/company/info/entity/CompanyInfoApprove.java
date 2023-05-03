package ks46team01.common.company.info.entity;

import jakarta.persistence.*;
import ks46team01.admin.info.entity.Admin;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "company_info_approve")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class CompanyInfoApprove {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_info_approve_idx")
    private Long companyInfoApproveIdx;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_info_idx")
    @ToString.Exclude
    private CompanyInfo companyInfoIdx;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "admin_username")
    @ToString.Exclude
    private Admin adminUsername;

    @Column(name = "company_info_approve_date")
    private Date companyInfoApproveDate;

    @Column(name = "company_info_approve_status")
    private String companyInfoApproveStatus;

    @Column(name = "company_info_approve_content")
    private String companyInfoApproveContent;

    @PrePersist
    public void setDefaultCompanyInfoStatus() {
        this.companyInfoApproveStatus = (this.companyInfoApproveStatus == null) ? "N" : this.companyInfoApproveStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CompanyInfoApprove CompanyInfoApproval = (CompanyInfoApprove) o;
        return Objects.equals(companyInfoApproveIdx, CompanyInfoApproval.companyInfoApproveIdx);
    }
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
