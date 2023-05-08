package ks46team01.common.company.contract.entity;

import jakarta.persistence.*;
import ks46team01.admin.company.unit.entity.CompanyUnit;
import ks46team01.common.company.info.entity.CompanyInfo;
import lombok.*;
import org.hibernate.Hibernate;

import java.sql.Date;
import java.util.List;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_info_idx", nullable = false)
    @ToString.Exclude
    private CompanyInfo companyInfoIdx;

    @OneToMany(mappedBy = "companyContractIdx", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private List<CompanyContractApprove> companyContractApprovals;

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
