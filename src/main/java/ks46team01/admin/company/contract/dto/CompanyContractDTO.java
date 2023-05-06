package ks46team01.admin.company.contract.dto;

import ks46team01.admin.company.contract.entity.CompanyContract;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.temporal.ChronoUnit;

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
    private String companyContractStatus;
    private String companyContractContent;
    private String adminUsername;
    private Timestamp companyContractAdminDate;
    private Timestamp companyContractAdminUpdate;

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
        companyContractDTO.setAdminUsername(companyContract.getAdminUsername().getAdminUsername());

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
