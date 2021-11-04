package business.dataaccess.organizador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ProcesarPagos {

	public static void procesarArchivoDePagos(String fileName) {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;

		try {
			archivo = new File(fileName);
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);

			String linea;
			int nLinea = 0;
			String idCarrera = "";
			while ((linea = br.readLine()) != null) {
				if (nLinea == 0) {
					idCarrera = linea;
				}
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != fr) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
