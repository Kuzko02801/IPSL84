package testing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;

import business.dataaccess.datainformation.SqliteConnectionInfo;
import business.dataaccess.dto.CarreraDto;

public class Main {

	private static boolean print = true;

	public static void main(String[] args) throws ParseException {
		try {
			DriverManager.registerDriver(new org.sqlite.JDBC());
		} catch (SQLException e1) {
			System.out.println("ada");
		}
		Connection con = null;
		PreparedStatement ps = null;
		Test test = null;
		CarreraDto carrera = new CarreraDto();
		try {
			con = DriverManager.getConnection(SqliteConnectionInfo.URL);
			test = new Test(con, ps);
			// añadir atletas
//			 test.addAtleta("123112323", "A5", "sisisisisis", new
//			 DateSqlite("03/02/1997"), Genero.HOMBRE);

//			carrera.nombre = "DATE WITH NEWLY IMPLEMENTED DATE CLASS.";
//			carrera.fecha = new DateSqlite("06/07/2021");
//			carrera.tipo = Tipo.ASFALTO;
//			carrera.distancia = 199;
//			carrera.cuota = 200;
//			carrera.carrera_id = "5";
//			carrera.plazasMaximas = 20; //
//			carrera.cierre = new DateSqlite("06/12/2021");
//			carrera.apertura = new DateSqlite("06/10/2021");
//			carrera.estado = EstadoCarrera.NO_COMENZADA;

			//test.addCarrera(carrera);
			
			// Poner los metodo a partir de esta linea y pasar como parametro ps.
			if (print) {
				test.printAllAthletes();
				System.out.println("-------------------------------------");
				test.printAllCarreras();
				System.out.println("-------------------------------------");
				test.printAllInscriptions();
			}

			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
