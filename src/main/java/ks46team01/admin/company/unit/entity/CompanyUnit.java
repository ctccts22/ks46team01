package ks46team01.admin.company.unit.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import ks46team01.common.company.contract.entity.CompanyContract;
import ks46team01.admin.company.entity.Company;
import ks46team01.admin.info.entity.Admin;
import lombok.*;
import org.hibernate.Hibernate;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "company_unit")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CompanyUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_unit_idx", nullable = false)
    private Long companyUnitIdx;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_idx", nullable = false)
    @ToString.Exclude
    private Company companyIdx;

    @Column(name = "company_unit_amount", nullable = false)
    private Double companyUnitAmount;

    @Column(name = "company_unit_price", nullable = false)
    private Integer companyUnitPrice;

    @Column(name = "company_unit_year", nullable = false)
    private Integer companyUnitYear;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "admin_username", nullable = false)
    @ToString.Exclude
    private Admin adminUsername;

    @Column(name = "company_unit_date", nullable = false)
    private Timestamp companyUnitDate;

    @OneToMany(mappedBy = "companyUnitIdx", cascade = CascadeType.ALL)
    @ToString.Exclude
    @JsonIgnore
    private List<CompanyContract> CompanyContracts;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CompanyUnit companyUnit = (CompanyUnit) o;
        return Objects.equals(companyUnitIdx, companyUnit.companyUnitIdx);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}