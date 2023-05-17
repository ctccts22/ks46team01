package ks46team01.common.farm.dto;

import lombok.Data;

@Data
public class FarmPickupDelivery extends FarmPickupConfirm{
    private Long farmPickupDeliveryIdx;
    private Long farmPickupRequestIdx;
    private String username;
    private Long companyInfoIdx;
    private String farmPickupDeliveryStatus;
    private String farmPickupDeliveryCompany;
    private String farmPickupDeliveryComplete;
    private String farmPickupDeliveryTrack;
}
