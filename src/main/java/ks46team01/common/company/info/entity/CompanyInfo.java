package ks46team01.common.company.info.entity;

import jakarta.persistence.*;
import ks46team01.admin.company.entity.Company;
import ks46team01.admin.info.entity.Admin;
import ks46team01.admin.inventory.entity.Inventory;
import ks46team01.user.info.entity.User;
import lombok.*;
import org.hibernate.Hibernate;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "company_info")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class CompanyInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_info_idx", nullable = false, unique = true)
    private Long companyInfoIdx;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "username", nullable = false)
    @ToString.Exclude
    private User username;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_idx", nullable = false)
    @ToString.Exclude
    private Company companyIdx;

    @Column(name = "company_info_name", nullable = false)
    private String companyInfoName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inventory_idx", nullable = false)
    @ToString.Exclude
    private Inventory inventoryIdx;

    @Column(name = "company_info_license_number", nullable = false)
    private String companyInfoLicenseNumber;

    @Column(name = "company_info_type", nullable = false)
    private String companyInfoType;

    @Column(name = "company_info_address", nullable = false)
    private String companyInfoAddress;

    @Column(name = "company_info_phone", nullable = false)
    private String companyInfoPhone;

    @Column(name = "company_info_date", nullable = false)
    private Timestamp companyInfoDate;

    @Column(name = "company_info_drop")
    private Timestamp companyInfoDrop;

    @Column(name = "company_info_update")
    private Timestamp companyInfoUpdate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "admin_username")
    @ToString.Exclude
    private Admin adminUsername;

    @Column(name = "company_info_approve_date")
    private Timestamp companyInfoApproveDate;

    @Column(name = "company_info_status")
    private String companyInfoStatus;

    @Column(name = "company_info_content")
    private String companyInfoContent;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CompanyInfo companyInfo = (CompanyInfo) o;
        return Objects.equals(companyInfoIdx, companyInfo.companyInfoIdx);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}