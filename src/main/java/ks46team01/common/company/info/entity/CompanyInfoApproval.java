package ks46team01.common.company.info.entity;

import jakarta.persistence.*;
import ks46team01.admin.info.entity.Admin;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

@Entity
@Table(name = "company_info_approval")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class CompanyInfoApproval {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_info_approval_idx")
    private Long companyInfoApprovalIdx;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_info_idx")
    @ToString.Exclude
    private CompanyInfo companyInfoIdx;

    @ManyToOne
    @JoinColumn(name = "admin_username")
    private Admin admin;

    @Column(name = "company_info_approve_date")
    private Date companyInfoApproveDate;

    @Column(name = "company_info_status")
    private String companyInfoStatus;

    @Column(name = "company_info_content")
    private String companyInfoContent;

}
