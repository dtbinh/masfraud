package masfraud.base.to;

import com.google.gson.Gson;

/**
 * Created with IntelliJ IDEA.
 * User: sorge
 * Date: 12/5/14
 * Time: 1:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class ObjectParse {

    private String payload;
    private MemberTO memberTO;
    private EventLogTO eventLogTO;
    private AccrualLogTO accrualLogTO;
    private RedemptionLogTO redemptionLogTO;

    public RedemptionLogTO getRedemptionLogTO() {
        return new Gson().fromJson(payload, RedemptionLogTO.class);
    }

    public void setRedemptionLogTO(RedemptionLogTO redemptionLogTO) {
        this.redemptionLogTO = redemptionLogTO;
    }

    public AccrualLogTO getAccrualLogTO() {
        return new Gson().fromJson(payload, AccrualLogTO.class);
    }

    public void setAccrualLogTO(AccrualLogTO accrualLogTO) {
        this.accrualLogTO = accrualLogTO;
    }

    public MemberTO getMemberTO() {
        return new Gson().fromJson(payload, MemberTO.class);
    }

    public void setMemberTO(MemberTO memberTO) {
        this.memberTO = memberTO;
    }

    public EventLogTO getEventLogTO() {
        return new Gson().fromJson(payload, EventLogTO.class);
    }

    public void setEventLogTO(EventLogTO eventLogTO) {
        this.eventLogTO = eventLogTO;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    @Override
    public String toString() {
        return "ObjectParse{" +
                "payload='" + payload + '\'' +
                ", memberTO=" + memberTO +
                ", eventLogTO=" + eventLogTO +
                ", accrualLogTO=" + accrualLogTO +
                ", redemptionLogTO=" + redemptionLogTO +
                '}';
    }
}
