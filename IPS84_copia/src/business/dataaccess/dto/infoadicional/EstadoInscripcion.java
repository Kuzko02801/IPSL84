package business.dataaccess.dto.infoadicional;

public enum EstadoInscripcion {
	PREINSCRITO("pre-inscrito"), INSCRITO("inscrito");

	public final String label;

	private EstadoInscripcion(String label) {
		this.label = label;
	}

}
