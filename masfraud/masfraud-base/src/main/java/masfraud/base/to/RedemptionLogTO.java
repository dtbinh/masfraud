package masfraud.base.to;

import java.math.BigDecimal;
import java.util.Date;

public class RedemptionLogTO extends EventLogTO{

	private static final long serialVersionUID = -276684927611669389L;
	/*EVENT_ID ID_ISSUING_PARTNER*/
	private String characteristic;
	private CurrencyTO currencyTO;
	private Date transactionDate;
	private Date expiryDate;
	private BigDecimal amountValue;
	private BigDecimal amountPoints;
	private String partnerDescAux;
    private String namePartner;
    private Integer idIssuingPatner;
	private RedemptionProductTO redemptionProductTO;
	

	public String getCharacteristic() {
		return characteristic;
	}
	public void setCharacteristic(String characteristic) {
		this.characteristic = characteristic;
	}
	public CurrencyTO getCurrency() {
		return currencyTO;
	}
	public void setCurrency(CurrencyTO currency) {
		this.currencyTO = currency;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	public Date getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	public BigDecimal getAmountValue() {
		if(this.amountValue == null && this.amountValue.intValue() == 0){
			return null;
		}
		return amountValue;
	}
	public void setAmountValue(BigDecimal amountValue) {
		this.amountValue = amountValue;
	}
	public BigDecimal getAmountPoints() {
		return amountPoints;
	}
	public void setAmountPoints(BigDecimal amountPoints) {
		this.amountPoints = amountPoints;
	}
	public String getPartnerDescAux() {
		return partnerDescAux;
	}
	public void setPartnerDescAux(String partnerDescAux) {
		this.partnerDescAux = partnerDescAux;
	}
	public RedemptionProductTO getRedemptionProductTO() {
		return redemptionProductTO;
	}
	public void setRedemptionProductTO(RedemptionProductTO redemptionProductTO) {
		this.redemptionProductTO = redemptionProductTO;
	}

    public String getNamePartner() {
        return namePartner;
    }

    public void setNamePartner(String namePartner) {
        this.namePartner = namePartner;
    }

    public Integer getIdIssuingPatner() {
        return idIssuingPatner;
    }

    public void setIdIssuingPatner(Integer idIssuingPatner) {
        this.idIssuingPatner = idIssuingPatner;
    }

    @Override
    public String toString() {
        return "RedemptionLogTO{" +
                "characteristic='" + characteristic + '\'' +
                ", currencyTO=" + currencyTO +
                ", transactionDate=" + transactionDate +
                ", expiryDate=" + expiryDate +
                ", amountValue=" + amountValue +
                ", amountPoints=" + amountPoints +
                ", partnerDescAux='" + partnerDescAux + '\'' +
                ", namePartner='" + namePartner + '\'' +
                ", idIssuingPatner=" + idIssuingPatner +
                ", redemptionProductTO=" + redemptionProductTO +
                '}';
    }
}
