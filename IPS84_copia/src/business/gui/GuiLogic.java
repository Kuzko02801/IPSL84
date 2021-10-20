package business.gui;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableModel;

import business.dataaccess.BusinessDataException;
import business.dataaccess.DataAccessFactory;
import business.dataaccess.dto.AtletaDto;
import business.dataaccess.dto.dtoassembler.DtoAssembler;
import business.dataaccess.dto.infoadicional.Genero;
import business.dataaccess.util.Check;
import gui.aplicacion.VentanaPedirEmail;

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

	public static void cargarInscritosCarrera(JTextField txt, JTable tablaCarrerasOrganizador) {
		String idCarrera = txt.getText();
		TableModel tm = DataAccessFactory.forInscripcionService().devolverParticipantesCarrera(idCarrera);
		tablaCarrerasOrganizador.setModel(tm);
	}

	public static void cargarClasificacionesAbsolutas(JTextField txIdOrganizador, JTable tablaClasificacionesAbsoluta) {
		String idCarrera = txIdOrganizador.getText();
		TableModel tm = DataAccessFactory.forCarreraService().devolverClasificacionAbsoluta(idCarrera);
		tablaClasificacionesAbsoluta.setModel(tm);
	}

	public static void cargarClasificacionesMasculinas(JTextField txIdOrganizador, JTable tablaClasificacionesHombre) {
		String idCarrera = txIdOrganizador.getText();
		TableModel tm = DataAccessFactory.forCarreraService().devolverClasificacionMasculina(idCarrera);
		tablaClasificacionesHombre.setModel(tm);
	}

	public static void cargarClasificacionesFemeninas(JTextField txIdOrganizador, JTable tablaClasificacionesMujer) {
		String idCarrera = txIdOrganizador.getText();
		TableModel tm = DataAccessFactory.forCarreraService().devolverClasificacionFemenina(idCarrera);
		tablaClasificacionesMujer.setModel(tm);
	}

	public static boolean comprobarIdValidaCarrera(JTextField txIdCarreraParticipante) {
		return Check.raceExists2(txIdCarreraParticipante.getText());
	}
	public static void registrarAtleta(String email,String dni,String nombre,String fechaNacimiento,String sexo) {
		DataAccessFactory.forAtletaService().atletaAdd(new AtletaDto(email,dni,nombre,fechaNacimiento,Genero.generoParser(sexo)));
	}


	public static void comprobarIdValidaParticipante() {
//		if (idValida(getTxIdCarreraParticipante().getText())) {
//			getTxIdCarreraValidaParticipante().setText("Válida");
//			getBtInscribirseParticipante().setEnabled(true);
//		} else {
//			getTxIdCarreraValidaParticipante().setText("No es valida");
//			getBtInscribirseParticipante().setEnabled(false);
//		}
		return;
	}

	// TODO
	public static void crearCarrera(String nombre,int distancia,String tipo,int plazas,int cuota,String fechaApertura,String fechaCierre) {
		// String nombre=getTxNombreCarrera().getText();
		// String tipo=getCbTipoCarrera();
	}

	public static void inscribirAtletaCarrera(String id, String email) throws BusinessDataException {

		DataAccessFactory.forAtletaService().inscribirAtleta(DtoAssembler.forAtletaDto(email, null, null, null),
				DtoAssembler.forCarreraDto(null, null, null, 0, 0, id, 0, null, null, null));
	}

	public static void inscribirsePagar(String id) {
		// comprobar si es una inscripcion o un pago
		// inscripcion
		VentanaPedirEmail v = new VentanaPedirEmail(id);
		v.setVisible(true);

		// pago
	}

}
