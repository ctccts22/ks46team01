package ks46team01.admin.coffee.controller;

import ks46team01.admin.coffee.mapper.CoffeeMapper;
import ks46team01.admin.coffee.service.CoffeeService;
import ks46team01.common.coffee.dto.CoffeeRequestConfirm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/admin/coffee")
public class AdminCoffeeController {

    private CoffeeService coffeeService;
    @GetMapping("/listCoffeeAdmin")
    public String adminCoffeeList(){

        return "/admin/coffee/listCoffeeAdmin";
    }
    @GetMapping("/listConfirmCoffeeAdmin")
    public String adminCoffeeConfirmList(Model model){
        List<CoffeeRequestConfirm> coffeeConfirmList = coffeeService.listConfirmCoffee();
        model.addAttribute("title","커피가루승인상태");
        model.addAttribute("coffeeConfirmList",coffeeConfirmList);
        return "/admin/coffee/listConfirmCoffeeAdmin";
    }
    @GetMapping("/listDeliveryCoffeeAdmin")
    public String adminCoffeeDeliveryList(){
        return "/admin/coffee/listDeliveryCoffeeAdmin";
    }
}