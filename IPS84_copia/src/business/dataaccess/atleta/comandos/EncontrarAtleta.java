package business.dataaccess.atleta.comandos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import business.dataaccess.datainformation.SqlStatements;
import business.dataaccess.datainformation.SqliteConnectionInfo;
import business.dataaccess.dto.AtletaDto;
import business.dataaccess.dto.dtoassembler.DtoAssembler;

public class EncontrarAtleta {

	private String email;
	
	public EncontrarAtleta(String email) {
		this.email = email;
	}
	
	public AtletaDto encontrarAtleta() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		AtletaDto atleta = new AtletaDto();
		try {
			con = DriverManager.getConnection(SqliteConnectionInfo.URL);
			ps = con.prepareStatement(SqlStatements.SQL_SELECT_ATLETA);
			ps.setString(1, email);
			
			rs = ps.executeQuery();

			while(rs.next()) {
				atleta = DtoAssembler.forAtletaDto(
						rs.getString(1)
						, rs.getString(2)
						, rs.getString(3)						
						, rs.getString(4)
						, rs.getString(5)
						); // Arreglar la seleccion del estado.
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return atleta;
	}
}
