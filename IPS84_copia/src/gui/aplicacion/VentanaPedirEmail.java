package gui.aplicacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import business.dataaccess.BusinessDataException;
import business.gui.GuiLogic;
import java.awt.Color;
import java.awt.Dialog;

public class VentanaPedirEmail extends JFrame {

	private JPanel contentPane;
	private JPanel buttonPane;
	private JPanel textPane;
	private JButton btnInscribir;
	private JButton btnCancelar;
	private JTextField txtEmail;
	private JLabel lblEmail;
	private JLabel lblNewLabel;
	private String id_carrera;
	private JLabel lblWarning;
	private VentanaPagoTarjeta vpt = new VentanaPagoTarjeta(this);
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPedirEmail frame = new VentanaPedirEmail("TEST");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPedirEmail(String id_carrera) {
		this.id_carrera = id_carrera;
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getButtonPane(), BorderLayout.SOUTH);
		contentPane.add(getTextPane());
	}
	private JPanel getButtonPane() {
		if (buttonPane == null) {
			buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			buttonPane.add(getBtnInscribir());
			buttonPane.add(getBtnCancelar());
		}
		return buttonPane;
	}
	private JPanel getTextPane() {
		if (textPane == null) {
			textPane = new JPanel();
			textPane.setLayout(null);
			textPane.add(getTxtEmail());
			textPane.add(getLblEmail());
			textPane.add(getLblNewLabel());
			textPane.add(getLblWarning());
		}
		return textPane;
	}
	private JButton getBtnInscribir() {
		if (btnInscribir == null) {
			btnInscribir = new JButton("Inscribirse");
			btnInscribir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						GuiLogic.inscribirAtletaCarrera(id_carrera, getTxtEmail().getText());
						vpt.setVisible(true);
					} catch (BusinessDataException e1) {
						getLblWarning().setText(e1.getMessage());
						getLblWarning().setEnabled(true);
					}
				}
			});
		}
		return btnInscribir;
	}
	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");
		}
		return btnCancelar;
	}
	private JTextField getTxtEmail() {
		if (txtEmail == null) {
			txtEmail = new JTextField();
			txtEmail.setText("");
			txtEmail.setBounds(80, 107, 293, 28);
			txtEmail.setColumns(10);
		}
		return txtEmail;
	}
	private JLabel getLblEmail() {
		if (lblEmail == null) {
			lblEmail = new JLabel("E-mail:");
			lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblEmail.setBounds(24, 112, 46, 14);
		}
		return lblEmail;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Para inscribirte escribe tu e-mail");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblNewLabel.setBounds(80, 22, 293, 37);
		}
		return lblNewLabel;
	}
	private JLabel getLblWarning() {
		if (lblWarning == null) {
			lblWarning = new JLabel("");
			lblWarning.setEnabled(false);
			lblWarning.setForeground(Color.RED);
			lblWarning.setBounds(80, 68, 314, 28);
		}
		return lblWarning;
	}
}
