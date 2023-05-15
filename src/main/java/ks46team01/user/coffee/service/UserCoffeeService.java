package ks46team01.user.coffee.service;

import ks46team01.common.coffee.dto.CoffeeDelivery;
import ks46team01.common.coffee.dto.CoffeeRequestConfirm;
import ks46team01.common.company.info.dto.CompanyInfoDTO;

import java.util.HashMap;
import java.util.List;

public interface UserCoffeeService {

    public List<CoffeeDelivery> listCoffeeDelivery(String userId); // 배송상태 조회
    public CompanyInfoDTO listCompanyCode(String userId); // 사업자 확인
    public List<CoffeeRequestConfirm> listCoffeeConfirm(String userId); // 커피가루 수거신청 승인상태확인
    public int insertCoffeeRequest(HashMap<String,Object> map); //커피가루 수거신청
}
