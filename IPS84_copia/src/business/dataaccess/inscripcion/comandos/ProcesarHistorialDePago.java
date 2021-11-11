package business.dataaccess.inscripcion.comandos;

import business.dataaccess.dto.pago.HistorialPago;
import business.dataaccess.parsers.HistorialSerializer;

public class ProcesarHistorialDePago {

	private String id_carrera;
	private String email_atleta;
	private String cantidad;
	private String comentario;
	private String cuota;

	public ProcesarHistorialDePago(String id_carrera, String email_atleta, String cuota, String cantidad, String comentario) {		
		this.id_carrera = id_carrera;
		this.email_atleta = email_atleta;
		this.cantidad = cantidad;
		this.cuota = cuota;
		this.comentario = comentario;
	}
	
	public void procesarPagos() {		
		HistorialPago hp = new HistorialPago(id_carrera, email_atleta, cuota, cantidad, comentario);		
		try {			
			HistorialSerializer.serializarPagos(hp);
		} catch (Exception e) {			
			e.printStackTrace();
		}
	}
}
