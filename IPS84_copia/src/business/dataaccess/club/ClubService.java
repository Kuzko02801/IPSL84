package business.dataaccess.club;

import java.io.File;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.TableModel;

import business.dataaccess.dto.AtletaDto;
import business.dataaccess.exception.BusinessDataException;

public interface ClubService {
	
	public TableModel devolverParticipantesClub(File file,List<AtletaDto> atletas) throws BusinessDataException;

}
