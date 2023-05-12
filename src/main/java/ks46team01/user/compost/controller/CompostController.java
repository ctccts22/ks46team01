package ks46team01.user.compost.controller;

import jakarta.servlet.http.HttpSession;
import ks46team01.common.compost.dto.CompanyContract;
import ks46team01.common.compost.dto.OrderCompostConfirm;
import ks46team01.common.compost.dto.OrderCompostDelivery;
import ks46team01.user.compost.service.UserCompostOrderServiceImpl;
import ks46team01.user.info.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/user/compost")
public class CompostController {
    private final UserCompostOrderServiceImpl userCompostOrderService;

    public CompostController(UserCompostOrderServiceImpl userCompostOrderService) {
        this.userCompostOrderService = userCompostOrderService;
    }

    @GetMapping("/listCompostOrder")
    public String orderCompostList() {
        // 커피 배지 주문신청
        return "user/compost/listCompostOrder";
    }
    @GetMapping("/insertCompostOrder")
    public String insertCompostList(Model model,
                                    @RequestParam("amount") Long amount,
                                    @RequestParam(value = "zonecode") String zonecode,
                                    @RequestParam(value = "roadAddress") String roadAddress,
                                    @RequestParam(value = "jibunAddress") String jibunAddress,
                                    @RequestParam(value = "detailAddress") String detailAddress,
                                    @RequestParam("phone") String phone,
                                    @RequestParam("message") String message,
                                    HttpSession session
                                    ){
        System.out.println("우편번호:"+zonecode);
        System.out.println("roadAddress:"+roadAddress);
        System.out.println("jibunAddress:"+jibunAddress);
        System.out.println("detailAddress:"+detailAddress);
        System.out.println("중량:"+amount);
        System.out.println("휴대폰번호:"+ phone);
        System.out.println("message:"+message);
        String address = roadAddress+jibunAddress+detailAddress; //농장주소
        User user = (User) session.getAttribute("user");
        String sessionId = user.getUsername(); //접속해있는 아이디
        System.out.println("ID:"+sessionId);

        List<CompanyContract> companyInfo = userCompostOrderService.companyinfoList(sessionId);

        System.out.println("CompanyInfoIdx:"+companyInfo.get(0).getCompanyInfoIdx());
        System.out.println("CompanyContractIdx:"+companyInfo.get(0).getCompanyContractIdx());
        System.out.println("InventoryIdx:"+companyInfo.get(0).getInventoryIdx());

        Long companyInfoIdx = companyInfo.get(0).getCompanyInfoIdx();
        Long companyContractIdx = companyInfo.get(0).getCompanyContractIdx();
        Long InventoryIdx = companyInfo.get(0).getInventoryIdx();
        HashMap<String, Object> map = new HashMap<>();
        map.put("userId",sessionId); //아이디
        map.put("address",address); // 농장주소
        map.put("phone",phone); //커피배지 신청인 휴대폰번호
        map.put("amount",amount); // 커피배지 신청 중량
        map.put("message",message); // 커피배지 신청내용
        map.put("companyInfoIdx",companyInfoIdx); //사업자 정보
        map.put("companyContractIdx",companyContractIdx); //
        map.put("InventoryIdx",InventoryIdx); //
        int result = userCompostOrderService.compostOrderInsert(map);
        System.out.println(result); // 1이라면 insert 성공 0이라면 실패

        return "user/compost/listCompostOrder";
    }
    @GetMapping("/listConfirmCompostOrder")
    public String orderCompostConfirmList(HttpSession session,
                                          Model model){
        // 유저 커피배지 승인상태
        User user = (User) session.getAttribute("user");
        String sessionId = user.getUsername(); //접속해있는 아이디
        System.out.println("ID:"+sessionId);
        List<OrderCompostConfirm> compostConfirmList = userCompostOrderService.compostConfirmList(sessionId);
        model.addAttribute("compostConfirmList",compostConfirmList);

            return "user/compost/listConfirmCompostOrder";
    }


    @GetMapping("/listDeliveryCompostOrder")
    public String orderCompostDeliveryList(HttpSession session,
                                           Model model){
        // 커피배송 조회

        User user = (User) session.getAttribute("user");
        String sessionId = user.getUsername(); //접속해있는 아이디
        List<OrderCompostDelivery> compostDeliveryList = userCompostOrderService.compostDeliveryList(sessionId);
        System.out.println("length");
        model.addAttribute("compostDeliveryList",compostDeliveryList);
        return "user/compost/listDeliveryCompostOrder";
    }

}