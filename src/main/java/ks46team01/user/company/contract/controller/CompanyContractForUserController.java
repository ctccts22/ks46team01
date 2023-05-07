package ks46team01.user.company.contract.controller;

import jakarta.servlet.http.HttpSession;
import ks46team01.common.company.contract.dto.CompanyContractDTO;
import ks46team01.common.company.contract.entity.CompanyContract;
import ks46team01.common.company.contract.repository.CompanyContractRepository;
import ks46team01.common.company.info.entity.CompanyInfo;
import ks46team01.common.company.info.repository.CompanyInfoRepository;
import ks46team01.user.info.entity.User;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Slf4j
@AllArgsConstructor
@RequestMapping("/user")
public class CompanyContractForUserController {
    private final CompanyContractRepository companyContractRepository;
    private final CompanyInfoRepository companyInfoRepository;

    @GetMapping("/companies/addCompanyContract")
    public String addCompanyContract(Model model, HttpSession session) {
        model.addAttribute("title", "사업자계약등록");
        model.addAttribute("companyContract", new CompanyContract());
        log.info("CompanyContract:{}",new CompanyContract());
        return "user/companies/addCompanyContract";
    }

    /**
     * 회원(user) 사업자 계약 등록
     */
    @PostMapping("/companies/addCompanyContract")
    public String addCompanyContract(@ModelAttribute CompanyContractDTO companyContractDTO,
                                     HttpSession session,
                                     BindingResult bindingResult,
                                     RedirectAttributes redirectAttributes) {
        log.info("companyContractDTO : {}", companyContractDTO );
        if (bindingResult.hasErrors()) {
            return "user/companies/addCompanyContract";
        }
        User user = (User) session.getAttribute("user");
        log.info("user : {}", user);

        CompanyInfo companyInfo = companyInfoRepository.findByUsername(user);
        if (companyInfo == null) {
            redirectAttributes.addFlashAttribute("error", "사용자의 회사 정보를 찾을 수 없습니다.");
            return "user/companies/addCompanyContract";
        }
        if (user == null) {
            redirectAttributes.addFlashAttribute("error", "로그인을 해야합니다.");
            return "auth/login";
        } else {
            companyContractDTO.setUsername(user.getUsername());
            log.info("userFromDTO : {}", user.getUsername());
        }

        companyContractDTO.setCompanyInfoIdx(companyInfo.getCompanyInfoIdx());

        return "/";
    }
}
