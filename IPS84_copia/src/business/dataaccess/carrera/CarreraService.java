package business.dataaccess.carrera;


import java.io.File;

import javax.swing.table.TableModel;

import business.dataaccess.dto.carrera.CarreraDto;
import business.dataaccess.exception.BusinessDataException;

public interface CarreraService {
	public void crearCarrera(CarreraDto carrera) throws BusinessDataException;
	public TableModel devolverCarrerasPropiasParticipante(String email_atleta);
	public TableModel devolverCarrerasValidas();
	public TableModel devolverCarrerasOrganizador();
	public CarreraDto findCarreraById(String id);
	public TableModel devolverClasificacionAbsoluta(String id);
	public TableModel devolverClasificacionFemenina(String id);
	public TableModel devolverClasificacionMasculina(String id);
	public void cargarTiempos(String id,File tiempos) throws BusinessDataException;
	public TableModel cargarClasificacionCategoria(String idCarrera, String categoria);
	public boolean comprobarInscripcionesFinalizadas(String idCarrera);
	boolean carreraFinalizada(String id_carrera) throws BusinessDataException;
}
