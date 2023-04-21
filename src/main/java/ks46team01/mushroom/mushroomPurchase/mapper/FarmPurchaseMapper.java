package ks46team01.mushroom.mushroomPurchase.mapper;



import ks46team01.mushroom.mushroomPurchase.dto.FarmPurchase;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FarmPurchaseMapper {
    List<FarmPurchase> getFarmPurchase();

    int addFarmPurchase (FarmPurchase farmPurchase);
}
