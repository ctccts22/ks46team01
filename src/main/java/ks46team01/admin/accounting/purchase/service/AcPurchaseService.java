package ks46team01.admin.accounting.purchase.service;


import ks46team01.admin.accounting.purchase.dto.AcPurchase;
import ks46team01.admin.accounting.purchase.mapper.AcPurchaseMapper;
import ks46team01.admin.company.dto.CompanyDTO;
import ks46team01.admin.info.dto.AdminDTO;
import ks46team01.admin.inventories.inventory.dto.InventoryDTO;
import ks46team01.common.company.contract.dto.CompanyContractDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class AcPurchaseService {
    private final AcPurchaseMapper acPurchaseMapper;
    public AcPurchaseService(AcPurchaseMapper acPurchaseMapper) {
        this.acPurchaseMapper = acPurchaseMapper;
    }

    //조회
    public List<AcPurchase> getAcPurchase() {
        List<AcPurchase> acPurchases = acPurchaseMapper.getAcPurchase();
        return acPurchases;
    }
    //관련테이블 조회
    public  List<CompanyDTO> getCompany(){
        List<CompanyDTO> companies = acPurchaseMapper.getCompany();
        return companies;
    }
    public  List<InventoryDTO> getInventory(){
        List<InventoryDTO> inventories = acPurchaseMapper.getInventory();
        return inventories;
    }
    public  List<CompanyContractDTO> getCompanyContract(){
        List<CompanyContractDTO> companyContracts = acPurchaseMapper.getCompanyContract();
        return companyContracts;
    }
    public List<AdminDTO> getAdmin(){
        List<AdminDTO> admins =acPurchaseMapper.getAdmin();
        return admins;
    }

    //입력
    public int addAcPurchase(AcPurchase acPurchase){
        return acPurchaseMapper.addAcPurchase(acPurchase);
    }



    //수정
    public AcPurchase getAcPurchaseInfoByModifyId( Long accountingPurchaseAdminIdx
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
            , Timestamp accountingPurchaseAdminUpdate){
        AcPurchase acPurchaseInfo = acPurchaseMapper.getAcPurchaseInfoByModifyId(accountingPurchaseAdminIdx
                                        ,  companyIdx
                                        ,  inventoryIdx
                                        ,  companyContractIdx
                                        ,  accountingPurchaseAdminDateS
                                        ,  accountingPurchaseAdminDate
                                        ,  accountingPurchaseAdminPrice
                                        ,  accountingPurchaseAdminAmount
                                        ,  accountingPurchaseAdminPayment
                                        ,  accountingPurchaseAdminSum
                                        ,  adminUsername
                                        ,  accountingPurchaseAdminUpdate);
        return acPurchaseInfo;
    }
    public void modifyAcPurchase(Long accountingPurchaseAdminIdx
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
            , Timestamp accountingPurchaseAdminUpdate){
        acPurchaseMapper.modifyAcPurchase(accountingPurchaseAdminIdx
                                ,  companyIdx
                                ,  inventoryIdx
                                ,  companyContractIdx
                                ,  accountingPurchaseAdminDateS
                                ,  accountingPurchaseAdminDate
                                ,  accountingPurchaseAdminPrice
                                ,  accountingPurchaseAdminAmount
                                ,  accountingPurchaseAdminPayment
                                ,  accountingPurchaseAdminSum
                                ,  adminUsername
                                ,  accountingPurchaseAdminUpdate);
    }



    //삭제
    public  AcPurchase getAcPurchaseInfoByDeleteId(Long accountingPurchaseAdminIdx){
        AcPurchase acPurchaseInfoByDelete = acPurchaseMapper.getAcPurchaseInfoByDeleteId(accountingPurchaseAdminIdx);
        return acPurchaseInfoByDelete;
    }

    public void deleteAcPurchase(Long accountingPurchaseAdminIdx){
        acPurchaseMapper.deleteAcPurchaseByIdx(accountingPurchaseAdminIdx);
    }



}


















