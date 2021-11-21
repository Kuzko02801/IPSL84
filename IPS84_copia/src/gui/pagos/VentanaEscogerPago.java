package gui.pagos;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import gui.aplicacion.VentanaApp;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaEscogerPago extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel pnPrincipal;
	private JLabel lbEscoger;
	private JButton btTransferencia;
	private JButton btTarjeta;
	private String id_carrera;
	private VentanaApp v;
	private String email;

	/**
	 * Create the frame.
	 */
	public VentanaEscogerPago(VentanaApp v, String id_carrera, String email) {
		this.v = v;
		this.id_carrera = id_carrera;
		this.email = email;
		setResizable(false);
		setModal(true);
		setTitle("M\u00E9todo");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 530, 345);
		pnPrincipal = new JPanel();
		pnPrincipal.setBackground(new Color(8, 46, 70));
		pnPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pnPrincipal);
		GroupLayout gl_pnPrincipal = new GroupLayout(pnPrincipal);
		gl_pnPrincipal.setHorizontalGroup(gl_pnPrincipal.createParallelGroup(Alignment.LEADING).addGroup(gl_pnPrincipal
				.createSequentialGroup()
				.addGroup(gl_pnPrincipal.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnPrincipal.createSequentialGroup().addGap(110).addComponent(getLbEscoger(),
								GroupLayout.PREFERRED_SIZE, 269, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnPrincipal.createSequentialGroup().addGap(85).addComponent(getBtTransferencia())
								.addGap(71).addComponent(getBtTarjeta(), GroupLayout.PREFERRED_SIZE, 117,
										GroupLayout.PREFERRED_SIZE)))
				.addContainerGap(116, Short.MAX_VALUE)));
		gl_pnPrincipal.setVerticalGroup(gl_pnPrincipal.createParallelGroup(Alignment.LEADING).addGroup(gl_pnPrincipal
				.createSequentialGroup().addGap(39).addComponent(getLbEscoger()).addGap(72)
				.addGroup(gl_pnPrincipal.createParallelGroup(Alignment.LEADING).addComponent(getBtTransferencia())
						.addComponent(getBtTarjeta(), GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
				.addContainerGap(137, Short.MAX_VALUE)));
		pnPrincipal.setLayout(gl_pnPrincipal);
	}

	private JLabel getLbEscoger() {
		if (lbEscoger == null) {
			lbEscoger = new JLabel("Escoger m\u00E9todo pago");
			lbEscoger.setForeground(new Color(184, 220, 245));
			lbEscoger.setHorizontalAlignment(SwingConstants.CENTER);
			lbEscoger.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
		}
		return lbEscoger;
	}

	private JButton getBtTransferencia() {
		if (btTransferencia == null) {
			btTransferencia = new JButton("Tranferencia");
			btTransferencia.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarVentanaTransferencia();
				}
			});
			btTransferencia.setForeground(new Color(184, 220, 245));
			btTransferencia.setBackground(new Color(50, 130, 181));
			btTransferencia.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		}
		return btTransferencia;
	}

	private JButton getBtTarjeta() {
		if (btTarjeta == null) {
			btTarjeta = new JButton("Tarjeta");
			btTarjeta.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarVentanaTarjeta();
				}
			});
			btTarjeta.setForeground(new Color(184, 220, 245));
			btTarjeta.setBackground(new Color(50, 130, 181));
			btTarjeta.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		}
		return btTarjeta;
	}

	private void mostrarVentanaTarjeta() {
		VentanaPagoTarjeta vpt = new VentanaPagoTarjeta(v, id_carrera, email);
		vpt.setVisible(true);
		dispose();
	}

	private void mostrarVentanaTransferencia() {
		VentanaPagoTransferencia vpt = new VentanaPagoTransferencia(v, id_carrera, email);
		vpt.setVisible(true);
		dispose();
	}
}
