package ks46team01.mushroom.mushroomFarmData.mapper;

import ks46team01.mushroom.mushroomCondition.dto.Crop;
import ks46team01.mushroom.mushroomFarmData.dto.FarmData;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FarmDataMapper {

    List<FarmData> getSearchFarmData(String searchKey, String searchValue);

    String addFarmData(FarmData farmData);



    FarmData saveFarmData(FarmData farmData);




}
