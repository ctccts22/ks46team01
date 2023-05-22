package ks46team01.admin.inventories.inventory.repository;

import ks46team01.admin.inventories.inventory.entity.Inventory;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    List<Inventory> findAll();

    @Query("SELECT i FROM Inventory i WHERE i.inventoryType = :inventoryType")
    Inventory findByInventoryType(@Param("inventoryType") String inventoryType);

}
