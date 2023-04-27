package ks46team01.common.wasted.dto;

import lombok.Data;

@Data
public class OrderWasted {
    private Long orderWastedIdx;
    private Long companyContractIdx;
    private String userName;
    private Long companyInfoIdx;
    private Long inventoryIdx;
    private String orderWastedScale;
    private Long orderWastedAmount;
    private Long companyUnitIdx;
    private Long orderWastedSubTotal;
    private String orderWastedPhone;
    private String orderWastedContent;

    private String orderWastedAddress;
    private String orderWastedDate;
}
