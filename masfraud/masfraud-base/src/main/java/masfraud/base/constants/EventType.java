package masfraud.base.constants;

public enum EventType {

	ACCRUAL("accrual"),
	REDEMPTION("redemption"),
	PROFILE("profile"),
    SAVE_MEMBER("saveMember");

    private String value;

	private EventType(final String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	
}
