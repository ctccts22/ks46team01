    package ks46team01.mushroom.mushroomFarmData.controller;

    import ks46team01.mushroom.mushroomFarmData.dto.FarmData;
    import ks46team01.mushroom.mushroomFarmData.service.FarmDataService;
    import ks46team01.mushroom.mushroomGrowth.dto.FarmMushroomGrowth;
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
        public String farmData(Model model
                                ,@RequestParam(name="searchKey", required = false) String searchKey
                                ,@RequestParam(name="searchValue", required = false) String searchValue) {
            List<FarmData> farmDataList = farmDataService.getFarmDataList(searchKey,searchValue);
            model.addAttribute("title", "조회");
            model.addAttribute("farmDataList", farmDataList);
            log.info("search 들어가는값 = {} ", farmDataList);
            return "mushroom/dataFarmMushroom";
        }


        @GetMapping("/add/addDataFarmMushroom")
        public String addDataFarmMushroom(Model model) {
            model.addAttribute("title", "등록");
            model.addAttribute("farmData", new FarmData());
            log.info("get farmData ={}", new FarmData());
            return "mushroom/add/addDataFarmMushroom";
        }
        @PostMapping("/add/addDataFarmMushroom")
        public String addFarmData(FarmData farmData) {
            farmDataService.add(farmData);
            log.info("post farmData ={}", new FarmData());
            return "redirect:mushroom/add/addDataFarmMushroom";
        }






    }





