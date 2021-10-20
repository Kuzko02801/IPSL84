package business.dataaccess.dto.infoadicional;

public enum Genero {
	HOMBRE("hombre"), MUJER("mujer"),NOBINARIO("no_binario"),DEFAULT("default");
	
	public final String label;

	private Genero(String label) {
		this.label = label;
	}
	
	public static Genero generoParser(String aux) {
		if(aux==null) {
			return DEFAULT;
		}
		switch(aux) {
		case "hombre":
			return HOMBRE;
		case "mujer":
			return MUJER;
		default:
			return NOBINARIO;
		}
	}
}
