package ks46team01.admin.company.unit.controller;

import jakarta.servlet.http.HttpSession;
import ks46team01.admin.company.unit.entity.CompanyUnit;
import ks46team01.admin.company.unit.repository.CompanyUnitRepository;
import ks46team01.admin.company.unit.service.CompanyUnitService;
import ks46team01.admin.info.entity.Admin;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@Slf4j
@AllArgsConstructor
@RequestMapping("/admin/companies/unit")
public class CompanyUnitController {

    private final CompanyUnitRepository companyUnitRepository;
    private final CompanyUnitService companyUnitService;

    @GetMapping("/listUnitCompany")
    public String companyUnitList(Model model) {
        List<Object[]> companyUnitList = companyUnitRepository.findCompanyUnitsWithCompanyType();
        model.addAttribute("title", "사업자계약단가");
        model.addAttribute("companyUnitList", companyUnitList);
        log.info("companyUnitList={}", companyUnitList);
        return "admin/companies/unit/listUnitCompany";
    }
    @PostMapping("/addCompanyUnit")
    public String addCompanyUnit(@RequestParam(value = "companyUnitIdx", required = false) Long companyUnitIdx,
                                    @RequestParam(value = "companyIdx", required = false) Long companyIdx,
                                           @RequestParam(value = "companyUnitYear", required = false) Integer companyUnitYear,
                                           @RequestParam(value = "companyUnitAmount", required = false) Double companyUnitAmount,
                                           @RequestParam(value = "companyUnitPrice", required = false) int companyUnitPrice,
                                           HttpSession session) {
        Admin admin = (Admin) session.getAttribute("adminUser");
        if (admin != null) {
            companyUnitService.addCompanyUnit(companyUnitIdx, companyIdx, companyUnitYear, companyUnitAmount, companyUnitPrice, admin);
            return "redirect:/admin/companies/unit/listUnitCompany";
        } else {
            return "redirect:/auth/loginAdmin";
        }
    }
    @PostMapping("/updateCompanyUnit")
    public String updateCompanyUnit(@RequestParam(value = "companyUnitIdx", required = false) Long companyUnitIdx,
                                 @RequestParam(value = "companyIdx", required = false) Long companyIdx,
                                 @RequestParam(value = "companyUnitYear", required = false) Integer companyUnitYear,
                                 @RequestParam(value = "companyUnitAmount", required = false) Double companyUnitAmount,
                                 @RequestParam(value = "companyUnitPrice", required = false) int companyUnitPrice,
                                 HttpSession session) {
        Admin admin = (Admin) session.getAttribute("adminUser");
        if (admin != null) {
            companyUnitService.updateCompanyUnit(companyUnitIdx, companyIdx, companyUnitYear, companyUnitAmount, companyUnitPrice, admin);
            return "redirect:/admin/companies/unit/listUnitCompany";
        } else {
            return "redirect:/auth/loginAdmin";
        }
    }

    @PostMapping("/delete/{companyUnitIdx}")
    @ResponseBody
    public ResponseEntity<String> deleteCompanyUnit(@PathVariable Long companyUnitIdx) {
        try {
            companyUnitService.deleteCompanyUnitByIdx(companyUnitIdx);
            return new ResponseEntity<>("삭제성공", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("삭제에러", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
