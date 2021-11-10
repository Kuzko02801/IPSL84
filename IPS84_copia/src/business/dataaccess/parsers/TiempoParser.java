package business.dataaccess.parsers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import business.dataaccess.exception.BusinessDataException;

public class TiempoParser {

	
	//TODO se pueden hacer mejoras: si la linea no esta bien escrita la salta y sigue parseando las demas
	
	public static ArrayList<String> parsearTiempos(File tiempos) throws BusinessDataException {
		ArrayList<String> result = new ArrayList<String>();
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(tiempos)));
			String line;
			int linea = 0;
			while ((line = br.readLine()) != null) {
				
				linea++;
				String[] args = line.split(";");
				if (args.length != 3) {
					throw new BusinessDataException("La linea" + linea + " no esta bien escrita");
				}
				int t1=Integer.parseInt(args[0]);
				if (args[1].trim().length() == 0) {
					throw new BusinessDataException("La linea" + linea + " no esta bien escrita");
				}
				Integer.parseInt(args[1]);
				if (args[2].trim().length() != 0) {
					Integer.parseInt(args[2]);
				}
				int t2=Integer.parseInt(args[2]);
				if(t2-t1<=0) {
					throw new BusinessDataException("La linea" + linea + " contiene un error");
				}
				result.add(line);
			}

		} catch (Exception e) {
			throw new BusinessDataException("Ha habido un problema cargando el fichero de tiempos");
		}
		return result;
	}
}
