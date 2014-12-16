package masfraud.base.to;

import com.google.gson.annotations.SerializedName;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class ClientTO implements Serializable {

	private static final long serialVersionUID = -2235290319524150314L;
	
	@SerializedName("_id")
	private Integer id;
	private String fantasyName;
	private String corporateName;
	private String cnpj;
	private String status;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date registerDate;

	public ClientTO(Integer id) {
		this.id = id;
	}
	
	public ClientTO() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFantasyName() {
		return this.fantasyName;
	}

	public void setFantasyName(String fantasyName) {
		this.fantasyName = fantasyName;
	}

	public String getCorporateName() {
		return this.corporateName;
	}

	public void setCorporateName(String corporateName) {
		this.corporateName = corporateName;
	}

	public String getCnpj() {
		return this.cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

}