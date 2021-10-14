package business.dataaccess.carrera.comandos;

import javax.swing.table.TableModel;

import business.dataaccess.BusinessDataException;
import business.dataaccess.atleta.comandos.AtletaInscripcion;
import business.dataaccess.carrera.CarreraService;
import business.dataaccess.dto.AtletaDto;
import business.dataaccess.dto.CarreraDto;

public class CarreraServiceImpl implements CarreraService{


	@Override
	public TableModel devolverCarrerasPropiasParticipante() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TableModel devolverCarrerasValidas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TableModel devolverCarrerasOrganizador() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void crearCarrera(CarreraDto carrera) {
		new CrearCarrera(carrera).crearCarrera();		
	}

	
}
