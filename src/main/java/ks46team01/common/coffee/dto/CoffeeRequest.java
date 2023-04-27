package ks46team01.common.coffee.dto;


import lombok.Data;

@Data
public class CoffeeRequest extends CompanyInfo {
    private Long coffeeRequestIdx;
    private String userName;
    private Long companyContractIdx;
    private Long companyInfoIdx;
    private Long inventoryIdx;
    private Long coffeeRequestEmission;
    private Long coffeeRequestAmount;
    private String coffeeRequestAddress;
    private String coffeeRequestPhone;
    private String coffeeRequestContent;
    private String coffeeRequestDate;

}
