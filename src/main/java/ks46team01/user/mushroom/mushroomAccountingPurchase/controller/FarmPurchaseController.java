    package ks46team01.user.mushroom.mushroomAccountingPurchase.controller;


    import ks46team01.admin.company.dto.CompanyDTO;
    import ks46team01.common.company.info.dto.CompanyInfoDTO;
    import ks46team01.common.compost.dto.CompanyContract;
    import ks46team01.common.compost.dto.Inventory;
    import ks46team01.user.mushroom.mushroomAccountingPurchase.dto.FarmPurchase;
    import ks46team01.user.mushroom.mushroomAccountingPurchase.service.FarmPurchaseService;
    import ks46team01.user.info.dto.UserDTO;
    import lombok.AllArgsConstructor;
    import lombok.extern.slf4j.Slf4j;
    import org.springframework.stereotype.Controller;
    import org.springframework.ui.Model;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.PostMapping;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RequestParam;

    import java.util.List;


    @Controller
    @Slf4j
    @AllArgsConstructor
    @RequestMapping("/mushroom")
    public class FarmPurchaseController {
        private final FarmPurchaseService farmPurchaseService;

        //조회
        @GetMapping("/listPurchaseAccountingMushroom")
        public String farmPurchaseList(Model model) {
            List<FarmPurchase> fp = farmPurchaseService.getListPurchaseAccount();
            List<UserDTO> userList = farmPurchaseService.getUserIdx();
            List<CompanyDTO> companyList = farmPurchaseService.getCompanyIdx();
            List<CompanyInfoDTO> companyInfoList = farmPurchaseService.getCompanyInfoIdx();
            List<Inventory> inventoryList = farmPurchaseService.getInventoryIdx();
            List<CompanyContract> companyContractList = farmPurchaseService.getCompanyContractIdx();
            model.addAttribute("title", "조회");
            model.addAttribute("fp", fp);
            model.addAttribute("userList", userList);
            model.addAttribute("companyList", companyList);
            model.addAttribute("companyInfoList", companyInfoList);
            model.addAttribute("inventoryList", inventoryList);
            model.addAttribute("companyContractList", companyContractList);
            log.info("fp ={}", fp);
            return "user/mushroom/listPurchaseAccountingMushroom";
        }

        //입력
        @GetMapping("/add/addPurchaseAccountingMushroom")
        public String showAddAccountPurchase(Model model) {
            List<UserDTO> userList = farmPurchaseService.getUserIdx();
            List<CompanyDTO> companyList = farmPurchaseService.getCompanyIdx();
            List<CompanyInfoDTO> companyInfoList = farmPurchaseService.getCompanyInfoIdx();
            List<Inventory> inventoryList = farmPurchaseService.getInventoryIdx();
            List<CompanyContract> companyContractList = farmPurchaseService.getCompanyContractIdx();
            model.addAttribute("FarmPurchase", new FarmPurchase());
            model.addAttribute("userList", userList);
            model.addAttribute("companyList", companyList);
            model.addAttribute("companyInfoList", companyInfoList);
            model.addAttribute("inventoryList", inventoryList);
            model.addAttribute("companyContractList", companyContractList);
            return "user/mushroom/add/addPurchaseAccountingMushroom";
        }

        @PostMapping("/add/addPurchaseAccountingMushroom")
        public String addAccountPurchase(FarmPurchase farmPurchase) {
            farmPurchaseService.addPurchaseAccount(farmPurchase);
            log.info("입력창 = {}", farmPurchase);
            return "redirect:/mushroom/listPurchaseAccountingMushroom";
        }

        //수정
        @GetMapping("/modify/modifyPurchaseAccountingMushroom")
        public String modifyAccountPurchase(@RequestParam(name = "accountingPurchaseIdx", required = false) Long accountingPurchaseIdx
                , @RequestParam(name = "username", required = false) String username
                , @RequestParam(name = "companyInfoIdx", required = false) Long companyInfoIdx
                , @RequestParam(name = "companyIdx", required = false) Long companyIdx
                , @RequestParam(name = "inventoryIdx", required = false) Long inventoryIdx
                , @RequestParam(name = "companyContractIdx", required = false) Long companyContractIdx
                , @RequestParam(name = "accountingPurchaseDate", required = false) String accountingPurchaseDate
                , @RequestParam(name = "accountingPurchaseType", required = false) String accountingPurchaseType
                , @RequestParam(name = "accountingPurchaseUnitPrice", required = false) int accountingPurchaseUnitPrice
                , @RequestParam(name = "accountingPurchaseAmount", required = false) double accountingPurchaseAmount
                , @RequestParam(name = "accountingPurchasePayment", required = false) String accountingPurchasePayment
                , @RequestParam(name = "accountingPurchaseSum", required = false) int accountingPurchaseSum
                , @RequestParam(name = "accountingPurchaseCode", required = false) String accountingPurchaseCode, Model model) {
           FarmPurchase farmPurchaseInfo = farmPurchaseService.getPurchaseAccountInfoByIdx(
                                   accountingPurchaseIdx
                                   ,  username
                                   ,  companyInfoIdx
                                   ,  companyIdx
                                   ,  inventoryIdx
                                   ,  companyContractIdx
                                   ,  accountingPurchaseDate
                                   ,  accountingPurchaseType
                                   ,  accountingPurchaseUnitPrice
                                   ,  accountingPurchaseAmount
                                   ,  accountingPurchasePayment
                                   ,  accountingPurchaseSum
                                   ,  accountingPurchaseCode  );
            List<FarmPurchase> fp = farmPurchaseService.getListPurchaseAccount();
            List<UserDTO> userList = farmPurchaseService.getUserIdx();
            List<CompanyDTO> companyList = farmPurchaseService.getCompanyIdx();
            List<CompanyInfoDTO> companyInfoList = farmPurchaseService.getCompanyInfoIdx();
            List<Inventory> inventoryList = farmPurchaseService.getInventoryIdx();
            List<CompanyContract> companyContractList = farmPurchaseService.getCompanyContractIdx();
            model.addAttribute("fp", fp);
            model.addAttribute("userList", userList);
            model.addAttribute("companyList", companyList);
            model.addAttribute("companyInfoList", companyInfoList);
            model.addAttribute("inventoryList", inventoryList);
            model.addAttribute("companyContractList", companyContractList);
           return "user/mushroom/modify/modifyPurchaseAccountingMushroom";
        }

        @PostMapping("/modify/modifyPurchaseAccountingMushroom")
        public String modifyAccountPurchase(@RequestParam(name = "accountingPurchaseIdx", required = false) Long accountingPurchaseIdx
                , @RequestParam(name = "username", required = false) String username
                , @RequestParam(name = "companyInfoIdx", required = false) Long companyInfoIdx
                , @RequestParam(name = "companyIdx", required = false) Long companyIdx
                , @RequestParam(name = "inventoryIdx", required = false) Long inventoryIdx
                , @RequestParam(name = "companyContractIdx", required = false) Long companyContractIdx
                , @RequestParam(name = "accountingPurchaseDate", required = false) String accountingPurchaseDate
                , @RequestParam(name = "accountingPurchaseType", required = false) String accountingPurchaseType
                , @RequestParam(name = "accountingPurchaseUnitPrice", required = false) int accountingPurchaseUnitPrice
                , @RequestParam(name = "accountingPurchaseAmount", required = false) double accountingPurchaseAmount
                , @RequestParam(name = "accountingPurchasePayment", required = false) String accountingPurchasePayment
                , @RequestParam(name = "accountingPurchaseSum", required = false) int accountingPurchaseSum
                , @RequestParam(name = "accountingPurchaseCode", required = false) String accountingPurchaseCode){
            farmPurchaseService.modifyPurchaseAccount( accountingPurchaseIdx
                            ,  username
                            ,  companyInfoIdx
                            ,  companyIdx
                            ,  inventoryIdx
                            ,  companyContractIdx
                            ,  accountingPurchaseDate
                            ,  accountingPurchaseType
                            ,  accountingPurchaseUnitPrice
                            ,  accountingPurchaseAmount
                            ,  accountingPurchasePayment
                            ,  accountingPurchaseSum
                            ,  accountingPurchaseCode);
            return "redirect:/mushroom/listPurchaseAccountingMushroom";
        }



        //삭제
        @PostMapping("/delete/deletePurchaseAccountingMushroom")
        public String deleteAccountPurchase(@RequestParam(name ="accountingPurchaseIdx")Long accountingPurchaseIdx){
            FarmPurchase deletePurchaseAccountByIdx = farmPurchaseService.getPurchaseAccountDeleteInfoByIdx(accountingPurchaseIdx);
            farmPurchaseService.deletePurchaseAccountByIdx(accountingPurchaseIdx);
            return "redirect:/mushroom/listPurchaseAccountingMushroom";
        }
    }





