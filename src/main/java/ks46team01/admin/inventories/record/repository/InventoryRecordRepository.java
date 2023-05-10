package ks46team01.admin.inventories.record.repository;

import ks46team01.admin.inventories.inventory.entity.Inventory;
import ks46team01.admin.inventories.record.entity.InventoryRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRecordRepository extends JpaRepository<InventoryRecord, Long> {

    InventoryRecord findByInventoryIdx(Inventory inventoryIdx);
}