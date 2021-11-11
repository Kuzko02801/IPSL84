package business.dataaccess.inscripcion.comandos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import business.dataaccess.datainformation.SqlStatements;
import business.dataaccess.datainformation.SqliteConnectionInfo;
import business.dataaccess.dto.carrera.Periodo;
import business.dataaccess.parsers.PeriodoParser;
import business.dataaccess.util.DateSqlite;

public class CuotaActualCarrera {
	
	private String id_carrera;
	
	public CuotaActualCarrera(String id_carrera) {
		this.id_carrera = id_carrera;
	}

	public double execute() {
		
		try {
			DriverManager.registerDriver(new org.sqlite.JDBC());
		} catch (SQLException e1) {
			System.out.println("Ha fallado el register del driver");
		}
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(SqliteConnectionInfo.URL);
			
			ps = con.prepareStatement(SqlStatements.SQL_SELECT_CARRERA);
			
			ps.setString(1,id_carrera);

			
			rs = ps.executeQuery();
			
			if (rs.next()) {
				List<Periodo> periodos = PeriodoParser.devolverPeriodos(rs.getString("periodos"));
				
				for (Periodo p : periodos) {
					
					if (p.getFechaInicio().compareTo(new DateSqlite().actual()) < 0 && 
							p.getFechaFin().compareTo(new DateSqlite().actual()) > 0) {
						rs.close();
						ps.close();
						con.close();
						return p.getCuota();
					}
				}
			} 
			rs.close();
			ps.close();
			con.close();
			return 0.0;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
