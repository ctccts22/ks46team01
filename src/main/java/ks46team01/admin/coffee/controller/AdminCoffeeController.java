package ks46team01.admin.coffee.controller;


import ks46team01.admin.coffee.service.CoffeeServiceImpl;
import ks46team01.common.coffee.dto.CoffeeDelivery;
import ks46team01.common.coffee.dto.CoffeeRequest;
import ks46team01.common.coffee.dto.CoffeeRequestConfirm;
import ks46team01.common.coffee.dto.CompanyInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/admin/coffee")
public class AdminCoffeeController {


    private final CoffeeServiceImpl coffeeService;

    public AdminCoffeeController(CoffeeServiceImpl coffeeService) {
        this.coffeeService = coffeeService;
    }

    @GetMapping("/listCoffeeAdmin")
    public String adminCoffeeList(Model model){
        System.out.println("실행?");
        List<CoffeeRequest> coffeeRequestList = coffeeService.listCoffeeAdmin();
        System.out.println(coffeeRequestList.get(0));
        model.addAttribute("coffeeRequestList",coffeeRequestList);

        return "/admin/coffee/listCoffeeAdmin";
    }
    @GetMapping("/listConfirmCoffeeAdmin")
    public String adminCoffeeConfirmList(Model model){
        System.out.println("/listConfirmCoffeeAdmin 실행?");
        List<CoffeeRequestConfirm> coffeeConfirmList = coffeeService.listConfirmCoffee();
        List<CompanyInfo> companyInfoList = coffeeService.listConfirmCompanyInfo();
        model.addAttribute("coffeeConfirmList",coffeeConfirmList);
        model.addAttribute("companyInfoList",companyInfoList);

        return "/admin/coffee/listConfirmCoffeeAdmin";
    }
    @GetMapping("/listDeliveryCoffeeAdmin")
    public String adminCoffeeDeliveryList(Model model){
        System.out.println("/listDeliveryCoffeeAdmin 실행?");
        List<CoffeeDelivery> coffeeDelivery = coffeeService.listCoffeeDelivery();
        System.out.println(coffeeDelivery.get(0));
        model.addAttribute("coffeeDelivery",coffeeDelivery);
        return "/admin/coffee/listDeliveryCoffeeAdmin";
    }
}