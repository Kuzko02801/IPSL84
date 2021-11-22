package business.dataaccess.carrera.comandos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import business.dataaccess.datainformation.SqlStatements;
import business.dataaccess.datainformation.SqliteConnectionInfo;

public class EstaCarreraLlena {

	private String id_carrera;
	
	public EstaCarreraLlena(String id_carrera) {
		this.id_carrera = id_carrera;
	}
	
	public boolean execute() {
		PreparedStatement pst = null;
		Connection con = null;
		ResultSet rs = null;

		try {
			con = DriverManager.getConnection(SqliteConnectionInfo.URL);

			pst = con.prepareStatement(SqlStatements.SQL_ESTA_CARRERA_LLENA);
			pst.setString(1, id_carrera);
			pst.setString(2, id_carrera);

			rs = pst.executeQuery();
			boolean llena = rs.getInt(1) > 0;
			
			
			
			rs.close();
			pst.close();
			con.close();

			return llena;
		} catch (SQLException e) {

		}
		return false;
	}
}
