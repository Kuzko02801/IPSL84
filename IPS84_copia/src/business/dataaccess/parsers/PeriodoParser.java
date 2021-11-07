package business.dataaccess.parsers;

import java.util.ArrayList;
import java.util.List;

import business.dataaccess.dto.carrera.Periodo;
import business.dataaccess.util.DateSqlite;

public class PeriodoParser {
	
	public static List<Periodo> devolverPeriodos (String texto) {
		
		List<Periodo> periodos = new ArrayList<>();
		String [] partes = texto.split(";");
		
		for (String s: partes) {
			String [] args = s.split(",");
			String fechaInicio = args[0];
			String fechaFin = args[1];
			double cuota = Double.valueOf(args[2]);
			
			periodos.add(new Periodo(new DateSqlite(fechaInicio), new DateSqlite(fechaFin), cuota));
		}
		
		return periodos;
	}
	
}
