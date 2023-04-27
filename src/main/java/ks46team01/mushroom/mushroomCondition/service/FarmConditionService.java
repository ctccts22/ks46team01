package ks46team01.mushroom.mushroomCondition.service;

import ks46team01.mushroom.mushroomCondition.dto.Crop;
import ks46team01.mushroom.mushroomCondition.dto.FarmCondition;
import ks46team01.mushroom.mushroomCondition.mapper.FarmConditionMapper;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FarmConditionService {
    private final FarmConditionMapper farmConditionMapper;

    public FarmConditionService(FarmConditionMapper farmConditionMapper){
        this.farmConditionMapper = farmConditionMapper;
    }

    public List<FarmCondition> getFarmCondition(){
        List<FarmCondition> farmCondition = farmConditionMapper.getFarmCondition();
        return farmCondition;
    }

    public String add(FarmCondition farmCondition) {
         String result =
                farmConditionMapper.addFarmCondition(farmCondition);
        return result;
    }
    public List<Crop> getCropIdx(Crop crop){
        List<Crop> cropIdx = farmConditionMapper.getCrop(crop);
        return cropIdx;
    }



}
