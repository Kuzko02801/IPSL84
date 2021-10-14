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
	private JPanel pnPrincipal;
	private JButton btOrganizador;
	private JButton btParticipante;
	private JLabel lblRegistro;
	private JPanel pnRegistroParticipante;
	private JButton btRegistrarseParticipante;
	private JLabel lbRegistroParticipante;
	private JLabel lblDni;
	private JLabel lblContrasenaParticipante;
	private JLabel lblFechaDeNacimiento;
	private JLabel lblSexo;
	private JLabel lbNombreParticipante;
	private JTextField txDniParticipante;
	private JTextField txNombreParticipante;
	private JPasswordField txPasswordParticipante;
	private JTextField txFechaNacimiento;
	private JComboBox cbSexo;
	private JPanel pnRegistroOrganizador;
	private JButton btRegistrarseOrganizador;
	private JLabel lbRegistroOrganizador;
	private JLabel lbDniOrganizador;
	private JLabel lbContrasena;
	private JLabel lbNombreOrganizador;
	private JTextField txDNIOrganizador;
	private JTextField txNombreOrganizador;
	private JPasswordField passOrganizador;

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
		pnCards.add(getPnPrincipal(), "pnPrincipal");
		pnCards.add(getPnRegistroParticipante(), "pnParticipante");
		pnCards.add(getPnRegistroOrganizador(), "pnOrganizador");
	}
	private JPanel getPnPrincipal() {
		if (pnPrincipal == null) {
			pnPrincipal = new JPanel();
			pnPrincipal.setLayout(null);
			pnPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
			pnPrincipal.setBackground(new Color(8, 46, 70));
			pnPrincipal.add(getBtOrganizador());
			pnPrincipal.add(getBtParticipante());
			pnPrincipal.add(getLblRegistro());
		}
		return pnPrincipal;
	}
	private JButton getBtOrganizador() {
		if (btOrganizador == null) {
			btOrganizador = new JButton("Organizador");
			btOrganizador.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarVentanaOrganizador();
				}
			});
			btOrganizador.setFont(new Font("Segoe UI Black", Font.PLAIN, 18));
			btOrganizador.setBackground(new Color(50, 130, 181));
			btOrganizador.setBounds(40, 150, 200, 68);
		}
		return btOrganizador;
	}
	private JButton getBtParticipante() {
		if (btParticipante == null) {
			btParticipante = new JButton("Participante");
			btParticipante.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarVentanaParticipante();
				}
			});
			btParticipante.setFont(new Font("Segoe UI Black", Font.PLAIN, 18));
			btParticipante.setBackground(new Color(50, 130, 181));
			btParticipante.setBounds(300, 150, 200, 68);
		}
		return btParticipante;
	}
	private JLabel getLblRegistro() {
		if (lblRegistro == null) {
			lblRegistro = new JLabel("\u00BFC\u00F3mo desea registrarse?");
			lblRegistro.setHorizontalAlignment(SwingConstants.CENTER);
			lblRegistro.setForeground(new Color(184, 220, 245));
			lblRegistro.setFont(new Font("Segoe UI Black", Font.PLAIN, 18));
			lblRegistro.setBackground(new Color(50, 130, 181));
			lblRegistro.setBounds(40, 42, 460, 48);
		}
		return lblRegistro;
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
			pnRegistroParticipante.add(getLblContrasenaParticipante());
			pnRegistroParticipante.add(getLblFechaDeNacimiento());
			pnRegistroParticipante.add(getLblSexo());
			pnRegistroParticipante.add(getLbNombreParticipante());
			pnRegistroParticipante.add(getTxDniParticipante());
			pnRegistroParticipante.add(getTxNombreParticipante());
			pnRegistroParticipante.add(getTxPasswordParticipante());
			pnRegistroParticipante.add(getTxFechaNacimiento());
			pnRegistroParticipante.add(getCbSexo());
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
			lblDni.setBounds(10, 68, 183, 34);
		}
		return lblDni;
	}
	private JLabel getLblContrasenaParticipante() {
		if (lblContrasenaParticipante == null) {
			lblContrasenaParticipante = new JLabel("Contrase\u00F1a");
			lblContrasenaParticipante.setForeground(new Color(184, 220, 245));
			lblContrasenaParticipante.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
			lblContrasenaParticipante.setBounds(10, 156, 183, 34);
		}
		return lblContrasenaParticipante;
	}
	private JLabel getLblFechaDeNacimiento() {
		if (lblFechaDeNacimiento == null) {
			lblFechaDeNacimiento = new JLabel("Fecha de nacimiento");
			lblFechaDeNacimiento.setForeground(new Color(184, 220, 245));
			lblFechaDeNacimiento.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
			lblFechaDeNacimiento.setBounds(10, 200, 183, 34);
		}
		return lblFechaDeNacimiento;
	}
	private JLabel getLblSexo() {
		if (lblSexo == null) {
			lblSexo = new JLabel("Sexo");
			lblSexo.setForeground(new Color(184, 220, 245));
			lblSexo.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
			lblSexo.setBounds(10, 244, 183, 34);
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
			txDniParticipante.setBounds(214, 68, 286, 34);
			txDniParticipante.setColumns(10);
		}
		return txDniParticipante;
	}
	private JTextField getTxNombreParticipante() {
		if (txNombreParticipante == null) {
			txNombreParticipante = new JTextField();
			txNombreParticipante.setColumns(10);
			txNombreParticipante.setBounds(214, 112, 286, 34);
		}
		return txNombreParticipante;
	}
	private JPasswordField getTxPasswordParticipante() {
		if (txPasswordParticipante == null) {
			txPasswordParticipante = new JPasswordField();
			txPasswordParticipante.setBounds(214, 156, 286, 34);
		}
		return txPasswordParticipante;
	}
	private JTextField getTxFechaNacimiento() {
		if (txFechaNacimiento == null) {
			txFechaNacimiento = new JTextField();
			txFechaNacimiento.setBounds(214, 200, 286, 34);
			txFechaNacimiento.setColumns(10);
		}
		return txFechaNacimiento;
	}
	private JComboBox getCbSexo() {
		if (cbSexo == null) {
			cbSexo = new JComboBox();
			cbSexo.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
			cbSexo.setModel(new DefaultComboBoxModel(new String[] {"Hombre", "Mujer"}));
			cbSexo.setBounds(213, 244, 287, 31);
		}
		return cbSexo;
	}
	private JPanel getPnRegistroOrganizador() {
		if (pnRegistroOrganizador == null) {
			pnRegistroOrganizador = new JPanel();
			pnRegistroOrganizador.setLayout(null);
			pnRegistroOrganizador.setBorder(new EmptyBorder(5, 5, 5, 5));
			pnRegistroOrganizador.setBackground(new Color(8, 46, 70));
			pnRegistroOrganizador.add(getBtRegistrarseOrganizador());
			pnRegistroOrganizador.add(getLbRegistroOrganizador());
			pnRegistroOrganizador.add(getLbDniOrganizador());
			pnRegistroOrganizador.add(getLbContrasena());
			pnRegistroOrganizador.add(getLbNombreOrganizador());
			pnRegistroOrganizador.add(getTxDNIOrganizador());
			pnRegistroOrganizador.add(getTxNombreOrganizador());
			pnRegistroOrganizador.add(getPassOrganizador());
		}
		return pnRegistroOrganizador;
	}
	private JButton getBtRegistrarseOrganizador() {
		if (btRegistrarseOrganizador == null) {
			btRegistrarseOrganizador = new JButton("Registrarse");
			btRegistrarseOrganizador.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					registrarOrganizador();
				}
			});
			btRegistrarseOrganizador.setFont(new Font("Segoe UI Black", Font.PLAIN, 18));
			btRegistrarseOrganizador.setBackground(new Color(50, 130, 181));
			btRegistrarseOrganizador.setBounds(353, 308, 147, 35);
		}
		return btRegistrarseOrganizador;
	}
	private JLabel getLbRegistroOrganizador() {
		if (lbRegistroOrganizador == null) {
			lbRegistroOrganizador = new JLabel("Registro organizador");
			lbRegistroOrganizador.setHorizontalAlignment(SwingConstants.CENTER);
			lbRegistroOrganizador.setForeground(new Color(184, 220, 245));
			lbRegistroOrganizador.setFont(new Font("Segoe UI Black", Font.PLAIN, 18));
			lbRegistroOrganizador.setBackground(new Color(50, 130, 181));
			lbRegistroOrganizador.setBounds(40, 10, 460, 48);
		}
		return lbRegistroOrganizador;
	}
	private JLabel getLbDniOrganizador() {
		if (lbDniOrganizador == null) {
			lbDniOrganizador = new JLabel("DNI");
			lbDniOrganizador.setForeground(new Color(184, 220, 245));
			lbDniOrganizador.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
			lbDniOrganizador.setBounds(10, 72, 183, 34);
		}
		return lbDniOrganizador;
	}
	private JLabel getLbContrasena() {
		if (lbContrasena == null) {
			lbContrasena = new JLabel("Contrase\u00F1a");
			lbContrasena.setForeground(new Color(184, 220, 245));
			lbContrasena.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
			lbContrasena.setBounds(10, 210, 183, 34);
		}
		return lbContrasena;
	}
	private JLabel getLbNombreOrganizador() {
		if (lbNombreOrganizador == null) {
			lbNombreOrganizador = new JLabel("Nombre y apellidos");
			lbNombreOrganizador.setForeground(new Color(184, 220, 245));
			lbNombreOrganizador.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
			lbNombreOrganizador.setBounds(10, 140, 183, 34);
		}
		return lbNombreOrganizador;
	}
	private JTextField getTxDNIOrganizador() {
		if (txDNIOrganizador == null) {
			txDNIOrganizador = new JTextField();
			txDNIOrganizador.setColumns(10);
			txDNIOrganizador.setBounds(214, 76, 286, 34);
		}
		return txDNIOrganizador;
	}
	private JTextField getTxNombreOrganizador() {
		if (txNombreOrganizador == null) {
			txNombreOrganizador = new JTextField();
			txNombreOrganizador.setColumns(10);
			txNombreOrganizador.setBounds(214, 144, 286, 34);
		}
		return txNombreOrganizador;
	}
	private JPasswordField getPassOrganizador() {
		if (passOrganizador == null) {
			passOrganizador = new JPasswordField();
			passOrganizador.setBounds(214, 214, 286, 34);
		}
		return passOrganizador;
	}
	
	
	
	
	//Metodos adiccionales
	
	
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
}
