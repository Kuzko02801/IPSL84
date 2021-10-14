package gui.aplicacion;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPedirEmail extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txEmail;
	private VentanaApp v;


	/**
	 * Create the dialog.
	 * @param ventanaApp 
	 */
	public VentanaPedirEmail(VentanaApp ventanaApp) {
		setModal(true);
		setResizable(false);
		setTitle("Inscripci\u00F3n");
		setBounds(100, 100, 500, 330);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(8, 46, 70));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Para inscribirte escribe tu e-mail");
			lblNewLabel.setForeground(new Color(184,220,245));
			lblNewLabel.setFont(new Font("Segoe UI Black", Font.PLAIN, 18));
			lblNewLabel.setBounds(90, 23, 306, 52);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lbEmail = new JLabel("E-mail:");
			lbEmail.setForeground(new Color(184,220,245));
			lbEmail.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
			lbEmail.setBounds(10, 130, 124, 41);
			contentPanel.add(lbEmail);
		}
		{
			txEmail = new JTextField();
			txEmail.setBackground(new Color(255, 255, 255));
			txEmail.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
			txEmail.setBounds(144, 130, 332, 41);
			contentPanel.add(txEmail);
			txEmail.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(8, 46, 70));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btInscribir = new JButton("Inscribir");
				btInscribir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//si el email es valido
						String email=txEmail.getText();
						v.inscribirAtletaCarrera(email);
						dispose();
					}

					
				});
				btInscribir.setForeground(new Color(184,220,245));
				btInscribir.setBackground(new Color(50, 130, 181));
				btInscribir.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
				buttonPane.add(btInscribir);
			}
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnCancelar.setForeground(new Color(184,220,245));
				btnCancelar.setBackground(new Color(50, 130, 181));
				btnCancelar.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
				buttonPane.add(btnCancelar);
			}
		}
	}

}
