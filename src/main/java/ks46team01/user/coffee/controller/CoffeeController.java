package ks46team01.user.coffee.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
@RequestMapping("/user/coffee")
public class CoffeeController {

    @GetMapping("/insertRequestCoffeeForm")
    public String coffeeRequestInsertForm(){
        log.info("/coffee_request 실행?");
        return "/user/coffee/insertRequestCoffeeForm";
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
    
    //커피 수거신청기능
    @PostMapping("/insertRequestCoffee")
    public String coffeeRequestInsert(@RequestParam(value = "r_coffee")String coffee){
        System.out.println(coffee);
        return "/user/coffee/listConfirmRequestCoffee";
    }
}