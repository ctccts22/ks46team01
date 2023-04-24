package ks46team01.common.coffee.dto;

import lombok.Data;

@Data
public class CoffeeDelivery extends CoffeeRequestConfirm{
    private Long coffeeDeliveryIdx; //배달 번호
    private Long coffeeRequestIdx; //요청 번호
    private Long companyInfoIdx; // 사업자 번호
    private String userName;
    private String coffeeDeliveryTrack;
    private String coffeeDeliveryStatus;
    private String coffeeDeliveryCompany;
    private String coffeeDeliveryComplete;


}
