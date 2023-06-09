package ks46team01.admin.inventories.inventory.entity;


import jakarta.persistence.*;
import ks46team01.admin.info.entity.Admin;
import lombok.*;
import org.hibernate.Hibernate;

import java.sql.Timestamp;
import java.util.Objects;


@Entity
@Table(name = "inventory")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inventory_idx")
    private Long inventoryIdx;

    @Column(name = "inventory_type", length = 20, nullable = false)
    private String inventoryType;

    @Column(name = "inventory_sum", nullable = false, columnDefinition = "double default '0'")
    private Double inventorySum;

    @ManyToOne
    @JoinColumn(name = "admin_username", nullable = false)
    @ToString.Exclude
    private Admin adminUsername;

    @Column(name = "inventory_date", nullable = false)
    private Timestamp inventoryDate;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Inventory inventory = (Inventory) o;
        return inventoryIdx != null && Objects.equals(inventoryIdx, inventory.inventoryIdx);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }


}
