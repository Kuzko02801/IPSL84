package gui.aplicacion;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import business.dataaccess.DataAccessFactory;
import business.dataaccess.util.Check;
import business.dataaccess.util.DateSqlite;

public class VentanaPagoTarjeta extends JDialog {

	private JPanel contentPane;
	private JLabel lblPagoTarjeta;
	private JLabel lblNumeroTarjeta;
	private JTextField txtTarjeta;
	private JTextField txtCaducidad;
	private JTextField txtCVC;
	private JLabel lblFechaCaducidad;
	private JLabel lblCVC;
	private JButton btnNewButton;
	private String id_carrera;
	private JTextField txtEmail;
	
	/**
	 * Create the frame.
	 */
	public VentanaPagoTarjeta(String id_carrera) {
		setModal(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 339);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblPagoTarjeta());
		contentPane.add(getLblNumeroTarjeta());
		contentPane.add(getTxtTarjeta());
		contentPane.add(getTxtCaducidad());
		contentPane.add(getTxtCVC());
		contentPane.add(getLblFechaCaducidad());
		contentPane.add(getLblCVC());
		contentPane.add(getBtnNewButton());
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 87, 45, 13);
		contentPane.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(101, 84, 147, 19);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		this.id_carrera = id_carrera;
	}
	private JLabel getLblPagoTarjeta() {
		if (lblPagoTarjeta == null) {
			lblPagoTarjeta = new JLabel("Pago tarjeta");
			lblPagoTarjeta.setBounds(180, 10, 112, 22);
		}
		return lblPagoTarjeta;
	}
	private JLabel getLblNumeroTarjeta() {
		if (lblNumeroTarjeta == null) {
			lblNumeroTarjeta = new JLabel("Numero tarjeta:");
			lblNumeroTarjeta.setBounds(10, 122, 88, 13);
		}
		return lblNumeroTarjeta;
	}
	private JTextField getTxtTarjeta() {
		if (txtTarjeta == null) {
			txtTarjeta = new JTextField();
			txtTarjeta.setBounds(101, 119, 147, 19);
			txtTarjeta.setColumns(10);
		}
		return txtTarjeta;
	}
	private JTextField getTxtCaducidad() {
		if (txtCaducidad == null) {
			txtCaducidad = new JTextField();
			txtCaducidad.setBounds(101, 148, 147, 19);
			txtCaducidad.setColumns(10);
		}
		return txtCaducidad;
	}
	private JTextField getTxtCVC() {
		if (txtCVC == null) {
			txtCVC = new JTextField();
			txtCVC.setColumns(10);
			txtCVC.setBounds(101, 177, 147, 19);
		}
		return txtCVC;
	}
	private JLabel getLblFechaCaducidad() {
		if (lblFechaCaducidad == null) {
			lblFechaCaducidad = new JLabel("Caducidad:");
			lblFechaCaducidad.setBounds(10, 151, 81, 13);
		}
		return lblFechaCaducidad;
	}
	private JLabel getLblCVC() {
		if (lblCVC == null) {
			lblCVC = new JLabel("CVC:");
			lblCVC.setBounds(10, 180, 81, 13);
		}
		return lblCVC;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Aceptar");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					if (txtTarjeta.getText().isEmpty()) {
						JOptionPane.showMessageDialog(rootPane, "No esta puesta el numero de la tarjeta");
					}
					else if (txtCaducidad.getText().isEmpty()) {
						JOptionPane.showMessageDialog(rootPane, "No esta puesto la caducidad");
					}
					else if (txtCVC.getText().isEmpty()) {
						JOptionPane.showMessageDialog(rootPane, "No esta puesto el cvc");
					}
					else if(new DateSqlite(txtCaducidad.getText()).compareTo(new DateSqlite().actual()) < 0) {
						JOptionPane.showMessageDialog(rootPane, "Tarjeta caducada. Pago rechazado");
					}
					else if (txtEmail.getText().isEmpty()) {
						JOptionPane.showMessageDialog(rootPane, "Email vacío");
					}
					else if (!existeAtleta(txtEmail.getText())) {
						JOptionPane.showMessageDialog(rootPane, "Email no existe");
					}
					else {
						JOptionPane.showMessageDialog(rootPane, "Pago Realizado con éxito con fecha:" + new DateSqlite().actual().toString() +". \n"
								+ "Usuario con email: " + txtEmail.getText() + "\n"
								+ "Número de tarjeta: " + txtTarjeta.getText() + "\n"
								+ "Fecha de caducidad: " + txtCaducidad.getText() + "\n"
								+ "CVC: " + txtCVC.getText());
						DataAccessFactory.forInscripcionService().pasarDePreInscritoAInscrito(id_carrera, txtEmail.getText());
						dispose();
					}
				}
			});
			btnNewButton.setBounds(163, 217, 85, 21);
		}
		return btnNewButton;
	}
	
	private boolean existeAtleta(String email) {
		try {
			return Check.atletaExists(email);
		} catch (SQLException e) {
			System.out.println("Fallo en query. Existe atleta");
		}
		return false;
	}
}
