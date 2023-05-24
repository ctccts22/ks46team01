package ks46team01.user.company.unit.controller;

import ks46team01.admin.company.unit.repository.CompanyUnitRepository;
import ks46team01.admin.company.unit.service.CompanyUnitService;
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
@RequestMapping("/user/companies")
public class CompanyUnitForUserController {

    private final CompanyUnitRepository companyUnitRepository;
    private final CompanyUnitService companyUnitService;

    @GetMapping("/listUnitCompany")
    public String companyUnitList(Model model) {
        List<Object[]> companyUnitList = companyUnitRepository.findCompanyUnitsWithCompanyType();
        model.addAttribute("title", "사업자계약단가");
        model.addAttribute("companyUnitList", companyUnitList);
        log.info("companyUnitList={}", companyUnitList);
        return "user/companies/listUnitCompany";
    }
}
