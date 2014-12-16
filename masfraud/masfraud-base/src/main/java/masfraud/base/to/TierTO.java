package masfraud.base.to;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TierTO implements Serializable, Comparable<TierTO> {

	private static final long serialVersionUID = -4986938595176372118L;

	private Long id;
	private LoyaltyProgramTO loyaltyProgramTO;
	private String description;
	private String name;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date startExpirationDate;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date endExpirationDate;
	private List<MemberStatusTO> statusList;
	private List<SegmentTO> segmentList;
	private Integer gracePeriodToDowngrade;
	private Boolean initialTier;
	private Boolean status;
	private Integer level;

	public TierTO() {
		this.initialTier = false;
		this.loyaltyProgramTO = new LoyaltyProgramTO();
	}
	
	public TierTO(Long id) {
		this.id = id;
		this.loyaltyProgramTO = new LoyaltyProgramTO();
	}
	
	public TierTO(Long id, Integer level) {
		this.id = id;
		this.level = level;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<MemberStatusTO> getStatusList() {
		return statusList;
	}

	public void setStatusList(List<MemberStatusTO> statusList) {
		this.statusList = statusList;
	}

	public Integer getGracePeriodToDowngrade() {
		return gracePeriodToDowngrade;
	}

	public void setGracePeriodToDowngrade(Integer gracePeriodToDowngrade) {
		this.gracePeriodToDowngrade = gracePeriodToDowngrade;
	}

	public Date getStartExpirationDate() {
		return startExpirationDate;
	}

	public void setStartExpirationDate(Date startExpirationDate) {
		this.startExpirationDate = startExpirationDate;
	}

	public Date getEndExpirationDate() {
		return endExpirationDate;
	}

	public void setEndExpirationDate(Date endExpirationDate) {
		this.endExpirationDate = endExpirationDate;
	}

	public Boolean getInitialTier() {
		return initialTier;
	}

	public void setInitialTier(Boolean initialTier) {
		this.initialTier = initialTier;
	}

	public LoyaltyProgramTO getLoyaltyProgramTO() {
		return loyaltyProgramTO;
	}

	public void setLoyaltyProgramTO(LoyaltyProgramTO loyaltyProgramTO) {
		this.loyaltyProgramTO = loyaltyProgramTO;
	}

	public List<SegmentTO> getSegmentList() {
		return segmentList;
	}

	public void setSegmentList(List<SegmentTO> segmentList) {
		this.segmentList = segmentList;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public void addMemberStatus(MemberStatusTO memberStatusTO){
		if(statusList == null){
			statusList = new ArrayList<MemberStatusTO>();
		}
		statusList.add(memberStatusTO);
	}
	
	public void addSegment(SegmentTO segmentTO){
		if(segmentList == null){
			segmentList = new ArrayList<SegmentTO>();
		}
		segmentList.add(segmentTO);
	}
	
	public String toString() {
		return this.id + " - " + this.name;
	}

	@Override
	public int compareTo(TierTO tierTO) {
		return this.getLevel().compareTo(tierTO.getLevel());
	}

}
