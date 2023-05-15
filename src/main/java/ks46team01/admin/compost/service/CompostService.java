package ks46team01.admin.compost.service;

import ks46team01.common.compost.dto.OrderCompost;
import ks46team01.common.compost.dto.OrderCompostConfirm;
import ks46team01.common.compost.dto.OrderCompostDelivery;

import java.util.List;

public interface CompostService {
    public List<OrderCompostConfirm> orderCompostList();
    public void orderCompostConfirmInsert(OrderCompostConfirm occ);
    public List<OrderCompostConfirm> orderCompostConfirmList();
    public List<OrderCompostDelivery> orderCompostDeliveryList();
    public void orderCompostDeliveryInsert(OrderCompostDelivery ocd);
}
