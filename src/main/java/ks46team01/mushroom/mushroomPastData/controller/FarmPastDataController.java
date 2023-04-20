    package ks46team01.mushroom.mushroomPastData.controller;

    import ks46team01.mushroom.mushroomPastData.dto.FarmPastData;
    import ks46team01.mushroom.mushroomPastData.service.FarmPastDataService;
    import lombok.AllArgsConstructor;
    import lombok.extern.slf4j.Slf4j;
    import org.springframework.stereotype.Controller;
    import org.springframework.ui.Model;
    import org.springframework.web.bind.annotation.GetMapping;
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


    }





