package ks46team01.mushroom.mushroomCondition.dto;

import lombok.*;


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
    private String mushroomConditionUse;
    private int mushroomConditionYear;

    private String cropContent;

}
