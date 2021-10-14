package gui.validadores;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

public class Validadores {

	private static final boolean comprobarEmail(String email) {
		boolean result = true;
		try {
			InternetAddress emailAddr = new InternetAddress(email);
			emailAddr.validate();
		} catch (AddressException ex) {
			result = false;
		}
		return result;
	}

	private static boolean comprobarNoVacio(String string) {
		if (string.trim().length() == 0) {
			return false;
		}
		return true;
	}

	final static String DATE_FORMAT = "dd-MM-yyyy";

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

	private static boolean comprobarMayor0(int valor) {
		if (valor > 0) {
			return true;
		} else {
			return false;
		}
	}
}
