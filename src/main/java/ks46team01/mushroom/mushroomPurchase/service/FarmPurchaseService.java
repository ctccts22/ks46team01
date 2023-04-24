package ks46team01.mushroom.mushroomPurchase.service;


import ks46team01.mushroom.mushroomPurchase.dto.FarmPurchase;
import ks46team01.mushroom.mushroomPurchase.mapper.FarmPurchaseMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FarmPurchaseService {
    private final FarmPurchaseMapper farmPurchaseMapper;

    public FarmPurchaseService(FarmPurchaseMapper farmPurchaseMapper){
        this.farmPurchaseMapper = farmPurchaseMapper;
    }

    public List<FarmPurchase> getFarmPurchase(){
        List<FarmPurchase> farmPurchase = farmPurchaseMapper.getFarmPurchase();
        return farmPurchase;
    }

    public int add(FarmPurchase farmPurchase) {
        int result =
                farmPurchaseMapper.addFarmPurchase(farmPurchase);
        return result;
    }


}
