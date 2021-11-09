package gui.validadoresGUI;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

public class Validadores {

	final static String DATE_FORMAT = "dd/MM/yyyy";

	public static boolean comprobarFechasValidas(String fechaCarrera, String fechaApertura, String fechaCierre) {
		Date carrera = null;
		Date apertura = null;
		Date cierre = null;

		try {
			DateFormat df = new SimpleDateFormat(DATE_FORMAT);
			df.setLenient(false);
			carrera = df.parse(fechaCarrera);
			apertura = df.parse(fechaApertura);
			cierre = df.parse(fechaCierre);
		} catch (ParseException e) {
			return false;
		}
		if (carrera.compareTo(apertura) <= 0 || carrera.compareTo(cierre) <= 0 || cierre.compareTo(apertura) <= 0
				|| apertura.compareTo(new Date()) <= 0) {
			return false;
		}
		return true;
	}

	public static final boolean comprobarEmail(String email) {
		if(!comprobarNoVacio(email)) {
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
		if(string==null) {
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
		try {
			d = Double.parseDouble(string);
		} catch (Exception e) {
			return false;
		}
		if (d > 0) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean comprobarMayor18(String fecha) {
		Period period;
		try {
			DateFormat df = new SimpleDateFormat(DATE_FORMAT);
			df.setLenient(false);
			Date nacimiento = df.parse(fecha);
			period = Period.between(nacimiento.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), LocalDate.now());
			if(period.getYears()>18) {
				return true;
			}
			return false;
		} catch (ParseException e) {
			return false;
		}
	}
	public static boolean comprobarMayor18Numero(String años) {
		Integer d = null;
		try {
			d = Integer.parseInt(años);
		} catch (Exception e) {
			return false;
		}
		if (d >= 18) {
			return true;
		} else {
			return false;
		}
	}
	public static boolean comprobarEdadesCategoria(String añosInicio,String añosFin) {
		Integer inicio=null;
		Integer fin=null;
		try {
			inicio = Integer.parseInt(añosInicio);
			fin = Integer.parseInt(añosFin);
		} catch (Exception e) {
			return false;
		}
		if(fin>inicio) {
			return true;
		}else {
			return false;
		}
	}
}
