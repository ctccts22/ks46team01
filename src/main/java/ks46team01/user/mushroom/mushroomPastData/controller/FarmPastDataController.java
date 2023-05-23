    package ks46team01.user.mushroom.mushroomPastData.controller;

    import ks46team01.common.company.info.entity.CompanyInfo;
    import ks46team01.crop.dto.Crop;
    import ks46team01.user.mushroom.mushroomPastData.dto.FarmPastData;
    import ks46team01.user.mushroom.mushroomPastData.service.FarmPastDataService;
    import ks46team01.user.info.entity.User;
    import lombok.AllArgsConstructor;
    import lombok.extern.slf4j.Slf4j;
    import org.springframework.stereotype.Controller;
    import org.springframework.ui.Model;
    import org.springframework.web.bind.annotation.*;

    import java.sql.Timestamp;
    import java.util.List;

    @Controller
    @Slf4j
    @AllArgsConstructor
    @RequestMapping("/mushroom")
    public class FarmPastDataController {
        private final FarmPastDataService farmPastDataService;

        //조회
        @GetMapping("/listDataPastMushroom")
        public String farmPastData(Model model) {
            List<FarmPastData> fpd = farmPastDataService.getFarmPastData();
            List<CompanyInfo> companyInfoList = farmPastDataService.getCompanyInfo();
            List<Crop> cropList = farmPastDataService.getCropIdx();
            List<User> usernameInfoList = farmPastDataService.getUsernameInfo();
            model.addAttribute("title", "조회");
            model.addAttribute("fpd", fpd);
            model.addAttribute("companyInfoList", companyInfoList);
            model.addAttribute("cropList", cropList);
            model.addAttribute("usernameInfoList", usernameInfoList);
            log.info("fpd={}",fpd);
            return "user/mushroom/listDataPastMushroom";
        }
        //입력
        @GetMapping("/add/addDataPastMushroom")
        public String showAddDataPastMushroomForm(Model model) {
            List<CompanyInfo> companyInfoList = farmPastDataService.getCompanyInfo();
            List<Crop> cropList = farmPastDataService.getCropIdx();
            List<User> usernameInfoList = farmPastDataService.getUsernameInfo();
            model.addAttribute("FarmPastData", new FarmPastData());
            model.addAttribute("companyInfoList", companyInfoList);
            model.addAttribute("cropList", cropList);
            model.addAttribute("usernameInfoList", usernameInfoList);
            log.info("들어오는값= {}" ,new FarmPastData());
            log.info("들어오는값= {}" ,companyInfoList);
            log.info("들어오는값= {}" ,cropList);
            log.info("들어오는값= {}" ,usernameInfoList);
            return "user/mushroom/add/addDataPastMushroom";
        }
        @PostMapping("/add/addDataPastMushroom")
        public String addFarmCondition(FarmPastData farmPastData) {
            farmPastDataService.addFarmPastData(farmPastData);
            log.info("입력창 :{}",farmPastData);
            return "redirect:/mushroom/listDataPastMushroom";

        }

        //수정
        @GetMapping("/modify/modifyDataPastMushroom")
        public String modifyFarmPastData(
                @RequestParam(name="pastDataIdx",required = false)Long pastDataIdx
                ,@RequestParam(name="username",required = false)String username
                ,@RequestParam(name="companyInfoIdx",required = false)Long companyInfoIdx
                ,@RequestParam(name="cropIdx",required = false)Long cropIdx
                ,@RequestParam(name="pastDataMushroomProduction",required = false)String pastDataMushroomProduction
                ,@RequestParam(name="pastDataTotalRevenue",required = false)Integer pastDataTotalRevenue
                ,@RequestParam(name="pastDataBadgeUse",required = false)Integer pastDataBadgeUse
                ,@RequestParam(name="pastDataYear",required = false)Integer pastDataYear
                ,@RequestParam(name="pastDataUse",required = false)String pastDataUse
                ,@RequestParam(name="pastDataComparison",required = false)String pastDataComparison
                ,@RequestParam(name="pastDataDate",required = false)Timestamp pastDataDate , Model model){
            FarmPastData farmPastDataInfo = farmPastDataService.getFarmPastDataInfoById(pastDataIdx
            , username
            , companyInfoIdx
            , cropIdx
            , pastDataMushroomProduction
            , pastDataTotalRevenue
            , pastDataBadgeUse
            , pastDataYear
            , pastDataUse
            , pastDataComparison
            , pastDataDate);
            List<FarmPastData> fpd = farmPastDataService.getFarmPastData();
            List<CompanyInfo> companyInfoList = farmPastDataService.getCompanyInfo();
            List<Crop> cropList = farmPastDataService.getCropIdx();
            List<User> usernameInfoList = farmPastDataService.getUsernameInfo();

            model.addAttribute("fpd", fpd);
            model.addAttribute("companyInfoList", companyInfoList);
            model.addAttribute("cropList", cropList);
            model.addAttribute("usernameInfoList", usernameInfoList);

            log.info("fpd  : {}", fpd);
            log.info("companyInfoList  : {}", companyInfoList);
            log.info("cropList  : {}", cropList);
            log.info("usernameInfoList  : {}", usernameInfoList);


            return "user/mushroom/modify/modifyDataPastMushroom";
        }




        @PostMapping("/modify/modifyDataPastMushroom")
        public String modifyFarmPastData(
                @RequestParam(name="pastDataIdx",required = false)Long pastDataIdx
                ,@RequestParam(name="username",required = false)String username
                ,@RequestParam(name="companyInfoIdx",required = false)Long companyInfoIdx
                ,@RequestParam(name="cropIdx",required = false)Long cropIdx
                ,@RequestParam(name="pastDataMushroomProduction",required = false)String pastDataMushroomProduction
                ,@RequestParam(name="pastDataTotalRevenue",required = false)Integer pastDataTotalRevenue
                ,@RequestParam(name="pastDataBadgeUse",required = false)Integer pastDataBadgeUse
                ,@RequestParam(name="pastDataYear",required = false)Integer pastDataYear
                ,@RequestParam(name="pastDataUse",required = false)String pastDataUse
                ,@RequestParam(name="pastDataComparison",required = false)String pastDataComparison
                ,@RequestParam(name="pastDataDate",required = false) Timestamp pastDataDate){
            farmPastDataService.modifyFarmPastData(pastDataIdx
                    , username
                    , companyInfoIdx
                    , cropIdx
                    , pastDataMushroomProduction
                    , pastDataTotalRevenue
                    , pastDataBadgeUse
                    , pastDataYear
                    , pastDataUse
                    , pastDataComparison
                    , pastDataDate);
            return "redirect:/mushroom/listDataPastMushroom";
        }





        //삭제
        @PostMapping("/delete/deleteDataPastMushroom")
        public String deleteDataPastMushroom(@RequestParam(name="pastDataIdx",required = false) Long pastDataIdx){

            FarmPastData farmPastData = farmPastDataService.getFarmPastDataInfoByDeleteId(pastDataIdx);
            farmPastDataService.deleteFarmPastData(pastDataIdx);

            log.info("삭제처리 :{}",farmPastData);
            log.info("삭제대상 :{}",pastDataIdx);
            return "redirect:/mushroom/listDataPastMushroom";
        }

    }












