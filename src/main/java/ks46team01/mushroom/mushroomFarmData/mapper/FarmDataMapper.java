package ks46team01.mushroom.mushroomFarmData.mapper;

import ks46team01.mushroom.mushroomCondition.dto.FarmCondition;
import ks46team01.mushroom.mushroomFarmData.dto.FarmData;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FarmDataMapper {
    List<FarmData> getFarmData();

    int addFarmData(FarmData farmData);
}
