    package ks46team01.mushroom.mushroomFarmData.controller;

    import ks46team01.mushroom.mushroomFarmData.dto.CompanyInfo;
    import ks46team01.mushroom.mushroomFarmData.dto.FarmData;
    import ks46team01.mushroom.mushroomFarmData.dto.UsernameInfo;
    import ks46team01.mushroom.mushroomFarmData.mapper.FarmDataMapper;
    import ks46team01.mushroom.mushroomFarmData.service.FarmDataService;
    import lombok.AllArgsConstructor;
    import lombok.extern.slf4j.Slf4j;
    import org.springframework.stereotype.Controller;
    import org.springframework.ui.Model;
    import org.springframework.web.bind.annotation.*;

    import java.sql.Date;
    import java.sql.Timestamp;
    import java.util.List;

    @Controller
    @Slf4j
    @AllArgsConstructor
    @RequestMapping("/mushroom")
    public class FarmDataController {
        private final FarmDataService farmDataService;
        private final FarmDataMapper farmDataMapper;

         //조회
        @GetMapping("/dataFarmMushroom")
        public String dataFarm(Model model){
            List<FarmData>  farmData = farmDataService.getListFarmData();
            List<CompanyInfo> companyInfo = farmDataService.getCompanyInfo();
            List<UsernameInfo> usernameInfo = farmDataService.getUsernameInfo();
            model.addAttribute("title","조회");
            model.addAttribute("farmData",farmData);
            model.addAttribute("companyInfo",companyInfo);
            model.addAttribute("usernameInfo",usernameInfo);
            log.info("farmData={} ",farmData);
            log.info("companyInfo={} ",companyInfo);
            log.info("usernameInfo={} ",usernameInfo);
            return "/mushroom/dataFarmMushroom";
        }

        //입력
        @GetMapping("add/addDataFarmMushroom")
        public String showAddFarmDataForm(Model model){
            List<CompanyInfo> companyInfo = farmDataService.getCompanyInfo();
            List<UsernameInfo> usernameInfo = farmDataService.getUsernameInfo();
            model.addAttribute("FarmData",new FarmData());
            model.addAttribute("companyInfo",companyInfo);
            model.addAttribute("usernameInfo",usernameInfo);
            return "/mushroom/add/addDataFarmMushroom";
        }
        @PostMapping("add/addDataFarmMushroom")
        public String addFarmData(FarmData farmData){
            farmDataService.addFarmData(farmData);
            return "redirect:/mushroom/dataFarmMushroom";
        }

        //수정
        @GetMapping("/modify/modifyDataFarmMushroom")
        public String modifyDataFarm(@RequestParam(name = "farmDataIdx",required = false) Long farmDataIdx
                ,@RequestParam(name = "username",required = false) String username
                ,@RequestParam(name = "companyInfoIdx",required = false) Long companyInfoIdx
                ,@RequestParam(name = "farmDataCompost",required = false) Integer farmDataCompost
                ,@RequestParam(name = "farmDataProduction",required = false) Double farmDataProduction
                ,@RequestParam(name = "farmDataExpectedSale",required = false) Integer farmDataExpectedSale
                ,@RequestParam(name = "farmDataActualSale",required = false) Integer farmDataActualSale
                ,@RequestParam(name = "farmDataProductionDate",required = false) Date farmDataProductionDate
                ,@RequestParam(name = "farmDataOccurrenceSaleDate",required = false) Date farmDataOccurrenceSaleDate
                ,@RequestParam(name = "farmDataExpectedWasted",required = false) Double farmDataExpectedWasted
                ,@RequestParam(name = "farmDataDate",required = false) Timestamp farmDataDate
                ,Model model) {
            FarmData farmDataInfo = farmDataService.getFarmDataInfoByIdx(farmDataIdx
                    , username
                    , companyInfoIdx
                    , farmDataCompost
                    , farmDataProduction
                    , farmDataExpectedSale
                    , farmDataActualSale
                    , farmDataProductionDate
                    , farmDataOccurrenceSaleDate
                    , farmDataExpectedWasted
                    , farmDataDate);
            List<FarmData> farmData = farmDataService.getListFarmData();
            List<CompanyInfo> companyInfo = farmDataService.getCompanyInfo();
            List<UsernameInfo> usernameInfo = farmDataService.getUsernameInfo();
            model.addAttribute("farmData", farmData);
            model.addAttribute("companyInfo", companyInfo);
            model.addAttribute("usernameInfo", usernameInfo);

            return "mushroom/modify/modifyDataFarmMushroom";
        }
        @PostMapping("/modify/modifyDataFarmMushroom")
        public String modifyDataFarm(@RequestParam(name = "farmDataIdx",required = false) Long farmDataIdx
                ,@RequestParam(name = "username",required = false) String username
                ,@RequestParam(name = "companyInfoIdx",required = false) Long companyInfoIdx
                ,@RequestParam(name = "farmDataCompost",required = false) Integer farmDataCompost
                ,@RequestParam(name = "farmDataProduction",required = false) Double farmDataProduction
                ,@RequestParam(name = "farmDataExpectedSale",required = false) Integer farmDataExpectedSale
                ,@RequestParam(name = "farmDataActualSale",required = false) Integer farmDataActualSale
                ,@RequestParam(name = "farmDataProductionDate",required = false) Date farmDataProductionDate
                ,@RequestParam(name = "farmDataOccurrenceSaleDate",required = false) Date farmDataOccurrenceSaleDate
                ,@RequestParam(name = "farmDataExpectedWasted",required = false) Double farmDataExpectedWasted
                ,@RequestParam(name = "farmDataDate",required = false) Timestamp farmDataDate){
            farmDataService.modifyFarmData(farmDataIdx
                                    , username
                                    , companyInfoIdx
                                    , farmDataCompost
                                    , farmDataProduction
                                    , farmDataExpectedSale
                                    , farmDataActualSale
                                    , farmDataProductionDate
                                    , farmDataOccurrenceSaleDate
                                    , farmDataExpectedWasted
                                    , farmDataDate);
            return "redirect:/mushroom/dataFarmMushroom";
        }



        //삭제
        @PostMapping("/delete/deleteDataFarmMushroom")
        public String deleteFarmData(@RequestParam(name = "farmDataIdx",required = false)Long farmDataIdx){
            FarmData farmDataInfo = farmDataService.getFarmDataInfoByDeleteIdx(farmDataIdx);
            farmDataService.deleteFarmData(farmDataIdx);
            return "redirect:/mushroom/dataFarmMushroom";
        }




    }





