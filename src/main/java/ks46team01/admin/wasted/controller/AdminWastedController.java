package ks46team01.admin.wasted.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/wasted")
public class AdminWastedController {
    // 폐배지 주문신청 관리
    @GetMapping("/listOrderWastedAdmin")
    public String adminWastedOrderList(){
        return "admin/wasted/listOrderWastedAdmin";
    }
    // 폐배지 주문신청확인 관리
    @GetMapping("/listConfirmOrderWastedAdmin")
    public String adminWastedOrderConfirmList(){
        return "admin/wasted/listConfirmOrderWastedAdmin";
    }
    // 폐배지 배송관리
    @GetMapping("/listDeliveryOrderWastedAdmin")
    public String adminWastedOrderDeliveryList(){
        return "admin/wasted/listDeliveryOrderWastedAdmin";
    }
}
