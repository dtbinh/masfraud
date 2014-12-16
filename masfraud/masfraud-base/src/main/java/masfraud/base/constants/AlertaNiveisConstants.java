package masfraud.base.constants;

public enum AlertaNiveisConstants {

    CRITICO("CRITICO"),
    ALTO("ALTO"),
    MEDIO("MEDIO"),
    BAIXO("BAIXO"),
    INFORMATIVO("INFORMATIVO"),
	;

	private String nivel;

	AlertaNiveisConstants(String nivel){
        this.nivel = nivel;
    }

    public String getNivel() {
        return nivel;
    }
}
