package gui.validadoresGUI;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import business.gui.CarreraManager;

public class Validadores {

	final static String DATE_FORMAT = "yyyy/MM/dd";
	final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);

	public static boolean comprobarFechasValidas(String fechaCarrera, String fechaApertura, String fechaCierre) {
		LocalDate carrera = null;
		LocalDate apertura = null;
		LocalDate cierre = null;
		try {
			carrera = LocalDate.parse(fechaCarrera, formatter);
			apertura = LocalDate.parse(fechaApertura, formatter);
			cierre = LocalDate.parse(fechaCierre, formatter);

		} catch (DateTimeParseException e) {
			return false;
		}
		if (!carrera.isAfter(cierre) || !apertura.isBefore(cierre)) {
			return false;
		}
		return true;
	}

	public static boolean comprobarFechasValidas(String fechaCarrera, LocalDate apertura, LocalDate cierre) {
		LocalDate carrera = null;
		try {
			carrera = LocalDate.parse(fechaCarrera, formatter);

		} catch (DateTimeParseException e) {
			return false;
		}
		if (!carrera.isAfter(cierre) || !apertura.isBefore(cierre)) {
			return false;
		}
		return true;
	}

	public static final boolean comprobarEmail(String email) {
		if (!comprobarNoVacio(email)) {
			return false;
		}
		boolean result = true;
		try {
			InternetAddress emailAddr = new InternetAddress(email);
			emailAddr.validate();
		} catch (AddressException ex) {
			result = false;
		}
		return result;
	}

	public static boolean comprobarNoVacio(String string) {
		if (string == null) {
			return false;
		}
		if (string.trim().isEmpty()) {
			return false;
		}
		return true;
	}

	public static boolean comprobarFecha(String fecha) {

		try {
			LocalDate.parse(fecha, formatter);
			return true;
		} catch (DateTimeParseException e) {
			return false;
		}
	}

	public static boolean comprobarMayorNumero(String string, int Numero) {
		Double d = null;
		Integer i = null;

		try {
			d = Double.valueOf(string);
			return d > Numero;
		} catch (NumberFormatException e) {
			try {
				i = Integer.valueOf(string);
				return i > Numero;
			} catch (NumberFormatException a) {
				return false;
			}
		}

	}

	public static boolean comprobarMenorNumero(String string, int Numero) {
		Double d = null;
		Integer i = null;

		try {
			d = Double.valueOf(string);
			return d < Numero;
		} catch (NumberFormatException e) {
			try {
				i = Integer.valueOf(string);
				return i < Numero;
			} catch (NumberFormatException a) {
				return false;
			}
		}

	}

	public static boolean comprobarMayor18(String fechaNacimiento) {
		try {

			LocalDate fecha = LocalDate.parse(fechaNacimiento, formatter);
			Period period = Period.between(fecha, LocalDate.now());
			if (period.getYears() > 18) {
				return true;
			}
			return false;
		} catch (DateTimeParseException e) {
			return false;
		}
	}

	public static boolean comprobarMayor18Numero(String a�os) {
		Integer d = null;
		try {
			d = Integer.parseInt(a�os);
		} catch (Exception e) {
			return false;
		}
		if (d >= 18) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean comprobarEdadesCategoria(String a�osInicio, String a�osFin) {
		Integer inicio = null;
		Integer fin = null;
		try {
			inicio = Integer.parseInt(a�osInicio);
			fin = Integer.parseInt(a�osFin);
		} catch (Exception e) {
			return false;
		}
		if(fin>100) {
			return false;
		}
		if (fin >= inicio) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean comprobarDouble(String text) {
		try {
			Double.parseDouble(text);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean comprobarFechaCancelacion(CarreraManager carreraManager, String maxCancelacion,
			String fechaCarrera) {
		if (carreraManager.getPeriodos().isEmpty())
			return false;

		LocalDate cancelacion = null;
		LocalDate primeraFecha = null;
		LocalDate fechaFin = null;
		try {
			cancelacion = LocalDate.parse(maxCancelacion, formatter);
			primeraFecha = carreraManager.getPeriodos().get(0).getFechaInicio().getDate();
			fechaFin = LocalDate.parse(fechaCarrera, formatter);

		} catch (DateTimeParseException e) {
			return false;
		}
		if (!cancelacion.isAfter(primeraFecha) || !cancelacion.isBefore(fechaFin)) {
			return false;
		}
		return true;
	}
}
