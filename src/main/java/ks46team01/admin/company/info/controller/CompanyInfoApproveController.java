package ks46team01.admin.company.info.controller;

import jakarta.servlet.http.HttpSession;
import ks46team01.admin.company.info.service.CompanyInfoApproveService;
import ks46team01.admin.info.entity.Admin;
import ks46team01.common.company.info.entity.CompanyInfo;
import ks46team01.common.company.info.entity.CompanyInfoApprove;
import ks46team01.common.company.info.repository.CompanyInfoApproveRepository;
import ks46team01.common.company.info.repository.CompanyInfoRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
@Slf4j
@RequestMapping("/admin/companies/info")
public class CompanyInfoApproveController {

    private final CompanyInfoApproveRepository companyInfoApproveRepository;
    private final CompanyInfoRepository companyInfoRepository;
    private final CompanyInfoApproveService companyInfoApproveService;

//    @GetMapping("/listInfoApproveCompany")
//    public String companyInfoApproveList(Model model) {
//        List<CompanyInfoApprove> companyInfoApproveList = companyInfoApproveRepository.findAll();
//        model.addAttribute("title", "사업자 정보 관리");
//        model.addAttribute("companyInfoApproveList", companyInfoApproveList);
//        log.info("companyInfoApprove={}", companyInfoApproveList);
//        return "admin/companies/info/listInfoApproveCompany";
//    }

    @GetMapping("/listInfoApproveCompany")
    public String companyInfoApproveList(Model model) {
        List<Object[]> companyInfoList = companyInfoApproveRepository.findAllCompanyInfoWithApprovals();
        model.addAttribute("title", "사업자 정보 관리");
        model.addAttribute("companyInfoList", companyInfoList);
        log.info("companyInfoList={}", companyInfoList);
        return "admin/companies/info/listInfoApproveCompany";
    }

    @PostMapping("/updateCompanyInfoApprove")
    public String updateCompanyInfoApprove(@RequestParam(value = "companyInfoApproveIdx", required = false) Long companyInfoApproveIdx,
                                           @RequestParam(value = "companyInfoApproveDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate companyInfoApproveDate,
                                           @RequestParam(value = "companyInfoApproveStatus", required = false) String companyInfoApproveStatus,
                                           @RequestParam(value = "companyInfoApproveContent", required = false) String companyInfoApproveContent,
                                           @RequestParam(value = "companyInfoIdx", required = true) Long companyInfoIdx,
                                           HttpSession session) {
        Admin admin = (Admin) session.getAttribute("adminUser");
        if (admin != null) {
            companyInfoApproveService.updateCompanyInfoApprove(companyInfoApproveIdx, companyInfoApproveDate, companyInfoApproveStatus, companyInfoApproveContent, admin, companyInfoIdx);
            return "redirect:/admin/companies/info/listInfoApproveCompany";
        } else {
            return "redirect:/auth/loginAdmin";
        }
    }
}
