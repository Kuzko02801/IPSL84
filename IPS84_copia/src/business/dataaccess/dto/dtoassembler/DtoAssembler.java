package business.dataaccess.dto.dtoassembler;

import java.util.List;

import business.dataaccess.dto.AtletaDto;
import business.dataaccess.dto.carrera.CarreraDto;
import business.dataaccess.dto.carrera.Categoria;
import business.dataaccess.dto.carrera.Periodo;
import business.dataaccess.dto.infoadicional.EstadoCarrera;
import business.dataaccess.dto.infoadicional.Genero;
import business.dataaccess.dto.infoadicional.Tipo;
import business.dataaccess.util.DateSqlite;

public class DtoAssembler {

	public static AtletaDto forAtletaDto(String email,String dni, String nombre, String fechaDeNacimiento, String genero) {
		AtletaDto atleta = new AtletaDto();	
		atleta.email = email;
		atleta.dni=dni;
		atleta.nombre = nombre;
		atleta.fechaDeNacimiento = new DateSqlite(fechaDeNacimiento);
		atleta.genero = Genero.generoParser(genero);
		return atleta;
	}
	
	public static CarreraDto forCarreraDto(
			String nombre,
			String fecha,
			String tipo,
			String distance,			
			String carrera_id,
			String plazasMaximas,			
			String estado,
			List<Categoria> categorias,
			List<Periodo> periodos) {
		CarreraDto carrera = new CarreraDto();
		carrera.nombre = nombre;
		carrera.fecha = new DateSqlite(fecha);
		carrera.tipo = Tipo.tipoParser(tipo);
		carrera.distancia = Double.valueOf(distance);
		carrera.carrera_id = carrera_id;
		carrera.plazasMaximas = Integer.valueOf(plazasMaximas);
		carrera.estado=EstadoCarrera.estadoParser(estado);
		carrera.periodos = periodos;
		carrera.categorias = categorias;
		return carrera;
	}
}
