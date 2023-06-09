package ks46team01.user.info.entity;

import java.sql.Timestamp;
import java.util.Objects;

import jakarta.persistence.*;

import ks46team01.auth.entity.Role;
import lombok.*;
import org.hibernate.Hibernate;

@Entity
@Table(name = "user")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @Column(name = "username", length = 30, nullable = false)
    private String username;

    @Column(name = "password", length = 100, nullable = false)
    private String password;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_idx", nullable = false)
    @ToString.Exclude
    private Role roleIdx;

    @Column(name = "name", length = 10, nullable = false)
    private String name;

    @Column(name = "birth", nullable = false)
    private java.sql.Date birth;

    @Column(name = "email", length = 30, nullable = false)
    private String email;

    @Column(name = "phone", length = 20, nullable = false)
    private String phone;

    @Column(name = "address", length = 200, nullable = false)
    private String address;

    @Column(name = "date", nullable = false, updatable = false)
    private Timestamp date;

    @Column(name = "modify_date")
    private Timestamp modifyDate;

    @Column(name = "is_del")
    private String isDel;

    @Column(name = "is_del_date")
    private Timestamp isDelDate;

    // 회원가입하면 is_del에 N을 디폴트 데이터로 입력
    @PrePersist
    public void setDefaultIsDel() {
        this.isDel = (this.isDel == null) ? "N" : this.isDel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        User user = (User) o;
        return Objects.equals(username, user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }

}
