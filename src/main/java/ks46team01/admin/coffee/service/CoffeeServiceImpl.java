package ks46team01.admin.coffee.service;

import ks46team01.common.coffee.dto.CoffeeDelivery;
import ks46team01.common.coffee.dto.CoffeeRequest;
import ks46team01.common.coffee.dto.CoffeeRequestConfirm;

import java.util.List;

public class CoffeeServiceImpl implements CoffeeService{

    //커피가루 수거신청 리스트
    @Override
    public List<CoffeeRequest> listCoffeeAdmin() {
        return null;
    }
    // 커피가루 승인상태 확인
    @Override
    public List<CoffeeRequestConfirm> listConfirmCoffee() {
        return null;
    }
    // 커피가루 배달상태 조회
    @Override
    public List<CoffeeDelivery> listDeliveryCoffee() {
        return null;
    }
}
