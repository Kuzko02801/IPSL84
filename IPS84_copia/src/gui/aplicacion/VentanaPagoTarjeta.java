package gui.aplicacion;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import business.dataaccess.util.Check;
import business.dataaccess.util.DateSqlite;
import business.gui.GuiLogic;

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
	private String email_atleta;
	private int dorsal = 0;
	private VentanaApp v;
	/**
	 * Create the frame.
	 * 
	 * @param email_atleta
	 */
	public VentanaPagoTarjeta(VentanaApp app,String id_carrera, String email_atleta) {
		this.v=app;
		setTitle("Pago");
		setModal(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 339);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(8, 46, 70));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane
				.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPane
								.createSequentialGroup().addContainerGap()
								.addComponent(getLblCVC(), GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(getBtnNewButton(), Alignment.TRAILING, GroupLayout.DEFAULT_SIZE,
												147, Short.MAX_VALUE)
										.addComponent(
												getTxtCVC(), Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 147,
												Short.MAX_VALUE))
								.addGap(142))
						.addGroup(Alignment.TRAILING,
								gl_contentPane.createSequentialGroup().addContainerGap()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
												.addComponent(getLblFechaCaducidad(), GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(getLblNumeroTarjeta(), GroupLayout.DEFAULT_SIZE, 122,
														Short.MAX_VALUE))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_contentPane
														.createSequentialGroup()
														.addComponent(getLblPagoTarjeta(), GroupLayout.PREFERRED_SIZE,
																0, Short.MAX_VALUE)
														.addGap(177))
												.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
														.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
																.addComponent(getTxtCaducidad(),
																		GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
																.addComponent(getTxtTarjeta(), GroupLayout.DEFAULT_SIZE,
																		147, Short.MAX_VALUE))
														.addGap(143)))));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addContainerGap()
				.addComponent(getLblPagoTarjeta(), GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
				.addGap(85)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE, false)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(2).addComponent(getLblNumeroTarjeta()))
						.addComponent(getTxtTarjeta(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(13)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(getLblFechaCaducidad())
						.addComponent(getTxtCaducidad(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(16)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(getTxtCVC(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(getLblCVC()))
				.addGap(21).addComponent(getBtnNewButton()).addGap(47)));
		contentPane.setLayout(gl_contentPane);
		this.id_carrera = id_carrera;
		this.email_atleta = email_atleta;
	}

	private JLabel getLblPagoTarjeta() {
		if (lblPagoTarjeta == null) {
			lblPagoTarjeta = new JLabel("Pago tarjeta");
			lblPagoTarjeta.setForeground(new Color(184, 220, 245));
			lblPagoTarjeta.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		}
		return lblPagoTarjeta;
	}

	private JLabel getLblNumeroTarjeta() {
		if (lblNumeroTarjeta == null) {
			lblNumeroTarjeta = new JLabel("Numero tarjeta:");
			lblNumeroTarjeta.setForeground(new Color(184, 220, 245));
			lblNumeroTarjeta.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		}
		return lblNumeroTarjeta;
	}

	private JTextField getTxtTarjeta() {
		if (txtTarjeta == null) {
			txtTarjeta = new JTextField();
			txtTarjeta.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
			txtTarjeta.setColumns(10);
		}
		return txtTarjeta;
	}

	private JTextField getTxtCaducidad() {
		if (txtCaducidad == null) {
			txtCaducidad = new JTextField();
			txtCaducidad.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
			txtCaducidad.setColumns(10);
		}
		return txtCaducidad;
	}

	private JTextField getTxtCVC() {
		if (txtCVC == null) {
			txtCVC = new JTextField();
			txtCVC.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
			txtCVC.setColumns(10);
		}
		return txtCVC;
	}

	private JLabel getLblFechaCaducidad() {
		if (lblFechaCaducidad == null) {
			lblFechaCaducidad = new JLabel("Caducidad:");
			lblFechaCaducidad.setForeground(new Color(176, 224, 230));
			lblFechaCaducidad.setBackground(new Color(143, 188, 143));
			lblFechaCaducidad.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		}
		return lblFechaCaducidad;
	}

	private JLabel getLblCVC() {
		if (lblCVC == null) {
			lblCVC = new JLabel("CVC:");
			lblCVC.setForeground(new Color(184, 220, 245));
			lblCVC.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		}
		return lblCVC;
	}

	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Aceptar");
			btnNewButton.setForeground(new Color(184, 220, 245));
			btnNewButton.setBackground(new Color(50, 130, 181));
			btnNewButton.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (txtTarjeta.getText().isEmpty()) {
						JOptionPane.showMessageDialog(rootPane, "No esta puesto el numero de la tarjeta");
					} else if (txtCaducidad.getText().isEmpty()) {
						JOptionPane.showMessageDialog(rootPane, "No esta puesto la caducidad");
					} else if (txtCVC.getText().isEmpty()) {
						JOptionPane.showMessageDialog(rootPane, "No esta puesto el cvc");
					} else if (new DateSqlite(txtCaducidad.getText()).compareTo(new DateSqlite().actual()) < 0) {
						JOptionPane.showMessageDialog(rootPane, "Tarjeta caducada. Pago rechazado");
					} else if (!existeAtleta(email_atleta)) {
						JOptionPane.showMessageDialog(rootPane, "Email no existe");
					} else if (pagoFueraDePlazo()) {
						JOptionPane.showMessageDialog(rootPane,
								"El pago rechazado. Han pasado 48h desde la preinscripcion");
					} else {
						JOptionPane.showMessageDialog(rootPane,
								"Pago Realizado con éxito con fecha:" + new DateSqlite().actual().toString() + ". \n"
										+ "Usuario con email: " + email_atleta + "\n" + "Número de tarjeta: "
										+ txtTarjeta.getText() + "\n" + "Fecha de caducidad: " + txtCaducidad.getText()
										+ "\n" + "CVC: " + txtCVC.getText());
						GuiLogic.pagarInscripcion(id_carrera, email_atleta, dorsal);
						v.mostrarTodasCarrerasParticipante();
						dispose();
					}
				}
			});
		}
		return btnNewButton;
	}

	protected boolean pagoFueraDePlazo() {
		try {
			return Check.pagoFueraDePlazo(id_carrera, email_atleta);
		} catch (SQLException e) {
			System.out.println("Fallo en query. Pago fuera de plazo");
			System.out.println(e.getMessage());
		}
		return false;
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
