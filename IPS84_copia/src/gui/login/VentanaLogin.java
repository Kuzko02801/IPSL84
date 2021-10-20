package gui.login;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import gui.aplicacion.VentanaApp;

public class VentanaLogin extends JFrame {

	private JPanel contentPane;
	private JPanel pnLogin;
	private JLabel lbBienvenido;
	private JTextField txUsuario;
	private JButton btLogin;
	private JLabel lbEmail;
	private JButton btRegistro;
	private JTextField txUsuarioValido;
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
						.addComponent(getLbEmail(), GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
						.addGap(142))
					.addGroup(Alignment.LEADING, gl_pnLogin.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_pnLogin.createParallelGroup(Alignment.LEADING)
							.addComponent(getTxUsuarioValido(), Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
							.addComponent(getBtLogin(), GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
							.addComponent(getTxUsuario(), Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
							.addComponent(getBtRegistro(), Alignment.TRAILING))
						.addGap(18))
			);
			gl_pnLogin.setVerticalGroup(
				gl_pnLogin.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_pnLogin.createSequentialGroup()
						.addContainerGap()
						.addComponent(getLbBienvenido(), GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
						.addGap(18)
						.addComponent(getLbEmail(), GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(getTxUsuario(), GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addGap(64)
						.addComponent(getTxUsuarioValido(), GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
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
			btLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					login();
				}
			});
			btLogin.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
			btLogin.setBackground(new Color(187,225,248));
			btLogin.setForeground(Color.BLACK);
		}
		return btLogin;
	}
	private JLabel getLbEmail() {
		if (lbEmail == null) {
			lbEmail = new JLabel("E-mail");
			lbEmail.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
			lbEmail.setForeground(new Color(184, 220, 245));
		}
		return lbEmail;
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
	private JTextField getTxUsuarioValido() {
		if (txUsuarioValido == null) {
			txUsuarioValido = new JTextField();
			txUsuarioValido.setBackground(Color.BLACK);
			txUsuarioValido.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txUsuarioValido.setHorizontalAlignment(SwingConstants.CENTER);
			txUsuarioValido.setForeground(new Color(255, 0, 0));
			txUsuarioValido.setEnabled(false);
			txUsuarioValido.setEditable(false);
			txUsuarioValido.setColumns(10);
		}
		return txUsuarioValido;
	}
	
	//metodos 
	
	private void login() {
		if(getTxUsuario().getText().equals("admin")) {
			mostrarVentanaApp(0);
		}else {
			mostrarVentanaApp(1);
		}
	}
	private void mostrarVentanaApp(int modo) {
		VentanaApp v=new VentanaApp(modo);
		v.setVisible(true);
		dispose();
	}
	private void mostrarVentanaRegistro() {
		VentanaRegistro v=new VentanaRegistro();
		v.setVisible(true);
		dispose();
	}
	
}
