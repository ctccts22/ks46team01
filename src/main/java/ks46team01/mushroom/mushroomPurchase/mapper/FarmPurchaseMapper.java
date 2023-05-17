package ks46team01.mushroom.mushroomPurchase.mapper;



import ks46team01.admin.company.dto.CompanyDTO;
import ks46team01.common.company.info.dto.CompanyInfoDTO;
import ks46team01.common.compost.dto.CompanyContract;
import ks46team01.common.compost.dto.Inventory;
import ks46team01.mushroom.mushroomPurchase.dto.FarmPurchase;
import ks46team01.user.info.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FarmPurchaseMapper {
    //조회
    List<FarmPurchase> getListPurchaseAccount();
    List<UserDTO> getUserIdx();
    List<CompanyDTO> getCompanyIdx();
    List<CompanyInfoDTO> getCompanyInfoIdx();
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
