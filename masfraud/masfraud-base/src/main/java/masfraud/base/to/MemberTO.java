package masfraud.base.to;

import masfraud.base.constants.AddressType;
import masfraud.base.constants.Gender;
import masfraud.base.constants.MaritalStatus;
import org.bson.types.ObjectId;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 * @author Mauricio
 *
 */
public class MemberTO extends EventLogTO implements Serializable {

    private static final long serialVersionUID = -8847647894093004540L;

    private Long pleMemberId;
    private Long prpMemberId;
    private String salutation;
    private String firstName;
    private String middleName;
    private String lastName;
    private Date birthDate;
    private Date enrolDate;
    private Gender gender;
    private MaritalStatus maritalStatus;
    private String nationality;
    private Date createdDate;
    private Date updatedDate;
    private Date registerDate;
    private MemberStatusTO memberStatusTO;
    private List<AddressTO> address;
    private List<AddressTO> deliveryAddress;
    private List<TelephoneTO> telephones;
    private List<MemberTokenTO> tokens;
    private Boolean acceptReceiveSMS;
    private Boolean acceptReceiveEmail;
    private Boolean acceptReceiveCall;
    private MemberSummaryBalanceTO memberSummaryBalanceTO;
    private TierTO tierTO;
    private MemberAccountTO memberAccountTO;
    private List<SegmentTO> segmentTOList;
    private Date tierUpgradeDate;
    private Date tierDowngradeDate;
    private Date tierDowngradeDateGracePeriod;
    private String eventName;
    private Integer eventId;

    public MemberTO() {

    }

    public MemberTO(String pfdMemberId) {
        this.id = new ObjectId(pfdMemberId);
    }

    public TierTO getTierTO() {
        return tierTO;
    }

    public void setTierTO(TierTO tierTO) {
        this.tierTO = tierTO;
    }

    public List<SegmentTO> getSegmentTOList() {
        return segmentTOList;
    }

    public void setSegmentTOList(List<SegmentTO> segmentTOList) {
        this.segmentTOList = segmentTOList;
    }

