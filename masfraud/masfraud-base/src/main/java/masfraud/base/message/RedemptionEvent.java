package masfraud.base.message;

import java.io.Serializable;

/**
 * 
 * @author Mauricio
 * 
 */
public class RedemptionEvent implements Serializable {

	private static final long serialVersionUID = -3671480900876654690L;

	private String idMember;
	private String codeCurrency;
	private String nameCurrency;
	private String amountPoints;
	private String idRedemptionSource;
	private String partnerDescAux;

	public String getIdMember() {
		return idMember;
	}

	public void setIdMember(String idMember) {
		this.idMember = idMember;
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

	public String getAmountPoints() {
		return amountPoints;
	}

	public void setAmountPoints(String amountPoints) {
		this.amountPoints = amountPoints;
	}

	public String getIdRedemptionSource() {
		return idRedemptionSource;
	}

	public void setIdRedemptionSource(String idRedemptionSource) {
		this.idRedemptionSource = idRedemptionSource;
	}

	public String getPartnerDescAux() {
		return partnerDescAux;
	}

	public void setPartnerDescAux(String partnerDescAux) {
		this.partnerDescAux = partnerDescAux;
	}

}
