package ks46team01.user.company.info.controller;

import jakarta.servlet.http.HttpSession;
import ks46team01.admin.company.entity.Company;
import ks46team01.admin.inventories.inventory.entity.Inventory;
import ks46team01.common.company.info.repository.CompanyInfoRepository;
import ks46team01.admin.company.repository.CompanyRepository;
import ks46team01.admin.inventories.inventory.repository.InventoryRepository;
import ks46team01.common.company.info.entity.CompanyInfo;
import ks46team01.user.company.info.service.CompanyInfoForUserService;
import ks46team01.user.info.entity.User;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@Controller
@Slf4j
@AllArgsConstructor
@RequestMapping("/user")
public class CompanyInfoForUserController {
    private final CompanyInfoForUserService companyInfoForUserService;
    private final CompanyInfoRepository companyInfoRepository;
    private final CompanyRepository companyRepository;
    private final InventoryRepository inventoryRepository;

    @GetMapping("/companies/addCompanyInfo")
    public String addCompanyInfo(Model model) {
        model.addAttribute("title", "사업자정보등록");
        model.addAttribute("companyInfo", new CompanyInfo());
        log.info("companyInfo={}", new CompanyInfo());
        return "user/companies/addCompanyInfo";
    }

    @PostMapping("/companies/addCompanyInfo")
    public String addCompanyInfo(@ModelAttribute CompanyInfo companyInfo,
                                 @RequestParam("company_type") Long companyType,
                                 HttpSession session,
                                 BindingResult bindingResult,
                                 Model model) {
        log.info("Received companyInfo : {}", companyInfo);
        if (bindingResult.hasErrors()) {
            return "user/companies/addCompanyInfo";
        }
        User user = (User) session.getAttribute("user");
        log.info("user: {}", user);

        CompanyInfo existingCompanyInfo = companyInfoRepository.findByUsername(user);
        if (existingCompanyInfo != null) {
            model.addAttribute("error", "중복아이디체크");
            return "user/companies/addCompanyInfo";
        }

        if (user == null) {
            model.addAttribute("error", "로그인을 해야합니다.");
            return "auth/login";
        } else {
            companyInfo.setUsername(user);
            log.info("user:{}", user);
        }

        Company company = companyRepository.findById(companyType)
                .orElseThrow(() -> new NoSuchElementException("Company not found with id: " + companyType));
        Inventory inventory = inventoryRepository.findById(companyType)
                .orElseThrow(() -> new NoSuchElementException("Inventory not found with id: " + companyType));

        companyInfo.setCompanyIdx(company);
        companyInfo.setInventoryIdx(inventory);

        log.info("사업자 정보등록 : {}", companyInfo);
        log.info("사업자 : {}", companyInfo.getCompanyIdx());
        log.info("사업자 : {}", companyInfo.getInventoryIdx());
        companyInfoForUserService.createCompanyInfo(companyInfo);
        return "redirect:/";
    }
}