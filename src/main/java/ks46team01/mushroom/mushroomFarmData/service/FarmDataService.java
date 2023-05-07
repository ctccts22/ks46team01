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

    //조회 서치
    public List<FarmData> getFarmDataList(String searchKey, String searchValue) {
        if(searchKey != null) {
            switch (searchKey) {
                case "farm_data_idx":
                    searchKey = "m.farm_data_idx";
                    break;
                case "adminName":
                    searchKey = "a.admin_name";
                    break;
                default:
                    searchKey = "c.company_info_license_number";
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
