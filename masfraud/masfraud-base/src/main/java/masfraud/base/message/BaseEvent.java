package masfraud.base.message;

import masfraud.base.constants.MessageType;

import java.io.Serializable;

/**
 * 
 * @author Mauricio
 *
 */
public class BaseEvent implements Serializable {

	private static final long serialVersionUID = -9172724640665412510L;

	private MessageType type;
	private String lastValidation;

	public MessageType getType() {
		return type;
	}

	public void setType(MessageType type) {
		this.type = type;
	}

	public String getLastValidation() {
		return lastValidation;
	}

	public void setLastValidation(String lastValidation) {
		this.lastValidation = lastValidation;
	}

}
