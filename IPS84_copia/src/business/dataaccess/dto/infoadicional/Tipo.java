package business.dataaccess.dto.infoadicional;

public enum Tipo {
	ASFALTO("asfalto"), MONTA�A("monta�a");
	
	public final String label;

	private Tipo(String label) {
		this.label = label;
	}
	
	public static Tipo tipoParser(String aux) {
		switch(aux) {
		case "asfalto":
			return ASFALTO;
		case "monta�a":
			return MONTA�A;
		}
		return null;
	}
}
