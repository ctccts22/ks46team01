package ks46team01.admin.coffee.controller;

import ks46team01.admin.coffee.mapper.CoffeeMapper;
import ks46team01.admin.coffee.service.CoffeeService;
import ks46team01.admin.coffee.service.CoffeeServiceImpl;
import ks46team01.common.coffee.dto.CoffeeRequest;
import ks46team01.common.coffee.dto.CoffeeRequestConfirm;
import ks46team01.common.coffee.dto.CompanyInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/admin/coffee")
public class AdminCoffeeController {

    @Autowired
    private CoffeeServiceImpl coffeeService;
    @GetMapping("/listCoffeeAdmin")
    public String adminCoffeeList(){

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
    public String adminCoffeeDeliveryList(){

        return "/admin/coffee/listDeliveryCoffeeAdmin";
    }
}