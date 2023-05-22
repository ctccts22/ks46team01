package ks46team01.admin.accounting.sale.controller;

import ks46team01.admin.accounting.sale.dto.AcSale;
import ks46team01.admin.accounting.sale.service.AcSaleService;
import ks46team01.admin.company.dto.CompanyDTO;
import ks46team01.admin.info.dto.AdminDTO;
import ks46team01.common.company.contract.dto.CompanyContractDTO;
import ks46team01.common.compost.dto.Inventory;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Controller
@Slf4j
@AllArgsConstructor
@RequestMapping("/admin/accounting/sale")
public class AcSaleController {
    private final AcSaleService acSaleService;

    //조회
    @GetMapping("/saleAccounting")
    public String acSale(Model model){
        List<AcSale> as = acSaleService.getAcSale();
        List<CompanyDTO> companyDTOList = acSaleService.getCompany();
        List<Inventory> inventories = acSaleService.getInventory();
        List<CompanyContractDTO> companyContractDTOS = acSaleService.getCompanyContract();
        List<AdminDTO> adminDTOS = acSaleService.getAdmin();
        model.addAttribute("title", "조회");
        model.addAttribute("as", as);
        model.addAttribute("companyDTOList", companyDTOList);
        model.addAttribute("inventories", inventories);
        model.addAttribute("companyContractDTOS", companyContractDTOS);
        model.addAttribute("adminDTOS", adminDTOS);
        log.info("as = {}", as);
        return "admin/accounting/sale/saleAccounting";
    }

    //입력
    @GetMapping("/saleAccountingAdd")
    public String showAddSaleAccounting(Model model){
        List<CompanyDTO> companyDTOList = acSaleService.getCompany();
        List<Inventory> inventories = acSaleService.getInventory();
        List<CompanyContractDTO> companyContractDTOS = acSaleService.getCompanyContract();
        List<AdminDTO> adminDTOS = acSaleService.getAdmin();
        model.addAttribute("AcSale", new AcSale());
        model.addAttribute("companyDTOList", companyDTOList);
        model.addAttribute("inventories", inventories);
        model.addAttribute("companyContractDTOS", companyContractDTOS);
        model.addAttribute("adminDTOS", adminDTOS);
        log.info("들어오는값={}", new AcSale());
        return "admon/accounting/sale/saleAccountingAdd";
    }
    @PostMapping("/saleAccountingAdd")
    public String addSaleAccounting(AcSale acSale){
        acSaleService.addAcSale(acSale);
        log.info("들어오는값={}", acSale);
        return "redirect:/admin/accounting/sale/saleAccounting";
    }


    //수정
    @GetMapping("/saleAccountingModify")
    public String modifyAcSale(@RequestParam(name="accountingSalesAdminIdx",required = false)Long accountingSalesAdminIdx
            ,@RequestParam(name="companyIdx",required = false)Long companyIdx
            ,@RequestParam(name="inventoryIdx",required = false)Long inventoryIdx
            ,@RequestParam(name="companyContractIdx",required = false)Long companyContractIdx
            ,@RequestParam(name="accountingSalesAdminDateS",required = false)String accountingSalesAdminDateS
            ,@RequestParam(name="accountingSalesAdminDate",required = false)Date accountingSalesAdminDate
            ,@RequestParam(name="accountingSalesAdminType",required = false)String accountingSalesAdminType
            ,@RequestParam(name="accountingSalesAdminPayment",required = false)String accountingSalesAdminPayment
            ,@RequestParam(name="accountingSalesAdminSum",required = false)Integer accountingSalesAdminSum
            ,@RequestParam(name="adminUsername",required = false)String adminUsername
            ,@RequestParam(name="accountingSalesAdminUpdate",required = false) Timestamp accountingSalesAdminUpdate
            ,@RequestParam(name="accountingSalesAdminFinishUpdate",required = false)String accountingSalesAdminFinishUpdate ,Model model) {
        AcSale acSaleInfo = acSaleService.getAcPurchaseInfoByModifyId(accountingSalesAdminIdx
                , companyIdx
                , inventoryIdx
                , companyContractIdx
                , accountingSalesAdminDateS
                , accountingSalesAdminDate
                , accountingSalesAdminType
                , accountingSalesAdminPayment
                , accountingSalesAdminSum
                , adminUsername
                , accountingSalesAdminUpdate
                , accountingSalesAdminFinishUpdate);
        List<CompanyDTO> companyDTOList = acSaleService.getCompany();
        List<Inventory> inventories = acSaleService.getInventory();
        List<CompanyContractDTO> companyContractDTOS = acSaleService.getCompanyContract();
        List<AdminDTO> adminDTOS = acSaleService.getAdmin();
        model.addAttribute("companyDTOList", companyDTOList);
        model.addAttribute("inventories", inventories);
        model.addAttribute("companyContractDTOS", companyContractDTOS);
        model.addAttribute("adminDTOS", adminDTOS);
        return "admin/accountg/sale/saleAccountingModify";
    }
    @PostMapping("/saleAccountingModify")
    public String modifyAcSale(@RequestParam(name="accountingSalesAdminIdx",required = false)Long accountingSalesAdminIdx
            ,@RequestParam(name="companyIdx",required = false)Long companyIdx
            ,@RequestParam(name="inventoryIdx",required = false)Long inventoryIdx
            ,@RequestParam(name="companyContractIdx",required = false)Long companyContractIdx
            ,@RequestParam(name="accountingSalesAdminDateS",required = false)String accountingSalesAdminDateS
            ,@RequestParam(name="accountingSalesAdminDate",required = false)Date accountingSalesAdminDate
            ,@RequestParam(name="accountingSalesAdminType",required = false)String accountingSalesAdminType
            ,@RequestParam(name="accountingSalesAdminPayment",required = false)String accountingSalesAdminPayment
            ,@RequestParam(name="accountingSalesAdminSum",required = false)Integer accountingSalesAdminSum
            ,@RequestParam(name="adminUsername",required = false)String adminUsername
            ,@RequestParam(name="accountingSalesAdminUpdate",required = false) Timestamp accountingSalesAdminUpdate
            ,@RequestParam(name="accountingSalesAdminFinishUpdate",required = false)String accountingSalesAdminFinishUpdate) {
    acSaleService.modifyAcSale(accountingSalesAdminIdx
            , companyIdx
            , inventoryIdx
            , companyContractIdx
            , accountingSalesAdminDateS
            , accountingSalesAdminDate
            , accountingSalesAdminType
            , accountingSalesAdminPayment
            , accountingSalesAdminSum
            , adminUsername
            , accountingSalesAdminUpdate
            , accountingSalesAdminFinishUpdate);
        return "redirect:/admin/accounting/sale/saleAccounting";
    }




    //삭제
    @PostMapping("/delete/saleAccountingDelete")
    public String deleteAcSale(@RequestParam(name="accountingSalesAdminIdx",required = false)Long accountingSalesAdminIdx){
        AcSale acSaleInfo = acSaleService.getAcSaleInfoByDeleteId(accountingSalesAdminIdx);
        acSaleService.deleteAcSale(accountingSalesAdminIdx);
        return "redirect:/admin/accounting/sale/saleAccounting";
    }


}

