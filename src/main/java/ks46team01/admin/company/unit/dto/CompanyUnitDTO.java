package ks46team01.admin.company.unit.dto;

import ks46team01.admin.company.unit.entity.CompanyUnit;
import ks46team01.common.company.contract.entity.CompanyContract;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
public class CompanyUnitDTO {
    private Long companyUnitIdx;
    private Double companyUnitAmount;
    private Integer companyUnitPrice;
    private Integer companyUnitYear;
    private Long companyIdx;
    private String adminUsername;


    public CompanyUnit toEntity() {
        CompanyUnit companyUnit = new CompanyUnit();
        BeanUtils.copyProperties(this, companyUnit);
        return companyUnit;
    }

    public static CompanyUnitDTO fromEntity(CompanyUnit companyUnit) {
        CompanyUnitDTO companyUnitDTO = new CompanyUnitDTO();
        BeanUtils.copyProperties(companyUnit, companyUnitDTO);
        companyUnitDTO.setCompanyIdx(companyUnit.getCompanyIdx().getCompanyIdx());
        companyUnitDTO.setAdminUsername(companyUnit.getAdminUsername().getAdminUsername());
        return companyUnitDTO;
    }

}
