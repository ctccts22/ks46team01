package ks46team01.mushroom.mushroomGrowth.service;

import ks46team01.common.company.info.entity.CompanyInfo;
import ks46team01.crop.dto.Crop;
import ks46team01.mushroom.mushroomFarmData.dto.FarmData;
import ks46team01.mushroom.mushroomGrowth.dto.FarmMushroomGrowth;
import ks46team01.mushroom.mushroomGrowth.mapper.FarmMushroomGrowthMapper;
import ks46team01.user.info.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

@Service
@Transactional
public class FarmMushroomGrowthService {
    private final FarmMushroomGrowthMapper farmMushroomGrowthMapper;
    public FarmMushroomGrowthService(FarmMushroomGrowthMapper farmMushroomGrowthMapper) {
        this.farmMushroomGrowthMapper = farmMushroomGrowthMapper;
    }

    //조회
    public List<FarmMushroomGrowth> getFarmGrowth(){
        List<FarmMushroomGrowth> farmMushroomGrowthList = farmMushroomGrowthMapper.getFarmGrowth();
        return farmMushroomGrowthList;
    }
    public  List<User> getUserIdx(){
        List<User> userList = farmMushroomGrowthMapper.getUserIdx();
        return userList;
    }
    public  List<FarmData> getFarmData(){
        List<FarmData> farmDataList = farmMushroomGrowthMapper.getFarmData();
        return farmDataList;
    }
    public  List<CompanyInfo> getCompanyInfo(){
        List<CompanyInfo> companyInfoList = farmMushroomGrowthMapper.getCompanyInfo();
        return companyInfoList;
    }
    public  List<Crop> getCropIdx(){
        List<Crop> cropList = farmMushroomGrowthMapper.getCropIdx();
        return cropList;
    }

    //입력
    public int addFarmGrown(FarmMushroomGrowth farmMushroomGrowth){
        return farmMushroomGrowthMapper.addFarmGrownMushroom(farmMushroomGrowth);
    }

    //특정 IDX 조회
    public FarmMushroomGrowth getDataGrownInfoByIdx(    Long mushroomGrowthIdx
                                            , String username
                                            , Long companyInfoIdx
                                            , Long farmDataIdx
                                            , Long cropIdx
                                            , int mushroomGrowthDaily
                                            , String mushroomGrowthStatus
                                            , Timestamp mushroomGrowthDate
                                            , String mushroomGrowthContent){
        FarmMushroomGrowth farmMushroomGrowth = farmMushroomGrowthMapper.getDataGrownInfoByIdx(mushroomGrowthIdx
                                                                            , username
                                                                            , companyInfoIdx
                                                                            , farmDataIdx
                                                                            , cropIdx
                                                                            , mushroomGrowthDaily
                                                                            , mushroomGrowthStatus
                                                                            , mushroomGrowthDate
                                                                            , mushroomGrowthContent);
        return farmMushroomGrowth;
    }
    //수정
    public void modifyDataGrown(Long mushroomGrowthIdx
                            , String username
                            , Long companyInfoIdx
                            , Long farmDataIdx
                            , Long cropIdx
                            , int mushroomGrowthDaily
                            , String mushroomGrowthStatus
                            , Timestamp mushroomGrowthDate
                            , String mushroomGrowthContent){
        farmMushroomGrowthMapper.modifyDataGrown(mushroomGrowthIdx
                                , username
                                , companyInfoIdx
                                , farmDataIdx
                                , cropIdx
                                , mushroomGrowthDaily
                                , mushroomGrowthStatus
                                , mushroomGrowthDate
                                , mushroomGrowthContent);
    }

    //수정



    //삭제
    public FarmMushroomGrowth getDataGrownInfoByDeleteIdx(Long mushroomGrowthIdx ){
        FarmMushroomGrowth farmMushroomGrowth = farmMushroomGrowthMapper.getDataGrownInfoByDeleteIdx(mushroomGrowthIdx);
        return farmMushroomGrowth;
    }

    public void deleteDataGrown(Long mushroomGrowthIdx){
        farmMushroomGrowthMapper.deleteDataGrownByIdx(mushroomGrowthIdx);
    }

}

