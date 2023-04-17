package ks46team01.admin.accounting.purchase.dto;


import lombok.*;


@Data
public class AcPurchase {
    private Long accountingPurchaseIdx;
    private Long companyIdx;
    private Long inventoryIdx;
    private String companyContract;
    private String accountingPurchaseDate;
    private String accountingPurchaseType;
    private String accountingPurchaseUnitPrice;
    private String accountingPurchaseAmount;
    private String accountingPurchasePayment;
    private String accountingPurchaseSum;
    private String adminUsername;
    private String accountingPurchaseUpdate;



}
