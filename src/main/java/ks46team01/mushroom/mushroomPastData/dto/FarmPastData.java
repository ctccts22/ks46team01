package ks46team01.mushroom.mushroomPastData.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class FarmPastData {
    private Long pastDataIdx;
    private String username;
    private Long companyInfoIdx;
    private Long cropIdx;
    private String pastDataMushroomProduction;
    private Integer pastDataTotalRevenue;
    private Integer pastDataBadgeUse;
    private Integer pastDataYear;
    private String pastDataUse;
    private String pastDataComparison;
    private Timestamp pastDataDate;

    private String companyInfoLicenseNumber;
    private String cropType;





}
