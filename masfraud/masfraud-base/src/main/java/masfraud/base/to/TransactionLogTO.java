package masfraud.base.to;

import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransactionLogTO extends AbstractBaseTO {

	private static final long serialVersionUID = -149566923912046141L;
	private Integer score;
	private String alertId;
	private String eventId;
	private Date executionDate;
	private List<DetectionRuleTO> rules;

	public TransactionLogTO() {
	}

	public TransactionLogTO(ObjectId id) {
		this.id = id;
	}
	
	public TransactionLogTO(String idStr) {
		this.idStr = idStr;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public List<DetectionRuleTO> getRules() {
		return rules;
	}

	public void setRules(List<DetectionRuleTO> rules) {
		this.rules = rules;
	}

	public String getAlertId() {
		return alertId;
	}

	public void setAlertId(String alertId) {
		this.alertId = alertId;
	}

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public Date getExecutionDate() {
		return executionDate;
	}

	public void setExecutionDate(Date executionDate) {
		this.executionDate = executionDate;
	}
	
	public void addRuleId(Long id){
		if(rules == null){
			rules = new ArrayList<DetectionRuleTO>();
		}
		rules.add(new DetectionRuleTO(id));
	}


    @Override
    public String toString() {
        return "TransactionLogTO{" +
                "score=" + score +
                ", alertId='" + alertId + '\'' +
                ", eventId='" + eventId + '\'' +
                ", executionDate=" + executionDate +
                ", rules=" + rules +
                '}';
    }


    public TransactionLogTO newObjectOnlyId(){
        TransactionLogTO transactionLogTO = new TransactionLogTO();
        transactionLogTO.setId(this.getId());
        return transactionLogTO;
    }


    public List<DetectionRuleTO> newListOnlyId(){
        List<DetectionRuleTO> detectionRuleTOs = new ArrayList<>();
        for (DetectionRuleTO detectionRuleTO : this.getRules()){
            detectionRuleTOs.add(detectionRuleTO.newObjectOnlyId());
        }
        return detectionRuleTOs;
    }
}
