package masfraud.base.constants;

public enum ContextKey {

	AGENT_LOCAL_NAME("agentLocalName"),
	AGENT_ROLE_NAME("agentRoleName"),
	AGENT_INSTANCE("agentInstance"),
	STRING_MESSAGE("stringMessage"),
	INCOMING_MESSAGE("incomingMessage"),
	MESSAGE("message"),
	STRUCTURAL_MESSAGE("message"),
	;

	private String value;

	private ContextKey(final String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	
}
