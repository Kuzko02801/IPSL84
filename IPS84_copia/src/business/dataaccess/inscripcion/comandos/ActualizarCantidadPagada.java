package business.dataaccess.inscripcion.comandos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import business.dataaccess.datainformation.SqlStatements;
import business.dataaccess.datainformation.SqliteConnectionInfo;
import business.gui.GuiLogic;

public class ActualizarCantidadPagada {
	
	private String id_carrera;
	private String email;
	private double pagado;

	public ActualizarCantidadPagada(String id_carrera, String email, double pagado) {
		this.id_carrera = id_carrera;
		this.email = email;
		this.pagado = pagado;
	}

	public void actualizar() {
		PreparedStatement pst;
		Connection con;
		
		try {
			con = DriverManager.getConnection(SqliteConnectionInfo.URL);
			
			pst = con.prepareStatement(SqlStatements.SQL_ACTUALIZAR_CANTIDAD_PAGADA);
			
			double nuevaCantidad = pagado + GuiLogic.obtenerCantidadPagada(email, id_carrera);
			
			pst.setDouble(1, nuevaCantidad);
			pst.setString(2, id_carrera);
			pst.setString(3, email);
			
			pst.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
}
