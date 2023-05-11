package ks46team01.admin.company.contract.service;

import ks46team01.admin.info.entity.Admin;
import ks46team01.admin.inventories.inventory.service.InventoryService;
import ks46team01.common.company.contract.entity.CompanyContract;
import ks46team01.common.company.contract.entity.CompanyContractApprove;
import ks46team01.common.company.contract.repository.CompanyContractApproveRepository;
import ks46team01.common.company.contract.repository.CompanyContractRepository;
import ks46team01.common.company.info.entity.CompanyInfo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class CompanyContractApproveService {
    private final CompanyContractRepository companyContractRepository;
    private final CompanyContractApproveRepository companyContractApproveRepository;
    private final InventoryService inventoryService;
    public CompanyContractApprove updateCompanyContractApprove(Long companyContractApproveIdx, LocalDate companyContractApproveDate, String companyContractApproveStatus, String companyContractApproveContent, Admin admin, Long companyContractIdx) {
        CompanyContractApprove exCompanyContractApprove;
//        String previousStatus = null;

        if (companyContractApproveIdx != null) {
            Optional<CompanyContractApprove> exCompanyContractApproveOptional = companyContractApproveRepository.findWithCompanyContractAndAdminByUsername(companyContractApproveIdx);

            if (exCompanyContractApproveOptional.isPresent()) {
                exCompanyContractApprove = exCompanyContractApproveOptional.get();
//                previousStatus = exCompanyContractApprove.getCompanyContractApproveStatus();
            } else {
                exCompanyContractApprove = new CompanyContractApprove();
                exCompanyContractApprove.setCompanyContractApproveIdx(companyContractApproveIdx);
            }
        } else {
            exCompanyContractApprove = new CompanyContractApprove();
        }

        Optional<CompanyContract> companyContractOptional = companyContractRepository.findByCompanyContractIdx(companyContractIdx);
        if (companyContractOptional.isPresent()) {
            CompanyContract companyContract = companyContractOptional.get();

            // CompanyContractApprove and CompanyContract 사이 관계 설정
            exCompanyContractApprove.setCompanyContractIdx(companyContract);
        } else {
            throw new RuntimeException("CompanyContract not found with companyContractIdx: " + companyContractIdx);
        }

        exCompanyContractApprove.setCompanyContractApproveDate(Date.valueOf(companyContractApproveDate));
        exCompanyContractApprove.setCompanyContractApproveStatus(companyContractApproveStatus);
        exCompanyContractApprove.setCompanyContractApproveContent(companyContractApproveContent);
        exCompanyContractApprove.setAdminUsername(admin);

//        if (!"Y".equals(previousStatus) && "Y".equals(companyContractApproveStatus)) {
//            CompanyContract contract = exCompanyContractApprove.getCompanyContractIdx();
//            if (contract != null) {
//                CompanyInfo companyInfo = contract.getCompanyInfoIdx();
//                if (companyInfo != null) {
//                    Long companyIdx = companyInfo.getCompanyIdx().getCompanyIdx();
//                    if (companyIdx != null) {
//                        if (1L == companyIdx) {
//                            inventoryService.inputInventory(contract);
//                        } else if (2L == companyIdx || 3L == companyIdx) {
//                            inventoryService.outputInventory(contract);
//                        }
//                    }
//                }
//            }
//        }

        return companyContractApproveRepository.save(exCompanyContractApprove);
    }
}



