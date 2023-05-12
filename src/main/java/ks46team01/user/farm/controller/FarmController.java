package ks46team01.user.farm.controller;

import jakarta.servlet.http.HttpSession;
import jakarta.websocket.OnClose;
import ks46team01.common.farm.dto.FarmData;
import ks46team01.user.farm.service.UserFarmServiceImpl;
import ks46team01.user.info.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("user/farm")
public class FarmController {
    private final UserFarmServiceImpl userFarmService ;

    public FarmController(UserFarmServiceImpl userFarmService) {
        this.userFarmService = userFarmService;
    }
    @PostMapping("/insertPickupWasted")
    public String wastedPickupInsert(HttpSession session,
                                     Model model,
                                     @RequestParam("farmName") String farmName,
                                     @RequestParam("amount") Long amount,
                                     @RequestParam("zonecode") String zonecode,
                                     @RequestParam("roadAddress") String roadAddress,
                                     @RequestParam("jibunAddress") String jibunAddress,
                                     @RequestParam("detailAddress") String detailAddress,
                                     @RequestParam("phone") String phone,
                                     @RequestParam("message") String message
                                     ){
        System.out.println("중량:"+amount);
        User user = (User) session.getAttribute("user");
        String userId = user.getUsername(); //접속해있는 아이디
        FarmData farmInfo = userFarmService.farmInfo(userId);
        Long companyInfoIdx = farmInfo.getCompanyInfoIdx();
        Long farmDataIdx = farmInfo.getFarmDataIdx();
        String address = roadAddress+jibunAddress+detailAddress;
        HashMap<String, Object> map = new HashMap<>();
        map.put("companyInfoIdx",companyInfoIdx);
        map.put("farmDataIdx",farmDataIdx);
        map.put("userId",userId);
        map.put("amount",amount);
        map.put("address",address);
        map.put("phone",phone);
        map.put("message",message);
        userFarmService.farmPickupInsert(map);
        List<FarmData> farmPickupList = userFarmService.listFarmPickup(userId);
        model.addAttribute("farmPickupList",farmPickupList);
        return "user/farm/listConfirmPickupWasted";
    }
    @GetMapping("/listConfirmPickupWasted")
    public String wastedPickupConfirmList(HttpSession session,
                                          Model model){
        User user = (User) session.getAttribute("user");
        String userId = user.getUsername(); //접속해있는 아이디
        List<FarmData> farmPickupList = userFarmService.listFarmPickup(userId);
        model.addAttribute("farmPickupList",farmPickupList);

        return "user/farm/listConfirmPickupWasted";
    }
    @GetMapping("/listOrderPickupWasted")
    public String wastedPickupOrderList(){

        return "user/farm/listOrderPickupWasted";
    }
    @GetMapping("/listDeliveryPickupWasted")
    public String wastedPickupDeliveryList(HttpSession session,
                                           Model model){

        User user = (User) session.getAttribute("user");
        String userId = user.getUsername(); //접속해있는 아이디
        List<FarmData> farmDeliveryList = userFarmService.listFarmDelivery(userId);
        model.addAttribute("DeliveryList",farmDeliveryList);

        return "user/farm/listDeliveryPickupWasted";
    }
}

