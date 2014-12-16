package masfraud.base.constants;

public enum ContextKeySpecialist {

    MEMBER_TO("MemberTO"),
    PRIMARY_VALUE("PrimaryValue"),
    ACCRUAL_LOG_TO("AccrualLogTO"),
    REDEMPTION_LOG_TO("RedemptionLogTO"),
    ;

    private String value;

	private ContextKeySpecialist(final String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
