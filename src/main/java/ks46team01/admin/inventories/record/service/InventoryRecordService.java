package ks46team01.admin.inventories.record.service;

import ks46team01.admin.info.entity.Admin;
import ks46team01.admin.inventories.input.entity.InventoryInput;
import ks46team01.admin.inventories.input.repository.InventoryInputRepository;
import ks46team01.admin.inventories.output.entity.InventoryOutput;
import ks46team01.admin.inventories.output.repository.InventoryOutputRepository;
import ks46team01.admin.inventories.record.entity.InventoryRecord;
import ks46team01.admin.inventories.record.repository.InventoryRecordRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class InventoryRecordService {
    private final InventoryRecordRepository inventoryRecordRepository;
    private final InventoryInputRepository inventoryInputRepository;
    private final InventoryOutputRepository inventoryOutputRepository;

    public InventoryRecord getInventoryRecord(Long inventoryRecordId) {
        return inventoryRecordRepository.findById(inventoryRecordId).orElse(null);
    }

    public void addInventoryRecord(Long inventoryRecordIdx, Long inventoryId, double amount, boolean isExceptional, Admin admin) {
        InventoryRecord record = getInventoryRecord(inventoryRecordIdx);

        record.setFinalAmount(record.getFinalAmount() + amount);
        if (isExceptional) {
            record.setExceptionalAmount(record.getExceptionalAmount() + amount);
        }
        record.setLastUpdated(new Timestamp(System.currentTimeMillis()));
        inventoryRecordRepository.save(record);

        InventoryInput input = new InventoryInput();
        input.setInventoryRecordIdx(record);
        input.setInputAmount(amount);
        input.setInputDate(new Date(System.currentTimeMillis()));
        input.setIsExceptional(isExceptional);
        input.setAdminUsername(admin);
        inventoryInputRepository.save(input);
    }

    public void removeInventoryRecord(Long inventoryRecordIdx, Long inventoryId, double amount, Admin admin) {
        InventoryRecord record = getInventoryRecord(inventoryRecordIdx);

        record.setFinalAmount(record.getFinalAmount() - amount);
        record.setLastUpdated(new Timestamp(System.currentTimeMillis()));
        inventoryRecordRepository.save(record);

        InventoryOutput output = new InventoryOutput();
        output.setInventoryRecordIdx(record);
        output.setOutputAmount(amount);
        output.setOutputDate(new Date(System.currentTimeMillis()));
        output.setAdminUsername(admin);
        inventoryOutputRepository.save(output);
    }
}
