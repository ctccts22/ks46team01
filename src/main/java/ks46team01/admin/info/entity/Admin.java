package ks46team01.admin.info.entity;

import jakarta.persistence.*;
import ks46team01.admin.inventory.entity.Inventory;
import ks46team01.auth.entity.Role;
import ks46team01.admin.company.entity.Company;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_idx", nullable = false)
    @ToString.Exclude
    private Role roleIdx;

    @Column(name = "admin_name", nullable = false)
    private String adminName;

    @Column(name = "admin_login")
    private Timestamp adminLogin;

    @Column(name = "admin_logout")
    private Timestamp adminLogout;

    @OneToMany(mappedBy = "adminUsername", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Company> companies;

    @OneToMany(mappedBy = "adminUsername", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Inventory> inventories;

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



