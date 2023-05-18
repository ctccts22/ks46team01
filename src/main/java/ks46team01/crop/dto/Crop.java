package ks46team01.crop.dto;

import lombok.Data;

@Data
public class Crop {
    private Long cropIdx;
    private String cropType;
    private String cropContent;
    private String adminUsername;
    private String cropDate;
}
