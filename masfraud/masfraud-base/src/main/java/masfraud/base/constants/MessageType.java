package masfraud.base.constants;

public enum MessageType {

	REPLICA("replica"),
	EVENT("event"),
	STRUCTURAL("structural");

	private String value;

	private MessageType(final String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	
}
