package ks46team01.auth.entity;

import jakarta.persistence.*;
import ks46team01.admin.entity.Admin;
import ks46team01.user.entity.User;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "role")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long roleId;

    @Enumerated(EnumType.STRING)
    @Column(name = "role_name", nullable = false, unique = true)
    private RoleName roleName;

    @OneToMany(mappedBy = "roleId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<User> users = new HashSet<>();

    @OneToMany(mappedBy = "roleId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Admin> admins = new HashSet<>();

    @Override
    public String toString() {
        return roleName.toString();
    }

    public enum RoleName {
        USER,
        ADMIN
    }
}
