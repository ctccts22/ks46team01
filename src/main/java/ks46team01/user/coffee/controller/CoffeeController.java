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
    public String coffeeRequestInsertForm() {
        log.info("/coffee_request 실행?");
        return "/user/coffee/insertRequestCoffeeForm";
    }

    @GetMapping("/listConfirmRequestCoffee")
    public String coffeeRequestConfirmList() {
        log.info("/coffeeRequestConfirm 실행?");
        return "/user/coffee/listConfirmRequestCoffee";
    }

    @GetMapping("/listDeliveryCoffee")
    public String coffeeDeliveryList() {
        return "/user/coffee/listDeliveryCoffee";
    }

    //커피 수거신청기능
    @GetMapping("/insertRequestCoffee")
    public String coffeeRequestInsert(@RequestParam(value = "r_coffee") String coffee, //카페명
                                      @RequestParam(value = "r_amount") String amount, //중량
                                      @RequestParam(value = "r_date") String date, // 날짜
                                      @RequestParam(value = "r_time") String time, //시간
                                      @RequestParam(value = "zonecode")String zonecode,
                                      @RequestParam(value = "roadAddress")String roadAddress,
                                      @RequestParam(value = "jibunAddress")String jibunAddress,
                                      @RequestParam(value = "detailAddress")String detailAddress,
                                      @RequestParam(value = "r_phone") String phone, //휴대폰번호
                                      @RequestParam(value = "r_message") String message) { //상세내용
        String address = zonecode+roadAddress+jibunAddress+detailAddress;
        String requestDate = date+time;
        System.out.println(coffee);
        System.out.println(amount+"kg");
        System.out.println(address);
        System.out.println(requestDate);
        System.out.println(phone);
        System.out.println(message);

        return "/user/coffee/listConfirmRequestCoffee";
    }
}