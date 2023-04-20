package ks46team01.mushroom.mushroomPastData.service;


import ks46team01.mushroom.mushroomPastData.dto.FarmPastData;
import ks46team01.mushroom.mushroomPastData.mapper.FarmPastDataMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FarmPastDataService {
    private final FarmPastDataMapper farmPastDataMapper;

    public FarmPastDataService(FarmPastDataMapper farmPastDataMapper){
        this.farmPastDataMapper = farmPastDataMapper;
    }

    public List<FarmPastData> getFarmPastData(){
        List<FarmPastData> farmPastData = farmPastDataMapper.getFarmPastData();
        return farmPastData;
    }


}
