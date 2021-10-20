package business.dataaccess.atleta.comandos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import business.dataaccess.BusinessDataException;
import business.dataaccess.datainformation.SqlStatements;
import business.dataaccess.datainformation.SqliteConnectionInfo;
import business.dataaccess.dto.AtletaDto;

public class AtletaAdd {

	private AtletaDto atleta;

	public AtletaAdd(AtletaDto atleta) {
		this.atleta = atleta;
	}

	public void atletaAdd() throws BusinessDataException {
		PreparedStatement ps = null;
		Connection con = null;
		try {
			DriverManager.registerDriver(new org.sqlite.JDBC());
		} catch (SQLException e1) {
			System.out.println("Ha fallado el register del driver");
		}
		try {
			con = DriverManager.getConnection(SqliteConnectionInfo.URL);
			if (new ExisteAtleta(atleta.email).existeAtleta()) {
				throw new BusinessDataException("Ya hay un atleta con este e-mail.");
			}
			ps = con.prepareStatement(SqlStatements.SQL_ADD_ATLETA);
			ps.setString(1, atleta.email);
			ps.setString(2, atleta.dni);
			ps.setString(3, atleta.nombre);
			ps.setString(4, atleta.fechaDeNacimiento.toString());
			ps.setString(5, atleta.genero.label);
			ps.executeUpdate();

			ps.close();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
