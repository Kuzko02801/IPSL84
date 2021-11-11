package business.dataaccess.inscripcion;

import javax.swing.table.TableModel;

public interface InscripcionService {

	TableModel devolverParticipantesCarrera(String id);
	void pasarDePendienteDePagoAInscrito(String id, String email);
	void generarDorsalParaCarrera(String id_carrera, int dorsalesReservados);
	double cuotaActualCarrera(String id_carrera);
}
