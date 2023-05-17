package ks46team01.admin.wasted.service;

import ks46team01.admin.wasted.mapper.WastedMapper;
import ks46team01.common.wasted.dto.OrderWasted;
import ks46team01.common.wasted.dto.OrderWastedConfirm;
import ks46team01.common.wasted.dto.OrderWastedDelivery;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WastedServiceImpl implements WastedService{
    private final WastedMapper wastedMapper;

    public WastedServiceImpl(WastedMapper wastedMapper) {
        this.wastedMapper = wastedMapper;
    }

    @Override
    public List<OrderWastedConfirm> wastedList() {
        List<OrderWastedConfirm> wastedList =  wastedMapper.wastedList();
        return wastedList;
    }

    @Override
    public void wastedConfirmInsert(OrderWastedConfirm wastedConfirm) {
        wastedMapper.wastedConfirmInsert(wastedConfirm);
    }

    @Override
    public List<OrderWastedConfirm> wastedConfirmList() {
        List<OrderWastedConfirm> wastedConfirmList = wastedMapper.wastedConfirmList();
        return wastedConfirmList;
    }

    @Override
    public List<OrderWastedDelivery> wastedDeliveryList() {
        List<OrderWastedDelivery> wastedDeliveryList = wastedMapper.wastedDeliveryList();
        return wastedDeliveryList;
    }

    @Override
    public void wastedDeliveryInsert(OrderWastedDelivery owd) {
        wastedMapper.wastedDeliveryInsert(owd);
    }
}
