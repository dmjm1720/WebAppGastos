/*     */ package mx.model;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ 
/*     */ public class Polizapagos implements Serializable {
/*     */   private int idVoucher;
/*     */   private String voucherNo;
/*     */   private String entryDate;
/*     */   private String transactionDate;
/*     */   private String currency;
/*     */   private String rate;
/*     */   private String remarks;
/*     */   private String drcr;
/*     */   private String unit;
/*     */   private String account;
/*     */   private String taxCode;
/*     */   private String tf;
/*     */   private String subAccount;
/*     */   private String contractNo;
/*     */   private String referenceNo;
/*     */   private String dueDate;
/*     */   private String amount;
/*     */   private String userFolio;
/*     */   private String userName;
/*     */   private Boolean processed;
/*     */   
/*     */   public Polizapagos() {}
/*     */   
/*     */   public Polizapagos(int idVoucher) {
/*  30 */     this.idVoucher = idVoucher;
/*     */   }
/*     */   
/*     */   public Polizapagos(int idVoucher, String voucherNo, String entryDate, String transactionDate, String currency, String rate, String remarks, String drcr, String unit, String account, String taxCode, String tf, String subAccount, String contractNo, String referenceNo, String dueDate, String amount, String userFolio, String userName, Boolean processed) {
/*  34 */     this.idVoucher = idVoucher;
/*  35 */     this.voucherNo = voucherNo;
/*  36 */     this.entryDate = entryDate;
/*  37 */     this.transactionDate = transactionDate;
/*  38 */     this.currency = currency;
/*  39 */     this.rate = rate;
/*  40 */     this.remarks = remarks;
/*  41 */     this.drcr = drcr;
/*  42 */     this.unit = unit;
/*  43 */     this.account = account;
/*  44 */     this.taxCode = taxCode;
/*  45 */     this.tf = tf;
/*  46 */     this.subAccount = subAccount;
/*  47 */     this.contractNo = contractNo;
/*  48 */     this.referenceNo = referenceNo;
/*  49 */     this.dueDate = dueDate;
/*  50 */     this.amount = amount;
/*  51 */     this.userFolio = userFolio;
/*  52 */     this.userName = userName;
/*  53 */     this.processed = processed;
/*     */   }
/*     */   
/*     */   public int getIdVoucher() {
/*  57 */     return this.idVoucher;
/*     */   }
/*     */   
/*     */   public void setIdVoucher(int idVoucher) {
/*  61 */     this.idVoucher = idVoucher;
/*     */   }
/*     */   
/*     */   public String getVoucherNo() {
/*  65 */     return this.voucherNo;
/*     */   }
/*     */   
/*     */   public void setVoucherNo(String voucherNo) {
/*  69 */     this.voucherNo = voucherNo;
/*     */   }
/*     */   
/*     */   public String getEntryDate() {
/*  73 */     return this.entryDate;
/*     */   }
/*     */   
/*     */   public void setEntryDate(String entryDate) {
/*  77 */     this.entryDate = entryDate;
/*     */   }
/*     */   
/*     */   public String getTransactionDate() {
/*  81 */     return this.transactionDate;
/*     */   }
/*     */   
/*     */   public void setTransactionDate(String transactionDate) {
/*  85 */     this.transactionDate = transactionDate;
/*     */   }
/*     */   
/*     */   public String getCurrency() {
/*  89 */     return this.currency;
/*     */   }
/*     */   
/*     */   public void setCurrency(String currency) {
/*  93 */     this.currency = currency;
/*     */   }
/*     */   
/*     */   public String getRate() {
/*  97 */     return this.rate;
/*     */   }
/*     */   
/*     */   public void setRate(String rate) {
/* 101 */     this.rate = rate;
/*     */   }
/*     */   
/*     */   public String getRemarks() {
/* 105 */     return this.remarks;
/*     */   }
/*     */   
/*     */   public void setRemarks(String remarks) {
/* 109 */     this.remarks = remarks;
/*     */   }
/*     */   
/*     */   public String getDrcr() {
/* 113 */     return this.drcr;
/*     */   }
/*     */   
/*     */   public void setDrcr(String drcr) {
/* 117 */     this.drcr = drcr;
/*     */   }
/*     */   
/*     */   public String getUnit() {
/* 121 */     return this.unit;
/*     */   }
/*     */   
/*     */   public void setUnit(String unit) {
/* 125 */     this.unit = unit;
/*     */   }
/*     */   
/*     */   public String getAccount() {
/* 129 */     return this.account;
/*     */   }
/*     */   
/*     */   public void setAccount(String account) {
/* 133 */     this.account = account;
/*     */   }
/*     */   
/*     */   public String getTaxCode() {
/* 137 */     return this.taxCode;
/*     */   }
/*     */   
/*     */   public void setTaxCode(String taxCode) {
/* 141 */     this.taxCode = taxCode;
/*     */   }
/*     */   
/*     */   public String getTf() {
/* 145 */     return this.tf;
/*     */   }
/*     */   
/*     */   public void setTf(String tf) {
/* 149 */     this.tf = tf;
/*     */   }
/*     */   
/*     */   public String getSubAccount() {
/* 153 */     return this.subAccount;
/*     */   }
/*     */   
/*     */   public void setSubAccount(String subAccount) {
/* 157 */     this.subAccount = subAccount;
/*     */   }
/*     */   
/*     */   public String getContractNo() {
/* 161 */     return this.contractNo;
/*     */   }
/*     */   
/*     */   public void setContractNo(String contractNo) {
/* 165 */     this.contractNo = contractNo;
/*     */   }
/*     */   
/*     */   public String getReferenceNo() {
/* 169 */     return this.referenceNo;
/*     */   }
/*     */   
/*     */   public void setReferenceNo(String referenceNo) {
/* 173 */     this.referenceNo = referenceNo;
/*     */   }
/*     */   
/*     */   public String getDueDate() {
/* 177 */     return this.dueDate;
/*     */   }
/*     */   
/*     */   public void setDueDate(String dueDate) {
/* 181 */     this.dueDate = dueDate;
/*     */   }
/*     */   
/*     */   public String getAmount() {
/* 185 */     return this.amount;
/*     */   }
/*     */   
/*     */   public void setAmount(String amount) {
/* 189 */     this.amount = amount;
/*     */   }
/*     */   
/*     */   public String getUserFolio() {
/* 193 */     return this.userFolio;
/*     */   }
/*     */   
/*     */   public void setUserFolio(String userFolio) {
/* 197 */     this.userFolio = userFolio;
/*     */   }
/*     */   
/*     */   public String getUserName() {
/* 201 */     return this.userName;
/*     */   }
/*     */   
/*     */   public void setUserName(String userName) {
/* 205 */     this.userName = userName;
/*     */   }
/*     */   
/*     */   public Boolean getProcessed() {
/* 209 */     return this.processed;
/*     */   }
/*     */   
/*     */   public void setProcessed(Boolean processed) {
/* 213 */     this.processed = processed;
/*     */   }
/*     */ }


/* Location:              C:\Users\Mario Arias\Desktop\Ultima version marubeni trabajable\WebAppGastos.war!\WEB-INF\classes\mx\model\Polizapagos.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */