package business.dataaccess.inscripcion.comandos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import business.dataaccess.datainformation.SqlStatements;
import business.dataaccess.datainformation.SqliteConnectionInfo;

public class GenerarDorsalParaCarrera {
	
	public String id_carrera;
	
	public GenerarDorsalParaCarrera(String id_carrera) {
		this.id_carrera = id_carrera;
	}

	public int execute() {
		try {
			DriverManager.registerDriver(new org.sqlite.JDBC());
		} catch (SQLException e1) {
			System.out.println("Ha fallado el register del driver");
		}
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int participantes = 0;
		try {
			con = DriverManager.getConnection(SqliteConnectionInfo.URL);
			ps = con.prepareStatement(SqlStatements.SQL_PARTICIPANTES_CARRERA);
			
			ps.setString(1,id_carrera);
			
			rs = ps.executeQuery();
			participantes = rs.getInt("participantes");
			
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return participantes;
	}
	
}
