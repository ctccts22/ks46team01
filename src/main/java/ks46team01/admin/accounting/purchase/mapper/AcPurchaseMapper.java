package ks46team01.admin.accounting.purchase.mapper;

import ks46team01.admin.accounting.purchase.dto.AcPurchase;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AcPurchaseMapper {

    List<AcPurchase> getAcPurchase();
}
