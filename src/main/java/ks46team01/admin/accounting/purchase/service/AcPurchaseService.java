package ks46team01.admin.accounting.purchase.service;


import ks46team01.admin.accounting.purchase.dto.AcPurchase;
import ks46team01.admin.accounting.purchase.mapper.AcPurchaseMapper;
import ks46team01.admin.accounting.sale.dto.AcSale;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AcPurchaseService {
    private final AcPurchaseMapper acPurchaseMapper;

    public AcPurchaseService(AcPurchaseMapper acPurchaseMapper) {
        this.acPurchaseMapper = acPurchaseMapper;
    }

    public List<AcPurchase> getAcPurchase() {
        List<AcPurchase> acPurchase = acPurchaseMapper.getAcPurchase();
        return acPurchase;
    }

    public String add(AcPurchase acPurchase) {
        String result =
                acPurchaseMapper.addAcPurchase(acPurchase);
        return result;
    }

}









