package ks46team01.mushroom.mushroomPurchase.service;


import ks46team01.admin.company.contract.entity.CompanyContract;
import ks46team01.admin.company.entity.Company;
import ks46team01.admin.inventory.entity.Inventory;
import ks46team01.common.company.info.entity.CompanyInfo;
import ks46team01.mushroom.mushroomPurchase.dto.FarmPurchase;
import ks46team01.mushroom.mushroomPurchase.mapper.FarmPurchaseMapper;
import ks46team01.user.info.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FarmPurchaseService {
    private final FarmPurchaseMapper farmPurchaseMapper;
    public FarmPurchaseService(FarmPurchaseMapper farmPurchaseMapper) {
        this.farmPurchaseMapper = farmPurchaseMapper;
    }

    //조회
    public List<FarmPurchase> getListPurchaseAccount(){
        List<FarmPurchase> farmPurchaseList = farmPurchaseMapper.getListPurchaseAccount();
        return farmPurchaseList;
    }
    public List<User> getUserIdx(){
        List<User> userList = farmPurchaseMapper.getUserIdx();
        return userList;
    }
    public  List<Company> getCompanyIdx(){
        List<Company> companyList = farmPurchaseMapper.getCompanyIdx();
        return companyList;
    }
    public  List<CompanyInfo> getCompanyInfoIdx(){
        List<CompanyInfo> companyInfoList = farmPurchaseMapper.getCompanyInfoIdx();
        return companyInfoList;
    }
    public List<Inventory> getInventoryIdx(){
        List<Inventory> inventoryList = farmPurchaseMapper.getInventoryIdx();
        return inventoryList;
    }
    public List<CompanyContract> getCompanyContractIdx(){
        List<CompanyContract> companyContractList = farmPurchaseMapper.getCompanyContractIdx();
        return companyContractList;
    }

    //입력
    public int addPurchaseAccount(FarmPurchase farmPurchase){
        return farmPurchaseMapper.addPurchaseAccount(farmPurchase);
    }

    //수정
    public FarmPurchase getPurchaseAccountInfoByIdx(Long accountingPurchaseIdx
                                            , String username
                                            , Long companyInfoIdx
                                            , Long companyIdx
                                            , Long inventoryIdx
                                            , Long companyContractIdx
                                            , String accountingPurchaseDate
                                            , String accountingPurchaseType
                                            , int accountingPurchaseUnitPrice
                                            , double accountingPurchaseAmount
                                            , String accountingPurchasePayment
                                            , int accountingPurchaseSum
                                            , String accountingPurchaseCode){
        FarmPurchase farmPurchaseInfo = farmPurchaseMapper.getPurchaseAccountInfoByIdx(
                accountingPurchaseIdx
                ,  username
                ,  companyInfoIdx
                ,  companyIdx
                ,  inventoryIdx
                ,  companyContractIdx
                ,  accountingPurchaseDate
                ,  accountingPurchaseType
                ,  accountingPurchaseUnitPrice
                ,  accountingPurchaseAmount
                ,  accountingPurchasePayment
                ,  accountingPurchaseSum
                ,  accountingPurchaseCode);
        return  farmPurchaseInfo;
    }

    public void modifyPurchaseAccount(Long accountingPurchaseIdx
                            , String username
                            , Long companyInfoIdx
                            , Long companyIdx
                            , Long inventoryIdx
                            , Long companyContractIdx
                            , String accountingPurchaseDate
                            , String accountingPurchaseType
                            , int accountingPurchaseUnitPrice
                            , double accountingPurchaseAmount
                            , String accountingPurchasePayment
                            , int accountingPurchaseSum
                            , String accountingPurchaseCode){
        farmPurchaseMapper.modifyPurchaseAccount( accountingPurchaseIdx
                                    ,  username
                                    ,  companyInfoIdx
                                    ,  companyIdx
                                    ,  inventoryIdx
                                    ,  companyContractIdx
                                    ,  accountingPurchaseDate
                                    ,  accountingPurchaseType
                                    ,  accountingPurchaseUnitPrice
                                    ,  accountingPurchaseAmount
                                    ,  accountingPurchasePayment
                                    ,  accountingPurchaseSum
                                    ,  accountingPurchaseCode);
    }



    //삭제
    public FarmPurchase getPurchaseAccountDeleteInfoByIdx(Long accountingPurchaseIdx){
        FarmPurchase farmPurchaseInfoDelete = farmPurchaseMapper.getPurchaseAccountDeleteInfoByIdx(accountingPurchaseIdx);
        return farmPurchaseInfoDelete;
    }

    public void deletePurchaseAccountByIdx(Long accountingPurchaseIdx){
        farmPurchaseMapper.deletePurchaseAccountByIdx(accountingPurchaseIdx);
    }

}





