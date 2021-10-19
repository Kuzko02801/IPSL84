package gui.aplicacion;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JTextField;

import business.dataaccess.BusinessDataException;
import business.gui.GuiLogic;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPedirEmail extends JDialog {
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
	private JLabel lblWarning;
	private String id_carrera;
	private VentanaPagoTarjeta vpt = new VentanaPagoTarjeta(this);
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPedirEmail dialog = new VentanaPedirEmail("A1");
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public VentanaPedirEmail(String id_carrera) {
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
			pnText.setLayout(null);
			pnText.add(getTxtEmail());
			pnText.add(getLblEmail());
			pnText.add(getLblNewLabel());
			pnText.add(getLblWarning());
		}
		return pnText;
	}
	private JPanel getPnButtons() {
		if (pnButtons == null) {
			pnButtons = new JPanel();
			pnButtons.add(getBtnInscribir());
			pnButtons.add(getBtnCancelar());
		}
		return pnButtons;
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
			txtEmail.setBounds(75, 95, 284, 25);
			txtEmail.setText("");
			txtEmail.setColumns(10);
		}
		return txtEmail;
	}
	private JLabel getLblEmail() {
		if (lblEmail == null) {
			lblEmail = new JLabel("E-mail:");
			lblEmail.setBounds(22, 99, 43, 19);
			lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		}
		return lblEmail;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Para inscribirte escribe tu e-mail");
			lblNewLabel.setBounds(71, 36, 288, 25);
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		}
		return lblNewLabel;
	}
	private JLabel getLblWarning() {
		if (lblWarning == null) {
			lblWarning = new JLabel("");
			lblWarning.setBounds(217, 35, 0, 0);
			lblWarning.setForeground(Color.RED);
			lblWarning.setEnabled(false);
		}
		return lblWarning;
	}
}
