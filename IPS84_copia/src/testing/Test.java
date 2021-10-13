package testing;

import java.sql.Connection;

import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import business.dataaccess.datainformation.SqlStatements;
import business.dataaccess.datainformation.SqliteConnectionInfo;
import business.dataaccess.dto.infoadicional.Tipo;
import business.dataaccess.dto.infoadicional.CategoriaAtleta;
import business.dataaccess.dto.infoadicional.EstadoCarrera;
import business.dataaccess.dto.infoadicional.Genero;

public class Test {

	private Connection con;
	private PreparedStatement ps;

	public Test(Connection con, PreparedStatement ps) {
		this.con = con;
		this.ps = ps;
	}
	
	public void addAtleta(String dni, String email, String nombre, Date fechaDeNacimiento, Genero genero) {
		
		try {
			con = DriverManager.getConnection(SqliteConnectionInfo.URL);
			ps = con.prepareStatement(SqlStatements.SQL_TESTING_INSERT_ATLETA);

			ps.setString(1, email);
			ps.setString(2, nombre);
			ps.setDate(3, fechaDeNacimiento);
			ps.setString(4, genero.label);

			ps.executeUpdate();
			
			System.out.println("Atleta añadido con exito.");
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Ha ocurrido un error");
		}
	}
	
	public void addCarrera(String nombre, Date date, Tipo tipo, double distancia, double cuota, String id, int plazasMaximas, Date cierre, Date apertura, EstadoCarrera estado, int plazasLibres) {
		
		try {
			con = DriverManager.getConnection(SqliteConnectionInfo.URL);
			ps = con.prepareStatement(SqlStatements.SQL_TESTING_INSERT_ATLETA);

			ps.setString(1, nombre);
			ps.setDate(2, date);
			ps.setString(3, tipo.label);
			ps.setDouble(4, distancia);
			ps.setDouble(5, cuota);
			ps.setString(6, id);
			ps.setInt(7, plazasMaximas);
			ps.setDate(8, cierre);
			ps.setDate(9, apertura);
			ps.setString(10, estado.label);
			ps.setInt(11, plazasLibres);

			ps.executeUpdate();
			
			System.out.println("Carrera añadida con exito.");
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Ha ocurrido un error");
		}
	}
	
	public void addInscripcion(String email_atleta, String id_carrera, EstadoCarrera estado, int tiempo, CategoriaAtleta categoria) {
		try {
			con = DriverManager.getConnection(SqliteConnectionInfo.URL);
			ps = con.prepareStatement(SqlStatements.SQL_TESTING_INSERT_ATLETA);

			ps.setString(1, email_atleta);
			ps.setString(2, id_carrera);
			ps.setString(3, estado.label);
			ps.setInt(4, tiempo);
			ps.setString(5, categoria.label);

			ps.executeUpdate();
			
			System.out.println("Inscripcion añadida con exito.");
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Ha ocurrido un error");
		}
	}
}
