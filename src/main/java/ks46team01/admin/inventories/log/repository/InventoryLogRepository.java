package ks46team01.admin.inventories.log.repository;

import ks46team01.admin.inventories.inventory.entity.Inventory;
import ks46team01.admin.inventories.log.entity.InventoryLog;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryLogRepository extends JpaRepository<InventoryLog, Long> {

}
