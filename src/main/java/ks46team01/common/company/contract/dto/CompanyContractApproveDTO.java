package ks46team01.common.company.contract.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class CompanyContractApproveDTO {
    private Long companyContractApproveIdx;
    private String adminUsername;
    private Date companyContractApproveDate;
    private String companyContractApproveStatus;
    private String companyContractApproveContent;
}
