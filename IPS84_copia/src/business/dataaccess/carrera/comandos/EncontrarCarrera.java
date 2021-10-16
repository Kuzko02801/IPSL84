package business.dataaccess.carrera.comandos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import business.dataaccess.carrera.CarreraService;
import business.dataaccess.datainformation.SqlStatements;
import business.dataaccess.datainformation.SqliteConnectionInfo;
import business.dataaccess.dto.CarreraDto;
import business.dataaccess.dto.dtoassembler.DtoAssembler;
import business.dataaccess.dto.infoadicional.EstadoCarrera;
import business.dataaccess.dto.infoadicional.Tipo;

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
						, rs.getDate(2)
						, Tipo.tipoParser(rs.getString(3)) // Arreglar la seleccion del tipo
						, rs.getDouble(4)
						, rs.getDouble(5)
						, id
						, rs.getInt(7)
						, rs.getDate(8)
						, rs.getDate(9)
						, EstadoCarrera.estadoParser(rs.getString(10))); // Arreglar la seleccion del estado.
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
