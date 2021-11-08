package business.dataaccess.dto.infoadicional;

public enum EstadoInscripcion {
	PREINSCRITO("pre-inscrito"), INSCRITO("inscrito"), PENDIENTE_DE_PAGO("pendiente-de-pago");

	public final String label;

	private EstadoInscripcion(String label) {
		this.label = label;
	}

}
