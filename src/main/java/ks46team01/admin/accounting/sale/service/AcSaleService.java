package ks46team01.admin.accounting.sale.service;

import ks46team01.admin.accounting.sale.dto.AcSale;
import ks46team01.admin.accounting.sale.mapper.AcSaleMapper;
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
}
