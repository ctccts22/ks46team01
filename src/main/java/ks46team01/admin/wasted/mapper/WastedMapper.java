package ks46team01.admin.wasted.mapper;

import ks46team01.common.wasted.dto.OrderWastedConfirm;
import ks46team01.common.wasted.dto.OrderWastedDelivery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WastedMapper {
    public List<OrderWastedConfirm> wastedList();
    public void wastedConfirmInsert(OrderWastedConfirm wastedConfirm);
    public List<OrderWastedConfirm> wastedConfirmList();
    public List<OrderWastedDelivery> wastedDeliveryList();
    public void wastedDeliveryInsert(OrderWastedDelivery owd);
}
