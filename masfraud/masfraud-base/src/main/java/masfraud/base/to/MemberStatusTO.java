package masfraud.base.to;

import java.io.Serializable;

public class MemberStatusTO implements Serializable
{

	private static final long serialVersionUID = -6340246628274426550L;

	private Integer id;
	private Integer idProgram;
	private String name;
	private String description;
	private Boolean initialStatus;
	private Boolean finalStatus;
	private String status;
	
	public MemberStatusTO() {
	}
	
	public MemberStatusTO(Integer id) {
		this.id = id;
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public Integer getIdProgram()
	{
		return idProgram;
	}

	public void setIdProgram(Integer idProgram)
	{
		this.idProgram = idProgram;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public Boolean getInitialStatus()
	{
		return initialStatus;
	}

	public void setInitialStatus(Boolean initialStatus)
	{
		this.initialStatus = initialStatus;
	}

	public Boolean getFinalStatus()
	{
		return finalStatus;
	}

	public void setFinalStatus(Boolean finalStatus)
	{
		this.finalStatus = finalStatus;
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}