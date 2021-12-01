package business.dataaccess.carrera.comandos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.TableModel;

import business.dataaccess.DataAccessFactory;
import business.dataaccess.datainformation.SqlStatements;
import business.dataaccess.datainformation.SqliteConnectionInfo;
import business.dataaccess.dto.carrera.CarreraDto;
import business.dataaccess.exception.BusinessDataException;
import business.dataaccess.util.TableModelAssembler;
import net.proteanit.sql.DbUtils;

public class DevolverClasificacionFemenina {
	private String id;
	
	public DevolverClasificacionFemenina(String id) {
		this.id = id;
	}
	
	public TableModel devolverClasificacionFemenina() throws BusinessDataException {
		try {
			DriverManager.registerDriver(new org.sqlite.JDBC());
		} catch (SQLException e1) {
			System.out.println("Ha fallado el register del driver");
		}
		CarreraDto carrera = DataAccessFactory.forCarreraService().findCarreraById(id);
		TableModel t = null;
		PreparedStatement ps = null;
		Connection con = null;
		ResultSet rs = null;

		try {
			con = DriverManager.getConnection(SqliteConnectionInfo.URL);
			ps = con.prepareStatement(SqlStatements.SQL_CLASIFICACION_FEMENINA);
			ps.setString(1, id);
			rs = ps.executeQuery();
			ArrayList<ArrayList<String>> listaInscripciones=new ArrayList<ArrayList<String>>();
			int contador=0;
			while (rs.next()) {
				
				contador++;//contador para la posicion, si no acabo se parsea luego
				// Sacar de la query
				String posicion=contador+"";
				String dorsal=rs.getString("dorsal");
				String nombre=rs.getString("nombre");
				String sexo=rs.getString("sexo");
				String club=rs.getString("club");
				String tiemposCorte=rs.getString("tiemposCorte");
				String tiempoFinal=rs.getString("tiempo");
				ArrayList<String> listaString = new ArrayList<String>() {
					{
						add(posicion);
						add(dorsal);
						add(nombre);
						add(sexo);
						add(club);
						add(tiemposCorte);
						add(tiempoFinal);
					}
				};
				listaInscripciones.add(listaString);
			}
			t = TableModelAssembler.clasificacionesAssembler(carrera.puntosCorte.size(), listaInscripciones);

			ps.close();
			rs.close();
			con.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return t;
	}
}
