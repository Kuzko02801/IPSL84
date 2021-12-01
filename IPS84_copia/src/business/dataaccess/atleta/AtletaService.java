package business.dataaccess.atleta;

import business.dataaccess.dto.AtletaDto;
import business.dataaccess.exception.BusinessDataException;

public interface AtletaService {

	public void inscribirAtleta(String carrera_id, String email_atleta) throws BusinessDataException;
	public AtletaDto encontrarAtleta(String email) throws BusinessDataException;
	public void atletaAdd(AtletaDto atleta)  throws BusinessDataException;
	public boolean existeAtleta(String email) throws BusinessDataException;
}
