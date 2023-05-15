package ks46team01.admin.accounting.purchase.controller;

import ks46team01.admin.accounting.purchase.dto.AcPurchase;
import ks46team01.admin.accounting.purchase.service.AcPurchaseService;
import ks46team01.admin.company.dto.CompanyDTO;
import ks46team01.admin.info.dto.AdminDTO;
import ks46team01.admin.inventories.inventory.dto.InventoryDTO;
import ks46team01.common.company.contract.dto.CompanyContractDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;
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
        List<CompanyDTO> companies = acPurchaseService.getCompany();
        List<InventoryDTO> inventories = acPurchaseService.getInventory();
        List<CompanyContractDTO> companyContracts = acPurchaseService.getCompanyContract();
        List<AdminDTO> admins = acPurchaseService.getAdmin();
        model.addAttribute("title", "조회");
        model.addAttribute("ap", ap);
        model.addAttribute("companies", companies);
        model.addAttribute("inventories", inventories);
        model.addAttribute("companyContracts", companyContracts);
        model.addAttribute("admins", admins);
        log.info("ap = {}", ap);
        return "/admin/accounting/purchase/purchaseAccounting";
    }


//입력
    @GetMapping("/purchaseAccountingAdd")
    public String showAddPurchaseAccounting(Model model){
        List<CompanyDTO> companies = acPurchaseService.getCompany();
        List<InventoryDTO> inventories = acPurchaseService.getInventory();
        List<CompanyContractDTO> companyContracts = acPurchaseService.getCompanyContract();
        List<AdminDTO> admins = acPurchaseService.getAdmin();
        model.addAttribute("AcPurchase", new AcPurchase());
        model.addAttribute("companies", companies);
        model.addAttribute("inventories", inventories);
        model.addAttribute("companyContracts", companyContracts);
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
    @GetMapping("/purchaseAccountingModify")
    public String modifyAcPurchase(@RequestParam(name="accountingPurchaseAdminIdx",required = false)Long accountingPurchaseAdminIdx
            ,@RequestParam(name="companyIdx",required = false)Long companyIdx
            ,@RequestParam(name="inventoryIdx",required = false)Long inventoryIdx
            ,@RequestParam(name="companyContractIdx",required = false)Long companyContractIdx
            ,@RequestParam(name="accountingPurchaseAdminDateS",required = false)String accountingPurchaseAdminDateS
            ,@RequestParam(name="accountingPurchaseAdminDate",required = false)Date accountingPurchaseAdminDate
            ,@RequestParam(name="accountingPurchaseAdminPrice",required = false)Integer accountingPurchaseAdminPrice
            ,@RequestParam(name="accountingPurchaseAdminAmount",required = false)Double accountingPurchaseAdminAmount
            ,@RequestParam(name="accountingPurchaseAdminPayment",required = false)String accountingPurchaseAdminPayment
            ,@RequestParam(name="accountingPurchaseAdminSum",required = false)Integer accountingPurchaseAdminSum
            ,@RequestParam(name="adminUsername",required = false)String adminUsername
            ,@RequestParam(name="accountingPurchaseAdminUpdate",required = false)Timestamp accountingPurchaseAdminUpdate, Model model){
        AcPurchase acPurchaseInfo = acPurchaseService.getAcPurchaseInfoByModifyId(accountingPurchaseAdminIdx
                                                ,  companyIdx
                                                ,  inventoryIdx
                                                ,  companyContractIdx
                                                ,  accountingPurchaseAdminDateS
                                                ,  accountingPurchaseAdminDate
                                                ,  accountingPurchaseAdminPrice
                                                ,  accountingPurchaseAdminAmount
                                                ,  accountingPurchaseAdminPayment
                                                ,  accountingPurchaseAdminSum
                                                ,  adminUsername
                                                ,  accountingPurchaseAdminUpdate);
            List<CompanyDTO> companies = acPurchaseService.getCompany();
            List<InventoryDTO> inventories = acPurchaseService.getInventory();
            List<CompanyContractDTO> companyContracts = acPurchaseService.getCompanyContract();
            List<AdminDTO> admins = acPurchaseService.getAdmin();
            model.addAttribute("companies", companies);
            model.addAttribute("inventories", inventories);
            model.addAttribute("companyContracts", companyContracts);
            model.addAttribute("admins", admins);
        return "/admin/accounting/purchase/purchaseAccountingModify";
    }
    @PostMapping("/purchaseAccountingModify")
    public String modifyAcPurchase(@RequestParam(name="accountingPurchaseAdminIdx",required = false)Long accountingPurchaseAdminIdx
            ,@RequestParam(name="companyIdx",required = false)Long companyIdx
            ,@RequestParam(name="inventoryIdx",required = false)Long inventoryIdx
            ,@RequestParam(name="companyContractIdx",required = false)Long companyContractIdx
            ,@RequestParam(name="accountingPurchaseAdminDateS",required = false)String accountingPurchaseAdminDateS
            ,@RequestParam(name="accountingPurchaseAdminDate",required = false)Date accountingPurchaseAdminDate
            ,@RequestParam(name="accountingPurchaseAdminPrice",required = false)Integer accountingPurchaseAdminPrice
            ,@RequestParam(name="accountingPurchaseAdminAmount",required = false)Double accountingPurchaseAdminAmount
            ,@RequestParam(name="accountingPurchaseAdminPayment",required = false)String accountingPurchaseAdminPayment
            ,@RequestParam(name="accountingPurchaseAdminSum",required = false)Integer accountingPurchaseAdminSum
            ,@RequestParam(name="adminUsername",required = false)String adminUsername
            ,@RequestParam(name="accountingPurchaseAdminUpdate",required = false)Timestamp accountingPurchaseAdminUpdate){
        acPurchaseService.modifyAcPurchase(accountingPurchaseAdminIdx
                                ,  companyIdx
                                ,  inventoryIdx
                                ,  companyContractIdx
                                ,  accountingPurchaseAdminDateS
                                ,  accountingPurchaseAdminDate
                                ,  accountingPurchaseAdminPrice
                                ,  accountingPurchaseAdminAmount
                                ,  accountingPurchaseAdminPayment
                                ,  accountingPurchaseAdminSum
                                ,  adminUsername
                                ,  accountingPurchaseAdminUpdate);
        return "redirect:/admin/accounting/purchase/purchaseAccounting";
    }





    //삭제
    @PostMapping("/delete/purchaseAccountingDelete")
    public String deleteAcPurchase(@RequestParam(name="accountingPurchaseAdminIdx",required = false)Long accountingPurchaseAdminIdx){
        AcPurchase acPurchaseInfo = acPurchaseService.getAcPurchaseInfoByDeleteId(accountingPurchaseAdminIdx);
        acPurchaseService.deleteAcPurchase(accountingPurchaseAdminIdx);
        return "redirect:/admin/accounting/purchase/purchaseAccounting";
    }


}






