package business.dataaccess.dto.infoadicional;

public enum Tipo {
	ASFALTO("asfalto"), MONTA�A("monta�a"),CARRERA_POPULAR("Carrera_popular"),DEFAULT("default");
	
	public final String label;

	private Tipo(String label) {
		this.label = label;
	}
	
	public static Tipo tipoParser(String aux) {
		if(aux==null) {
			return DEFAULT;
		}
		switch(aux) {
		case "asfalto":
			return ASFALTO;
		case "monta�a":
			return MONTA�A;
		default:
			return CARRERA_POPULAR;
		}
	}
}
