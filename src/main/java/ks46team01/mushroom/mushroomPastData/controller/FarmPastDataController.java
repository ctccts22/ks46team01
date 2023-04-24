    package ks46team01.mushroom.mushroomPastData.controller;

    import ks46team01.mushroom.mushroomGrowth.dto.FarmMushroomGrowth;
    import ks46team01.mushroom.mushroomPastData.dto.FarmPastData;
    import ks46team01.mushroom.mushroomPastData.service.FarmPastDataService;
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
    public class FarmPastDataController {
        private final FarmPastDataService farmPastDataService;

        @GetMapping("/dataPastMushroom")
        public String farmPastData(Model model) {
            List<FarmPastData> fpd = farmPastDataService.getFarmPastData();

            model.addAttribute("title", "조회");
            model.addAttribute("fpd", fpd);
            return "mushroom/dataPastMushroom";
        }

        @PostMapping("/add/addDataPastMushroom")
        public String addFarmPastData(FarmPastData farmPastData) {
            farmPastDataService.add(farmPastData);

            return "redirect:/mushroom/addDataPastMushroom";
        }
        @GetMapping("/add/addDataPastMushroom")
        public String addFarmPastData(Model model) {
            model.addAttribute("title", "등록");
            model.addAttribute("farmPastData", new FarmPastData());
            return "mushroom/add/addDataPastMushroom";
        }



    }





