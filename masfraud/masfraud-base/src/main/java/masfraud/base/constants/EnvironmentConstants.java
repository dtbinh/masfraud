package masfraud.base.constants;

public enum EnvironmentConstants {

	INCOMING_EVENTS("incomingEvents"),
	STRUCTURAL_MAP("structuralMap"),
	ALERT_TABLE("alertTable"),
	SCORE_TABLE("scoreTable"),
    DETECTION_RULE_TOs("listCommand"),
    EVENT_LOG("eventLog"),
    NOTIFICATION_TO("notificationTO");

	private String value;

	private EnvironmentConstants(final String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
