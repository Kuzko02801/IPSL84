package business.dataaccess.inscripcion.comandos;

import javax.swing.table.TableModel;

import business.dataaccess.inscripcion.InscripcionService;

public class InscripcionServiceImpl implements InscripcionService{
	
	@Override
	public TableModel devolverParticipantesCarrera(String id) {
		return new DevolverParticipantesCarrera(id).devolverParticipantes();
	}

	@Override
	public void pasarDePendienteDePagoAInscrito(String id, String email) {
		new PasarDePendienteDePagoAInscrito(id, email).execute();
	}
	
	@Override
	public void generarDorsalParaCarrera(String id_carrera, int dorsalesReservados) {
		new GenerarDorsalParaCarrera(id_carrera, dorsalesReservados).execute();
	}

	@Override
	public double cuotaActualCarrera(String id_carrera) {
		return new CuotaActualCarrera(id_carrera).execute();
	}
	
	@Override
	public void procesarHistorialDePagos(String id_carrera, String email_atleta,String cuota, String cantidad, String comentario) {
		new ProcesarHistorialDePago(id_carrera, email_atleta, cuota, cantidad, comentario);
	}
	
	
}
