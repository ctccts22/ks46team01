package ks46team01.user.company.info.service;


import ks46team01.admin.company.entity.Company;
import ks46team01.admin.inventories.inventory.entity.Inventory;
import ks46team01.common.company.info.repository.CompanyInfoRepository;
import ks46team01.common.company.info.entity.CompanyInfo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class CompanyInfoForUserService {
    private final CompanyInfoRepository companyInfoRepository;

    public CompanyInfo createCompanyInfo(CompanyInfo companyInfo) {
        Company company = companyInfo.getCompanyIdx();
        Inventory inventory = companyInfo.getInventoryIdx();

        List<CompanyInfo> companyList = companyInfoRepository.findByCompanyIdx(company);
        List<CompanyInfo> inventoryList = companyInfoRepository.findByInventoryIdx(inventory);

        companyInfo.setCompanyInfoDate(new Timestamp(System.currentTimeMillis()));

        return companyInfoRepository.save(companyInfo);
    }
}