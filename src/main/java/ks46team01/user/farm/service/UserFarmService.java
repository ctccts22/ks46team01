package ks46team01.user.farm.service;

import ks46team01.common.farm.dto.FarmData;
import ks46team01.common.farm.dto.FarmPickupDelivery;

import java.util.HashMap;
import java.util.List;

public interface UserFarmService {
    public FarmData farmInfo(String userId);
    public void farmPickupInsert(HashMap<String,Object> map);
    public List<FarmData> listFarmPickup(String id);
    public List<FarmData> listFarmDelivery(String id);
    public void insertDelivery(FarmPickupDelivery fpd);
}
