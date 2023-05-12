package ks46team01.admin.company.contract.service;

import ks46team01.admin.info.entity.Admin;
import ks46team01.admin.inventories.inventory.service.InventoryService;
import ks46team01.admin.inventories.record.entity.InventoryRecord;
import ks46team01.admin.inventories.record.repository.InventoryRecordRepository;
import ks46team01.common.company.contract.entity.CompanyContract;
import ks46team01.common.company.contract.entity.CompanyContractApprove;
import ks46team01.common.company.contract.repository.CompanyContractApproveRepository;
import ks46team01.common.company.contract.repository.CompanyContractRepository;
import ks46team01.common.company.info.entity.CompanyInfo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class CompanyContractApproveService {
    private final CompanyContractRepository companyContractRepository;
    private final CompanyContractApproveRepository companyContractApproveRepository;
    private final InventoryService inventoryService;
    private final InventoryRecordRepository inventoryRecordRepository;

    public CompanyContractApprove updateCompanyContractApprove(Long companyContractApproveIdx, LocalDate companyContractApproveDate, String companyContractApproveStatus, String companyContractApproveContent, Admin admin, Long companyContractIdx) {
        CompanyContractApprove exCompanyContractApprove;

        if (companyContractApproveIdx != null) {
            Optional<CompanyContractApprove> exCompanyContractApproveOptional = companyContractApproveRepository.findWithCompanyContractAndAdminByUsername(companyContractApproveIdx);

            if (exCompanyContractApproveOptional.isPresent()) {
                exCompanyContractApprove = exCompanyContractApproveOptional.get();
            } else {
                exCompanyContractApprove = new CompanyContractApprove();
                exCompanyContractApprove.setCompanyContractApproveIdx(companyContractApproveIdx);
            }
        } else {
            exCompanyContractApprove = new CompanyContractApprove();
        }

        CompanyContract companyContract = companyContractRepository.findById(companyContractIdx)
                .orElseThrow(() -> new RuntimeException("CompanyContract not found with companyContractIdx: " + companyContractIdx));

        exCompanyContractApprove.setCompanyContractIdx(companyContract);
        exCompanyContractApprove.setCompanyContractApproveDate(Date.valueOf(companyContractApproveDate));
        exCompanyContractApprove.setCompanyContractApproveStatus(companyContractApproveStatus);
        exCompanyContractApprove.setCompanyContractApproveContent(companyContractApproveContent);
        exCompanyContractApprove.setAdminUsername(admin);

        CompanyContractApprove updatedCompanyContractApprove = companyContractApproveRepository.save(exCompanyContractApprove);

        if (updatedCompanyContractApprove.getCompanyContractApproveStatus().equals("Y")) {

            InventoryRecord inventoryRecord = new InventoryRecord();


            inventoryRecord.setCompanyContractIdx(updatedCompanyContractApprove.getCompanyContractIdx());
            inventoryRecord.setInventoryIdx(updatedCompanyContractApprove.getCompanyContractIdx().getCompanyInfoIdx().getInventoryIdx());
            inventoryRecord.setFinalAmount(updatedCompanyContractApprove.getCompanyContractIdx().getCompanyContractAmount());
            inventoryRecord.setLastUpdated(Timestamp.valueOf(LocalDateTime.now()));
            inventoryRecord.setAdminUsername(admin);

            inventoryRecordRepository.save(inventoryRecord);
        }

        return updatedCompanyContractApprove;
    }
}
