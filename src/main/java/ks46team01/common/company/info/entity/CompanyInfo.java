package ks46team01.common.company.info.entity;

import jakarta.persistence.*;
import ks46team01.admin.company.entity.Company;
import ks46team01.admin.company.unit.entity.CompanyUnit;
import ks46team01.admin.inventory.entity.Inventory;
import ks46team01.user.info.entity.User;
import lombok.*;
import org.hibernate.Hibernate;

import java.sql.Timestamp;
import java.util.List;
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

    @Column(name = "company_info_address", nullable = false)
    private String companyInfoAddress;

    @Column(name = "company_info_phone", nullable = false)
    private String companyInfoPhone;

    @Column(name = "company_info_date", nullable = false)
    private Timestamp companyInfoDate;

    @Column(name = "company_info_update")
    private Timestamp companyInfoUpdate;

    @Column(name = "company_info_is_del", length = 2, columnDefinition = "char(2) default 'N'")
    private String companyInfoIsDel;

    @Column(name = "company_info_is_del_date")
    private Timestamp companyInfoIsDelDate;

    @OneToMany(mappedBy = "companyInfoIdx", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private List<CompanyInfoApprove> companyInfoApprovals;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_unit_idx", nullable = false)
    @ToString.Exclude
    private CompanyUnit companyUnitIdx;

    @PrePersist
    public void setDefaultCompanyInfoIsDel() {
        this.companyInfoIsDel = (this.companyInfoIsDel == null) ? "N" : this.companyInfoIsDel;
    }

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