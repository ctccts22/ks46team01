package ks46team01.company.controller;

import jakarta.servlet.http.HttpSession;
import ks46team01.admin.entity.Admin;
import ks46team01.company.entity.Company;
import ks46team01.company.service.CompanyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/companies")
public class CompanyController {

    private final CompanyService companyService;

    @GetMapping("/listCompany")
    public String getAllCompony(Model model) {
        List<Company> companyList = companyService.getAllCompanies();
        model.addAttribute("companyList", companyList);
        return "companies/listCompany";
    }

    @GetMapping("/addCompany")
    public String showAddCompanyForm(Model model) {
        model.addAttribute("company", new Company());
        return "companies/addCompany";
    }

    @PostMapping("/addCompany")
    public String addCompany(Company company, HttpSession session) {
        Admin admin = (Admin) session.getAttribute("adminUser");
        if (admin != null) {
            company.setAdminUsername(admin);
            company.setCompanyDate(Timestamp.valueOf(LocalDateTime.now())); // Set the current timestamp as the companyDate
            companyService.createCompany(company);
            return "redirect:/companies/listCompany";
        } else {
            // Handle the case when the admin is not logged in
            return "redirect:/auth/loginAdmin";
        }
    }


}
