package business.dataaccess;

import business.dataaccess.atleta.comandos.AtletaServiceImpl;


public class DataAcessFactory {

	public static AtletaServiceImpl inscribir() {
		return new AtletaServiceImpl();
	}
	
	
}
