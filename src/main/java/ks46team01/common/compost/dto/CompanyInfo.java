package ks46team01.common.compost.dto;

import lombok.Data;

@Data
public class CompanyInfo extends Inventory{
    private Long companyInfoIdx;
    private String username;
    private Long companyIdx;
    private String companyInfoName;
    private Long inventoryIdx;
    private String companyInfoLicenseNumber;
    private String companyInfoPhone;
    private String companyInfoDate;
    private String companyInfoUpdate;
    private String companyInfoIsDel;
    private String companyInfoIsDelDate;

}
