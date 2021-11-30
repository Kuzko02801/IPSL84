package business.dataaccess.club.comandos;

import java.io.File;
import java.util.List;

import javax.swing.table.TableModel;

import business.dataaccess.club.ClubService;
import business.dataaccess.dto.AtletaDto;
import business.dataaccess.exception.BusinessDataException;

public class ClubServiceImpl implements ClubService{

	@Override
	public TableModel devolverParticipantesClub(File file, List<AtletaDto> atletas) throws BusinessDataException {
		return new DevolverParticipantesClub(file,atletas).devolverParticipantes();
	}

}
