package business.dataaccess.carrera.comandos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import business.dataaccess.datainformation.SqliteConnectionInfo;
import business.dataaccess.util.Check;

public class ExisteCarrera {

	private String id;

	public ExisteCarrera(String id) {
		this.id = id;
	}

	public boolean existeCarrera() {
		Connection con = null;		
		boolean result = false;
		try {
			con = DriverManager.getConnection(SqliteConnectionInfo.URL);
			result = Check.raceExists(con, id);
			con.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return result;
	}
}
