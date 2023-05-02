    package ks46team01.mushroom.mushroomCondition.controller;

    import jakarta.servlet.http.HttpSession;
    import ks46team01.admin.info.dto.AdminDTO;
    import ks46team01.admin.info.entity.Admin;
    import ks46team01.mushroom.mushroomCondition.dto.Crop;
    import ks46team01.mushroom.mushroomCondition.dto.FarmCondition;
    import ks46team01.mushroom.mushroomCondition.service.FarmConditionService;
    import lombok.AllArgsConstructor;
    import lombok.extern.slf4j.Slf4j;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.stereotype.Controller;
    import org.springframework.ui.Model;
    import org.springframework.web.bind.annotation.*;

    import java.sql.Timestamp;
    import java.time.LocalDateTime;
    import java.util.Collections;
    import java.util.List;
    import java.util.Optional;

    @Controller
    @Slf4j
    @AllArgsConstructor
    @RequestMapping("/mushroom")
    public class FarmConditionController {
        private final FarmConditionService farmConditionService;

        @GetMapping("/conditionMushroom")
        public String farmCondition(Model model, @RequestParam(value = "mushroomConditionIdx", required = false) String mushroomConditionIdx) {
           log.info("mushroomConditionIdx={}",mushroomConditionIdx);
            List<FarmCondition> fc;
            if (mushroomConditionIdx != null && !mushroomConditionIdx.isEmpty()) {
                Optional<FarmCondition> farmConditionOptional = farmConditionService.getMushroomByConditionIdx(mushroomConditionIdx);
                fc = farmConditionOptional.map(Collections::singletonList).orElse(Collections.emptyList());
            } else {
                fc = farmConditionService.getAllFarmCondition();
            }
            model.addAttribute("fc", fc);
            log.info("fc = {} ", fc);
            return "mushroom/conditionMushroom";
        }


        @GetMapping("/add/addConditionMushroom")
        public String showAddFarmConditionForm(Model model) {
            List<Crop> cropList = farmConditionService.getCropIdx();
            model.addAttribute("FarmCondition", new FarmCondition());
            model.addAttribute("cropList", cropList);
            log.info("들어오는값= {}", new FarmCondition());
            log.info("들어오는값= {}", cropList);
            return "mushroom/add/addConditionMushroom";
        }

        @PostMapping("/add/addConditionMushroom")
        public String addFarmCondition(FarmCondition farmCondition, HttpSession session) {
            AdminDTO admin = (AdminDTO) session.getAttribute("adminUser");
            if (admin != null) {
                farmConditionService.addFarmCondition(farmCondition);

                return "redirect:/mushroom/conditionMushroom";
            } else {
                return "redirect:/auth/loginAdmin";
            }
        }







    }


/*

        @PostMapping("/modifyFarmCondition")
        public String modifyAdmin(@RequestParam("mushroomConditionIdx") String mushroomConditionIdx,
                                  @RequestParam("cropIdx") String cropIdx,
                                  @RequestParam("mushroomConditionTemperature") String mushroomConditionTemperature,
                                  @RequestParam("mushroomConditionHumidity") String mushroomConditionHumidity,
                                  @RequestParam("mushroomConditionOxygen") String mushroomConditionOxygen,
                                  @RequestParam("mushroomConditionCo2") String mushroomConditionCo2,
                                  @RequestParam("mushroomConditionIlluminance") String mushroomConditionIlluminance,
                                  @RequestParam("mushroomConditionPh") String mushroomConditionPh,
                                  @RequestParam("mushroomConditionYear") String mushroomConditionYear,
                                  @RequestParam("mushroomConditionUse") String mushroomConditionUse,
                                  @RequestParam("mushroomConditionDate") String mushroomConditionDate,
                                  Model model) {
            Admin modifyFarmCondition = farmConditionService.modifyFarmCondition(mushroomConditionIdx, cropIdx, mushroomConditionTemperature, mushroomConditionHumidity , mushroomConditionOxygen ,mushroomConditionCo2 , mushroomConditionIlluminance,mushroomConditionPh, mushroomConditionYear , mushroomConditionUse, mushroomConditionDate );

            if (modifyFarmCondition == null) {
                model.addAttribute("에러", "실패했습니다.");
            } else {
                model.addAttribute("성공", "성공했습니다.");
            }
            return "redirect:/mushroom/conditionMushroom";
        }
*/










