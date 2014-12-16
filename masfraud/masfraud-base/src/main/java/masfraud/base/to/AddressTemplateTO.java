package masfraud.base.to;

import masfraud.base.constants.AddressType;

import java.io.Serializable;

public class AddressTemplateTO implements Serializable {

	private static final long serialVersionUID = -3481733961031674159L;
	private Integer id;
	private String format;
	private AddressType addressType;
	
	public AddressTemplateTO(){
	}
	
	public AddressTemplateTO(Integer id, String format){
		this.id =id;
		this.format = format;
	}
	
	public AddressTemplateTO(Integer id, String format, String addressType){
		this.id =id;
		this.format = format;
		this.addressType = AddressType.toObject(Integer.valueOf(addressType));
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public AddressType getAddressType() {
		return addressType;
	}
	public void setAddressType(AddressType addressType) {
		this.addressType = addressType;
	}
}