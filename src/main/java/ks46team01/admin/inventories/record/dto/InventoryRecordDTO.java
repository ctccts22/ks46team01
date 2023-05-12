package ks46team01.admin.inventories.record.dto;

import ks46team01.admin.info.entity.Admin;
import ks46team01.admin.inventories.record.entity.InventoryRecord;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.sql.Timestamp;

@Data
public class InventoryRecordDTO {
    private Long inventoryRecordIdx;
    private Long companyContractIdx;
    private Long inventoryIdx;
    private Double initialAmount;
    private Double finalAmount;
    private Double lossAmount;
    private Double exceptionalAmount;
    private String adminUsername;
    private Timestamp lastUpdated;

    public InventoryRecord toEntity() {
        InventoryRecord inventoryRecord = new InventoryRecord();
        BeanUtils.copyProperties(this, inventoryRecord);

        Admin admin = new Admin();
        admin.setAdminUsername(this.adminUsername);
        inventoryRecord.setAdminUsername(admin);

        return inventoryRecord;
    }

    public static InventoryRecordDTO fromEntity(InventoryRecord inventoryRecord) {
        InventoryRecordDTO inventoryRecordDTO = new InventoryRecordDTO();
        BeanUtils.copyProperties(inventoryRecord, inventoryRecordDTO);
        inventoryRecordDTO.setAdminUsername(inventoryRecord.getAdminUsername().getAdminUsername());
        return inventoryRecordDTO;
    }
}
