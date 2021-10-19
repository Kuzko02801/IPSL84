package business.dataaccess.atleta.comandos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import business.dataaccess.BusinessDataException;
import business.dataaccess.DataAccessFactory;
import business.dataaccess.datainformation.SqlStatements;
import business.dataaccess.datainformation.SqliteConnectionInfo;
import business.dataaccess.dto.AtletaDto;
import business.dataaccess.dto.CarreraDto;
import business.dataaccess.dto.infoadicional.CategoriaAtleta;
import business.dataaccess.dto.infoadicional.EstadoInscripcion;
import business.dataaccess.util.Check;
import business.dataaccess.util.DateSqlite;

public class AtletaInscripcion {

	private AtletaDto atleta;
	private CarreraDto carrera;
	private Connection con;

	public AtletaInscripcion(AtletaDto atleta, CarreraDto carrera) {
		this.atleta = atleta;
		this.carrera = carrera;		
	}

	public void inscribirAtleta() throws BusinessDataException {
		
		PreparedStatement ps = null;		
		try {
			con = DriverManager.getConnection(SqliteConnectionInfo.URL);
			atleta = DataAccessFactory.forAtletaService().encontrarAtleta(atleta.email);
			// Check if the race exists.			
			
			if(!Check.atletaExists(con, atleta.email)) {
				throw new BusinessDataException("Ningun atleta asociado con este email.");
			}
			
			if (!Check.raceExists(con, carrera.carrera_id))
				throw new BusinessDataException("La carrera no existe.");
			
			carrera = DataAccessFactory.forCarreraService().findCarreraById(carrera.carrera_id);
			
			// Inscripcion abierta.
			if(!inscripcionAbierta())
				throw new BusinessDataException("Estas fuera del plazo de inscripción.");
			
			// Checkeo de plazas. 
			if(!hayPlazasLibres())
				throw new BusinessDataException("No hay plazas libres.");			
			
			ps = con.prepareStatement(SqlStatements.SQL_INSCRIBIR_ATLETA);
			ps.setString(1, atleta.email);
			ps.setString(2, carrera.carrera_id);
			ps.setString(3, EstadoInscripcion.PREINSCRITO.label);								
			ps.setString(4, seleccionarCategoria());
			ps.setString(5, fechaActual());

			ps.executeUpdate();

			ps.close();
			con.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	private String seleccionarCategoria() {
		// UNTIL ATHLETE REGISTRATION IS ENABLED
		//atleta.fechaDeNacimiento = new Date(System.currentTimeMillis() - 10000000);
		//////////////////////////////////////////
		int edad = atleta.fechaDeNacimiento.subYears(new DateSqlite().actual()); // Puede no funcionar
		if(edad >= 18 && edad <= 21)
			return CategoriaAtleta.JUNIOR.label;
		else if(edad > 21 && edad <= 29)
			return CategoriaAtleta.SENIOR.label;
		else if(edad > 29 && edad <= 35)
			return CategoriaAtleta.VETERANO_1.label;
		else
			// Si siempre devuelve este, la edad esta mal calculada.
			return CategoriaAtleta.VETERANO_2.label;
		
	}

	private String  fechaActual() {		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(new Date(System.currentTimeMillis()));		
	}

	private boolean hayPlazasLibres() throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement(SqlStatements.SQL_NUMERO_INSCRIPCIONES);
			ps.setString(1, carrera.carrera_id);
			rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println(carrera.plazasMaximas);
				System.out.println(rs.getInt(1));
				if(carrera.plazasMaximas > rs.getInt(1))
					return true;
			}
		} finally {
			rs.close();
			ps.close();
		}
		return false;
	}

	private boolean inscripcionAbierta() {
		CarreraDto carrera_aux = DataAccessFactory.forCarreraService().findCarreraById(carrera.carrera_id);
		if(carrera_aux.cierre.compareTo(new DateSqlite().actual()) >= 0)
			return true;
		else
			return false;
	}

	

}
