package masfraud.base.to;

import masfraud.base.constants.TelephoneType;

import java.io.Serializable;

public class TelephoneTO implements Serializable {

	private static final long serialVersionUID = 7552875845921515558L;
	
	private String number;
	private int areaCode;
	private int countryCode;
	private int extension;

	private TelephoneType type;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public int getExtension() {
		return extension;
	}

	public void setExtension(int extension) {
		this.extension = extension;
	}

	public TelephoneType getType() {
		return type;
	}

	public void setType(TelephoneType type) {
		this.type = type;
	}
	public int getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(int areaCode) {
		this.areaCode = areaCode;
	}

	public int getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(int countryCode) {
		this.countryCode = countryCode;
	}

	@Override
	public String toString() {
		return "TelephoneTO{" +
				"number='" + number + '\'' +
				", areaCode=" + areaCode +
				", countryCode=" + countryCode +
				", extension=" + extension +
				", type=" + type +
				'}';
	}
}
