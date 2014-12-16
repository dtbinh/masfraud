package masfraud.base.message;

import masfraud.base.constants.EventType;
import masfraud.base.constants.MessageType;

/**
 * 
 * @author Mauricio
 * 
 */
public class GenericEvent extends BaseEvent {

	private static final long serialVersionUID = 7860112866959005591L;

	private EventType eventType;
	private String payload;
	
	public GenericEvent() {
		setType(MessageType.EVENT);
	}
	
	public EventType getEventType() {
		return eventType;
	}
	public void setEventType(EventType eventType) {
		this.eventType = eventType;
	}
	public String getPayload() {
		return payload;
	}
	public void setPayload(String payload) {
		this.payload = payload;
	}

    @Override
    public String toString() {
        return "GenericEvent{" +
                "eventType=" + eventType +
                ", payload='" + payload + '\'' +
                '}';
    }
}
