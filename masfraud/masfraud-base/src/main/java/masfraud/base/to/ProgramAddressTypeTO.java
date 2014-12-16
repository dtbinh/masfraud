package masfraud.base.to;

import masfraud.base.constants.AddressType;

import java.io.Serializable;

public class ProgramAddressTypeTO implements Serializable{
	

	private static final long serialVersionUID = 5291125111286450869L;
	
	private Integer id;
    private LoyaltyProgramTO loyaltyProgramTO;
	private String name;
	private String description;
	private String status;
	private AddressType channelType;
	
	public ProgramAddressTypeTO(){
		
	}
	
	public ProgramAddressTypeTO(Integer id){
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public AddressType getChannelType() {
		return channelType;
	}
	public void setChannelType(AddressType channelType) {
		this.channelType = channelType;
	}
    
  
}
