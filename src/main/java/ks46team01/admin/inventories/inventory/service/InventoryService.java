package ks46team01.admin.inventories.inventory.service;

import ks46team01.admin.info.entity.Admin;
import ks46team01.admin.info.repository.AdminRepository;
import ks46team01.admin.inventories.input.entity.InventoryInput;
import ks46team01.admin.inventories.input.repository.InventoryInputRepository;
import ks46team01.admin.inventories.inventory.dto.InventoryDTO;
import ks46team01.admin.inventories.inventory.entity.Inventory;
import ks46team01.admin.inventories.inventory.repository.InventoryRepository;
import ks46team01.admin.inventories.output.entity.InventoryOutput;
import ks46team01.admin.inventories.output.repository.InventoryOutputRepository;
import ks46team01.admin.inventories.record.entity.InventoryRecord;
import ks46team01.admin.inventories.record.repository.InventoryRecordRepository;
import ks46team01.common.company.contract.entity.CompanyContract;
import ks46team01.common.company.contract.entity.CompanyContractApprove;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class InventoryService {
    private final InventoryRepository inventoryRepository;
    private final InventoryInputRepository inventoryInputRepository;
    private final InventoryOutputRepository inventoryOutputRepository;
    private final InventoryRecordRepository inventoryRecordRepository;
    private final AdminRepository adminRepository;

    public InventoryDTO addCompanyContract(Long inventoryIdx, String inventoryType, LocalDateTime inventoryDate, Admin admin) {
        if (adminRepository.existsById(admin.getAdminUsername())) {
            InventoryDTO inventoryDTO = new InventoryDTO();
            inventoryDTO.setInventoryIdx(inventoryIdx);
            inventoryDTO.setInventoryType(inventoryType);
            inventoryDTO.setAdminUsername(admin.getAdminUsername());
            inventoryDTO.setInventoryDate(Timestamp.valueOf(inventoryDate));

            Inventory inventory = inventoryDTO.toEntity();
            Inventory savedInventory = inventoryRepository.save(inventory);

            return InventoryDTO.fromEntity(savedInventory);
        } else {
            return null;
        }
    }
    public boolean deleteInventory(Long inventoryIdx, Admin admin) {
        if (adminRepository.existsById(admin.getAdminUsername())) {
            try {
                inventoryRepository.deleteById(inventoryIdx);
                return true;
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

}
