package ks46team01.admin.company.info.controller;

import ks46team01.common.company.info.entity.CompanyInfo;
import ks46team01.common.company.info.entity.CompanyInfoApproval;
import ks46team01.common.company.info.repository.CompanyInfoApproveRepository;
import ks46team01.common.company.info.repository.CompanyInfoRepository;
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
@RequestMapping("/admin/companies/info")
public class CompanyInfoApproveController {

    private final CompanyInfoApproveRepository companyInfoApproveRepository;

    @GetMapping("/listInfoApproveCompany")
    public String companyInfoApproveList(Model model) {
        List<CompanyInfoApproval> companyInfoApproveList = companyInfoApproveRepository.findAll();
        model.addAttribute("title", "사업자 정보 관리");
        model.addAttribute("companyInfoApproveList", companyInfoApproveList);
        log.info("companyInfoApprove={}", companyInfoApproveList);
        return "admin/companies/info/listInfoApproveCompany";
    }


}
