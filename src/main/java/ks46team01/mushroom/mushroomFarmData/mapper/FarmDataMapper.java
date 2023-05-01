package ks46team01.mushroom.mushroomFarmData.mapper;

import ks46team01.mushroom.mushroomFarmData.dto.FarmData;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FarmDataMapper {

    String addFarmData(FarmData farmData);


    List<FarmData> findAllFarmData();
    List<FarmData> getSearchFarmData(String searchKey, String searchValue);

    FarmData saveFarmData(FarmData farmData);

}
