package business.dataaccess.listadeespera.comandos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import business.dataaccess.datainformation.SqlStatements;
import business.dataaccess.datainformation.SqliteConnectionInfo;
import business.dataaccess.exception.BusinessDataException;

public class NumeroDeListaEspera {

	private String id_carrera;

	public NumeroDeListaEspera(String id_carrera) {
		this.id_carrera = id_carrera;
	}

	public int execute() throws BusinessDataException {
		PreparedStatement pst = null;
		Connection con = null;
		ResultSet rs = null;
		int puesto = 0;
		try {
			con = DriverManager.getConnection(SqliteConnectionInfo.URL);

			pst = con.prepareStatement(SqlStatements.SQL_PUESTO_LISTA_ESPERA);
			pst.setString(1, id_carrera);
			rs = pst.executeQuery();
			puesto = rs.getInt(1);

			rs.close();
			pst.close();
			con.close();
			return puesto;
		} catch (SQLException e) {
			throw new BusinessDataException("Error al solicitar numero de lista de espera.");
		}
	}

}
