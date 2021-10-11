package testing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;

import business.dataaccess.datainformation.SqliteConnectionInfo;
import business.dataaccess.dto.infoadicional.Genero;

public class Main {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement ps = null;
		Test test = null;
		try {
			con = DriverManager.getConnection(SqliteConnectionInfo.URL);
			test = new Test(con, ps);
			// Poner los metodo a partir de esta linea y pasar como parametro ps.
			
			test.addAtleta("123112323", "sasdas@asdd.com", "sisisisisis", new Date(System.currentTimeMillis()), Genero.HOMBRE);
			
			////////////////////////////////////////////////////////////////////
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
