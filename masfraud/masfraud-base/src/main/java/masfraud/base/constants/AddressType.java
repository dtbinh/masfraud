package masfraud.base.constants;

public enum AddressType {

	PHONE("phone", 2,2),
	SOCIAL("social", 5,3), 
	MOBILE("mobile", 6,2), 
	INSTANT_MESSAGE("instantMessage", 4, 2),
	PHYSICAL("physical", 1, 1),
	EMAIL("email", 3, 3);
	
	private Integer type;
	private String name;	
	private Integer template;
	
	private AddressType(final String name, final Integer type, final Integer template){
		this.name = name;
		this.type = type;
		this.template = template;
	}

	public static AddressType toObject(Integer type){
		for (AddressType addressType : AddressType.values()) {
			if (type.equals(addressType.getType())) {
				return addressType;
			}
		}
		return null;
	}
	
	public static AddressType valueByTemplate(Integer template){
		for (AddressType addressType : AddressType.values()) {
			if (template.equals(addressType.getTemplate())) {
				return addressType;
			}
		}
		return null;
	}

	public Integer getType() {
		return type;
	}
	
	public Integer getTemplate() {
		return template;
	}

	public String getName() {
		return name;
	}
	
	public String toString() {
		return name;
	}
}
