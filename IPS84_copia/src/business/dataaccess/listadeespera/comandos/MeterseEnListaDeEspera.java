package business.dataaccess.listadeespera.comandos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import business.dataaccess.datainformation.SqlStatements;
import business.dataaccess.datainformation.SqliteConnectionInfo;

public class MeterseEnListaDeEspera {

	private String id_carrera;
	private String email;
	
	public MeterseEnListaDeEspera(String id_carrera, String email) {
		this.id_carrera = id_carrera;
		this.email = email;
	}
	
	public void execute(){
		PreparedStatement pst = null;
		Connection con = null;
		
		try {
			con = DriverManager.getConnection(SqliteConnectionInfo.URL);

			pst = con.prepareStatement(SqlStatements. SQL_INSERTAR_LISTA_ESPERA);
			pst.setString(1, email);
			pst.setString(2, id_carrera);
			pst.executeUpdate();
			pst.close();
			con.close();
		} catch (SQLException e) {
			
		}
		
	}
	
	

}
