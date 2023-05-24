package ks46team01.user.mushroom.mushroomFarmData.service;


import ks46team01.common.company.info.dto.CompanyInfoDTO;
import ks46team01.user.mushroom.mushroomFarmData.dto.FarmData;
import ks46team01.user.mushroom.mushroomFarmData.mapper.FarmDataMapper;

import ks46team01.user.info.dto.UserDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Service
@Transactional
public class FarmDataService {
    private final FarmDataMapper farmDataMapper;

    public FarmDataService(FarmDataMapper farmDataMapper) {
        this.farmDataMapper = farmDataMapper;
    }


    //조회
    public List<FarmData> getListFarmData() {
        List<FarmData> farmDataList = farmDataMapper.getListFarmData();
        return farmDataList;
    }

    public List<CompanyInfoDTO> getCompanyInfo() {
        List<CompanyInfoDTO> companyInfo = farmDataMapper.getCompanyInfo();
        return companyInfo;
    }

    public List<UserDTO> getUsernameInfo() {
        List<UserDTO> usernameInfo = farmDataMapper.getUsernameInfo();
        return usernameInfo;
    }

    //입력
    public int addFarmData(FarmData farmData)  {
        return farmDataMapper.addDataFarmMushroom(farmData);
    }


    //수정
    public FarmData getFarmDataInfoByIdx(Long farmDataIdx
                                    , String username
                                    , Long companyInfoIdx
                                    , Integer farmDataCompost
                                    , Double farmDataProduction
                                    , Integer farmDataExpectedSale
                                    , Integer farmDataActualSale
                                    , Date farmDataProductionDate
                                    , Date farmDataOccurrenceSaleDate
                                    , Double farmDataExpectedWasted
                                    , Timestamp farmDataDate) {
        FarmData FarmDataInfoByIdx = farmDataMapper.getFarmDataInfoByIdx(farmDataIdx
                                                , username
                                                , companyInfoIdx
                                                , farmDataCompost
                                                , farmDataProduction
                                                , farmDataExpectedSale
                                                , farmDataActualSale
                                                , farmDataProductionDate
                                                , farmDataOccurrenceSaleDate
                                                , farmDataExpectedWasted
                                                , farmDataDate);
        return FarmDataInfoByIdx;
    }
    //수정
    public void modifyFarmData(Long farmDataIdx
                        , String username
                        , Long companyInfoIdx
                        , Integer farmDataCompost
                        , Double farmDataProduction
                        , Integer farmDataExpectedSale
                        , Integer farmDataActualSale
                        , Date farmDataProductionDate
                        , Date farmDataOccurrenceSaleDate
                        , Double farmDataExpectedWasted
                        , Timestamp farmDataDate){
        farmDataMapper.modifyFarmData(farmDataIdx
                        ,  username
                        ,  companyInfoIdx
                        ,  farmDataCompost
                        ,  farmDataProduction
                        ,  farmDataExpectedSale
                        ,  farmDataActualSale
                        ,  farmDataProductionDate
                        ,  farmDataOccurrenceSaleDate
                        ,  farmDataExpectedWasted
                        ,  farmDataDate);

    }

    //삭제
    public FarmData getFarmDataInfoByDeleteIdx(Long farmDataIdx){
        FarmData farmDataDelete = farmDataMapper.getFarmDataInfoByDeleteIdx(farmDataIdx);
        return farmDataDelete;
    }
    public void deleteFarmData(Long farmDataIdx){

        farmDataMapper.deleteFarmDataByIdx(farmDataIdx);
    }



}
