    package ks46team01.mushroom.mushroomCondition.controller;

    import jakarta.servlet.http.HttpSession;
    import ks46team01.admin.info.entity.Admin;
    import ks46team01.mushroom.mushroomCondition.dto.Crop;
    import ks46team01.mushroom.mushroomCondition.dto.FarmCondition;
    import ks46team01.mushroom.mushroomCondition.service.FarmConditionService;
    import lombok.AllArgsConstructor;
    import lombok.extern.slf4j.Slf4j;
    import org.springframework.stereotype.Controller;
    import org.springframework.ui.Model;
    import org.springframework.web.bind.annotation.*;

    import java.sql.Timestamp;
    import java.time.LocalDateTime;
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
            return "mushroom/conditionMushroom";
        }

        @GetMapping("/add/addConditionMushroom")
        public String showAddFarmConditionForm(Model model) {
            model.addAttribute("FarmCondition", new FarmCondition());
            model.addAttribute("Crop", new Crop());
            log.info("들어오는값= {FarmCondition}",new FarmCondition());
            log.info("들어오는값= {Crop}",new Crop());
            return "mushroom/add/addConditionMushroom";
        }
        @PostMapping("/add/addConditionMushroom")
        public String addFarmCondition(FarmCondition farmCondition, HttpSession session) {
            Admin admin = (Admin) session.getAttribute("adminUser");
            if (admin != null) {
                farmCondition.setAdminUsername(String.valueOf(admin));
                farmCondition.setMushroomConditionDate(Timestamp.valueOf(LocalDateTime.now()));

                farmConditionService.addFarmCondition(farmCondition);

                return "redirect:/mushroom/conditionMushroom";
            } else {
                return "redirect:/auth/loginAdmin";
            }
        }



    }






