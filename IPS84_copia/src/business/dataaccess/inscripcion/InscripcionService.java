package business.dataaccess.inscripcion;

import javax.swing.table.TableModel;

public interface InscripcionService {
	
	void cancelarInscripcion(String email, String id_carrera);
	
	TableModel devolverParticipantesCarrera(String id);

	void pasarDePendienteDePagoAInscrito(String id, String email);

	void generarDorsalParaCarrera(String id_carrera, int dorsalesReservados);

	double cuotaActualCarrera(String id_carrera);

	void procesarHistorialDePagos(String id_carrera, String email_atleta, String cuota, String cantidad,
			String comentario);

	void actualizarCantidadPagada(String id_carrera, String email, double pagado);

	double devolverCantidadPagada(String email, String id_carrera);
	boolean estaATiempo(String id, String email);
}
