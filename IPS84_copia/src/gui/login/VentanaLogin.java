package gui.login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaLogin extends JFrame {

	private JPanel contentPane;
	private JPanel pnLogin;
	private JLabel lbBienvenido;
	private JTextField txUsuario;
	private JButton btLogin;
	private JLabel lbDni;
	private JLabel lbContrasena;
	private JTextField txPassword;
	private JButton btRegistro;
	/**
	 * Create the frame.
	 */
	public VentanaLogin() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(8, 46, 70));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(129)
					.addComponent(getPnLogin(), GroupLayout.PREFERRED_SIZE, 301, Short.MAX_VALUE)
					.addGap(146))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(getPnLogin(), GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
	private JPanel getPnLogin() {
		if (pnLogin == null) {
			pnLogin = new JPanel();
			pnLogin.setBackground(new Color(50, 130, 181));
			GroupLayout gl_pnLogin = new GroupLayout(pnLogin);
			gl_pnLogin.setHorizontalGroup(
				gl_pnLogin.createParallelGroup(Alignment.TRAILING)
					.addGroup(gl_pnLogin.createSequentialGroup()
						.addGap(101)
						.addComponent(getLbBienvenido(), GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGap(109))
					.addGroup(gl_pnLogin.createSequentialGroup()
						.addContainerGap()
						.addComponent(getLbDni(), GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
						.addGap(142))
					.addGroup(gl_pnLogin.createSequentialGroup()
						.addContainerGap()
						.addComponent(getLbContrasena(), GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
						.addGap(206))
					.addGroup(gl_pnLogin.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_pnLogin.createParallelGroup(Alignment.TRAILING)
							.addComponent(getBtLogin(), Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
							.addComponent(getTextField_2(), Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
							.addComponent(getTxUsuario(), GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
							.addComponent(getBtRegistro()))
						.addGap(18))
			);
			gl_pnLogin.setVerticalGroup(
				gl_pnLogin.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_pnLogin.createSequentialGroup()
						.addContainerGap()
						.addComponent(getLbBienvenido(), GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
						.addGap(18)
						.addComponent(getLbDni(), GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(getTxUsuario(), GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(getLbContrasena(), GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(getTextField_2(), GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(getBtLogin(), GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
						.addGap(18)
						.addComponent(getBtRegistro(), GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
			);
			pnLogin.setLayout(gl_pnLogin);
		}
		return pnLogin;
	}
	private JLabel getLbBienvenido() {
		if (lbBienvenido == null) {
			lbBienvenido = new JLabel("Bienvenido");
			lbBienvenido.setForeground(new Color(184, 220, 245));
			lbBienvenido.setFont(new Font("Segoe UI Black", Font.PLAIN, 18));
			lbBienvenido.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lbBienvenido;
	}
	private JTextField getTxUsuario() {
		if (txUsuario == null) {
			txUsuario = new JTextField();
			txUsuario.setColumns(10);
		}
		return txUsuario;
	}
	private JButton getBtLogin() {
		if (btLogin == null) {
			btLogin = new JButton("Login");
			btLogin.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
			btLogin.setBackground(new Color(187,225,248));
			btLogin.setForeground(Color.BLACK);
		}
		return btLogin;
	}
	private JLabel getLbDni() {
		if (lbDni == null) {
			lbDni = new JLabel("DNI");
			lbDni.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
			lbDni.setForeground(new Color(184, 220, 245));
		}
		return lbDni;
	}
	private JLabel getLbContrasena() {
		if (lbContrasena == null) {
			lbContrasena = new JLabel("Contrase\u00F1a");
			lbContrasena.setForeground(new Color(184, 220, 245));
			lbContrasena.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
		}
		return lbContrasena;
	}
	private JTextField getTextField_2() {
		if (txPassword == null) {
			txPassword = new JTextField();
			txPassword.setColumns(10);
		}
		return txPassword;
	}
	
	
	
	private JButton getBtRegistro() {
		if (btRegistro == null) {
			btRegistro = new JButton("\u00BFNo tienes cuenta? Reg\u00EDstrate");
			btRegistro.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarVentanaRegistro();
				}
			});
			btRegistro.setForeground(new Color(184,220,245));
			btRegistro.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
			btRegistro.setBackground(new Color(50, 130, 181));
		}
		return btRegistro;
	}
	
	//metodos 
	
	private void mostrarVentanaRegistro() {
		VentanaRegistro v=new VentanaRegistro();
		v.setVisible(true);
		dispose();
	}
}
