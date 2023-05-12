package ks46team01.common.compost.dto;

import lombok.Data;

@Data
public class CompanyContract extends CompanyInfo{
    private Long companyContractIdx;
    private String companyContractDeliveryTerm;
    private String companyContractStart;
    private String companyContractEnd;
    private Long companyContractAmount;
    private Long companyUnitIdx;
    private String companyContractStatus;
    private String companyContractContent;
    private String adminUsername;
    private String company_contractAdminDate;
    private String companyContractAdminUpdate;
    private Long companyInfoIdx;

}
