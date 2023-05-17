package ks46team01.admin.farm.mapper;

import ks46team01.common.farm.dto.FarmPickupConfirm;
import ks46team01.common.farm.dto.FarmPickupDelivery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminFarmMapper {
    public List<FarmPickupConfirm> farmPickupConfirmList();
    public void farmPickupConfirmInsert(FarmPickupConfirm farmPickupConfirm);
    public List<FarmPickupDelivery> farmPickupConfirmStatusList();
    public List<FarmPickupDelivery> farmPickupDeliveryList();
    public void updateDelivery(Long farmPickupRequestIdx);
}
