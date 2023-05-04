package ks46team01.admin.company.unit.repository;

import ks46team01.admin.company.unit.entity.CompanyUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompanyUnitRepository extends JpaRepository<CompanyUnit, Long> {
    List<CompanyUnit> findAll();

    @Query("SELECT " +
            "cu.companyUnitIdx, cu.companyIdx, cu.companyUnitAmount, cu.companyUnitPrice, cu.companyUnitYear, " +
            "cu.adminUsername, cu.companyUnitDate, c.companyType " +
            "FROM CompanyUnit cu JOIN cu.companyIdx c")
    List<Object[]> findCompanyUnitsWithCompanyType();


    Optional<CompanyUnit> findByCompanyUnitIdx(Long companyUnitIdx);

}
