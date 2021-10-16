package business.dataaccess.dto;

import business.dataaccess.dto.infoadicional.Genero;
import business.dataaccess.util.DateSqlite;

public class AtletaDto {	
	public String email;
	public String nombre;
	public DateSqlite fechaDeNacimiento;
	public Genero genero;
}
