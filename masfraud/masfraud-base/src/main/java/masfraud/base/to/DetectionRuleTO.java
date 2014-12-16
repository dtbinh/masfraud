package masfraud.base.to;

import com.google.gson.annotations.SerializedName;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Mauro Wahl
 * @since 15/07/2014 12:18:05
 * @class drools-hello-world.se.waymark.drools.domain.Rules.java
 */
public class DetectionRuleTO implements Serializable{
	private static final long serialVersionUID = 6790144976330618604L;
	@SerializedName("_id")
	private Long id;
	private String name;
	private String code;
	private String description;
	private String rule;
	private Integer score;
	private String eventType;
	private String status;
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private Date createdDt;
	private String sCreatedDt;

	public Date getCreatedDt() {
		return createdDt;
	}

	public void setCreatedDt(Date createdDt) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String sDate = formatter.format(createdDt);
		setsCreatedDt(sDate);
		this.createdDt = createdDt;
	}

	private LoyaltyProgramTO loyaltyProgramTO;
	private Integer clientId;

	public DetectionRuleTO() {
	}

	public DetectionRuleTO(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRule() {
		return this.rule;
	}

	public void setRule(String rule) {
		this.rule = rule;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getEventType() {
		return this.eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LoyaltyProgramTO getLoyaltyProgramTO() {
		return loyaltyProgramTO;
	}

	public void setLoyaltyProgramTO(LoyaltyProgramTO loyaltyProgramTO) {
		this.loyaltyProgramTO = loyaltyProgramTO;
	}

	public String getsCreatedDt() {
		return this.sCreatedDt;
	}

	private void setsCreatedDt(String sCreatedDt) {
		this.sCreatedDt = sCreatedDt;
	}

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

    @Override
    public String toString() {
        return "DetectionRuleTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", description='" + description + '\'' +
                ", rule='" + rule + '\'' +
                ", score=" + score +
                ", eventType='" + eventType + '\'' +
                ", status='" + status + '\'' +
                ", createdDt=" + createdDt +
                ", sCreatedDt='" + sCreatedDt + '\'' +
                ", loyaltyProgramTO=" + loyaltyProgramTO +
                ", clientId=" + clientId +
                '}';
    }


    public DetectionRuleTO newObjectOnlyId(){
        DetectionRuleTO detectionRuleTO = new DetectionRuleTO();
        detectionRuleTO.setId(this.getId());
        detectionRuleTO.setScore(this.getScore());
        detectionRuleTO.setName(this.getName());
        detectionRuleTO.setCode(this.getCode());

        return detectionRuleTO;
    }
    
  
}