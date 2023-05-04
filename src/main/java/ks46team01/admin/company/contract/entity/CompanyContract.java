package ks46team01.admin.company.contract.entity;

import jakarta.persistence.*;
import ks46team01.admin.company.unit.entity.CompanyUnit;
import ks46team01.admin.info.entity.Admin;
import ks46team01.admin.inventory.entity.Inventory;
import ks46team01.common.company.info.entity.CompanyInfo;
import ks46team01.user.info.entity.User;
import lombok.*;
import org.hibernate.Hibernate;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "company_contract")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CompanyContract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_contract_idx", nullable = false)
    private Long companyContractIdx;

    @Column(name = "company_contract_delivery_term", nullable = false)
    private String companyContractDeliveryTerm;

    @Column(name = "company_contract_start", nullable = false)
    private Date companyContractStart;

    @Column(name = "company_contract_end", nullable = false)
    private Date companyContractEnd;

    @Column(name = "company_contract_amount", nullable = false)
    private Double companyContractAmount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_unit_idx", nullable = false)
    @ToString.Exclude
    private CompanyUnit companyUnitIdx;

    @Column(name = "company_contract_status", nullable = false)
    private String companyContractStatus;

    @Column(name = "company_contract_content")
    private String companyContractContent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "admin_username", nullable = false)
    @ToString.Exclude
    private Admin adminUsername;

    @Column(name = "company_contract_admin_date", nullable = false)
    private Timestamp companyContractAdminDate;

    @Column(name = "company_contract_admin_update")
    private Timestamp companyContractAdminUpdate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CompanyContract companyContract = (CompanyContract) o;
        return Objects.equals(companyContractIdx, companyContract.companyContractIdx);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
