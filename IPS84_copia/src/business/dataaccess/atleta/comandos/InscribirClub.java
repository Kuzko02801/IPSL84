package business.dataaccess.atleta.comandos;

import java.io.File;
import java.util.ArrayList;
import business.dataaccess.DataAccessFactory;
import business.dataaccess.dto.AtletaDto;
import business.dataaccess.dto.carrera.CarreraDto;
import business.dataaccess.exception.BusinessDataException;
import business.dataaccess.parsers.LoteAtletaParser;
import business.dataaccess.util.Check;

public class InscribirClub {

	private File ficheroAtletas;

	public InscribirClub(File ficheroAtletas) {
		this.ficheroAtletas = ficheroAtletas;
	}

	public void inscribirClub() throws BusinessDataException {
		String idCarrera = LoteAtletaParser.parsearIdCarrera(ficheroAtletas);
		if (idCarrera == null) {
			throw new BusinessDataException("El fichero de atletas esta corrupto");
		}
		if (!Check.raceExists(idCarrera)) {
			throw new BusinessDataException("La carrera a la que se quiere inscribir no existe");
		}
		CarreraDto carrera = DataAccessFactory.forCarreraService().findCarreraById(idCarrera);
		if (!Check.checkCarreraAbierta(carrera.periodos)) {
			throw new BusinessDataException("La carrera no tiene plazos de inscripción abiertos");
		}

		ArrayList<AtletaDto> listaAtletas = LoteAtletaParser.parsearAtletas(ficheroAtletas);
		int numeroDeAtletas = listaAtletas.size();
		if (!Check.hayPlazasLibres(numeroDeAtletas, carrera)) {
			throw new BusinessDataException("La carrera no tiene plazas para tantos atletas");
		}

		for (AtletaDto atletaDto : listaAtletas) {
			DataAccessFactory.forAtletaService().atletaAdd(atletaDto);
			DataAccessFactory.forAtletaService().inscribirAtleta(idCarrera, atletaDto.email);
		}

	}

}
