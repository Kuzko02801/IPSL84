package gui.aplicacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import business.dataaccess.exception.BusinessDataException;
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
	private boolean tieneLista;

	/**
	 * Create the dialog.
	 * 
	 * @param tieneLista
	 */
	public VentanaInscribirse(String id_carrera, boolean tieneLista) {
		setModal(true);
		setTitle("Inscripci\u00F3n");
		this.id_carrera = id_carrera;
		this.tieneLista = tieneLista;
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
				@Override
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
				@Override
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
		try {
			if (Validadores.comprobarEmail(getTxtEmail().getText())) {
				if (GuiLogic.existeUsuario(getTxtEmail().getText())) {
					if (tieneLista) {
						meterseEnListaCarrera(id_carrera, getTxtEmail().getText());
						JOptionPane.showMessageDialog(this,
								String.format("Estas en la lista de espera, tu posición es: %d",
										GuiLogic.numeroListaDeEspera(id_carrera)));
						dispose();
					} else {
						inscribirAtleta(id_carrera);
						dispose();
					}
				} else {
					int input = JOptionPane.showConfirmDialog(this,
							"Tu e-mail no esta registrado pero puedes inscribirte aportando datos adicionales", "Datos",
							JOptionPane.DEFAULT_OPTION);
					if (input == 0) {
						mostrarVentanaRegistro(getTxtEmail().getText(), tieneLista);
					}

				}
			} else {
				JOptionPane.showMessageDialog(this, "El email no es valido.");
			}
		} catch (BusinessDataException e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
			dispose();
		}
//		boolean existe;
//		boolean estaInscrito;
//		boolean estaEnListaDeEspera;
//
//		try {
//			if (Validadores.comprobarEmail(getTxtEmail().getText())) {
//				estaInscrito = Check.existeInscripcion(getTxtEmail().getText(), id_carrera);
//				if (estaInscrito) {
//					JOptionPane.showMessageDialog(rootPane, "Ya te has registrado para esta carrera");
//					return;
//				}
//
//				estaEnListaDeEspera = Check.estaEnListaDeEspera(getTxtEmail().getText(), id_carrera);
//				if (GuiLogic.isCarreraLlena(id_carrera)) {
//					/**
//					 * Se le ofrece al usuario meterse a la lista de espera. Si acepta se le mete en
//					 * la lista y es notificado de su puesto en la misma. Si rechaza, la inscripcion
//					 * no se realiza y la ventana se cierra.
//					 */
//					if (estaEnListaDeEspera) {
//						JOptionPane.showMessageDialog(this, "Usted ya esta en la lista de espera.");
//						return;
//					} else {
//						meterseEnListaCarrera(id_carrera, getTxtEmail().getText());
//					}
//				}
//				existe = Check.atletaExists(getTxtEmail().getText());
//				if (existe) {
//					// Checkar si la carrera esta llena, si lo esta, se le ofrece meterse a la lista
//					// de espera. Si no se cancela la inscripcion.
//					if (GuiLogic.isCarreraLlena(id_carrera)) {
//						/**
//						 * Se le ofrece al usuario meterse a la lista de espera. Si acepta se le mete en
//						 * la lista y es notificado de su puesto en la misma. Si rechaza, la inscripcion
//						 * no se realiza y la ventana se cierra.
//						 */
//						meterseEnListaCarrera(id_carrera, getTxtEmail().getText());
//					} else {
//						inscribirAtleta(id_carrera);
//					}
//				} else { // No se sabe si el atleta puede no estar registrado.
//					int input = JOptionPane.showConfirmDialog(this,
//							"Tu e-mail no estï¿½ registrado pero puedes inscribirte aportando datos adiccionales",
//							"Datos", JOptionPane.DEFAULT_OPTION);
//					if (input == 0) {
//
//						mostrarVentanaRegistro(getTxtEmail().getText());
//					}
//				}
//			} else {
//				JOptionPane.showMessageDialog(this, "El email no es vï¿½lido", "Error", JOptionPane.WARNING_MESSAGE);
//			}
//		} catch (BusinessDataException e) {
//			JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
//		}
	}

	private void meterseEnListaCarrera(String id_carrera, String email) {
		GuiLogic.meterseEnListaDeEspera(id_carrera, email);

	}

	private void inscribirAtleta(String id_carrera) throws BusinessDataException {
		GuiLogic.inscribirAtletaCarrera(id_carrera, getTxtEmail().getText());

	}

	private void mostrarVentanaRegistro(String email, boolean tieneLista) {
		VentanaRegistro v = new VentanaRegistro(email, id_carrera, tieneLista);
		v.setVisible(true);
		dispose();
	}
}
