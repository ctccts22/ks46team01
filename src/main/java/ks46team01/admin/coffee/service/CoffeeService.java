package ks46team01.admin.coffee.service;

import ks46team01.common.coffee.dto.CoffeeDelivery;
import ks46team01.common.coffee.dto.CoffeeRequest;

import ks46team01.common.coffee.dto.CoffeeRequestConfirm;
import ks46team01.common.company.info.dto.CompanyInfoDTO;


import java.util.List;

public interface CoffeeService {
    public List<CoffeeRequest> listCoffeeAdmin(); //커피가루 수거신청 조회
    public List<CoffeeRequestConfirm> listConfirmCoffee(); // 커피가루 승인상태 조회

    public List<CoffeeDelivery> listDeliveryCoffee(); // 커피가루 배달상태 조회
    public List<CompanyInfoDTO> listConfirmCompanyInfo(); // 커피가루 승인상태조회 사업자 테이블 데이터
    public List<CoffeeDelivery> listCoffeeDelivery();
    public void insertConfirmCoffeeAdmin(CoffeeRequestConfirm confirm); // 커피가루 수거신청 승인/거절

}
