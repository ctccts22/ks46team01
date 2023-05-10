package ks46team01.admin.inventories.output.repository;

import ks46team01.admin.inventories.output.entity.InventoryOutput;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryOutputRepository extends JpaRepository<InventoryOutput, Long> {
}