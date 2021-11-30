package business.dataaccess.club.comandos;

import java.io.File;
import java.util.List;

import javax.swing.table.TableModel;

import business.dataaccess.dto.AtletaDto;
import business.dataaccess.exception.BusinessDataException;
import business.dataaccess.parsers.LoteAtletaParser;
import business.dataaccess.parsers.TablaAtletasParser;

public class DevolverParticipantesClub {

	private File file;
	private List<AtletaDto> atletas;

	public DevolverParticipantesClub(File file, List<AtletaDto> atletas) {
		this.file = file;
		this.atletas = atletas;
	}

	public TableModel devolverParticipantes() throws BusinessDataException {
		List<AtletaDto> atletasFichero = LoteAtletaParser.parsearAtletas(file);

		for (AtletaDto atletaDto : atletasFichero) {
			atletas.add(atletaDto);
		}
		return TablaAtletasParser.parsearParticipantesTabla(atletas);
	}

}
