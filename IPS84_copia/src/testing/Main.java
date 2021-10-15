package testing;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import business.dataaccess.datainformation.SqliteConnectionInfo;
import business.dataaccess.dto.CarreraDto;
import business.dataaccess.dto.infoadicional.EstadoCarrera;
import business.dataaccess.dto.infoadicional.Genero;
import business.dataaccess.dto.infoadicional.Tipo;

public class Main {

	public static void main(String[] args) {
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
			//test.addAtleta("123112323", "sasd222as@asdd.com", "sisisisisis", new Date(System.currentTimeMillis()), Genero.HOMBRE);
			
			carrera.nombre = "a";
			carrera.fecha = new Date(System.currentTimeMillis() + 1000000000);
			carrera.tipo = Tipo.ASFALTO;
			carrera.distancia = 199;
			carrera.cuota = 200;
			carrera.carrera_id = "1";
			carrera.plazasMaximas = 20;
			carrera.cierre = new Date(System.currentTimeMillis() + 10000000);
			carrera.apertura = new Date(System.currentTimeMillis() + 1000000);
			carrera.estado = EstadoCarrera.NO_COMENZADA;
			
			test.addCarrera(carrera);
			carrera.carrera_id = "2";
			test.addCarrera(carrera);
			carrera.carrera_id = "3";
			test.addCarrera(carrera);
			// Poner los metodo a partir de esta linea y pasar como parametro ps.
			test.printAllAthletes();
			test.printAllCarreras();

			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
