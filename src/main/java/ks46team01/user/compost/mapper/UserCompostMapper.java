package ks46team01.user.compost.mapper;

import ks46team01.common.compost.dto.CompanyContract;
import ks46team01.common.compost.dto.OrderCompostConfirm;
import ks46team01.common.compost.dto.OrderCompostDelivery;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface UserCompostMapper {
    public int insertOrderCompost(HashMap<String,Object> map); //유저 커피배지 신청
    public List<CompanyContract> userCompanyInfo(String userId); // 유저 사업자 정보
    public List<OrderCompostConfirm> userConfirmList(String userId); // 유저 승인상태 확인

    public List<OrderCompostDelivery> userCompostDeliveryList(String userId); // 유저 배송상태 조회
}
