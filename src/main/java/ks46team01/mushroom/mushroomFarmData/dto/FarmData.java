package ks46team01.mushroom.mushroomFarmData.dto;

import lombok.Data;

import java.sql.Date;
import java.sql.Timestamp;

@Data
public class FarmData {

    private Long farmDataIdx;
    private String username;
    private Long companyInfoIdx;
    private Integer farmDataCompost;
    private Double farmDataProduction;
    private Integer farmDataExpectedSale;
    private Integer farmDataActualSale;
    private Date farmDataProductionDate;
    private Date farmDataOccurrenceSaleDate;
    private Double farmDataExpectedWasted;
    private Timestamp farmDataDate;

    private String companyInfoLicenseNumber;
    private String name;
}