    public String getSalutation() {
        return salutation;
    }

    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getQualifiedName() {
        String m = middleName != null ? middleName + " " : null;
        return firstName + " " + m + lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public MemberStatusTO getMemberStatusTO() {
        return memberStatusTO;
    }

    public void setMemberStatusTO(MemberStatusTO memberStatusTO) {
        this.memberStatusTO = memberStatusTO;
    }

    public List<AddressTO> getAddress() {
        return address;
    }

    public void setAddress(List<AddressTO> address) {
        this.address = address;
    }

    public List<TelephoneTO> getTelephones() {
        return telephones;
    }

    public void setTelephones(List<TelephoneTO> telephones) {
        this.telephones = telephones;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updatedDate = updateDate;
    }

    public List<MemberTokenTO> getTokens() {
        return tokens;
    }

    public void setTokens(List<MemberTokenTO> tokens) {
        this.tokens = tokens;
    }

    public Boolean isAcceptReceiveSMS() {
        return acceptReceiveSMS;
    }

    public void setAcceptReceiveSMS(Boolean acceptReceiveSMS) {
        this.acceptReceiveSMS = acceptReceiveSMS;
    }

    public Boolean isAcceptReceiveEmail() {
        return acceptReceiveEmail;
    }

    public void setAcceptReceiveEmail(Boolean acceptReceiveEmail) {
        this.acceptReceiveEmail = acceptReceiveEmail;
    }

    public Date getEnrolDate() {
        return enrolDate;
    }

    public void setEnrolDate(Date enrolDate) {
        this.enrolDate = enrolDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public MemberSummaryBalanceTO getMemberSummaryBalanceTO() {
        return memberSummaryBalanceTO;
    }

    public void setMemberSummaryBalanceTO(MemberSummaryBalanceTO memberSummaryBalanceTO) {
        this.memberSummaryBalanceTO = memberSummaryBalanceTO;
    }

    public Date getTierUpgradeDate() {
        return tierUpgradeDate;
    }

    public void setTierUpgradeDate(Date tierUpgradeDate) {
        this.tierUpgradeDate = tierUpgradeDate;
    }

    public Date getTierDowngradeDate() {
        return tierDowngradeDate;
    }

    public void setTierDowngradeDate(Date tierDowngradeDate) {
        this.tierDowngradeDate = tierDowngradeDate;
    }

    public Date getTierDowngradeDateGracePeriod() {
        return tierDowngradeDateGracePeriod;
    }

    public void setTierDowngradeDateGracePeriod(Date tierDowngradeDateGracePeriod) {
        this.tierDowngradeDateGracePeriod = tierDowngradeDateGracePeriod;
    }

    public MemberAccountTO getMemberAccountTO() {
        return memberAccountTO;
    }

    public void setMemberAccountTO(MemberAccountTO memberAccountTO) {
        this.memberAccountTO = memberAccountTO;
    }

    public Boolean isAcceptReceiveCall() {
        return acceptReceiveCall;
    }

    public void setAcceptReceiveCall(Boolean acceptReceiveCall) {
        this.acceptReceiveCall = acceptReceiveCall;
    }

    public Long getPleMemberId() {
        return pleMemberId;
    }

    public void setPleMemberId(Long pleMemberId) {
        this.pleMemberId = pleMemberId;
    }

    public Long getPrpMemberId() {
        return prpMemberId;
    }

    public void setPrpMemberId(Long prpMemberId) {
        this.prpMemberId = prpMemberId;
    }

    public List<AddressTO> getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(List<AddressTO> deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public String getFullName() {
        StringBuffer sb = new StringBuffer();
        sb.append(getFirstName() != null ? getFirstName() + " " : "");
        sb.append(getMiddleName() != null ? getMiddleName() + " " : "");
        sb.append(getLastName() != null ? getLastName() + " " : "");
        return sb.toString().trim();
    }

    public AddressTO getMemberEmail() {
        if (this.getAddress() != null) {
            for (AddressTO addressTO : this.getAddress()) {
                if (addressTO.getAddressTemplateTO().getAddressType().equals(AddressType.EMAIL)) {
                    return addressTO;
                }
            }
        }
        return null;
    }

    public Integer getAge() {
        if (birthDate != null) {
            Calendar dateOfBirth = new GregorianCalendar();
            dateOfBirth.setTime(birthDate);
            Calendar today = Calendar.getInstance();
            int age = today.get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR);
            dateOfBirth.add(Calendar.YEAR, age);
            if (today.before(dateOfBirth)) {
                age--;
            }
            return age;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "MemberTO{" +
                "pleMemberId=" + pleMemberId +
                ", prpMemberId=" + prpMemberId +
                ", salutation='" + salutation + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", enrolDate=" + enrolDate +
                ", gender=" + gender +
                ", maritalStatus=" + maritalStatus +
                ", nationality='" + nationality + '\'' +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                ", registerDate=" + registerDate +
                ", memberStatusTO=" + memberStatusTO +
                ", address=" + address +
                ", deliveryAddress=" + deliveryAddress +
                ", telephones=" + telephones +
                ", tokens=" + tokens +
                ", acceptReceiveSMS=" + acceptReceiveSMS +
                ", acceptReceiveEmail=" + acceptReceiveEmail +
                ", acceptReceiveCall=" + acceptReceiveCall +
                ", memberSummaryBalanceTO=" + memberSummaryBalanceTO +
                ", tierTO=" + tierTO +
                ", memberAccountTO=" + memberAccountTO +
                ", segmentTOList=" + segmentTOList +
                ", tierUpgradeDate=" + tierUpgradeDate +
                ", tierDowngradeDate=" + tierDowngradeDate +
                ", tierDowngradeDateGracePeriod=" + tierDowngradeDateGracePeriod +
                ", eventName='" + eventName + '\'' +
                ", eventId=" + eventId +
                '}';
    }

    public MemberTO newMemberOnlyToken() {
        MemberTO memberTO = new MemberTO();
        memberTO.setTokens(this.getTokens());
        return memberTO;
    }

}