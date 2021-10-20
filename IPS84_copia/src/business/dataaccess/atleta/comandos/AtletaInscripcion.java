package business.dataaccess.atleta.comandos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import business.dataaccess.BusinessDataException;
import business.dataaccess.DataAccessFactory;
import business.dataaccess.datainformation.SqlStatements;
import business.dataaccess.datainformation.SqliteConnectionInfo;
import business.dataaccess.dto.AtletaDto;
import business.dataaccess.dto.CarreraDto;
import business.dataaccess.dto.infoadicional.CategoriaAtleta;
import business.dataaccess.dto.infoadicional.EstadoInscripcion;
import business.dataaccess.util.Check;
import business.dataaccess.util.DateSqlite;

public class AtletaInscripcion {

	private AtletaDto atleta;
	private CarreraDto carrera;
	private Connection con;

	public AtletaInscripcion(AtletaDto atleta, CarreraDto carrera) {
		this.atleta = DataAccessFactory.forAtletaService().encontrarAtleta(atleta.email);
		
		this.carrera = DataAccessFactory.forCarreraService().findCarreraById(carrera.carrera_id);
		
	}

	public void inscribirAtleta() throws BusinessDataException {

		PreparedStatement ps = null;
		try {

			
			// Check if the race exists.
			if (!Check.atletaExists(atleta.email)) {
				throw new BusinessDataException("Ningun atleta asociado con este email.");
			}
			System.out.println("El checkeo falla 1");

			// Inscripcion abierta.
			if (!inscripcionAbierta()) {
				System.out.println("fuera del plazo");
				throw new BusinessDataException("Estas fuera del plazo de inscripci�n.");
			}
			System.out.println("El checkeo falla 2");

			// Checkeo de plazas.
			if (!hayPlazasLibres())
				throw new BusinessDataException("No hay plazas libres.");
			
			System.out.println("El checkeo falla 3");
			con = DriverManager.getConnection(SqliteConnectionInfo.URL);
			System.out.println("El checkeo falla 4");
			ps = con.prepareStatement(SqlStatements.SQL_INSCRIBIR_ATLETA);
			System.out.println("El checkeo falla 5");
			ps.setString(1, atleta.email); // atleta.email
			ps.setString(2, carrera.carrera_id);
			ps.setString(3, EstadoInscripcion.PREINSCRITO.label);
			ps.setString(4, seleccionarCategoria());// seleccionarCategoria());
			ps.setString(5, fechaActual());// fechaActual());

			ps.executeUpdate();

			ps.close();
			con.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	private String seleccionarCategoria() {
		// UNTIL ATHLETE REGISTRATION IS ENABLED
		// atleta.fechaDeNacimiento = new Date(System.currentTimeMillis() - 10000000);
		//////////////////////////////////////////
		int edad = atleta.fechaDeNacimiento.subYears(new DateSqlite().actual()); // Puede no funcionar
		if (edad >= 18 && edad <= 21)
			return CategoriaAtleta.JUNIOR.label;
		else if (edad > 21 && edad <= 29)
			return CategoriaAtleta.SENIOR.label;
		else if (edad > 29 && edad <= 35)
			return CategoriaAtleta.VETERANO_1.label;
		else
			// Si siempre devuelve este, la edad esta mal calculada.
			return CategoriaAtleta.VETERANO_2.label;

	}

	private String fechaActual() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
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
			System.out.println(carrera.plazasMaximas);
			System.out.println(rs.getInt(1));
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
		if (carrera.cierre.compareTo(new DateSqlite().actual()) >= 0)
			return true;
		else
			return false;
	}

}
