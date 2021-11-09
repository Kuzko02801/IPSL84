package business.dataaccess.dto.carrera;

import business.dataaccess.util.Check;
import business.dataaccess.util.DateSqlite;

public class Periodo {
		
	private DateSqlite fechaInicio;
	private DateSqlite fechaFin;
	private double cuota;

	public Periodo(DateSqlite fechaInicio, DateSqlite fechaFin, double cuota){
		Check.isNotNull(fechaInicio, "La fecha de inicio no puede ser nula.");
		Check.isNotNull(fechaInicio, "La fecha de inicio no puede ser nula.");
		Check.isNotNull(fechaFin, "La fecha de final no puede ser nula.");
		Check.isTrue(cuota > 0, "La cuota debe ser mayor que 0.");
		
		this.fechaInicio = fechaInicio;
		this.cuota = cuota;
	}

	public DateSqlite getFechaInicio() {
		return fechaInicio;
	}

	public void setFecha(DateSqlite fecha) {
		this.fechaInicio = fecha;
	}

	public double getCuota() {
		return cuota;
	}

	public void setCuota(double cuota) {
		this.cuota = cuota;
	}

	public DateSqlite getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(DateSqlite fechaFin) {
		this.fechaFin = fechaFin;
	}	
}
