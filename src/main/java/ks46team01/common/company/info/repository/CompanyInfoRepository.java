package ks46team01.common.company.info.repository;

import ks46team01.admin.company.entity.Company;
import ks46team01.admin.company.unit.entity.CompanyUnit;
import ks46team01.admin.inventories.inventory.entity.Inventory;
import ks46team01.common.company.info.entity.CompanyInfo;
import ks46team01.user.info.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompanyInfoRepository
        extends JpaRepository<CompanyInfo, Long> {

    @Query("select ci from CompanyInfo as ci")
    List<CompanyInfo> findAll();

    CompanyInfo findByUsername(User user);

    List<CompanyInfo> findByCompanyIdx(Company companyInfo);

    List<CompanyInfo> findByInventoryIdx(Inventory companyInfo);

    Optional<CompanyInfo> findByCompanyInfoIdx(Long companyInfoIdx);

    CompanyInfo findByCompanyInfoName(String companyInfoName);

    List<CompanyInfo> findByCompanyUnitIdx(CompanyUnit companyUnit);

}