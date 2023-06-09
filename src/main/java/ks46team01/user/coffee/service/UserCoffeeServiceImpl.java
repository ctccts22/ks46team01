package ks46team01.user.coffee.service;

import ks46team01.common.coffee.dto.CoffeeDelivery;
import ks46team01.common.coffee.dto.CoffeeRequestConfirm;
import ks46team01.common.company.info.dto.CompanyInfoDTO;
import ks46team01.user.coffee.mapper.UserCoffeeMapper;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class UserCoffeeServiceImpl implements UserCoffeeService {

        private final UserCoffeeMapper userCoffeeMapper;

    public UserCoffeeServiceImpl(UserCoffeeMapper userCoffeeMapper) {
        this.userCoffeeMapper = userCoffeeMapper;
    }

    @Override
    public List<CoffeeDelivery> listCoffeeDelivery(String userId) {
        List<CoffeeDelivery> listCoffeeDelivery = userCoffeeMapper.listCoffeeDelivery(userId);
        return listCoffeeDelivery;
    }

    @Override //사업자 조회
    public CompanyInfoDTO listCompanyCode(String userId) {
        CompanyInfoDTO ci = userCoffeeMapper.listCompanyCode(userId);
        return ci;
    }

    @Override //유저 커피신청 승인상태확인
    public List<CoffeeRequestConfirm> listCoffeeConfirm(String userId) {
        List<CoffeeRequestConfirm> listCoffeeConfirm = userCoffeeMapper.listCoffeeConfirm(userId);
        return listCoffeeConfirm;
    }

    @Override
    public int insertCoffeeRequest(HashMap<String, Object> map) {
        int result = userCoffeeMapper.insertCoffeeRequest(map);
        return result;
    }

    @Override
    public void deliveryInsert(CoffeeDelivery cd) {
        userCoffeeMapper.deliveryInsert(cd);
    }

//    @Override // 커피 수거신청
//    public int insertCoffeeRequest(String coffee, String userId, String amount, String address, String requestDate, String phone, String message) {
////        int result = userCoffeeMapper.insertCoffeeRequest(coffee,userId,amount,address,requestDate,phone,message);
//        return 0;
//    }
}
