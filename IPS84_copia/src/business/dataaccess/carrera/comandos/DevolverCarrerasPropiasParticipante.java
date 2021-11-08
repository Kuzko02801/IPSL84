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

public class DevolverCarrerasPropiasParticipante {

	private String email_atleta;
	
	public DevolverCarrerasPropiasParticipante(String email_atleta) {
		this.email_atleta = email_atleta;
	}
	
	public TableModel devolverCarreras() {
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
			ps = con.prepareStatement(SqlStatements.SQL_CARRERA_PARTICIPADO);
			ps.setString(1, email_atleta);
			rs = ps.executeQuery();			
			t = DbUtils.resultSetToTableModel(rs);

			ps.close();
			con.close();
			rs.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return t;
	}
}
