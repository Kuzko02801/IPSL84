package business.dataaccess.carrera.comandos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import business.dataaccess.BusinessDataException;
import business.dataaccess.datainformation.SqlStatements;
import business.dataaccess.datainformation.SqliteConnectionInfo;
import business.dataaccess.dto.carrera.CarreraDto;
import business.dataaccess.dto.carrera.Categoria;
import business.dataaccess.dto.carrera.Periodo;
import business.dataaccess.dto.infoadicional.EstadoCarrera;
import business.dataaccess.parsers.CategoriaParser;
import business.dataaccess.parsers.PeriodoParser;


public class CrearCarrera {
	private CarreraDto carrera;
	public CrearCarrera(CarreraDto carrera) {
		this.carrera=carrera;
	}
	public void crearCarrera() throws BusinessDataException {

		// Checar si los periodos son validos.
		checkPeriods(carrera.periodos);
		
		// Checar las categorias.
		checkCategories(carrera.categorias);
		
		try {
			DriverManager.registerDriver(new org.sqlite.JDBC());
		} catch (SQLException e1) {
			System.out.println("Ha fallado el register del driver");
		}
		PreparedStatement ps = null;
		Connection con= null;
		String id = null;
		try {
			con = DriverManager.getConnection(SqliteConnectionInfo.URL);
			
			ps = con.prepareStatement(SqlStatements.SQL_INSERT_CARRERA);
						
			id = UUID.randomUUID().toString().substring(0, 6);
			ps.setString(1, carrera.nombre);
			ps.setString(2, carrera.fecha.toString());
			ps.setString(3, carrera.tipo.label);
			ps.setDouble(4, carrera.distancia);			
			ps.setString(5, id);
			ps.setInt(6, carrera.plazasMaximas);			
			// Insertar categorias.
			ps.setString(7, CategoriaParser.categoriasToString(carrera.categorias));
			// Insertar periodos.
			ps.setString(8, PeriodoParser.periodosToString(carrera.periodos));						
			
			ps.execute();
			
			ps.close();
			con.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	private void checkCategories(List<Categoria> categorias) throws BusinessDataException {
		
		for(Categoria pivote : categorias) {			
			for(Categoria categoria : categorias) {
				if(!categoria.equals(pivote)) {
					if(pivote.getEdadMinima() > categoria.getEdadMinima()
							&& pivote.getEdadMinima() < categoria.getEdadMaxima()
							|| pivote.getEdadMaxima() > categoria.getEdadMinima()
							&& pivote.getEdadMaxima() < categoria.getEdadMaxima()) {
						throw new BusinessDataException("Las edades de las categorias no se pueden solapar.");
					}
				}
			}
		}
		
	}

	private void checkPeriods(List<Periodo> periodos) throws BusinessDataException {
				
		for(Periodo pivote : periodos) {
			if(pivote.getFechaInicio().isAfter(carrera.fecha)
					|| pivote.getFechaFin().isAfter(carrera.fecha)) {
				throw new BusinessDataException("Las fechas de inicio y fin deben ser antes del inicio de la carrera.");	
			}
			
			for(Periodo periodo : periodos) {
				if(!periodo.equals(pivote)) {
					/**
					 * Tira BusinessException si alguna de las fechas
					 * del pivote esta solapada con las del periodo.
					 */ 
					if(pivote.getFechaInicio().isAfter(periodo.getFechaInicio())
							&& pivote.getFechaInicio().isBefore(periodo.getFechaFin())
							|| pivote.getFechaFin().isAfter(periodo.getFechaInicio())
							&& pivote.getFechaFin().isBefore(periodo.getFechaFin())) {
						throw new BusinessDataException("Las fechas no se pueden solapar.");
					}					
				}
			}
		}
	}
}
