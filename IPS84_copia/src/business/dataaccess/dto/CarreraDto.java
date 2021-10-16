package business.dataaccess.dto;


import business.dataaccess.dto.infoadicional.EstadoCarrera;
import business.dataaccess.dto.infoadicional.Tipo;
import business.dataaccess.util.DateSqlite;

public class CarreraDto {
	public String nombre;
	public DateSqlite fecha;
	public Tipo tipo;
	public EstadoCarrera estado;
	public double distancia;
	public double cuota;
	public String carrera_id;
	public int plazasMaximas;
	public DateSqlite cierre;
	public DateSqlite apertura;
}
