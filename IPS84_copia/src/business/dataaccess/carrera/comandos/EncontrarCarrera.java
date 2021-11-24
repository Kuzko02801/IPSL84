package business.dataaccess.carrera.comandos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import business.dataaccess.datainformation.SqlStatements;
import business.dataaccess.datainformation.SqliteConnectionInfo;
import business.dataaccess.dto.carrera.CarreraDto;
import business.dataaccess.dto.dtoassembler.DtoAssembler;
import business.dataaccess.exception.BusinessDataException;
import business.dataaccess.parsers.CategoriaParser;
import business.dataaccess.parsers.PeriodoParser;
import business.dataaccess.parsers.PuntosCorteParser;

public class EncontrarCarrera {

	String id;
	
	public EncontrarCarrera(String id) {
		this.id = id;
	}
	public CarreraDto encontrarCarrera() throws BusinessDataException {
		try {
			DriverManager.registerDriver(new org.sqlite.JDBC());
		} catch (SQLException e1) {
			System.out.println("Ha fallado el register del driver");
		}
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
						, rs.getString(3)
						, rs.getDouble(4) + ""					
						, id
						, rs.getInt(6) + ""						
						, CategoriaParser.devolverCategorias(rs.getString(7))
						, PeriodoParser.devolverPeriodos(rs.getString(8))
						, PuntosCorteParser.devolverPuntosCorte(rs.getString(9))
						, rs.getBoolean(10)
						, rs.getBoolean(11));
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			throw new BusinessDataException("Ha habido un problema con la base de datos");
		}
		return carrera;
	}
}
