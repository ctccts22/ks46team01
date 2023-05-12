package ks46team01.common.compost.dto;

import lombok.Data;

@Data
public class OrderCompostDelivery extends OrderCompostConfirm{
    private Long orderCompostDeliveryIdx;
    private Long orderCompostIdx;
    private String userName;
    private Long companyInfoIdx;
    private String orderCompostDeliveryTrack;
    private String orderCompostDeliveryStatus;
    private String orderCompostDeliveryCompany;
    private String orderCompostDeliveryComplete;
}
