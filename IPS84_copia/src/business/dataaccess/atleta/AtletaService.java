package business.dataaccess.atleta;

import java.io.File;

import business.dataaccess.dto.AtletaDto;
import business.dataaccess.exception.BusinessDataException;

public interface AtletaService {

	public void inscribirAtleta(String carrera_id, String email_atleta) throws BusinessDataException;
	public AtletaDto encontrarAtleta(String email);
	public void atletaAdd(AtletaDto atleta)  throws BusinessDataException;
	public boolean existeAtleta(String email) throws BusinessDataException;
	public void inscribirClub(File ficheroAtleta);
}
