package ks46team01.common.farm.dto;

import lombok.Data;

@Data
public class FarmPickupRequest {
    private Long farmPickupRequestIdx;
    private Long farmDataIdx;
    private String userName;
    private Long companyInfoIdx;
    private Long farmPickupRequestAmount;
    private String farmPickupRequestPhone;
    private String farmPickupRequestAddress;
    private String farmPickupRequestContent;
    private String farmPickupRequestDate;


}
