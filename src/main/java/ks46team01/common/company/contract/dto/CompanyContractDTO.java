package ks46team01.common.company.contract.dto;

import ks46team01.common.company.contract.entity.CompanyContract;
import ks46team01.common.company.contract.entity.CompanyContractApprove;
import ks46team01.common.company.info.entity.CompanyInfo;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.sql.Date;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class CompanyContractDTO {

    private Long companyContractIdx;
    private String companyContractDeliveryTerm;
    private Date companyContractStart;
    private Date companyContractEnd;
    private Long contractDuration;
    private Double companyContractAmount;
    private Long companyUnitIdx;
    private Integer CompanyUnitPrice;
    private Long companyInfoIdx;
    private String companyInfoLicenseNumber;
    private String username;

    private String companyInfoName;
    private String companyType;
    private Long companyIdx;
    private Integer companyUnitYear;
    private Double companyUnitAmount;

    private List<CompanyContractApproveDTO> companyContractApprovals;

    public CompanyContract toEntity() {
        CompanyContract companyContract = new CompanyContract();
        BeanUtils.copyProperties(this, companyContract);
        return companyContract;
    }

    public static CompanyContractDTO fromEntity(CompanyContract companyContract) {
        CompanyContractDTO companyContractDTO = new CompanyContractDTO();
        BeanUtils.copyProperties(companyContract, companyContractDTO);

        companyContractDTO.setCompanyUnitIdx(companyContract.getCompanyUnitIdx().getCompanyUnitIdx());
        companyContractDTO.setCompanyUnitPrice(companyContract.getCompanyUnitIdx().getCompanyUnitPrice());
        companyContractDTO.setCompanyInfoIdx(companyContract.getCompanyInfoIdx().getCompanyInfoIdx());
        companyContractDTO.setCompanyInfoLicenseNumber(companyContract.getCompanyInfoIdx().getCompanyInfoLicenseNumber());
        companyContractDTO.setUsername(companyContract.getCompanyInfoIdx().getUsername().getUsername());
        companyContractDTO.setCompanyInfoName(companyContract.getCompanyInfoIdx().getCompanyInfoName());
        companyContractDTO.setCompanyType(companyContract.getCompanyInfoIdx().getCompanyIdx().getCompanyType());
        companyContractDTO.setCompanyIdx(companyContract.getCompanyInfoIdx().getCompanyIdx().getCompanyIdx());
        companyContractDTO.setCompanyUnitYear(companyContract.getCompanyUnitIdx().getCompanyUnitYear());
        companyContractDTO.setCompanyUnitAmount(companyContract.getCompanyUnitIdx().getCompanyUnitAmount());

        companyContractDTO.setCompanyContractApprovals(companyContract.getCompanyContractApprovals().stream()
                .map(CompanyContractApprove::toCompanyContractApproveDTO)
                .collect(Collectors.toList()));

        // 날짜 계산
        if (companyContract.getCompanyContractStart() != null && companyContract.getCompanyContractEnd() != null) {
            long duration = ChronoUnit.DAYS.between(companyContract.getCompanyContractStart().toLocalDate(), companyContract.getCompanyContractEnd().toLocalDate());
            companyContractDTO.setContractDuration(duration);
        } else {
            companyContractDTO.setContractDuration(null);
        }

        return companyContractDTO;
    }
}
