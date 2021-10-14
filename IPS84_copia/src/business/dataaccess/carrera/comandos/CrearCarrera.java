package business.dataaccess.carrera.comandos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
		Connection con=null;
		
		try {
			con = DriverManager.getConnection(SqliteConnectionInfo.URL);
			//cosas de crear carreras
			
			
			
		
			con.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
}
