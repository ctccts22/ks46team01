package ks46team01.admin.company.unit.entity;

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
    @JoinColumn(name = "username", nullable = false)
    @ToString.Exclude
    private User username;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_idx", nullable = false)
    @ToString.Exclude
    private Company companyIdx;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inventory_idx", nullable = false)
    @ToString.Exclude
    private Inventory inventoryIdx;

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

    @Column(name = "company_unit_update")
    private Timestamp companyUnitUpdate;

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