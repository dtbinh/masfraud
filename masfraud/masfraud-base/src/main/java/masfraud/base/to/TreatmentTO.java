package masfraud.base.to;


import java.io.Serializable;
import java.util.Date;
import masfraud.base.constants.TreatmentStatus;

public class TreatmentTO implements Serializable {

	private static final long serialVersionUID = 2382806647808218652L;
	private Date date;
	private String caseId;
	private TreatmentStatus treatmentStatus;
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getCaseId() {
		return caseId;
	}
	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}
	public TreatmentStatus getTreatmentStatus() {
		return treatmentStatus;
	}
	public void setTreatmentStatus(TreatmentStatus treatmentStatus) {
		this.treatmentStatus = treatmentStatus;
	}
	
}
