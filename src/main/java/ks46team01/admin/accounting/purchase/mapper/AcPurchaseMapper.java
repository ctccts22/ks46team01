package ks46team01.admin.accounting.purchase.mapper;

import ks46team01.admin.accounting.purchase.dto.AcPurchase;
import ks46team01.admin.company.contract.entity.CompanyContract;
import ks46team01.admin.company.entity.Company;
import ks46team01.admin.info.entity.Admin;
import ks46team01.admin.inventory.entity.Inventory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AcPurchaseMapper {

    //조회
    List<AcPurchase> getAcPurchase();
    //연관테이블 조회
    List<Company> getCompany();
    List<Inventory> getInventory();
    List<CompanyContract> getCompanyContract();
    List<Admin> getAdmin();

    //입력
    int addAcPurchase(AcPurchase acPurchase);






    //삭제
    AcPurchase getAcPurchaseInfoByDeleteId(Long accountingPurchaseAdminIdx);

    void deleteAcPurchaseByIdx(Long accountingPurchaseAdminIdx);


}
