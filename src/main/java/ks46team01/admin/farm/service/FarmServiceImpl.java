package ks46team01.admin.farm.service;

import ks46team01.admin.farm.mapper.AdminFarmMapper;
import ks46team01.common.farm.dto.FarmPickupConfirm;
import ks46team01.common.farm.dto.FarmPickupDelivery;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FarmServiceImpl implements FarmService{
    private final AdminFarmMapper adminFarmMapper;

    public FarmServiceImpl(AdminFarmMapper adminFarmMapper) {
        this.adminFarmMapper = adminFarmMapper;
    }

    @Override
    public List<FarmPickupConfirm> farmPickupConfirmList() {
        List<FarmPickupConfirm> farmPickupConfirm = adminFarmMapper.farmPickupConfirmList();
        return farmPickupConfirm;
    }

    @Override
    public void farmPickupConfirmInsert(FarmPickupConfirm farmPickupConfirm) {
        adminFarmMapper.farmPickupConfirmInsert(farmPickupConfirm);
    }

    @Override
    public List<FarmPickupConfirm> farmPickupConfirmStatusList() {
        List<FarmPickupConfirm> farmPickupConfirmStatusList = adminFarmMapper.farmPickupConfirmStatusList();
        return farmPickupConfirmStatusList;
    }

    @Override
    public List<FarmPickupDelivery> farmPickupDeliveryList() {
        List<FarmPickupDelivery> farmPickupDeliveryList = adminFarmMapper.farmPickupDeliveryList();
        return farmPickupDeliveryList;
    }

}
