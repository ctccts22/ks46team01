package ks46team01.admin.company.contract.service;

import ks46team01.common.company.contract.repository.CompanyContractRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class CompanyContractApproveService {
    private final CompanyContractRepository companyContractRepository;

    }



