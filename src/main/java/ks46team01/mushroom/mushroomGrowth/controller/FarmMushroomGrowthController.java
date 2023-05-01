    package ks46team01.mushroom.mushroomGrowth.controller;

    import ks46team01.mushroom.mushroomFarmData.dto.FarmData;
    import ks46team01.mushroom.mushroomGrowth.dto.FarmMushroomGrowth;
    import ks46team01.mushroom.mushroomGrowth.service.FarmMushroomGrowthService;
    import lombok.AllArgsConstructor;
    import lombok.extern.slf4j.Slf4j;
    import org.springframework.stereotype.Controller;
    import org.springframework.ui.Model;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.PostMapping;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RequestParam;

    import java.util.List;

    @Controller
    @Slf4j
    @AllArgsConstructor
    @RequestMapping("/mushroom")
    public class FarmMushroomGrowthController {
        private final FarmMushroomGrowthService farmMushroomGrowthService;

        @GetMapping("/dataGrownMushroom")
        public String farmMushroomGrowthService(Model model
                        , @RequestParam(name = "searchKey", required = false) String searchKey
                        , @RequestParam(name = "searchValue", required = false) String searchValue) {
            List<FarmMushroomGrowth> fmsg = farmMushroomGrowthService.getFarmMushroomGrowth(searchKey, searchValue);
            model.addAttribute("title", "조회");
            model.addAttribute("fmsg", fmsg);
            log.info("search 들어가는값 = {} ", fmsg);
            return "mushroom/dataGrownMushroom";
        }


        @GetMapping("/add/addDataGrownMushroom")
        public String addDataGrown(Model model) {
            model.addAttribute("title", "등록");
            model.addAttribute("farmMushroomGrowth", new FarmMushroomGrowth());
            return "mushroom/add/addDataGrownMushroom";
        }
        @PostMapping("/add/addDataGrownMushroom")
        public String addDataGrown(FarmMushroomGrowth farmMushroomGrowth) {
            farmMushroomGrowthService.add(farmMushroomGrowth);

            return "redirect:mushroom/addDataGrownMushroom";
        }
      }














