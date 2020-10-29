/*     */ package mx.model;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ 
/*     */ public class Poliza implements Serializable {
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
/*     */   
/*     */   public Poliza() {}
/*     */   
/*     */   public Poliza(int idVoucher) {
/*  29 */     this.idVoucher = idVoucher;
/*     */   }
/*     */   
/*     */   public Poliza(int idVoucher, String voucherNo, String entryDate, String transactionDate, String currency, String rate, String remarks, String drcr, String unit, String account, String taxCode, String tf, String subAccount, String contractNo, String referenceNo, String dueDate, String amount, String userFolio, String userName) {
/*  33 */     this.idVoucher = idVoucher;
/*  34 */     this.voucherNo = voucherNo;
/*  35 */     this.entryDate = entryDate;
/*  36 */     this.transactionDate = transactionDate;
/*  37 */     this.currency = currency;
/*  38 */     this.rate = rate;
/*  39 */     this.remarks = remarks;
/*  40 */     this.drcr = drcr;
/*  41 */     this.unit = unit;
/*  42 */     this.account = account;
/*  43 */     this.taxCode = taxCode;
/*  44 */     this.tf = tf;
/*  45 */     this.subAccount = subAccount;
/*  46 */     this.contractNo = contractNo;
/*  47 */     this.referenceNo = referenceNo;
/*  48 */     this.dueDate = dueDate;
/*  49 */     this.amount = amount;
/*  50 */     this.userFolio = userFolio;
/*  51 */     this.userName = userName;
/*     */   }
/*     */   
/*     */   public int getIdVoucher() {
/*  55 */     return this.idVoucher;
/*     */   }
/*     */   
/*     */   public void setIdVoucher(int idVoucher) {
/*  59 */     this.idVoucher = idVoucher;
/*     */   }
/*     */   
/*     */   public String getVoucherNo() {
/*  63 */     return this.voucherNo;
/*     */   }
/*     */   
/*     */   public void setVoucherNo(String voucherNo) {
/*  67 */     this.voucherNo = voucherNo;
/*     */   }
/*     */   
/*     */   public String getEntryDate() {
/*  71 */     return this.entryDate;
/*     */   }
/*     */   
/*     */   public void setEntryDate(String entryDate) {
/*  75 */     this.entryDate = entryDate;
/*     */   }
/*     */   
/*     */   public String getTransactionDate() {
/*  79 */     return this.transactionDate;
/*     */   }
/*     */   
/*     */   public void setTransactionDate(String transactionDate) {
/*  83 */     this.transactionDate = transactionDate;
/*     */   }
/*     */   
/*     */   public String getCurrency() {
/*  87 */     return this.currency;
/*     */   }
/*     */   
/*     */   public void setCurrency(String currency) {
/*  91 */     this.currency = currency;
/*     */   }
/*     */   
/*     */   public String getRate() {
/*  95 */     return this.rate;
/*     */   }
/*     */   
/*     */   public void setRate(String rate) {
/*  99 */     this.rate = rate;
/*     */   }
/*     */   
/*     */   public String getRemarks() {
/* 103 */     return this.remarks;
/*     */   }
/*     */   
/*     */   public void setRemarks(String remarks) {
/* 107 */     this.remarks = remarks;
/*     */   }
/*     */   
/*     */   public String getDrcr() {
/* 111 */     return this.drcr;
/*     */   }
/*     */   
/*     */   public void setDrcr(String drcr) {
/* 115 */     this.drcr = drcr;
/*     */   }
/*     */   
/*     */   public String getUnit() {
/* 119 */     return this.unit;
/*     */   }
/*     */   
/*     */   public void setUnit(String unit) {
/* 123 */     this.unit = unit;
/*     */   }
/*     */   
/*     */   public String getAccount() {
/* 127 */     return this.account;
/*     */   }
/*     */   
/*     */   public void setAccount(String account) {
/* 131 */     this.account = account;
/*     */   }
/*     */   
/*     */   public String getTaxCode() {
/* 135 */     return this.taxCode;
/*     */   }
/*     */   
/*     */   public void setTaxCode(String taxCode) {
/* 139 */     this.taxCode = taxCode;
/*     */   }
/*     */   
/*     */   public String getTf() {
/* 143 */     return this.tf;
/*     */   }
/*     */   
/*     */   public void setTf(String tf) {
/* 147 */     this.tf = tf;
/*     */   }
/*     */   
/*     */   public String getSubAccount() {
/* 151 */     return this.subAccount;
/*     */   }
/*     */   
/*     */   public void setSubAccount(String subAccount) {
/* 155 */     this.subAccount = subAccount;
/*     */   }
/*     */   
/*     */   public String getContractNo() {
/* 159 */     return this.contractNo;
/*     */   }
/*     */   
/*     */   public void setContractNo(String contractNo) {
/* 163 */     this.contractNo = contractNo;
/*     */   }
/*     */   
/*     */   public String getReferenceNo() {
/* 167 */     return this.referenceNo;
/*     */   }
/*     */   
/*     */   public void setReferenceNo(String referenceNo) {
/* 171 */     this.referenceNo = referenceNo;
/*     */   }
/*     */   
/*     */   public String getDueDate() {
/* 175 */     return this.dueDate;
/*     */   }
/*     */   
/*     */   public void setDueDate(String dueDate) {
/* 179 */     this.dueDate = dueDate;
/*     */   }
/*     */   
/*     */   public String getAmount() {
/* 183 */     return this.amount;
/*     */   }
/*     */   
/*     */   public void setAmount(String amount) {
/* 187 */     this.amount = amount;
/*     */   }
/*     */   
/*     */   public String getUserFolio() {
/* 191 */     return this.userFolio;
/*     */   }
/*     */   
/*     */   public void setUserFolio(String userFolio) {
/* 195 */     this.userFolio = userFolio;
/*     */   }
/*     */   
/*     */   public String getUserName() {
/* 199 */     return this.userName;
/*     */   }
/*     */   
/*     */   public void setUserName(String userName) {
/* 203 */     this.userName = userName;
/*     */   }
/*     */ }


/* Location:              C:\Users\Mario Arias\Desktop\Ultima version marubeni trabajable\WebAppGastos.war!\WEB-INF\classes\mx\model\Poliza.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */