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
			while (rs.next()) {
				carrera = DtoAssembler.forCarreraDto(rs.getString("nombre"), rs.getString("fecha"),
						rs.getString("tipo"), rs.getDouble("distancia") + "", id, rs.getInt("plazas_maximas") + "",
						CategoriaParser.devolverCategorias(rs.getString("categorias")),
						PeriodoParser.devolverPeriodos(rs.getString("periodos")),
						PuntosCorteParser.devolverPuntosCorte(rs.getString("puntosdecorte")),
						rs.getBoolean("listadeespera"), rs.getBoolean("cancelacioninscripcion"),
						rs.getDouble("porcentajeadevolver") + "", rs.getString("fechamaxcancelacion"));
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
