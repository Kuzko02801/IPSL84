package business.gui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.TableModel;

import business.dataaccess.BusinessDataException;
import business.dataaccess.DataAccessFactory;
import business.dataaccess.dto.AtletaDto;
import business.dataaccess.dto.carrera.Categoria;
import business.dataaccess.dto.carrera.Periodo;
import business.dataaccess.dto.dtoassembler.DtoAssembler;
import business.dataaccess.util.Check;

/*
 * This class manages all the gui logic.
 */
public class GuiLogic {

	public static void mostrarCarrerasParticipante(int index, JTable tablaCarrerasParticipante) {
		if (index == 0) {
			cargarTodasCarrerasParticipante(tablaCarrerasParticipante);
		} else {
			cargarPropiasCarrerasParticipante(tablaCarrerasParticipante);
		}
	}

	public static void cargarTodasCarrerasParticipante(JTable tablaCarrerasParticipante) {
		TableModel tm = DataAccessFactory.forCarreraService().devolverCarrerasValidas();
		tablaCarrerasParticipante.setModel(tm);
	}

	public static void cargarPropiasCarrerasParticipante(JTable tablaCarrerasParticipante) {
		TableModel tm = DataAccessFactory.forCarreraService().devolverCarrerasPropiasParticipante();
		tablaCarrerasParticipante.setModel(tm);

	}

	public static void cargarCarrerasOrganizador(JTable tablaCarrerasOrganizador) {
		TableModel tm = DataAccessFactory.forCarreraService().devolverCarrerasOrganizador();
		tablaCarrerasOrganizador.setModel(tm);
	}

	public static void cargarInscritosCarrera(String idCarrera, JTable tablaCarrerasOrganizador) {
		TableModel tm = DataAccessFactory.forInscripcionService().devolverParticipantesCarrera(idCarrera);
		tablaCarrerasOrganizador.setModel(tm);
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

	public static boolean comprobarIdValidaCarrera(String id) {
		return Check.raceExists2(id);
	}
	public static void registrarAtleta(String email,String dni,String nombre,String fechaNacimiento,String sexo) {
		try {
			DataAccessFactory.forAtletaService().atletaAdd(DtoAssembler.forAtletaDto(email,dni,nombre,fechaNacimiento,sexo));
		} catch (BusinessDataException e) {
			e.printStackTrace();
		}
	}
	public static void crearCarrera(String nombre, String fecha, String tipo, String distancia, String plazas, List<Categoria> categorias, List<Periodo> periodos) throws BusinessDataException {
		DataAccessFactory.forCarreraService().crearCarrera(
				DtoAssembler.forCarreraDto(
						nombre
						, fecha
						, tipo
						, distancia					
						,null
						, plazas					
						, categorias
						, periodos));
					
	}

	public static void inscribirAtletaCarrera(String id, String email) throws BusinessDataException {
		DataAccessFactory.forAtletaService().inscribirAtleta(DtoAssembler.forAtletaDto(email, null, null, null, null),
				DtoAssembler.forCarreraDto(null, null, null, "0", id, "0", new ArrayList<Categoria>(), new ArrayList<Periodo>()));
	}
	public static AtletaDto devuelveAtleta(String email) {
		return DataAccessFactory.forAtletaService().encontrarAtleta(email);
	}
	
	public static boolean existeUsuario(String email) {
		try {
			return DataAccessFactory.forAtletaService().existeAtleta(email);
		} catch (BusinessDataException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static void pagarInscripcion(String id, String email, int dorsal) {
		DataAccessFactory.forInscripcionService().pasarDePendienteDePagoAInscrito(id, email, dorsal);
	}
}
