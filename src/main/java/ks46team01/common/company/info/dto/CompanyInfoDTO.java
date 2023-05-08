package ks46team01.common.company.info.dto;

import ks46team01.common.company.info.entity.CompanyInfo;
import ks46team01.common.company.info.entity.CompanyInfoApprove;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class CompanyInfoDTO {

    private Long companyInfoIdx;
    private String username;
    private Long companyIdx;
    private String companyType;
    private String companyInfoName;
    private Long inventoryIdx;
    private String inventoryType;
    private String companyInfoLicenseNumber;
    private String companyInfoAddress;
    private String companyInfoPhone;
    private Timestamp companyInfoDate;
    private Timestamp companyInfoUpdate;
    private String companyInfoIsDel;
    private Timestamp companyInfoIsDelDate;
    private List<CompanyInfoApproveDTO> companyInfoApprovals;

    public CompanyInfo toEntity() {
        CompanyInfo companyInfo = new CompanyInfo();
        BeanUtils.copyProperties(this, companyInfo);
        return companyInfo;
    }

    public static CompanyInfoDTO fromEntity(CompanyInfo companyInfo) {
        CompanyInfoDTO companyInfoDTO = new CompanyInfoDTO();
        BeanUtils.copyProperties(companyInfo, companyInfoDTO);

        companyInfoDTO.setUsername(companyInfo.getUsername().getUsername());
        companyInfoDTO.setCompanyIdx(companyInfo.getCompanyIdx().getCompanyIdx());
        companyInfoDTO.setCompanyType(companyInfo.getCompanyIdx().getCompanyType());
        companyInfoDTO.setInventoryIdx(companyInfo.getInventoryIdx().getInventoryIdx());
        companyInfoDTO.setInventoryType(companyInfo.getInventoryIdx().getInventoryType());
        companyInfoDTO.setCompanyInfoApprovals(companyInfo.getCompanyInfoApprovals().stream()
                .map(CompanyInfoApprove::toCompanyInfoApproveDTO)
                .collect(Collectors.toList()));

        return companyInfoDTO;
    }
}