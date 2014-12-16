package masfraud.base.constants;

public enum EventActionType {
	
	//STATUS
	CHANGE_MEMBER_STATUS("CHANGE_MEMBER_STATUS"),
	
	//MEMBER
	INSERT_MEMBER("INSERT_MEMBER"),
	UPDATE_MEMBER("UPDATE_MEMBER"),
	
	//TOKEN
	INSERT_MEMBER_TOKEN("INSERT_MEMBER_TOKEN"),
	UPDATE_MEMBER_TOKEN("UPDATE_MEMBER_TOKEN"),


    INSERT_MEMBER_DELIVERY_ADDRESS("INSERT_MEMBER_DELIVERY_ADDRESS"),

	//ADDRESS
    INSERT_MEMBER_ADDRESS("INSERT_MEMBER_ADDRESS"),
	UPDATE_MEMBER_ADDRESS("UPDATE_MEMBER_ADDRESS"),

	INSERT_MEMBER_ADDRESS_PHONE("INSERT_MEMBER_ADDRESS_PHONE"),
	UPDATE_MEMBER_ADDRESS_PHONE("UPDATE_MEMBER_ADDRESS_PHONE"),
	
	INSERT_MEMBER_ADDRESS_SOCIAL("INSERT_MEMBER_ADDRESS_SOCIAL"),
	UPDATE_MEMBER_ADDRESS_SOCIAL("UPDATE_MEMBER_ADDRESS_SOCIAL"),
	
	INSERT_MEMBER_ADDRESS_MOBILE("INSERT_MEMBER_ADDRESS_MOBILE"),
	UPDATE_MEMBER_ADDRESS_MOBILE("UPDATE_MEMBER_ADDRESS_MOBILE"),
	
	INSERT_MEMBER_ADDRESS_INSTANT_MESSAGE("INSERT_MEMBER_ADDRESS_INSTANT_MESSAGE"),
	UPDATE_MEMBER_ADDRESS_INSTANT_MESSAGE("UPDATE_MEMBER_ADDRESS_INSTANT_MESSAGE"),
	
	INSERT_MEMBER_ADDRESS_PHYSICAL("INSERT_MEMBER_ADDRESS_PHYSICAL"),
	UPDATE_MEMBER_ADDRESS_PHYSICAL("UPDATE_MEMBER_ADDRESS_PHYSICAL"),
	
	INSERT_MEMBER_ADDRESS_EMAIL("INSERT_MEMBER_ADDRESS_EMAIL"),
	UPDATE_MEMBER_ADDRESS_EMAIL("UPDATE_MEMBER_ADDRESS_EMAIL"),
	
	//ADJUST
	CREDIT_ADJUST("CREDIT_ADJUST"),
	DEBIT_ADJUST("DEBIT_ADJUST"),
	REDEEM_CANCELLATION("REDEEM_CANCELLATION"),
	EARN_CANCELLATION("EARN_CANCELLATION"),
	
	//ACCRUAL
	FINANCIAL_EARN("FINANCIAL_EARN"),
	
	//REDEMPTION
	FINANCIAL_REDEEM("FINANCIAL_REDEEM"),
	REDEMPTION_REWARD("REDEMPTION_REWARD"),

    MEMBER_BALANCE("MEMBER_BALANCE"),
	
	;
	
	private String value;
	
	private EventActionType(String value){
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	
	public static EventActionType toObject(String type){
		if(type != null){
			for(EventActionType eventType : EventActionType.values()){
				if(eventType.value.equals(type)){
					return eventType;
				}
			}
		}
		return null;
	}
	
}