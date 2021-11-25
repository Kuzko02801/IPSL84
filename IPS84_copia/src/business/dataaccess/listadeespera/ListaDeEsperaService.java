package business.dataaccess.listadeespera;

import business.dataaccess.exception.BusinessDataException;

public interface ListaDeEsperaService {

	int numeroDeListaEspera(String id_carrera) throws BusinessDataException;
	void meterseEnListaDeEspera(String id_carrera, String email);
}
