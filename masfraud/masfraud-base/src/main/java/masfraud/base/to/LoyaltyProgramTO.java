package masfraud.base.to;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class LoyaltyProgramTO implements Serializable {

	private static final long serialVersionUID = -5370660403343663854L;
	
	@SerializedName("_id")
	private Integer id;
	private String name;
	private String description;
	private String status;
	private Integer prpId;
	private Integer pleId;
	private ClientTO clientTO;
	private Integer pleSourceSystem;
	private Integer prpSourceSystem;
	
	public LoyaltyProgramTO() {
	}

	public LoyaltyProgramTO(Integer id) {
		this.id = id;
	}

	public ClientTO getClientTO() {
		return clientTO;
	}

	public void setClientTO(ClientTO clientTO) {
		this.clientTO = clientTO;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getPrpId() {
		return prpId;
	}

	public void setPrpId(Integer prpId) {
		this.prpId = prpId;
	}

	public Integer getPleId() {
		return pleId;
	}

	public void setPleId(Integer pleId) {
		this.pleId = pleId;
	}

	
    public Integer getPleSourceSystem() {
		return pleSourceSystem;
	}

	public void setPleSourceSystem(Integer pleSourceSystem) {
		this.pleSourceSystem = pleSourceSystem;
	}

	public Integer getPrpSourceSystem() {
		return prpSourceSystem;
	}

	public void setPrpSourceSystem(Integer prpSourceSystem) {
		this.prpSourceSystem = prpSourceSystem;
	}

	@Override
    public String toString() {
        return "LoyaltyProgramTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", prpId=" + prpId +
                ", pleId=" + pleId +
                ", clientTO=" + clientTO +
                ", pleSourceSystem=" + pleSourceSystem +
                ", prpSourceSystem=" + prpSourceSystem +
                '}';
    }

    public LoyaltyProgramTO newObjectOnlyId(){
        LoyaltyProgramTO loyaltyProgramTO = new LoyaltyProgramTO();
        loyaltyProgramTO.setId(this.getId());
        loyaltyProgramTO.setPrpId(this.getPrpId());
        loyaltyProgramTO.setPleId(this.getPleId());
        ClientTO clientTO = new ClientTO();
        clientTO.setId(this.getClientTO().getId());
        loyaltyProgramTO.setClientTO(clientTO);
        return loyaltyProgramTO;

    }

}