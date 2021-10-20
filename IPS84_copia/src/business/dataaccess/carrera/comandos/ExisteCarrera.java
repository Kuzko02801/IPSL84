package business.dataaccess.carrera.comandos;

import java.sql.SQLException;

import business.dataaccess.util.Check;

public class ExisteCarrera {

	private String id;

	public ExisteCarrera(String id) {
		this.id = id;
	}

	public boolean existeCarrera() {		
		boolean result = false;
		try {
			
			result = Check.raceExists(id);
			
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return result;
	}
}
