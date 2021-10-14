package business.dataaccess.atleta.comandos;
import business.dataaccess.atleta.AtletaService;
import business.dataaccess.dto.AtletaDto;
import business.dataaccess.dto.CarreraDto;

public class AtletaServiceImpl implements AtletaService{
			
	@Override
	public void inscribirAtleta(AtletaDto atleta, CarreraDto carrera) {
		new AtletaInscripcion(atleta, carrera).inscribirAtleta();
	}


}
