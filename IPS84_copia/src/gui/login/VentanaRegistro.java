package gui.login;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class VentanaRegistro extends JFrame {

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
	private JComboBox cbSexo;
	private JLabel lbEmail;
	private JTextField txEmail;

	/**
	 * Create the frame.
	 */
	public VentanaRegistro() {
		setResizable(false);
		setTitle("Registro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 400);
		pnCards = new JPanel();
		pnCards.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pnCards);
		pnCards.setLayout(new CardLayout(0, 0));
		pnCards.add(getPnRegistroParticipante(), "pnParticipante");
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
			pnRegistroParticipante.add(getLbEmail());
			pnRegistroParticipante.add(getTxEmail());
		}
		return pnRegistroParticipante;
	}
	private JButton getBtRegistrarseParticipante() {
		if (btRegistrarseParticipante == null) {
			btRegistrarseParticipante = new JButton("Registrarse");
			btRegistrarseParticipante.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					registrarParticipante();
				}
			});
			btRegistrarseParticipante.setFont(new Font("Segoe UI Black", Font.PLAIN, 18));
			btRegistrarseParticipante.setBackground(new Color(50, 130, 181));
			btRegistrarseParticipante.setBounds(353, 308, 147, 35);
		}
		return btRegistrarseParticipante;
	}
	private JLabel getLbRegistroParticipante() {
		if (lbRegistroParticipante == null) {
			lbRegistroParticipante = new JLabel("Registro participante");
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
			lblDni.setBounds(10, 135, 183, 34);
		}
		return lblDni;
	}
	private JLabel getLblFechaDeNacimiento() {
		if (lblFechaDeNacimiento == null) {
			lblFechaDeNacimiento = new JLabel("Fecha de nacimiento");
			lblFechaDeNacimiento.setForeground(new Color(184, 220, 245));
			lblFechaDeNacimiento.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
			lblFechaDeNacimiento.setBounds(10, 223, 183, 34);
		}
		return lblFechaDeNacimiento;
	}
	private JLabel getLblSexo() {
		if (lblSexo == null) {
			lblSexo = new JLabel("Sexo");
			lblSexo.setForeground(new Color(184, 220, 245));
			lblSexo.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
			lblSexo.setBounds(10, 265, 183, 34);
		}
		return lblSexo;
	}
	private JLabel getLbNombreParticipante() {
		if (lbNombreParticipante == null) {
			lbNombreParticipante = new JLabel("Nombre y apellidos");
			lbNombreParticipante.setForeground(new Color(184, 220, 245));
			lbNombreParticipante.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
			lbNombreParticipante.setBounds(10, 179, 183, 34);
		}
		return lbNombreParticipante;
	}
	private JTextField getTxDniParticipante() {
		if (txDniParticipante == null) {
			txDniParticipante = new JTextField();
			txDniParticipante.setBounds(214, 135, 286, 34);
			txDniParticipante.setColumns(10);
		}
		return txDniParticipante;
	}
	private JTextField getTxNombreParticipante() {
		if (txNombreParticipante == null) {
			txNombreParticipante = new JTextField();
			txNombreParticipante.setColumns(10);
			txNombreParticipante.setBounds(214, 179, 286, 34);
		}
		return txNombreParticipante;
	}
	private JTextField getTxFechaNacimiento() {
		if (txFechaNacimiento == null) {
			txFechaNacimiento = new JTextField();
			txFechaNacimiento.setBounds(214, 223, 286, 34);
			txFechaNacimiento.setColumns(10);
		}
		return txFechaNacimiento;
	}
	private JComboBox getCbSexo() {
		if (cbSexo == null) {
			cbSexo = new JComboBox();
			cbSexo.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
			cbSexo.setModel(new DefaultComboBoxModel(new String[] {"Hombre", "Mujer"}));
			cbSexo.setBounds(213, 267, 287, 31);
		}
		return cbSexo;
	}
	
	
	
	
	//Metodos adiccionales//////////////////////////////
	
	
	private void mostrarVentanaOrganizador() {
		CardLayout cl = (CardLayout)(pnCards.getLayout());
	    cl.show(pnCards, "pnOrganizador");
	}
	private void mostrarVentanaParticipante() {
		CardLayout cl = (CardLayout)(pnCards.getLayout());
	    cl.show(pnCards, "pnParticipante");
	}
	private void mostrarVentanaLogin() {
		VentanaLogin v=new VentanaLogin();
		v.setVisible(true);
		dispose();
	}
	
	private void registrarParticipante() {
		mostrarVentanaLogin();
	}
	
	private void registrarOrganizador() {
		mostrarVentanaLogin();
	}
	private JLabel getLbEmail() {
		if (lbEmail == null) {
			lbEmail = new JLabel("E-mail");
			lbEmail.setForeground(new Color(184, 220, 245));
			lbEmail.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
			lbEmail.setBounds(10, 91, 183, 34);
		}
		return lbEmail;
	}
	private JTextField getTxEmail() {
		if (txEmail == null) {
			txEmail = new JTextField();
			txEmail.setColumns(10);
			txEmail.setBounds(214, 91, 286, 34);
		}
		return txEmail;
	}
}
