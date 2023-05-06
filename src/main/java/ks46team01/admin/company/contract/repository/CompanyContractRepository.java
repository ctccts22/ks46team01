package ks46team01.admin.company.contract.repository;

import ks46team01.admin.company.contract.entity.CompanyContract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyContractRepository extends JpaRepository<CompanyContract, Long> {

    List<CompanyContract> findAll();


}

