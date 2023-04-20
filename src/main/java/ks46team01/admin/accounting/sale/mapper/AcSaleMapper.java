package ks46team01.admin.accounting.sale.mapper;

import ks46team01.admin.accounting.sale.dto.AcSale;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AcSaleMapper {
    List<AcSale> getAcSale();
}
