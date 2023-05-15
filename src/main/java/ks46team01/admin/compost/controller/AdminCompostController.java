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
import java.util.Random;

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
    @PostMapping("/deliveryCompostInsert")
    public String adminCompostDeliveryInsert(HttpSession session,
                                             Model model,
                                             Random random,
                                             @RequestParam("orderCompostIdx") Long orderCompostIdx,
                                             @RequestParam("companyInfoIdx") Long companyInfoIdx,
                                             @RequestParam("orderCompostConfirmStatus") String orderCompostConfirmStatus,
                                             @RequestParam("username") String username){

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

        OrderCompostDelivery ocd = new OrderCompostDelivery();
        ocd.setUsername(username);
        ocd.setCompanyInfoIdx(companyInfoIdx);
        ocd.setOrderCompostIdx(orderCompostIdx);
        ocd.setOrderCompostDeliveryTrack(shippingNumber);
        ocd.setOrderCompostDeliveryCompany(selectedCompany);
        compostService.orderCompostDeliveryInsert(ocd);

        List<OrderCompostConfirm> confirmList = compostService.orderCompostConfirmList();
        model.addAttribute("confirmList",confirmList);

        return "admin/farm/listConfirmFarmAdmin";
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
            occ.setUsername(userId[i]);
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
