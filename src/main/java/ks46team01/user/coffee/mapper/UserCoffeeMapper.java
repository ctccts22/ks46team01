package ks46team01.user.coffee.mapper;

import ks46team01.common.coffee.dto.CompanyInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserCoffeeMapper {
    //커피가루 수거신청
//    public int insertCoffeeRequest(String coffee, String userId, String amount, String address, String requestDate, String phone, String message);
    public CompanyInfo listCompanyCode(String userId);
}
