package business.dataaccess.inscripcion;

import javax.swing.table.TableModel;

public interface InscripcionService {

	public TableModel devolverParticipantesCarrera(String id);
	void pasarDePendienteDePagoAInscrito(String id, String email, int dorsal);
}
