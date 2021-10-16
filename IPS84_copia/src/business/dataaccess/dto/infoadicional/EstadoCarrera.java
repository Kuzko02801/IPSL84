package business.dataaccess.dto.infoadicional;

public enum EstadoCarrera {
	FINALIZADA("finalizada"), EN_PROGRESO("en_progreso"), NO_COMENZADA("no_comenzada");
	
public final String label;
	
	private EstadoCarrera(String label) {
		this.label = label;
	}
	
	public static EstadoCarrera estadoParser(String aux) {
		switch(aux) {
		case "finalizada":
			return FINALIZADA;
		case "en_progreso":
			return EN_PROGRESO;
		case "no_comenzada":
			return NO_COMENZADA;
		}
		return null;
	}
}
