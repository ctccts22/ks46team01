    package ks46team01.mushroom.mushroomCondition.controller;

    import ks46team01.mushroom.mushroomCondition.dto.Crop;
    import ks46team01.mushroom.mushroomCondition.dto.FarmCondition;
    import ks46team01.mushroom.mushroomCondition.mapper.FarmConditionMapper;
    import ks46team01.mushroom.mushroomCondition.service.FarmConditionService;
    import lombok.AllArgsConstructor;
    import lombok.extern.slf4j.Slf4j;
    import org.springframework.stereotype.Controller;
    import org.springframework.ui.Model;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;

    @Controller
    @Slf4j
    @AllArgsConstructor
    @RequestMapping("/mushroom")
    public class FarmConditionController {
        private final FarmConditionService farmConditionService;
        private final FarmConditionMapper farmConditionMapper;

        //조회
        @GetMapping("/conditionMushroom")
        public String farmCondition(Model model) {
            List<FarmCondition> fc = farmConditionService.getFarmCondition();
            List<Crop> cropList = farmConditionService.getCropIdx();
            model.addAttribute("title", "조회");
            model.addAttribute("fc", fc);
            model.addAttribute("cropList", cropList);
            log.info("fc = {} ", fc);
            return "/mushroom/conditionMushroom";
        }
        //입력
        @GetMapping("/add/addConditionMushroom")
        public String showAddFarmConditionForm(Model model) {
            List<Crop> cropList = farmConditionService.getCropIdx();
            model.addAttribute("FarmCondition", new FarmCondition());
            model.addAttribute("cropList", cropList);
            log.info("들어오는값= {}" ,new FarmCondition());
            log.info("들어오는값= {}",cropList);
            return "/mushroom/add/addConditionMushroom";
        }
        @PostMapping("/add/addConditionMushroom")
        public String addFarmCondition(FarmCondition farmCondition) {
                farmConditionService.addFarmCondition(farmCondition) ;
                log.info("입력창  : {}", farmCondition);
                return "redirect:/mushroom/conditionMushroom";

        }
        //수정
        @GetMapping("/modify/modifyConditionMushroom")
        public String modifyFarmCondition(@RequestParam(name = "mushroomConditionIdx",required = false)Long mushroomConditionIdx
                ,@RequestParam(name = "cropIdx",required = false)Long cropIdx
                ,@RequestParam(name = "mushroomConditionTemperature", required = false)String mushroomConditionTemperature
                ,@RequestParam(name = "mushroomConditionHumidity" , required = false) String mushroomConditionHumidity
                ,@RequestParam(name = "mushroomConditionOxygen" , required = false) String mushroomConditionOxygen
                ,@RequestParam(name = "mushroomConditionCo2" , required = false) String mushroomConditionCo2
                ,@RequestParam(name = "mushroomConditionIlluminance" , required = false) String mushroomConditionIlluminance
                ,@RequestParam(name = "mushroomConditionPh" , required = false) String mushroomConditionPh
                ,@RequestParam(name = "mushroomConditionUse", required = false) String mushroomConditionUse
                ,@RequestParam(name = "mushroomConditionYear", required = false) int mushroomConditionYear, Model model){
            FarmCondition farmConditionInfo = farmConditionService.getFarmConditionInfoById(mushroomConditionIdx
                    ,cropIdx
                    ,mushroomConditionTemperature
                    ,mushroomConditionHumidity
                    ,mushroomConditionOxygen
                    ,mushroomConditionIlluminance
                    ,mushroomConditionCo2
                    ,mushroomConditionPh
                    ,mushroomConditionUse
                    ,mushroomConditionYear);
            List<FarmCondition> fc = farmConditionService.getFarmCondition();
            List<Crop> cropList = farmConditionService.getCropIdx();
            model.addAttribute("FarmCondition", new FarmCondition());
            model.addAttribute("cropList", cropList);
            log.info("입력창  : {}", mushroomConditionIdx);
            return "mushroom/modify/modifyConditionMushroom";
        }
        @PostMapping("/modify/modifyConditionMushroom")
        public String modifyFarmCondition(@RequestParam(name = "mushroomConditionIdx",required = false)Long mushroomConditionIdx
                                         ,@RequestParam(name = "cropIdx",required = false)Long cropIdx
                                         ,@RequestParam(name = "mushroomConditionTemperature", required = false)String mushroomConditionTemperature
                                         ,@RequestParam(name = "mushroomConditionHumidity" , required = false) String mushroomConditionHumidity
                                         ,@RequestParam(name = "mushroomConditionOxygen" , required = false) String mushroomConditionOxygen
                                         ,@RequestParam(name = "mushroomConditionCo2" , required = false) String mushroomConditionCo2
                                         ,@RequestParam(name = "mushroomConditionIlluminance" , required = false) String mushroomConditionIlluminance
                                         ,@RequestParam(name = "mushroomConditionPh" , required = false) String mushroomConditionPh
                                         ,@RequestParam(name = "mushroomConditionUse", required = false) String mushroomConditionUse
                                         ,@RequestParam(name = "mushroomConditionYear", required = false) int mushroomConditionYear){
            farmConditionService.modifyFarmCondition(mushroomConditionIdx
                                                    ,cropIdx
                                                    ,mushroomConditionTemperature
                                                    ,mushroomConditionHumidity
                                                    ,mushroomConditionOxygen
                                                    ,mushroomConditionCo2
                                                    ,mushroomConditionIlluminance
                                                    ,mushroomConditionPh
                                                    ,mushroomConditionUse
                                                    ,mushroomConditionYear);

            return "redirect:/mushroom/conditionMushroom";
        }
        //삭제

        @PostMapping("/delete/deleteConditionMushroom")
        public String deleteFarmCondition(@RequestParam(name = "mushroomConditionIdx",required = false)Long mushroomConditionIdx){

            FarmCondition farmConditionInfo = farmConditionService.getFarmConditionInfoByDeleteId(mushroomConditionIdx) ;
            farmConditionService.deleteFarmCondition(mushroomConditionIdx);
            return "redirect:/mushroom/conditionMushroom";
        }





    }






