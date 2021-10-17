package business.dataaccess.inscripcion.comandos;

import javax.swing.table.TableModel;

import business.dataaccess.inscripcion.InscripcionService;

public class InscripcionServiceImpl implements InscripcionService{
	
	@Override
	public TableModel devolverParticipantesCarrera(String id) {
		return new DevolverParticipantesCarrera(id).devolverParticipantes();
	}

	@Override
	public void pasarDePreInscritoAInscrito(String id, String email) {
		new PasarDePreAInscritoAInscrito(id, email).execute();
	}
	
	
}
