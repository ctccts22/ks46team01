package ks46team01.user.compost.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/compost")
public class CompostController {

    @GetMapping("/listCompostOrder")
    public String orderCompostList() {
        // 커피 배지 주문신청
        return "user/compost/listCompostOrder";
    }
    @GetMapping("/listConfirmCompostOrder")
    public String orderCompostConfirmList(){
        // 커피배지 승인상태
        return "user/compost/listConfirmCompostOrder";
    }
    @GetMapping("/listDeliveryCompostOrder")
    public String orderCompostDeliveryList(){
        // 커피배송 조회
        return "user/compost/listDeliveryCompostOrder";
    }

}