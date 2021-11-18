package gui.aplicacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import business.dataaccess.exception.BusinessDataException;
import business.dataaccess.util.Check;
import business.gui.GuiLogic;
import gui.login.VentanaRegistro;
import gui.validadoresGUI.Validadores;

public class VentanaInscribirse extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel pnText;
	private JPanel pnButtons;
	private JButton btnInscribir;
	private JButton btnCancelar;
	private JTextField txtEmail;
	private JLabel lblEmail;
	private JLabel lblNewLabel;
	// private VentanaPagoTarjeta vpt = new VentanaPagoTarjeta(this);
	private String id_carrera;
	/**
	 * Create the dialog.
	 */
	public VentanaInscribirse(String id_carrera) {
		setModal(true);
		setTitle("Inscripci\u00F3n");
		this.id_carrera = id_carrera;
		setResizable(false);
		setBounds(100, 100, 450, 300);
		getContentPane().add(getPnText(), BorderLayout.CENTER);
		getContentPane().add(getPnButtons(), BorderLayout.SOUTH);

	}

	public String getId_carrera() {
		return this.id_carrera;
	}

	public String getEmail_atleta() {
		return getTxtEmail().getText();
	}

	private JPanel getPnText() {
		if (pnText == null) {
			pnText = new JPanel();
			pnText.setBackground(new Color(8, 46, 70));
			pnText.setLayout(null);
			pnText.add(getTxtEmail());
			pnText.add(getLblEmail());
			pnText.add(getLblNewLabel());
		}
		return pnText;
	}

	private JPanel getPnButtons() {
		if (pnButtons == null) {
			pnButtons = new JPanel();
			pnButtons.setBackground(new Color(8, 46, 70));
			pnButtons.add(getBtnInscribir());
			pnButtons.add(getBtnCancelar());
		}
		return pnButtons;
	}

	private JButton getBtnInscribir() {
		if (btnInscribir == null) {
			btnInscribir = new JButton("Inscribirse");
			btnInscribir.setBackground(new Color(50, 130, 181));
			btnInscribir.setForeground(new Color(184, 220, 245));
			btnInscribir.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
			btnInscribir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					inscribirAtleta();

				}
			});
		}
		return btnInscribir;
	}

	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");
			btnCancelar.setBackground(new Color(50, 130, 181));
			btnCancelar.setForeground(new Color(184, 220, 245));
			btnCancelar.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
		}
		return btnCancelar;
	}

	private JTextField getTxtEmail() {
		if (txtEmail == null) {
			txtEmail = new JTextField();
			txtEmail.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
			txtEmail.setBounds(109, 95, 250, 25);
			txtEmail.setText("");
			txtEmail.setColumns(10);
		}
		return txtEmail;
	}

	private JLabel getLblEmail() {
		if (lblEmail == null) {
			lblEmail = new JLabel("E-mail");
			lblEmail.setForeground(new Color(184, 220, 245));
			lblEmail.setBackground(new Color(143, 188, 143));
			lblEmail.setBounds(22, 99, 77, 19);
			lblEmail.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		}
		return lblEmail;
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Para inscribirte escribe tu e-mail");
			lblNewLabel.setForeground(new Color(184, 220, 245));
			lblNewLabel.setBackground(new Color(176, 224, 230));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(71, 36, 288, 25);
			lblNewLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 16));
		}
		return lblNewLabel;
	}

	private void inscribirAtleta() {
		boolean existe;
		boolean estaInscrito;

		try {
			if (Validadores.comprobarEmail(getTxtEmail().getText())) {
				existe = Check.atletaExists(getTxtEmail().getText());
				estaInscrito = Check.existeInscripcion(getTxtEmail().getText(), id_carrera);
				if (estaInscrito) {
					JOptionPane.showMessageDialog(rootPane, "Ya te has registrado para esta carrera");
					return;
				}
				if (existe) {
					GuiLogic.inscribirAtletaCarrera(id_carrera, getTxtEmail().getText());
					dispose();
				} else {
					int input = JOptionPane.showConfirmDialog(this,
							"Tu e-mail no está registrado pero puedes inscribirte aportando datos adiccionales",
							"Datos", JOptionPane.DEFAULT_OPTION);
					if (input == 0) {

						mostrarVentanaRegistro(getTxtEmail().getText());
					}
				}
			} else {
				JOptionPane.showMessageDialog(this, "El email no es válido", "Error", JOptionPane.WARNING_MESSAGE);
			}
		} catch (BusinessDataException e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
			e.printStackTrace();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(this, "Ha ocurrido un error inesperado con la inscripción", "Error",
					JOptionPane.WARNING_MESSAGE);
			e.printStackTrace();
		}
	}

	private void mostrarVentanaRegistro(String email) {
		VentanaRegistro v = new VentanaRegistro(email, id_carrera);
		v.setVisible(true);
		dispose();
	}
}
