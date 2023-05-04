package ks46team01.admin.company.unit.service;

import ks46team01.admin.company.entity.Company;
import ks46team01.admin.company.repository.CompanyRepository;
import ks46team01.admin.company.unit.entity.CompanyUnit;
import ks46team01.admin.company.unit.repository.CompanyUnitRepository;
import ks46team01.admin.info.entity.Admin;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

@Service
@Transactional
@AllArgsConstructor
public class CompanyUnitService {

    private final CompanyUnitRepository companyUnitRepository;
    private final CompanyRepository companyRepository;

    public void addCompanyUnit(Long companyUnitIdx, Long companyIdx, Integer companyUnitYear, Double companyUnitAmount, int companyUnitPrice, Admin admin) {
        Company company = companyRepository.findById(companyIdx).orElseThrow(() -> new IllegalArgumentException("등록되지 않은 Idx: " + companyIdx));
        CompanyUnit addCompanyUnit = createCompanyUnit(company, companyUnitYear, companyUnitAmount, companyUnitPrice, admin);
        companyUnitRepository.save(addCompanyUnit);
    }

    public void updateCompanyUnit(Long companyUnitIdx, Long companyIdx, Integer companyUnitYear, Double companyUnitAmount, int companyUnitPrice, Admin admin) {
        Company company = companyRepository.findByCompanyIdx(companyIdx).orElseThrow(() -> new IllegalArgumentException("등록되지 않은 Idx: " + companyIdx));
        CompanyUnit updateCompanyUnit = createCompanyUnit(company, companyUnitYear, companyUnitAmount, companyUnitPrice, admin);
        updateCompanyUnit.setCompanyUnitIdx(companyUnitIdx);
        companyUnitRepository.save(updateCompanyUnit);
    }
    private CompanyUnit createCompanyUnit(Company company, Integer companyUnitYear, Double companyUnitAmount, int companyUnitPrice, Admin admin) {
        CompanyUnit companyUnit = new CompanyUnit();
        companyUnit.setCompanyIdx(company);
        companyUnit.setCompanyUnitYear(companyUnitYear);
        companyUnit.setCompanyUnitAmount(companyUnitAmount);
        companyUnit.setCompanyUnitPrice(companyUnitPrice);
        companyUnit.setAdminUsername(admin);
        companyUnit.setCompanyUnitDate(new Timestamp(System.currentTimeMillis()));
        return companyUnit;
    }




    public void deleteCompanyUnitByIdx(Long companyUnitIdx) {
        companyUnitRepository.deleteById(companyUnitIdx);
    }
}
