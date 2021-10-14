package business.dataaccess.carrera;

import javax.swing.table.TableModel;

import business.dataaccess.dto.CarreraDto;

public interface CarreraService {
	public void crearCarrera(CarreraDto carrera);
	public boolean existeCarrera(String id);
	public TableModel devolverCarrerasPropiasParticipante();
	public TableModel devolverCarrerasValidas();
	public TableModel devolverCarrerasOrganizador();
}
