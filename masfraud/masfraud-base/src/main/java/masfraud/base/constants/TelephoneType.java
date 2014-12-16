package masfraud.base.constants;

public enum TelephoneType {

	RESIDENTIAL,
	COMMERCIAL,
	CELL,
	FAX, MESSAGE, OTHER;

	/**
	 * 
	 * @param value
	 * @return
	 */
	public static TelephoneType getByValue(final String value) {
        for(final TelephoneType retorno : TelephoneType.values()) {
            if(retorno.toString().equals(value)) {
                return retorno;
            }
        }
        return null;
    }
}
