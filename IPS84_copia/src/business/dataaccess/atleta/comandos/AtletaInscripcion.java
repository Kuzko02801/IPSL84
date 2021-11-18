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

		PreparedStatement getCategorias = null;
		PreparedStatement inscribirAtleta = null;
		ResultSet categorias = null;
		List<Categoria> listaCat=null;
		int age = 0;
		try {

			// Check if the race exists.
			if (!Check.atletaExists(email_atleta)) {
				throw new BusinessDataException("Ningun atleta asociado con este email.");
			}

			atleta = DataAccessFactory.forAtletaService().encontrarAtleta(email_atleta);
			age = (int)ChronoUnit.YEARS.between(atleta.fechaDeNacimiento.getDate(),LocalDate.now());
			carrera = DataAccessFactory.forCarreraService().findCarreraById(carrera_id);
			// Inscripcion abierta.
			if (!inscripcionAbierta()) {
				System.out.println("fuera del plazo");
				throw new BusinessDataException("Estas fuera del plazo de inscripci�n.");
			}

			// Checkeo de plazas.
			if (!hayPlazasLibres())
				throw new BusinessDataException("No hay plazas libres.");

			con = DriverManager.getConnection(SqliteConnectionInfo.URL);

			// TODO buscar las categorias de la carrera, parsearlas y si no encaja con
			// ninguna categoria el atleta, excepcion

			/**
			 * Para coger las categorias de la carrera necesitamos la id de la carrera.
			 */
			getCategorias = con.prepareStatement(SqlStatements.SQL_FIND_CATEGORIAS);

			getCategorias.setString(1, carrera_id);

			categorias = getCategorias.executeQuery();
			listaCat = CategoriaParser.devolverCategorias(categorias.getString(1));

			for (Categoria c : listaCat) {
				if (c.getEdadMinima() > age || c.getEdadMaxima() < age) {
					getCategorias.close();				
					throw new BusinessDataException("No existe ninguna categoria adecuada para el atleta.");
				}
			}

			inscribirAtleta = con.prepareStatement(SqlStatements.SQL_INSCRIBIR_ATLETA);

			inscribirAtleta.setString(1, email_atleta); // atleta.email
			inscribirAtleta.setString(2, carrera_id);
			inscribirAtleta.setString(3, EstadoInscripcion.PENDIENTE_DE_PAGO.label);
			inscribirAtleta.setString(4, seleccionarCategoria(listaCat, age));// seleccionarCategoria());
			inscribirAtleta.setString(5, fechaActual());// fechaActual());

			inscribirAtleta.executeUpdate();

			categorias.close();
			getCategorias.close();
			inscribirAtleta.close();
			con.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	private String seleccionarCategoria(List<Categoria> listaCat, int age) {		
		for(Categoria c : listaCat) {
			if(c.getEdadMinima() <= age && age <= c.getEdadMaxima()) {
				return c.getTipo();
			}
		}
		return null;
	}

	private String fechaActual() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		return sdf.format(new Date(System.currentTimeMillis()));
	}

	private boolean hayPlazasLibres() throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;

		con = DriverManager.getConnection(SqliteConnectionInfo.URL);
		ps = con.prepareStatement(SqlStatements.SQL_NUMERO_INSCRIPCIONES);
		ps.setString(1, carrera.carrera_id);
		rs = ps.executeQuery();
		while (rs.next()) {
//			System.out.println(carrera.plazasMaximas);
//			System.out.println(rs.getInt(1));
			if (carrera.plazasMaximas > rs.getInt(1)) {
				rs.close();
				ps.close();
				con.close();
				return true;
			}

		}

		rs.close();
		ps.close();
		con.close();

		return false;
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

}
