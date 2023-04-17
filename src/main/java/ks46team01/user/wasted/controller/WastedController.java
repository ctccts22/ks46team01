package ks46team01.user.wasted.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/wasted")
public class WastedController {

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