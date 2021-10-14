package business.dataaccess.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import business.dataaccess.datainformation.SqlStatements;

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
}
