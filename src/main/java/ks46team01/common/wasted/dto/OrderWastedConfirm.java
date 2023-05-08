package ks46team01.common.wasted.dto;

import lombok.Data;

@Data
public class OrderWastedConfirm extends OrderWasted{
    private Long orderWastedConfirmIdx;
    private Long orderWastedIdx;
    private String userName;
    private Long companyInfoIdx;
    private String orderWastedConfirmStatus;
    private String orderWastedConfirmContent;
    private String adminUsername;
    private String orderWastedConfirmDate;

}
