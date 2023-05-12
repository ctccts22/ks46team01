package ks46team01.mushroom.mushroomPurchase.mapper;



import ks46team01.admin.company.contract.entity.CompanyContract;
import ks46team01.admin.company.entity.Company;
import ks46team01.admin.inventory.entity.Inventory;
import ks46team01.common.company.info.entity.CompanyInfo;
import ks46team01.mushroom.mushroomPurchase.dto.FarmPurchase;
import ks46team01.user.info.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FarmPurchaseMapper {
    //조회
    List<FarmPurchase> getListPurchaseAccount();
    List<User> getUserIdx();
    List<Company> getCompanyIdx();
    List<CompanyInfo> getCompanyInfoIdx();
    List<Inventory> getInventoryIdx();
    List<CompanyContract> getCompanyContractIdx();

    // 입력
    int addPurchaseAccount(FarmPurchase farmPurchase);

    // 특정 코드 조회
    FarmPurchase getPurchaseAccountInfoByIdx(Long accountingPurchaseIdx
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
                                    , String accountingPurchaseCode);

    //수정
    void modifyPurchaseAccount(Long accountingPurchaseIdx
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
            , String accountingPurchaseCode);

    //삭제
    FarmPurchase getPurchaseAccountDeleteInfoByIdx(Long accountingPurchaseIdx);
    void deletePurchaseAccountByIdx(Long accountingPurchaseIdx);

}
