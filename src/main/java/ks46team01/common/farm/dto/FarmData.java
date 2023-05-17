package ks46team01.common.farm.dto;

import lombok.Data;

@Data
public class FarmData extends FarmPickupDelivery{
    private Long farmDataIdx;
    private String username;
    private Long companyInfoIdx;
    private Long farmDataCompost;
    private Long farmDataProduction;
    private Long farmDataExpectedSale;
    private Long farmDataActualSale;
    private String farmDataProductionDate;
    private String farmDataOccurenceSaleDate;
    private Long farmDataExpectedWasted;
    private String farmDataDate;
    private String companyInfoName;
}
