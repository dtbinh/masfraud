package masfraud.base.to;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class SegmentTO implements Serializable {

	private static final long serialVersionUID = -6020072895797655446L;

	private Long id;
	private LoyaltyProgramTO programTO;
	private String name;
	private String code;
	private String description;
	private String status;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date startDate;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date endDate;
	
	public SegmentTO (Long id){
		this.id = id;
		this.programTO = new LoyaltyProgramTO();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public SegmentTO (){
		this.programTO = new LoyaltyProgramTO();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LoyaltyProgramTO getProgramTO() {
		return programTO;
	}
	public void setProgramTO(LoyaltyProgramTO programTO) {
		this.programTO = programTO;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

}