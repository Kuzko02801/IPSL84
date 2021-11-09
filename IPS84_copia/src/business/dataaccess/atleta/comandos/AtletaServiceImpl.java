package business.dataaccess.atleta.comandos;
import business.dataaccess.atleta.AtletaService;
import business.dataaccess.dto.AtletaDto;
import business.dataaccess.dto.carrera.CarreraDto;
import business.dataaccess.exception.BusinessDataException;

public class AtletaServiceImpl implements AtletaService{
			
	@Override
	public void inscribirAtleta(AtletaDto atleta, CarreraDto carrera) throws BusinessDataException {
		new AtletaInscripcion(atleta, carrera).inscribirAtleta();
	}

	@Override
	public AtletaDto encontrarAtleta(String email) {
		return new EncontrarAtleta(email).encontrarAtleta();
	}

	@Override
	public void atletaAdd(AtletaDto atleta) throws BusinessDataException {
		new AtletaAdd(atleta).atletaAdd();
		
	}

	@Override
	public boolean existeAtleta(String email) throws BusinessDataException {
		return new ExisteAtleta(email).existeAtleta();
		
	}
}
