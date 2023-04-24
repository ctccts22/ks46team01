package ks46team01.admin.coffee.service;

import ks46team01.admin.coffee.mapper.CoffeeMapper;
import ks46team01.common.coffee.dto.CoffeeDelivery;
import ks46team01.common.coffee.dto.CoffeeRequest;
import ks46team01.common.coffee.dto.CoffeeRequestConfirm;
import ks46team01.common.coffee.dto.CompanyInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CoffeeServiceImpl implements CoffeeService{

    @Autowired
    private CoffeeMapper coffeeMapper;
    //커피가루 수거신청 리스트
    @Override
    public List<CoffeeRequest> listCoffeeAdmin() {
        List<CoffeeRequest> coffeeAdmin = coffeeMapper.listCoffeeAdmin();
        return coffeeAdmin;
    }
    // 커피가루 승인상태 확인
    @Override
    public List<CoffeeRequestConfirm> listConfirmCoffee() {
        System.out.println("ServiceImpl 실행?");
        List<CoffeeRequestConfirm> coffeeConfirmList = coffeeMapper.listConfirmCoffee();
        System.out.println("mapper 실행?");
        return coffeeConfirmList;
    }
    // 커피가루 배달상태 조회
    @Override
    public List<CoffeeDelivery> listDeliveryCoffee() {
        return null;
    }

    @Override
    public List<CompanyInfo> listConfirmCompanyInfo() {
        List<CompanyInfo> companyInfoList = coffeeMapper.listConfirmCompanyInfo();
        return companyInfoList;
    }

    @Override
    public List<CoffeeDelivery> listCoffeeDelivery() {
        List<CoffeeDelivery> deliveryList = coffeeMapper.listCoffeeDelivery();
        return deliveryList;
    }


}
