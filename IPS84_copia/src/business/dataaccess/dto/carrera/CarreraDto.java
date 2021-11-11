package business.dataaccess.dto.carrera;


import java.util.List;

import business.dataaccess.dto.infoadicional.Tipo;
import business.dataaccess.util.DateSqlite;

public class CarreraDto {
	public String nombre;
	public DateSqlite fecha;
	public Tipo tipo;	
	public double distancia;	
	public String carrera_id;
	public int plazasMaximas;
	public List<Periodo> periodos;
	public List<Categoria> categorias;
}
