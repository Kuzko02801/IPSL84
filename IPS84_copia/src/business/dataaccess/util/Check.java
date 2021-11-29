package business.dataaccess.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import business.dataaccess.datainformation.SqlStatements;
import business.dataaccess.datainformation.SqliteConnectionInfo;
import business.dataaccess.dto.carrera.CarreraDto;
import business.dataaccess.dto.carrera.Periodo;
import business.dataaccess.exception.BusinessDataException;

public class Check {

	public static boolean raceExists(String id) throws BusinessDataException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Connection con = DriverManager.getConnection(SqliteConnectionInfo.URL);
			ps = con.prepareStatement(SqlStatements.SQL_SELECT_CARRERA);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				rs.close();
				ps.close();
				con.close();
				return true;
			} else {
				rs.close();
				ps.close();
				con.close();
				return false;
			}
		} catch (SQLException e) {
			throw new BusinessDataException("Ha habido un problema con la base de datos");
		}
	}

	public static boolean atletaExists(String email) throws BusinessDataException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;
		try {
			con = DriverManager.getConnection(SqliteConnectionInfo.URL);
			ps = con.prepareStatement(SqlStatements.SQL_SELECT_ATLETA);
			ps.setString(1, email);
			rs = ps.executeQuery();
			if (rs.next()) {
				rs.close();
				ps.close();
				con.close();
				return true;
			} else {
				rs.close();
				ps.close();
				con.close();
				return false;
			}
		} catch (SQLException e) {
			throw new BusinessDataException("Ha habido un problema con la base de datos");
		}

	}

	public static boolean puedePagarInscripcion(String carrera_id, String email_atleta) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;

		con = DriverManager.getConnection(SqliteConnectionInfo.URL);

		ps = con.prepareStatement(SqlStatements.SQL_INSCRIPCION_CARRERA_PAGO);
		ps.setString(1, carrera_id);
		ps.setString(2, email_atleta);
		rs = ps.executeQuery();
		if (rs.next()) {
			rs.close();
			ps.close();
			con.close();
			return true;
		} else {
			rs.close();
			ps.close();
			con.close();
			return false;
		}
	}

	public static boolean pagoFueraDePlazo(String carrera_id, String email_atleta) throws BusinessDataException {
		boolean b = false;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Connection con = null;
		try {
			con = DriverManager.getConnection(SqliteConnectionInfo.URL);

			pst = con.prepareStatement(SqlStatements.SQL_FECHA_INSCRIPCION);

			pst.setString(1, carrera_id);
			pst.setString(2, email_atleta);

			rs = pst.executeQuery();

			if (rs.next()) {
				String date = rs.getString("fecha_inscripcion");
				DateSqlite parsedDate = new DateSqlite(date);
				if (new DateSqlite().actual().isTwoDaysHigher(parsedDate)) {
					b = true;
				}
				b = false;
			}
			con.close();
			rs.close();
			pst.close();
			return b;
		} catch (SQLException e) {
			throw new BusinessDataException("Ha habido un problema con la base de datos");
		}
	}

	public static boolean hayPlazasLibres(int plazas, CarreraDto carrera) throws BusinessDataException {
		int plazasLibres = 0;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;
		try {
			con = DriverManager.getConnection(SqliteConnectionInfo.URL);
			ps = con.prepareStatement(SqlStatements.SQL_NUMERO_INSCRIPCIONES);
			ps.setString(1, carrera.carrera_id);
			rs = ps.executeQuery();

			while (rs.next()) {
//				plazasLibres++;
//				if (plazasLibres >= plazas) {
//					rs.close();
//					ps.close();
//					con.close();
//					return true;
//				}
				plazasLibres = carrera.plazasMaximas - rs.getInt("numeroInscripciones");
			}
			if (plazasLibres > 0) {
				rs.close();
				ps.close();
				con.close();
				return true;
			}

			rs.close();
			ps.close();
			con.close();
			return false;
		} catch (SQLException e) {
			throw new BusinessDataException("Ha habido un problema con la base de datos");
		}
	}

	public static boolean checkCarreraAbierta(List<Periodo> periodos) {
		for (Periodo periodo : periodos) {
			if (periodo.getFechaInicio().isBefore(new DateSqlite().actual())
					&& periodo.getFechaFin().isAfter(new DateSqlite().actual())) {
				return true;
			}
		}
		return false;
	}

	public static void isNotNull(Object o, String msg) {
		if (o == null)
			throw new IllegalArgumentException(msg);
	}

	public static void isTrue(boolean cond, String msg) {
		if (!cond)
			throw new IllegalArgumentException(msg);
	}

	public static boolean existeInscripcion(String email, String id_carrera) throws BusinessDataException {
		PreparedStatement pst = null;
		ResultSet rs = null;
		Connection con = null;

		try {
			con = DriverManager.getConnection(SqliteConnectionInfo.URL);

			pst = con.prepareStatement(SqlStatements.SQL_INSCRIPCION_CONCRETA);

			pst.setString(1, email);
			pst.setString(2, id_carrera);

			rs = pst.executeQuery();

			if (rs.next()) {
				rs.close();
				pst.close();
				con.close();
				return true;
			}
			rs.close();
			pst.close();
			con.close();
			return false;
		} catch (SQLException e) {
			throw new BusinessDataException("Ha ocurrido un problema con la base de datos");
		}
	}

	public static boolean estaInscripcionPagada(String email, String id_carrera) throws BusinessDataException {
		PreparedStatement pst = null;
		ResultSet rs = null;
		Connection con = null;
		String estado = null;
		try {
			con = DriverManager.getConnection(SqliteConnectionInfo.URL);

			pst = con.prepareStatement(SqlStatements.SQL_INSCRIPCION_ESTADO_PAGO);

			pst.setString(1, email);
			pst.setString(2, id_carrera);

			rs = pst.executeQuery();

			if (rs.next()) {
				estado = rs.getString(1);
			}
			pst.close();
			rs.close();
			con.close();

			return estado.equals("INSCRITO");

		} catch (SQLException e) {
			throw new BusinessDataException("Ha ocurrido un problema con la base de datos");
		}
	}

	public static boolean estaEnListaDeEspera(String email, String id_carrera) throws BusinessDataException {
		PreparedStatement pst = null;
		ResultSet rs = null;
		Connection con = null;

		try {
			con = DriverManager.getConnection(SqliteConnectionInfo.URL);

			pst = con.prepareStatement(SqlStatements.SQL_EN_LISTA_ESPERA);

			pst.setString(1, email);
			pst.setString(2, id_carrera);

			rs = pst.executeQuery();

			if (rs.next()) {
				rs.close();
				pst.close();
				con.close();
				return true;
			}
			rs.close();
			pst.close();
			con.close();
			return false;
		} catch (SQLException e) {
			throw new BusinessDataException("Ha ocurrido un problema con la base de datos");
		}
	}
}
