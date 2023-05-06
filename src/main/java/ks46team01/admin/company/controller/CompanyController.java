package ks46team01.admin.company.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpSession;
import ks46team01.admin.company.dto.CompanyDTO;
import ks46team01.admin.info.dto.AdminDTO;
import ks46team01.admin.info.entity.Admin;
import ks46team01.admin.company.entity.Company;
import ks46team01.admin.company.service.CompanyService;
import ks46team01.admin.info.util.AdminConverter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/admin/companies")
public class CompanyController {

    private final CompanyService companyService;

    @GetMapping("/listCompany")
    public String getAllCompony(Model model) {
        List<CompanyDTO> companyList = companyService.getAllCompanies();
        model.addAttribute("companyList", companyList);
        return "admin/companies/listCompany";
    }

    @GetMapping("/addCompany")
    public String showAddCompanyForm(Model model) {
        model.addAttribute("company", new Company());
        return "admin/companies/addCompany";
    }

    @PostMapping("/addCompany")
    @ResponseBody
    public String addCompany(CompanyDTO companyDTO, HttpSession session) throws JsonProcessingException {
        Admin admin = (Admin) session.getAttribute("adminUser");
        String result = null;
        if (admin != null) {
            AdminDTO adminDTO = AdminConverter.entityToDTO(admin);
            companyDTO.setAdminUsername(adminDTO.getAdminUsername());
            companyDTO.setCompanyDate(Timestamp.valueOf(LocalDateTime.now()));
            companyService.createCompany(companyDTO);
            List<CompanyDTO> companyList = companyService.getAllCompanies();
            ObjectMapper mapper = new ObjectMapper();
            result = mapper.writeValueAsString(companyList);
        }
        return result;
    }



}
