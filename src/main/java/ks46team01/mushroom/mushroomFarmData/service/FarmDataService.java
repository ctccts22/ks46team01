package ks46team01.mushroom.mushroomFarmData.service;

import ks46team01.mushroom.mushroomCondition.dto.FarmCondition;
import ks46team01.mushroom.mushroomFarmData.dto.FarmData;
import ks46team01.mushroom.mushroomFarmData.mapper.FarmDataMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FarmDataService {
    private final FarmDataMapper farmDataMapper;
    public FarmDataService(FarmDataMapper farmDataMapper){
        this.farmDataMapper = farmDataMapper;
    }

    public List<FarmData> getFarmDataList(String searchKey, String searchValue) {
        if(searchKey != null) {
            switch (searchKey) {
                case "farm_data_idx":
                    searchKey = "farm_data_idx";
                    break;
                case "username":
                    searchKey = "username";
                    break;
                default:
                    searchKey = "company_info_idx";
                    break;
            }
        }
        List<FarmData> getFarmDataList = farmDataMapper.getSearchFarmData(searchKey, searchValue);
        return  getFarmDataList;
    }

    public String add(FarmData farmData) {
        String result =
                farmDataMapper.addFarmData(farmData);
        return result;
    }



}
