package ks46team01.mushroom.mushroomGrowth.service;

import ks46team01.mushroom.mushroomGrowth.dto.FarmMushroomGrowth;
import ks46team01.mushroom.mushroomGrowth.mapper.FarmMushroomGrowthMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FarmMushroomGrowthService {
    private final FarmMushroomGrowthMapper farmMushroomGrowthMapper;
    public FarmMushroomGrowthService(FarmMushroomGrowthMapper farmMushroomGrowthMapper) {
        this.farmMushroomGrowthMapper = farmMushroomGrowthMapper;
    }



    public List<FarmMushroomGrowth> getFarmMushroomGrowth(String searchKey, String searchValue) {
        if(searchKey != null){
            switch (searchKey) {
                case "mushroomGrowthIdx":
                    searchKey = "mushroom_growth_idx";
                    break;
                case "farmDataIdx":
                    searchKey = "farm_data_idx";
                    break;
                default:
                    searchKey = "crop_idx";
                    break;
            }
        }
        List<FarmMushroomGrowth> farmMushroomGrowth = farmMushroomGrowthMapper.getMushroomGrowthInfoById(searchKey, searchValue);
        return farmMushroomGrowth;
    }


        public int add(FarmMushroomGrowth farmMushroomGrowth){
            int result =
                    farmMushroomGrowthMapper.addFarmMushroomGrowth(farmMushroomGrowth);
            return result;

        }


}

