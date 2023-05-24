package ks46team01.user.wasted.controller;

import jakarta.servlet.http.HttpSession;
import ks46team01.common.wasted.dto.CompanyDTO;
import ks46team01.user.info.entity.User;
import ks46team01.user.wasted.service.UserWastedServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/user/wasted")
public class WastedController {
    private final UserWastedServiceImpl userWastedService;

    public WastedController(UserWastedServiceImpl userWastedService) {
        this.userWastedService = userWastedService;
    }

    @PostMapping("/insertWasted")
    public String wastedInsert(@RequestParam("farmName") String farmName,
                               @RequestParam("amount") Long amount,
                               @RequestParam("zonecode") String zonecode,
                               @RequestParam("roadAddress") String roadAddress,
                               @RequestParam("jibunAddress") String jibunAddress,
                               @RequestParam("detailAddress") String detailAddress,
                               @RequestParam("phone") String phone,
                               @RequestParam("message") String message,
                               HttpSession session,
                               Model model) {
        System.out.println(farmName);
        System.out.println(amount);
        String address = zonecode + roadAddress + jibunAddress + detailAddress;
        System.out.println(phone);
        System.out.println(message);
        User user = (User) session.getAttribute("user");
        String sessionId = user.getUsername(); //접속해있는 아이디
        CompanyDTO cd = userWastedService.companyInfo(sessionId);
        System.out.println(cd.getCompanyInfoIdx());
        System.out.println(cd.getCompanyUnitIdx());
        System.out.println(cd.getCompanyContractIdx());
        Long companyInfoIdx = cd.getCompanyInfoIdx();
        Long companyUnitIdx = cd.getCompanyUnitIdx();
        Long companyContractIdx = cd.getCompanyContractIdx();
        HashMap<String, Object> map = new HashMap<>();
        map.put("userId", sessionId); //아이디
        map.put("address", address); //주소
        map.put("phone", phone); //번호
        map.put("amount", amount); //증량
        map.put("message", message); //내용
        map.put("companyInfoIdx", companyInfoIdx);
        map.put("companyUnitIdx", companyUnitIdx);
        map.put("companyContractIdx", companyContractIdx);
        userWastedService.insertWasted(map);
        List<CompanyDTO> wastedList = userWastedService.listWasted(sessionId);
        model.addAttribute("wastedList", wastedList);
        return "user/wasted/listConfirmWasted";
    }
    @PostMapping("/updateDelivery")
    public String wastedDeliveryUpdate(@RequestParam("orderWastedDeliveryIdx") Long orderWastedDeliveryIdx,
                                       Model model,
                                       HttpSession session){
        userWastedService.wastedDeliveryUpdate(orderWastedDeliveryIdx);

        User user = (User) session.getAttribute("user");
        String sessionId = user.getUsername(); //접속해있는 아이디

        List<CompanyDTO> wastedDeliveryList = userWastedService.listDelivery(sessionId);

        model.addAttribute("DeliveryList", wastedDeliveryList);
        return "user/wasted/listDeliveryWasted";
    }
    @GetMapping("/listConfirmWasted")
    public String wastedConfirmList(HttpSession session,
                                    Model model) {
        User user = (User) session.getAttribute("user");
        if(user != null){
        String sessionId = user.getUsername(); //접속해있는 아이디

        List<CompanyDTO> wastedList = userWastedService.listWasted(sessionId);
        model.addAttribute("wastedList", wastedList);
        }
        return "user/wasted/listConfirmWasted";
    }

    @GetMapping("/listDeliveryWasted")
    public String wastedDeliveryList(HttpSession session,
                                     Model model) {
        User user = (User) session.getAttribute("user");
        if(user != null){
        String sessionId = user.getUsername(); //접속해있는 아이디

        List<CompanyDTO> wastedDeliveryList = userWastedService.listDelivery(sessionId);

        model.addAttribute("DeliveryList", wastedDeliveryList);

        }
        return "user/wasted/listDeliveryWasted";
    }

    @GetMapping("/listOrderWasted")
    public String wastedOrderList() {
        return "user/wasted/listOrderWasted";
    }

}

