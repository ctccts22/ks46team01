package ks46team01.admin.company.contract.controller;


import ks46team01.admin.company.contract.service.CompanyContractApproveService;
import ks46team01.common.company.contract.repository.CompanyContractApproveRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
@Slf4j
@RequestMapping("/admin/companies/contract")
public class CompanyContractApproveController {

    private final CompanyContractApproveService companyContractApproveService;
    private final CompanyContractApproveRepository companyContractApproveRepository;

    @GetMapping("/listContractApproveCompany")
    public String companyInfoApproveList(Model model) {
        List<Object[]> companyContractList = companyContractApproveRepository.findAllCompanyContractWithApprovals();
        model.addAttribute("title", "사업자 계약 관리");
        model.addAttribute("companyContractList", companyContractList);
        log.info("companyContractList={}", companyContractList);
        return "admin/companies/contract/listContractApproveCompany";
    }


}
