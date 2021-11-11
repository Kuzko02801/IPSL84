package business.dataaccess.atleta.comandos;
import business.dataaccess.atleta.AtletaService;
import business.dataaccess.dto.AtletaDto;
import business.dataaccess.exception.BusinessDataException;

public class AtletaServiceImpl implements AtletaService{
			
	@Override
	public void inscribirAtleta(String id, String email) throws BusinessDataException {
		new AtletaInscripcion(id, email).inscribirAtleta();
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
