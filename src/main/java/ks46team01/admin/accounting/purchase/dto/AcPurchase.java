package ks46team01.admin.accounting.purchase.dto;


import lombok.*;


@Data
public class AcPurchase {
    private Long accounting_purchase_admin_idx;
    private Long company_idx;
    private Long inventory_idx;
    private String company_contract_idx;
    private String accounting_purchase_admin_date;
    private String accounting_purchase_admin_price;
    private String accounting_purchase_admin_amount;
    private String accounting_purchase_admin_payment;
    private String accounting_purchase_admin_sum;
    private String admin_username;
    private String accounting_purchase_admin_update;



}
