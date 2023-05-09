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


}







