package business.dataaccess.inscripcion.comandos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import business.dataaccess.datainformation.SqlStatements;
import business.dataaccess.datainformation.SqliteConnectionInfo;

public class CancelarInscripcion {

	private String email;
	private String id_carrera;

	public CancelarInscripcion(String email, String id_carrera) {
		this.email = email;
		this.id_carrera = id_carrera;
	}

	public void execute() {
		PreparedStatement pst = null;
		Connection con = null;

		try {
			con = DriverManager.getConnection(SqliteConnectionInfo.URL);

			pst = con.prepareStatement(SqlStatements.SQL_CANCELAR_INSCRIPCION);
			pst.setString(1, email);
			pst.setString(2, id_carrera);
			pst.executeUpdate();
			pst.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
			//throw new BusinessDataException("Ha ocurrido un error con la base de datos");
		}

	}

}
