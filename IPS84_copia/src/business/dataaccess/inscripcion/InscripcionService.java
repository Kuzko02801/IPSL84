package business.dataaccess.inscripcion;

import javax.swing.table.TableModel;

public interface InscripcionService {

	public TableModel devolverParticipantesCarrera(String id);
}
