package ks46team01.admin.farm.mapper;

import ks46team01.common.farm.dto.FarmPickupConfirm;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminFarmMapper {
    public List<FarmPickupConfirm> farmPickupConfirmList();
}
