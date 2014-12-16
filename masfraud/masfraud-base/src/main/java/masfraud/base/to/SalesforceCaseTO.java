package masfraud.base.to;

import java.io.Serializable;
import java.math.BigDecimal;

public class SalesforceCaseTO implements Serializable {

	private static final long serialVersionUID = 7138399541208399869L;

	private String alertId;
	private String alertType;
	private String alertLevel;
	private Long score;
	private String loyaltyEngine;
	private BigDecimal transactionValueCurrency;
	private BigDecimal transactionValuePoints;
	private String currencyName;
	private String partner;
	private String memberId;
	private String programId;
	// 2014-10-20T03:15:46-03:00
	private String transactionDateTime;
	private String transactionId;
	private String supplier;
	private String orderNumber;
	private String sourceSystem;
	private String instanceURL;
	private String error;
	private String message;
	private String caseID;

	public String getAlertId() {
		return alertId;
	}

	public void setAlertId(String alertId) {
		this.alertId = alertId;
	}

	public String getAlertType() {
		return alertType;
	}

	public void setAlertType(String alertType) {
		this.alertType = alertType;
	}

	public String getAlertLevel() {
		return alertLevel;
	}

	public void setAlertLevel(String alertLevel) {
		this.alertLevel = alertLevel;
	}

	public Long getScore() {
		return score;
	}

	public void setScore(Long score) {
		this.score = score;
	}

	public String getLoyaltyEngine() {
		return loyaltyEngine;
	}

	public void setLoyaltyEngine(String loyaltyEngine) {
		this.loyaltyEngine = loyaltyEngine;
	}

	public BigDecimal getTransactionValueCurrency() {
		return transactionValueCurrency;
	}

	public void setTransactionValueCurrency(BigDecimal transactionValueCurrency) {
		this.transactionValueCurrency = transactionValueCurrency;
	}

	public BigDecimal getTransactionValuePoints() {
		return transactionValuePoints;
	}

	public void setTransactionValuePoints(BigDecimal transactionValuePoints) {
		this.transactionValuePoints = transactionValuePoints;
	}

	public String getCurrencyName() {
		return currencyName;
	}

	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}

	public String getPartner() {
		return partner;
	}

	public void setPartner(String partner) {
		this.partner = partner;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getProgramId() {
		return programId;
	}

	public void setProgramId(String programId) {
		this.programId = programId;
	}

	public String getTransactionDateTime() {
		return transactionDateTime;
	}

	public void setTransactionDateTime(String transactionDateTime) {
		this.transactionDateTime = transactionDateTime;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getSourceSystem() {
		return sourceSystem;
	}

	public void setSourceSystem(String sourceSystem) {
		this.sourceSystem = sourceSystem;
	}

	public String getInstanceURL() {
		return instanceURL;
	}

	public void setInstanceURL(String instanceURL) {
		this.instanceURL = instanceURL;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCaseID() {
		return caseID;
	}

	public void setCaseID(String caseID) {
		this.caseID = caseID;
	}
	
}
