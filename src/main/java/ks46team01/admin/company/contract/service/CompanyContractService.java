package ks46team01.admin.company.contract.service;

import ks46team01.common.company.contract.dto.CompanyContractDTO;
import ks46team01.common.company.contract.entity.CompanyContract;
import ks46team01.common.company.contract.repository.CompanyContractRepository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class CompanyContractService {
    private final CompanyContractRepository companyContractRepository;

    public List<CompanyContractDTO> getAllCompanyContracts() {
        List<CompanyContract> results = companyContractRepository.findAll();

        List<CompanyContractDTO> companyContractDTOList = new ArrayList<>();

        for (CompanyContract companyContract : results) {
            CompanyContractDTO dto = CompanyContractDTO.fromEntity(companyContract);
            companyContractDTOList.add(dto);
        }

        return companyContractDTOList;
    }

    public void addCompanyContract(CompanyContract companyContract) {
        companyContractRepository.save(companyContract);
    }

    public CompanyContractDTO updateCompanyContract(Long companyContractIdx, LocalDate companyContractStart,
                                                    LocalDate companyContractEnd, String companyContractDeliveryTerm, Double companyContractAmount) {

        Optional<CompanyContract> existingCompanyContractOptional = companyContractRepository.findByCompanyContractIdx(companyContractIdx);

        if (existingCompanyContractOptional.isPresent()) {
            CompanyContract existingCompanyContract = existingCompanyContractOptional.get();
            existingCompanyContract.setCompanyContractIdx(companyContractIdx);
            existingCompanyContract.setCompanyContractStart(Date.valueOf(companyContractStart));
            existingCompanyContract.setCompanyContractEnd(Date.valueOf(companyContractEnd));
            existingCompanyContract.setCompanyContractDeliveryTerm(companyContractDeliveryTerm);
            existingCompanyContract.setCompanyContractAmount(companyContractAmount);

            CompanyContract updatedCompanyContract = companyContractRepository.save(existingCompanyContract);
            return CompanyContractDTO.fromEntity(updatedCompanyContract);
        } else {
            throw new RuntimeException();
        }
    }
}
