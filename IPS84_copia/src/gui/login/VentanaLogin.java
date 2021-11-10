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

import business.gui.GuiLogic;
import gui.aplicacion.VentanaApp;

public class VentanaLogin extends JFrame {

	private JPanel contentPane;
	private JPanel pnLogin;
	private JLabel lbBienvenido;
	private JButton btLogin;
	private JButton btLoginAdmin;

	/**
	 * Create the frame.
	 */
	public VentanaLogin() {
		setResizable(false);
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(8, 46, 70));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(129)
						.addComponent(getPnLogin(), GroupLayout.PREFERRED_SIZE, 301, Short.MAX_VALUE).addGap(146)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
						.addComponent(getPnLogin(), GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE).addContainerGap()));
		contentPane.setLayout(gl_contentPane);
	}

	private JPanel getPnLogin() {
		if (pnLogin == null) {
			pnLogin = new JPanel();
			pnLogin.setBackground(new Color(50, 130, 181));
			GroupLayout gl_pnLogin = new GroupLayout(pnLogin);
			gl_pnLogin.setHorizontalGroup(gl_pnLogin.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_pnLogin.createSequentialGroup().addGap(101)
							.addComponent(getLbBienvenido(), GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
									Short.MAX_VALUE)
							.addGap(109))
					.addGroup(gl_pnLogin.createSequentialGroup().addContainerGap()
							.addGroup(gl_pnLogin.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(getBtLoginParticipante(), Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
											GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(getBtLoginAdmin(), Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 278,
											Short.MAX_VALUE))
							.addContainerGap(13, Short.MAX_VALUE)));
			gl_pnLogin.setVerticalGroup(gl_pnLogin.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_pnLogin.createSequentialGroup().addContainerGap()
							.addComponent(getLbBienvenido(), GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE).addGap(103)
							.addComponent(getBtLoginParticipante(), GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
									Short.MAX_VALUE)
							.addGap(70)
							.addComponent(getBtLoginAdmin(), GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
							.addGap(62)));
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

	private JButton getBtLoginParticipante() {
		if (btLogin == null) {
			btLogin = new JButton("Login Participante");
			btLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					loginParticipante();
				}
			});
			btLogin.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
			btLogin.setBackground(new Color(187, 225, 248));
			btLogin.setForeground(Color.BLACK);
		}
		return btLogin;
	}


	private JButton getBtLoginAdmin() {
		if (btLoginAdmin == null) {
			btLoginAdmin = new JButton("Login Admin");
			btLoginAdmin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					loginAdmin();
				}
			});
			btLoginAdmin.setForeground(Color.BLACK);
			btLoginAdmin.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
			btLoginAdmin.setBackground(new Color(187, 225, 248));
		}
		return btLoginAdmin;
	}
	
	private void loginParticipante() {
		mostrarVentanaApp(VentanaApp.PARTICIPANTE);
	}

	private void loginAdmin() {
		mostrarVentanaApp(VentanaApp.ADMIN);
	}

	private void mostrarVentanaApp(int mode) {
		VentanaApp v = new VentanaApp(mode);
		v.setVisible(true);
		dispose();
	}
}
