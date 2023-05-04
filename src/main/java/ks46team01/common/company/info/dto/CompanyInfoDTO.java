package ks46team01.common.company.info.dto;

import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
public class CompanyInfoDTO {

    private Long companyInfoIdx;
    private Long usernameId;
    private Long companyIdx;
    private String companyInfoName;
    private Long inventoryIdx;
    private String companyInfoLicenseNumber;
    private String companyInfoAddress;
    private String companyInfoPhone;
    private Timestamp companyInfoDate;
    private Timestamp companyInfoUpdate;
    private String companyInfoIsDel;
    private Timestamp companyInfoIsDelDate;
    private List<Long> companyInfoApprovalsIds;

}