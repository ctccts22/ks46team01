package ks46team01.common.wasted.dto;

import lombok.Data;

@Data
public class OrderWastedDelivery extends OrderWastedConfirm{
    private Long orderWastedDeliveryIdx;
    private Long orderWastedIdx;
    private String userName;
    private Long companyInfoIdx;
    private String orderWastedDeliveryStatus;
    private String orderWastedDeliveryCompany;
    private String orderWastedDeliveryComplete;
    private String orderWastedDeliveryTrack;
}
