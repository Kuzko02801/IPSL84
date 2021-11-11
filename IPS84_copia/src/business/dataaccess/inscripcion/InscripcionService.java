package business.dataaccess.inscripcion;

import javax.swing.table.TableModel;

public interface InscripcionService {

	TableModel devolverParticipantesCarrera(String id);
	void pasarDePendienteDePagoAInscrito(String id, String email, int dorsal);
	void generarDorsalParaCarrera(String id_carrera, int dorsalesReservados);
}
