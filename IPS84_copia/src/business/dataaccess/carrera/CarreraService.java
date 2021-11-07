package business.dataaccess.carrera;


import javax.swing.table.TableModel;

import business.dataaccess.dto.carrera.CarreraDto;

public interface CarreraService {
	public void crearCarrera(CarreraDto carrera);
	public boolean existeCarrera(String id);
	public TableModel devolverCarrerasPropiasParticipante();
	public TableModel devolverCarrerasValidas();
	public TableModel devolverCarrerasOrganizador();
	public CarreraDto findCarreraById(String id);
	public TableModel devolverClasificacionAbsoluta(String id);
	public TableModel devolverClasificacionFemenina(String id);
	public TableModel devolverClasificacionMasculina(String id);

}
