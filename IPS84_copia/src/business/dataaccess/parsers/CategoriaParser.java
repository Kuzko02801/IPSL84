package business.dataaccess.parsers;

import java.util.ArrayList;
import java.util.List;

import business.dataaccess.dto.carrera.Categoria;

public class CategoriaParser {
	
	public static List<Categoria> devolverCategorias(String texto) {
		List<Categoria> categorias = new ArrayList<>();
		String [] partes = texto.split(";");
		
		for (String s: partes) {
			String [] args = s.split(",");
			String tipo = args[0];
			int edadMinima = Integer.valueOf(args[1]);
			int edadMaxima = Integer.valueOf(args[2]);
			
			categorias.add(new Categoria(tipo, edadMinima, edadMaxima));
		}
		
		return categorias;
	}
	
	public static String categoriasToString(List<Categoria> categorias) {
		  StringBuilder result = new StringBuilder();

	        for(Categoria categoria : categorias) {
	            result.append(categoria.getTipo());
	            result.append(",");
	            result.append(categoria.getEdadMinima());
	            result.append(",");
	            result.append(categoria.getEdadMaxima());
	            result.append(";");
	        }

	        return result.toString();
	}
}
