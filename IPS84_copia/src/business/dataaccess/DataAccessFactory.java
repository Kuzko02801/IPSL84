package business.dataaccess;

import business.dataaccess.atleta.comandos.AtletaServiceImpl;
import business.dataaccess.carrera.comandos.CarreraServiceImpl;


public class DataAccessFactory {

	public static AtletaServiceImpl forAtletaService() {
		return new AtletaServiceImpl();
	}
	
	public static CarreraServiceImpl forCarreraService() {
		return new CarreraServiceImpl();
	}	
}
