package gui.aplicacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import java.awt.Font;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.SystemColor;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaApp extends JFrame {

	private JPanel pnPrincipal;
	private JPanel pnParticipante;
	private JPanel pnBotonesParticipante;
	private JPanel pnBotonesOrdenarParticipante;
	private JScrollPane scrollPaneTabla;
	private JTable tablaCarrerasParticipante;
	private JButton btOrdenar;
	private JComboBox cbCarreras;
	private JMenuBar menuBar;
	private JMenu mnCuenta;
	private JMenu mnOrganizador;
	private JMenu mnParticipante;
	private JPanel pnBotonesInscribirseParticipante;
	private JButton btInscribirseParticipante;
	private JTextField txIdCarreraParticipante;
	private JLabel lbIDCarreraParticipante;
	private JMenuItem mnItemCuentaSalir;
	private JPanel pnOrganizador;
	private JPanel pnBotonesOrganizador;
	private JPanel pnBotonesOrdenarParticipante_1;
	private JButton btMostrarClasificaciones;
	private JComboBox cbClasificaciones;
	private JPanel pnBotonesInscribirseParticipante_1;
	private JButton btInscribirseParticipante_1;
	private JLabel lbIDCarreraParticipante_1;
	private JTextField textField;
	private JPanel pnTablasOrganizador;
	private JScrollPane scrollPaneCarrerasOrganizador;
	private JScrollPane scrollPaneParticipantes;
	private JTable tablaCarrerasOrganizador;
	private JTable tablaParticipantes;
	private JScrollPane scrollPaneClasificacionesAbsolutas;
	private JTable tablaClasificacionesAbsoluta;
	private JPanel pnClasificacionesSexo;
	private JScrollPane scrollPaneClasificacionesHombre;
	private JScrollPane scrollPaneClasificacionesMujer;
	private JTable tablaClasificacionesHombre;
	private JTable tablaClasificacionesMujer;
	private JTextField txIdCarreraValida;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	private JButton btMostrarCarreras;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaApp frame = new VentanaApp();
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
	public VentanaApp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setJMenuBar(getMenuBar_1());
		pnPrincipal = new JPanel();
		pnPrincipal.setBackground(new Color(8, 46, 70));
		pnPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pnPrincipal);
		pnPrincipal.setLayout(new CardLayout(0, 0));
		pnPrincipal.add(getPnParticipante(), "pnParticipante");
		pnPrincipal.add(getPnOrganizador(), "pnOrganizador");
	}
	private JPanel getPnParticipante() {
		if (pnParticipante == null) {
			pnParticipante = new JPanel();
			pnParticipante.setBackground(new Color(8, 46, 70));
			pnParticipante.setBorder(new EmptyBorder(5, 5, 5, 5));
			GroupLayout gl_pnParticipante = new GroupLayout(pnParticipante);
			gl_pnParticipante.setHorizontalGroup(
				gl_pnParticipante.createParallelGroup(Alignment.TRAILING)
					.addGroup(gl_pnParticipante.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_pnParticipante.createParallelGroup(Alignment.TRAILING)
							.addComponent(getScrollPaneTabla(), Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 746, Short.MAX_VALUE)
							.addComponent(getPnBotonesParticipante(), Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 746, Short.MAX_VALUE))
						.addContainerGap())
			);
			gl_pnParticipante.setVerticalGroup(
				gl_pnParticipante.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_pnParticipante.createSequentialGroup()
						.addContainerGap()
						.addComponent(getPnBotonesParticipante(), GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(getScrollPaneTabla(), GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
						.addContainerGap())
			);
			pnParticipante.setLayout(gl_pnParticipante);
		}
		return pnParticipante;
	}
	private JPanel getPnBotonesParticipante() {
		if (pnBotonesParticipante == null) {
			pnBotonesParticipante = new JPanel();
			pnBotonesParticipante.setBackground(new Color(8, 46, 70));
			GroupLayout gl_pnBotonesParticipante = new GroupLayout(pnBotonesParticipante);
			gl_pnBotonesParticipante.setHorizontalGroup(
				gl_pnBotonesParticipante.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_pnBotonesParticipante.createSequentialGroup()
						.addComponent(getPnBotonesOrdenarParticipante(), GroupLayout.DEFAULT_SIZE, 746, Short.MAX_VALUE)
						.addContainerGap())
					.addComponent(getPnBotonesInscribirseParticipante(), GroupLayout.DEFAULT_SIZE, 746, Short.MAX_VALUE)
			);
			gl_pnBotonesParticipante.setVerticalGroup(
				gl_pnBotonesParticipante.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_pnBotonesParticipante.createSequentialGroup()
						.addComponent(getPnBotonesInscribirseParticipante(), GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(getPnBotonesOrdenarParticipante(), GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(44, Short.MAX_VALUE))
			);
			pnBotonesParticipante.setLayout(gl_pnBotonesParticipante);
		}
		return pnBotonesParticipante;
	}
	private JPanel getPnBotonesOrdenarParticipante() {
		if (pnBotonesOrdenarParticipante == null) {
			pnBotonesOrdenarParticipante = new JPanel();
			pnBotonesOrdenarParticipante.setBackground(new Color(8, 46, 70));
			GroupLayout gl_pnBotonesOrdenarParticipante = new GroupLayout(pnBotonesOrdenarParticipante);
			gl_pnBotonesOrdenarParticipante.setHorizontalGroup(
				gl_pnBotonesOrdenarParticipante.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_pnBotonesOrdenarParticipante.createSequentialGroup()
						.addComponent(getBtOrdenar(), GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(getCbCarreras(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(428))
			);
			gl_pnBotonesOrdenarParticipante.setVerticalGroup(
				gl_pnBotonesOrdenarParticipante.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_pnBotonesOrdenarParticipante.createParallelGroup(Alignment.BASELINE)
						.addComponent(getBtOrdenar(), GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
						.addComponent(getCbCarreras(), GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
			);
			pnBotonesOrdenarParticipante.setLayout(gl_pnBotonesOrdenarParticipante);
		}
		return pnBotonesOrdenarParticipante;
	}
	private JScrollPane getScrollPaneTabla() {
		if (scrollPaneTabla == null) {
			scrollPaneTabla = new JScrollPane();
			scrollPaneTabla.setBackground(new Color(50, 130, 181));
			scrollPaneTabla.setViewportView(getTablaCarrerasParticipante());
		}
		return scrollPaneTabla;
	}
	private JTable getTablaCarrerasParticipante() {
		if (tablaCarrerasParticipante == null) {
			tablaCarrerasParticipante = new JTable();
			tablaCarrerasParticipante.setSelectionBackground(new Color(50,130,181));
			tablaCarrerasParticipante.setSelectionForeground(new Color(184,220,245));
			tablaCarrerasParticipante.setForeground(new Color(184,220,245));
			tablaCarrerasParticipante.setBackground(new Color(50, 130, 181));
			tablaCarrerasParticipante.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
			tablaCarrerasParticipante.setRowHeight(25);
			tablaCarrerasParticipante.setModel(new DefaultTableModel(
				new Object[][] {
					{"", null, null, null, null, null, null, null, null},
				},
				new String[] {
					"Estado inscripci\u00F3n", "ID Carrera", "Nombre carrera", "Fecha carrera", "Tipo carrera", "Distancia (km)asd", "Cuota inscripci\u00F3n", "Final inscripci\u00F3n", "Plazas"
				}
			) {
				Class[] columnTypes = new Class[] {
					Object.class, String.class, String.class, String.class, String.class, Integer.class, Integer.class, String.class, Integer.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
			});
		}
		return tablaCarrerasParticipante;
	}
	private JButton getBtOrdenar() {
		if (btOrdenar == null) {
			btOrdenar = new JButton("Mostrar");
			btOrdenar.setForeground(new Color(184,220,245));
			btOrdenar.setBackground(new Color(50, 130, 181));
		}
		return btOrdenar;
	}
	private JComboBox getCbCarreras() {
		if (cbCarreras == null) {
			cbCarreras = new JComboBox();
			cbCarreras.setForeground(new Color(184,220,245));
			cbCarreras.setBackground(new Color(50, 130, 181));
			cbCarreras.setModel(new DefaultComboBoxModel(new String[] {"Mis carreras", "Todas las carreras"}));
		}
		return cbCarreras;
	}
	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnCuenta());
			menuBar.add(getMnOrganizador());
			menuBar.add(getMnParticipante());
		}
		return menuBar;
	}
	private JMenu getMnCuenta() {
		if (mnCuenta == null) {
			mnCuenta = new JMenu("Cuenta");
			mnCuenta.add(getMntmNewMenuItem_1());
			mnCuenta.add(getMntmNewMenuItem());
			mnCuenta.add(getMnItemCuentaSalir());
		}
		return mnCuenta;
	}
	private JMenu getMnOrganizador() {
		if (mnOrganizador == null) {
			mnOrganizador = new JMenu("Organizador");
			mnOrganizador.setEnabled(false);
		}
		return mnOrganizador;
	}
	private JMenu getMnParticipante() {
		if (mnParticipante == null) {
			mnParticipante = new JMenu("Participante");
			mnParticipante.setEnabled(false);
		}
		return mnParticipante;
	}
	private JPanel getPnBotonesInscribirseParticipante() {
		if (pnBotonesInscribirseParticipante == null) {
			pnBotonesInscribirseParticipante = new JPanel();
			pnBotonesInscribirseParticipante.setBackground(new Color(8, 46, 70));
			GroupLayout gl_pnBotonesInscribirseParticipante = new GroupLayout(pnBotonesInscribirseParticipante);
			gl_pnBotonesInscribirseParticipante.setHorizontalGroup(
				gl_pnBotonesInscribirseParticipante.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_pnBotonesInscribirseParticipante.createSequentialGroup()
						.addComponent(getBtInscribirseParticipante(), GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_pnBotonesInscribirseParticipante.createParallelGroup(Alignment.LEADING)
							.addComponent(getLbIDCarreraParticipante())
							.addComponent(getTxIdCarreraParticipante(), GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE))
						.addGap(436))
			);
			gl_pnBotonesInscribirseParticipante.setVerticalGroup(
				gl_pnBotonesInscribirseParticipante.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_pnBotonesInscribirseParticipante.createSequentialGroup()
						.addComponent(getLbIDCarreraParticipante())
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_pnBotonesInscribirseParticipante.createParallelGroup(Alignment.BASELINE)
							.addComponent(getBtInscribirseParticipante(), GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
							.addComponent(getTxIdCarreraParticipante(), GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)))
			);
			pnBotonesInscribirseParticipante.setLayout(gl_pnBotonesInscribirseParticipante);
		}
		return pnBotonesInscribirseParticipante;
	}
	private JButton getBtInscribirseParticipante() {
		if (btInscribirseParticipante == null) {
			btInscribirseParticipante = new JButton("Inscribirse/pagar");
			btInscribirseParticipante.setForeground(new Color(184,220,245));
			btInscribirseParticipante.setBackground(new Color(50, 130, 181));
		}
		return btInscribirseParticipante;
	}
	private JTextField getTxIdCarreraParticipante() {
		if (txIdCarreraParticipante == null) {
			txIdCarreraParticipante = new JTextField();
			txIdCarreraParticipante.setColumns(10);
		}
		return txIdCarreraParticipante;
	}
	private JLabel getLbIDCarreraParticipante() {
		if (lbIDCarreraParticipante == null) {
			lbIDCarreraParticipante = new JLabel("ID CARRERA");
			lbIDCarreraParticipante.setForeground(new Color(184,220,245));
			lbIDCarreraParticipante.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		}
		return lbIDCarreraParticipante;
	}
	private JMenuItem getMnItemCuentaSalir() {
		if (mnItemCuentaSalir == null) {
			mnItemCuentaSalir = new JMenuItem("Salir");
		}
		return mnItemCuentaSalir;
	}
	private JPanel getPnOrganizador() {
		if (pnOrganizador == null) {
			pnOrganizador = new JPanel();
			pnOrganizador.setBackground(new Color(8, 46, 70));
			GroupLayout gl_pnOrganizador = new GroupLayout(pnOrganizador);
			gl_pnOrganizador.setHorizontalGroup(
				gl_pnOrganizador.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_pnOrganizador.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_pnOrganizador.createParallelGroup(Alignment.LEADING)
							.addComponent(getPnBotonesOrganizador(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(getPnTablasOrganizador(), GroupLayout.DEFAULT_SIZE, 815, Short.MAX_VALUE))
						.addContainerGap())
			);
			gl_pnOrganizador.setVerticalGroup(
				gl_pnOrganizador.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_pnOrganizador.createSequentialGroup()
						.addGap(5)
						.addComponent(getPnBotonesOrganizador(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(getPnTablasOrganizador(), GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
						.addContainerGap())
			);
			pnOrganizador.setLayout(gl_pnOrganizador);
		}
		return pnOrganizador;
	}
	private JPanel getPnBotonesOrganizador() {
		if (pnBotonesOrganizador == null) {
			pnBotonesOrganizador = new JPanel();
			pnBotonesOrganizador.setBackground(new Color(8, 46, 70));
			GroupLayout gl_pnBotonesOrganizador = new GroupLayout(pnBotonesOrganizador);
			gl_pnBotonesOrganizador.setHorizontalGroup(
				gl_pnBotonesOrganizador.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_pnBotonesOrganizador.createSequentialGroup()
						.addGroup(gl_pnBotonesOrganizador.createParallelGroup(Alignment.LEADING)
							.addComponent(getPnBotonesOrdenarParticipante_1(), GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(getPnBotonesInscribirseParticipante_1(), GroupLayout.DEFAULT_SIZE, 746, Short.MAX_VALUE))
						.addContainerGap())
			);
			gl_pnBotonesOrganizador.setVerticalGroup(
				gl_pnBotonesOrganizador.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_pnBotonesOrganizador.createSequentialGroup()
						.addContainerGap()
						.addComponent(getPnBotonesInscribirseParticipante_1(), GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(getPnBotonesOrdenarParticipante_1(), GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
			);
			pnBotonesOrganizador.setLayout(gl_pnBotonesOrganizador);
		}
		return pnBotonesOrganizador;
	}
	private JPanel getPnBotonesOrdenarParticipante_1() {
		if (pnBotonesOrdenarParticipante_1 == null) {
			pnBotonesOrdenarParticipante_1 = new JPanel();
			pnBotonesOrdenarParticipante_1.setBackground(new Color(8, 46, 70));
			GroupLayout gl_pnBotonesOrdenarParticipante_1 = new GroupLayout(pnBotonesOrdenarParticipante_1);
			gl_pnBotonesOrdenarParticipante_1.setHorizontalGroup(
				gl_pnBotonesOrdenarParticipante_1.createParallelGroup(Alignment.LEADING)
					.addGap(0, 736, Short.MAX_VALUE)
					.addGroup(gl_pnBotonesOrdenarParticipante_1.createSequentialGroup()
						.addComponent(getBtMostrarClasificaciones(), GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(getCbClasificaciones(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(428))
			);
			gl_pnBotonesOrdenarParticipante_1.setVerticalGroup(
				gl_pnBotonesOrdenarParticipante_1.createParallelGroup(Alignment.LEADING)
					.addGap(0, 37, Short.MAX_VALUE)
					.addGroup(gl_pnBotonesOrdenarParticipante_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(getBtMostrarClasificaciones(), GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
						.addComponent(getCbClasificaciones(), GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
			);
			pnBotonesOrdenarParticipante_1.setLayout(gl_pnBotonesOrdenarParticipante_1);
		}
		return pnBotonesOrdenarParticipante_1;
	}
	private JButton getBtMostrarClasificaciones() {
		if (btMostrarClasificaciones == null) {
			btMostrarClasificaciones = new JButton("Mostrar clasificaciones");
			btMostrarClasificaciones.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarClasificaciones();
				}

				
			});
			btMostrarClasificaciones.setForeground(new Color(184, 220, 245));
			btMostrarClasificaciones.setBackground(new Color(50, 130, 181));
		}
		return btMostrarClasificaciones;
	}
	private JComboBox getCbClasificaciones() {
		if (cbClasificaciones == null) {
			cbClasificaciones = new JComboBox();
			cbClasificaciones.setModel(new DefaultComboBoxModel(new String[] {"Absolutas", "Por sexo"}));
			cbClasificaciones.setForeground(new Color(184, 220, 245));
			cbClasificaciones.setBackground(new Color(50, 130, 181));
		}
		return cbClasificaciones;
	}
	private JPanel getPnBotonesInscribirseParticipante_1() {
		if (pnBotonesInscribirseParticipante_1 == null) {
			pnBotonesInscribirseParticipante_1 = new JPanel();
			pnBotonesInscribirseParticipante_1.setBackground(new Color(8, 46, 70));
			GroupLayout gl_pnBotonesInscribirseParticipante_1 = new GroupLayout(pnBotonesInscribirseParticipante_1);
			gl_pnBotonesInscribirseParticipante_1.setHorizontalGroup(
				gl_pnBotonesInscribirseParticipante_1.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_pnBotonesInscribirseParticipante_1.createSequentialGroup()
						.addComponent(getBtInscribirseParticipante_1(), GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_pnBotonesInscribirseParticipante_1.createParallelGroup(Alignment.LEADING)
							.addComponent(getLbIDCarreraParticipante_1())
							.addGroup(gl_pnBotonesInscribirseParticipante_1.createSequentialGroup()
								.addComponent(getTextField_1(), GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(getTextField_1_1(), GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
								.addGap(10)
								.addComponent(getBtMostrarCarreras(), GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)))
						.addGap(153))
			);
			gl_pnBotonesInscribirseParticipante_1.setVerticalGroup(
				gl_pnBotonesInscribirseParticipante_1.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_pnBotonesInscribirseParticipante_1.createSequentialGroup()
						.addComponent(getLbIDCarreraParticipante_1())
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_pnBotonesInscribirseParticipante_1.createParallelGroup(Alignment.LEADING)
							.addGroup(Alignment.TRAILING, gl_pnBotonesInscribirseParticipante_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(getTextField_1_1(), GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
								.addComponent(getBtMostrarCarreras(), GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_pnBotonesInscribirseParticipante_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(getBtInscribirseParticipante_1(), GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
								.addComponent(getTextField_1(), GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE))))
			);
			pnBotonesInscribirseParticipante_1.setLayout(gl_pnBotonesInscribirseParticipante_1);
		}
		return pnBotonesInscribirseParticipante_1;
	}
	private JButton getBtInscribirseParticipante_1() {
		if (btInscribirseParticipante_1 == null) {
			btInscribirseParticipante_1 = new JButton("Mostrar participantes");
			btInscribirseParticipante_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarPanelOrganizadorParticipantes();
				}
			});
			btInscribirseParticipante_1.setForeground(new Color(184, 220, 245));
			btInscribirseParticipante_1.setBackground(new Color(50, 130, 181));
		}
		return btInscribirseParticipante_1;
	}
	private JLabel getLbIDCarreraParticipante_1() {
		if (lbIDCarreraParticipante_1 == null) {
			lbIDCarreraParticipante_1 = new JLabel("ID CARRERA");
			lbIDCarreraParticipante_1.setForeground(new Color(184, 220, 245));
			lbIDCarreraParticipante_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		}
		return lbIDCarreraParticipante_1;
	}
	private JTextField getTextField_1() {
		if (textField == null) {
			textField = new JTextField();
			textField.setColumns(10);
		}
		return textField;
	}
	private JPanel getPnTablasOrganizador() {
		if (pnTablasOrganizador == null) {
			pnTablasOrganizador = new JPanel();
			pnTablasOrganizador.setLayout(new CardLayout(0, 0));
			pnTablasOrganizador.add(getScrollPaneCarrerasOrganizador(), "pnCarrerasOrganizador");
			pnTablasOrganizador.add(getScrollPaneParticipantesOrganizador(), "pnParticipantesOrganizador");
			pnTablasOrganizador.add(getScrollPaneClasificacionesAbsolutas(), "pnClasificacionesAbsolutas");
			pnTablasOrganizador.add(getPnClasificacionesSexo(), "pnClasificacionesSexo");
		}
		return pnTablasOrganizador;
	}
	private JScrollPane getScrollPaneCarrerasOrganizador() {
		if (scrollPaneCarrerasOrganizador == null) {
			scrollPaneCarrerasOrganizador = new JScrollPane();
			scrollPaneCarrerasOrganizador.setViewportView(getTable_1());
		}
		return scrollPaneCarrerasOrganizador;
	}
	private JScrollPane getScrollPaneParticipantesOrganizador() {
		if (scrollPaneParticipantes == null) {
			scrollPaneParticipantes = new JScrollPane();
			scrollPaneParticipantes.setViewportView(getTable_1_1());
		}
		return scrollPaneParticipantes;
	}
	private JTable getTable_1() {
		if (tablaCarrerasOrganizador == null) {
			tablaCarrerasOrganizador = new JTable();
			tablaCarrerasOrganizador.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"ID carrera", "N\u00FAmero de inscritos", "Nombre carrera", "Fecha carrera", "Tipo carrera", "Distancia (km)", "Cuota Inscripci\u00F3n", "Fin inscripci\u00F3n", "Plazas"
				}
			));
		}
		return tablaCarrerasOrganizador;
	}
	private JTable getTable_1_1() {
		if (tablaParticipantes == null) {
			tablaParticipantes = new JTable();
			tablaParticipantes.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"DNI", "Nombre", "Categor\u00EDa", "Fecha inscripci\u00F3n", "Estado inscripci\u00F3n"
				}
			) {
				Class[] columnTypes = new Class[] {
					String.class, String.class, String.class, String.class, String.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
			});
		}
		return tablaParticipantes;
	}
	private JScrollPane getScrollPaneClasificacionesAbsolutas() {
		if (scrollPaneClasificacionesAbsolutas == null) {
			scrollPaneClasificacionesAbsolutas = new JScrollPane();
			scrollPaneClasificacionesAbsolutas.setViewportView(getTablaClasificacionesAbsoluta());
		}
		return scrollPaneClasificacionesAbsolutas;
	}
	private JTable getTablaClasificacionesAbsoluta() {
		if (tablaClasificacionesAbsoluta == null) {
			tablaClasificacionesAbsoluta = new JTable();
			tablaClasificacionesAbsoluta.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Posici\u00F3n", "Sexo", "Nombre", "Tiempo"
				}
			) {
				Class[] columnTypes = new Class[] {
					Object.class, Object.class, String.class, String.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
			});
		}
		return tablaClasificacionesAbsoluta;
	}
	private JPanel getPnClasificacionesSexo() {
		if (pnClasificacionesSexo == null) {
			pnClasificacionesSexo = new JPanel();
			GroupLayout gl_pnClasificacionesSexo = new GroupLayout(pnClasificacionesSexo);
			gl_pnClasificacionesSexo.setHorizontalGroup(
				gl_pnClasificacionesSexo.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_pnClasificacionesSexo.createSequentialGroup()
						.addComponent(getScrollPaneClasificacionesHombre(), GroupLayout.PREFERRED_SIZE, 376, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(getScrollPaneClasificacionesMujer(), GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE))
			);
			gl_pnClasificacionesSexo.setVerticalGroup(
				gl_pnClasificacionesSexo.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_pnClasificacionesSexo.createSequentialGroup()
						.addGroup(gl_pnClasificacionesSexo.createParallelGroup(Alignment.BASELINE)
							.addComponent(getScrollPaneClasificacionesHombre(), GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
							.addComponent(getScrollPaneClasificacionesMujer(), GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE))
						.addContainerGap())
			);
			pnClasificacionesSexo.setLayout(gl_pnClasificacionesSexo);
		}
		return pnClasificacionesSexo;
	}
	private JScrollPane getScrollPaneClasificacionesHombre() {
		if (scrollPaneClasificacionesHombre == null) {
			scrollPaneClasificacionesHombre = new JScrollPane();
			scrollPaneClasificacionesHombre.setViewportView(getTablaClasificacionesHombre());
		}
		return scrollPaneClasificacionesHombre;
	}
	private JScrollPane getScrollPaneClasificacionesMujer() {
		if (scrollPaneClasificacionesMujer == null) {
			scrollPaneClasificacionesMujer = new JScrollPane();
			scrollPaneClasificacionesMujer.setViewportView(getTablaClasificacionesMujer());
		}
		return scrollPaneClasificacionesMujer;
	}
	private JTable getTablaClasificacionesHombre() {
		if (tablaClasificacionesHombre == null) {
			tablaClasificacionesHombre = new JTable();
			tablaClasificacionesHombre.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Posici\u00F3n", "Sexo", "Nombre", "Tiempo"
				}
			) {
				Class[] columnTypes = new Class[] {
					Integer.class, String.class, String.class, String.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
			});
		}
		return tablaClasificacionesHombre;
	}
	private JTable getTablaClasificacionesMujer() {
		if (tablaClasificacionesMujer == null) {
			tablaClasificacionesMujer = new JTable();
			tablaClasificacionesMujer.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Posici\u00F3n", "Sexo", "Nombre", "Tiempo"
				}
			) {
				Class[] columnTypes = new Class[] {
					Integer.class, String.class, Object.class, String.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
			});
		}
		return tablaClasificacionesMujer;
	}
	private JTextField getTextField_1_1() {
		if (txIdCarreraValida == null) {
			txIdCarreraValida = new JTextField();
			txIdCarreraValida.setText("La carrera (valida)");
			txIdCarreraValida.setEditable(false);
			txIdCarreraValida.setColumns(10);
		}
		return txIdCarreraValida;
	}
	private JMenuItem getMntmNewMenuItem() {
		if (mntmNewMenuItem == null) {
			mntmNewMenuItem = new JMenuItem("organizador");
			mntmNewMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarPanelOrganizador();
				}
			});
		}
		return mntmNewMenuItem;
	}
	private JMenuItem getMntmNewMenuItem_1() {
		if (mntmNewMenuItem_1 == null) {
			mntmNewMenuItem_1 = new JMenuItem("Participante");
			mntmNewMenuItem_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarPanelParticipante();
				}
			});
		}
		return mntmNewMenuItem_1;
	}
	
	private JButton getBtMostrarCarreras() {
		if (btMostrarCarreras == null) {
			btMostrarCarreras = new JButton("Mostrar carreras");
			btMostrarCarreras.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarPanelOrganizadorCarreras();
				}
			});
		}
		return btMostrarCarreras;
	}
	private void mostrarPanelParticipante() {
		CardLayout cl = (CardLayout)(pnPrincipal.getLayout());
	    cl.show(pnPrincipal, "pnParticipante");
	}
	private void mostrarPanelOrganizador() {
		CardLayout cl = (CardLayout)(pnPrincipal.getLayout());
	    cl.show(pnPrincipal, "pnOrganizador");
	}
	private void mostrarPanelOrganizadorCarreras() {
		CardLayout cl = (CardLayout)(pnTablasOrganizador.getLayout());
	    cl.show(pnTablasOrganizador, "pnCarrerasOrganizador");
	}
	private void mostrarPanelOrganizadorParticipantes() {
		CardLayout cl = (CardLayout)(pnTablasOrganizador.getLayout());
	    cl.show(pnTablasOrganizador, "pnParticipantesOrganizador");
	}
	private void mostrarPanelOrganizadorClasificacionesAbsolutas() {
		CardLayout cl = (CardLayout)(pnTablasOrganizador.getLayout());
	    cl.show(pnTablasOrganizador, "pnClasificacionesAbsolutas");
	}
	private void mostrarPanelOrganizadorClasificacionesSexo() {
		System.out.println("fuk");
		CardLayout cl = (CardLayout)(pnTablasOrganizador.getLayout());
	    cl.show(pnTablasOrganizador, "pnClasificacionesSexo");
	}
	private void mostrarClasificaciones() {
		if(cbClasificaciones.getSelectedIndex()==0) {
			mostrarPanelOrganizadorClasificacionesAbsolutas();
		}else if(cbClasificaciones.getSelectedIndex()==1) {
			mostrarPanelOrganizadorClasificacionesSexo();
		}
		
	}
}
