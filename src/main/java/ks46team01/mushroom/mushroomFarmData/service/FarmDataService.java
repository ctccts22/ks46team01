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
    public String add(FarmData farmData) {
        String result =
                farmDataMapper.addFarmData(farmData);
        return result;
    }
    public List<FarmData> getFarmDataList() {
        return farmDataMapper.findAllFarmData();
    }

}
