    package ks46team01.mushroom.mushroomFarmData.controller;

    import ks46team01.mushroom.mushroomCondition.dto.FarmCondition;
    import ks46team01.mushroom.mushroomFarmData.dto.FarmData;
    import ks46team01.mushroom.mushroomFarmData.service.FarmDataService;
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
    public class FarmDataController {
        private final FarmDataService farmDataService;

        @GetMapping("/dataFarmMushroom")
        public String farmData(Model model) {
            List<FarmData> fd = farmDataService.getFarmData();
            model.addAttribute("title", "조회");
            model.addAttribute("fd", fd);
            return "mushroom/dataFarmMushroom";
        }

        @PostMapping("/add/addDataFarmMushroom")
        public String addFarmData(FarmData farmData) {
            farmDataService.add(farmData);

            return "redirect:/mushroom/addDataFarmMushroom";
        }
        @GetMapping("/add/addDataFarmMushroom")
        public String addFarmCondition(Model model) {
            model.addAttribute("title", "등록");
            model.addAttribute("farmData", new FarmData());
            return "mushroom/add/addDataFarmMushroom";
        }


    }





