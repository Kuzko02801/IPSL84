package business.dataaccess.atleta;

import business.dataaccess.BusinessDataException;
import business.dataaccess.dto.AtletaDto;
import business.dataaccess.dto.CarreraDto;

public interface AtletaService {

	public void inscribirAtleta(AtletaDto atleta, CarreraDto carrera) throws BusinessDataException;
	public AtletaDto encontrarAtleta(String email);
}
