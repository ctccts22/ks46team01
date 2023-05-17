package ks46team01.user.farm.mapper;

import ks46team01.common.farm.dto.FarmData;
import ks46team01.common.farm.dto.FarmPickupDelivery;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface UserFarmMapper {
    public FarmData farmInfo(String userId);
    public void insertFarmPickup(HashMap<String,Object> map);
    public List<FarmData> listFarmPickup(String id);
    public List<FarmData> listFarmDelivery(String id);
    public void insertDelivery(FarmPickupDelivery fpd);
}
