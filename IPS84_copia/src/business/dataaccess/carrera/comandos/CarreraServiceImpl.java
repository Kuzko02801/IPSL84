package business.dataaccess.carrera.comandos;

import java.io.File;

import javax.swing.table.TableModel;

import business.dataaccess.carrera.CarreraService;
import business.dataaccess.dto.carrera.CarreraDto;
import business.dataaccess.exception.BusinessDataException;

public class CarreraServiceImpl implements CarreraService {

	@Override
	public TableModel devolverCarrerasPropiasParticipante(String email_atleta) {
		return new DevolverCarrerasPropiasParticipante(email_atleta).devolverCarreras();
	}

	@Override
	public TableModel devolverCarrerasValidas() {
		return new DevolverCarrerasValidas().devolverCarreras();
	}

	@Override
	public TableModel devolverCarrerasOrganizador() {
		return new DevolverCarrerasOrganizador().devolverCarreras();
	}

	@Override
	public void crearCarrera(CarreraDto carrera) throws BusinessDataException {
		new CrearCarrera(carrera).crearCarrera();
	}

	@Override
	public TableModel devolverClasificacionAbsoluta(String id) throws BusinessDataException {
		return new DevolverClasificacionAbsoluta(id).devolverClasificacionAbsoluta();
	}

	@Override
	public CarreraDto findCarreraById(String id) throws BusinessDataException {
		return new EncontrarCarrera(id).encontrarCarrera();
	}

	@Override
	public TableModel devolverClasificacionFemenina(String id) {
		return new DevolverClasificacionFemenina(id).devolverClasificacionFemenina();
	}

	@Override
	public TableModel devolverClasificacionMasculina(String id) {
		return new DevolverClasificacionMasculina(id).devolverClasificacionMasculina();
	}

	@Override
	public void cargarTiempos(String id, File file) throws BusinessDataException {
		new CargarTiempos(id, file).cargarTiempos();
	}

	@Override
	public TableModel cargarClasificacionCategoria(String idCarrera, String categoria) {
		return new CargarClasificacionCategoria(idCarrera, categoria).devolverClasificacionCategoria();
	}

	@Override
	public boolean comprobarInscripcionesFinalizadas(String id_carrera) {
		return new ComprobarInscripcionesFinalizadas(id_carrera).haFinalizado();
	}

	@Override
	public boolean carreraFinalizada(String id_carrera) throws BusinessDataException {
		return new ComprobarCarreraFinalizada(id_carrera).haFinalizado();
	}

	@Override
	public boolean isCarreraLlena(String id_carrera) throws BusinessDataException {
		return new EstaCarreraLlena(id_carrera).execute();
	}

	@Override
	public boolean tieneListaEspera(String id_carrera) throws BusinessDataException {
		return new TieneListaEspera(id_carrera).execute();
	}

	@Override
	public boolean tieneCancelacion(String id_carrera) throws BusinessDataException {
		return new TieneCancelacion(id_carrera).execute();
	}

	@Override
	public Double porcentajeADevolver(String id_carrera) throws BusinessDataException {
		return new PorcentajeADevolver(id_carrera).execute();
	}
}
