package ks46team01.admin.wasted.controller;


import jakarta.servlet.http.HttpSession;
import ks46team01.admin.info.entity.Admin;
import ks46team01.admin.wasted.service.WastedServiceImpl;
import ks46team01.common.wasted.dto.OrderWastedConfirm;
import ks46team01.common.wasted.dto.OrderWastedDelivery;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/admin/wasted")
public class AdminWastedController {
    private final WastedServiceImpl wastedService;

    public AdminWastedController(WastedServiceImpl wastedService) {
        this.wastedService = wastedService;
    }

    // 폐배지 주문신청 관리
    @GetMapping("/listOrderWastedAdmin")
    public String adminWastedOrderList(Model model){
        List<OrderWastedConfirm> wastedList = wastedService.wastedList();
        model.addAttribute("wastedList",wastedList);
        return "admin/wasted/listOrderWastedAdmin";
    }
    // 폐배지 주문신청확인 관리
    @GetMapping("/listConfirmOrderWastedAdmin")
    public String adminWastedOrderConfirmList(Model model){
        List<OrderWastedConfirm> wastedList = wastedService.wastedConfirmList();
        model.addAttribute("wastedList",wastedList);
        return "admin/wasted/listConfirmOrderWastedAdmin";
    }
    @PostMapping("insertConfirmOrderWastedAdmin")
    public String adminWastedOrderConfirmInsert(@RequestParam("userName") String[] userId,
                                                @RequestParam("status") String status,
                                                @RequestParam("content") String content,
                                                @RequestParam("orderWastedIdx") Long[] orderWastedIdx,
                                                @RequestParam("companyInfoIdx") Long[] companyInfoIdx,
                                                Model model,
                                                HttpSession session){
        OrderWastedConfirm orderWastedConfirm = new OrderWastedConfirm();
        Admin admin = (Admin) session.getAttribute("adminUser");
        String adminId = admin.getAdminUsername();
        orderWastedConfirm.setAdminUsername(adminId);
        orderWastedConfirm.setOrderWastedConfirmContent(content);
        orderWastedConfirm.setOrderWastedConfirmStatus(status);
        for(int i = 0; i < orderWastedIdx.length; i++){
            orderWastedConfirm.setUserName(userId[i]);
            orderWastedConfirm.setOrderWastedIdx(orderWastedIdx[i]);
            orderWastedConfirm.setCompanyInfoIdx(companyInfoIdx[i]);
            wastedService.wastedConfirmInsert(orderWastedConfirm);
        }

        List<OrderWastedConfirm> wastedList = wastedService.wastedList();
        model.addAttribute("wastedList",wastedList);
        return "admin/wasted/listOrderWastedAdmin";
    }
    // 폐배지 배송관리
    @GetMapping("/listDeliveryOrderWastedAdmin")
    public String adminWastedOrderDeliveryList(Model model){
        List<OrderWastedDelivery> deliveryList = wastedService.wastedDeliveryList();
        model.addAttribute("deliveryList",deliveryList);
        return "admin/wasted/listDeliveryOrderWastedAdmin";
    }
}