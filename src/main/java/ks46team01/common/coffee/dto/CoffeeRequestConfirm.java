package ks46team01.common.coffee.dto;

import lombok.Data;

@Data
public class CoffeeRequestConfirm extends CoffeeRequest{

    private Long coffeeRequestConfirmIdx; //커피가루 배송 고유번호 PK
    private String userName; // 회원 아이디 FK
    private Long coffeeRequestIdx; //수거신청 고유번호 FK
    private Long companyInfoIdx; // 회원권한 FK
    private String coffeeRequestConfirmStatus; //수거신청 상태
    private String coffeeRequestConfirmContent; // 수거신청 &반려 이유
    private String adminUsername; // 운영자 아이디 FK
    private String coffeeRequestConfirmDate; // 등록날짜

}
