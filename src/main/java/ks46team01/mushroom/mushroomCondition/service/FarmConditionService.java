package ks46team01.mushroom.mushroomCondition.service;

import ks46team01.admin.info.entity.Admin;
import ks46team01.mushroom.mushroomCondition.dto.Crop;
import ks46team01.mushroom.mushroomCondition.dto.FarmCondition;
import ks46team01.mushroom.mushroomCondition.mapper.FarmConditionMapper;

import ks46team01.mushroom.mushroomFarmData.mapper.FarmDataMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class FarmConditionService {
    private final FarmConditionMapper farmConditionMapper;
    public FarmConditionService(FarmConditionMapper farmConditionMapper){
        this.farmConditionMapper = farmConditionMapper;
    }


    public List<FarmCondition> getAllFarmCondition() {
        return farmConditionMapper.getFarmCondition();
    }

    public Optional<FarmCondition> getMushroomByConditionIdx(String mushroomConditionIdx) {
        return farmConditionMapper.findByConditionIdx(mushroomConditionIdx);
    }




    public List<FarmCondition> getFarmCondition(){
        List<FarmCondition> farmCondition = farmConditionMapper.getFarmCondition();
        return farmCondition;
    }

    public FarmCondition addFarmCondition(FarmCondition farmCondition) {
        return farmConditionMapper.saveFarmCondition(farmCondition);
    }
    public List<Crop> getCropIdx(){
        List<Crop> cropList =
                farmConditionMapper.getCropIdx();
        return cropList;
    }



/*
    public Admin modifyFarmCondition(String mushroomConditionIdx, String cropIdx, String mushroomConditionTemperature , String mushroomConditionHumidity, String mushroomConditionOxygen, String mushroomConditionCo2, String mushroomConditionIlluminance, String mushroomConditionPh, String mushroomConditionYear, String mushroomConditionUse , String mushroomConditionDate) {
        Optional<FarmCondition> existingFarmConditionOptional = farmConditionMapper.findByAdminUsername(mushroomConditionIdx);

        if (existingFarmConditionOptional.isPresent()) {
            FarmCondition existingFarmCondition = existingFarmConditionOptional.get();
            existingFarmCondition.setAdminUsername(mushroomConditionIdx);
            existingFarmCondition.setCropIdx(Long.valueOf(cropIdx));
            existingFarmCondition.setMushroomConditionTemperature(mushroomConditionTemperature);
            existingFarmCondition.setMushroomConditionHumidity(mushroomConditionHumidity);
            existingFarmCondition.setMushroomConditionOxygen(mushroomConditionOxygen);
            existingFarmCondition.setMushroomConditionCo2(mushroomConditionCo2);
            existingFarmCondition.setMushroomConditionIlluminance(mushroomConditionIlluminance);
            existingFarmCondition.setMushroomConditionPh(mushroomConditionPh);
            existingFarmCondition.setMushroomConditionYear(Integer.parseInt(mushroomConditionYear));
            existingFarmCondition.setMushroomConditionUse(mushroomConditionUse);
            existingFarmCondition.setMushroomConditionDate(Timestamp.valueOf(mushroomConditionDate));
            return farmConditionMapper.save(existingFarmCondition);

        } else {
            throw new RuntimeException("mushroomConditionIdx not found with the given mushroomConditionIdx: " + mushroomConditionIdx);
        }
    }
*/





}












