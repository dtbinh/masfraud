package masfraud.base.to;

import masfraud.base.constants.EventActionType;
import masfraud.base.constants.EventType;
import masfraud.base.constants.NotificationType;
import masfraud.base.constants.ScoreStatus;
import org.bson.types.ObjectId;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Mauricio
 * 
 */
public class EventLogTO extends AbstractBaseTO implements Serializable {

	private static final long serialVersionUID = -6369052308411711963L;

	private TransactionLogTO transactionLog;
	private Date eventDate;
	private EventType eventType;
	private EventActionType eventActionType;
	private ScoreStatus scoreStatus;
	private NotificationType notificationType;
	private LoyaltyProgramTO loyaltyProgramTO;
	private MemberTO memberTO;
	private String sourceSystem;
	private String sourceId;
	private String eventPayload;
    private String UUID;

	public EventLogTO() {

	}

	public EventLogTO(ObjectId id) {
		this.id = id;
	}

	public TransactionLogTO getTransactionLog() {
		return transactionLog;
	}

	public void setTransactionLog(TransactionLogTO transactionLog) {
		this.transactionLog = transactionLog;
	}

	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	public EventType getEventType() {
		return eventType;
	}

	public void setEventType(EventType eventType) {
		this.eventType = eventType;
	}

	public EventActionType getEventActionType() {
		return eventActionType;
	}

	public void setEventActionType(EventActionType eventActionType) {
		this.eventActionType = eventActionType;
	}

	public ScoreStatus getScoreStatus() {
		return scoreStatus;
	}

	public void setScoreStatus(ScoreStatus scoreStatus) {
		this.scoreStatus = scoreStatus;
	}

	public NotificationType getNotificationType() {
		return notificationType;
	}

	public void setNotificationType(NotificationType notificationType) {
		this.notificationType = notificationType;
	}

	public LoyaltyProgramTO getLoyaltyProgramTO() {
		return loyaltyProgramTO;
	}

	public void setLoyaltyProgramTO(LoyaltyProgramTO loyaltyProgramTO) {
		this.loyaltyProgramTO = loyaltyProgramTO;
	}

	public MemberTO getMemberTO() {
		return memberTO;
	}

	public void setMemberTO(MemberTO memberTO) {
		this.memberTO = memberTO;
	}

	public String getSourceSystem() {
		return sourceSystem;
	}

	public void setSourceSystem(String sourceSystem) {
		this.sourceSystem = sourceSystem;
	}

	public String getSourceId() {
		return sourceId;
	}

	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}

	public String getEventPayload() {
		return eventPayload;
	}

	public void setEventPayload(String eventPayload) {
		this.eventPayload = eventPayload;
	}

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public Map<String, Object> getWhereMap() {
		Map<String, Object> whereMap = new HashMap<String, Object>();

		/*
		 * if(this.eventDate != null){ whereMap.put("eventDate",
		 * this.eventDate); }
		 */
		if (this.eventType != null) {
			whereMap.put("eventType", this.eventType);
		}
		if (this.eventActionType != null) {
			whereMap.put("eventActionType", this.eventActionType);
		}
		if (this.scoreStatus != null) {
			whereMap.put("scoreStatus", this.scoreStatus);
		}
		if (this.notificationType != null) {
			whereMap.put("notificationType", this.notificationType);
		}
		if (this.loyaltyProgramTO != null && this.loyaltyProgramTO.getId() != null) {
			whereMap.put("loyaltyProgramTO.id", this.loyaltyProgramTO.getId());
		}
		if (this.loyaltyProgramTO != null && this.loyaltyProgramTO.getClientTO() != null) {
			whereMap.put("loyaltyProgramTO.clientTO.id", this.loyaltyProgramTO.getClientTO().getId());
		}
		if (this.sourceSystem != null) {
			whereMap.put("sourceSystem", this.sourceSystem);
		}
		if (this.sourceId != null) {
			whereMap.put("sourceId", this.sourceId);
		}
		if (this.eventPayload != null) {
			whereMap.put("eventPayload", this.eventPayload);
		}
        if (this.UUID != null) {
            whereMap.put("uuid", this.UUID);
        }
		return whereMap;
	}

    @Override
    public String toString() {
        return "EventLogTO{" +
                "transactionLog=" + transactionLog +
                ", eventDate=" + eventDate +
                ", eventType=" + eventType +
                ", eventActionType=" + eventActionType +
                ", scoreStatus=" + scoreStatus +
                ", notificationType=" + notificationType +
                ", loyaltyProgramTO=" + loyaltyProgramTO +
                ", memberTO=" + memberTO +
                ", sourceSystem='" + sourceSystem + '\'' +
                ", sourceId='" + sourceId + '\'' +
                ", eventPayload='" + eventPayload + '\'' +
                ", UUID='" + UUID + '\'' +
                '}';
    }


    public EventLogTO newObjectOnlyId(){
        EventLogTO eventLogTO = new EventLogTO();
        eventLogTO.setId(this.getId());
        eventLogTO.setEventType(this.getEventType());
        eventLogTO.setEventDate(this.getEventDate());
        eventLogTO.setScoreStatus(this.getScoreStatus());
        return eventLogTO;
    }

}