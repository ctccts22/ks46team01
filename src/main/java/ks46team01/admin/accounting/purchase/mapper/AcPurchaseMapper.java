package ks46team01.admin.accounting.purchase.mapper;

import ks46team01.admin.accounting.purchase.dto.AcPurchase;
import ks46team01.admin.company.dto.CompanyDTO;
import ks46team01.admin.info.dto.AdminDTO;
import ks46team01.admin.inventories.inventory.dto.InventoryDTO;
import ks46team01.common.company.contract.dto.CompanyContractDTO;
import org.apache.ibatis.annotations.Mapper;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Mapper
public interface AcPurchaseMapper {

    //조회
    List<AcPurchase> getAcPurchase();
    //연관테이블 조회
    List<CompanyDTO> getCompany();
    List<InventoryDTO> getInventory();
    List<CompanyContractDTO> getCompanyContract();
    List<AdminDTO> getAdmin();

    //입력
    int addAcPurchase(AcPurchase acPurchase);


    //수정 조회
    AcPurchase getAcPurchaseInfoByModifyId( Long accountingPurchaseAdminIdx
                                , Long companyIdx
                                , Long inventoryIdx
                                , Long companyContractIdx
                                , String accountingPurchaseAdminDateS
                                , Date accountingPurchaseAdminDate
                                , int accountingPurchaseAdminPrice
                                , double accountingPurchaseAdminAmount
                                , String accountingPurchaseAdminPayment
                                , int accountingPurchaseAdminSum
                                , String adminUsername
                                , Timestamp accountingPurchaseAdminUpdate
    );
    //수정
    void modifyAcPurchase(Long accountingPurchaseAdminIdx
            , Long companyIdx
            , Long inventoryIdx
            , Long companyContractIdx
            , String accountingPurchaseAdminDateS
            , Date accountingPurchaseAdminDate
            , int accountingPurchaseAdminPrice
            , double accountingPurchaseAdminAmount
            , String accountingPurchaseAdminPayment
            , int accountingPurchaseAdminSum
            , String adminUsername
            , Timestamp accountingPurchaseAdminUpdate
    );


    //삭제
    AcPurchase getAcPurchaseInfoByDeleteId(Long accountingPurchaseAdminIdx);
    void deleteAcPurchaseByIdx(Long accountingPurchaseAdminIdx);

}
