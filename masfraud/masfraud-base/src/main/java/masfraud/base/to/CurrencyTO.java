package masfraud.base.to;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Marcos
 *
 */
public class CurrencyTO implements Serializable {
	private static final long serialVersionUID = -4134449037561723068L;

	private Integer id;
	private LoyaltyProgramTO loyaltyProgramTO;
	private String code;
	private String name;
	private String description;
	private Integer decimalPlaces;
	private String status;
	private List<PartnerTO> partnerList;
	
	public CurrencyTO() {
		this.loyaltyProgramTO = new LoyaltyProgramTO();
	}
	
	public CurrencyTO(Integer id) {
		this.loyaltyProgramTO = new LoyaltyProgramTO();
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LoyaltyProgramTO getLoyaltyProgramTO() {
		return loyaltyProgramTO;
	}
	public void setLoyaltyProgramTO(LoyaltyProgramTO loyaltyProgramTO) {
		this.loyaltyProgramTO = loyaltyProgramTO;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<PartnerTO> getPartnerList() {
		return partnerList;
	}
	public void setPartnerList(List<PartnerTO> partnerList) {
		this.partnerList = partnerList;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getDecimalPlaces() {
		return decimalPlaces;
	}
	public void setDecimalPlaces(Integer decimalPlaces) {
		this.decimalPlaces = decimalPlaces;
	}
	
	public void addPartner(PartnerTO partnerTO) {
		if (partnerList == null) {
			partnerList = new ArrayList<PartnerTO>();
		}
		partnerList.add(partnerTO);
	}
}