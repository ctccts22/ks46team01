package ks46team01.admin.company.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import ks46team01.admin.company.contract.entity.CompanyContract;
import ks46team01.admin.company.unit.entity.CompanyUnit;
import ks46team01.admin.info.entity.Admin;
import lombok.*;
import org.hibernate.Hibernate;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "company")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_idx", nullable = false)
    private Long companyIdx;

    @Column(name = "company_type", nullable = false)
    private String companyType;

    @ManyToOne
    @JoinColumn(name = "admin_username", nullable = false)
    @JsonIgnore
    private Admin adminUsername;

    @Column(name = "company_date", nullable = false)
    private Timestamp companyDate;

    @OneToMany(mappedBy = "companyUnitIdx", cascade = CascadeType.ALL)
    @ToString.Exclude
    @JsonIgnore
    private List<CompanyUnit> companyUnits;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Company company = (Company) o;
        return getCompanyIdx() != null && Objects.equals(getCompanyIdx(), company.getCompanyIdx());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
