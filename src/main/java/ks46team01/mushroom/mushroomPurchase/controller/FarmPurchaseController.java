    package ks46team01.mushroom.mushroomPurchase.controller;


    import ks46team01.mushroom.mushroomPurchase.dto.FarmPurchase;
    import ks46team01.mushroom.mushroomPurchase.service.FarmPurchaseService;
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
    public class FarmPurchaseController {
        private final FarmPurchaseService farmPurchaseService;

        @GetMapping("/accountMushroom")
        public String farmPurchase(Model model) {
            List<FarmPurchase> fap = farmPurchaseService.getFarmPurchase();

            model.addAttribute("title", "조회");
            model.addAttribute("fap", fap);


            return "mushroom/accountMushroom";
        }


    }





