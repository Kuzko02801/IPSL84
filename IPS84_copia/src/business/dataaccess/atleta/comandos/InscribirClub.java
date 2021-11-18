package business.dataaccess.atleta.comandos;

import java.io.File;
import java.util.ArrayList;

import business.dataaccess.DataAccessFactory;
import business.dataaccess.dto.AtletaDto;
import business.dataaccess.dto.carrera.CarreraDto;
import business.dataaccess.dto.dtoassembler.DtoAssembler;
import business.dataaccess.exception.BusinessDataException;
import business.dataaccess.parsers.TiempoParser;
import business.dataaccess.util.Check;

public class InscribirClub {

	private File ficheroAtletas;
	public InscribirClub(File ficheroAtletas) {
		this.ficheroAtletas=ficheroAtletas;
	}

	public void inscribirClub() {
		String idCarrera=LoteAtletasParser.parsearIdCarrera(ficheroAtletas);
		if(idCarrera==null) {
			throw new BusinessDataException("El fichero de atletas esta corrupto");
		}
		if(!Check.raceExists(idCarrera)) {
			throw new BusinessDataException("La carrera a la que se quiere inscribir no existe");
		}
		CarreraDto carrera=DataAccessFactory.forCarreraService().findCarreraById(idCarrera);
		if(!Check.checkCarreraAbierta(carrera.periodos)) {
			throw new BusinessDataException("La carrera no tiene plazos de inscripción abiertos");
		}
		
		ArrayList<AtletaDto> listaAtletas = LoteAtletasParser.parsearAtletas(ficheroAtletas);
		int numeroDeAtletas=listaAtletas.size();
		if(!Check.hayPlazasLibres(numeroDeAtletas, carrera)) {
			throw new BusinessDataException("La carrera no tiene plazas para tantos atletas");
		}
		
		//TODO aqui ya esta comprobado que se puedan inscribir, 
		//osea que por cada atleta lo registramos y lo inscribimos con atletaAdd. Depende de como quiera claudio lo
		//de registrarlos si alguno no puede :D.
		
	}

}
