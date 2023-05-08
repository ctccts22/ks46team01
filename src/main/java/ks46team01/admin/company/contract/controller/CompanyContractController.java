package ks46team01.admin.company.contract.controller;

import ks46team01.common.company.contract.dto.CompanyContractDTO;
import ks46team01.common.company.contract.entity.CompanyContract;
import ks46team01.common.company.contract.repository.CompanyContractRepository;
import ks46team01.admin.company.contract.service.CompanyContractService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@Slf4j
@AllArgsConstructor
@RequestMapping("/admin/companies/contract")
public class CompanyContractController {


    private final CompanyContractRepository companyContractRepository;
    private final CompanyContractService companyContractService;

    @GetMapping("/listContractCompany")
    public String companyContractList(Model model) {
        List<CompanyContract> companyContractList = companyContractRepository.findAll();
        List<CompanyContractDTO> companyContractDTOList = companyContractList.stream()
                        .map(CompanyContractDTO::fromEntity)
                                .collect(Collectors.toList());
        model.addAttribute("title", "사업자계약신청관리");
        model.addAttribute("companyContractList", companyContractDTOList);
        log.info("companyContractDTOList={}", companyContractDTOList);

        return "admin/companies/contract/listContractCompany";
    }



}
