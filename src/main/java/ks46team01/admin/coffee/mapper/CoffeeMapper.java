package ks46team01.admin.coffee.mapper;

import ks46team01.common.coffee.dto.CoffeeDelivery;
import ks46team01.common.coffee.dto.CoffeeRequestConfirm;
import ks46team01.common.coffee.dto.CoffeeRequest;



import ks46team01.common.company.info.dto.CompanyInfoDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CoffeeMapper {
    public List<CoffeeRequest> listCoffeeAdmin(); // 커피가루 수거신청 확인페이지
    public void insertConfirmCoffeeAdmin(CoffeeRequestConfirm confirm); // 커피가루 수거신청 승인/거절
    public List<CoffeeRequestConfirm> listConfirmCoffee(); //

    public List<CompanyInfoDTO> listConfirmCompanyInfo(); //
    
    public void updateDelivery(Long coffeeDeliveryIdx);// 배송중인 상품 배송완료로 변경
    public List<CoffeeDelivery> listCoffeeDelivery(); // 커피가루 배송리스트


}
