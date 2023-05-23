package ks46team01.user.mushroom.mushroomPastData.mapper;


import ks46team01.common.company.info.entity.CompanyInfo;
import ks46team01.crop.dto.Crop;
import ks46team01.user.mushroom.mushroomPastData.dto.FarmPastData;
import ks46team01.user.info.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface FarmPastDataMapper {
    //조회
    List<FarmPastData> getListFarmPastData();
    List<Crop> getCropIdx();
    List<CompanyInfo> getCompanyInfo();
    List<User> getUsernameInfo();


    //입력
    int addFarmPastData(FarmPastData farmPastData);

    //특정 정보 조회
    FarmPastData getFarmPastDataInfoById(Long pastDataIdx
                                    , String username
                                    , Long companyInfoIdx
                                    , Long cropIdx
                                    , String pastDataMushroomProduction
                                    , Integer pastDataTotalRevenue
                                    , Integer pastDataBadgeUse
                                    , Integer pastDataYear
                                    , String pastDataUse
                                    , String pastDataComparison
                                    , Timestamp pastDataDate);
    //수정
    void modifyFarmPastData(Long pastDataIdx
                        , String username
                        , Long companyInfoIdx
                        , Long cropIdx
                        , String pastDataMushroomProduction
                        , Integer pastDataTotalRevenue
                        , Integer pastDataBadgeUse
                        , Integer pastDataYear
                        , String pastDataUse
                        , String pastDataComparison
                        , Timestamp pastDataDate);






    //삭제
   FarmPastData getFarmPastDataInfoByDeleteId(Long pastDataIdx);

    void deleteFarmPastDataByIdx(Long pastDataIdx);



}
