package ks46team01.admin.accounting.purchase.controller;

import ks46team01.admin.accounting.purchase.dto.AcPurchase;
import ks46team01.admin.accounting.purchase.service.AcPurchaseService;
import ks46team01.admin.accounting.sale.dto.AcSale;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@Slf4j
@AllArgsConstructor
@RequestMapping("/admin/accounting/purchase")
public class AcPurchaseController {

    private final AcPurchaseService acPurchaseService;

    @GetMapping("/purchaseAccounting")
    public String getAcPurchase(Model model) {
        List<AcPurchase> ac = acPurchaseService.getAcPurchase();

        model.addAttribute("title", "이력조회");
        model.addAttribute("ac", ac);

        return "admin/accounting/purchase/purchaseAccounting";
    }

    @PostMapping("/admin/accounting/purchase")
    public String addAccountingPurchase(AcPurchase acPurchase) {
        acPurchaseService.add(acPurchase);

        return "redirect:/admin/purchaseAccountingAdd";
    }
    @GetMapping("/purchaseAccountingAdd")
    public String addAccountingPurchase(Model model) {
        model.addAttribute("title", "등록");
        model.addAttribute("acSale", new AcPurchase());
        return "/admin/accounting/purchase/purchaseAccountingAdd";
    }


}























