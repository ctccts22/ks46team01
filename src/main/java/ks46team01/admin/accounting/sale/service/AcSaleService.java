package ks46team01.admin.accounting.sale.service;

import ks46team01.admin.accounting.sale.dto.AcSale;
import ks46team01.admin.accounting.sale.mapper.AcSaleMapper;
import ks46team01.admin.company.dto.CompanyDTO;
import ks46team01.admin.info.dto.AdminDTO;
import ks46team01.common.company.contract.dto.CompanyContractDTO;
import ks46team01.common.compost.dto.Inventory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class AcSaleService {
    private final AcSaleMapper acSaleMapper;
    public AcSaleService(AcSaleMapper acSaleMapper){
        this.acSaleMapper = acSaleMapper;
    }

    //조회
    public List<AcSale> getAcSale(){
        List<AcSale> acSales = acSaleMapper.getAcSale();
        return acSales;
    }
    public List<CompanyDTO> getCompany(){
        List<CompanyDTO> companyDTOList = acSaleMapper.getCompany();
        return companyDTOList;
    }
    public List<Inventory> getInventory(){
        List<Inventory> inventories = acSaleMapper.getInventory();
        return inventories;
    }
    public List<CompanyContractDTO> getCompanyContract(){
        List<CompanyContractDTO> companyContractDTOS = acSaleMapper.getCompanyContract();
        return companyContractDTOS;
    }
    public List<AdminDTO> getAdmin(){
        List<AdminDTO> adminDTOList = acSaleMapper.getAdmin();
        return adminDTOList;
    }

    //입력
    public int addAcSale(AcSale acSale){
        return acSaleMapper.addAcSale(acSale);
    }

    //수정
    public AcSale getAcPurchaseInfoByModifyId(Long accountingSalesAdminIdx
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
            , String accountingSalesAdminFinishUpdate ){
        AcSale acSaleInfo = acSaleMapper.getAcPurchaseInfoByModifyId(accountingSalesAdminIdx
                , companyIdx
                , inventoryIdx
                , companyContractIdx
                , accountingSalesAdminDateS
                , accountingSalesAdminDate
                , accountingSalesAdminType
                , accountingSalesAdminPayment
                , accountingSalesAdminSum
                , adminUsername
                , accountingSalesAdminUpdate
                , accountingSalesAdminFinishUpdate);
        return acSaleInfo;
    }

    public void modifyAcSale(Long accountingSalesAdminIdx
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
            , String accountingSalesAdminFinishUpdate ){
        acSaleMapper.modifyAcSale(accountingSalesAdminIdx
                , companyIdx
                , inventoryIdx
                , companyContractIdx
                , accountingSalesAdminDateS
                , accountingSalesAdminDate
                , accountingSalesAdminType
                , accountingSalesAdminPayment
                , accountingSalesAdminSum
                , adminUsername
                , accountingSalesAdminUpdate
                , accountingSalesAdminFinishUpdate);
    }




    //삭제
    public  AcSale getAcSaleInfoByDeleteId(Long accountingSalesAdminIdx){
        AcSale acSaleInfoByDelete = acSaleMapper.getAcSaleInfoByDeleteId(accountingSalesAdminIdx);
        return acSaleInfoByDelete;
    }

    public  void deleteAcSale(Long accountingSalesAdminIdx){
        acSaleMapper.deleteAcSaleByIdx(accountingSalesAdminIdx);
    }






}
