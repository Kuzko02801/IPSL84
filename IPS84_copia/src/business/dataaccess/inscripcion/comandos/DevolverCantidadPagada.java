package business.dataaccess.inscripcion.comandos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import business.dataaccess.datainformation.SqlStatements;
import business.dataaccess.datainformation.SqliteConnectionInfo;

public class DevolverCantidadPagada {

	private String email;
	private String id_carrera;
	
	public DevolverCantidadPagada(String email, String id_carrera) {
		this.email = email;
		this.id_carrera = id_carrera;
	}

	public double devolverCantidad(){
		PreparedStatement pst = null;
		ResultSet rs = null;
		Connection con = null;
		
		try {
			con = DriverManager.getConnection(SqliteConnectionInfo.URL);
			
			pst = con.prepareStatement(SqlStatements.SQL_OBTENER_CANTIDAD_PAGADA);
			
			pst.setString(1, id_carrera);
			pst.setString(2, email);
			
			rs = pst.executeQuery();
			
			return rs.getDouble("cantidadPagada");
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	
}
