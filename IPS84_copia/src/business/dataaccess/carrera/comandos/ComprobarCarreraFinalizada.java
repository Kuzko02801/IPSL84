package business.dataaccess.carrera.comandos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Formatter;

import business.dataaccess.datainformation.SqlStatements;
import business.dataaccess.datainformation.SqliteConnectionInfo;
import business.dataaccess.exception.BusinessDataException;

public class ComprobarCarreraFinalizada {

	private String id_carrera;

	public ComprobarCarreraFinalizada(String id_carrera) throws BusinessDataException {
		this.id_carrera = id_carrera;
	}

	public boolean haFinalizado() throws BusinessDataException {
		PreparedStatement pst = null;
		Connection con = null;
		ResultSet rs = null;
		boolean finalizada = false;
		try {
			con = DriverManager.getConnection(SqliteConnectionInfo.URL);

			pst = con.prepareStatement(SqlStatements.SQL_SELECT_CARRERA);
			pst.setString(1, id_carrera);

			rs = pst.executeQuery();
			String DATE_FORMAT = "yyyy/MM/dd";
			if (rs.next() && LocalDate.parse(rs.getString("fecha"),DateTimeFormatter.ofPattern(DATE_FORMAT)).isBefore(LocalDate.now())) {
				finalizada = true;
			}
			pst.close();
			rs.close();
			con.close();
		} catch (SQLException e) {
			throw new BusinessDataException(e.getMessage());
		}
		return finalizada;
	}

}
