package ks46team01.mushroom.mushroomCondition.mapper;

import ks46team01.crop.dto.Crop;
import ks46team01.mushroom.mushroomCondition.dto.FarmCondition;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FarmConditionMapper{
    // 조회
   List<FarmCondition> getFarmCondition();
    // crop 목록을 조회
   List<Crop> getCropIdx();


    // 입력
    int saveFarmCondition(FarmCondition farmCondition);

    //특정회원조회
    FarmCondition getFarmConditionInfoById(Long mushroomConditionIdx
                                    ,Long cropIdx
                                    ,String mushroomConditionTemperature
                                    ,String mushroomConditionHumidity
                                    ,String mushroomConditionOxygen
                                    ,String mushroomConditionIlluminance
                                    ,String mushroomConditionCo2
                                    ,String mushroomConditionPh
                                    ,String mushroomConditionUse
                                    ,Integer mushroomConditionYear);
    // 수정
    void modifyFarmCondition(Long mushroomConditionIdx
                            ,Long cropIdx
                            ,String mushroomConditionTemperature
                            ,String mushroomConditionHumidity
                            ,String mushroomConditionOxygen
                            ,String mushroomConditionCo2
                            ,String mushroomConditionIlluminance
                            ,String mushroomConditionPh
                            ,String mushroomConditionUse
                            ,Integer mushroomConditionYear
                            );


    // 삭제
    FarmCondition getFarmConditionInfoByDeleteId(Long mushroomConditionIdx);

    void deleteFarmConditionByIdx(Long mushroomConditionIdx);


}
