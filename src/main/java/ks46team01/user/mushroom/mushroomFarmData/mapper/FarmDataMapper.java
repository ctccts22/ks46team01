package ks46team01.user.mushroom.mushroomFarmData.mapper;

import ks46team01.common.company.info.dto.CompanyInfoDTO;
import ks46team01.user.mushroom.mushroomFarmData.dto.FarmData;
import ks46team01.user.info.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface FarmDataMapper {

    //조회
    List<FarmData> getListFarmData();
    List<CompanyInfoDTO> getCompanyInfo();
    List<UserDTO> getUsernameInfo();

    //입력
    int addDataFarmMushroom(FarmData farmData);

    //특정 IDX 조회
    FarmData getFarmDataInfoByIdx(Long farmDataIdx
                        , String username
                        , Long companyInfoIdx
                        , Integer farmDataCompost
                        , Double farmDataProduction
                        , Integer farmDataExpectedSale
                        , Integer farmDataActualSale
                        , Date farmDataProductionDate
                        , Date farmDataOccurrenceSaleDate
                        , Double farmDataExpectedWasted
                        , Timestamp farmDataDate);
    //수정
    void modifyFarmData(Long farmDataIdx
                        , String username
                        , Long companyInfoIdx
                        , Integer farmDataCompost
                        , Double farmDataProduction
                        , Integer farmDataExpectedSale
                        , Integer farmDataActualSale
                        , Date farmDataProductionDate
                        , Date farmDataOccurrenceSaleDate
                        , Double farmDataExpectedWasted
                        , Timestamp farmDataDate);



    //삭제
    FarmData getFarmDataInfoByDeleteIdx(Long farmDataIdx);

    void deleteFarmDataByIdx(Long farmDataIdx);



}
