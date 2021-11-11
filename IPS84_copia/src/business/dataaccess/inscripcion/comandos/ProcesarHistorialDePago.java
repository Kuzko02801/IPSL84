package business.dataaccess.inscripcion.comandos;

import business.dataaccess.dto.pago.HistorialPago;
import business.dataaccess.parsers.HistorialSerializer;

public class ProcesarHistorialDePago {

	private String id_carrera;
	private String email_atleta;
	private String cantidad;

	public ProcesarHistorialDePago(String id_carrera, String email_atleta, String cantidad) {		
		this.id_carrera = id_carrera;
		this.email_atleta = email_atleta;
		this.cantidad = cantidad;
	}
	
	public void procesarPagos() {		
		HistorialPago hp = new HistorialPago(id_carrera, email_atleta, cantidad);		
		try {			
			HistorialSerializer.serializarPagos(hp);
		} catch (Exception e) {			
			e.printStackTrace();
		}
	}
}
