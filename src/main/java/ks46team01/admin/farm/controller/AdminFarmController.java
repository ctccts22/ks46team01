package ks46team01.admin.farm.controller;


import ks46team01.admin.farm.service.FarmServiceImpl;
import ks46team01.common.farm.dto.FarmPickupConfirm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin/farm")
public class AdminFarmController {
    private final FarmServiceImpl farmService;

    public AdminFarmController(FarmServiceImpl farmService) {
        this.farmService = farmService;
    }

    //폐배지 수거신청 관리
    @GetMapping("/listRequestPickupFarmAdmin")
    public String adminFarmPickupRequestList(Model model) {
        List<FarmPickupConfirm> farmPickupConfirmList = farmService.farmPickupConfirmList();
        model.addAttribute("confirmList",farmPickupConfirmList);

        return "admin/farm/listRequestPickupFarmAdmin";
    }

    // 폐배지 수거신청확인 관리
    @GetMapping("/listConfirmPickupFarmAdmin")
    public String adminFarmPickupConfirmList() {
        return "admin/farm/listConfirmPickupFarmAdmin";
    }


    // 폐배지 수거배송 관리
    @GetMapping("/listDeliveryPickupFarmAdmin")
    public String adminFarmPickupDeliveryList() {
        return "admin/farm/listDeliveryPickupFarmAdmin";
    }

    // 작물 고유코드
    @GetMapping("/listCodeCrop")
    public String cropCodeList() {
        return "admin/farm/listCodeCrop";
    }
}