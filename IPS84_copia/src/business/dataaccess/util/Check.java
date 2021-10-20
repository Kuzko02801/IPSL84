package business.dataaccess.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import business.dataaccess.datainformation.SqlStatements;
import business.dataaccess.datainformation.SqliteConnectionInfo;

public class Check {

	public static boolean raceExists(Connection conn, String id) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = conn;
		ps = con.prepareStatement(SqlStatements.SQL_SELECT_CARRERA);
		ps.setString(1, id);
		rs = ps.executeQuery();
		if (rs.next())
			return true;
		rs.close();
		ps.close();

		return false;
	}
	public static boolean raceExists2(String id) {
		try {
			DriverManager.registerDriver(new org.sqlite.JDBC());
		} catch (SQLException e1) {
			System.out.println("Ha fallado el register del driver");
		}
		PreparedStatement ps = null;
		Connection con = null;
		try {
			con = DriverManager.getConnection(SqliteConnectionInfo.URL);
			ps = con.prepareStatement(SqlStatements.SQL_SELECT_CARRERA);
			ps.setString(1, id);
			ResultSet rs=ps.executeQuery();
			rs = ps.executeQuery();
			if (rs.next()) {
				return true;
			}
			rs.close();
			ps.close();
			ps.close();
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static boolean atletaExists(Connection conn, String email) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = conn;
		ps = con.prepareStatement(SqlStatements.SQL_SELECT_ATLETA);
		ps.setString(1, email);
		rs = ps.executeQuery();
		if (rs.next())
			return true;

		rs.close();
		ps.close();

		return false;
	}
}
