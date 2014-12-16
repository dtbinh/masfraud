package masfraud.base.constants;

public enum EventValidationStatus {

	NEW("new"),
	IN_TREATMENT("treatment"),
	CLOSED("saveMember");

	private String value;

	private EventValidationStatus(final String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	
}
