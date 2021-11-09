package business.dataaccess.carrera.comandos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import business.dataaccess.datainformation.SqlStatements;
import business.dataaccess.datainformation.SqliteConnectionInfo;
import business.dataaccess.dto.carrera.CarreraDto;
import business.dataaccess.dto.carrera.Periodo;
import business.dataaccess.dto.dtoassembler.DtoAssembler;
import business.dataaccess.parsers.PeriodoParser;
import business.dataaccess.util.Check;

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
		List<CarreraDto> carreras = new ArrayList<>();
		try {
			con = DriverManager.getConnection(SqliteConnectionInfo.URL);
			ps = con.prepareStatement(SqlStatements.SQL_CARRERAS);
			rs = ps.executeQuery();
			while (rs.next()) {
				// We check that the race is open.
				periodos = PeriodoParser.devolverPeriodos(rs.getString("periodos"));
				if (Check.checkCarreraAbierta(periodos)) {
					carreras.add(DtoAssembler.toCarreraDto(rs));
				}
			}
			t = tableModelAssembler(carreras);
			ps.close();
			rs.close();
			con.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return t;
	}

	private TableModel tableModelAssembler(List<CarreraDto> carreras) {
		String col[] = { "ID", "Nombre", "Fecha", "Tipo", "Distancia", "Plazas maximas", "Plazo1", "Cuota1", "Plazo2",
				"Cuota2", "Plazo3", "Cuota3" };
		DefaultTableModel tableModel = new DefaultTableModel(col, 0);
		for (CarreraDto carrera : carreras) {
			int nPeriodos = carrera.periodos.size();
			Object[] row = new Object[12];
			List<Object> lista = new ArrayList<Object>(Arrays.asList(carrera.carrera_id, carrera.nombre,
					carrera.fecha.toString(), carrera.tipo.toString(), carrera.distancia, carrera.plazasMaximas,
					carrera.periodos.get(0).getFechaInicio() + " - " + carrera.periodos.get(0).getFechaFin(),
					carrera.periodos.get(0).getCuota()));
			for (int i = 1; i < nPeriodos; i++) {
				lista.add(carrera.periodos.get(i).getFechaInicio() + " - " + carrera.periodos.get(i).getFechaFin());
				lista.add(carrera.periodos.get(i).getCuota());
			}
			for (int i = 0; i < lista.size(); i++) {
				row[i] = lista.get(i);
			}
			tableModel.addRow(row);
		}
		return tableModel;
	}
}
