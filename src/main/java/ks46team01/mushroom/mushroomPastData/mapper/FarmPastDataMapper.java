package ks46team01.mushroom.mushroomPastData.mapper;


import ks46team01.mushroom.mushroomPastData.dto.FarmPastData;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FarmPastDataMapper {
    List<FarmPastData> getFarmPastData();


    int addFarmPastData(FarmPastData farmPastData);
}
