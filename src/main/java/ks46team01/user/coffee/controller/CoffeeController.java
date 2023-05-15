package ks46team01.user.coffee.controller;

import jakarta.servlet.http.HttpSession;
import ks46team01.common.coffee.dto.CoffeeDelivery;
import ks46team01.common.coffee.dto.CoffeeRequestConfirm;
import ks46team01.common.company.info.dto.CompanyInfoDTO;
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
import java.util.Random;

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
    @PostMapping("/deliveryInsert")
    public String coffeeDeliveryInsert(Model model,
                                       HttpSession session,
                                       Random random,
                                       @RequestParam("coffeeRequestIdx") Long coffeeRequestIdx,
                                       @RequestParam("companyInfoIdx") Long companyInfoIdx,
                                       @RequestParam("coffeeRequestConfirmStatus") char coffeeRequestConfirmStatus){
        User user = (User) session.getAttribute("user");
        String userId = user.getUsername();
        String shippingNumber = "";
        // 첫 글자를 대문자로 설정
        shippingNumber += (char)(random.nextInt(26) + 'A');
        // 두 번째부터 열 세 자리는 0~9 사이의 숫자로 설정
        for (int i = 0; i < 3; i++) {
            shippingNumber += random.nextInt(10);
        }
        // 네 번째부터 열 두 자리는 0~25 사이의 알파벳 대문자로 설정
        for (int i = 0; i < 2; i++) {
            shippingNumber += (char)(random.nextInt(26) + 'A');
        }
        // 마지막 열 여섯 자리는 0~9 사이의 숫자로 설정
        for (int i = 0; i < 6; i++) {
            shippingNumber += random.nextInt(10);
        }
        String[] shippingCompanies = {"CJ대한통운", "롯데택배", "우체국택배", "로젠택배", "한진택배",
                "CU 편의점택배", "EMS 택배", "경동택배", "대신택배", "DHL 택배",
                "하이택배", "CVSnet 편의점택배", "합동택배", "천일택배", "APEX 택배",
                "세방 택배", "KGB택배", "SLX 택배", "일양로지스", "홈픽택배"};
        int index = random.nextInt(shippingCompanies.length);

        String selectedCompany = shippingCompanies[index];

        System.out.println(selectedCompany);
        System.out.println(shippingNumber);
        System.out.println(userId);
        System.out.println(coffeeRequestIdx);
        System.out.println(companyInfoIdx);
        System.out.println(coffeeRequestConfirmStatus);
        CoffeeDelivery cd = new CoffeeDelivery();

        cd.setUsername(userId);
        cd.setCoffeeRequestIdx(coffeeRequestIdx);
        cd.setCompanyInfoIdx(companyInfoIdx);
        cd.setCoffeeDeliveryTrack(shippingNumber);
        cd.setCoffeeDeliveryCompany(selectedCompany);
        coffeeService.deliveryInsert(cd);
        List<CoffeeDelivery> userDeliveryList = coffeeService.listCoffeeDelivery(userId);
        model.addAttribute("userDeliveryList", userDeliveryList);
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
        CompanyInfoDTO ci = coffeeService.listCompanyCode(userId);
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