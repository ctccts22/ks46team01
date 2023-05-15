package ks46team01.admin.inventories.log.service;

import ks46team01.admin.inventories.inventory.repository.InventoryRepository;
import ks46team01.admin.inventories.log.dto.InventoryLogDTO;
import ks46team01.admin.inventories.log.mapper.InventoryLogMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
@AllArgsConstructor
public class InventoryLogService {

    private final InventoryLogMapper inventoryLogMapper;

    public void updateInventoryLogAndInventory(InventoryLogDTO inventoryLogDTO) {

        inventoryLogMapper.insertInventoryLog(inventoryLogDTO);

        if ("I".equals(inventoryLogDTO.getTransactionType())) {
            inventoryLogMapper.addInventorySum(inventoryLogDTO.getInventoryIdx(), inventoryLogDTO.getAmount());
        } else if ("O".equals(inventoryLogDTO.getTransactionType())) {
            inventoryLogMapper.subtractInventorySum(inventoryLogDTO.getInventoryIdx(), inventoryLogDTO.getAmount());
        }
    }

}
