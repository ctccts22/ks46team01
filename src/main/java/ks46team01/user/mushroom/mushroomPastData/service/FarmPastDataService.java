package ks46team01.user.mushroom.mushroomPastData.service;

import ks46team01.common.company.info.entity.CompanyInfo;
import ks46team01.crop.dto.Crop;
import ks46team01.user.mushroom.mushroomPastData.dto.FarmPastData;
import ks46team01.user.mushroom.mushroomPastData.mapper.FarmPastDataMapper;
import ks46team01.user.info.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

@Service
@Transactional
public class FarmPastDataService {
    private final FarmPastDataMapper farmPastDataMapper;
    public FarmPastDataService(FarmPastDataMapper farmPastDataMapper){
        this.farmPastDataMapper = farmPastDataMapper;
    }


    //조회 List<FarmPastData>
    public List<FarmPastData> getFarmPastData(){
        List<FarmPastData> farmPastData = farmPastDataMapper.getListFarmPastData();
        return farmPastData;
    }
    //Crop
    public List<Crop> getCropIdx(){
        List<Crop> cropList = farmPastDataMapper.getCropIdx();
        return cropList;
    }
    //CompanyInfo
    public List<CompanyInfo> getCompanyInfo(){
        List<CompanyInfo> companyInfo = farmPastDataMapper.getCompanyInfo();
        return companyInfo;
    }

    //user
    public List<User> getUsernameInfo(){
        List<User> usernameInfo = farmPastDataMapper.getUsernameInfo();
        return usernameInfo;
    }


    //입력
    public int addFarmPastData(FarmPastData farmPastData){
        return farmPastDataMapper.addFarmPastData(farmPastData);
    }

    //수정 대상 조회
    public FarmPastData getFarmPastDataInfoById(Long pastDataIdx
                                        , String username
                                        , Long companyInfoIdx
                                        , Long cropIdx
                                        , String pastDataMushroomProduction
                                        , Integer pastDataTotalRevenue
                                        , Integer pastDataBadgeUse
                                        , Integer pastDataYear
                                        , String pastDataUse
                                        , String pastDataComparison
                                        , Timestamp pastDataDate
                                                ){
        FarmPastData farmPastDataInfo = farmPastDataMapper.getFarmPastDataInfoById(
                                             pastDataIdx
                                            ,  username
                                            ,  companyInfoIdx
                                            ,  cropIdx
                                            ,  pastDataMushroomProduction
                                            ,  pastDataTotalRevenue
                                            ,  pastDataBadgeUse
                                            ,  pastDataYear
                                            ,  pastDataUse
                                            ,  pastDataComparison
                                            ,  pastDataDate);
        return farmPastDataInfo;
    }
    //수정
    public void modifyFarmPastData(Long pastDataIdx
            , String username
            , Long companyInfoIdx
            , Long cropIdx
            , String pastDataMushroomProduction
            , Integer pastDataTotalRevenue
            , Integer pastDataBadgeUse
            , Integer pastDataYear
            , String pastDataUse
            , String pastDataComparison
            , Timestamp pastDataDate){
        farmPastDataMapper.modifyFarmPastData(
                pastDataIdx
                ,  username
                ,  companyInfoIdx
                ,  cropIdx
                ,  pastDataMushroomProduction
                ,  pastDataTotalRevenue
                ,  pastDataBadgeUse
                ,  pastDataYear
                ,  pastDataUse
                ,  pastDataComparison
                ,  pastDataDate
        );
    }


    //삭제
    public FarmPastData getFarmPastDataInfoByDeleteId(Long pastDataIdx){
        FarmPastData farmPastDataInfoDelete= farmPastDataMapper.getFarmPastDataInfoByDeleteId(pastDataIdx);

        return farmPastDataInfoDelete;
    }

    public void deleteFarmPastData(Long pastDataIdx){
        farmPastDataMapper.deleteFarmPastDataByIdx(pastDataIdx);
    }


}








