package ks46team01.admin.inventories.inventory.dto;

import ks46team01.admin.info.entity.Admin;
import ks46team01.admin.inventories.inventory.entity.Inventory;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.sql.Timestamp;

@Data
@RequiredArgsConstructor
public class InventoryDTO {
    private Long inventoryIdx;
    private String inventoryType;
    private Double inventorySum;
    private String adminUsername;
    private Timestamp inventoryDate;

    public Inventory toEntity() {
        Inventory inventory = new Inventory();
        BeanUtils.copyProperties(this, inventory);

        Admin admin = new Admin();
        admin.setAdminUsername(this.adminUsername);
        inventory.setAdminUsername(admin);

        return inventory;
    }

    public static InventoryDTO fromEntity(Inventory inventory) {
        InventoryDTO inventoryDTO = new InventoryDTO();
        BeanUtils.copyProperties(inventory, inventoryDTO);
        inventoryDTO.setAdminUsername(inventory.getAdminUsername().getAdminUsername());
        return inventoryDTO;
    }
}
