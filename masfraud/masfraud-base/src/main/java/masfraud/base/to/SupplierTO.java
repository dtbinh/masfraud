package masfraud.base.to;

import java.io.Serializable;

/**
 * 
 * @author Marcos Pestana
 * 
 */
public class SupplierTO implements Serializable {

	private static final long serialVersionUID = 5523306350608358923L;

	private Integer id;
	private String fantasyName;
	private String corporateName;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFantasyName() {
		return fantasyName;
	}
	public void setFantasyName(String fantasyName) {
		this.fantasyName = fantasyName;
	}
	public String getCorporateName() {
		return corporateName;
	}
	public void setCorporateName(String corporateName) {
		this.corporateName = corporateName;
	}
	

}
