package ks46team01.admin.company.contract.service;

import ks46team01.admin.company.contract.dto.CompanyContractDTO;
import ks46team01.admin.company.contract.entity.CompanyContract;
import ks46team01.admin.company.contract.repository.CompanyContractRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
}
