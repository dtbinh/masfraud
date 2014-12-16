package masfraud.base.constants;

/**
 * @author Marcos Pestana
 *
 */
public enum ScoreStatus {

	NEW("NEW","N"),
	TREATMENT("TREATMENT","T"), 
	INELIGIBLE("INELIGIBLE", "I"),
	FRAUD("FRAUD", "F"),
	CLOSED("CLOSED","C");

	
	private String acronym;
	
	private String name;

	
	private ScoreStatus(final String name, final String acronym){
		this.name = name;
		this.acronym = acronym;
	}
	
	public String getAcronym(){
		return this.acronym;
	}
	
	public String getName(){
		return this.name;
	}
	
	public static ScoreStatus forValue(String acronym) throws EnumConstantNotPresentException{
		for(ScoreStatus scoreStatus : ScoreStatus.values()){
			if(scoreStatus.getAcronym().equals(acronym)){
				return scoreStatus;
			}
		}
		throw new EnumConstantNotPresentException(ScoreStatus.class, acronym);
	}

	
}
