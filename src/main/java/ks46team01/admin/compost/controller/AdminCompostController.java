package ks46team01.admin.compost.controller;

import jakarta.servlet.http.HttpSession;
import ks46team01.admin.compost.service.CompostServiceImpl;
import ks46team01.admin.info.entity.Admin;
import ks46team01.common.compost.dto.OrderCompost;
import ks46team01.common.compost.dto.OrderCompostConfirm;
import ks46team01.common.compost.dto.OrderCompostDelivery;
import ks46team01.user.info.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/admin/compost")
public class AdminCompostController {
    private final CompostServiceImpl compostService;

    public AdminCompostController(CompostServiceImpl compostService) {
        this.compostService = compostService;
    }

    @GetMapping("/listOrderFarmAdmin")
    public String adminFarmOrderList(Model model) {
        List<OrderCompostConfirm> compostList =compostService.orderCompostList();
        model.addAttribute("compostList",compostList);
        return "admin/farm/listOrderFarmAdmin";
    }
    @PostMapping("/insertConfirmCompost")
    public String adminCompostConfirmInsert(@RequestParam("status") String status,
                                            @RequestParam("content") String content,
                                            @RequestParam("companyInfoIdx") Long[] companyInfoIdx,
                                            @RequestParam("orderCompostIdx") Long[] orderCompostIdx,
                                            @RequestParam("userId") String[] userId,
                                            HttpSession session,
                                            Model model
    ){
        OrderCompostConfirm occ = new OrderCompostConfirm();
        Admin admin = (Admin) session.getAttribute("adminUser");
        String adminId = admin.getAdminUsername();
        System.out.println(adminId);
        System.out.println(orderCompostIdx.length+":length???????");
        for(int i = 0; i < orderCompostIdx.length; i++){
            occ.setAdminUsername(adminId);
            occ.setOrderCompostConfirmStatus(status);
            occ.setOrderCompostIdx(orderCompostIdx[i]);
            occ.setCompanyInfoIdx(companyInfoIdx[i]);
            occ.setOrderCompostConfirmContent(content);
            occ.setUserName(userId[i]);
            compostService.orderCompostConfirmInsert(occ);
        }
        List<OrderCompostConfirm> compostList = compostService.orderCompostList();
        model.addAttribute("compostList",compostList);
        return "admin/farm/listOrderFarmAdmin";
    }
    // 커피배지 신청확인 관리
    @GetMapping("/listConfirmFarmAdmin")
    public String adminFarmConfirmList(Model model) {
        List<OrderCompostConfirm> confirmList = compostService.orderCompostConfirmList();
        model.addAttribute("confirmList",confirmList);

        return "admin/farm/listConfirmFarmAdmin";
    }

    // 커피배지 배송관리
    @GetMapping("/listDeliveryFarmAdmin")
    public String adminFarmDeliveryList(Model model) {
        List<OrderCompostDelivery> deliveryList = compostService.orderCompostDeliveryList();
        model.addAttribute("deliveryList",deliveryList);
        return "admin/farm/listDeliveryFarmAdmin";
    }

}
