package ks46team01.admin.accounting.purchase.dto;


import lombok.*;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;



public class AcPurchase {

    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private Long accountingPurchaseAdminIdx;
    private Long companyIdx;
    private Long inventoryIdx;
    private Long companyContractIdx;

    private String accountingPurchaseAdminDateS;
    private Date accountingPurchaseAdminDate;
    private int accountingPurchaseAdminPrice;
    private double accountingPurchaseAdminAmount;
    private String accountingPurchaseAdminPayment;
    private int accountingPurchaseAdminSum;
    private String adminUsername;
    private Timestamp accountingPurchaseAdminUpdate;

    private String companyType;
    private String inventoryType;
    private String adminName;

    public Long getAccountingPurchaseAdminIdx() {
        return accountingPurchaseAdminIdx;
    }

    public void setAccountingPurchaseAdminIdx(Long accountingPurchaseAdminIdx) {
        this.accountingPurchaseAdminIdx = accountingPurchaseAdminIdx;
    }

    public Long getCompanyIdx() {
        return companyIdx;
    }

    public void setCompanyIdx(Long companyIdx) {
        this.companyIdx = companyIdx;
    }

    public Long getInventoryIdx() {
        return inventoryIdx;
    }

    public void setInventoryIdx(Long inventoryIdx) {
        this.inventoryIdx = inventoryIdx;
    }

    public Long getCompanyContractIdx() {
        return companyContractIdx;
    }

    public void setCompanyContractIdx(Long companyContractIdx) {
        this.companyContractIdx = companyContractIdx;
    }

    public String getAccountingPurchaseAdminDateS() {
        return accountingPurchaseAdminDateS;
    }

    public void setAccountingPurchaseAdminDateS(String accountingPurchaseAdminDateS) throws Exception{
        this.accountingPurchaseAdminDateS = accountingPurchaseAdminDateS;
        this.accountingPurchaseAdminDate = dateFormat.parse(accountingPurchaseAdminDateS);
    }

    public Date getAccountingPurchaseAdminDate() {
        return accountingPurchaseAdminDate;
    }

    public void setAccountingPurchaseAdminDate(Date accountingPurchaseAdminDate) {
        this.accountingPurchaseAdminDate = accountingPurchaseAdminDate;
    }

    public int getAccountingPurchaseAdminPrice() {
        return accountingPurchaseAdminPrice;
    }

    public void setAccountingPurchaseAdminPrice(int accountingPurchaseAdminPrice) {
        this.accountingPurchaseAdminPrice = accountingPurchaseAdminPrice;
    }

    public double getAccountingPurchaseAdminAmount() {
        return accountingPurchaseAdminAmount;
    }

    public void setAccountingPurchaseAdminAmount(double accountingPurchaseAdminAmount) {
        this.accountingPurchaseAdminAmount = accountingPurchaseAdminAmount;
    }

    public String getAccountingPurchaseAdminPayment() {
        return accountingPurchaseAdminPayment;
    }

    public void setAccountingPurchaseAdminPayment(String accountingPurchaseAdminPayment) {
        this.accountingPurchaseAdminPayment = accountingPurchaseAdminPayment;
    }

    public int getAccountingPurchaseAdminSum() {
        return accountingPurchaseAdminSum;
    }

    public void setAccountingPurchaseAdminSum(int accountingPurchaseAdminSum) {
        this.accountingPurchaseAdminSum = accountingPurchaseAdminSum;
    }

    public String getAdminUsername() {
        return adminUsername;
    }

    public void setAdminUsername(String adminUsername) {
        this.adminUsername = adminUsername;
    }

    public Timestamp getAccountingPurchaseAdminUpdate() {
        return accountingPurchaseAdminUpdate;
    }

    public void setAccountingPurchaseAdminUpdate(Timestamp accountingPurchaseAdminUpdate) {
        this.accountingPurchaseAdminUpdate = accountingPurchaseAdminUpdate;
    }

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    public String getInventoryType() {
        return inventoryType;
    }

    public void setInventoryType(String inventoryType) {
        this.inventoryType = inventoryType;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    @Override
    public String toString() {
        return "AcPurchase{" +
                "accountingPurchaseAdminIdx=" + accountingPurchaseAdminIdx +
                ", companyIdx=" + companyIdx +
                ", inventoryIdx=" + inventoryIdx +
                ", companyContractIdx=" + companyContractIdx +
                ", accountingPurchaseAdminDateS='" + accountingPurchaseAdminDateS + '\'' +
                ", accountingPurchaseAdminDate=" + accountingPurchaseAdminDate +
                ", accountingPurchaseAdminPrice=" + accountingPurchaseAdminPrice +
                ", accountingPurchaseAdminAmount=" + accountingPurchaseAdminAmount +
                ", accountingPurchaseAdminPayment='" + accountingPurchaseAdminPayment + '\'' +
                ", accountingPurchaseAdminSum=" + accountingPurchaseAdminSum +
                ", adminUsername='" + adminUsername + '\'' +
                ", accountingPurchaseAdminUpdate=" + accountingPurchaseAdminUpdate +
                ", companyType='" + companyType + '\'' +
                ", inventoryType='" + inventoryType + '\'' +
                ", adminName='" + adminName + '\'' +
                '}';
    }
}
