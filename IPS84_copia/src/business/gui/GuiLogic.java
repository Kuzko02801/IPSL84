package business.gui;

import java.io.File;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.TableModel;

import business.dataaccess.DataAccessFactory;
import business.dataaccess.dto.AtletaDto;
import business.dataaccess.dto.carrera.Categoria;
import business.dataaccess.dto.carrera.Periodo;
import business.dataaccess.dto.dtoassembler.DtoAssembler;
import business.dataaccess.exception.BusinessDataException;
import business.dataaccess.util.Check;

/*
 * This class manages all the gui logic.
 */
public class GuiLogic {

	public static void cargarTodasCarrerasParticipante(JTable tablaCarrerasParticipante) {
		TableModel tm = DataAccessFactory.forCarreraService().devolverCarrerasValidas();
		tablaCarrerasParticipante.setModel(tm);
	}

	public static void cargarPropiasCarrerasParticipante(JTable tablaCarrerasParticipante, String email_atleta) {
		TableModel tm = DataAccessFactory.forCarreraService().devolverCarrerasPropiasParticipante(email_atleta);
		tablaCarrerasParticipante.setModel(tm);

	}

	public static void cargarCarrerasOrganizador(JTable tablaCarrerasOrganizador) {
		TableModel tm = DataAccessFactory.forCarreraService().devolverCarrerasOrganizador();
		tablaCarrerasOrganizador.setModel(tm);
	}

	public static void cargarInscritosCarrera(String idCarrera, JTable tablaInscritosOrganizador) {
		TableModel tm = DataAccessFactory.forInscripcionService().devolverParticipantesCarrera(idCarrera);
		tablaInscritosOrganizador.setModel(tm);
	}

	public static void cargarClasificacionesAbsolutas(String idCarrera, JTable tablaClasificacionesAbsoluta) {
		TableModel tm = DataAccessFactory.forCarreraService().devolverClasificacionAbsoluta(idCarrera);
		tablaClasificacionesAbsoluta.setModel(tm);
	}

	public static void cargarClasificacionesMasculinas(String idCarrera, JTable tablaClasificacionesHombre) {
		TableModel tm = DataAccessFactory.forCarreraService().devolverClasificacionMasculina(idCarrera);
		tablaClasificacionesHombre.setModel(tm);
	}

	public static void cargarClasificacionesFemeninas(String idCarrera, JTable tablaClasificacionesMujer) {
		TableModel tm = DataAccessFactory.forCarreraService().devolverClasificacionFemenina(idCarrera);
		tablaClasificacionesMujer.setModel(tm);
	}

	public static boolean comprobarIdValidaCarrera(String id) throws SQLException {
		return Check.raceExists(id);
	}

	public static void registrarAtleta(String email, String dni, String nombre, String fechaNacimiento, String sexo)
			throws BusinessDataException {
		DataAccessFactory.forAtletaService()
				.atletaAdd(DtoAssembler.forAtletaDto(email, dni, nombre, fechaNacimiento, sexo));

	}

	public static void crearCarrera(String nombre, String fecha, String tipo, String distancia, String plazas,
			List<Categoria> categorias, List<Periodo> periodos) throws BusinessDataException {
		DataAccessFactory.forCarreraService().crearCarrera(
				DtoAssembler.forCarreraDto(nombre, fecha, tipo, distancia, null, plazas, categorias, periodos));
	}

	public static void inscribirAtletaCarrera(String id, String email) throws BusinessDataException {
		DataAccessFactory.forAtletaService().inscribirAtleta(id, email);
	}

	public static AtletaDto devuelveAtleta(String email) {
		return DataAccessFactory.forAtletaService().encontrarAtleta(email);
	}

	public static boolean existeUsuario(String email) throws BusinessDataException {
		return DataAccessFactory.forAtletaService().existeAtleta(email);
	}

	public static void pagarInscripcion(String id, String email) {
		DataAccessFactory.forInscripcionService().pasarDePendienteDePagoAInscrito(id, email);
	}
	
	public static void cargaTiemposCarrera(String id_carrera, File tiempos) throws BusinessDataException {
		 DataAccessFactory.forCarreraService().cargarTiempos(id_carrera, tiempos);
	}

	public static void cargarClasificacionCategoria(JTable tabla,String idCarrera, String categoria) {
		TableModel tm=DataAccessFactory.forCarreraService().cargarClasificacionCategoria(idCarrera,categoria);
		tabla.setModel(tm);
	}
	
	public static boolean comprobarInscripcionesFinalizadas(String id_carrera) {
		return DataAccessFactory.forCarreraService().comprobarInscripcionesFinalizadas(id_carrera);
	}
	public static boolean comprobarCarreraFinalizada(String id_carrera) throws BusinessDataException {
		return DataAccessFactory.forCarreraService().carreraFinalizada(id_carrera);
	}
	public static void generarDorsales(String id_carrera,int dorsalesReservados) {
		DataAccessFactory.forInscripcionService().generarDorsalParaCarrera(id_carrera, dorsalesReservados);
	}
	public static double cuotaActualCarrera(String id_carrera) {
		return DataAccessFactory.forInscripcionService().cuotaActualCarrera(id_carrera);
	}
	public static void procesarPagos(String id_carrera,String email,double cuota,double pagado,String comentario) {
		DataAccessFactory.forInscripcionService().procesarHistorialDePagos(id_carrera, email, ""+cuota, ""+pagado, comentario);
	}

	public static void inscribeClubCarrera(File ficheroAtletas) {
		DataAccessFactory.forAtletaService().inscribirClub(ficheroAtletas);
		
	}
	
}
