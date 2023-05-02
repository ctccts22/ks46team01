package ks46team01.mushroom.mushroomCondition.mapper;


import ks46team01.mushroom.mushroomCondition.dto.Crop;
import ks46team01.mushroom.mushroomCondition.dto.FarmCondition;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface FarmConditionMapper{


    Optional<FarmCondition> findByConditionIdx(@Param("mushroomConditionIdx") String mushroomConditionIdx);
   List<FarmCondition> getFarmCondition();
    FarmCondition saveFarmCondition(FarmCondition farmCondition);
    // farm-condition 목록 조회

    List<Crop> getCropIdx();
    // crop 목록을 조회



/*
    Admin save(FarmCondition existingFarmCondition);


    Optional<FarmCondition> findByAdminUsername(String mushroomConditionIdx);*/
}
