package business.dataaccess.dto.dtoassembler;

import business.dataaccess.dto.AtletaDto;
import business.dataaccess.dto.CarreraDto;
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
			String distancia,
			String cuota,
			String carrera_id,
			String plazasMaximas,
			String cierre,
			String apertura,
			String estado) {
		CarreraDto carrera = new CarreraDto();
		carrera.nombre = nombre;
		carrera.fecha = new DateSqlite(fecha);
		carrera.tipo = Tipo.tipoParser(tipo);
		carrera.distancia = Double.parseDouble(distancia);
		carrera.cuota = Double.parseDouble(cuota);
		carrera.apertura = new DateSqlite(apertura);
		carrera.cierre = new DateSqlite(cierre);
		carrera.carrera_id = carrera_id;
		carrera.plazasMaximas = Integer.parseInt(plazasMaximas);
		carrera.estado=EstadoCarrera.estadoParser(estado);
		return carrera;
	}
}
