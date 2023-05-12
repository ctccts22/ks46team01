package ks46team01.user.farm.service;

import ks46team01.common.farm.dto.FarmData;
import ks46team01.user.farm.mapper.UserFarmMapper;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class UserFarmServiceImpl implements UserFarmService{
    private final UserFarmMapper userFarmMapper;

    public UserFarmServiceImpl(UserFarmMapper userFarmMapper) {
        this.userFarmMapper = userFarmMapper;
    }

    @Override
    public FarmData farmInfo(String userId) {
        FarmData farmData = userFarmMapper.farmInfo(userId);
        return farmData;
    }

    @Override
    public void farmPickupInsert(HashMap<String, Object> map) {
        userFarmMapper.insertFarmPickup(map);
    }

    @Override
    public List<FarmData> listFarmPickup(String id) {
        List<FarmData> farmPickupList = userFarmMapper.listFarmPickup(id);
        return farmPickupList;
    }

    @Override
    public List<FarmData> listFarmDelivery(String id) {
        List<FarmData> farmPickupList = userFarmMapper.listFarmDelivery(id);
        return farmPickupList;
    }
}
