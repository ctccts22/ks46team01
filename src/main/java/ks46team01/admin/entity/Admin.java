package ks46team01.admin.entity;

import jakarta.persistence.*;
import ks46team01.company.entity.Company;
import lombok.*;
import org.hibernate.Hibernate;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "admin")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Admin {

    @Id
    @Column(name = "admin_username", nullable = false, unique = true)
    private String adminUsername;

    @Column(name = "admin_password", nullable = false)
    private String adminPassword;

    @Column(name = "admin_name", nullable = false)
    private String adminName;

    @Column(name = "admin_login")
    private Timestamp adminLogin;

    @Column(name = "admin_logout")
    private Timestamp adminLogout;

    @OneToMany(mappedBy = "adminUsername", cascade = CascadeType.ALL)
    private List<Company> companies;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Admin admin = (Admin) o;
        return adminUsername != null && Objects.equals(adminUsername, admin.adminUsername);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}



