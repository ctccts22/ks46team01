package ks46team01.admin.inventories.log.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class InventoryLogDTO {
    private Long inventoryLogIdx;
    private Long inventoryIdx;
    private String inventoryType;
    private Long companyInfoIdx;
    private String companyInfoName;
    private String companyInfoLicenseNumber;
    private Double amount;
    private String transactionType;
    private Timestamp transactionDate;
    private String adminUsername;

}
