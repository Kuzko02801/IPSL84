package business.dataaccess.atleta.comandos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import business.dataaccess.DataAccessFactory;
import business.dataaccess.datainformation.SqlStatements;
import business.dataaccess.datainformation.SqliteConnectionInfo;
import business.dataaccess.dto.AtletaDto;
import business.dataaccess.dto.carrera.CarreraDto;
import business.dataaccess.dto.carrera.Categoria;
import business.dataaccess.dto.carrera.Periodo;
import business.dataaccess.dto.infoadicional.EstadoInscripcion;
import business.dataaccess.exception.BusinessDataException;
import business.dataaccess.parsers.CategoriaParser;
import business.dataaccess.util.Check;
import business.dataaccess.util.DateSqlite;

public class AtletaInscripcion {

	private String carrera_id;
	private String email_atleta;
	private CarreraDto carrera;
	private AtletaDto atleta;
	private Connection con;

	public AtletaInscripcion(String carrera_id, String email_atleta) {
		this.carrera_id = carrera_id;
		this.email_atleta = email_atleta;
	}

	public void inscribirAtleta() throws BusinessDataException {

		int age = 0;
		try {

			if (!Check.atletaExists(email_atleta)) {
				throw new BusinessDataException("Ningun atleta asociado con este email.");
			}

			if (Check.existeInscripcion(email_atleta, carrera_id)) {
				throw new BusinessDataException("Ya estas inscrito en esta carrera.");
			}

			atleta = DataAccessFactory.forAtletaService().encontrarAtleta(email_atleta);
			age = (int) ChronoUnit.YEARS.between(atleta.fechaDeNacimiento.getDate(), LocalDate.now());

			carrera = DataAccessFactory.forCarreraService().findCarreraById(carrera_id);
			// Inscripcion abierta.
			if (!inscripcionAbierta()) {
				throw new BusinessDataException("Estas fuera del plazo de inscripcion.");
			}
			con = DriverManager.getConnection(SqliteConnectionInfo.URL);
			// Checkeo de plazas.
			if (!Check.hayPlazasLibres(1, carrera)) {
				if (carrera.listaDeEspera) {
					// Añadir atleta a la lista de espera.
					añadirListaEspera();
					return;
				} else {
					throw new BusinessDataException("No hay plazas libres.");
				}
			} else {
				inscribirNuevoAtleta(age);
			}
			con.close();
		} catch (SQLException e) {

			// throw new BusinessDataException("Ha ocurrido un error con la inscripcion");
		}
	}

	private void inscribirNuevoAtleta(int age) throws SQLException, BusinessDataException {
		PreparedStatement getCategorias = null;
		PreparedStatement inscribirAtleta = null;
		ResultSet categorias = null;
		List<Categoria> listaCat = null;

		// TODO buscar las categorias de la carrera, parsearlas y si no encaja con
		// ninguna categoria el atleta, excepcion

		/**
		 * Para coger las categorias de la carrera necesitamos la id de la carrera.
		 */
		getCategorias = con.prepareStatement(SqlStatements.SQL_FIND_CATEGORIAS);

		getCategorias.setString(1, carrera_id);

		categorias = getCategorias.executeQuery();
		listaCat = CategoriaParser.devolverCategorias(categorias.getString(1));

		inscribirAtleta = con.prepareStatement(SqlStatements.SQL_INSCRIBIR_ATLETA);

		Double cantidadAPagar = getCuotaPeriodo();

		inscribirAtleta.setString(1, email_atleta); // atleta.email
		inscribirAtleta.setString(2, carrera_id);
		inscribirAtleta.setString(3, EstadoInscripcion.PENDIENTE_DE_PAGO.label);
		inscribirAtleta.setString(4, seleccionarCategoria(listaCat, age));// seleccionarCategoria());
		inscribirAtleta.setString(5, fechaActual());// fechaActual());
		inscribirAtleta.setDouble(6, cantidadAPagar);

		inscribirAtleta.executeUpdate();

		categorias.close();
		getCategorias.close();
		inscribirAtleta.close();
	}

	/**
	 * Añade un atleta a la lista de espera con la id de la carrera y el email del
	 * atleta.
	 * 
	 * @throws SQLException
	 */
	private void añadirListaEspera() throws SQLException {
		PreparedStatement listaEspera = con.prepareStatement(SqlStatements.SQL_INSERTAR_LISTA_ESPERA);
		listaEspera.setString(1, atleta.email);
		listaEspera.setString(2, carrera.carrera_id);
		listaEspera.executeUpdate();
	}

	private String seleccionarCategoria(List<Categoria> listaCat, int age) {
		for (Categoria c : listaCat) {
			if (c.getEdadMinima() <= age && age <= c.getEdadMaxima()) {
				return c.getTipo();
			}
		}
		return null;
	}

	private String fechaActual() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		return sdf.format(new Date(System.currentTimeMillis()));
	}

	private boolean inscripcionAbierta() {
		for (Periodo periodo : carrera.periodos) {
			// Si la fecha actual esta en el rango de algun periodo devuelve true, false en
			// caso contrario.
			if (periodo.getFechaInicio().isBefore(new DateSqlite().actual())
					&& periodo.getFechaFin().isAfter(new DateSqlite().actual())) {
				return true;
			}
		}
		return false;
	}

	private Double getCuotaPeriodo() {
		for (Periodo periodo : carrera.periodos) {
			// Si la fecha actual esta en el rango de algun periodo devuelve true, false en
			// caso contrario.
			if (periodo.getFechaInicio().isBefore(new DateSqlite().actual())
					&& periodo.getFechaFin().isAfter(new DateSqlite().actual())) {
				return periodo.getCuota();
			}
		}
		return null;
	}

}
