package gui.pagos;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import business.dataaccess.exception.BusinessDataException;
import business.dataaccess.util.Check;
import business.gui.GuiLogic;
import gui.aplicacion.VentanaApp;
import gui.validadoresGUI.Validadores;

import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPagoTransferencia extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel pnPrincipal;
	private JButton btPagar;
	private JTextField txIban;
	private JTextField txCantidad;
	private JLabel lbDatos;
	private JLabel lbCantidad;
	private JLabel lbIban;
	private JLabel lbCuotaActual;
	private JTextField txCuotaActual;
	private String id_carrera;
	private VentanaApp v;
	private String email;
	private double cuotaActual;
	

	/**
	 * Create the frame.
	 * @param email 
	 * @param id_carrera 
	 * @param v 
	 */
	public VentanaPagoTransferencia(VentanaApp v, String id_carrera, String email) {
		this.v=v;
		this.id_carrera=id_carrera;
		this.email=email;
		this.cuotaActual=GuiLogic.cuotaActualCarrera(id_carrera) - GuiLogic.obtenerCantidadPagada(email, id_carrera);
		setTitle("Tranferencia");
		setModal(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 350);
		pnPrincipal = new JPanel();
		pnPrincipal.setBackground(new Color(8, 46, 70));
		pnPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pnPrincipal);
		GroupLayout gl_pnPrincipal = new GroupLayout(pnPrincipal);
		gl_pnPrincipal.setHorizontalGroup(
			gl_pnPrincipal.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_pnPrincipal.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnPrincipal.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnPrincipal.createSequentialGroup()
							.addGroup(gl_pnPrincipal.createParallelGroup(Alignment.LEADING)
								.addComponent(getLbIban(), GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(getLbCuotaActual(), GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(gl_pnPrincipal.createSequentialGroup()
							.addComponent(getLbCantidad(), GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
							.addGap(29)))
					.addGroup(gl_pnPrincipal.createParallelGroup(Alignment.LEADING)
						.addComponent(getBtPagar(), GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_pnPrincipal.createParallelGroup(Alignment.LEADING, false)
							.addComponent(getTxCantidad())
							.addComponent(getLbDatos(), GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
							.addComponent(getTxCuotaActual(), GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
							.addComponent(getTxIban(), GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)))
					.addGap(132))
		);
		gl_pnPrincipal.setVerticalGroup(
			gl_pnPrincipal.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnPrincipal.createSequentialGroup()
					.addContainerGap()
					.addComponent(getLbDatos())
					.addGap(23)
					.addGroup(gl_pnPrincipal.createParallelGroup(Alignment.BASELINE)
						.addComponent(getTxCuotaActual(), GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(getLbCuotaActual(), GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addGap(12)
					.addGroup(gl_pnPrincipal.createParallelGroup(Alignment.BASELINE)
						.addComponent(getLbIban(), GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(getTxIban(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_pnPrincipal.createParallelGroup(Alignment.BASELINE)
						.addComponent(getLbCantidad(), GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(getTxCantidad(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(40)
					.addComponent(getBtPagar())
					.addGap(81))
		);
		pnPrincipal.setLayout(gl_pnPrincipal);
	}
	

	private JButton getBtPagar() {
		if (btPagar == null) {
			btPagar = new JButton("Pagar");
			btPagar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					pagar();
				}
			});
			btPagar.setBackground(new Color(50, 130, 181));
			btPagar.setForeground(new Color(184,220,245));
			btPagar.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
		}
		return btPagar;
	}
	private JTextField getTxIban() {
		if (txIban == null) {
			txIban = new JTextField();
			txIban.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
			txIban.setColumns(10);
		}
		return txIban;
	}
	private JTextField getTxCantidad() {
		if (txCantidad == null) {
			txCantidad = new JTextField();
			txCantidad.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
			txCantidad.setColumns(10);
		}
		return txCantidad;
	}
	private JLabel getLbDatos() {
		if (lbDatos == null) {
			lbDatos = new JLabel("Datos");
			lbDatos.setForeground(new Color(184,220,245));
			lbDatos.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
		}
		return lbDatos;
	}
	private JLabel getLbCantidad() {
		if (lbCantidad == null) {
			lbCantidad = new JLabel("Cantidad a pagar");
			lbCantidad.setForeground(new Color(184,220,245));
			lbCantidad.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
		}
		return lbCantidad;
	}
	private JLabel getLbIban() {
		if (lbIban == null) {
			lbIban = new JLabel("IBAN");
			lbIban.setForeground(new Color(184,220,245));
			lbIban.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
		}
		return lbIban;
	}
	private JLabel getLbCuotaActual() {
		if (lbCuotaActual == null) {
			lbCuotaActual = new JLabel("Cuota Actual");
			lbCuotaActual.setForeground(new Color(184, 220, 245));
			lbCuotaActual.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
		}
		return lbCuotaActual;
	}
	private JTextField getTxCuotaActual() {
		if (txCuotaActual == null) {
			txCuotaActual = new JTextField();
			txCuotaActual.setText(""+cuotaActual);
			txCuotaActual.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
			txCuotaActual.setColumns(10);
		}
		return txCuotaActual;
	}
	private void pagar() {
		if(comprobarCampos()) {
			double pagado=Double.parseDouble(getTxCantidad().getText());
			if (pagoFueraDePlazo()) {
				JOptionPane.showMessageDialog(this, "Te hemos desinscrito de la carrera por no poder realizar el pago a tiempo");
				GuiLogic.cancelarInscripcion(email, id_carrera);
			}
			else {
				if(pagado>this.cuotaActual) {
					GuiLogic.pagarInscripcion(id_carrera, email);
					GuiLogic.procesarPagos
					(id_carrera,email,cuotaActual,pagado,"Pagado con transferencia. Ha pagado "+(pagado-cuotaActual)+" de más");
					GuiLogic.actualizarCantidadPagada(id_carrera, email, pagado);
					JOptionPane.showMessageDialog(this, "Has pagado más de la cuota total. "
							+ "Atleta inscrito correctamente. Se le remunera con " + (pagado-cuotaActual) + "€", "Info", JOptionPane.INFORMATION_MESSAGE);
					cerrar();
				}else if(pagado==this.cuotaActual) {
					GuiLogic.pagarInscripcion(id_carrera, email);
					GuiLogic.procesarPagos
					(id_carrera,email,cuotaActual,cuotaActual,"Pagado con transferencia. Pagado correctamente");
					GuiLogic.actualizarCantidadPagada(id_carrera, email, pagado);
					JOptionPane.showMessageDialog(this, "Has pagado la cuota total. Atleta inscrito correctamente", "Info", JOptionPane.INFORMATION_MESSAGE);
					cerrar();
				}else{
					JOptionPane.showMessageDialog(this, "Has pagado menos dinero que la cuota actual", "Error", JOptionPane.ERROR_MESSAGE);
					GuiLogic.procesarPagos
					(id_carrera,email,cuotaActual,pagado,"Pagado con transferencia. Pagado "+(cuotaActual-pagado)+" no se le inscribe aún.");
					GuiLogic.actualizarCantidadPagada(id_carrera, email, pagado);
					cerrar();
				}
			}
		}
	}
	private boolean pagoFueraDePlazo() {
		try {
			return Check.pagoFueraDePlazo(id_carrera, email);
		} catch (BusinessDataException e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
		}
		return false;
	}


	private void cerrar(){
		v.mostrarTodasCarrerasParticipante();
		dispose();
	}


	private boolean comprobarCampos() {
		if(Validadores.comprobarNoVacio(getTxIban().getText())&&Validadores.comprobarDouble(getTxCantidad().getText())) {
			return true;
		}else {
			JOptionPane.showMessageDialog(this, "Comprueba los campos", "Error", JOptionPane.WARNING_MESSAGE);
			return false;
		}
	}
	
}
