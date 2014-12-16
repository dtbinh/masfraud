package masfraud.base.message;

import java.util.HashMap;
import java.util.Map;

import masfraud.base.constants.RoleNameConstants;

public class StructuralEvent extends BaseEvent {

	private static final long serialVersionUID = 8738533141087584856L;

	private Map<RoleNameConstants, Map<String, String>> activeReplicas = new HashMap<>();

	public Map<RoleNameConstants, Map<String, String>> getActiveReplicas() {
		return activeReplicas;
	}

	public void setActiveReplicas(Map<RoleNameConstants, Map<String, String>> activeReplicas) {
		this.activeReplicas = activeReplicas;
	}
	

}
