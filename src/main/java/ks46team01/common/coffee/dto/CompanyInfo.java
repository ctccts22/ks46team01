package ks46team01.common.coffee.dto;

import lombok.Data;
@Data
public class CompanyInfo {
    private Long companyInfoIdx; //사업자 구별
    private String companyInfoName; // 사업자명
    private String companyInfoPhone; // 사업자 번호
    private String companyInfoAddress; // 사업자 주소
}
