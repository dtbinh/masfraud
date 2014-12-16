package masfraud.base.to;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 
 * @author Marcos
 * 
 */
public class PartnerTO implements Serializable {

	private static final long serialVersionUID = 6221481511481874469L;

	private Integer id = 0;
	private LoyaltyProgramTO loyaltyProgramTO;
	private String name;
	private String description;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date createdDate;
	private List<PartnerServiceTO> serviceList;
	private Boolean status;
	
	public PartnerTO(){
		serviceList = new ArrayList<PartnerServiceTO>();
	}
	
	public PartnerTO(Integer id){
		/**
		 * Quando não tiver partner considerar 0 - Para atender Redemption
		 */
		if (id != null) {
			this.id = id;			
		}
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		/**
		 * Quando não tiver partner considerar 0 - Para atender Redemption
		 */
		if (id != null) {
			this.id = id;			
		}
	}

	public LoyaltyProgramTO getLoyaltyProgramTO() {
		return loyaltyProgramTO;
	}

	public void setLoyaltyProgramTO(LoyaltyProgramTO loyaltyProgramTO) {
		this.loyaltyProgramTO = loyaltyProgramTO;
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

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	public List<PartnerServiceTO> getServiceList() {
		return serviceList;
	}

	public void setServiceList(List<PartnerServiceTO> serviceList) {
		this.serviceList = serviceList;
	}
	
	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	public void addService(PartnerServiceTO partnerServiceTO){
		if(serviceList == null){
			serviceList = new ArrayList<PartnerServiceTO>();
		}
		serviceList.add(partnerServiceTO);
	}

	public String toString(){
		return id + " - " + name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PartnerTO other = (PartnerTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	} 
	
}
