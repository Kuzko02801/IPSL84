package business.dataaccess.listadeespera.comandos;

import business.dataaccess.exception.BusinessDataException;
import business.dataaccess.listadeespera.ListaDeEsperaService;

public class ListaDeEsperaServiceImpl implements ListaDeEsperaService {

	@Override
	public int numeroDeListaEspera(String id_carrera) throws BusinessDataException {
		return new NumeroDeListaEspera(id_carrera).execute();
	}
	
	@Override
	public void meterseEnListaDeEspera(String id_carrera, String email) {
		new MeterseEnListaDeEspera(id_carrera, email).execute();
		
	}

}
