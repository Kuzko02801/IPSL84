package business.dataaccess.carrera.comandos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

import business.dataaccess.datainformation.SqlStatements;
import business.dataaccess.datainformation.SqliteConnectionInfo;
import business.dataaccess.dto.carrera.CarreraDto;
import business.dataaccess.dto.carrera.Periodo;
import business.dataaccess.dto.infoadicional.EstadoCarrera;
import business.dataaccess.parsers.PeriodoParser;


public class CrearCarrera {
	private CarreraDto carrera;
	public CrearCarrera(CarreraDto carrera) {
		this.carrera=carrera;
	}
	public void crearCarrera() {

		try {
			DriverManager.registerDriver(new org.sqlite.JDBC());
		} catch (SQLException e1) {
			System.out.println("Ha fallado el register del driver");
		}
		PreparedStatement ps = null;
		Connection con= null;
		String id = null;
		try {
			con = DriverManager.getConnection(SqliteConnectionInfo.URL);
			
			ps = con.prepareStatement(SqlStatements.SQL_INSERT_CARRERA);
						
			id = UUID.randomUUID().toString().substring(0, 6);
			ps.setString(1, carrera.nombre);
			ps.setString(2, carrera.fecha.toString());
			ps.setString(3, carrera.tipo.label);
			ps.setDouble(4, carrera.distancia);			
			ps.setString(5, id);
			ps.setInt(6, carrera.plazasMaximas);			
			ps.setString(7, EstadoCarrera.NO_COMENZADA.label);	
			// Insertar categorias.
			
			// Insertar periodos.
			ps.setString(9, PeriodoParser.periodosToString(carrera.periodos));	
						
			
			ps.execute();
			
			ps.close();
			con.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
}
