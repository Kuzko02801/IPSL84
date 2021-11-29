package business.dataaccess.carrera.comandos;

import business.dataaccess.DataAccessFactory;
import business.dataaccess.dto.carrera.CarreraDto;
import business.dataaccess.exception.BusinessDataException;

public class PorcentajeADevolver {

	private String id_carrera;

	public PorcentajeADevolver(String id_carrera) {
		this.id_carrera = id_carrera;
	}

	public Double execute() throws BusinessDataException {
		CarreraDto carrera = DataAccessFactory.forCarreraService().findCarreraById(id_carrera);
		return carrera.porcentajeADevolver;
	}

}
