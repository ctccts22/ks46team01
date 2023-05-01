package ks46team01.mushroom.mushroomCondition.dto;

import lombok.*;

import java.sql.Timestamp;
import java.util.List;

@Data
public class Crop {
     private Long cropIdxInfo;
     private String cropType;
     private String cropContent;
     private String adminUsername;
     private Timestamp cropDate;

     private List<FarmCondition> farmConditionList;

}
