package ks46team01.admin.accounting.sale.mapper;

import ks46team01.admin.accounting.sale.dto.AcSale;
import ks46team01.mushroom.mushroomFarmData.dto.FarmData;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AcSaleMapper {
    List<AcSale> getAcSale();

    String addAcSale(AcSale acSale);
}
