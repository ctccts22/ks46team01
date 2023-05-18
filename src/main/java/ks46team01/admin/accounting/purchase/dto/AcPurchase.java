package ks46team01.admin.accounting.purchase.dto;


import lombok.*;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import ks46team01.admin.company.dto.CompanyDTO;
import ks46team01.admin.info.dto.AdminDTO;
import ks46team01.admin.inventories.inventory.dto.InventoryDTO;
import ks46team01.common.company.contract.dto.CompanyContractDTO;


public class AcPurchase {

    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private Long accountingPurchaseAdminIdx;
    private Long companyIdx;
    private Long inventoryIdx;
    private Long companyContractIdx;

    private String accountingPurchaseAdminDateS;
    private Date accountingPurchaseAdminDate;
    private Integer accountingPurchaseAdminPrice;
    private Double accountingPurchaseAdminAmount;
    private String accountingPurchaseAdminPayment;
    private Integer accountingPurchaseAdminSum;
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

    public Integer getAccountingPurchaseAdminPrice() {
        return accountingPurchaseAdminPrice;
    }

    public void setAccountingPurchaseAdminPrice(Integer accountingPurchaseAdminPrice) {
        this.accountingPurchaseAdminPrice = accountingPurchaseAdminPrice;
    }

    public Double getAccountingPurchaseAdminAmount() {
        return accountingPurchaseAdminAmount;
    }

    public void setAccountingPurchaseAdminAmount(Double accountingPurchaseAdminAmount) {
        this.accountingPurchaseAdminAmount = accountingPurchaseAdminAmount;
    }

    public String getAccountingPurchaseAdminPayment() {
        return accountingPurchaseAdminPayment;
    }

    public void setAccountingPurchaseAdminPayment(String accountingPurchaseAdminPayment) {
        this.accountingPurchaseAdminPayment = accountingPurchaseAdminPayment;
    }

    public Integer getAccountingPurchaseAdminSum() {
        return accountingPurchaseAdminSum;
    }

    public void setAccountingPurchaseAdminSum(Integer accountingPurchaseAdminSum) {
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
<<<<<<< HEAD
=======

>>>>>>> 7ab3d1e (5월19일 추가)
}
