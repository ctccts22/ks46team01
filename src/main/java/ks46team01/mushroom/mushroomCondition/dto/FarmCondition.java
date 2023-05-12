package ks46team01.mushroom.mushroomCondition.dto;

import ks46team01.admin.info.entity.Admin;
import lombok.*;

import java.sql.Timestamp;

@Data
public class FarmCondition {
    private Long mushroomConditionIdx;
    private Long cropIdx;
    private String mushroomConditionTemperature;
    private String mushroomConditionHumidity;
    private String mushroomConditionOxygen;
    private String mushroomConditionCo2;
    private String mushroomConditionIlluminance;
    private String mushroomConditionPh;
    private int mushroomConditionYear;
    private String mushroomConditionUse;
    private String adminUsername;
    private Timestamp mushroomConditionDate;

    private Admin adminInfo;

    private Crop cropInfo;





}
