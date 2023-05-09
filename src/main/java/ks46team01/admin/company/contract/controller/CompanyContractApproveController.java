package ks46team01.admin.company.contract.controller;


import jakarta.servlet.http.HttpSession;
import ks46team01.admin.company.contract.service.CompanyContractApproveService;
import ks46team01.admin.info.entity.Admin;
import ks46team01.common.company.contract.repository.CompanyContractApproveRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
@AllArgsConstructor
@Slf4j
@RequestMapping("/admin/companies/contract")
public class CompanyContractApproveController {

    private final CompanyContractApproveService companyContractApproveService;
    private final CompanyContractApproveRepository companyContractApproveRepository;

    @GetMapping("/listContractApproveCompany")
    public String companyContractApproveList(Model model) {
        List<Object[]> companyContractList = companyContractApproveRepository.findAllCompanyContractWithApprovals();
        model.addAttribute("title", "사업자 계약 관리");
        model.addAttribute("companyContractList", companyContractList);
        log.info("companyContractList={}", companyContractList);
        return "admin/companies/contract/listContractApproveCompany";
    }
    @PostMapping("/updateCompanyContractApprove")
    public String updateCompanyContractApprove(@RequestParam(value = "companyContractApproveIdx", required = false) Long companyContractApproveIdx,
                                           @RequestParam(value = "companyContractApproveDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate companyContractApproveDate,
                                           @RequestParam(value = "companyContractApproveStatus", required = false) String companyContractApproveStatus,
                                           @RequestParam(value = "companyContractApproveContent", required = false) String companyContractApproveContent,
                                           @RequestParam(value = "companyContractIdx", required = true) Long companyContractIdx,
                                           HttpSession session) {
        Admin admin = (Admin) session.getAttribute("adminUser");
        if (admin != null) {
            companyContractApproveService.updateCompanyContractApprove(companyContractApproveIdx, companyContractApproveDate, companyContractApproveStatus, companyContractApproveContent, admin, companyContractIdx);
            return "redirect:/admin/companies/contract/listContractApproveCompany";
        } else {
            return "redirect:/auth/loginAdmin";
        }
    }

}
