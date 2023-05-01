package ks46team01.mushroom.mushroomCondition.mapper;

import ks46team01.mushroom.mushroomCondition.dto.FarmCondition;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FarmConditionMapper{


   List<FarmCondition> getFarmCondition();



    FarmCondition saveFarmCondition(FarmCondition farmCondition);


}
