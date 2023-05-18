package ks46team01.admin.accounting.sale.mapper;

import ks46team01.admin.accounting.sale.dto.AcSale;
import ks46team01.admin.company.dto.CompanyDTO;
import ks46team01.admin.info.dto.AdminDTO;
import ks46team01.common.company.contract.dto.CompanyContractDTO;
import ks46team01.common.compost.dto.Inventory;
import org.apache.ibatis.annotations.Mapper;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Mapper
public interface AcSaleMapper {

    //조회
    List<AcSale> getAcSale();
    List<CompanyDTO> getCompany();
    List<Inventory> getInventory();
    List<CompanyContractDTO> getCompanyContract();
    List<AdminDTO> getAdmin();

    //입력
    int addAcSale(AcSale acSale);


    //수정
    AcSale getAcPurchaseInfoByModifyId(Long accountingSalesAdminIdx
                            , Long companyIdx
                            , Long inventoryIdx
                            , Long companyContractIdx
                            , String accountingSalesAdminDateS
                            , Date accountingSalesAdminDate
                            , String accountingSalesAdminType
                            , String accountingSalesAdminPayment
                            , Integer accountingSalesAdminSum
                            , String adminUsername
                            , Timestamp accountingSalesAdminUpdate
                            , String accountingSalesAdminFinishUpdate
    );
    void modifyAcSale(Long accountingSalesAdminIdx
                        , Long companyIdx
                        , Long inventoryIdx
                        , Long companyContractIdx
                        , String accountingSalesAdminDateS
                        , Date accountingSalesAdminDate
                        , String accountingSalesAdminType
                        , String accountingSalesAdminPayment
                        , Integer accountingSalesAdminSum
                        , String adminUsername
                        , Timestamp accountingSalesAdminUpdate
                        , String accountingSalesAdminFinishUpdate
    );





    //삭제
    AcSale getAcSaleInfoByDeleteId(Long accountingSalesAdminIdx);
    void deleteAcSaleByIdx(Long accountingSalesAdminIdx);

}

