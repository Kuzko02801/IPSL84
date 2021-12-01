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

	public CarreraDto findCarreraById(String id) throws BusinessDataException;

	public TableModel devolverClasificacionAbsoluta(String id) throws BusinessDataException;

	public TableModel devolverClasificacionFemenina(String id) throws BusinessDataException;

	public TableModel devolverClasificacionMasculina(String id) throws BusinessDataException;

	public void cargarTiempos(String id, File tiempos) throws BusinessDataException;

	public TableModel cargarClasificacionCategoria(String idCarrera, String categoria);

	public boolean comprobarInscripcionesFinalizadas(String idCarrera);

	boolean carreraFinalizada(String id_carrera) throws BusinessDataException;

	boolean isCarreraLlena(String id_carrera) throws BusinessDataException;

	boolean tieneListaEspera(String id_carrera) throws BusinessDataException;

	boolean tieneCancelacion(String id_carrera) throws BusinessDataException;

	Double porcentajeADevolver(String id_carrera) throws BusinessDataException;
}
