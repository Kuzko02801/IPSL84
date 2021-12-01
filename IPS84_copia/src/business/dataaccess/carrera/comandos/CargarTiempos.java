package business.dataaccess.carrera.comandos;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import business.dataaccess.DataAccessFactory;
import business.dataaccess.datainformation.SqlStatements;
import business.dataaccess.datainformation.SqliteConnectionInfo;
import business.dataaccess.dto.carrera.CarreraDto;
import business.dataaccess.exception.BusinessDataException;
import business.dataaccess.parsers.TiempoParser;

public class CargarTiempos {

	private String id;
	private File tiempos;

	public CargarTiempos(String id, File tiempos) {
		this.id = id;
		this.tiempos = tiempos;
	}

	public void cargarTiempos() throws BusinessDataException {
		String idCarrera = TiempoParser.parsearIdCarrera(tiempos);
		if (!idCarrera.equals(id)) {
			throw new BusinessDataException("Las ids de las carreras no coinciden.");
		}
		CarreraDto carrera = DataAccessFactory.forCarreraService().findCarreraById(idCarrera);
		List<List<String>> todosLosTiempos = TiempoParser.parsearTiempos(tiempos, carrera.puntosCorte.size());
		try {
			DriverManager.registerDriver(new org.sqlite.JDBC());
		} catch (SQLException e1) {
			System.out.println("Ha fallado el register del driver");
		}
		PreparedStatement ps = null;
		Connection con = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(SqliteConnectionInfo.URL);
			ps = con.prepareStatement(SqlStatements.SQL_INSCRIPCION_DORSAL);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				PreparedStatement statement1 = con.prepareStatement(SqlStatements.SQL_INSCRIPCION_ACTUALIZAR_TIEMPOS);
				statement1.setString(1, "DNS");
				statement1.setString(2, "0");
				statement1.setString(3, "0");
				statement1.setString(4, "-");
				statement1.setString(5, id);
				statement1.setInt(6, rs.getInt("dorsal"));
				statement1.executeUpdate();
				statement1.close();
				for (List<String> listaTiempos : todosLosTiempos) {

					int dorsal = Integer.parseInt(listaTiempos.get(0));
					if (dorsal == rs.getInt("dorsal")) {
						PreparedStatement statement = con
								.prepareStatement(SqlStatements.SQL_INSCRIPCION_ACTUALIZAR_TIEMPOS);
						statement.setString(1, calculaTiempo(listaTiempos.get(1), listaTiempos.get(2)));
						statement.setString(2, listaTiempos.get(1));
						statement.setString(3, listaTiempos.get(2));
						statement.setString(4, calculaTiemposCorte(listaTiempos.get(1), listaTiempos.get(3)));
						statement.setString(5, id);
						statement.setInt(6, dorsal);
						statement.executeUpdate();
						statement.close();
					}
				}
			}
			ps.close();
			con.close();
			rs.close();
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	private String calculaTiemposCorte(String tiempoInicio, String tiemposCorte) throws BusinessDataException {
		String result = "";
		String[] tiempos = tiemposCorte.split(";");
		for (int i = 0; i < tiempos.length; i++) {
			if (!tiempos[i].equals("-")) {
				result += calculaTiempo(tiempoInicio, tiempos[i])+";";
			}else {
				result+="-;";
			}
		}
		return result.substring(result.length() - 1);
	}

	private String calculaTiempo(String tiempoInicio, String tiempoFin) throws BusinessDataException {
		if (tiempoFin.trim().equals("-")) {
			return "DNF";
		} else {
			int t1 = Integer.parseInt(tiempoInicio);
			int t2 = Integer.parseInt(tiempoFin);
			int t = t2 - t1;
			if(t<0) {
				throw new BusinessDataException("El archivo esta corrupto");
			}
			Duration duration = Duration.ofMillis(t);
			long seconds = duration.getSeconds();
			long HH = seconds / 3600;
			long MM = (seconds % 3600) / 60;
			long SS = seconds % 60;
			return String.format("%02d:%02d:%02d", HH, MM, SS);
		}

	}
}
