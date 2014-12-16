package masfraud.base.to;

import com.google.gson.annotations.SerializedName;
import masfraud.base.constants.EventType;
import masfraud.base.constants.NotificationType;

import java.io.Serializable;

public class NotificationTO implements Serializable {

    private static final long serialVersionUID = -4129236550397877100L;

    @SerializedName("_id")
    private Long id;
    private NotificationType notificationType;
    private Integer score;
    private boolean openCase;
    private String status;
    private LoyaltyProgramTO loyaltyProgramTO;
    private EventType eventType;
    private Integer level;


    public NotificationTO() {

    }

    public NotificationTO(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
	
	public NotificationTO(NotificationType notificationType) {
		this.notificationType = notificationType;
	}

    public void setId(Long id) {
        this.id = id;
    }

    public String getNotificationTypeCss() {
        return notificationType.getCssClass();
    }

    public NotificationType getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(NotificationType notificationType) {
        this.notificationType = notificationType;
        this.level = notificationType.getLevel();
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public boolean getOpenCase() {
        return openCase;
    }

    public void setOpenCase(boolean openCase) {
        this.openCase = openCase;
    }

    public String getStatus() {
        return status;
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

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }


    @Override
    public String toString() {
        return "NotificationTO{" +
                "id=" + id +
                ", notificationType=" + notificationType +
                ", score=" + score +
                ", openCase=" + openCase +
                ", status='" + status + '\'' +
                ", loyaltyProgramTO=" + loyaltyProgramTO +
                ", eventType=" + eventType +
                '}';
    }

    public NotificationTO newObjectOnlyId(){
        NotificationTO notificationTO = new NotificationTO();
        notificationTO.setId(this.getId());
        notificationTO.setNotificationType(this.getNotificationType());
        notificationTO.setScore(this.getScore());
        return notificationTO;
    }

	public Integer getLevel() {
		return level;
	}


}