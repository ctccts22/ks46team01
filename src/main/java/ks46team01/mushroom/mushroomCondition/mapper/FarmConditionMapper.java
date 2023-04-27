package ks46team01.mushroom.mushroomCondition.mapper;

import ks46team01.mushroom.mushroomCondition.dto.Crop;
import ks46team01.mushroom.mushroomCondition.dto.FarmCondition;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface FarmConditionMapper{


   List<FarmCondition> getFarmCondition();
    String addFarmCondition(FarmCondition farmCondition);

    List<Crop> getCrop(Crop crop);


}
