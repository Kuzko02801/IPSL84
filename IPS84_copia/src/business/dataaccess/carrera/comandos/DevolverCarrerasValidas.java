package business.dataaccess.carrera.comandos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.swing.table.TableModel;

import business.dataaccess.datainformation.SqlStatements;
import business.dataaccess.datainformation.SqliteConnectionInfo;
import business.dataaccess.dto.carrera.CarreraDto;
import business.dataaccess.dto.carrera.Periodo;
import business.dataaccess.parsers.PeriodoParser;
import business.dataaccess.util.Check;
import net.proteanit.sql.DbUtils;

public class DevolverCarrerasValidas {

	public TableModel devolverCarreras() {
		try {
			DriverManager.registerDriver(new org.sqlite.JDBC());
		} catch (SQLException e1) {
			System.out.println("Ha fallado el register del driver");
		}
		TableModel t = null;
		PreparedStatement ps = null;
		Connection con = null;
		ResultSet rs = null;
		List<Periodo> periodos;		
		try {
			con = DriverManager.getConnection(SqliteConnectionInfo.URL);
			ps = con.prepareStatement(SqlStatements.SQL_CARRERAS);
			
			rs = ps.executeQuery();	
			
			while(rs.next()) {
				// We check that the race is open.				
				periodos = PeriodoParser.devolverPeriodos(rs.getString("periodos"));
				if(!Check.checkCarreraAbierta(periodos)) {
					rs.deleteRow();
				}
			}			
			t = DbUtils.resultSetToTableModel(rs);
			
			ps.close();
			rs.close();
			con.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return t;
	}

	
}
