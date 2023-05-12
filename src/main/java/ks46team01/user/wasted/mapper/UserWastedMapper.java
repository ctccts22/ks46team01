package ks46team01.user.wasted.mapper;

import ks46team01.common.farm.dto.FarmData;
import ks46team01.common.wasted.dto.CompanyDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface UserWastedMapper {
    public CompanyDTO companyInfo(String userId);// 사업자 정보확인 유저
    public void insertWasted(HashMap<String,Object> map); // 폐배지 구매신청 사업자 회원
    public List<CompanyDTO> listWasted(String userId); // 폐배지 구매신청리스트 사업자 회원
    public List<CompanyDTO> listDeliveryWasted(String userId); //폐배지 배송정보 사업자 회원

}
