package gui.login;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import business.dataaccess.exception.BusinessDataException;
import business.gui.GuiLogic;
import gui.validadoresGUI.Validadores;

public class VentanaRegistro extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel pnCards;
	private JPanel pnRegistroParticipante;
	private JButton btRegistrarseParticipante;
	private JLabel lbRegistroParticipante;
	private JLabel lblDni;
	private JLabel lblFechaDeNacimiento;
	private JLabel lblSexo;
	private JLabel lbNombreParticipante;
	private JTextField txDniParticipante;
	private JTextField txNombreParticipante;
	private JTextField txFechaNacimiento;
	private JComboBox<String> cbSexo;
	private String email;
	private String idCarrera;

	/**
	 * Create the frame.
	 */
	public VentanaRegistro(String email, String idCarrera) {
		setModal(true);
		setResizable(false);
		setTitle("Registro");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 550, 350);
		pnCards = new JPanel();
		pnCards.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pnCards);
		pnCards.setLayout(new CardLayout(0, 0));
		pnCards.add(getPnRegistroParticipante(), "pnParticipante");

		this.email = email;
		this.idCarrera = idCarrera;
	}

	private JPanel getPnRegistroParticipante() {
		if (pnRegistroParticipante == null) {
			pnRegistroParticipante = new JPanel();
			pnRegistroParticipante.setLayout(null);
			pnRegistroParticipante.setBorder(new EmptyBorder(5, 5, 5, 5));
			pnRegistroParticipante.setBackground(new Color(8, 46, 70));
			pnRegistroParticipante.add(getBtRegistrarseParticipante());
			pnRegistroParticipante.add(getLbRegistroParticipante());
			pnRegistroParticipante.add(getLblDni());
			pnRegistroParticipante.add(getLblFechaDeNacimiento());
			pnRegistroParticipante.add(getLblSexo());
			pnRegistroParticipante.add(getLbNombreParticipante());
			pnRegistroParticipante.add(getTxDniParticipante());
			pnRegistroParticipante.add(getTxNombreParticipante());
			pnRegistroParticipante.add(getTxFechaNacimiento());
			pnRegistroParticipante.add(getCbSexo());
		}
		return pnRegistroParticipante;
	}

	private JButton getBtRegistrarseParticipante() {
		if (btRegistrarseParticipante == null) {
			btRegistrarseParticipante = new JButton("Continuar");
			btRegistrarseParticipante.setEnabled(true);
			btRegistrarseParticipante.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (comprobarCampos()) {
						inscribirParticipante();
					}
				}
			});
			btRegistrarseParticipante.setFont(new Font("Segoe UI Black", Font.PLAIN, 18));
			btRegistrarseParticipante.setBackground(new Color(50, 130, 181));
			btRegistrarseParticipante.setBounds(355, 258, 147, 35);
		}
		return btRegistrarseParticipante;
	}

	private JLabel getLbRegistroParticipante() {
		if (lbRegistroParticipante == null) {
			lbRegistroParticipante = new JLabel("Introducir datos");
			lbRegistroParticipante.setHorizontalAlignment(SwingConstants.CENTER);
			lbRegistroParticipante.setForeground(new Color(184, 220, 245));
			lbRegistroParticipante.setFont(new Font("Segoe UI Black", Font.PLAIN, 18));
			lbRegistroParticipante.setBackground(new Color(50, 130, 181));
			lbRegistroParticipante.setBounds(40, 10, 460, 48);
		}
		return lbRegistroParticipante;
	}

	private JLabel getLblDni() {
		if (lblDni == null) {
			lblDni = new JLabel("DNI");
			lblDni.setForeground(new Color(184, 220, 245));
			lblDni.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
			lblDni.setBounds(10, 68, 183, 34);
		}
		return lblDni;
	}

	private JLabel getLblFechaDeNacimiento() {
		if (lblFechaDeNacimiento == null) {
			lblFechaDeNacimiento = new JLabel("Fecha de nacimiento");
			lblFechaDeNacimiento.setForeground(new Color(184, 220, 245));
			lblFechaDeNacimiento.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
			lblFechaDeNacimiento.setBounds(10, 156, 183, 34);
		}
		return lblFechaDeNacimiento;
	}

	private JLabel getLblSexo() {
		if (lblSexo == null) {
			lblSexo = new JLabel("Sexo");
			lblSexo.setForeground(new Color(184, 220, 245));
			lblSexo.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
			lblSexo.setBounds(10, 200, 183, 34);
		}
		return lblSexo;
	}

	private JLabel getLbNombreParticipante() {
		if (lbNombreParticipante == null) {
			lbNombreParticipante = new JLabel("Nombre y apellidos");
			lbNombreParticipante.setForeground(new Color(184, 220, 245));
			lbNombreParticipante.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
			lbNombreParticipante.setBounds(10, 112, 183, 34);
		}
		return lbNombreParticipante;
	}

	private JTextField getTxDniParticipante() {
		if (txDniParticipante == null) {
			txDniParticipante = new JTextField();
			txDniParticipante.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
//			txDniParticipante.addKeyListener(new KeyAdapter() {
//				@Override
//				public void keyReleased(KeyEvent e) {
//					comprobarCampos();
//				}
//			});
			txDniParticipante.setBounds(214, 68, 286, 34);
			txDniParticipante.setColumns(10);
		}
		return txDniParticipante;
	}

	private JTextField getTxNombreParticipante() {
		if (txNombreParticipante == null) {
			txNombreParticipante = new JTextField();
			txNombreParticipante.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
//			txNombreParticipante.addKeyListener(new KeyAdapter() {
//				@Override
//				public void keyReleased(KeyEvent e) {
//					comprobarCampos();
//				}
//			});
			txNombreParticipante.setColumns(10);
			txNombreParticipante.setBounds(214, 112, 286, 34);
		}
		return txNombreParticipante;
	}

	private JTextField getTxFechaNacimiento() {
		if (txFechaNacimiento == null) {
			txFechaNacimiento = new JTextField();
			txFechaNacimiento.setText("yyyy/MM/dd");
			txFechaNacimiento.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
//			txFechaNacimiento.addKeyListener(new KeyAdapter() {
//				@Override
//				public void keyReleased(KeyEvent e) {
//					comprobarCampos();
//				}
//			});
			txFechaNacimiento.setBounds(214, 156, 286, 34);
			txFechaNacimiento.setColumns(10);
		}
		return txFechaNacimiento;
	}

	private JComboBox<String> getCbSexo() {
		if (cbSexo == null) {
			cbSexo = new JComboBox<String>();
			cbSexo.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
			cbSexo.setModel(new DefaultComboBoxModel<String>(new String[] { "Hombre", "Mujer" }));
			cbSexo.setBounds(214, 200, 287, 31);
		}
		return cbSexo;
	}

	// Metodos adiccionales

	private void inscribirParticipante() {
		if (comprobarCampos()) {
			if (registraParticipante()) {
				inscribeParticipante();
				dispose();
			}
		}

	}

	private void inscribeParticipante() {

		try {
			GuiLogic.inscribirAtletaCarrera(idCarrera, email);
		} catch (BusinessDataException e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
		}

	}

	private boolean registraParticipante() {
		try {
			GuiLogic.registrarAtleta(email, getTxDniParticipante().getText(), getTxNombreParticipante().getText(),
					getTxFechaNacimiento().getText(), getCbSexo().getSelectedItem().toString());
			return true;
		} catch (BusinessDataException e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
			return false;
		}
	}

	private boolean comprobarCampos() {
		if (Validadores.comprobarNoVacio(getTxNombreParticipante().getText())
				&& Validadores.comprobarNoVacio(getTxDniParticipante().getText())
				&& Validadores.comprobarMayor18(getTxFechaNacimiento().getText())
				&& Validadores.comprobarMayor18(getTxFechaNacimiento().getText())
				&& Validadores.comprobarFecha(getTxFechaNacimiento().getText())) {
			return true;
		} else {
			JOptionPane.showMessageDialog(this, "Comprueba los campos", "Error", JOptionPane.WARNING_MESSAGE);
			return false;
		}
	}

}
