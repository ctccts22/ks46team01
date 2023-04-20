package ks46team01.admin.company.unit.repository;

import ks46team01.admin.company.unit.entity.CompanyUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyUnitRepository extends JpaRepository<CompanyUnit, Long> {
    List<CompanyUnit> findAll();

}
