package business.dataaccess.inscripcion.comandos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import business.dataaccess.datainformation.SqlStatements;
import business.dataaccess.datainformation.SqliteConnectionInfo;
import business.dataaccess.util.Check;

public class PasarDePreAInscritoAInscrito {
	
	private String id;
	private String email;

	public PasarDePreAInscritoAInscrito(String id, String email) {
		this.id = id;
		this.email = email;
	}
	
	public void execute() {
		try {
			DriverManager.registerDriver(new org.sqlite.JDBC());
		} catch (SQLException e1) {
			System.out.println("Ha fallado el register del driver");
		}
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = DriverManager.getConnection(SqliteConnectionInfo.URL);
			ps = con.prepareStatement(SqlStatements.SQL_INSCRIPCION_PAGO);
			
			if (!Check.atletaExists(con, email)) {
				System.out.println("Email: "+ email );
				System.out.println("La actualizacion del pago es fraudulenta1");
			}if (!Check.raceExists(con, id)) {
				System.out.println("La actualizacion del pago es fraudulenta");
			}
			
			
			ps.setString(1, email);
			ps.setString(2, id);
			ps.executeUpdate();
			
			ps.close();
			con.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
