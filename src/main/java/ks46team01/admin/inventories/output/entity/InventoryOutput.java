package ks46team01.admin.inventories.output.entity;

import jakarta.persistence.*;
import java.sql.Date;
import java.util.Objects;

import ks46team01.admin.info.entity.Admin;
import ks46team01.admin.inventories.record.entity.InventoryRecord;
import lombok.*;
import org.hibernate.Hibernate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "inventory_output")
public class InventoryOutput {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "output_idx")
    private Long outputIdx;

    @ManyToOne
    @JoinColumn(name = "inventory_record_idx", nullable = false)
    @ToString.Exclude
    private InventoryRecord inventoryRecordIdx;

    @Column(name = "output_amount", nullable = false)
    private Double outputAmount;

    @Column(name = "output_date", nullable = false)
    private Date outputDate;

    @ManyToOne
    @JoinColumn(name = "admin_username", nullable = false)
    @ToString.Exclude
    private Admin adminUsername;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        InventoryOutput inventoryOutput = (InventoryOutput) o;
        return outputIdx != null && Objects.equals(outputIdx, inventoryOutput.outputIdx);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

