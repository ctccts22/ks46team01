package ks46team01.mushroom.mushroomFarmData.dto;

import ks46team01.admin.info.entity.Admin;
import lombok.Data;

import java.sql.Date;
import java.sql.Timestamp;

@Data
public class FarmData {
    private Long farm_data_idx;
    private String username;
    private Long company_info_idx;
    private String farm_data_compost;
    private String farm_data_production;
    private String farm_data_expected_sale;
    private String farm_data_actual_sale;
    private Date farm_data_production_date;
    private Date farm_data_occurrence_sale_date;
    private String farm_data_expected_wasted;
    private Timestamp farm_data_date;



    private Admin adminInfo;
}
