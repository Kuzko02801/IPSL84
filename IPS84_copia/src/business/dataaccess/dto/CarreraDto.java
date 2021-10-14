package business.dataaccess.dto;


import java.sql.Date;

import business.dataaccess.dto.infoadicional.EstadoCarrera;
import business.dataaccess.dto.infoadicional.Tipo;

public class CarreraDto {
	public String nombre;
	public Date fecha;
	public Tipo tipo;
	public EstadoCarrera estado;
	public double distancia;
	public double cuota;
	public String carrera_id;
	public int plazasMaximas;
	public Date cierre;
	public Date apertura;
}
