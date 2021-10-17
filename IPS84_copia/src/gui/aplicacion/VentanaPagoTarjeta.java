package gui.aplicacion;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import business.dataaccess.DataAccessFactory;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPagoTarjeta extends JFrame {

	private JPanel contentPane;
	private JLabel lblPagoTarjeta;
	private JLabel lblNumeroTarjeta;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblFechaCaducidad;
	private JLabel lblCVC;
	private JButton btnNewButton;
	private JFrame vpe;


	/**
	 * Create the frame.
	 */
	public VentanaPagoTarjeta(VentanaPedirEmail vpe) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblPagoTarjeta());
		contentPane.add(getLblNumeroTarjeta());
		contentPane.add(getTextField());
		contentPane.add(getTextField_1());
		contentPane.add(getTextField_2());
		contentPane.add(getLblFechaCaducidad());
		contentPane.add(getLblCVC());
		contentPane.add(getBtnNewButton());
		this.vpe = vpe;
	}
	private JLabel getLblPagoTarjeta() {
		if (lblPagoTarjeta == null) {
			lblPagoTarjeta = new JLabel("Pago tarjeta");
			lblPagoTarjeta.setBounds(180, 28, 112, 22);
		}
		return lblPagoTarjeta;
	}
	private JLabel getLblNumeroTarjeta() {
		if (lblNumeroTarjeta == null) {
			lblNumeroTarjeta = new JLabel("Numero tarjeta:");
			lblNumeroTarjeta.setBounds(10, 77, 88, 13);
		}
		return lblNumeroTarjeta;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(101, 74, 147, 19);
			textField.setColumns(10);
		}
		return textField;
	}
	private JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setBounds(101, 123, 147, 19);
			textField_1.setColumns(10);
		}
		return textField_1;
	}
	private JTextField getTextField_2() {
		if (textField_2 == null) {
			textField_2 = new JTextField();
			textField_2.setColumns(10);
			textField_2.setBounds(101, 177, 147, 19);
		}
		return textField_2;
	}
	private JLabel getLblFechaCaducidad() {
		if (lblFechaCaducidad == null) {
			lblFechaCaducidad = new JLabel("Caducidad:");
			lblFechaCaducidad.setBounds(10, 126, 81, 13);
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
					if (textField.getText().isEmpty()) {
						JOptionPane.showMessageDialog(rootPane, "No esta puesta el numero de la tarjeta");
					}
					if (textField_1.getText().isEmpty()) {
						JOptionPane.showMessageDialog(rootPane, "No esta puesto la caducidad");
					}
					if (textField_2.getText().isEmpty()) {
						JOptionPane.showMessageDialog(rootPane, "No esta puesto el cvc");
					}
					else {
						DataAccessFactory.forInscripcionService().pasarDePreInscritoAInscrito(((VentanaPedirEmail) vpe).getId_carrera(),
								((VentanaPedirEmail) vpe).getEmail_atleta());
						dispose();
						vpe.dispose();
					}
				}
			});
			btnNewButton.setBounds(163, 217, 85, 21);
			
		}
		return btnNewButton;
	}
}
