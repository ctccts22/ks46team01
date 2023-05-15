package ks46team01.admin.accounting.sale.dto;

import lombok.*;

import java.util.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

@Data
public class AcSale {
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    private Long accountingSalesAdminIdx;
    private Long companyIdx;
    private Long inventoryIdx;
    private Long companyContractIdx;

    private String accountingSalesAdminDateS;

    @Setter(AccessLevel.NONE) private Date accountingSalesAdminDate;
    private String accountingSalesAdminType;
    private String accountingSalesAdminPayment;
    private Integer accountingSalesAdminSum;
    private String adminUsername;
    private Timestamp accountingSalesAdminUpdate;
    private String accountingSalesAdminFinishUpdate;


    public void setAccountingSalesAdminDateS(String accountingSalesAdminDateS) throws Exception {
        this.accountingSalesAdminDateS = accountingSalesAdminDateS;
        this.accountingSalesAdminDate = dateFormat.parse(accountingSalesAdminDateS);
    }



}
