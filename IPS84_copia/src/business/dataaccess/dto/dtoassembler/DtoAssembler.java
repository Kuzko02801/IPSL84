package business.dataaccess.dto.dtoassembler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import business.dataaccess.dto.AtletaDto;
import business.dataaccess.dto.carrera.CarreraDto;
import business.dataaccess.dto.carrera.Categoria;
import business.dataaccess.dto.carrera.Periodo;
import business.dataaccess.dto.infoadicional.Genero;
import business.dataaccess.dto.infoadicional.Tipo;
import business.dataaccess.parsers.CategoriaParser;
import business.dataaccess.parsers.PeriodoParser;
import business.dataaccess.util.DateSqlite;

public class DtoAssembler {

	public static AtletaDto forAtletaDto(String email) {
		return forAtletaDto(email, null, null, null, null);
	}
	
	public static AtletaDto forAtletaDto(String email,String dni, String nombre, String fechaDeNacimiento, String genero) {
		AtletaDto atleta = new AtletaDto();	
		atleta.email = email;
		atleta.dni=dni;
		atleta.nombre = nombre;
		atleta.fechaDeNacimiento = new DateSqlite(fechaDeNacimiento);
		atleta.genero = Genero.generoParser(genero);
		return atleta;
	}
	
	
	public static CarreraDto forCarreraDto(String id) {
		return forCarreraDto(null, null, null, "0", id, "0", new ArrayList<Categoria>(), new ArrayList<Periodo>());
	}
	
	public static CarreraDto forCarreraDto(
			String nombre,
			String fecha,
			String tipo,
			String distance,			
			String carrera_id,
			String plazasMaximas,			
			List<Categoria> categorias,
			List<Periodo> periodos) {
		CarreraDto carrera = new CarreraDto();
		carrera.nombre = nombre;
		carrera.fecha = new DateSqlite(fecha);
		carrera.tipo = Tipo.tipoParser(tipo);
		carrera.distancia = Double.valueOf(distance);
		carrera.carrera_id = carrera_id;
		carrera.plazasMaximas = Integer.valueOf(plazasMaximas);
		carrera.periodos = periodos;
		carrera.categorias = categorias;
		return carrera;
	}

	public static CarreraDto toCarreraDto(ResultSet rs) throws SQLException {
		CarreraDto c = new CarreraDto();
		
		c.carrera_id = rs.getString("id");
		c.distancia = rs.getDouble("distancia");
		c.fecha = new DateSqlite(rs.getString("fecha"));
		c.nombre = rs.getString("nombre");
		c.plazasMaximas = rs.getInt("plazasMaximas");
		c.tipo = Tipo.tipoParser(rs.getString("tipo"));
		c.categorias = CategoriaParser.devolverCategorias(rs.getString("categorias"));
		c.periodos = PeriodoParser.devolverPeriodos(rs.getString("periodos"));
		
		return c;
	}
}
