package ks46team01.admin.inventories.log.mapper;

import ks46team01.admin.inventories.log.dto.InventoryLogDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface InventoryLogMapper {

    public List<InventoryLogDTO> listInventoryLog(); // 인벤토리 로그 조회

    @Insert("INSERT INTO inventory_log (inventory_idx, company_info_idx, amount, transaction_type, admin_username) VALUES (#{inventoryIdx}, #{companyInfoIdx}, #{amount}, #{transactionType}, #{adminUsername})")
    void insertInventoryLog(InventoryLogDTO inventoryLogDTO);

    @Update("UPDATE inventory SET inventory_sum = inventory_sum + #{amount} WHERE inventory_idx = #{inventoryIdx}")
    void addInventorySum(@Param("inventoryIdx") Long inventoryIdx, @Param("amount") Double amount);

    @Update("UPDATE inventory SET inventory_sum = inventory_sum - #{amount} WHERE inventory_idx = #{inventoryIdx}")
    void subtractInventorySum(@Param("inventoryIdx") Long inventoryIdx, @Param("amount") Double amount);
}
