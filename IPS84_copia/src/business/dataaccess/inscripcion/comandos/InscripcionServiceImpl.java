package business.dataaccess.inscripcion.comandos;

import javax.swing.table.TableModel;

import business.dataaccess.inscripcion.InscripcionService;

public class InscripcionServiceImpl implements InscripcionService{
	
	@Override
	public TableModel devolverParticipantesCarrera(String id) {
		return new DevolverParticipantesCarrera(id).devolverParticipantes();
	}

	@Override
	public void pasarDePendienteDePagoAInscrito(String id, String email, int dorsal) {
		new PasarDePendienteDePagoAInscrito(id, email, dorsal).execute();
	}
	
	@Override
	public int generarDorsalParaCarrera(String id_carrera, int dorsalesReservados) {
		return new GenerarDorsalParaCarrera(id_carrera, dorsalesReservados).execute();
	}
	
	
}
