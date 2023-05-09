package ks46team01.admin.inventories.input.dto;

import ks46team01.admin.info.entity.Admin;
import ks46team01.admin.inventories.input.entity.InventoryInput;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.sql.Date;

@Data
public class InventoryInputDTO {
    private Long inputIdx;
    private Long inventoryRecordIdx;
    private Double inputAmount;
    private Date inputDate;
    private Boolean isExceptional;
    private String adminUsername;

    public InventoryInput toEntity() {
        InventoryInput inventoryInput = new InventoryInput();
        BeanUtils.copyProperties(this, inventoryInput);

        Admin admin = new Admin();
        admin.setAdminUsername(this.adminUsername);
        inventoryInput.setAdminUsername(admin);

        return inventoryInput;
    }

    public static InventoryInputDTO fromEntity(InventoryInput inventoryInput) {
        InventoryInputDTO inventoryInputDTO = new InventoryInputDTO();
        BeanUtils.copyProperties(inventoryInput, inventoryInputDTO);
        inventoryInputDTO.setAdminUsername(inventoryInput.getAdminUsername().getAdminUsername());
        return inventoryInputDTO;
    }
}
