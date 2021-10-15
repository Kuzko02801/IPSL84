package business.dataaccess.carrera.comandos;

import javax.swing.table.TableModel;

import business.dataaccess.carrera.CarreraService;
import business.dataaccess.dto.CarreraDto;

public class CarreraServiceImpl implements CarreraService{


	@Override
	public TableModel devolverCarrerasPropiasParticipante() {
		return new DevolverCarrerasPropiasParticipante().devolverCarreras();
	}

	@Override
	public TableModel devolverCarrerasValidas() {
		return new DevolverCarrerasValidas().devolverCarreras();
	}

	@Override
	public TableModel devolverCarrerasOrganizador() {
		return new DevolverCarrerasOrganizador().devolverCarreras();
	}
	
	@Override
	public void crearCarrera(CarreraDto carrera) {
		new CrearCarrera(carrera).crearCarrera();		
	}

	@Override
	public boolean existeCarrera(String id) {
		return new ExisteCarrera(id).existeCarrera();
	}
	
	@Override
	public TableModel devolverClasificacionAbsoluta(String id) {
		return new DevolverClasificacionAbsoluta(id).devolverClasificacionAbsoluta();
	}

	@Override
	public TableModel devolverClasificacionFemenina(String id) {
		return new DevolverClasificacionFemenina(id).devolverClasificacionFemenina();
	}

	@Override
	public TableModel devolverClasificacionMasculina(String id) {
		return new DevolverClasificacionMasculina(id).devolverClasificacionMasculina();
	}
	
}
