package business.dataaccess.parsers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import business.dataaccess.exception.BusinessDataException;

public class TiempoParser {

	// TODO se pueden hacer mejoras: si la linea no esta bien escrita la salta y
	// sigue parseando las demas

	public static String parsearIdCarrera(File tiempos) throws BusinessDataException {
		String id = null;
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(tiempos)));
			id = br.readLine();
			br.close();
		} catch (Exception e) {
			throw new BusinessDataException("Ha habido un problema leyendo el fichero");
		}
		if (id == null || id.trim().length() == 0) {
			throw new BusinessDataException("El fichero está corrupto");
		}
		return id;

	}

	@SuppressWarnings("resource")
	public static List<List<String>> parsearTiempos(File tiempos, int numeroPuntosCorte) throws BusinessDataException {
		ArrayList<List<String>> result = new ArrayList<List<String>>();
		BufferedReader br;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(tiempos)));
			br.readLine();
			String line;
			int linea = 0;
			while ((line = br.readLine()) != null) {
				linea++;
				String[] args = line.split(";");

				if (args.length != numeroPuntosCorte + 3) {
					throw new BusinessDataException(
							"El archivo esta corrupto en la linea " + linea + ", el numero de campos es incorrecto.");
				}
				for (int i = 0; i < args.length; i++) {
					if (!args[i].equals("-")) {
						try {
							Integer.parseInt(args[i]);
						} catch (Exception e) {
							throw new BusinessDataException("El archivo esta corrupto en la linea" + linea);
						}
					}

				}
				ArrayList<String> aux = new ArrayList<String>(); // cada linea
				aux.add(args[0]); // dorsal
				aux.add(args[1]); // tiempoInicio
				aux.add(args[args.length - 1]); // tiempoFin
				String auxString = "";
				for (int i = 2; i < args.length - 1; i++) {
					auxString += args[i] + ";";
				}
				auxString.substring(0, auxString.length() - 1); // tiemposCorte
				aux.add(auxString);
				result.add(aux);
			}
			br.close();
		} catch (FileNotFoundException e) {
			throw new BusinessDataException("No se ha encontrado el archivo");
		} catch (IOException e) {
			throw new BusinessDataException("El archivo esta corrupto");
		}
		return result;
	}
}
