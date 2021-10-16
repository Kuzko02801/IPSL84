package business.dataaccess.dto.infoadicional;

public enum Tipo {
	ASFALTO("asfalto"), MONTAÑA("montaña");
	
	public final String label;

	private Tipo(String label) {
		this.label = label;
	}
	
	public static Tipo tipoParser(String aux) {
		switch(aux) {
		case "asfalto":
			return ASFALTO;
		case "montaña":
			return MONTAÑA;
		}
		return null;
	}
}
