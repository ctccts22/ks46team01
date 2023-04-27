package ks46team01.admin.accounting.sale.controller;

import ks46team01.admin.accounting.sale.service.AcSaleService;
import ks46team01.admin.accounting.sale.dto.AcSale;
import ks46team01.mushroom.mushroomFarmData.dto.FarmData;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    @PostMapping("/admin/accounting/sale")
    public String addAccountingSale(AcSale acSale) {
        acSaleService.add(acSale);

        return "redirect:/admin/saleAccountingAdd";
    }
    @GetMapping("/saleAccountingAdd")
    public String addFarmCondition(Model model) {
        model.addAttribute("title", "등록");
        model.addAttribute("acSale", new AcSale());
        return "/admin/accounting/sale/saleAccountingAdd";
    }
}


