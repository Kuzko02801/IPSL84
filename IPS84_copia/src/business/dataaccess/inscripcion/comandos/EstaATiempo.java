package business.dataaccess.inscripcion.comandos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import business.dataaccess.datainformation.SqlStatements;
import business.dataaccess.datainformation.SqliteConnectionInfo;

public class EstaATiempo {
	
	private String id;
	private String email;

	public EstaATiempo(String id, String email) {
		this.id = id;
		this.email = email;
	}
	
	
	public boolean execute() {
		PreparedStatement pst = null;
		Connection con = null;
		ResultSet rs = null;
		
		String fechaInscripcion = null;
		try {
			con = DriverManager.getConnection(SqliteConnectionInfo.URL);
			
			pst = con.prepareStatement(SqlStatements.SQL_CHECKEAR_PAGO_A_TIEMPO);
			
			pst.setString(1, id);
			pst.setString(2, email);
			
			rs = pst.executeQuery();
			
			fechaInscripcion = rs.getString("fecha_inscripcion");
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			
			if (LocalDate.parse(fechaInscripcion, formatter).plusDays(2).compareTo(LocalDate.now()) >= 0) {
				rs.close();
				pst.close();
				con.close();
				return true;
			}
			rs.close();
			pst.close();
			con.close();
			return false;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
