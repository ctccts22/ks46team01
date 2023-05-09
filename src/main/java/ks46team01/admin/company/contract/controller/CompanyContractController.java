package ks46team01.admin.company.contract.controller;

import ks46team01.common.company.contract.dto.CompanyContractDTO;
import ks46team01.common.company.contract.entity.CompanyContract;
import ks46team01.common.company.contract.repository.CompanyContractRepository;
import ks46team01.admin.company.contract.service.CompanyContractService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
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
    @PostMapping("/updateCompanyContract")
    public String updateCompanyContract(@RequestParam("companyContractIdx") Long companyContractIdx,
                                    @RequestParam("companyContractStart") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate companyContractStart,
                                    @RequestParam("companyContractEnd")  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate companyContractEnd,
                                    @RequestParam("companyContractDeliveryTerm") String companyContractDeliveryTerm,
                                    @RequestParam("companyContractAmount") Double companyContractAmount,
                                    Model model) {
        CompanyContractDTO updatedCompanyContractDTO = companyContractService.updateCompanyContract(companyContractIdx, companyContractStart, companyContractEnd, companyContractDeliveryTerm, companyContractAmount);
        if (updatedCompanyContractDTO == null) {
            model.addAttribute("에러", "실패했습니다.");
        } else {
            model.addAttribute("성공", "성공했습니다.");
        }
        return "redirect:/admin/companies/contract/listContractCompany";
    }

//    @PostMapping("/updateCompanyContract")
//    public ResponseEntity<?> updateCompanyContract(@RequestParam("companyContractIdx") Long companyContractIdx,
//                                                   @RequestParam("companyContractStart") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate companyContractStart,
//                                                   @RequestParam("companyContractEnd") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate companyContractEnd,
//                                                   @RequestParam("companyContractDeliveryTerm") String companyContractDeliveryTerm,
//                                                   @RequestParam("companyContractAmount") Double companyContractAmount,
//                                                   Model model) {
//
//        CompanyContractDTO updatedCompanyContractDTO = companyContractService.updateCompanyContract(companyContractIdx, companyContractStart, companyContractEnd, companyContractDeliveryTerm, companyContractAmount);
//        if (updatedCompanyContractDTO == null) {
//            return new ResponseEntity<>("Error updating contract", HttpStatus.BAD_REQUEST);
//        } else {
//            return new ResponseEntity<>("Successfully updated contract", HttpStatus.OK);
//        }
//    }
}
