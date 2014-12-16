package masfraud.base.constants;

public enum Gender {

	MALE("M", "Masculino"), FEMALE("F", "Feminino");

	private String value;
	private String htmlValue;

	private Gender(String value, String htmlValue) {
		this.value = value;
		this.htmlValue = htmlValue;
	}

	public String getValue() {
		return value;
	}

	public String getHtmlValue() {
		return htmlValue;
	}

	/**
	 * 
	 * @param value
	 * @return
	 */
	public static Gender getByValue(final String value) {
		for (final Gender retorno : Gender.values()) {
			if (retorno.getValue().equals(value)) {
				return retorno;
			}
		}
		return null;
	}

	/**
	 * 
	 * @param value
	 * @return
	 */
	public static Gender getByHtmlInfo(String value) {
		for (final Gender retorno : Gender.values()) {
			if (retorno.getHtmlValue().equals(value)) {
				return retorno;
			}
		}
		return null;
	}

}
