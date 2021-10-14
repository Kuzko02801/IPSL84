package business.dataaccess;

import business.dataaccess.atleta.comandos.AtletaServiceImpl;
import business.dataaccess.carrera.comandos.CarreraServiceImpl;
import business.dataaccess.inscripcion.comandos.InscripcionServiceImpl;


public class DataAccessFactory {

	public static AtletaServiceImpl forAtletaService() {
		return new AtletaServiceImpl();
	}
	
	public static CarreraServiceImpl forCarreraService() {
		return new CarreraServiceImpl();
	}	
	
	public static InscripcionServiceImpl forInscripcionService() {
		return new InscripcionServiceImpl();
	}	
}
