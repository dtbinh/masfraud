package masfraud.base.constants;

public enum TreatmentStatus {
	NOVO("NOVO", "Novo"),
	EM_TRATAMENTO("EM_TRATAMENTO","Em Tratamento"), 
	APROVADO("APROVADO", "Aprovado"), 
	REJEITADO("REJEITADO","Rejeitado"),
	TRATADO("TRATADO" ,"Tratado"),
	ENCERRADO("ENCERRADO", "Encerrado");
	
	private String value;
	private String name;
	
	TreatmentStatus(String name, String value){
		this.name = name;
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static TreatmentStatus toObject(String value){
		for (TreatmentStatus treatmentStatus : TreatmentStatus.values()) {
			if (value.equals(treatmentStatus.getValue())) {
				return treatmentStatus;
			}
		}
		return null;
	}
	
	
}
