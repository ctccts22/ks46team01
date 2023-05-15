package ks46team01.user.compost.service;

import ks46team01.common.compost.dto.CompanyContract;
import ks46team01.common.compost.dto.OrderCompostConfirm;
import ks46team01.common.compost.dto.OrderCompostDelivery;
import ks46team01.user.compost.mapper.UserCompostMapper;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class UserCompostOrderServiceImpl implements UserCompostOrderService {
    private final UserCompostMapper userCompostMapper;

    public UserCompostOrderServiceImpl(UserCompostMapper userCompostMapper) {
        this.userCompostMapper = userCompostMapper;
    }

    @Override
    public List<CompanyContract> companyinfoList(String userId) {
        List<CompanyContract> userCompanyInfo = userCompostMapper.userCompanyInfo(userId);
        return userCompanyInfo;
    }

    @Override
    public int compostOrderInsert(HashMap<String, Object> map) {
        int result = userCompostMapper.insertOrderCompost(map);
        return result;
    }

    @Override
    public List<OrderCompostConfirm> compostConfirmList(String userId) {
        List<OrderCompostConfirm> userConfirmList = userCompostMapper.userConfirmList(userId);
        return userConfirmList;
    }

    @Override
    public void userCompostDeliveryUpdate(OrderCompostDelivery ocd) {
        userCompostMapper.userCompostDeliveryUpdate(ocd);
    }

    @Override
    public List<OrderCompostDelivery> compostDeliveryList(String userId) {
        List<OrderCompostDelivery> userCompostDeliveryList = userCompostMapper.userCompostDeliveryList(userId);
        return userCompostDeliveryList;
    }
}
