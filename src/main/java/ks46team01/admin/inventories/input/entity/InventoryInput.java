package ks46team01.admin.inventories.input.entity;

import jakarta.persistence.*;
import ks46team01.admin.info.entity.Admin;
import ks46team01.admin.inventories.record.entity.InventoryRecord;
import lombok.*;
import org.hibernate.Hibernate;

import java.sql.Date;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "inventory_input")
public class InventoryInput {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "input_idx")
    private Long inputIdx;

    @ManyToOne
    @JoinColumn(name = "inventory_record_idx", nullable = false)
    @ToString.Exclude
    private InventoryRecord inventoryRecordIdx;

    @Column(name = "input_amount", nullable = false)
    private Double inputAmount;

    @Column(name = "input_date", nullable = false)
    private Date inputDate;

    @Column(name = "is_exceptional", nullable = false, columnDefinition = "BOOLEAN DEFAULT FALSE")
    private Boolean isExceptional;

    @ManyToOne
    @JoinColumn(name = "admin_username", nullable = false)
    @ToString.Exclude
    private Admin adminUsername;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        InventoryInput inventoryInput = (InventoryInput) o;
        return inputIdx != null && Objects.equals(inputIdx, inventoryInput.inputIdx);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
