package ks46team01.mushroom.mushroomPurchase.dto;

import lombok.Data;

@Data
public class FarmPurchase {
            private Long accountingPurchaseIdx;
            private String username;
            private Long companyInfoIdx;
            private Long companyIdx;
            private Long inventoryIdx;
            private Long companyContractIdx;
            private String accountingPurchaseDate;
            private String accountingPurchaseType;
            private int accountingPurchaseUnitPrice;
            private double accountingPurchaseAmount;
            private String accountingPurchasePayment;
            private int accountingPurchaseSum;
            private String accountingPurchaseCode;




}
