package ks46team01.common.farm.dto;

import lombok.Data;

@Data
public class FarmPickupConfirm extends FarmPickupRequest{
    private Long farmPickupConfirmIdx;
    private Long farmPickupRequestIdx;
    private String userName;
    private Long companyInfoIdx;
    private String farmPickupConfirmStatus;
    private String farmPickupConfirmContent;
    private String adminUsername;
    private String farmPickupConfirmDate;
}
