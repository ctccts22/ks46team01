package ks46team01.admin.accounting.purchase.mapper;

import ks46team01.admin.accounting.purchase.dto.AcPurchase;
import ks46team01.admin.accounting.sale.dto.AcSale;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AcPurchaseMapper {

    List<AcPurchase> getAcPurchase();

    String addAcPurchase(AcPurchase acPurchase);
}
