package business.dataaccess.carrera.comandos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.TableModel;

import business.dataaccess.datainformation.SqlStatements;
import business.dataaccess.datainformation.SqliteConnectionInfo;
import net.proteanit.sql.DbUtils;

public class DevolverClasificacionAbsoluta {
	
	private String id;
	
	public DevolverClasificacionAbsoluta(String id) {
		this.id = id;
	}
	
	public TableModel devolverClasificacionAbsoluta() {
		try {
			DriverManager.registerDriver(new org.sqlite.JDBC());
		} catch (SQLException e1) {
			System.out.println("Ha fallado el register del driver");
		}
		TableModel t = null;
		PreparedStatement ps = null;
		Connection con = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(SqliteConnectionInfo.URL);
			ps = con.prepareStatement(SqlStatements.SQL_CLASIFICACION_ABSOLUTA);			
			ps.setString(1, id);
			rs = ps.executeQuery();
			t = DbUtils.resultSetToTableModel(rs);

			ps.close();
			rs.close();
			con.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return t;
	}
}
