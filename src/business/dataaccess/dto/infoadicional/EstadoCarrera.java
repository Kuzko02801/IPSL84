package business.dataaccess.dto.infoadicional;

public enum EstadoCarrera {
	FINALIZADA("finalizada"), EN_PROGRESO("en progreso"), NO_COMENZADA("no comenzada");
	
public final String label;
	
	private EstadoCarrera(String label) {
		this.label = label;
	}
}
