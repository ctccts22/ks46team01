package ks46team01.admin.compost.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/compost")
public class AdminCompostController {
    @GetMapping("/listOrderFarmAdmin")
    public String adminFarmOrderList() {
        return "admin/farm/listOrderFarmAdmin";
    }

    // 커피배지 신청확인 관리
    @GetMapping("/listConfirmFarmAdmin")
    public String adminFarmConfirmList() {
        return "admin/farm/listConfirmFarmAdmin";
    }

    // 커피배지 배송관리
    @GetMapping("/listDeliveryFarmAdmin")
    public String adminFarmDeliveryList() {
        return "admin/farm/listDeliveryFarmAdmin";
    }

}
