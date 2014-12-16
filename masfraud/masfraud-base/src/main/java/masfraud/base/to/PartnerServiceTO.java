package masfraud.base.to;

/**
 * 
 * @author Marcos
 * 
 */
public enum PartnerServiceTO {

	DATA(1, "Dados"),
	EMISSION(2, "Emissão"),
	IDENTITY(3, "Identidade"),
	LIABILITY(4, "Liability"),
	REDEMPTION(5, "Resgate");

	private Integer id;
	private String name;

	private PartnerServiceTO(final Integer id, final String name) {
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String toString() {
		return id + " - " + name;
	}

	public static PartnerServiceTO toObject(Integer id) {
		for (PartnerServiceTO partnerServiceTO : PartnerServiceTO.values()) {
			if (id.equals(partnerServiceTO.getId())) {
				return partnerServiceTO;
			}
		}
		return null;
	}

}
