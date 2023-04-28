    package ks46team01.mushroom.mushroomFarmData.controller;

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
            List<FarmData> farmDataList = farmDataService.getFarmDataList();
            log.info("들어가는값 = {} ",farmDataList );
            model.addAttribute("title", "조회");
            model.addAttribute("farmDataList", farmDataList);
            log.info("들어가는값 = {} ", farmDataList);
            return "mushroom/dataFarmMushroom";
        }

        @PostMapping("/add/addDataFarmMushroom")
        public String addFarmData(FarmData farmData) {
            farmDataService.add(farmData);

            return "mushroom/add/addDataFarmMushroom";
        }
        @GetMapping("/add/addDataFarmMushroom")
        public String addDataFarmMushroom(Model model) {
            model.addAttribute("title", "등록");
            model.addAttribute("farmData", new FarmData());
            log.info("farmData ={}", new FarmData());
            return "redirect:/mushroom/addDataFarmMushroom";
        }


    }





