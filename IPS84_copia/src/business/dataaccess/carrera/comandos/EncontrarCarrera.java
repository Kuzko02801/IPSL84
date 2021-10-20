package business.dataaccess.carrera.comandos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import business.dataaccess.datainformation.SqlStatements;
import business.dataaccess.datainformation.SqliteConnectionInfo;
import business.dataaccess.dto.CarreraDto;
import business.dataaccess.dto.dtoassembler.DtoAssembler;
import business.dataaccess.dto.infoadicional.EstadoCarrera;
import business.dataaccess.dto.infoadicional.Tipo;
import business.dataaccess.util.DateSqlite;

public class EncontrarCarrera {

	String id;
	
	public EncontrarCarrera(String id) {
		this.id = id;
	}
	
	public CarreraDto encontrarCarrera() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		CarreraDto carrera = new CarreraDto();
		try {
			con = DriverManager.getConnection(SqliteConnectionInfo.URL);
			ps = con.prepareStatement(SqlStatements.SQL_SELECT_CARRERA);
			ps.setString(1, id);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				carrera = DtoAssembler.forCarreraDto(
						rs.getString(1)
						, rs.getString(2)
						, rs.getString(3) // Arreglar la seleccion del tipo
						, rs.getString(4)
						, rs.getString(5)
						, id
						, rs.getString(7)
						, rs.getString(8)
						, rs.getString(9)
						, rs.getString(10)); // Arreglar la seleccion del estado.
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return carrera;
	}
}
