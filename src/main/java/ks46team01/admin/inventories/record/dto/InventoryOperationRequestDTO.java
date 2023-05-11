package ks46team01.admin.inventories.record.dto;

import lombok.Data;

@Data
public class InventoryOperationRequestDTO {
    private Long inventoryIdx;
    private double amount;
    private boolean isExceptional;
}
