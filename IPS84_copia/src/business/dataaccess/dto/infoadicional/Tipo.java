package business.dataaccess.dto.infoadicional;

public enum Tipo {
	ASFALTO("asfalto"), MONTA�A("monta�a");
	
	public final String label;

	private Tipo(String label) {
		this.label = label;
	}
}
