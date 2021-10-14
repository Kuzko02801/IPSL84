package business.dataaccess.inscripcion.comandos;

import javax.swing.table.TableModel;

public class InscripcionServiceImpl {

	public TableModel devolverParticipantesCarrera(String id) {
		return new DevolverParticipantesCarrera(id).devolverParticipantes();
	}
}
