package ks46team01.admin.inventories.log.entity;

import jakarta.persistence.*;
import ks46team01.admin.info.entity.Admin;
import ks46team01.admin.inventories.inventory.entity.Inventory;
import ks46team01.common.company.info.entity.CompanyInfo;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "inventory_log")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class InventoryLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inventory_log_idx")
    private Long inventoryLogIdx;

    @ManyToOne
    @JoinColumn(name = "inventory_idx", nullable = false)
    @ToString.Exclude
    private Inventory inventoryIdx;

    @ManyToOne
    @JoinColumn(name = "company_info_idx", nullable = false)
    @ToString.Exclude
    private CompanyInfo companyInfoIdx;

    @Column(name = "amount", nullable = false)
    private Double amount;

    @Column(name = "transaction_type", nullable = false)
    private String transactionType;

    @Column(name = "transaction_date", nullable = false)
    private Timestamp transactionDate;

    @ManyToOne
    @JoinColumn(name = "admin_username", nullable = false)
    @ToString.Exclude
    private Admin adminUsername;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        InventoryLog inventoryLog = (InventoryLog) o;
        return inventoryLogIdx != null && Objects.equals(inventoryLogIdx, inventoryLog.inventoryLogIdx);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
