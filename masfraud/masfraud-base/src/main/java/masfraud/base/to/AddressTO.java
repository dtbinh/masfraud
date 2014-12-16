package masfraud.base.to;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


/**
 * @author Mauricio
 *
 */
public class AddressTO implements Serializable{

	private static final long serialVersionUID = 7315927819274947456L;

    @SerializedName("_id")
	private Long id;
	private Long idMember;
	private AddressTemplateTO addressTemplateTO;
	private ProgramAddressTypeTO programAddressTypeTO;
	private String name;
	private Map<String, String> mapValues = new HashMap<>();
	private String values;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<String, String> getMapValues() {
		return mapValues;
	}

	public void setMapValues(Map<String, String> mapValues) {
		this.mapValues = mapValues;
	}

	public String getValues() {
		return values;
	}

	public void setValues(String values) {
		this.values = values;
	}

	public AddressTemplateTO getAddressTemplateTO() {
		return addressTemplateTO;
	}

	public void setAddressTemplateTO(AddressTemplateTO addressTemplateTO) {
		this.addressTemplateTO = addressTemplateTO;
	}

	public ProgramAddressTypeTO getProgramAddressTypeTO() {
		return programAddressTypeTO;
	}

	public void setProgramAddressTypeTO(ProgramAddressTypeTO programAddressTypeTO) {
		this.programAddressTypeTO = programAddressTypeTO;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdMember() {
		return idMember;
	}

	public void setIdMember(Long idMember) {
		this.idMember = idMember;
	}


    @Override
    public String toString() {
        return "AddressTO{" +
                "id=" + id +
                ", idMember=" + idMember +
                ", addressTemplateTO=" + addressTemplateTO +
                ", programAddressTypeTO=" + programAddressTypeTO +
                ", name='" + name + '\'' +
                ", mapValues=" + mapValues +
                ", values='" + values + '\'' +
                '}';
    }
}