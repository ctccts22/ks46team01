package ks46team01.admin.accounting.purchase.service;


import ks46team01.admin.accounting.purchase.dto.AcPurchase;
import ks46team01.admin.accounting.purchase.mapper.AcPurchaseMapper;
import ks46team01.admin.company.contract.entity.CompanyContract;
import ks46team01.admin.company.entity.Company;
import ks46team01.admin.info.entity.Admin;
import ks46team01.admin.inventory.entity.Inventory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public  List<Company> getCompany(){
        List<Company> companies = acPurchaseMapper.getCompany();
        return companies;
    }
    public  List<Inventory> getInventory(){
        List<Inventory> inventories = acPurchaseMapper.getInventory();
        return inventories;
    }
    public  List<CompanyContract> getCompanyContract(){
        List<CompanyContract> companyContracts = acPurchaseMapper.getCompanyContract();
        return companyContracts;
    }
    public List<Admin> getAdmin(){
        List<Admin> admins =acPurchaseMapper.getAdmin();
        return admins;
    }

    //입력
    public int addAcPurchase(AcPurchase acPurchase){
        return acPurchaseMapper.addAcPurchase(acPurchase);
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


















