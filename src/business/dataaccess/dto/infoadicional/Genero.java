package business.dataaccess.dto.infoadicional;

public enum Genero {
	HOMBRE("hombre"), MUJER("mujer");
	
	public final String label;

	private Genero(String label) {
		this.label = label;
	}
}
