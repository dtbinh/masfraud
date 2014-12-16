package masfraud.base.message;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * @author Mauricio
 * 
 */
public class AccrualEvent extends BaseEvent {

	private static final long serialVersionUID = -9142791939677169287L;

	private String token;
	private String tokenName;
	private BigDecimal amountPoints = BigDecimal.ZERO;
	private String codeCurrency;
	private String nameCurrency;
	private Date dateTransaction;
	private String idIssuingPartner;
	private String partnerName;
	private String locationCode;
	private String partnerDescAux;

	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getTokenName() {
		return tokenName;
	}

	public void setTokenName(String tokenName) {
		this.tokenName = tokenName;
	}

	public BigDecimal getAmountPoints() {
		return amountPoints;
	}

	public void setAmountPoints(BigDecimal amountPoints) {
		this.amountPoints = amountPoints;
	}

	public String getCodeCurrency() {
		return codeCurrency;
	}

	public void setCodeCurrency(String codeCurrency) {
		this.codeCurrency = codeCurrency;
	}

	public String getNameCurrency() {
		return nameCurrency;
	}

	public void setNameCurrency(String nameCurrency) {
		this.nameCurrency = nameCurrency;
	}

	public Date getDateTransaction() {
		return dateTransaction;
	}

	public void setDateTransaction(Date dateTransaction) {
		this.dateTransaction = dateTransaction;
	}

	public String getIdIssuingPartner() {
		return idIssuingPartner;
	}

	public void setIdIssuingPartner(String idIssuingPartner) {
		this.idIssuingPartner = idIssuingPartner;
	}

	public String getPartnerName() {
		return partnerName;
	}

	public void setPartnerName(String partnerName) {
		this.partnerName = partnerName;
	}

	public String getLocationCode() {
		return locationCode;
	}

	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}

	public String getPartnerDescAux() {
		return partnerDescAux;
	}

	public void setPartnerDescAux(String partnerDescAux) {
		this.partnerDescAux = partnerDescAux;
	}

}
