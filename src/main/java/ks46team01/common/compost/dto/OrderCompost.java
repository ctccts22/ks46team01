package ks46team01.common.compost.dto;

import lombok.Data;

@Data
public class OrderCompost {
    private Long orderCompostIdx;
    private String userName;
    private Long companyContractIdx;
    private Long companyInfoIdx;
    private Long inventoryIdx;
    private String orderCompostCrop;
    private String orderCompostArea;
    private Long orderCompostAmount;
    private String orderCompostPhone;
    private String orderCompostAddress;
    private String orderCompostContent;
    private String orderCompostDate;

}
