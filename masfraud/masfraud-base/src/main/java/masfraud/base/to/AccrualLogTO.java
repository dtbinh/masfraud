package masfraud.base.to;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author marcos
 *
 */
public class AccrualLogTO extends EventLogTO{

	private static final long serialVersionUID = -276684927611669389L;
	/*EVENT_ID ID_ISSUING_PARTNER*/

    private String typeString;
	private Integer accrualLogID;
	private String characteristic;
	private CurrencyTO currencyTO;
	private Date transactionDate;
	private Date expiryDate;
	private BigDecimal amountValue;
	private BigDecimal amountPoints;
	private String partnerDescAux;
	private BigDecimal conversionRate;
    private String namePartner;
    private Integer idIssuingPatner;
    private String eventName;
    private Integer eventId;
	
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
	public Integer getAccrualLogID() {
		return accrualLogID;
	}
	public void setAccrualLogID(Integer accrualLogID) {
		this.accrualLogID = accrualLogID;
	}
	public BigDecimal getConversionRate() {
		if(this.amountPoints !=null && this.amountValue !=null){
			BigDecimal conversionRate = new BigDecimal(this.amountPoints.doubleValue() / this.amountValue.doubleValue(),java.math.MathContext.DECIMAL32);
			return conversionRate;
		}
	
		return BigDecimal.ZERO;
	}
	public void setConversionRate(BigDecimal conversionRate) {
		this.conversionRate = conversionRate;
	}

    public CurrencyTO getCurrencyTO() {
        return currencyTO;
    }

    public void setCurrencyTO(CurrencyTO currencyTO) {
        this.currencyTO = currencyTO;
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

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public String getTypeString() {
        return typeString;
    }

    public void setTypeString(String typeString) {
        this.typeString = typeString;
    }

    @Override
    public String toString() {
        return "AccrualLogTO{" +
                "typeString='" + typeString + '\'' +
                ", accrualLogID=" + accrualLogID +
                ", characteristic='" + characteristic + '\'' +
                ", currencyTO=" + currencyTO +
                ", transactionDate=" + transactionDate +
                ", expiryDate=" + expiryDate +
                ", amountValue=" + amountValue +
                ", amountPoints=" + amountPoints +
                ", partnerDescAux='" + partnerDescAux + '\'' +
                ", conversionRate=" + conversionRate +
                ", namePartner='" + namePartner + '\'' +
                ", idIssuingPatner=" + idIssuingPatner +
                ", eventName='" + eventName + '\'' +
                ", eventId=" + eventId +
                '}';
    }
}
