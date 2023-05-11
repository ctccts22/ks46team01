package ks46team01.admin.farm.service;

import ks46team01.common.farm.dto.FarmPickupConfirm;
import ks46team01.common.farm.dto.FarmPickupDelivery;

import java.util.List;

public interface FarmService {
    public List<FarmPickupConfirm> farmPickupConfirmList();
    public void farmPickupConfirmInsert(FarmPickupConfirm farmPickupConfirm);
    public List<FarmPickupConfirm> farmPickupConfirmStatusList();
    public List<FarmPickupDelivery> farmPickupDeliveryList();
}
