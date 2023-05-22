package ks46team01.admin.inventories.log.service;

import ks46team01.admin.info.entity.Admin;
import ks46team01.admin.inventories.inventory.entity.Inventory;
import ks46team01.admin.inventories.inventory.repository.InventoryRepository;
import ks46team01.admin.inventories.log.dto.InventoryLogDTO;
import ks46team01.admin.inventories.log.entity.InventoryLog;
import ks46team01.admin.inventories.log.repository.InventoryLogRepository;
import ks46team01.common.company.info.entity.CompanyInfo;
import ks46team01.common.company.info.repository.CompanyInfoRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
@Slf4j
@AllArgsConstructor
public class InventoryLogService {
    private final CompanyInfoRepository companyInfoRepository;
    private final InventoryRepository inventoryRepository;
    private final InventoryLogRepository inventoryLogRepository;

    public void addInventoryLogAndInventory(InventoryLogDTO inventoryLogDTO, Admin admin) {

        String inventoryType = inventoryLogDTO.getInventoryType();
        Inventory inventory = inventoryRepository.findByInventoryType(inventoryType);
        if (inventory == null) {
            throw new RuntimeException("Inventory type not found: " + inventoryType);
        }

        CompanyInfo companyInfo = companyInfoRepository.findByCompanyInfoName(inventoryLogDTO.getCompanyInfoName());
        if (companyInfo == null || !Objects.equals(companyInfo.getCompanyInfoName(), inventoryLogDTO.getCompanyInfoName())) {
            throw new RuntimeException("companyInfoName not found");
        }

        InventoryLog inventoryLog = new InventoryLog();

        inventoryLog.setInventoryLogIdx(inventoryLogDTO.getInventoryLogIdx());
        inventoryLog.setInventoryIdx(inventory); // Link the inventory to the log
        inventoryLog.setCompanyInfoIdx(companyInfo);
        inventoryLog.setAmount(inventoryLogDTO.getAmount());
        inventoryLog.setTransactionType(inventoryLogDTO.getTransactionType());
        inventoryLog.setTransactionDate(Timestamp.valueOf(LocalDateTime.now()));
        inventoryLog.setAdminUsername(admin);

        // Modify the inventory sum based on the transaction type
        if ("I".equals(inventoryLogDTO.getTransactionType())) {
            inventory.setInventorySum(inventory.getInventorySum() + inventoryLogDTO.getAmount());
        } else if ("O".equals(inventoryLogDTO.getTransactionType())) {
            inventory.setInventorySum(inventory.getInventorySum() - inventoryLogDTO.getAmount());
        }

        // Save both the inventory and the inventory log
        inventoryRepository.save(inventory);
        inventoryLogRepository.save(inventoryLog);
    }
}


