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
	private int dorsalesReservados;
	
	public GenerarDorsalParaCarrera(String id_carrera, int dorsalesReservados) {
		this.id_carrera = id_carrera;
		this.dorsalesReservados = dorsalesReservados; 
	}

	public void execute() {
		try {
			DriverManager.registerDriver(new org.sqlite.JDBC());
		} catch (SQLException e1) {
			System.out.println("Ha fallado el register del driver");
		}
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int dorsal = dorsalesReservados;
		try {
			con = DriverManager.getConnection(SqliteConnectionInfo.URL);
			ps = con.prepareStatement(SqlStatements.SQL_INSCRIPCION_CARRERA);
			ps.setString(1,id_carrera);
			rs = ps.executeQuery();
			while(rs.next()) {
				dorsal++;
				PreparedStatement statement = con
						.prepareStatement(SqlStatements.SQL_INSCRIPCION_ACTUALIZAR_DORSALES);
				statement.setInt(1, dorsal);
				statement.setString(2, id_carrera);
				statement.setString(3, rs.getString("email_atleta"));
				statement.executeUpdate();
				statement.close();
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}
