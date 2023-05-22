    package ks46team01.mushroom.mushroomGrowth.controller;

    import ks46team01.common.company.info.dto.CompanyInfoDTO;
    import ks46team01.crop.dto.Crop;
    import ks46team01.mushroom.mushroomFarmData.dto.FarmData;
    import ks46team01.mushroom.mushroomGrowth.dto.FarmMushroomGrowth;
    import ks46team01.mushroom.mushroomGrowth.service.FarmMushroomGrowthService;
    import ks46team01.user.info.dto.UserDTO;
    import lombok.AllArgsConstructor;
    import lombok.extern.slf4j.Slf4j;
    import org.springframework.stereotype.Controller;
    import org.springframework.ui.Model;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.PostMapping;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RequestParam;

    import java.sql.Timestamp;
    import java.util.List;

    @Controller
    @Slf4j
    @AllArgsConstructor
    @RequestMapping("/mushroom")
    public class FarmMushroomGrowthController {
        private final FarmMushroomGrowthService farmMushroomGrowthService;

        @GetMapping("/dataGrownMushroom")
        public String farmGrown(Model model){
            List<FarmMushroomGrowth> fmsg = farmMushroomGrowthService.getFarmGrowth();
            List<UserDTO> userList = farmMushroomGrowthService.getUserIdx();
            List<FarmData> farmDataList = farmMushroomGrowthService.getFarmData();
            List<CompanyInfoDTO> companyInfoList = farmMushroomGrowthService.getCompanyInfo();
            List<Crop> cropList = farmMushroomGrowthService.getCropIdx();
            model.addAttribute("title", "조회");
            model.addAttribute("fmsg", fmsg);
            model.addAttribute("userList", userList);
            model.addAttribute("farmDataList", farmDataList);
            model.addAttribute("companyInfoList", companyInfoList);
            model.addAttribute("cropList", cropList);
            log.info("fmsg = {} ", fmsg);
            return "mushroom/dataGrownMushroom";
        }


        @GetMapping("/add/addDataGrownMushroom")
        public String showAddDataGrownForm(Model model){
            List<UserDTO> userList = farmMushroomGrowthService.getUserIdx();
            List<FarmData> farmDataList = farmMushroomGrowthService.getFarmData();
            List<CompanyInfoDTO> companyInfoList = farmMushroomGrowthService.getCompanyInfo();
            List<Crop> cropList = farmMushroomGrowthService.getCropIdx();
            model.addAttribute("FarmMushroomGrowth", new FarmMushroomGrowth());
            model.addAttribute("userList", userList);
            model.addAttribute("farmDataList", farmDataList);
            model.addAttribute("companyInfoList", companyInfoList);
            model.addAttribute("cropList", cropList);
            log.info("FarmMushroomGrowth = {} ",new FarmMushroomGrowth());
            log.info("userList = {} ",userList);
            log.info("farmDataList = {} ", farmDataList);
            log.info("companyInfoList = {} ", companyInfoList);
            log.info("cropList = {} ",cropList );
            return "mushroom/add/addDataGrownMushroom";
        }
        @PostMapping("/add/addDataGrownMushroom")
        public String addDataGrown(FarmMushroomGrowth farmMushroomGrowth){
            farmMushroomGrowthService.addFarmGrown(farmMushroomGrowth);
            log.info("입력창  : {}", farmMushroomGrowth);
            return "redirect:/mushroom/dataGrownMushroom";
        }


        //수정
        @GetMapping("/modify/modifyDataGrownMushroom")
        public String modifyDataGrown(@RequestParam(name="mushroomGrowthIdx" ,required = false)Long mushroomGrowthIdx
                                    ,@RequestParam(name="username" ,required = false)String username
                                    ,@RequestParam(name="companyInfoIdx" ,required = false)Long companyInfoIdx
                                    ,@RequestParam(name="farmDataIdx" ,required = false)Long farmDataIdx
                                    ,@RequestParam(name="cropIdx" ,required = false)Long cropIdx
                                    ,@RequestParam(name="mushroomGrowthDaily" ,required = false)int mushroomGrowthDaily
                                    ,@RequestParam(name="mushroomGrowthStatus" ,required = false)String mushroomGrowthStatus
                                    ,@RequestParam(name="mushroomGrowthDate" ,required = false) Timestamp mushroomGrowthDate
                                    ,@RequestParam(name="mushroomGrowthContent" ,required = false)String mushroomGrowthContent, Model model){
            FarmMushroomGrowth farmMushroomGrowth = farmMushroomGrowthService.getDataGrownInfoByIdx(mushroomGrowthIdx
                    , username
                    , companyInfoIdx
                    , farmDataIdx
                    , cropIdx
                    , mushroomGrowthDaily
                    , mushroomGrowthStatus
                    , mushroomGrowthDate
                    , mushroomGrowthContent);
            List<UserDTO> userList = farmMushroomGrowthService.getUserIdx();
            List<FarmData> farmDataList = farmMushroomGrowthService.getFarmData();
            List<CompanyInfoDTO> companyInfoList = farmMushroomGrowthService.getCompanyInfo();
            List<Crop> cropList = farmMushroomGrowthService.getCropIdx();
            model.addAttribute("userList", userList);
            model.addAttribute("farmDataList", farmDataList);
            model.addAttribute("companyInfoList", companyInfoList);
            model.addAttribute("cropList", cropList);
            log.info("userList = {} ",userList);
            log.info("farmDataList = {} ", farmDataList);
            log.info("companyInfoList = {} ", companyInfoList);
            log.info("cropList = {} ",cropList );

            return "mushroom/modify/modifyDataGrownMushroom";
        }

        @PostMapping("/modify/modifyDataGrownMushroom")
        public String modifyDataGrown(@RequestParam(name="mushroomGrowthIdx" ,required = false)Long mushroomGrowthIdx
                ,@RequestParam(name="username" ,required = false)String username
                ,@RequestParam(name="companyInfoIdx" ,required = false)Long companyInfoIdx
                ,@RequestParam(name="farmDataIdx" ,required = false)Long farmDataIdx
                ,@RequestParam(name="cropIdx" ,required = false)Long cropIdx
                ,@RequestParam(name="mushroomGrowthDaily" ,required = false)int mushroomGrowthDaily
                ,@RequestParam(name="mushroomGrowthStatus" ,required = false)String mushroomGrowthStatus
                ,@RequestParam(name="mushroomGrowthDate" ,required = false) Timestamp mushroomGrowthDate
                ,@RequestParam(name="mushroomGrowthContent" ,required = false)String mushroomGrowthContent){
            farmMushroomGrowthService.modifyDataGrown(mushroomGrowthIdx
                    , username
                    , companyInfoIdx
                    , farmDataIdx
                    , cropIdx
                    , mushroomGrowthDaily
                    , mushroomGrowthStatus
                    , mushroomGrowthDate
                    , mushroomGrowthContent);
            return "redirect:/mushroom/dataGrownMushroom";
        }





        //삭제
        @PostMapping("delete/deleteDataGrownMushroom")
        public String deleteDataGrownMushroom(@RequestParam(name="mushroomGrowthIdx",required = false ) Long mushroomGrowthIdx){

            FarmMushroomGrowth farmMushroomGrowth = farmMushroomGrowthService.getDataGrownInfoByDeleteIdx(mushroomGrowthIdx);
            farmMushroomGrowthService.deleteDataGrown(mushroomGrowthIdx);
            return "redirect:/mushroom/dataGrownMushroom";
        }


      }














