package ks46team01.admin.company.service;

import ks46team01.admin.company.dto.CompanyDTO;
import ks46team01.admin.company.repository.CompanyRepository;
import ks46team01.admin.company.entity.Company;
import ks46team01.admin.company.util.CompanyConverter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class CompanyService {

    private final CompanyRepository companyRepository;

    public List<CompanyDTO> getAllCompanies() {
        List<Company> companies = companyRepository.findAll();
        return companies.stream().map(CompanyConverter::entityToDTO).collect(Collectors.toList());
    }

    public CompanyDTO createCompany(CompanyDTO companyDTO) {
        Company company = CompanyConverter.dtoToEntity(companyDTO);
        Company savedCompany = companyRepository.save(company);
        return CompanyConverter.entityToDTO(savedCompany);
    }
}

