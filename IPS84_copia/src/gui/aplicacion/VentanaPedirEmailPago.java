package gui.aplicacion;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import business.dataaccess.BusinessDataException;
import business.dataaccess.util.Check;
import business.gui.GuiLogic;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class VentanaPedirEmailPago extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtEmail;
	private String id_carrera;

	/**
	 * Create the dialog.
	 * @param id_carrera 
	 */
	public VentanaPedirEmailPago(String id_carrera) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblEmail = new JLabel("Introduzca su email porfavor");
		lblEmail.setBounds(117, 84, 180, 13);
		contentPanel.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(117, 107, 180, 19);
		contentPanel.add(txtEmail);
		txtEmail.setColumns(10);
		
		this.id_carrera = id_carrera;
		JButton btnSiguiente = new JButton("Siguiente");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pulsarSiguiente();
			}
		});
		btnSiguiente.setBounds(166, 182, 85, 21);
		contentPanel.add(btnSiguiente);
	}
	private void pulsarSiguiente() {
		
		boolean existeAtleta;
		try {
			existeAtleta = Check.atletaExists(txtEmail.getText());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		if(existeAtleta) {
			try {
				GuiLogic.inscribirAtletaCarrera(id_carrera, txtEmail.getText());
			} catch (BusinessDataException e) {
				e.printStackTrace();
				throw new RuntimeException();
			}
		}else {
			
		}
		
	}
	private void comprobarPuedePagar() {
		if (puedePagar(id_carrera, txtEmail.getText())) {
			
			VentanaPagoTarjeta vpt = new VentanaPagoTarjeta(id_carrera, txtEmail.getText());
			vpt.setVisible(true);
		} else {
			JOptionPane.showMessageDialog(rootPane, "No es posible realizar el pago sobre la carrera con id: " + id_carrera );
		}
	}
	private boolean puedePagar(String carrera_id, String email_atleta) {
		try {
			return Check.puedePagarInscripcion(carrera_id, email_atleta);
		} catch (SQLException e) {
			System.out.println("Excepcion en VentanaPedirEmail");
		}
		return false;
	}
}
