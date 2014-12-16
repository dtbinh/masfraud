package masfraud.base.message;

import masfraud.base.constants.EventActionType;
import masfraud.base.constants.EventType;
import masfraud.base.to.MemberTO;

import java.io.Serializable;
import java.util.Date;

public class Event extends BaseEvent implements Serializable  {

    private static final long serialVersionUID = 364527096280968737L;

    private Object _id;
    private EventType eventType;
    private EventActionType eventActionType;
    private MemberTO memberTO;
    private Date eventDate;


    public Object get_id() {
        return _id;
    }

    public void set_id(Object _id) {
        this._id = _id;
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

    public MemberTO getMemberTO() {
        return memberTO;
    }

    public void setMemberTO(MemberTO memberTO) {
        this.memberTO = memberTO;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }
}
