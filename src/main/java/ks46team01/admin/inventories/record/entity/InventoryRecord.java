package ks46team01.admin.inventories.record.entity;

import jakarta.persistence.*;
import ks46team01.admin.info.entity.Admin;
import ks46team01.admin.inventories.inventory.entity.Inventory;
import ks46team01.common.company.contract.entity.CompanyContract;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "inventory_record")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class InventoryRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inventory_record_idx")
    private Long inventoryRecordIdx;

    @ManyToOne
    @JoinColumn(name = "company_contract_idx", nullable = false)
    @ToString.Exclude
    private CompanyContract companyContractIdx;

    @ManyToOne
    @JoinColumn(name = "inventory_idx", nullable = false)
    @ToString.Exclude
    private Inventory inventoryIdx;

    @Column(name = "final_amount", nullable = false, columnDefinition = "DOUBLE DEFAULT 0")
    private Double finalAmount;

    @ManyToOne
    @JoinColumn(name = "admin_username", nullable = false)
    @ToString.Exclude
    private Admin adminUsername;

    @Column(name = "last_updated", nullable = false, columnDefinition= "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @UpdateTimestamp
    private Timestamp lastUpdated;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        InventoryRecord inventoryRecord = (InventoryRecord) o;
        return inventoryRecordIdx != null && Objects.equals(inventoryRecordIdx, inventoryRecord.inventoryRecordIdx);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}