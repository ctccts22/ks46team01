package ks46team01.mushroom.mushroomGrowth.mapper;


import ks46team01.mushroom.mushroomGrowth.dto.FarmMushroomGrowth;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FarmMushroomGrowthMapper {

    public  List<FarmMushroomGrowth> getFarmMushroomGrowth(String searchKey, String searchValue);

    int addFarmMushroomGrowth(FarmMushroomGrowth farmMushroomGrowth);



}
