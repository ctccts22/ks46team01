package ks46team01.user.company.contract.controller;

import jakarta.servlet.http.HttpSession;
import ks46team01.admin.company.contract.service.CompanyContractService;
import ks46team01.admin.company.unit.dto.CompanyUnitDTO;
import ks46team01.admin.company.unit.entity.CompanyUnit;
import ks46team01.admin.company.unit.repository.CompanyUnitRepository;
import ks46team01.common.company.contract.dto.CompanyContractDTO;
import ks46team01.common.company.contract.entity.CompanyContract;
import ks46team01.common.company.contract.repository.CompanyContractRepository;
import ks46team01.common.company.info.dto.CompanyInfoDTO;
import ks46team01.common.company.info.entity.CompanyInfo;
import ks46team01.common.company.info.repository.CompanyInfoRepository;
import ks46team01.user.info.entity.User;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@Slf4j
@AllArgsConstructor
@RequestMapping("/user")
public class CompanyContractForUserController {
    private final CompanyUnitRepository companyUnitRepository;
    private final CompanyContractRepository companyContractRepository;
    private final CompanyContractService companyContractService;
    private final CompanyInfoRepository companyInfoRepository;

    @GetMapping("/companies/addCompanyContract")
    public String showAddCompanyContractForm(Model model) {
        model.addAttribute("companyContract", new CompanyContract());
        return "user/companies/addCompanyContract";
    }

    @GetMapping("/companies/getCompanyInfo")
    @ResponseBody
    public CompanyInfoDTO getCompanyInfo(HttpSession session) {
        User user = (User) session.getAttribute("user");
        CompanyInfo companyInfo = companyInfoRepository.findByUsername(user);

        if (companyInfo != null) {
            return CompanyInfoDTO.fromEntity(companyInfo);
        } else {
            return new CompanyInfoDTO();
        }
    }
    @PostMapping("/companies/addCompanyContract")
    @ResponseBody
    public ResponseEntity<?> addCompanyContract(@ModelAttribute CompanyContract companyContract) {
        companyContractService.addCompanyContract(companyContract);
        log.info("계약내용등록 : {}", companyContract);
        return ResponseEntity.ok().body("성공적으로 등록되었습니다.");
    }
}

