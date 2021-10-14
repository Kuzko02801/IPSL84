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

public class ExisteCarrera {

	private String id;

	public ExisteCarrera(String id) {
		this.id = id;
	}

	public boolean existeCarrera() {
		try {
			DriverManager.registerDriver(new org.sqlite.JDBC());
		} catch (SQLException e1) {
			System.out.println("Ha fallado el register del driver");
		}

		PreparedStatement ps = null;
		Connection con = null;
		try {
			con = DriverManager.getConnection(SqliteConnectionInfo.URL);
			//TODO
			//No se jusco hazlo tu crack, si existe una carrera con esa id devuelve true y si no false jaja
			ps = con.prepareStatement(SqlStatements.);
			ResultSet rs = ps.executeQuery();
			

			ps.close();
			con.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return false;

	}
}
