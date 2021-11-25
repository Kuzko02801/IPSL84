package gui.login;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import business.dataaccess.exception.BusinessDataException;
import business.gui.GuiLogic;

public class DialogListaDeEpera extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogListaDeEpera(String id_carrera) {
		setAlwaysOnTop(true);
		setModal(true);
		setBounds(100, 100, 270, 146);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblDeseaListaDeEspera = new JLabel(
					"<html>\u00BFDesea apuntarse a la lista<br> de espera de esta carrera?</html>");
			lblDeseaListaDeEspera.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblDeseaListaDeEspera.setBounds(34, 23, 191, 40);
			contentPanel.add(lblDeseaListaDeEspera);
		}
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			{
				JButton btnSi = new JButton("Si");
				btnSi.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						mostrarPuestoListaEspera();
					}

					private void mostrarPuestoListaEspera() {
						try {
							JOptionPane.showMessageDialog(null, String.format("Su puesto en la lista de espera es %d",
									GuiLogic.numeroListaDeEspera(id_carrera)));
							dispose();
						} catch (HeadlessException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (BusinessDataException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});
				buttonPane.add(btnSi);
			}
			{
				JButton btnNo = new JButton("No");
				btnNo.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				buttonPane.add(btnNo);
			}
		}
	}

}
