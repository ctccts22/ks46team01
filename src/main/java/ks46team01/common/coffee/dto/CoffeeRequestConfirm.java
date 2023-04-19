package ks46team01.common.coffee.dto;

import lombok.Data;

@Data
public class CoffeeRequestConfirm {

    private Long coffeeRequestConfirmIdx;
    private String userName;
    private Long coffeeRequestIdx;
    private Long companyInfoIdx;
    private String coffeeRequestConfirmStatus;
    private String coffeeRequestConfirmContent;
    private String adminUsername;
    private String coffeeRequestConfirmDate;

}
