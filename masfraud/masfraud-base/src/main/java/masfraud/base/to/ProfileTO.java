package masfraud.base.to;

public class ProfileTO{
	
	private static final long serialVersionUID = -3968396919486158590L;

	private Long id;
	private String name;
	private String description;
	private String status;

	public ProfileTO() {
	}

	public ProfileTO(Long id, String name, String description) {
		super();
		this.id = id;
		this.setName(name);
		this.description = description;
	}

	public ProfileTO(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAuthority() {
		return name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void changeStatus() {
		this.status = "A".equals(status) ? "I" : "A";
	}
}
