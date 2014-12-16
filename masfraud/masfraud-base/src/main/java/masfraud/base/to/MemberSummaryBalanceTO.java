package masfraud.base.to;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * @author Mauricio
 * 
 */
public class MemberSummaryBalanceTO implements Serializable {

	private static final long serialVersionUID = -2024565341828076720L;

	private Long id;
	private Integer idCurrency;
	private String currencyCode;
	private String currencyname;
	private Integer idPartner;
	private String partnerName;
	private String partnerDescription;
	private Date updatedDate;
	private BigDecimal previousBalance = BigDecimal.ZERO;
	private BigDecimal billedCredit = BigDecimal.ZERO;
	private BigDecimal billedDebit = BigDecimal.ZERO;
	private BigDecimal currentBalance = BigDecimal.ZERO;
	private BigDecimal unbilledCredit = BigDecimal.ZERO;
	private BigDecimal unbilledDebit = BigDecimal.ZERO;
	private BigDecimal futureBalance = BigDecimal.ZERO;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getIdCurrency() {
		return idCurrency;
	}

	public void setIdCurrency(Integer idCurrency) {
		this.idCurrency = idCurrency;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public String getCurrencyname() {
		return currencyname;
	}

	public void setCurrencyname(String currencyname) {
		this.currencyname = currencyname;
	}

	public Integer getIdPartner() {
		return idPartner;
	}

	public void setIdPartner(Integer idPartner) {
		this.idPartner = idPartner;
	}

	public String getPartnerName() {
		return partnerName;
	}

	public void setPartnerName(String partnerName) {
		this.partnerName = partnerName;
	}

	public String getPartnerDescription() {
		return partnerDescription;
	}

	public void setPartnerDescription(String partnerDescription) {
		this.partnerDescription = partnerDescription;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public BigDecimal getPreviousBalance() {
		return previousBalance;
	}

	public void setPreviousBalance(BigDecimal previousBalance) {
		this.previousBalance = previousBalance;
	}

	public BigDecimal getBilledCredit() {
		return billedCredit;
	}

	public void setBilledCredit(BigDecimal billedCredit) {
		this.billedCredit = billedCredit;
	}

	public BigDecimal getBilledDebit() {
		return billedDebit;
	}

	public void setBilledDebit(BigDecimal billedDebit) {
		this.billedDebit = billedDebit;
	}

	public BigDecimal getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(BigDecimal currentBalance) {
		this.currentBalance = currentBalance;
	}

	public BigDecimal getUnbilledCredit() {
		return unbilledCredit;
	}

	public void setUnbilledCredit(BigDecimal unbilledCredit) {
		this.unbilledCredit = unbilledCredit;
	}

	public BigDecimal getUnbilledDebit() {
		return unbilledDebit;
	}

	public void setUnbilledDebit(BigDecimal unbilledDebit) {
		this.unbilledDebit = unbilledDebit;
	}

	public BigDecimal getFutureBalance() {
		return futureBalance;
	}

	public void setFutureBalance(BigDecimal futureBalance) {
		this.futureBalance = futureBalance;
	}

}
