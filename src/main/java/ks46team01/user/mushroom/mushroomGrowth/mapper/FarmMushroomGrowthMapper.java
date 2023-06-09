package ks46team01.user.mushroom.mushroomGrowth.mapper;

import ks46team01.user.mushroom.mushroomFarmData.dto.FarmData;
import ks46team01.user.info.dto.UserDTO;
import ks46team01.common.company.info.dto.CompanyInfoDTO;
import ks46team01.crop.dto.Crop;
import ks46team01.user.mushroom.mushroomGrowth.dto.FarmMushroomGrowth;

import org.apache.ibatis.annotations.Mapper;

import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface FarmMushroomGrowthMapper {
    //조회
    List<FarmMushroomGrowth> getFarmGrowth();
    List<UserDTO> getUserIdx();
    List<FarmData> getFarmData();
    List<CompanyInfoDTO> getCompanyInfo();
    List<Crop> getCropIdx();

    //입력
    int addFarmGrownMushroom(FarmMushroomGrowth farmMushroomGrowth);
    //특정회원조회
    FarmMushroomGrowth getDataGrownInfoByIdx(Long mushroomGrowthIdx
                                        , String username
                                        , Long companyInfoIdx
                                        , Long farmDataIdx
                                        , Long cropIdx
                                        , int mushroomGrowthDaily
                                        , String mushroomGrowthStatus
                                        , Timestamp mushroomGrowthDate
                                        , String mushroomGrowthContent);

    //수정
    void modifyDataGrown(Long mushroomGrowthIdx
            , String username
            , Long companyInfoIdx
            , Long farmDataIdx
            , Long cropIdx
            , int mushroomGrowthDaily
            , String mushroomGrowthStatus
            , Timestamp mushroomGrowthDate
            , String mushroomGrowthContent);


    //삭제
    FarmMushroomGrowth getDataGrownInfoByDeleteIdx(Long mushroomGrowthIdx);

    void deleteDataGrownByIdx(Long mushroomGrowthIdx);

}
