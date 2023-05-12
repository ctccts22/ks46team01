package ks46team01.admin.coffee.controller;


import ks46team01.admin.coffee.service.CoffeeServiceImpl;
import ks46team01.common.coffee.dto.CoffeeDelivery;
import ks46team01.common.coffee.dto.CoffeeRequest;
import ks46team01.common.coffee.dto.CoffeeRequestConfirm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        System.out.println("listCoffeeAdmin 실행?");
        List<CoffeeRequest> coffeeRequestList = coffeeService.listCoffeeAdmin();
        model.addAttribute("coffeeRequestList",coffeeRequestList);

        return "admin/coffee/listCoffeeAdmin";
    }
    @GetMapping("/listConfirmCoffeeAdmin")
    public String adminCoffeeConfirmList(Model model){
        System.out.println("/listConfirmCoffeeAdmin 실행?");
        List<CoffeeRequestConfirm> coffeeConfirmList = coffeeService.listConfirmCoffee();
        List<CompanyInfo> companyInfoList = coffeeService.listConfirmCompanyInfo();
        System.out.println("null?"+companyInfoList);
        model.addAttribute("coffeeConfirmList",coffeeConfirmList);
        model.addAttribute("companyInfoList",companyInfoList);

        return "admin/coffee/listConfirmCoffeeAdmin";
    }
    @GetMapping("/listDeliveryCoffeeAdmin")
    public String adminCoffeeDeliveryList(Model model){
        System.out.println("/listDeliveryCoffeeAdmin 실행?");
        List<CoffeeDelivery> coffeeDelivery = coffeeService.listCoffeeDelivery();
        model.addAttribute("coffeeDelivery",coffeeDelivery);
        return "admin/coffee/listDeliveryCoffeeAdmin";
    }
    @PostMapping("/insertCoffeeAdmin")
    public String adminCoffeeConfirmInsert(@RequestParam("coffeeIdx") String[] coffeeIdx,
                                           @RequestParam("companyIdx") String[] companyIdx,
                                           @RequestParam("name") String[] name,
                                           @RequestParam("cafeName") String[] cafeName,
                                           @RequestParam("cafePhone") String[] cafePhone,
                                           @RequestParam("cafeAddress") String[] cafeAddress,
                                           @RequestParam("coffeeAmount") String[] coffeeAmount,
                                           @RequestParam("coffeeDate") String[] coffeeDate,
                                           @RequestParam("adminId") String adminId,
                                           @RequestParam("status") String status,
                                           @RequestParam("content") String content,
                                           Model model){
        CoffeeRequestConfirm confirm = new CoffeeRequestConfirm(); // CoffeeRequestConfirm dto 객체생성
//        System.out.println("insertCoffeeAdmin 실행?");
//        System.out.println("coffeeRequestIdx Size:"+coffeeIdx.length);
//        System.out.println("companyIdx Size:"+companyIdx.length);
//        System.out.println("유저네임 size:"+name.length);
//        System.out.println("카페명 size:"+cafeName.length);
//        System.out.println("카페번호 size:"+cafePhone.length);
//        System.out.println("카페주소 size:"+cafeAddress.length);
//        System.out.println("커피찌꺼기중량 size:"+coffeeAmount.length);
//        System.out.println("커피수거신청날짜 size:"+coffeeDate.length);
        if(status.equals("승인")){
            for(int i = 0; i < coffeeIdx.length; i++){
                Long lCoffeeIdx = Long.parseLong(coffeeIdx[i]);
                Long lCompanyIdx = Long.parseLong(companyIdx[i]);
//                System.out.println(i+1+"번폼");
//                System.out.println("coffeeRequestIdx:"+coffeeIdx[i]);
//                System.out.println("companyIdx:"+companyIdx[i]);
//                System.out.println("유저 이름:"+name[i]);
//                System.out.println("카페명:"+cafeName[i]);
//                System.out.println("카페번호:"+cafePhone[i]);
//                System.out.println("카페주소:"+cafeAddress[i]);
//                System.out.println("커피찌꺼기중량:"+coffeeAmount[i]);
//                System.out.println("커피수거신청날짜:"+coffeeDate[i]);
//                System.out.println("admin:"+adminId);
//                System.out.println("status:"+status);
//                System.out.println("content:"+content);
                confirm.setCoffeeRequestIdx(lCoffeeIdx);
                confirm.setCompanyInfoIdx(lCompanyIdx);
                confirm.setUserName(name[i]);
                confirm.setCoffeeRequestConfirmStatus(status);
                confirm.setCoffeeRequestConfirmContent(content);
                confirm.setAdminUsername(adminId);
                coffeeService.insertConfirmCoffeeAdmin(confirm);
            }
        }else if(status.equals("거절")){
            for(int i = 0; i < coffeeIdx.length; i++){
                Long lCoffeeIdx = Long.parseLong(coffeeIdx[i]);
                Long lCompanyIdx = Long.parseLong(companyIdx[i]);
//                System.out.println(i+1+"번폼");
//                System.out.println("coffeeRequestIdx:"+coffeeIdx[i]);
//                System.out.println("companyIdx:"+companyIdx[i]);
//                System.out.println("유저 이름:"+name[i]);
//                System.out.println("카페명:"+cafeName[i]);
//                System.out.println("카페번호:"+cafePhone[i]);
//                System.out.println("카페주소:"+cafeAddress[i]);
//                System.out.println("커피찌꺼기중량:"+coffeeAmount[i]);
//                System.out.println("커피수거신청날짜:"+coffeeDate[i]);
//                System.out.println("admin:"+adminId);
//                System.out.println("status:"+status);
//                System.out.println("content:"+content);
                confirm.setCoffeeRequestIdx(lCoffeeIdx);
                confirm.setCompanyInfoIdx(lCompanyIdx);
                confirm.setUserName(name[i]);
                confirm.setCoffeeRequestConfirmStatus(status);
                confirm.setCoffeeRequestConfirmContent(content);
                confirm.setAdminUsername(adminId);
                coffeeService.insertConfirmCoffeeAdmin(confirm);
            }
        }

        List<CoffeeRequest> coffeeRequestList = coffeeService.listCoffeeAdmin();
        model.addAttribute("coffeeRequestList",coffeeRequestList);
        return "admin/coffee/listCoffeeAdmin";
    }
}