package ks46team01.admin.coffee.mapper;

import ks46team01.common.coffee.dto.CoffeeRequestConfirm;
import ks46team01.common.coffee.dto.CoffeeRequest;
import ks46team01.common.coffee.dto.CoffeeDelivery;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CoffeeMapper {
    public List<CoffeeRequestConfirm> listConfirmCoffee();
}
