package ks46team01.common.compost.dto;

import lombok.Data;

@Data
public class Inventory {
    private Long InventoryIdx;
    private String inventoryType;
    private Long inventoryAmount;
    private String adminUsername;
    private String inventoryDate;
    private String inventoryUpdate;
}
