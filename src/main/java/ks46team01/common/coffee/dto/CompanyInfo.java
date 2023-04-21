package ks46team01.common.coffee.dto;

import lombok.Data;
@Data
public class CompanyInfo {
    private int companyInfoIdx; //사업자 구별 1.카페사업자,2.농가사업자,3.폐배지사업자
    private String companyInfoName; // 사업자명
    private String companyInfoPhone; // 사업자 번호
    private String companyInfoAddress; // 사업자 주소
}
