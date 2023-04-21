package ks46team01.user.coffee.service;

import ks46team01.common.coffee.dto.CompanyInfo;
public interface UserCoffeeService {

    
    public CompanyInfo listCompanyCode(String userId); // 사업자 확인

//    public int insertCoffeeRequest(String coffee, String userId, String amount, String address, String requestDate, String phone, String message); //커피가루 수거신청
}
