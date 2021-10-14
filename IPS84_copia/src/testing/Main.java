package testing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;

import business.dataaccess.datainformation.SqliteConnectionInfo;
import business.dataaccess.dto.infoadicional.Genero;

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
		try {
			con = DriverManager.getConnection(SqliteConnectionInfo.URL);
			test = new Test(con, ps);
			//añadir atletas
			test.addAtleta("123112323", "sasdas@asdd.com", "sisisisisis", new Date(System.currentTimeMillis()), Genero.HOMBRE);
			// Poner los metodo a partir de esta linea y pasar como parametro ps.
			String query = "select * from atleta";
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
