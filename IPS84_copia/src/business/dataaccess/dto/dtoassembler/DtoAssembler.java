package business.dataaccess.dto.dtoassembler;

import business.dataaccess.dto.AtletaDto;
import business.dataaccess.dto.CarreraDto;
import business.dataaccess.dto.infoadicional.EstadoCarrera;
import business.dataaccess.dto.infoadicional.Genero;
import business.dataaccess.dto.infoadicional.Tipo;
import business.dataaccess.util.DateSqlite;

public class DtoAssembler {

	public static AtletaDto forAtletaDto(String email, String nombre, DateSqlite fechaDeNacimiento, Genero genero) {
		AtletaDto atleta = new AtletaDto();	
		atleta.email = email;
		atleta.nombre = nombre;
		atleta.fechaDeNacimiento = fechaDeNacimiento;
		atleta.genero = genero;
		return atleta;
	}
	
	public static CarreraDto forCarreraDto(
			String nombre,
			DateSqlite fecha,
			Tipo tipo,
			double distancia,
			double cuota,
			String carrera_id,
			int plazasMaximas,
			DateSqlite cierre,
			DateSqlite apertura,
			EstadoCarrera estado) {
		CarreraDto carrera = new CarreraDto();
		carrera.nombre = nombre;
		carrera.fecha = fecha;
		carrera.tipo = tipo;
		carrera.distancia = distancia;
		carrera.cuota = cuota;
		carrera.carrera_id = carrera_id;
		carrera.plazasMaximas = plazasMaximas;
		carrera.cierre = cierre;
		carrera.apertura = apertura;
		return carrera;
	}
}
