package business.dataaccess.atleta.comandos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import business.dataaccess.BusinessDataException;
import business.dataaccess.DataAccessFactory;
import business.dataaccess.datainformation.SqlStatements;
import business.dataaccess.datainformation.SqliteConnectionInfo;
import business.dataaccess.dto.AtletaDto;
import business.dataaccess.util.Check;

public class AtletaAdd {

	private AtletaDto atleta;
	private Connection c;
	
	public AtletaAdd(AtletaDto atleta) {
		this.atleta = atleta;
	}
	
	public void atletaAdd() throws BusinessDataException {
		PreparedStatement ps = null;		
		try {
			c = DriverManager.getConnection(SqliteConnectionInfo.URL);
			atleta = DataAccessFactory.forAtletaService().encontrarAtleta(atleta.email);
			// Check if the race exists.			
			
			if(!Check.atletaExists(c, atleta.email)) {
				throw new BusinessDataException("Ya hay un atleta con este e-mail.");
			}				
			
			ps = c.prepareStatement(SqlStatements.SQL_ADD_ATLETA);
			
			ps.setString(1, atleta.email);
			ps.setString(2, atleta.nombre);
			ps.setString(3, atleta.fechaDeNacimiento.toString());								
			ps.setString(4, atleta.genero.label);		

			ps.executeUpdate();

			ps.close();			

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
