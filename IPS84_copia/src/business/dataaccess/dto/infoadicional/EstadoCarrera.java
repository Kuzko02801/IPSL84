package business.dataaccess.dto.infoadicional;

public enum EstadoCarrera {
	FINALIZADA("finalizada"), EN_PROGRESO("en_progreso"), NO_COMENZADA("no_comenzada");
	
public final String label;
	
	private EstadoCarrera(String label) {
		this.label = label;
	}
}
