package ks46team01.user.farm.controller;

import jakarta.servlet.http.HttpSession;
import jakarta.websocket.OnClose;
import ks46team01.common.farm.dto.FarmData;
import ks46team01.common.farm.dto.FarmPickupDelivery;
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
import java.util.Random;

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
        if(user != null){
            String userId = user.getUsername(); //접속해있는 아이디
            List<FarmData> farmPickupList = userFarmService.listFarmPickup(userId);
            model.addAttribute("farmPickupList",farmPickupList);
        }

        return "user/farm/listConfirmPickupWasted";
    }
    @GetMapping("/listOrderPickupWasted")
    public String wastedPickupOrderList(){

        return "user/farm/listOrderPickupWasted";
    }

    @PostMapping("/deliveryInsert")
    public String wastedPickupDeliveryInsert(@RequestParam("companyInfoIdx") Long companyInfoIdx,
                                             @RequestParam("farmPickupRequestIdx") Long farmPickupRequestIdx,
                                             Model model,
                                             HttpSession session,
                                             Random random){
        User user = (User) session.getAttribute("user");
        String userId = user.getUsername(); //접속해있는 아이디
        FarmPickupDelivery fpd = new FarmPickupDelivery();
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
        fpd.setUsername(userId);
        fpd.setFarmPickupRequestIdx(farmPickupRequestIdx);
        fpd.setCompanyInfoIdx(companyInfoIdx);
        fpd.setFarmPickupDeliveryTrack(shippingNumber);
        fpd.setFarmPickupDeliveryCompany(selectedCompany);

        userFarmService.insertDelivery(fpd);

        List<FarmData> farmPickupList = userFarmService.listFarmPickup(userId);
        model.addAttribute("farmPickupList",farmPickupList);

        return "user/farm/listConfirmPickupWasted";
    }
    @GetMapping("/listDeliveryPickupWasted")
    public String wastedPickupDeliveryList(HttpSession session,
                                           Model model){

        User user = (User) session.getAttribute("user");
        if(user != null){
            String userId = user.getUsername(); //접속해있는 아이디
            List<FarmData> farmDeliveryList = userFarmService.listFarmDelivery(userId);
            model.addAttribute("DeliveryList",farmDeliveryList);
        }

        return "user/farm/listDeliveryPickupWasted";
    }
}

