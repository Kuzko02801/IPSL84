package gui.aplicacion;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class VentanaPagoTarjeta extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtTarjeta;
	private JTextField txtFecha;
	private JTextField txtCVC;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VentanaPagoTarjeta dialog = new VentanaPagoTarjeta();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VentanaPagoTarjeta() {
		setTitle("Pago con tarjeta");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblPagoConTarjeta = new JLabel("Pago con tarjeta");
		lblPagoConTarjeta.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPagoConTarjeta.setBounds(161, 10, 120, 36);
		contentPanel.add(lblPagoConTarjeta);
		
		JLabel lblNumero = new JLabel("Numero tarjerta:");
		lblNumero.setBounds(25, 73, 93, 23);
		contentPanel.add(lblNumero);
		
		txtTarjeta = new JTextField();
		txtTarjeta.setBounds(138, 75, 126, 19);
		contentPanel.add(txtTarjeta);
		txtTarjeta.setColumns(10);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(25, 117, 45, 13);
		contentPanel.add(lblFecha);
		
		txtFecha = new JTextField();
		txtFecha.setBounds(138, 114, 126, 19);
		contentPanel.add(txtFecha);
		txtFecha.setColumns(10);
		
		JLabel lblCVC = new JLabel("CVC:");
		lblCVC.setBounds(25, 160, 45, 13);
		contentPanel.add(lblCVC);
		
		txtCVC = new JTextField();
		txtCVC.setBounds(138, 157, 126, 19);
		contentPanel.add(txtCVC);
		txtCVC.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(161, 206, 85, 21);
		contentPanel.add(btnAceptar);
	}
}
