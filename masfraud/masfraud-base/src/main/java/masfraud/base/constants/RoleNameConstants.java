package masfraud.base.constants;

public enum RoleNameConstants {

	ENVIRONMENT("environment"),
	COORDINATOR("coordinator"),
	
	SPECIALIST_ACCRUAL("specialistAccrual"),
	SERVICE_ACCRUAL("serviceAccrual"),
	
	SPECIALIST_PROFILE("specialistProfile"),
	SERVICE_PROFILE("serviceProfile"),
	
	SPECIALIST_REDEMPTION("specialistRedemption"),
	SERVICE_REDEMPTION("serviceRedemption"),

    SPECIALIST_SAVE_MEMBER("specialistSaveMember"),
    SERVICE_SAVE_MEMBER("serviceSaveMember");

	private String value;

	private RoleNameConstants(final String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
