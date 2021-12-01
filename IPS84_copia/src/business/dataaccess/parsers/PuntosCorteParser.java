package business.dataaccess.parsers;

import java.util.ArrayList;
import java.util.List;

import business.dataaccess.exception.BusinessDataException;
import gui.validadoresGUI.Validadores;

public class PuntosCorteParser {

	public static int devolverNumeroPuntosCorte(String texto) throws BusinessDataException {
		String[] partes = texto.split(";");
		for (String s : partes) {
			if (!Validadores.comprobarMayorNumero(s, 1)) {
				throw new BusinessDataException("Ha habido un problema con la base de datos");
			}
		}
		return partes.length;
	}

	public static List<Integer> devolverPuntosCorte(String texto) throws BusinessDataException {
		List<Integer> puntosCorte = new ArrayList<>();
		if (texto == null || texto.equals("no-puntoscorte")) {
			return puntosCorte;
		}

		String[] partes = texto.split(";");
		for (String s : partes) {
			if (!Validadores.comprobarMayorNumero(s, 1)) {
				throw new BusinessDataException("Ha habido un problema con la base de datos");
			}
			puntosCorte.add(Integer.parseInt(s));
		}

		return puntosCorte;
	}

	public static String puntosCorteToString(List<Integer> puntosCorte) {
		if (puntosCorte.isEmpty())
			return "no-puntoscorte";
		String a = "";
		for (Integer integer : puntosCorte) {
			a += integer + ";";
		}
		return a.substring(0, a.length() - 1);
	}

}
