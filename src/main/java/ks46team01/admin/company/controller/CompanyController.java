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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/deleteCompany")
    @ResponseBody
    public ResponseEntity<?> deleteCompany(@RequestParam("companyIdx") Long companyIdx, HttpSession session) {
        Admin admin = (Admin) session.getAttribute("adminUser");
        if (admin != null) {
            boolean isDeleted = companyService.deleteCompany(companyIdx, admin);
            if (isDeleted) {
                return new ResponseEntity<>("200성공", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("400에러", HttpStatus.BAD_REQUEST);
            }
        }
        return new ResponseEntity<>("401어드민로그인에러", HttpStatus.UNAUTHORIZED);
    }

}
