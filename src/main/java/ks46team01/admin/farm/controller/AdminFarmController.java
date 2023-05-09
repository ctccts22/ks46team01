package ks46team01.admin.farm.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/farm")
public class AdminFarmController {
    //폐배지 수거신청 관리
    @GetMapping("/listRequestPickupFarmAdmin")
    public String adminFarmPickupRequestList() {
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