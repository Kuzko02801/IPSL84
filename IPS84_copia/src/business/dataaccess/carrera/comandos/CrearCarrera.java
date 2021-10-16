package business.dataaccess.carrera.comandos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

import business.dataaccess.datainformation.SqlStatements;
import business.dataaccess.datainformation.SqliteConnectionInfo;
import business.dataaccess.dto.CarreraDto;
import business.dataaccess.dto.infoadicional.EstadoCarrera;


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
						
			id = UUID.randomUUID().toString();
			ps.setString(1, carrera.nombre);
			ps.setDate(2, new Date(System.currentTimeMillis()));
			ps.setString(3, carrera.tipo.label);
			ps.setDouble(4, carrera.distancia);
			ps.setDouble(5, carrera.cuota);
			ps.setString(6, id);
			ps.setInt(7, carrera.plazasMaximas);
			ps.setString(8, carrera.cierre.toString());
			ps.setString(9, carrera.apertura.toString());
			ps.setString(10, EstadoCarrera.NO_COMENZADA.toString());			
			
			ps.close();
			con.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
}
