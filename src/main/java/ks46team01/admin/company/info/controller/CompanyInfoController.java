package ks46team01.admin.company.info.controller;

import ks46team01.common.company.info.repository.CompanyInfoRepository;
import ks46team01.common.company.info.entity.CompanyInfo;
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
public class CompanyInfoController {

    private final CompanyInfoRepository companyInfoRepository;

    @GetMapping("/listInfoCompany")
    public String companyInfoList(Model model) {
        List<CompanyInfo> companyInfoList = companyInfoRepository.findAll();
        model.addAttribute("title", "사업자 정보 조회");
        model.addAttribute("companyInfoList", companyInfoList);
        log.info("companyInfo={}", companyInfoList);
        return "admin/companies/info/listInfoCompany";
    }

}
