package ks46team01.admin.company.entity;

import jakarta.persistence.*;
import ks46team01.admin.info.entity.Admin;
import lombok.*;
import org.hibernate.Hibernate;

import java.sql.Timestamp;
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
    private Admin adminUsername;

    @Column(name = "company_date", nullable = false)
    private Timestamp companyDate;


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
