package business.dataaccess;

import business.dataaccess.atleta.comandos.AtletaServiceImpl;


public class DataAccessFactory {

	public static AtletaServiceImpl forAtletaService() {
		return new AtletaServiceImpl();
	}
	
	
}
