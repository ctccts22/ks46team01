package ks46team01.admin.company.contract.controller;

import ks46team01.admin.company.contract.entity.CompanyContract;
import ks46team01.admin.company.contract.repository.CompanyContractRepository;
import ks46team01.admin.company.unit.entity.CompanyUnit;
import ks46team01.admin.company.unit.repository.CompanyUnitRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Slf4j
@AllArgsConstructor
@RequestMapping("/admin/companies/contract")
public class CompanyContractController {


    private final CompanyContractRepository companyContractRepository;

    @GetMapping("/listContractCompany")
    public String companyContractList(Model model) {
        List<CompanyContract> companyContractList = companyContractRepository.findAll();
        model.addAttribute("title", "사업자계약신청관리");
        model.addAttribute("companyContractList", companyContractList);
        log.info("companyContractList={}", companyContractList);

        return "admin/companies/contract/listContractCompany";
    }
}
