package business.dataaccess.carrera.comandos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import business.dataaccess.datainformation.SqlStatements;
import business.dataaccess.datainformation.SqliteConnectionInfo;
import business.dataaccess.exception.BusinessDataException;

public class TieneListaEspera {

	private String id_carrera;

	public TieneListaEspera(String id_carrera) {
		this.id_carrera = id_carrera;
	}

	public boolean execute() throws BusinessDataException {
		PreparedStatement pst = null;
		Connection con = null;
		ResultSet rs = null;
		boolean tieneLista;
		try {
			con = DriverManager.getConnection(SqliteConnectionInfo.URL);

			pst = con.prepareStatement(SqlStatements.SQL_TIENE_LISTA_ESPERA);
			pst.setString(1, id_carrera);

			rs = pst.executeQuery();
			tieneLista = rs.getBoolean(1);
			rs.close();
			pst.close();
			con.close();

			return tieneLista;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new BusinessDataException("Ha ocurrido un error con la base de datos");
		}
	}

}
