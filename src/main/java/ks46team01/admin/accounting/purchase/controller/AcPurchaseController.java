package ks46team01.admin.accounting.purchase.controller;

import ks46team01.admin.accounting.purchase.dto.AcPurchase;
import ks46team01.admin.accounting.purchase.service.AcPurchaseService;

import ks46team01.admin.company.entity.Company;
import ks46team01.admin.info.entity.Admin;


import ks46team01.common.compost.dto.CompanyContract;
import ks46team01.common.compost.dto.Inventory;
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

    //조회
    @GetMapping("/purchaseAccounting")
    public String acPurchase(Model model) {
        List<AcPurchase> ap = acPurchaseService.getAcPurchase();
        List<Company> companies = acPurchaseService.getCompany();


        List<Admin> admins = acPurchaseService.getAdmin();
        model.addAttribute("title", "조회");
        model.addAttribute("ap", ap);
        model.addAttribute("companies", companies);

        model.addAttribute("admins", admins);
        log.info("ap = {}", ap);
        return "/admin/accounting/purchase/purchaseAccounting";
    }


//입력
    @GetMapping("/purchaseAccountingAdd")
    public String showAddPurchaseAccounting(Model model){
        List<Company> companies = acPurchaseService.getCompany();


        List<Admin> admins = acPurchaseService.getAdmin();
        model.addAttribute("AcPurchase", new AcPurchase());
        model.addAttribute("companies", companies);

        model.addAttribute("admins", admins);
        log.info("들어오는 값 = {}" ,  new AcPurchase());
        return "/admin/accounting/purchase/purchaseAccountingAdd";
    }
    @PostMapping("/purchaseAccountingAdd")
    public String addPurchaseAccounting(AcPurchase acPurchase){
        acPurchaseService.addAcPurchase(acPurchase);
        log.info("입력창  : {}", acPurchase);
        return "redirect:/admin/accounting/purchase/purchaseAccounting";
    }


    //수정



    //삭제
    @PutMapping("/delete/purchaseAccountingDelete")
    public String deleteAcPurchase(@RequestParam(name="accountingPurchaseAdminIdx",required = false)Long accountingPurchaseAdminIdx){
        AcPurchase acPurchaseInfo = acPurchaseService.getAcPurchaseInfoByDeleteId(accountingPurchaseAdminIdx);
        acPurchaseService.deleteAcPurchase(accountingPurchaseAdminIdx);
        return "redirect:/admin/accounting/purchase/purchaseAccounting";
    }


}























