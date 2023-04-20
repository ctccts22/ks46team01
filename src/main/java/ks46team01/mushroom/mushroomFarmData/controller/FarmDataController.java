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
            List<FarmData> fd = farmDataService.getFarmData();

            model.addAttribute("title", "조회");
            model.addAttribute("fd", fd);


            return "mushroom/dataFarmMushroom";
        }


    }





