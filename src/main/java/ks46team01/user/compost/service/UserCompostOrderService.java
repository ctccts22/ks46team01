package ks46team01.user.compost.service;

import ks46team01.common.compost.dto.CompanyContract;
import ks46team01.common.compost.dto.OrderCompostConfirm;
import ks46team01.common.compost.dto.OrderCompostDelivery;

import java.util.HashMap;
import java.util.List;

public interface UserCompostOrderService {
    public List<CompanyContract> companyinfoList(String userId); // 사업자 정보
    public int compostOrderInsert (HashMap<String,Object> map); // 커피배지 주문신청
    public List<OrderCompostConfirm> compostConfirmList(String userId); // 유저 승인상태 확인

    public void userCompostDeliveryUpdate(OrderCompostDelivery ocd);
    public List<OrderCompostDelivery> compostDeliveryList(String userId); // 유저 배송상태 조회
}
