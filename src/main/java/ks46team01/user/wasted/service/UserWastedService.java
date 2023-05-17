package ks46team01.user.wasted.service;

import ks46team01.common.wasted.dto.CompanyDTO;

import java.util.HashMap;
import java.util.List;

public interface UserWastedService {
    public CompanyDTO companyInfo(String id);
    public void insertWasted(HashMap<String,Object> map);
    public List<CompanyDTO> listWasted(String userId);
    public List<CompanyDTO> listDelivery(String userId);
    public void wastedDeliveryUpdate(Long orderWastedDeliveryIdx);
}
