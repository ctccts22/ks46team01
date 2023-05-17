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
import java.util.Random;

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
    @PostMapping("/InsertDelivery")
    public String adminWastedDeliveryInsert(@RequestParam("orderWastedIdx") Long orderWastedIdx,
                                            @RequestParam("companyInfoIdx") Long companyInfoIdx,
                                            @RequestParam("username") String username,
                                            Model model,
                                            Random random){
        String shippingNumber = "";
        // 첫 글자를 대문자로 설정
        shippingNumber += (char)(random.nextInt(26) + 'A');
        // 두 번째부터 열 세 자리는 0~9 사이의 숫자로 설정
        for (int i = 0; i < 3; i++) {
            shippingNumber += random.nextInt(10);
        }
        // 네 번째부터 열 두 자리는 0~25 사이의 알파벳 대문자로 설정
        for (int i = 0; i < 2; i++) {
            shippingNumber += (char)(random.nextInt(26) + 'A');
        }
        // 마지막 열 여섯 자리는 0~9 사이의 숫자로 설정
        for (int i = 0; i < 6; i++) {
            shippingNumber += random.nextInt(10);
        }
        String[] shippingCompanies = {"CJ대한통운", "롯데택배", "우체국택배", "로젠택배", "한진택배",
                "CU 편의점택배", "EMS 택배", "경동택배", "대신택배", "DHL 택배",
                "하이택배", "CVSnet 편의점택배", "합동택배", "천일택배", "APEX 택배",
                "세방 택배", "KGB택배", "SLX 택배", "일양로지스", "홈픽택배"};
        int index = random.nextInt(shippingCompanies.length);

        String selectedCompany = shippingCompanies[index];
        OrderWastedDelivery owd = new OrderWastedDelivery();
        owd.setOrderWastedIdx(orderWastedIdx);
        owd.setCompanyInfoIdx(companyInfoIdx);
        owd.setUserName(username);
        owd.setOrderWastedDeliveryCompany(selectedCompany);
        owd.setOrderWastedDeliveryTrack(shippingNumber);
        wastedService.wastedDeliveryInsert(owd);

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