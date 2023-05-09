    package ks46team01.mushroom.mushroomPurchase.controller;


    import ks46team01.admin.company.contract.entity.CompanyContract;
    import ks46team01.admin.company.entity.Company;
    import ks46team01.admin.inventory.entity.Inventory;
    import ks46team01.common.company.info.entity.CompanyInfo;
    import ks46team01.mushroom.mushroomPurchase.dto.FarmPurchase;
    import ks46team01.mushroom.mushroomPurchase.service.FarmPurchaseService;
    import ks46team01.user.info.entity.User;
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
    @RequestMapping("/mushroom")
    public class FarmPurchaseController {
        private final FarmPurchaseService farmPurchaseService;

        //조회
        @GetMapping("/accountMushroom")
        public String farmPurchaseList(Model model){
            List<FarmPurchase> fp = farmPurchaseService.getListPurchaseAccount();
            List<User> userList = farmPurchaseService.getUserIdx();
            List<Company> companyList =farmPurchaseService.getCompanyIdx();
            List<CompanyInfo> companyInfoList = farmPurchaseService.getCompanyInfoIdx();
            List<Inventory> inventoryList = farmPurchaseService.getInventoryIdx();
            List<CompanyContract> companyContractList = farmPurchaseService.getCompanyContractIdx();
            model.addAttribute("title","조회");
            model.addAttribute("fp",fp);
            model.addAttribute("userList",userList);
            model.addAttribute("companyList",companyList);
            model.addAttribute("companyInfoList",companyInfoList);
            model.addAttribute("inventoryList",inventoryList);
            model.addAttribute("companyContractList",companyContractList);
            log.info("fp ={}" ,fp);
            return "/mushroom/accountMushroom";
        }

        //입력
        @GetMapping("/add/addAccountMushroom")
        public String showAddAccountPurchase(Model model){
            List<User> userList = farmPurchaseService.getUserIdx();
            List<Company> companyList =farmPurchaseService.getCompanyIdx();
            List<CompanyInfo> companyInfoList = farmPurchaseService.getCompanyInfoIdx();
            List<Inventory> inventoryList = farmPurchaseService.getInventoryIdx();
            List<CompanyContract> companyContractList = farmPurchaseService.getCompanyContractIdx();
            model.addAttribute("FarmPurchase",new FarmPurchase());
            model.addAttribute("userList",userList);
            model.addAttribute("companyList",companyList);
            model.addAttribute("companyInfoList",companyInfoList);
            model.addAttribute("inventoryList",inventoryList);
            model.addAttribute("companyContractList",companyContractList);
            return "/mushroom/add/addAccountMushroom";
        }
        @PostMapping("/add/addAccountMushroom")
        public String addAccountPurchase(FarmPurchase farmPurchase){
            farmPurchaseService.addPurchaseAccount(farmPurchase);
            log.info("입력창 = {}",farmPurchase);
            return "redirect:/mushroom/accountMushroom";
        }



    }





