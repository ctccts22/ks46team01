package ks46team01.admin.company.info.repository;

import ks46team01.common.company.info.entity.CompanyInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyInfoRepository extends JpaRepository<CompanyInfo, Long> {

    List<CompanyInfo> findAll();

}
