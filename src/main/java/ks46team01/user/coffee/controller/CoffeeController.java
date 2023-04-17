package ks46team01.user.coffee.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/user/coffee")
public class CoffeeController {

    @GetMapping("/listRequestCoffee")
    public String coffeeRequestList(){
        log.info("/coffee_request 실행?");
        return "/user/coffee/listRequestCoffee";
    }
    @GetMapping("/listConfirmRequestCoffee")
    public String coffeeRequestConfirmList(){
        log.info("/coffeeRequestConfirm 실행?");
        return "/user/coffee/listConfirmRequestCoffee";
    }
    @GetMapping("/listDeliveryCoffee")
    public String coffeeDeliveryList(){
        return "/user/coffee/listDeliveryCoffee";
    }

}