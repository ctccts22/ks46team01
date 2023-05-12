package ks46team01.admin.wasted.service;

import ks46team01.common.wasted.dto.OrderWasted;
import ks46team01.common.wasted.dto.OrderWastedConfirm;
import ks46team01.common.wasted.dto.OrderWastedDelivery;

import java.util.List;

public interface WastedService {
    public List<OrderWastedConfirm> wastedList();
    public void wastedConfirmInsert(OrderWastedConfirm wastedConfirm);
    public List<OrderWastedConfirm> wastedConfirmList();

    public List<OrderWastedDelivery> wastedDeliveryList();
}
