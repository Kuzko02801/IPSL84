package business.dataaccess.carrera;


import javax.swing.table.TableModel;

import business.dataaccess.BusinessDataException;
import business.dataaccess.dto.carrera.CarreraDto;

public interface CarreraService {
	public void crearCarrera(CarreraDto carrera) throws BusinessDataException;
	public boolean existeCarrera(String id);
	public TableModel devolverCarrerasPropiasParticipante(String email_atleta);
	public TableModel devolverCarrerasValidas();
	public TableModel devolverCarrerasOrganizador();
	public CarreraDto findCarreraById(String id);
	public TableModel devolverClasificacionAbsoluta(String id);
	public TableModel devolverClasificacionFemenina(String id);
	public TableModel devolverClasificacionMasculina(String id);

}
