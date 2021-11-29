package business.dataaccess.carrera.comandos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import business.dataaccess.datainformation.SqlStatements;
import business.dataaccess.datainformation.SqliteConnectionInfo;
import business.dataaccess.exception.BusinessDataException;

public class TieneCancelacion {

	private String id_carrera;

	public TieneCancelacion(String id_carrera) {
		this.id_carrera = id_carrera;
	}

	public boolean execute() throws BusinessDataException {
		PreparedStatement pst = null;
		Connection con = null;
		ResultSet rs = null;
		boolean tieneCancelacion;
		try {
			con = DriverManager.getConnection(SqliteConnectionInfo.URL);

			pst = con.prepareStatement(SqlStatements.SQL_TIENE_CANCELACION);
			pst.setString(1, id_carrera);

			rs = pst.executeQuery();
			tieneCancelacion = rs.getBoolean(1);
			rs.close();
			pst.close();
			con.close();

			return tieneCancelacion;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new BusinessDataException("Ha ocurrido un error con la base de datos");
		}
	}

}
