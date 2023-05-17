package ks46team01.admin.farm.controller;


import jakarta.servlet.http.HttpSession;
import ks46team01.admin.farm.service.FarmServiceImpl;
import ks46team01.admin.info.entity.Admin;
import ks46team01.common.farm.dto.FarmPickupConfirm;
import ks46team01.common.farm.dto.FarmPickupDelivery;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    @PostMapping("/updateDelivery")
    public String adminUpdateDelivery(@RequestParam("farmPickupRequestIdx") Long farmPickupRequestIdx,
                                      Model model){
        farmService.updateDelivery(farmPickupRequestIdx);

        List<FarmPickupDelivery> statusList = farmService.farmPickupConfirmStatusList();
        model.addAttribute("statusList",statusList);
        return "admin/farm/listConfirmPickupFarmAdmin";

    }
    @PostMapping("/insertConfirmPickupFarmAdmin")
    public String aminFarmPickupConfirmInsert(@RequestParam("userName") String[] userId,
                                              @RequestParam("companyInfoIdx") Long[] companyInfoIdx,
                                              @RequestParam("farmPickupRequestIdx") Long[] farmPickupRequestIdx,
                                              @RequestParam("status") String status,
                                              @RequestParam("content") String content,
                                              HttpSession session,
                                              Model model){
        Admin admin = (Admin) session.getAttribute("adminUser");
        String adminId = admin.getAdminUsername();
        FarmPickupConfirm farmPickupConfirm = new FarmPickupConfirm();
        farmPickupConfirm.setAdminUsername(adminId);
        farmPickupConfirm.setFarmPickupConfirmContent(content);
        farmPickupConfirm.setFarmPickupConfirmStatus(status);
        for(int i = 0; i < farmPickupRequestIdx.length; i++){
        farmPickupConfirm.setFarmPickupRequestIdx(farmPickupRequestIdx[i]);
        farmPickupConfirm.setCompanyInfoIdx(companyInfoIdx[i]);
        farmPickupConfirm.setUsername(userId[i]);
        farmService.farmPickupConfirmInsert(farmPickupConfirm);
        }
        System.out.println(content);
        System.out.println(status);
        System.out.println(adminId);
        List<FarmPickupConfirm> farmPickupConfirmList = farmService.farmPickupConfirmList();
        model.addAttribute("confirmList",farmPickupConfirmList);
        return "admin/farm/listRequestPickupFarmAdmin";
    }

    // 폐배지 수거신청확인 관리
    @GetMapping("/listConfirmPickupFarmAdmin")
    public String adminFarmPickupConfirmList(Model model) {
        List<FarmPickupDelivery> statusList = farmService.farmPickupConfirmStatusList();
        model.addAttribute("statusList",statusList);
        return "admin/farm/listConfirmPickupFarmAdmin";
    }


    // 폐배지 수거배송 관리
    @GetMapping("/listDeliveryPickupFarmAdmin")
    public String adminFarmPickupDeliveryList(Model model) {
        List<FarmPickupDelivery> deliveryList = farmService.farmPickupDeliveryList();
        model.addAttribute("deliveryList",deliveryList);
        return "admin/farm/listDeliveryPickupFarmAdmin";
    }

    // 작물 고유코드
    @GetMapping("/listCodeCrop")
    public String cropCodeList() {
        return "admin/farm/listCodeCrop";
    }
}