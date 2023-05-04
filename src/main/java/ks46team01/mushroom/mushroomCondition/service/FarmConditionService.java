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

    //조회
    public List<FarmCondition> getFarmCondition(){
        List<FarmCondition> farmCondition = farmConditionMapper.getFarmCondition();
        return farmCondition;
    }
    public List<Crop> getCropIdx(){
        List<Crop> cropList = farmConditionMapper.getCropIdx();
        return cropList;
    }

    //입력
    public int addFarmCondition(FarmCondition farmCondition) {
        return farmConditionMapper.saveFarmCondition(farmCondition);
    }

    //수정
    public FarmCondition getFarmConditionInfoById(Long mushroomConditionIdx
                                                , Long cropIdx
                                                , String mushroomConditionTemperature
                                                , String mushroomConditionHumidity
                                                , String mushroomConditionOxygen
                                                , String mushroomConditionIlluminance
                                                , String mushroomConditionCo2
                                                , String mushroomConditionPh
                                                , String mushroomConditionUse
                                                , int mushroomConditionYear){
        FarmCondition farmConditionInfo = farmConditionMapper.getFarmConditionInfoById(mushroomConditionIdx
                                            ,cropIdx
                                            ,mushroomConditionTemperature
                                            ,mushroomConditionHumidity
                                            ,mushroomConditionOxygen
                                            ,mushroomConditionIlluminance
                                            ,mushroomConditionCo2
                                            ,mushroomConditionPh
                                            ,mushroomConditionUse
                                            ,mushroomConditionYear);
        return farmConditionInfo;
    }

    public void modifyFarmCondition(Long mushroomConditionIdx
                                    ,Long cropIdx
                                    ,String mushroomConditionTemperature
                                    ,String mushroomConditionHumidity
                                    ,String mushroomConditionOxygen
                                    ,String mushroomConditionIlluminance
                                    ,String mushroomConditionCo2
                                    ,String mushroomConditionPh
                                    ,String mushroomConditionUse
                                    ,int mushroomConditionYear){
        farmConditionMapper.modifyFarmCondition(mushroomConditionIdx
                                                ,cropIdx
                                                ,mushroomConditionTemperature
                                                ,mushroomConditionHumidity
                                                ,mushroomConditionOxygen
                                                ,mushroomConditionIlluminance
                                                ,mushroomConditionCo2
                                                ,mushroomConditionPh
                                                ,mushroomConditionUse
                                                ,mushroomConditionYear);
                                    }

    //삭제

    public FarmCondition getFarmConditionInfoByDeleteId(Long mushroomConditionIdx){
        FarmCondition farmConditionInfoDelete = farmConditionMapper.getFarmConditionInfoByDeleteId(mushroomConditionIdx);
        return farmConditionInfoDelete;
    }

    public void deleteFarmCondition(Long mushroomConditionIdx){
        farmConditionMapper.deleteFarmConditionByIdx(mushroomConditionIdx);
    }



}












