package testing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;

import business.dataaccess.datainformation.SqliteConnectionInfo;
import business.dataaccess.dto.CarreraDto;
import business.dataaccess.dto.infoadicional.EstadoCarrera;
import business.dataaccess.dto.infoadicional.Tipo;
import business.dataaccess.util.DateSqlite;

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
//			// añadir atletas
////			 test.addAtleta("123112323", "A5", "sisisisisis", new
////			 DateSqlite("03/02/1997"), Genero.HOMBRE);
//			
//			//test.addAtleta("a", "emailaux", "a", new DateSqlite("20/03/2001"), Genero.HOMBRE);
//			
			carrera.nombre = "CARRERA_ABIERTA";
			carrera.fecha = new DateSqlite("06/07/2021");
			carrera.tipo = Tipo.CARRERA_POPULAR;
			carrera.distancia = 199;
			carrera.cuota = 200;
			carrera.carrera_id = "OPEN";
			carrera.plazasMaximas = 20; //
			carrera.cierre = new DateSqlite("2022/05/03");
			carrera.apertura = new DateSqlite("2020/03/04");
			carrera.estado = EstadoCarrera.NO_COMENZADA;

			test.addCarrera(carrera);
//			
//			CarreraDto testCarrera = new CarreraDto();
//			testCarrera.carrera_id = "5";
//			
//			AtletaDto testAtleta = new AtletaDto();
//			testAtleta.email = "emailaux";
//			
//			try {
//				DataAccessFactory.forAtletaService().inscribirAtleta(testAtleta, testCarrera);
//			} catch (BusinessDataException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			
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
