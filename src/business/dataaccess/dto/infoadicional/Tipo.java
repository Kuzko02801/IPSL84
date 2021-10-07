package business.dataaccess.dto.infoadicional;

public enum Tipo {
	ASFALTO("asfalto"), MONTAÑA("montaña");
	
	public final String label;

	private Tipo(String label) {
		this.label = label;
	}
}
