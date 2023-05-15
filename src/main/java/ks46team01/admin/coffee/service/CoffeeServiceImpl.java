package ks46team01.admin.coffee.service;

import ks46team01.admin.coffee.mapper.CoffeeMapper;
import ks46team01.admin.inventories.log.service.InventoryLogService;
import ks46team01.common.coffee.dto.CoffeeDelivery;
import ks46team01.common.coffee.dto.CoffeeRequest;
import ks46team01.common.coffee.dto.CoffeeRequestConfirm;
import ks46team01.common.company.info.dto.CompanyInfoDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
@AllArgsConstructor
public class CoffeeServiceImpl implements CoffeeService{

    private final CoffeeMapper coffeeMapper;
    private final InventoryLogService inventoryLogService;
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

    @Override
    public void updateDelivery(Long coffeeDeliveryIdx) {
        coffeeMapper.updateDelivery(coffeeDeliveryIdx);
    }

    // 커피가루 배달상태 조회
    @Override
    public List<CoffeeDelivery> listDeliveryCoffee() {
        return null;
    }

    @Override
    public List<CompanyInfoDTO> listConfirmCompanyInfo() {
        List<CompanyInfoDTO> companyInfoList = coffeeMapper.listConfirmCompanyInfo();
        return companyInfoList;
    }



    @Override
    public List<CoffeeDelivery> listCoffeeDelivery() {
        List<CoffeeDelivery> deliveryList = coffeeMapper.listCoffeeDelivery();
        return deliveryList;
    }


    @Override
    public void insertConfirmCoffeeAdmin(CoffeeRequestConfirm confirm) {
        coffeeMapper.insertConfirmCoffeeAdmin(confirm);
    }

}
