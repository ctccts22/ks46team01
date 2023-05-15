package ks46team01.common.compost.dto;

import lombok.Data;

@Data
public class OrderCompostConfirm extends OrderCompost{
    private Long orderCompostConfirmIdx;
    private Long orderCompostIdx;
    private String username;
    private Long  companyInfoIdx;
    private String orderCompostConfirmStatus;
    private String OrderCompostConfirmContent;
    private String adminUsername;
    private String orderCompostConfirmDate;

}
