package masfraud.base.message;

import masfraud.base.constants.MessageType;


public class ReplicaEvent extends BaseEvent {

	private static final long serialVersionUID = 8738533141087584856L;

	public ReplicaEvent() {
		this.setType(MessageType.REPLICA);
	}
	
	private String replicaName;
	private String containerDest;

	public String getReplicaName() {
		return replicaName;
	}

	public void setReplicaName(String replicaName) {
		this.replicaName = replicaName;
	}

	public String getContainerDest() {
		return containerDest;
	}

	public void setContainerDest(String containerDest) {
		this.containerDest = containerDest;
	}

}
