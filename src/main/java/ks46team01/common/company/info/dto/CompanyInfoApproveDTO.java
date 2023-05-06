package ks46team01.common.company.info.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class CompanyInfoApproveDTO {
    private Long companyInfoApproveIdx;
    private String adminUsername;
    private Date companyInfoApproveDate;
    private String companyInfoApproveStatus;
    private String companyInfoApproveContent;
}
