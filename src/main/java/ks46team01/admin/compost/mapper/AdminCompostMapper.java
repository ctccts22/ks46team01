package ks46team01.admin.compost.mapper;

import ks46team01.common.coffee.dto.CoffeeRequestConfirm;
import ks46team01.common.compost.dto.OrderCompostConfirm;
import ks46team01.common.compost.dto.OrderCompostDelivery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminCompostMapper {
    public List<OrderCompostConfirm> orderCompostList(); // 커피배지 수거신청 리스트
    
    public void orderCompostConfirmInsert(OrderCompostConfirm occ); //커피배지 수거신청 승인/거절 insert
    public List<OrderCompostConfirm> orderCompostConfirmList(); // 커피배지 수거신청 승인/거절 List
    public List<OrderCompostDelivery> orderCompostDeliveryList(); // 커피배지 배송조회
}
