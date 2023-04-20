package ks46team01.common.company.info.entity;

import jakarta.persistence.*;
import ks46team01.user.info.entity.User;
import lombok.*;

@Entity
@Table(name = "company_info")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CompanyInfo {

    @Id
    @Column(name = "company_info_idx", nullable = false)
    private Long companyInfoIdx;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "username", nullable = false)
    @ToString.Exclude
    private User username;


}
