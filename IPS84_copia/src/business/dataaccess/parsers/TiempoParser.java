package business.dataaccess.parsers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import business.dataaccess.exception.BusinessDataException;

public class TiempoParser {

	// TODO se pueden hacer mejoras: si la linea no esta bien escrita la salta y
	// sigue parseando las demas

	public static ArrayList<String> parsearTiempos(File tiempos) throws BusinessDataException {
		ArrayList<String> result = new ArrayList<String>();
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(tiempos)));
			String line;
			int linea = 0;
			while ((line = br.readLine()) != null) {
				linea++;
				String[] args = line.split(";");
				if (args.length == 2) {
					comprobarPrimerosCampos(args, linea);
					
				} else if (args.length == 3) {
					comprobarPrimerosCampos(args, linea);
					int t1 = Integer.parseInt(args[1]);
					int t2 = Integer.parseInt(args[2]);
					if (t2 - t1 <= 0) {
						throw new BusinessDataException("La linea" + linea + " contiene un error");
					}
				} else {
					throw new BusinessDataException("El archivo está corrupto");
				}
				
				result.add(line);
			}
			br.close();
		} catch (Exception e) {
			throw new BusinessDataException("El archivo esta corrupto");
		}

		return result;

	}

	private static void comprobarPrimerosCampos(String[] args, int linea) {
		try {
			Integer.parseInt(args[0]);
			Integer.parseInt(args[1]);
		} catch (Exception e) {
			System.out.println("La linea" + linea + " no esta bien escrita");
		}

	}
}
