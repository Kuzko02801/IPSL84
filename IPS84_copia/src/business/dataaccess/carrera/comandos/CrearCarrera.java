package business.dataaccess.carrera.comandos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

import business.dataaccess.BusinessDataException;
import business.dataaccess.atleta.comandos.AtletaInscripcion;
import business.dataaccess.datainformation.SqlStatements;
import business.dataaccess.datainformation.SqliteConnectionInfo;
import business.dataaccess.dto.CarreraDto;
import business.dataaccess.dto.infoadicional.EstadoInscripcion;

public class CrearCarrera {
	private CarreraDto carrera;
	public CrearCarrera(CarreraDto carrera) {
		this.carrera=carrera;
	}
	public void crearCarrera() {

		PreparedStatement ps = null;
		Connection con= null;
		String id = null;
		try {
			con = DriverManager.getConnection(SqliteConnectionInfo.URL);
			
			ps = con.prepareStatement(SqlStatements.SQL_INSERT_CARRERA);
						
			id = UUID.randomUUID().toString();
			ps.setString(1, carrera.nombre);
			ps.setDate(2, new Date(System.currentTimeMillis()));
			ps.
			
			
			
			con.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
}
