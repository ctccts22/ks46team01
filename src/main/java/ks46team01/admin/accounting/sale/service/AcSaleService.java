package ks46team01.admin.accounting.sale.service;

import ks46team01.admin.accounting.sale.dto.AcSale;
import ks46team01.admin.accounting.sale.mapper.AcSaleMapper;
import ks46team01.mushroom.mushroomFarmData.dto.FarmData;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AcSaleService {
    private final AcSaleMapper acSaleMapper;

    public AcSaleService(AcSaleMapper acSaleMapper)
    {
        this.acSaleMapper= acSaleMapper;
    }

    public List<AcSale> getAcSale(){
        List<AcSale> acSalse = acSaleMapper.getAcSale();
        return acSalse;
    }

    public String add(AcSale acSale) {
        String result =
                acSaleMapper.addAcSale(acSale);
        return result;
    }
}
