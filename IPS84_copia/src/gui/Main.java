package gui;

import java.awt.EventQueue;

import gui.login.VentanaLogin;

public class Main {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaLogin frame = new VentanaLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	// ASDPO+Ihsdf`0oisHABNDF
}
