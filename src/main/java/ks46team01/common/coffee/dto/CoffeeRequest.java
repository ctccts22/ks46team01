package ks46team01.common.coffee.dto;


import ks46team01.common.company.info.dto.CompanyInfoDTO;
import lombok.Data;

@Data
public class CoffeeRequest extends CompanyInfoDTO {
    private Long coffeeRequestIdx;
    private String userName;
    private Long companyContractIdx;
    private Long companyInfoIdx;
    private Long inventoryIdx;
    private Long coffeeRequestAmount;
    private String coffeeRequestAddress;
    private String coffeeRequestPhone;
    private String coffeeRequestContent;
    private String coffeeRequestDate;

}
