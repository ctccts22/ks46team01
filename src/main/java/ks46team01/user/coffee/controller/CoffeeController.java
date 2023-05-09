package ks46team01.user.coffee.controller;

import jakarta.servlet.http.HttpSession;
import ks46team01.common.coffee.dto.CoffeeDelivery;
import ks46team01.common.coffee.dto.CoffeeRequestConfirm;
import ks46team01.common.coffee.dto.CompanyInfo;
import ks46team01.user.coffee.service.UserCoffeeServiceImpl;
import ks46team01.user.info.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("/user/coffee")
public class CoffeeController {
    private final UserCoffeeServiceImpl coffeeService;

    public CoffeeController(UserCoffeeServiceImpl coffeeService) {
        this.coffeeService = coffeeService;
    }


    @GetMapping("/insertRequestCoffeeForm") //inserRequestCoffeeForm 페이지로 이동
    public String coffeeRequestInsertForm() {
        log.info("/coffee_request 실행?");
        return "user/coffee/insertRequestCoffeeForm";
    }

    @GetMapping("/listConfirmRequestCoffee") //유저 커피가루 신청상태 확인
    public String coffeeRequestConfirmList(Model model,
                                           HttpSession session) {
        log.info("/coffeeRequestConfirm 실행?");

        User user = (User) session.getAttribute("user");
        String userId = user.getUsername();
        System.out.println("userId:" + userId);
            List<CoffeeRequestConfirm> userConfirmList = coffeeService.listCoffeeConfirm(userId);
            model.addAttribute("userConfirmList", userConfirmList);

        return "user/coffee/listConfirmRequestCoffee";
    }

    @GetMapping("/listDeliveryCoffee")

    public String coffeeDeliveryList(Model model,
                                     HttpSession session) {
        System.out.println("/listDeliveryCoffee 실행?");
        User user = (User) session.getAttribute("user");
        String userId = user.getUsername();
        System.out.println(userId);

            List<CoffeeDelivery> userDeliveryList = coffeeService.listCoffeeDelivery(userId);
            model.addAttribute("userDeliveryList", userDeliveryList);
            System.out.println("실행????????");

        return "user/coffee/listDeliveryCoffee";
    }

    @GetMapping("/coffeeDeliveryList")
    public String coffeeDeliveryList() {
        return "user/coffee/listDeliveryCoffee";
    }

    @PostMapping("/insertRequestCoffee")
    public String coffeeRequestInsert(
            @RequestParam(value = "r_coffee") String coffee,
            @RequestParam(value = "r_amount") String amount,
            @RequestParam(value = "zonecode") String zonecode,
            @RequestParam(value = "roadAddress") String roadAddress,
            @RequestParam(value = "jibunAddress") String jibunAddress,
            @RequestParam(value = "detailAddress") String detailAddress,
            @RequestParam(value = "r_phone") String phone,
            @RequestParam(value = "r_message") String message,
            HttpSession session,
            Model model) {

        String address = zonecode + roadAddress + jibunAddress + detailAddress;
        User user = (User) session.getAttribute("user");
        String userId = user.getUsername();
        System.out.println("아이디:" + userId);
        CompanyInfo ci = coffeeService.listCompanyCode(userId);
        System.out.println(ci.getCompanyInfoIdx());
        Long companyInfoIdx = ci.getCompanyInfoIdx();
        HashMap<String, Object> map = new HashMap<>();
        map.put("userId", userId);
        map.put("amount", amount);
        map.put("address", address);
        map.put("phone", phone);
        map.put("message", message);
        map.put("companyInfoIdx", companyInfoIdx);
        int result = coffeeService.insertCoffeeRequest(map);
        System.out.println(result + "쿼리결과확인");
        List<CoffeeRequestConfirm> userConfirmList = coffeeService.listCoffeeConfirm(userId);
        model.addAttribute("userConfirmList", userConfirmList);

        return "user/coffee/listConfirmRequestCoffee";
    }
}