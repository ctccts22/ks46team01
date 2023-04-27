package ks46team01.admin.company.service;

import ks46team01.admin.company.repository.CompanyRepository;
import ks46team01.admin.company.entity.Company;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
