package masfraud.base.to;

import java.io.Serializable;

/**
 * 
 * @author Mauricio
 *
 */
public class MemberAccountTO implements Serializable{

	private static final long serialVersionUID = 1706524438433538259L;
	
	private Long id;
	private String status;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
