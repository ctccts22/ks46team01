package ks46team01.mushroom.mushroomFarmData.dto;

import lombok.Data;

@Data
public class FarmData {
    private Long farm_data_idx;
    private String username;
    private Long company_info_idx;
    private String farm_data_compost;
    private String farm_data_production;
    private String farm_data_expected_sale;
    private String farm_data_actual_sale;
    private String farm_data_production_date;
    private String farm_data_occurrence_sale_date;
    private String farm_data_expected_wasted;
    private String farm_data_date;

}
