package business.dataaccess.carrera.comandos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import business.dataaccess.datainformation.SqlStatements;
import business.dataaccess.datainformation.SqliteConnectionInfo;
import business.dataaccess.dto.carrera.Periodo;
import business.dataaccess.parsers.PeriodoParser;
import business.dataaccess.util.DateSqlite;

public class ComprobarInscripcionesFinalizadas {

	private String id_carrera;

	public ComprobarInscripcionesFinalizadas(String id_carrera) {
		this.id_carrera = id_carrera;
	}

	public boolean haFinalizado() {
		PreparedStatement pst = null;
		Connection con = null;
		ResultSet rs = null;

		try {
			con = DriverManager.getConnection(SqliteConnectionInfo.URL);

			pst = con.prepareStatement(SqlStatements.SQL_SELECT_CARRERA);
			pst.setString(1, id_carrera);

			rs = pst.executeQuery();
			boolean finalizada = false;
			String periodos = "";
			if (rs.next()) {
				periodos = rs.getString("periodos");
				List<Periodo> listaPeriodos = PeriodoParser.devolverPeriodos(periodos);
				if (listaPeriodos.get(listaPeriodos.size() - 1).getFechaFin().isBefore(new DateSqlite().actual())) {
					finalizada = false;
				}
				finalizada = true;
			}
			return finalizada;
		} catch (SQLException e) {

		}
		return false;
	}
}
