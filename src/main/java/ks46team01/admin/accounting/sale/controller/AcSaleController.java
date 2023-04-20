package ks46team01.admin.accounting.sale.controller;

import ks46team01.admin.accounting.sale.service.AcSaleService;
import ks46team01.admin.accounting.sale.dto.AcSale;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Slf4j
@AllArgsConstructor
@RequestMapping("/admin/accounting/sale")
public class AcSaleController {
    private final AcSaleService acSaleService;

    @GetMapping("/saleAccounting")
    public String accountingSale(Model model) {
        List<AcSale> as = acSaleService.getAcSale();

        model.addAttribute("title","조회");
        model.addAttribute("as", as);

        return "/admin/accounting/sale/saleAccounting";
    }
}


