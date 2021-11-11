package testing;

import gui.validadoresGUI.Validadores;

public class TestDates {
	final static String DATE_FORMAT = "dd/MM/yyyy";
	public static void main(String[] args) {
		
		System.out.println(Validadores.comprobarMayor18("22/5/2000"));
		System.out.println(Validadores.comprobarFecha("29/2/2001"));
	}

}
