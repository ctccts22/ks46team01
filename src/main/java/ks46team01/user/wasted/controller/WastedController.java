package ks46team01.user.wasted.controller;

import jakarta.servlet.http.HttpSession;
import ks46team01.user.info.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user/wasted")
public class WastedController {
    @PostMapping("/insertWasted")
    public String wastedInsert(@RequestParam("farmName") String farmName,
                               @RequestParam("amount") Long amount,
                               @RequestParam("zonecode" )String zonecode,
                               @RequestParam("roadAddress") String roadAddress,
                               @RequestParam("jibunAddress") String jibunAddress,
                               @RequestParam("detailAddress") String detailAddress,
                               @RequestParam("phone") String phone,
                               @RequestParam("message") String message,
                               HttpSession session){
        System.out.println(farmName);
        System.out.println(amount);
        String Address = zonecode+roadAddress+jibunAddress+detailAddress;
        System.out.println(phone);
        System.out.println(message);
        User user = (User) session.getAttribute("user");
        String sessionId = user.getUsername(); //접속해있는 아이디

        return "user/wasted/listConfirmPickupWasted";
    }

    @GetMapping("/listConfirmWasted")
    public String wastedConfirmList(){

        return "user/wasted/listConfirmWasted";
    }
    @GetMapping("/listDeliveryWasted")
    public String wastedDeliveryList(){
        return "user/wasted/listDeliveryWasted";
    }

    @GetMapping("/listOrderWasted")
    public String wastedOrderList(){
        return "user/wasted/listOrderWasted";
    }

    @GetMapping("/listConfirmPickupWasted")
    public String wastedPickupConfirmList(){
        return "user/wasted/listConfirmPickupWasted";
    }

    @GetMapping("/listDeliveryPickupWasted")
    public String wastedPickupDeliveryList(){
        return "user/wasted/listDeliveryPickupWasted";
    }

    @GetMapping("/listOrderPickupWasted")
    public String wastedPickupOrderList(){
        return "user/wasted//listOrderPickupWasted";
    }

}