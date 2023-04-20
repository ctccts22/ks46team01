package ks46team01.admin.coffee.service;

import ks46team01.common.coffee.dto.CoffeeDelivery;
import ks46team01.common.coffee.dto.CoffeeRequest;
import org.springframework.stereotype.Service;
import ks46team01.common.coffee.dto.CoffeeRequestConfirm;

import java.util.List;

public interface CoffeeService {
    public List<CoffeeRequest> listCoffeeAdmin(); //커피가루 수거신청 조회
    public List<CoffeeRequestConfirm> listConfirmCoffee(); // 커피가루 승인상태 조회
    public List<CoffeeDelivery> listDeliveryCoffee(); // 커피가루 배달상태 조회

}
