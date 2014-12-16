package masfraud.base.constants;

public enum NotificationType {
	CRITICAL("CRITICAL", "class_critical",1),
	HIGH("HIGH", "class_high",2),
	MEDIUM("MEDIUM", "class_medium",3),
	LOW("LOW", "class_low",4),
	INFO("INFO", "class_info",5)
	;
	
	private String value;
	private String cssClass;
	private Integer level;
	
	private NotificationType(String value, String cssClass, Integer level){
		this.value = value;
		this.cssClass = cssClass;
		this.level = level;
	}

	public String getValue() {
		return value;
	}
	
	public String getCssClass() {
		return cssClass;
	}
	public Integer getLevel(){
		return level;
	}

	public static NotificationType toObject(String value){
		if(value != null){
			for(NotificationType notificationType : NotificationType.values()){
				if(value.equals(notificationType.getValue())){
					return notificationType;
				}
			}
		}
		return null;
	}
	
}
