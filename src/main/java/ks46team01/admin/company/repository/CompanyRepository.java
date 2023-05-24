package ks46team01.admin.company.repository;

import ks46team01.admin.company.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompanyRepository  extends JpaRepository<Company, Long> {

    @Query("select c from Company as c")
    List<Company> findAll();

    Optional<Company> findByCompanyIdx(Long companyIdx);


}
