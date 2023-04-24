package ks46team01.user.coffee.service;

import ks46team01.common.coffee.dto.CompanyInfo;

import java.util.HashMap;

public interface UserCoffeeService {

    
    public CompanyInfo listCompanyCode(String userId); // 사업자 확인

    public int insertCoffeeRequest(HashMap<String,Object> map); //커피가루 수거신청
}
