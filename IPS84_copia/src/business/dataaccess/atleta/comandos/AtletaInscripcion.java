package business.dataaccess.atleta.comandos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import business.dataaccess.BusinessDataException;
import business.dataaccess.datainformation.SqlStatements;
import business.dataaccess.datainformation.SqliteConnectionInfo;
import business.dataaccess.dto.AtletaDto;
import business.dataaccess.dto.CarreraDto;
import business.dataaccess.dto.infoadicional.CategoriaAtleta;
import business.dataaccess.dto.infoadicional.EstadoInscripcion;

public class AtletaInscripcion {

	private AtletaDto atleta;
	private CarreraDto carrera;

	private Connection con;

	public AtletaInscripcion(AtletaDto atleta, CarreraDto carrera) {
		this.atleta = atleta;
		this.carrera = carrera;
	}

	public void inscribirAtleta() throws BusinessDataException {

		PreparedStatement ps = null;

		try {
			con = DriverManager.getConnection(SqliteConnectionInfo.URL);

			// Check if the race exists.
			if (!raceExists())
				throw new BusinessDataException("La carrera no existe.");
			
			// Inscripcion abierta.
			if(!inscripcionAbierta())
				throw new BusinessDataException("Estas fuera del plazo de inscripción.");
			
			// Checkeo de plazas. 
			if(!hayPlazasLibres())
				throw new BusinessDataException("No hay plazas libres.");
			
			
			ps = con.prepareStatement(SqlStatements.SQL_INSCRIBIR_ATLETA);
			ps.setString(1, atleta.email);
			ps.setString(2, carrera.carrera_id);
			ps.setString(3, EstadoInscripcion.PREINSCRITO.label);						
			ps.setDate(4, fechaActual());						
			ps.setString(5, seleccionarCategoria());

			ps.executeUpdate();

			ps.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private String seleccionarCategoria() {
		int edad = atleta.fechaDeNacimiento.compareTo(new Date(System.currentTimeMillis())) * -1; // Puede no funcionar
		if(edad >= 18 || edad <= 21)
			return CategoriaAtleta.JUNIOR.label;
		else if(edad > 21 || edad <= 29)
			return CategoriaAtleta.SENIOR.label;
		else if(edad > 29 || edad <= 35)
			return CategoriaAtleta.VETERANO_1.label;
		else
			// Si siempre devuelve este, la edad esta mal calculada.
			return CategoriaAtleta.VETERANO_2.label;
		
	}

	private Date fechaActual() {		
		return new Date(System.currentTimeMillis());		
	}

	private boolean hayPlazasLibres() throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement(SqlStatements.SQL_NUMERO_INSCRIPCIONES);
			ps.setString(1, carrera.carrera_id);
			rs = ps.executeQuery();
			while(rs.next()) {
				if(carrera.plazasMaximas <= rs.getInt(1))
					return false;
			}

		} finally {
			rs.close();
			ps.close();
		}
		return true;
	}

	private boolean inscripcionAbierta() {
		if(System.currentTimeMillis() < carrera.cierre.getTime())
			return true;
		else
			return false;
	}

	private boolean raceExists() throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement(SqlStatements.SQL_SELECT_CARRERA);
			ps.setString(1, carrera.carrera_id);
			rs = ps.executeQuery();
			if (!rs.next())
				return false;

		} finally {
			rs.close();
			ps.close();
		}
		return true;
	}

}
