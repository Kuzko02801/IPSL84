package business.dataaccess.dto.pago;

public class HistorialPago {

	private String id_carrera;
	private String email_atleta;
	private String cantidad;
	private String comentario;
	private String cuota;	

	public HistorialPago(String id_carrera, String email_atleta, String cuota, String cantidad, String comentario) {
		this.id_carrera = id_carrera;
		this.email_atleta = email_atleta;
		this.cantidad = cantidad;
		this.cuota = cuota;
		this.comentario = comentario;
	}
	
	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public String getCuota() {
		return cuota;
	}

	public void setCuota(String cuota) {
		this.cuota = cuota;
	}

	public String getId_carrera() {
		return id_carrera;
	}

	public void setId_carrera(String id_carrera) {
		this.id_carrera = id_carrera;
	}

	public String getEmail_atleta() {
		return email_atleta;
	}

	public void setEmail_atleta(String email_atleta) {
		this.email_atleta = email_atleta;
	}

	public String getCantidad() {
		return cantidad;
	}

	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}
	
	@Override
	public String toString() {
		return id_carrera + ";" + email_atleta + ";" + cantidad; 
	}
}
