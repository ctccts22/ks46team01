package ks46team01.common.wasted.dto;

import lombok.Data;

@Data
public class CompanyDTO extends OrderWastedDelivery{
    private Long companyUnitIdx;
    private Long companyInfoIdx;
    private Long companyContractIdx;
    private String companyInfoName;
}
