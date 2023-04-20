package ks46team01.admin.coffee.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/admin/coffee")
public class AdminCoffeeController {

    @GetMapping("/listCoffeeAdmin")
    public String adminCoffeeList(){
        return "/admin/coffee/listCoffeeAdmin";
    }
    @GetMapping("/listConfirmCoffeeAdmin")
    public String adminCoffeeConfirmList(){
        return "/admin/coffee/listConfirmCoffeeAdmin";
    }
    @GetMapping("/listDeliveryCoffeeAdmin")
    public String adminCoffeeDeliveryList(){
        return "/admin/coffee/listDeliveryCoffeeAdmin";
    }
}