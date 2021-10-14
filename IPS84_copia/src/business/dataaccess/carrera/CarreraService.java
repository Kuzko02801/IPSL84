package business.dataaccess.carrera;

import javax.swing.table.TableModel;

import business.dataaccess.BusinessDataException;
import business.dataaccess.dto.AtletaDto;
import business.dataaccess.dto.CarreraDto;

public interface CarreraService {
	public void crearCarrera(AtletaDto atleta, CarreraDto carrera) throws BusinessDataException;
	public TableModel tablaCarreras();
}
