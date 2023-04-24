package ks46team01.mushroom.mushroomFarmData.service;

import ks46team01.mushroom.mushroomCondition.dto.FarmCondition;
import ks46team01.mushroom.mushroomFarmData.dto.FarmData;
import ks46team01.mushroom.mushroomFarmData.mapper.FarmDataMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FarmDataService {
    private final FarmDataMapper farmDataMapper;

    public FarmDataService(FarmDataMapper farmDataMapper){
        this.farmDataMapper = farmDataMapper;
    }
    public List<FarmData> getFarmData(){
        List<FarmData> farmData = farmDataMapper.getFarmData();
        return farmData;
    }
    public int add(FarmData farmData) {
        int result =
                farmDataMapper.addFarmData(farmData);
        return result;
    }



}
