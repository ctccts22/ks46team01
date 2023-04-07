package ks46team01.company.service;

import ks46team01.company.entity.Company;
import ks46team01.company.repository.CompanyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;

    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }
    public Company createCompany(Company company) {
        return companyRepository.save(company);
    }
}
