package ks46team01.common.farm.dto;

import lombok.Data;

@Data
public class FarmData {
    private Long farmDataIdx;
    private String userName;
    private Long companyInfoIdx;
    private Long farmDataCompost;
    private Long farmDataProduction;
    private Long farmDataExpectedSale;
    private Long farmDataActualSale;
    private String farmDataProductionDate;
    private String farmDataOccurenceSaleDate;
    private Long farmDataExpectedWasted;
    private String farmDataDate;

}
