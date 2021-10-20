package testing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import business.dataaccess.datainformation.SqlStatements;
import business.dataaccess.datainformation.SqliteConnectionInfo;
import business.dataaccess.dto.CarreraDto;
import business.dataaccess.dto.infoadicional.CategoriaAtleta;
import business.dataaccess.dto.infoadicional.EstadoCarrera;
import business.dataaccess.dto.infoadicional.Genero;
import business.dataaccess.util.DateSqlite;

public class Test {

	private Connection con;
	private PreparedStatement ps;

	public Test(Connection con, PreparedStatement ps) {
		this.con = con;
		this.ps = ps;
	}
	
	public void addAtleta(String dni, String email, String nombre, DateSqlite fechaDeNacimiento, Genero genero) {
		
		try {			
			ps = con.prepareStatement(SqlStatements.SQL_TESTING_INSERT_ATLETA);

			
			ps.setString(1, email);
			ps.setString(2, dni);
			ps.setString(3, nombre);
			ps.setString(4, fechaDeNacimiento.toString());
			ps.setString(5, genero.label);

			ps.executeUpdate();
			
			System.out.println("Atleta añadido con exito.");
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Ha ocurrido un error");
		}
	}
	
	public void addCarrera(CarreraDto carrera) {
		
		try {
			con = DriverManager.getConnection(SqliteConnectionInfo.URL);
			ps = con.prepareStatement(SqlStatements.SQL_INSERT_CARRERA);

			ps.setString(1, carrera.nombre);
			ps.setString(2, carrera.fecha.toString());
			ps.setString(3, carrera.tipo.label);
			ps.setDouble(4, carrera.distancia);
			ps.setDouble(5, carrera.cuota);
			ps.setString(6, carrera.carrera_id);
			ps.setInt(7, carrera.plazasMaximas);
			ps.setString(8, carrera.cierre.toString());
			ps.setString(9, carrera.apertura.toString());
			ps.setString(10, carrera.estado.label);			

			ps.executeUpdate();
			
			System.out.println("Carrera añadida con exito.");
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Ha ocurrido un error");
		}
	}
	
	public void printAllAthletes() throws SQLException {
		String query = "select * from Atleta";
		Statement s = con.createStatement();
		ResultSet rs= s.executeQuery(query);
		ResultSetMetaData rsmd = rs.getMetaData();
		int columnsNumber = rsmd.getColumnCount();
		while(rs.next()) {
			for (int i = 1; i <= columnsNumber; i++) {
		        if (i > 1) System.out.print(",  ");
		        String columnValue = rs.getString(i);
		        System.out.print(columnValue + " " + rsmd.getColumnName(i));
		    }
		    System.out.println("");
		}
	}
	
	public void printAllCarreras() throws SQLException {
		String query = "select * from Carrera";
		Statement s = con.createStatement();
		ResultSet rs= s.executeQuery(query);
		ResultSetMetaData rsmd = rs.getMetaData();
		int columnsNumber = rsmd.getColumnCount();
		while(rs.next()) {
			for (int i = 1; i <= columnsNumber; i++) {
		        if (i > 1) System.out.print(",  ");
		        String columnValue = rs.getString(i);
		        System.out.print(columnValue + " " + rsmd.getColumnName(i));
		    }
		    System.out.println("");
		}
	}
	
	public void printAllInscriptions() throws SQLException {
		String query = "select * from Inscripcion";
		Statement s = con.createStatement();
		ResultSet rs= s.executeQuery(query);
		ResultSetMetaData rsmd = rs.getMetaData();
		int columnsNumber = rsmd.getColumnCount();
		while(rs.next()) {
			for (int i = 1; i <= columnsNumber; i++) {
		        if (i > 1) System.out.print(",  ");
		        String columnValue = rs.getString(i);
		        System.out.print(columnValue + " " + rsmd.getColumnName(i));
		    }
		    System.out.println("");
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
