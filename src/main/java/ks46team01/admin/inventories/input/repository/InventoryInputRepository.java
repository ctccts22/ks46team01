package ks46team01.admin.inventories.input.repository;

import ks46team01.admin.inventories.input.entity.InventoryInput;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryInputRepository extends JpaRepository<InventoryInput, Long> {
}