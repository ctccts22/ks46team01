package ks46team01.admin.company.info.controller;

import ks46team01.admin.company.info.service.CompanyInfoService;
import ks46team01.common.company.info.repository.CompanyInfoRepository;
import ks46team01.common.company.info.entity.CompanyInfo;
import ks46team01.user.info.entity.User;
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
import java.time.LocalDateTime;
import java.util.List;

@Controller
@AllArgsConstructor
@Slf4j
@RequestMapping("/admin/companies/info")
public class CompanyInfoController {

    private final CompanyInfoRepository companyInfoRepository;
    private final CompanyInfoService companyInfoService;

    @GetMapping("/listInfoCompany")
    public String companyInfoList(Model model) {
        List<CompanyInfo> companyInfoList = companyInfoRepository.findAll();
        model.addAttribute("title", "사업자 정보 조회");
        model.addAttribute("companyInfoList", companyInfoList);
        log.info("companyInfo={}", companyInfoList);
        return "admin/companies/info/listInfoCompany";
    }

    @PostMapping("/updateCompanyInfo")
    public String updateCompanyInfo(@RequestParam("companyInfoIdx") Long companyInfoIdx,
                                    @RequestParam("companyInfoName") String companyInfoName,
                             @RequestParam("companyInfoLicenseNumber") String companyInfoLicenseNumber,
                             @RequestParam("companyInfoAddress") String companyInfoAddress,
                             @RequestParam("companyInfoIsDel") String companyInfoIsDel,
                             @RequestParam(value = "companyInfoIsDelDate", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime companyInfoIsDelDate,
                             Model model) {
        CompanyInfo updatedCompanyInfo = companyInfoService.updateCompanyInfo(companyInfoIdx, companyInfoName, companyInfoLicenseNumber, companyInfoAddress, companyInfoIsDel, companyInfoIsDelDate);

        if (updatedCompanyInfo == null) {
            model.addAttribute("에러", "실패했습니다.");
        } else {
            model.addAttribute("성공", "성공했습니다.");
        }
        return "redirect:/admin/companies/info/listInfoCompany";
    }
}
