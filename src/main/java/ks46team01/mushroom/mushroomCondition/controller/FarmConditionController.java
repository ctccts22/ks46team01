    package ks46team01.mushroom.mushroomCondition.controller;

    import ks46team01.mushroom.mushroomCondition.dto.FarmCondition;
    import ks46team01.mushroom.mushroomCondition.dto.Crop;
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

        @GetMapping("/conditionMushroom")
        public String farmCondition(Model model) {
            List<FarmCondition> fc = farmConditionService.getFarmCondition();

            model.addAttribute("title", "조회");
            model.addAttribute("fc", fc);
            return "/mushroom/conditionMushroom";
        }



        @GetMapping("/add/addConditionMushroom")
        public String addFarmCondition(Model model) {

            model.addAttribute("title", "등록");
            model.addAttribute("farmCondition", new FarmCondition());
            List<Crop> cropList = farmConditionService.getCropIdx(new Crop());
            model.addAttribute("cropList", cropList);
            return "/mushroom/add/addConditionMushroom";
        }
        @PostMapping("/add/addConditionMushroom")
        public String addCondition(FarmCondition farmCondition, Crop inputCrop) {
            farmConditionService.add(farmCondition);
            return "redirect:/mushroom/add/addConditionMushroom";
        }





    }






