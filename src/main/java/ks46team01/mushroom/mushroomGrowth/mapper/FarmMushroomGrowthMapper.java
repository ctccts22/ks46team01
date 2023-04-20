package ks46team01.mushroom.mushroomGrowth.mapper;


import ks46team01.mushroom.mushroomGrowth.dto.FarmMushroomGrowth;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FarmMushroomGrowthMapper {

    List<FarmMushroomGrowth> getFarmMushroomGrowth();
    List<FarmMushroomGrowth> getMushroomGrowthInfoById(String searchKey, String searchValue);


}
