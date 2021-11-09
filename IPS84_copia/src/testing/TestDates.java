package testing;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import gui.validadoresGUI.Validadores;

public class TestDates {
	final static String DATE_FORMAT = "dd/MM/yyyy";
	public static void main(String[] args) {
		
		System.out.println(Validadores.comprobarMayor18("22/5/2000"));
		System.out.println(Validadores.comprobarFecha("29/2/2001"));
	}

}
