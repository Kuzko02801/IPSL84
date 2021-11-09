package gui.validadoresGUI;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

public class Validadores {

	final static String DATE_FORMAT = "yyyy/MM/dd";

	public static boolean comprobarFechasValidas(String fechaCarrera, String fechaApertura, String fechaCierre) {
		LocalDate carrera = null;
		LocalDate apertura = null;
		LocalDate cierre = null;
		DateTimeFormatter formatter = null;
		try {
			formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);

			carrera = LocalDate.parse(fechaCarrera, formatter);
			apertura = LocalDate.parse(fechaApertura, formatter);
			cierre = LocalDate.parse(fechaCierre, formatter);

		} catch (DateTimeParseException e) {
			System.out.println("problemas");
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
		if (string.trim().length() == 0) {
			return false;
		}
		return true;
	}

	public static boolean comprobarFecha(String fecha) {
		try {
			DateFormat df = new SimpleDateFormat(DATE_FORMAT);
			df.setLenient(false);
			df.parse(fecha);
			return true;
		} catch (ParseException e) {
			return false;
		}
	}

	public static boolean comprobarMayor0(String string) {
		Double d = null;
		Integer i = null;

		try {
			d = Double.valueOf(string);
			return d > 0;
		} catch (NumberFormatException e) {
			try {
				i = Integer.valueOf(string);
				return i > 0;
			} catch (NumberFormatException a) {
				return false;
			}
		}

	}

	public static boolean comprobarMayor18(String fecha) {
		Period period;
		try {
			DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
			df.setLenient(false);
			Date nacimiento = df.parse(fecha);
			period = Period.between(nacimiento.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
					LocalDate.now());
			if (period.getYears() > 18) {
				return true;
			}
			return false;
		} catch (ParseException e) {
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
		if (fin > inicio) {
			return true;
		} else {
			return false;
		}
	}
}
