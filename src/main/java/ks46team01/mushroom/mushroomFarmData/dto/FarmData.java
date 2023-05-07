package ks46team01.mushroom.mushroomFarmData.dto;

import lombok.Data;

import java.sql.Date;
import java.sql.Timestamp;

@Data
public class FarmData {
    private Long farmDataIdx;
    private String adminName;
    private String companyInfoLicenseNumber;
    private String farmDataCompost;
    private String farmDataProduction;
    private String farmDataExpectedSale;
    private String farmDataActualSale;
    private Date farmDataProductionDate;
    private Date farmDataOccurrenceSaleDate;
    private String farmDataExpectedWasted;
    private Timestamp farmDataDate;



    private String username;
    private Long companyInfoIdx;
}
