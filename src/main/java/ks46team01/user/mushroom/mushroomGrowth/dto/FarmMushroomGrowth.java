package ks46team01.user.mushroom.mushroomGrowth.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class FarmMushroomGrowth {
        private Long mushroomGrowthIdx;
        private String username;
        private Long companyInfoIdx;
        private Long farmDataIdx;
        private Long cropIdx;
        private int mushroomGrowthDaily;
        private String mushroomGrowthStatus;
        private Timestamp mushroomGrowthDate;
        private String mushroomGrowthContent;


        private String cropType;
        private String name;
        private String companyInfoName;
}



