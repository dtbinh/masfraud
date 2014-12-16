package masfraud.base.to;

import java.io.Serializable;
import java.util.List;

public class AlertLogTO extends AbstractBaseTO implements Serializable{
	
	private static final long serialVersionUID = -3239097166356754889L;
	private MemberTO memberTO;
	private LoyaltyProgramTO loyaltyProgramTO;
	private TransactionLogTO transactionLogTO;
	private EventLogTO eventLogTO;
	private List<DetectionRuleTO> detectionRuleTOList;
	private NotificationTO notificationTO;
	private TreatmentTO treatmentTO;
	private SalesforceCaseTO salesforceCaseTO;

	public MemberTO getMemberTO() {
		return memberTO;
	}

	public void setMemberTO(MemberTO memberTO) {
		this.memberTO = memberTO;
	}

	public List<DetectionRuleTO> getDetectionRuleTOList() {
		return detectionRuleTOList;
	}

	public void setDetectionRuleTOList(List<DetectionRuleTO> detectionRuleTOList) {
		this.detectionRuleTOList = detectionRuleTOList;
	}

	public NotificationTO getNotificationTO() {
		return notificationTO;
	}

	public void setNotificationTO(NotificationTO notificationTO) {
		this.notificationTO = notificationTO;
	}

	public LoyaltyProgramTO getLoyaltyProgramTO() {
		return loyaltyProgramTO;
	}

	public void setLoyaltyProgramTO(LoyaltyProgramTO loyaltyProgramTO) {
		this.loyaltyProgramTO = loyaltyProgramTO;
	}

	public TransactionLogTO getTransactionLogTO() {
		return transactionLogTO;
	}

	public void setTransactionLogTO(TransactionLogTO transactionLogTO) {
		this.transactionLogTO = transactionLogTO;
	}

	public EventLogTO getEventLogTO() {
		return eventLogTO;
	}

	public void setEventLogTO(EventLogTO eventLogTO) {
		this.eventLogTO = eventLogTO;
	}

    public TreatmentTO getTreatmentTO() {
		return treatmentTO;
	}

	public void setTreatmentTO(TreatmentTO treatmentTO) {
		this.treatmentTO = treatmentTO;
	}

	@Override
    public String toString() {
        return "AlertLogTO{" +
                "memberTO=" + memberTO +
                ", loyaltyProgramTO=" + loyaltyProgramTO +
                ", transactionLogTO=" + transactionLogTO +
                ", eventLogTO=" + eventLogTO +
                ", detectionRuleTOList=" + detectionRuleTOList +
                ", notificationTO=" + notificationTO +
                ", salesforceCaseTO=" + salesforceCaseTO +
                '}';
    }

	public SalesforceCaseTO getSalesforceCaseTO() {
		return salesforceCaseTO;
	}

	public void setSalesforceCaseTO(SalesforceCaseTO salesforceCaseTO) {
		this.salesforceCaseTO = salesforceCaseTO;
	}
	
}