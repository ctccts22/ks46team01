package ks46team01.admin.inventories.output.dto;

import ks46team01.admin.info.entity.Admin;
import ks46team01.admin.inventories.output.entity.InventoryOutput;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.sql.Date;

@Data
public class InventoryOutputDTO {
    private Long outputIdx;
    private Long inventoryRecordIdx;
    private Double outputAmount;
    private Date outputDate;
    private String adminUsername;

    public InventoryOutput toEntity() {
        InventoryOutput inventoryOutput = new InventoryOutput();
        BeanUtils.copyProperties(this, inventoryOutput);

        Admin admin = new Admin();
        admin.setAdminUsername(this.adminUsername);
        inventoryOutput.setAdminUsername(admin);

        return inventoryOutput;
    }

    public static InventoryOutputDTO fromEntity(InventoryOutput inventoryOutput) {
        InventoryOutputDTO inventoryOutputDTO = new InventoryOutputDTO();
        BeanUtils.copyProperties(inventoryOutput, inventoryOutputDTO);
        inventoryOutputDTO.setAdminUsername(inventoryOutput.getAdminUsername().getAdminUsername());
        return inventoryOutputDTO;
    }
}
