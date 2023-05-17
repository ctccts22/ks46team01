package ks46team01.user.wasted.service;

import ks46team01.common.wasted.dto.CompanyDTO;
import ks46team01.user.wasted.mapper.UserWastedMapper;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class UserWastedServiceImpl implements UserWastedService {
    private final UserWastedMapper userWastedMapper;

    public UserWastedServiceImpl(UserWastedMapper userWastedMapper) {
        this.userWastedMapper = userWastedMapper;
    }

    @Override
    public CompanyDTO companyInfo(String id) {
        CompanyDTO cd = userWastedMapper.companyInfo(id);
        return cd;
    }

    @Override
    public void insertWasted(HashMap<String, Object> map) {
        userWastedMapper.insertWasted(map);
    }

    @Override
    public List<CompanyDTO> listWasted(String userId) {
        List<CompanyDTO> cd = userWastedMapper.listWasted(userId);
        return cd;
    }

    @Override
    public List<CompanyDTO> listDelivery(String userId) {
        List<CompanyDTO> cd = userWastedMapper.listDeliveryWasted(userId);
        return cd;
    }

    @Override
    public void wastedDeliveryUpdate(Long orderWastedDeliveryIdx) {
        userWastedMapper.wastedDeliveryUpdate(orderWastedDeliveryIdx);
    }
}
