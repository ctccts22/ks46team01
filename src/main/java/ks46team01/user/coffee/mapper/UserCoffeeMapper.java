package ks46team01.user.coffee.mapper;

import ks46team01.common.coffee.dto.CoffeeDelivery;
import ks46team01.common.coffee.dto.CoffeeRequestConfirm;
import ks46team01.common.company.info.dto.CompanyInfoDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface UserCoffeeMapper {
    public List<CoffeeRequestConfirm> listCoffeeConfirm(String userId); //커피가루 수거신청 상태확인
    public int insertCoffeeRequest(HashMap<String,Object> map); //커피 수거신청
    public CompanyInfoDTO listCompanyCode(String userId); //사업자 정보확인
    public List<CoffeeDelivery> listCoffeeDelivery(String userId); // 커피가루 배송상태 조회
    public void deliveryInsert(CoffeeDelivery cd); // 카페회원 커피가루 배송
}
