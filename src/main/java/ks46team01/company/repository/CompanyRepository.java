package ks46team01.company.repository;

import ks46team01.company.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository  extends JpaRepository<Company, Long> {

}
