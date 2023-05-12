package ks46team01.admin.compost.service;

import ks46team01.admin.compost.mapper.AdminCompostMapper;
import ks46team01.common.compost.dto.OrderCompostConfirm;
import ks46team01.common.compost.dto.OrderCompostDelivery;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompostServiceImpl implements CompostService{
    private final AdminCompostMapper compostMapper;

    public CompostServiceImpl(AdminCompostMapper compostMapper) {
        this.compostMapper = compostMapper;
    }


    @Override
    public List<OrderCompostConfirm> orderCompostList() {
        List<OrderCompostConfirm> listOrderCompost = compostMapper.orderCompostList();
        return listOrderCompost;
    }

    @Override
    public void orderCompostConfirmInsert(OrderCompostConfirm occ) {
        compostMapper.orderCompostConfirmInsert(occ);
    }

    @Override
    public List<OrderCompostConfirm> orderCompostConfirmList() {
        List<OrderCompostConfirm> confirmList = compostMapper.orderCompostConfirmList();
        return confirmList;
    }

    @Override
    public List<OrderCompostDelivery> orderCompostDeliveryList() {
        List<OrderCompostDelivery> deliveryList = compostMapper.orderCompostDeliveryList();
        return deliveryList;
    }

}
