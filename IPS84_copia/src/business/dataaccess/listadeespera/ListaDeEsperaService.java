package business.dataaccess.listadeespera;

import business.dataaccess.exception.BusinessDataException;

public interface ListaDeEsperaService {

	int numeroDeListaEspera(String id_carrera) throws BusinessDataException;
}
