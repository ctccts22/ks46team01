package ks46team01.admin.inventory.service;

import ks46team01.admin.info.entity.Admin;
import ks46team01.admin.info.repository.AdminRepository;
import ks46team01.admin.inventory.dto.InventoryDTO;
import ks46team01.admin.inventory.entity.Inventory;
import ks46team01.admin.inventory.repository.InventoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Service
@Transactional
@AllArgsConstructor
public class InventoryService {
    private final InventoryRepository inventoryRepository;
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
