package gui.aplicacion;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import business.dataaccess.exception.BusinessDataException;
import business.dataaccess.util.Check;
import business.gui.CarreraManager;
import business.gui.GuiLogic;
import gui.pagos.VentanaEscogerPago;
import gui.validadoresGUI.Validadores;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;

public class VentanaApp extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel pnPrincipal;
	private JPanel pnParticipante;
	private JPanel pnBotonesParticipante;
	private JPanel pnBotonesOrdenarParticipante;
	private JScrollPane scrollPaneTabla;
	private JTable tablaCarrerasParticipante;
	private JButton btOrdenar;
	private JComboBox<String> cbCarrerasParticipante;
	private JMenuBar menuBar;
	private JMenu mnCuenta;
	private JMenu mnOrganizador;
	private JMenu mnParticipante;
	private JPanel pnBotonesInscribirseParticipante;
	private JButton btInscribirseParticipante;
	private JMenuItem mnItCuentaSalir;
	private JPanel pnOrganizador;
	private JPanel pnBotonesOrganizador;
	private JPanel pnBotonesOrganizador2;
	private JButton btMostrarClasificaciones;
	private JComboBox<String> cbClasificaciones;
	private JPanel pnBotonesOrganizador1;
	private JButton btMostrarParticipantes;
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
	private JMenuItem mnItCuentaOrganizador;
	private JMenuItem mnItCuentaParticipante;
	private JButton btMostrarCarreras;
	private JPanel pnCrearCarrera;
	private JButton btCrearCarreraOrganizador;
	private JLabel lbDatosCarrera;
	private JLabel lbNombreCarrera;
	private JLabel lbFechaCarrera;
	private JLabel lbTipoCarrera;
	private JLabel lbDistanciaCarrera;
	private JLabel lbPlazasMaximaCarrera;
	private JTextField txNombreCarrera;
	private JTextField txFechaCarrera;
	private JTextField txDistanciaCarrera;
	private JTextField txPlazasCarrera;
	private JComboBox<String> cbTipoCarrera;
	private JPanel pnDatosCarrera;
	private JPanel pnInscripcionCarrera;
	private JLabel lbPeriodosInscripcion;
	private JLabel lbFechaFin;
	private JLabel lbFechaInicio;
	private JLabel lbCuotaInscripcion;
	private JTextField txFechaFinPlazo;
	private JTextField txFechaInicioPlazo;
	private JPanel pnCategoriasCarrera;
	private JLabel lbCategoriasCarrera;
	private JLabel lbEdadInicioCategoria;
	private JLabel lbNombreCategoria;
	private JLabel lbEdadFinCategoria;
	private JTextField txEdadInicioCategoria;
	private JTextField txNombreCategoria;
	private JButton btAnadirInscripcion;
	private JTextField txCuotaCarrera;
	private JTextField txEdadFinCategoria;
	private JButton btAnadirCategoria;
	private JButton btCrearCarrera;
	private JButton btPagarParticipante;
	private JButton btResetCarrera;
	private JButton btCargarTiempos;
	private JButton btGenerarDorsales;
	private JScrollPane scrollPanePeriodos;
	private JLabel lblPeriodos;
	private JLabel lblCategorias;
	private JScrollPane scrollPaneCategorias;
	private JTextArea txCategorias;
	private JTextArea txPeriodos;
	private JMenuItem mnItemEmail;
	public final static int ADMIN = 0;
	public final static int PARTICIPANTE = 1;

	private CarreraManager carreraManager;
	private String email;
	private JButton btInscribirClubOrganizador;
	private JCheckBox chBoxListaEspera;
	private JCheckBox chBoxCancelacionInscripcion;

	/**
	 * Create the frame.
	 */
	public VentanaApp(int mode) {
		setTitle("Gestor carreras");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 868, 684);
		setJMenuBar(getMenuBar_1());
		pnPrincipal = new JPanel();
		pnPrincipal.setBackground(new Color(8, 46, 70));
		pnPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pnPrincipal);
		pnPrincipal.setLayout(new CardLayout(0, 0));
		pnPrincipal.add(getPnParticipante(), "pnParticipante");
		pnPrincipal.add(getPnOrganizador(), "pnOrganizador");
		switch (mode) {
		case ADMIN:
			mostrarPanelOrganizador();
			getMnItCuentaParticipante().setEnabled(false);
			getMnItCuentaOrganizador().setEnabled(false);
			carreraManager = new CarreraManager();
			break;
		case PARTICIPANTE:
			mostrarPanelParticipante();
			getMnItCuentaParticipante().setEnabled(false);
			getMnItCuentaOrganizador().setEnabled(false);
			break;
		}
	}

	private JPanel getPnParticipante() {
		if (pnParticipante == null) {
			pnParticipante = new JPanel();
			pnParticipante.setBackground(new Color(8, 46, 70));
			pnParticipante.setBorder(new EmptyBorder(5, 5, 5, 5));
			GroupLayout gl_pnParticipante = new GroupLayout(pnParticipante);
			gl_pnParticipante.setHorizontalGroup(gl_pnParticipante.createParallelGroup(Alignment.TRAILING)
					.addGroup(Alignment.LEADING, gl_pnParticipante.createSequentialGroup().addContainerGap()
							.addGroup(gl_pnParticipante.createParallelGroup(Alignment.LEADING)
									.addComponent(getScrollPaneTabla(), GroupLayout.DEFAULT_SIZE, 756, Short.MAX_VALUE)
									.addGroup(gl_pnParticipante
											.createSequentialGroup().addComponent(getPnBotonesParticipante(),
													GroupLayout.PREFERRED_SIZE, 746, Short.MAX_VALUE)
											.addContainerGap()))));
			gl_pnParticipante.setVerticalGroup(gl_pnParticipante.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_pnParticipante.createSequentialGroup().addContainerGap()
							.addComponent(getPnBotonesParticipante(), GroupLayout.PREFERRED_SIZE, 93,
									GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(getScrollPaneTabla(), GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
							.addContainerGap()));
			pnParticipante.setLayout(gl_pnParticipante);
		}
		return pnParticipante;
	}

	private JPanel getPnBotonesParticipante() {
		if (pnBotonesParticipante == null) {
			pnBotonesParticipante = new JPanel();
			pnBotonesParticipante.setBackground(new Color(8, 46, 70));
			GroupLayout gl_pnBotonesParticipante = new GroupLayout(pnBotonesParticipante);
			gl_pnBotonesParticipante
					.setHorizontalGroup(gl_pnBotonesParticipante.createParallelGroup(Alignment.LEADING)
							.addGroup(Alignment.TRAILING, gl_pnBotonesParticipante.createSequentialGroup()
									.addGroup(gl_pnBotonesParticipante.createParallelGroup(Alignment.TRAILING)
											.addComponent(getPnBotonesInscribirseParticipante(), Alignment.LEADING,
													GroupLayout.PREFERRED_SIZE, 760, Short.MAX_VALUE)
											.addComponent(getPnBotonesOrdenarParticipante(), GroupLayout.DEFAULT_SIZE,
													GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addContainerGap()));
			gl_pnBotonesParticipante
					.setVerticalGroup(
							gl_pnBotonesParticipante.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_pnBotonesParticipante.createSequentialGroup()
											.addComponent(getPnBotonesInscribirseParticipante(),
													GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(getPnBotonesOrdenarParticipante(), GroupLayout.PREFERRED_SIZE,
													37, GroupLayout.PREFERRED_SIZE)
											.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
			pnBotonesParticipante.setLayout(gl_pnBotonesParticipante);
		}
		return pnBotonesParticipante;
	}

	private JPanel getPnBotonesOrdenarParticipante() {
		if (pnBotonesOrdenarParticipante == null) {
			pnBotonesOrdenarParticipante = new JPanel();
			pnBotonesOrdenarParticipante.setBackground(new Color(8, 46, 70));
			GroupLayout gl_pnBotonesOrdenarParticipante = new GroupLayout(pnBotonesOrdenarParticipante);
			gl_pnBotonesOrdenarParticipante.setHorizontalGroup(gl_pnBotonesOrdenarParticipante
					.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_pnBotonesOrdenarParticipante.createSequentialGroup()
							.addComponent(getBtOrdenar(), GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(getCbCarrerasParticipante(),
									GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(428)));
			gl_pnBotonesOrdenarParticipante.setVerticalGroup(gl_pnBotonesOrdenarParticipante
					.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_pnBotonesOrdenarParticipante.createParallelGroup(Alignment.BASELINE)
							.addComponent(getBtOrdenar(), GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
							.addComponent(getCbCarrerasParticipante(), GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)));
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
			tablaCarrerasParticipante.setSelectionBackground(new Color(50, 130, 181));
			tablaCarrerasParticipante.setSelectionForeground(new Color(184, 220, 245));
			tablaCarrerasParticipante.setForeground(Color.BLACK);
			tablaCarrerasParticipante.setBackground(Color.WHITE);
			tablaCarrerasParticipante.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
			tablaCarrerasParticipante.setRowHeight(25);
		}
		return tablaCarrerasParticipante;
	}

	private JButton getBtOrdenar() {
		if (btOrdenar == null) {
			btOrdenar = new JButton("Mostrar");
			btOrdenar.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
			btOrdenar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarCarrerasParticipante();
				}
			});
			btOrdenar.setForeground(new Color(184, 220, 245));
			btOrdenar.setBackground(new Color(50, 130, 181));
		}
		return btOrdenar;
	}

	private JComboBox<String> getCbCarrerasParticipante() {
		if (cbCarrerasParticipante == null) {
			cbCarrerasParticipante = new JComboBox<String>();
			cbCarrerasParticipante.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
			cbCarrerasParticipante.setForeground(new Color(184, 220, 245));
			cbCarrerasParticipante.setBackground(new Color(50, 130, 181));
			cbCarrerasParticipante
					.setModel(new DefaultComboBoxModel<String>(new String[] { "Todas las carreras", "Mis carreras" }));
		}
		return cbCarrerasParticipante;
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
			mnCuenta.add(getMnItCuentaParticipante());
			mnCuenta.add(getMnItCuentaOrganizador());
			mnCuenta.add(getMnItCuentaSalir());
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
			mnParticipante.add(getMnItemEmail());
		}
		return mnParticipante;
	}

	private JPanel getPnBotonesInscribirseParticipante() {
		if (pnBotonesInscribirseParticipante == null) {
			pnBotonesInscribirseParticipante = new JPanel();
			pnBotonesInscribirseParticipante.setBackground(new Color(8, 46, 70));

			GroupLayout gl_pnBotonesInscribirseParticipante = new GroupLayout(pnBotonesInscribirseParticipante);
			gl_pnBotonesInscribirseParticipante
					.setHorizontalGroup(gl_pnBotonesInscribirseParticipante.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_pnBotonesInscribirseParticipante.createSequentialGroup()
									.addComponent(getBtInscribirseParticipante(), GroupLayout.PREFERRED_SIZE, 186,
											GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(getBtPagarParticipante(), GroupLayout.PREFERRED_SIZE, 137,
											GroupLayout.PREFERRED_SIZE)
									.addContainerGap(427, Short.MAX_VALUE)));
			gl_pnBotonesInscribirseParticipante.setVerticalGroup(gl_pnBotonesInscribirseParticipante
					.createParallelGroup(Alignment.TRAILING)
					.addGroup(gl_pnBotonesInscribirseParticipante.createSequentialGroup().addGap(25)
							.addGroup(gl_pnBotonesInscribirseParticipante.createParallelGroup(Alignment.BASELINE)
									.addComponent(getBtInscribirseParticipante(), GroupLayout.PREFERRED_SIZE, 24,
											Short.MAX_VALUE)
									.addComponent(getBtPagarParticipante(), GroupLayout.PREFERRED_SIZE, 24,
											Short.MAX_VALUE))));
			pnBotonesInscribirseParticipante.setLayout(gl_pnBotonesInscribirseParticipante);
		}
		return pnBotonesInscribirseParticipante;
	}

	private JButton getBtPagarParticipante() {
		if (btPagarParticipante == null) {
			btPagarParticipante = new JButton("Pagar");
			btPagarParticipante.setForeground(new Color(184, 220, 245));
			btPagarParticipante.setBackground(new Color(50, 130, 181));
			btPagarParticipante.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
			btPagarParticipante.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					pagar();
				}
			});
		}
		return btPagarParticipante;
	}

	private JButton getBtInscribirseParticipante() {
		if (btInscribirseParticipante == null) {
			btInscribirseParticipante = new JButton("Inscribirse");
			btInscribirseParticipante.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarVentanaInscripcion();
				}
			});
			btInscribirseParticipante.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
			btInscribirseParticipante.setForeground(new Color(184, 220, 245));
			btInscribirseParticipante.setBackground(new Color(50, 130, 181));
		}
		return btInscribirseParticipante;
	}

	private JMenuItem getMnItCuentaSalir() {
		if (mnItCuentaSalir == null) {
			mnItCuentaSalir = new JMenuItem("Salir");
			mnItCuentaSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
		}
		return mnItCuentaSalir;
	}

	private JPanel getPnOrganizador() {
		if (pnOrganizador == null) {
			pnOrganizador = new JPanel();
			pnOrganizador.setBackground(new Color(8, 46, 70));
			GroupLayout gl_pnOrganizador = new GroupLayout(pnOrganizador);
			gl_pnOrganizador.setHorizontalGroup(gl_pnOrganizador.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_pnOrganizador.createSequentialGroup().addContainerGap()
							.addGroup(gl_pnOrganizador.createParallelGroup(Alignment.LEADING)
									.addComponent(getPnBotonesOrganizador(), GroupLayout.PREFERRED_SIZE, 768,
											GroupLayout.PREFERRED_SIZE)
									.addComponent(getPnTablasOrganizador(), GroupLayout.DEFAULT_SIZE, 1064,
											Short.MAX_VALUE))
							.addContainerGap()));
			gl_pnOrganizador.setVerticalGroup(gl_pnOrganizador.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_pnOrganizador.createSequentialGroup().addGap(5)
							.addComponent(getPnBotonesOrganizador(), GroupLayout.PREFERRED_SIZE,
									GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(getPnTablasOrganizador(), GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
							.addContainerGap()));
			pnOrganizador.setLayout(gl_pnOrganizador);
		}
		return pnOrganizador;
	}

	private JPanel getPnBotonesOrganizador() {
		if (pnBotonesOrganizador == null) {
			pnBotonesOrganizador = new JPanel();
			pnBotonesOrganizador.setBackground(new Color(8, 46, 70));
			GroupLayout gl_pnBotonesOrganizador = new GroupLayout(pnBotonesOrganizador);
			gl_pnBotonesOrganizador.setHorizontalGroup(gl_pnBotonesOrganizador.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_pnBotonesOrganizador.createSequentialGroup()
							.addGroup(gl_pnBotonesOrganizador.createParallelGroup(Alignment.LEADING)
									.addComponent(getPnBotonesOrganizador1(), Alignment.TRAILING,
											GroupLayout.PREFERRED_SIZE, 760, Short.MAX_VALUE)
									.addComponent(getPnBotonesOrganizador2(), GroupLayout.PREFERRED_SIZE, 760,
											Short.MAX_VALUE))
							.addContainerGap()));
			gl_pnBotonesOrganizador
					.setVerticalGroup(
							gl_pnBotonesOrganizador.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_pnBotonesOrganizador.createSequentialGroup()
											.addComponent(getPnBotonesOrganizador1(), GroupLayout.PREFERRED_SIZE, 59,
													GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(getPnBotonesOrganizador2(), GroupLayout.PREFERRED_SIZE, 37,
													GroupLayout.PREFERRED_SIZE)
											.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
			pnBotonesOrganizador.setLayout(gl_pnBotonesOrganizador);
		}
		return pnBotonesOrganizador;
	}

	private JPanel getPnBotonesOrganizador2() {
		if (pnBotonesOrganizador2 == null) {
			pnBotonesOrganizador2 = new JPanel();
			pnBotonesOrganizador2.setBackground(new Color(8, 46, 70));
			GroupLayout gl_pnBotonesOrganizador2 = new GroupLayout(pnBotonesOrganizador2);
			gl_pnBotonesOrganizador2
					.setHorizontalGroup(
							gl_pnBotonesOrganizador2.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_pnBotonesOrganizador2.createSequentialGroup()
											.addComponent(getBtCrearCarreraOrganizador(), GroupLayout.PREFERRED_SIZE,
													153, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(getBtGenerarDorsales(), GroupLayout.PREFERRED_SIZE, 187,
													GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(getBtCargarTiempos())
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(getBtInscribirClubOrganizador(), GroupLayout.PREFERRED_SIZE,
													123, GroupLayout.PREFERRED_SIZE)
											.addContainerGap(156, Short.MAX_VALUE)));
			gl_pnBotonesOrganizador2.setVerticalGroup(gl_pnBotonesOrganizador2.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_pnBotonesOrganizador2.createParallelGroup(Alignment.BASELINE)
							.addComponent(getBtCrearCarreraOrganizador(), GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
							.addComponent(getBtGenerarDorsales(), GroupLayout.PREFERRED_SIZE, 37,
									GroupLayout.PREFERRED_SIZE)
							.addComponent(getBtCargarTiempos(), GroupLayout.PREFERRED_SIZE, 37,
									GroupLayout.PREFERRED_SIZE)
							.addComponent(getBtInscribirClubOrganizador(), GroupLayout.DEFAULT_SIZE, 37,
									Short.MAX_VALUE)));
			pnBotonesOrganizador2.setLayout(gl_pnBotonesOrganizador2);
		}
		return pnBotonesOrganizador2;
	}

	private JButton getBtMostrarClasificaciones() {
		if (btMostrarClasificaciones == null) {
			btMostrarClasificaciones = new JButton("Mostrar clasificaciones");
			btMostrarClasificaciones.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
			btMostrarClasificaciones.setEnabled(true);
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

	private JComboBox<String> getCbClasificaciones() {
		if (cbClasificaciones == null) {
			cbClasificaciones = new JComboBox<String>();
			cbClasificaciones.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
			cbClasificaciones.setModel(new DefaultComboBoxModel<String>(new String[] { "Absolutas", "Por sexo" }));
			cbClasificaciones.setForeground(new Color(184, 220, 245));
			cbClasificaciones.setBackground(new Color(50, 130, 181));
		}
		return cbClasificaciones;
	}

	private JPanel getPnBotonesOrganizador1() {
		if (pnBotonesOrganizador1 == null) {
			pnBotonesOrganizador1 = new JPanel();
			pnBotonesOrganizador1.setBackground(new Color(8, 46, 70));
			GroupLayout gl_pnBotonesOrganizador1 = new GroupLayout(pnBotonesOrganizador1);
			gl_pnBotonesOrganizador1
					.setHorizontalGroup(
							gl_pnBotonesOrganizador1.createParallelGroup(Alignment.LEADING)
									.addGroup(
											gl_pnBotonesOrganizador1.createSequentialGroup()
													.addComponent(getBtMostrarCarreras(), GroupLayout.PREFERRED_SIZE,
															154, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(getBtMostrarParticipantes(),
															GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(getBtMostrarClasificaciones(),
															GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(getCbClasificaciones(), GroupLayout.PREFERRED_SIZE,
															GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
													.addGap(128)));
			gl_pnBotonesOrganizador1.setVerticalGroup(gl_pnBotonesOrganizador1.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_pnBotonesOrganizador1.createSequentialGroup().addGap(25)
							.addGroup(gl_pnBotonesOrganizador1.createParallelGroup(Alignment.BASELINE)
									.addComponent(getBtMostrarCarreras(), GroupLayout.PREFERRED_SIZE, 33,
											GroupLayout.PREFERRED_SIZE)
									.addComponent(getBtMostrarParticipantes(), GroupLayout.PREFERRED_SIZE, 34,
											GroupLayout.PREFERRED_SIZE)
									.addComponent(getBtMostrarClasificaciones(), GroupLayout.PREFERRED_SIZE, 37,
											GroupLayout.PREFERRED_SIZE)
									.addComponent(getCbClasificaciones(), GroupLayout.PREFERRED_SIZE, 37,
											GroupLayout.PREFERRED_SIZE))));
			pnBotonesOrganizador1.setLayout(gl_pnBotonesOrganizador1);
		}
		return pnBotonesOrganizador1;
	}

	private JButton getBtMostrarParticipantes() {
		if (btMostrarParticipantes == null) {
			btMostrarParticipantes = new JButton("Mostrar participantes");
			btMostrarParticipantes.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
			btMostrarParticipantes.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarPanelOrganizadorInscritos();
				}
			});
			btMostrarParticipantes.setForeground(new Color(184, 220, 245));
			btMostrarParticipantes.setBackground(new Color(50, 130, 181));
		}
		return btMostrarParticipantes;
	}

	private JPanel getPnTablasOrganizador() {
		if (pnTablasOrganizador == null) {
			pnTablasOrganizador = new JPanel();
			pnTablasOrganizador.setLayout(new CardLayout(0, 0));
			pnTablasOrganizador.add(getScrollPaneCarrerasOrganizador(), "pnCarrerasOrganizador");
			pnTablasOrganizador.add(getScrollPaneParticipantesOrganizador(), "pnParticipantesOrganizador");
			pnTablasOrganizador.add(getScrollPaneClasificacionesAbsolutas(), "pnClasificacionesAbsolutas");
			pnTablasOrganizador.add(getPnClasificacionesSexo(), "pnClasificacionesSexo");
			pnTablasOrganizador.add(getPnCrearCarrera(), "pnCrearCarreras");
		}
		return pnTablasOrganizador;
	}

	private JScrollPane getScrollPaneCarrerasOrganizador() {
		if (scrollPaneCarrerasOrganizador == null) {
			scrollPaneCarrerasOrganizador = new JScrollPane();
			scrollPaneCarrerasOrganizador.setViewportView(getTablaCarrerasOrganizador());
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

	private JTable getTablaCarrerasOrganizador() {
		if (tablaCarrerasOrganizador == null) {
			tablaCarrerasOrganizador = new JTable();
			tablaCarrerasOrganizador.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
			tablaCarrerasOrganizador.setModel(new DefaultTableModel(new Object[][] {}, new String[] {}));
			tablaCarrerasOrganizador.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
				public void valueChanged(ListSelectionEvent event) {
					if (!event.getValueIsAdjusting() && tablaCarrerasOrganizador.getSelectedRow() != -1) {
						cargarCategorias();
					}
				}
			});
		}
		return tablaCarrerasOrganizador;
	}

	private JTable getTable_1_1() {
		if (tablaParticipantes == null) {
			tablaParticipantes = new JTable();
			tablaParticipantes.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "DNI", "Nombre",
					"Categor\u00EDa", "Fecha inscripci\u00F3n", "Estado inscripci\u00F3n" }) {

				Class[] columnTypes = new Class[] { String.class, String.class, String.class, String.class,
						String.class };

				public Class<?> getColumnClass(int columnIndex) {
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
			tablaClasificacionesAbsoluta.setModel(new DefaultTableModel(new Object[][] {},
					new String[] { "Posici\u00F3n", "Sexo", "Nombre", "Tiempo" }) {
				Class[] columnTypes = new Class[] { Object.class, Object.class, String.class, String.class };

				public Class<?> getColumnClass(int columnIndex) {
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
			gl_pnClasificacionesSexo.setHorizontalGroup(gl_pnClasificacionesSexo.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_pnClasificacionesSexo.createSequentialGroup()
							.addComponent(getScrollPaneClasificacionesHombre(), GroupLayout.DEFAULT_SIZE, 376,
									Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(getScrollPaneClasificacionesMujer(), GroupLayout.DEFAULT_SIZE, 398,
									Short.MAX_VALUE)));
			gl_pnClasificacionesSexo.setVerticalGroup(gl_pnClasificacionesSexo.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_pnClasificacionesSexo.createSequentialGroup()
							.addGroup(gl_pnClasificacionesSexo.createParallelGroup(Alignment.BASELINE)
									.addComponent(getScrollPaneClasificacionesHombre(), GroupLayout.DEFAULT_SIZE, 380,
											Short.MAX_VALUE)
									.addComponent(getScrollPaneClasificacionesMujer(), GroupLayout.DEFAULT_SIZE, 380,
											Short.MAX_VALUE))
							.addContainerGap()));
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
			tablaClasificacionesHombre.setModel(new DefaultTableModel(new Object[][] {},
					new String[] { "Posici\u00F3n", "Sexo", "Nombre", "Tiempo" }) {
				Class[] columnTypes = new Class[] { Integer.class, String.class, String.class, String.class };

				public Class<?> getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
			});
		}
		return tablaClasificacionesHombre;
	}

	private JTable getTablaClasificacionesMujer() {
		if (tablaClasificacionesMujer == null) {
			tablaClasificacionesMujer = new JTable();
			tablaClasificacionesMujer.setModel(new DefaultTableModel(new Object[][] {},
					new String[] { "Posici\u00F3n", "Sexo", "Nombre", "Tiempo" }) {
				Class[] columnTypes = new Class[] { Integer.class, String.class, Object.class, String.class };

				public Class<?> getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
			});
		}
		return tablaClasificacionesMujer;
	}

	private JMenuItem getMnItCuentaOrganizador() {
		if (mnItCuentaOrganizador == null) {
			mnItCuentaOrganizador = new JMenuItem("Organizador");
			mnItCuentaOrganizador.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarPanelOrganizador();
				}
			});
		}
		return mnItCuentaOrganizador;
	}

	private JMenuItem getMnItCuentaParticipante() {
		if (mnItCuentaParticipante == null) {
			mnItCuentaParticipante = new JMenuItem("Participante");
			mnItCuentaParticipante.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarPanelParticipante();
				}
			});
		}
		return mnItCuentaParticipante;
	}

	private JButton getBtMostrarCarreras() {
		if (btMostrarCarreras == null) {
			btMostrarCarreras = new JButton("Mostrar carreras");
			btMostrarCarreras.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
			btMostrarCarreras.setForeground(new Color(184, 220, 245));
			btMostrarCarreras.setBackground(new Color(50, 130, 181));
			btMostrarCarreras.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarPanelOrganizadorCarreras();
				}
			});
		}
		return btMostrarCarreras;
	}

	private JPanel getPnCrearCarrera() {
		if (pnCrearCarrera == null) {
			pnCrearCarrera = new JPanel();
			pnCrearCarrera.setBackground(new Color(50, 130, 181));
			GroupLayout gl_pnCrearCarrera = new GroupLayout(pnCrearCarrera);
			gl_pnCrearCarrera.setHorizontalGroup(gl_pnCrearCarrera.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_pnCrearCarrera.createSequentialGroup().addContainerGap()
							.addGroup(gl_pnCrearCarrera.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_pnCrearCarrera.createSequentialGroup()
											.addComponent(getPnDatosCarrera(), GroupLayout.DEFAULT_SIZE, 371,
													Short.MAX_VALUE)
											.addGap(56))
									.addComponent(getPnCategoriasCarrera(), GroupLayout.DEFAULT_SIZE, 427,
											Short.MAX_VALUE))
							.addGroup(gl_pnCrearCarrera.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_pnCrearCarrera.createSequentialGroup().addGroup(gl_pnCrearCarrera
											.createParallelGroup(Alignment.LEADING)
											.addGroup(Alignment.TRAILING, gl_pnCrearCarrera.createSequentialGroup()
													.addGroup(gl_pnCrearCarrera.createParallelGroup(Alignment.LEADING)
															.addGroup(gl_pnCrearCarrera.createSequentialGroup()
																	.addGroup(gl_pnCrearCarrera
																			.createParallelGroup(Alignment.LEADING)
																			.addComponent(getScrollPanePeriodos(),
																					GroupLayout.DEFAULT_SIZE, 189,
																					Short.MAX_VALUE)
																			.addGroup(gl_pnCrearCarrera
																					.createSequentialGroup().addGap(9)
																					.addComponent(getBtResetCarrera(),
																							GroupLayout.DEFAULT_SIZE,
																							180, Short.MAX_VALUE)))
																	.addPreferredGap(ComponentPlacement.RELATED))
															.addGroup(gl_pnCrearCarrera.createSequentialGroup()
																	.addComponent(getLblPeriodos(),
																			GroupLayout.DEFAULT_SIZE, 152,
																			Short.MAX_VALUE)
																	.addGap(43)))
													.addGroup(gl_pnCrearCarrera.createParallelGroup(Alignment.LEADING)
															.addGroup(gl_pnCrearCarrera.createSequentialGroup()
																	.addComponent(getLblCategorias(),
																			GroupLayout.DEFAULT_SIZE, 153,
																			Short.MAX_VALUE)
																	.addGap(27))
															.addComponent(getBtCrearCarrera(), Alignment.TRAILING,
																	GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
															.addComponent(getScrollPaneCategorias(),
																	GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)))
											.addComponent(getPnInscripcionCarrera(), Alignment.TRAILING,
													GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE))
											.addContainerGap())
									.addGroup(gl_pnCrearCarrera.createSequentialGroup().addGap(46)
											.addComponent(getChBoxListaEspera())
											.addPreferredGap(ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
											.addComponent(getChBoxCancelacionInscripcion()).addGap(49)))));
			gl_pnCrearCarrera.setVerticalGroup(gl_pnCrearCarrera.createParallelGroup(Alignment.TRAILING)
					.addGroup(gl_pnCrearCarrera.createSequentialGroup().addContainerGap()
							.addGroup(gl_pnCrearCarrera.createParallelGroup(Alignment.LEADING)
									.addComponent(getPnInscripcionCarrera(), GroupLayout.PREFERRED_SIZE, 216,
											Short.MAX_VALUE)
									.addComponent(getPnDatosCarrera(), GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_pnCrearCarrera.createParallelGroup(Alignment.TRAILING)
									.addComponent(getPnCategoriasCarrera(), GroupLayout.PREFERRED_SIZE, 183,
											Short.MAX_VALUE)
									.addGroup(gl_pnCrearCarrera.createSequentialGroup()
											.addGroup(gl_pnCrearCarrera.createParallelGroup(Alignment.BASELINE)
													.addComponent(getLblPeriodos(), GroupLayout.PREFERRED_SIZE, 23,
															GroupLayout.PREFERRED_SIZE)
													.addComponent(getLblCategorias(), GroupLayout.PREFERRED_SIZE, 23,
															GroupLayout.PREFERRED_SIZE))
											.addPreferredGap(ComponentPlacement.RELATED)
											.addGroup(gl_pnCrearCarrera.createParallelGroup(Alignment.LEADING, false)
													.addComponent(getScrollPaneCategorias(), GroupLayout.PREFERRED_SIZE,
															60, GroupLayout.PREFERRED_SIZE)
													.addComponent(getScrollPanePeriodos(), GroupLayout.DEFAULT_SIZE, 60,
															Short.MAX_VALUE))
											.addGap(18)
											.addGroup(gl_pnCrearCarrera.createParallelGroup(Alignment.LEADING)
													.addComponent(getChBoxListaEspera())
													.addComponent(getChBoxCancelacionInscripcion()))
											.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
											.addGroup(gl_pnCrearCarrera.createParallelGroup(Alignment.LEADING)
													.addComponent(getBtCrearCarrera(), Alignment.TRAILING,
															GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
													.addComponent(getBtResetCarrera(), Alignment.TRAILING,
															GroupLayout.PREFERRED_SIZE, 27,
															GroupLayout.PREFERRED_SIZE))))
							.addGap(47)));
			pnCrearCarrera.setLayout(gl_pnCrearCarrera);
		}
		return pnCrearCarrera;
	}

	private JButton getBtCrearCarreraOrganizador() {
		if (btCrearCarreraOrganizador == null) {
			btCrearCarreraOrganizador = new JButton("Crear carrera");
			btCrearCarreraOrganizador.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
			btCrearCarreraOrganizador.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarPanelOrganizadorCrearCarrera();
				}
			});
			btCrearCarreraOrganizador.setForeground(new Color(184, 220, 245));
			btCrearCarreraOrganizador.setBackground(new Color(50, 130, 181));
		}
		return btCrearCarreraOrganizador;
	}

	private JLabel getLbDatosCarrera() {
		if (lbDatosCarrera == null) {
			lbDatosCarrera = new JLabel("Datos carrera");
			lbDatosCarrera.setFont(new Font("Segoe UI Black", Font.BOLD, 16));
		}
		return lbDatosCarrera;
	}

	private JLabel getLbNombreCarrera() {
		if (lbNombreCarrera == null) {
			lbNombreCarrera = new JLabel("Nombre carrera");
			lbNombreCarrera.setFont(new Font("Segoe UI Black", Font.BOLD, 14));
		}
		return lbNombreCarrera;
	}

	private JLabel getLbFechaCarrera() {
		if (lbFechaCarrera == null) {
			lbFechaCarrera = new JLabel("Fecha carrera");
			lbFechaCarrera.setFont(new Font("Segoe UI Black", Font.BOLD, 14));
		}
		return lbFechaCarrera;
	}

	private JLabel getLbTipoCarrera() {
		if (lbTipoCarrera == null) {
			lbTipoCarrera = new JLabel("Tipo de carrera");
			lbTipoCarrera.setFont(new Font("Segoe UI Black", Font.BOLD, 14));
		}
		return lbTipoCarrera;
	}

	private JLabel getLbDistanciaCarrera() {
		if (lbDistanciaCarrera == null) {
			lbDistanciaCarrera = new JLabel("Distancia carrera");
			lbDistanciaCarrera.setFont(new Font("Segoe UI Black", Font.BOLD, 14));
		}
		return lbDistanciaCarrera;
	}

	private JLabel getLbPlazasMaximaCarrera() {
		if (lbPlazasMaximaCarrera == null) {
			lbPlazasMaximaCarrera = new JLabel("Plazas m\u00E1ximas");
			lbPlazasMaximaCarrera.setFont(new Font("Segoe UI Black", Font.BOLD, 14));
		}
		return lbPlazasMaximaCarrera;
	}

	private JTextField getTxNombreCarrera() {
		if (txNombreCarrera == null) {
			txNombreCarrera = new JTextField();
			txNombreCarrera.setText("CarreraPrueba");
			txNombreCarrera.setColumns(10);
		}
		return txNombreCarrera;
	}

	private JTextField getTxFechaCarrera() {
		if (txFechaCarrera == null) {
			txFechaCarrera = new JTextField();
			txFechaCarrera.setText("2021/12/30");
			txFechaCarrera.setColumns(10);
		}
		return txFechaCarrera;
	}

	private JTextField getTxDistanciaCarrera() {
		if (txDistanciaCarrera == null) {
			txDistanciaCarrera = new JTextField();
			txDistanciaCarrera.setText("15");
			txDistanciaCarrera.setColumns(10);
		}
		return txDistanciaCarrera;
	}

	private JTextField getTxPlazasCarrera() {
		if (txPlazasCarrera == null) {
			txPlazasCarrera = new JTextField();
			txPlazasCarrera.setText("50");
			txPlazasCarrera.setColumns(10);
		}
		return txPlazasCarrera;
	}

	private JComboBox<String> getCbTipoCarrera() {
		if (cbTipoCarrera == null) {
			cbTipoCarrera = new JComboBox<String>();
			cbTipoCarrera.setFont(new Font("Tahoma", Font.BOLD, 12));
			cbTipoCarrera.setModel(new DefaultComboBoxModel<String>(new String[] { "Asfalto", "Monta\u00F1a" }));
		}
		return cbTipoCarrera;
	}

	private JPanel getPnDatosCarrera() {
		if (pnDatosCarrera == null) {
			pnDatosCarrera = new JPanel();
			pnDatosCarrera.setBackground(new Color(70, 130, 180));
			GroupLayout gl_pnDatosCarrera = new GroupLayout(pnDatosCarrera);
			gl_pnDatosCarrera.setHorizontalGroup(gl_pnDatosCarrera.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_pnDatosCarrera.createSequentialGroup().addContainerGap().addGroup(gl_pnDatosCarrera
							.createParallelGroup(Alignment.LEADING).addComponent(getLbDatosCarrera())
							.addGroup(gl_pnDatosCarrera.createSequentialGroup()
									.addGroup(gl_pnDatosCarrera.createParallelGroup(Alignment.TRAILING)
											.addComponent(getLbDistanciaCarrera(), Alignment.LEADING,
													GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(getLbFechaCarrera(), Alignment.LEADING,
													GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
											.addComponent(getLbNombreCarrera(), Alignment.LEADING,
													GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
											.addComponent(getLbTipoCarrera(), Alignment.LEADING,
													GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
											.addComponent(getLbPlazasMaximaCarrera(), Alignment.LEADING,
													GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_pnDatosCarrera.createParallelGroup(Alignment.LEADING)
											.addComponent(getTxPlazasCarrera()).addComponent(getTxDistanciaCarrera())
											.addComponent(getCbTipoCarrera(), 0, GroupLayout.DEFAULT_SIZE,
													Short.MAX_VALUE)
											.addComponent(getTxFechaCarrera()).addComponent(getTxNombreCarrera(),
													GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE))
									.addGap(0)))
							.addGap(10)));
			gl_pnDatosCarrera.setVerticalGroup(gl_pnDatosCarrera.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_pnDatosCarrera.createSequentialGroup().addGap(5).addComponent(getLbDatosCarrera())
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_pnDatosCarrera.createParallelGroup(Alignment.BASELINE)
									.addComponent(getLbNombreCarrera(), GroupLayout.PREFERRED_SIZE, 23,
											GroupLayout.PREFERRED_SIZE)
									.addGroup(gl_pnDatosCarrera.createSequentialGroup().addGap(4).addComponent(
											getTxNombreCarrera(), GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_pnDatosCarrera.createParallelGroup(Alignment.BASELINE)
									.addComponent(getLbFechaCarrera(), GroupLayout.PREFERRED_SIZE, 23,
											GroupLayout.PREFERRED_SIZE)
									.addGroup(gl_pnDatosCarrera.createSequentialGroup().addGap(4).addComponent(
											getTxFechaCarrera(), GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_pnDatosCarrera.createParallelGroup(Alignment.BASELINE)
									.addComponent(getLbTipoCarrera(), GroupLayout.PREFERRED_SIZE, 23,
											GroupLayout.PREFERRED_SIZE)
									.addGroup(gl_pnDatosCarrera.createSequentialGroup().addGap(1).addComponent(
											getCbTipoCarrera(), GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_pnDatosCarrera.createParallelGroup(Alignment.BASELINE)
									.addComponent(getLbDistanciaCarrera(), GroupLayout.PREFERRED_SIZE, 23,
											GroupLayout.PREFERRED_SIZE)
									.addGroup(gl_pnDatosCarrera.createSequentialGroup().addGap(2).addComponent(
											getTxDistanciaCarrera(), GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_pnDatosCarrera.createParallelGroup(Alignment.BASELINE)
									.addComponent(getLbPlazasMaximaCarrera(), GroupLayout.PREFERRED_SIZE, 23,
											GroupLayout.PREFERRED_SIZE)
									.addGroup(gl_pnDatosCarrera.createSequentialGroup().addGap(2).addComponent(
											getTxPlazasCarrera(), GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)))
							.addGap(6)));
			pnDatosCarrera.setLayout(gl_pnDatosCarrera);
		}
		return pnDatosCarrera;
	}

	private JPanel getPnInscripcionCarrera() {
		if (pnInscripcionCarrera == null) {
			pnInscripcionCarrera = new JPanel();
			pnInscripcionCarrera.setBackground(new Color(70, 130, 180));
			GroupLayout gl_pnInscripcionCarrera = new GroupLayout(pnInscripcionCarrera);
			gl_pnInscripcionCarrera.setHorizontalGroup(gl_pnInscripcionCarrera.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_pnInscripcionCarrera.createSequentialGroup().addContainerGap()
							.addGroup(gl_pnInscripcionCarrera.createParallelGroup(Alignment.LEADING).addGroup(
									gl_pnInscripcionCarrera.createSequentialGroup().addGroup(gl_pnInscripcionCarrera
											.createParallelGroup(Alignment.LEADING)
											.addComponent(getLbPeriodosInscripcion())
											.addGroup(gl_pnInscripcionCarrera.createSequentialGroup()
													.addGroup(gl_pnInscripcionCarrera
															.createParallelGroup(Alignment.TRAILING)
															.addComponent(getLbCuotaInscripcion(),
																	GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
															.addComponent(getLbFechaFin(), Alignment.LEADING,
																	GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
															.addComponent(getLbFechaInicio(), Alignment.LEADING,
																	GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE))
													.addPreferredGap(ComponentPlacement.RELATED)
													.addGroup(gl_pnInscripcionCarrera
															.createParallelGroup(Alignment.LEADING)
															.addGroup(gl_pnInscripcionCarrera.createSequentialGroup()
																	.addGroup(gl_pnInscripcionCarrera
																			.createParallelGroup(Alignment.LEADING)
																			.addComponent(getTxFechaFinPlazo(),
																					GroupLayout.DEFAULT_SIZE, 193,
																					Short.MAX_VALUE)
																			.addComponent(getTxFechaInicioPlazo(),
																					GroupLayout.DEFAULT_SIZE, 193,
																					Short.MAX_VALUE))
																	.addGap(0))
															.addComponent(getTxCuotaCarrera(), GroupLayout.DEFAULT_SIZE,
																	193, Short.MAX_VALUE))))
											.addGap(10))
									.addGroup(gl_pnInscripcionCarrera
											.createSequentialGroup().addComponent(getBtAnadirInscripcion(),
													GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
											.addContainerGap()))));
			gl_pnInscripcionCarrera.setVerticalGroup(gl_pnInscripcionCarrera.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_pnInscripcionCarrera.createSequentialGroup().addGap(5)
							.addComponent(getLbPeriodosInscripcion()).addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_pnInscripcionCarrera.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_pnInscripcionCarrera.createSequentialGroup().addGap(4)
											.addComponent(getTxFechaInicioPlazo()))
									.addComponent(getLbFechaInicio(), GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_pnInscripcionCarrera.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_pnInscripcionCarrera.createSequentialGroup().addGap(4)
											.addComponent(getTxFechaFinPlazo()))
									.addComponent(getLbFechaFin(), GroupLayout.PREFERRED_SIZE, 23,
											GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_pnInscripcionCarrera.createParallelGroup(Alignment.BASELINE)
									.addComponent(getLbCuotaInscripcion(), GroupLayout.PREFERRED_SIZE, 23,
											GroupLayout.PREFERRED_SIZE)
									.addGroup(gl_pnInscripcionCarrera.createSequentialGroup().addGap(4)
											.addComponent(getTxCuotaCarrera())))
							.addGap(31)
							.addComponent(getBtAnadirInscripcion(), GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
							.addContainerGap()));
			pnInscripcionCarrera.setLayout(gl_pnInscripcionCarrera);
		}
		return pnInscripcionCarrera;
	}

	private JLabel getLbPeriodosInscripcion() {
		if (lbPeriodosInscripcion == null) {
			lbPeriodosInscripcion = new JLabel("Periodo inscripci\u00F3n");
			lbPeriodosInscripcion.setFont(new Font("Segoe UI Black", Font.BOLD, 16));
		}
		return lbPeriodosInscripcion;
	}

	private JLabel getLbFechaFin() {
		if (lbFechaFin == null) {
			lbFechaFin = new JLabel("Fecha fin");
			lbFechaFin.setFont(new Font("Segoe UI Black", Font.BOLD, 14));
		}
		return lbFechaFin;
	}

	private JLabel getLbFechaInicio() {
		if (lbFechaInicio == null) {
			lbFechaInicio = new JLabel("Fecha inicio");
			lbFechaInicio.setFont(new Font("Segoe UI Black", Font.BOLD, 14));
		}
		return lbFechaInicio;
	}

	private JLabel getLbCuotaInscripcion() {
		if (lbCuotaInscripcion == null) {
			lbCuotaInscripcion = new JLabel("Cuota");
			lbCuotaInscripcion.setFont(new Font("Segoe UI Black", Font.BOLD, 14));
		}
		return lbCuotaInscripcion;
	}

	private JTextField getTxFechaFinPlazo() {
		if (txFechaFinPlazo == null) {
			txFechaFinPlazo = new JTextField();
			txFechaFinPlazo.setText("2021/12/22");
			txFechaFinPlazo.setColumns(10);
		}
		return txFechaFinPlazo;
	}

	private JTextField getTxFechaInicioPlazo() {
		if (txFechaInicioPlazo == null) {
			txFechaInicioPlazo = new JTextField();
			txFechaInicioPlazo.setText("2021/12/20");
			txFechaInicioPlazo.setColumns(10);
		}
		return txFechaInicioPlazo;
	}

	private JPanel getPnCategoriasCarrera() {
		if (pnCategoriasCarrera == null) {
			pnCategoriasCarrera = new JPanel();
			pnCategoriasCarrera.setBackground(new Color(70, 130, 180));
			GroupLayout gl_pnCategoriasCarrera = new GroupLayout(pnCategoriasCarrera);
			gl_pnCategoriasCarrera.setHorizontalGroup(gl_pnCategoriasCarrera.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_pnCategoriasCarrera.createSequentialGroup().addContainerGap()
							.addGroup(gl_pnCategoriasCarrera.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_pnCategoriasCarrera.createSequentialGroup()
											.addComponent(getLbCategoriasCarrera(), GroupLayout.DEFAULT_SIZE,
													GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addGap(237))
									.addGroup(gl_pnCategoriasCarrera.createSequentialGroup()
											.addGroup(gl_pnCategoriasCarrera.createParallelGroup(Alignment.TRAILING)
													.addComponent(getLbEdadFinCategoria(), GroupLayout.DEFAULT_SIZE,
															129, Short.MAX_VALUE)
													.addComponent(getLbNombreCategoria(), Alignment.LEADING,
															GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
													.addComponent(getLbEdadInicioCategoria(), Alignment.LEADING,
															GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE))
											.addPreferredGap(ComponentPlacement.RELATED)
											.addGroup(gl_pnCategoriasCarrera.createParallelGroup(Alignment.LEADING)
													.addComponent(getTxEdadFinCategoria(), GroupLayout.DEFAULT_SIZE,
															193, Short.MAX_VALUE)
													.addComponent(getTxEdadInicioCategoria(), GroupLayout.DEFAULT_SIZE,
															193, Short.MAX_VALUE)
													.addComponent(getTxNombreCategoria(), GroupLayout.DEFAULT_SIZE, 193,
															Short.MAX_VALUE))))
							.addGap(10))
					.addGroup(Alignment.TRAILING, gl_pnCategoriasCarrera.createSequentialGroup()
							.addComponent(getBtAnadirCategoria(), GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
							.addContainerGap()));
			gl_pnCategoriasCarrera
					.setVerticalGroup(gl_pnCategoriasCarrera.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_pnCategoriasCarrera.createSequentialGroup().addGap(5)
									.addComponent(getLbCategoriasCarrera(), GroupLayout.DEFAULT_SIZE,
											GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_pnCategoriasCarrera.createParallelGroup(Alignment.LEADING, false)
											.addComponent(getTxNombreCategoria()).addComponent(getLbNombreCategoria(),
													GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
									.addGroup(gl_pnCategoriasCarrera.createParallelGroup(Alignment.BASELINE)
											.addComponent(getLbEdadInicioCategoria(), GroupLayout.PREFERRED_SIZE, 23,
													GroupLayout.PREFERRED_SIZE)
											.addComponent(getTxEdadInicioCategoria(), GroupLayout.PREFERRED_SIZE, 19,
													GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_pnCategoriasCarrera.createParallelGroup(Alignment.BASELINE)
											.addComponent(getTxEdadFinCategoria(), GroupLayout.PREFERRED_SIZE, 19,
													GroupLayout.PREFERRED_SIZE)
											.addComponent(getLbEdadFinCategoria(), GroupLayout.PREFERRED_SIZE, 23,
													GroupLayout.PREFERRED_SIZE))
									.addGap(10)
									.addComponent(getBtAnadirCategoria(), GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
									.addGap(6)));
			pnCategoriasCarrera.setLayout(gl_pnCategoriasCarrera);
		}
		return pnCategoriasCarrera;
	}

	private JLabel getLbCategoriasCarrera() {
		if (lbCategoriasCarrera == null) {
			lbCategoriasCarrera = new JLabel("Categorias");
			lbCategoriasCarrera.setFont(new Font("Segoe UI Black", Font.BOLD, 16));
		}
		return lbCategoriasCarrera;
	}

	private JLabel getLbEdadInicioCategoria() {
		if (lbEdadInicioCategoria == null) {
			lbEdadInicioCategoria = new JLabel("Edad inicio");
			lbEdadInicioCategoria.setFont(new Font("Segoe UI Black", Font.BOLD, 14));
		}
		return lbEdadInicioCategoria;
	}

	private JLabel getLbNombreCategoria() {
		if (lbNombreCategoria == null) {
			lbNombreCategoria = new JLabel("Nombre");
			lbNombreCategoria.setFont(new Font("Segoe UI Black", Font.BOLD, 14));
		}
		return lbNombreCategoria;
	}

	private JLabel getLbEdadFinCategoria() {
		if (lbEdadFinCategoria == null) {
			lbEdadFinCategoria = new JLabel("Edad fin");
			lbEdadFinCategoria.setFont(new Font("Segoe UI Black", Font.BOLD, 14));
		}
		return lbEdadFinCategoria;
	}

	private JTextField getTxEdadInicioCategoria() {
		if (txEdadInicioCategoria == null) {
			txEdadInicioCategoria = new JTextField();
			txEdadInicioCategoria.setText("18");
			txEdadInicioCategoria.setColumns(10);
		}
		return txEdadInicioCategoria;
	}

	private JTextField getTxNombreCategoria() {
		if (txNombreCategoria == null) {
			txNombreCategoria = new JTextField();
			txNombreCategoria.setText("Adultos");
			txNombreCategoria.setColumns(10);
		}
		return txNombreCategoria;
	}

	private JButton getBtAnadirInscripcion() {
		if (btAnadirInscripcion == null) {
			btAnadirInscripcion = new JButton("A\u00F1adir inscripci\u00F3n");
			btAnadirInscripcion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					a�adePlazoInscripcion();
				}
			});
			btAnadirInscripcion.setFont(new Font("Segoe UI Black", Font.BOLD, 14));
		}
		return btAnadirInscripcion;
	}

	private JTextField getTxCuotaCarrera() {
		if (txCuotaCarrera == null) {
			txCuotaCarrera = new JTextField();
			txCuotaCarrera.setText("3");
			txCuotaCarrera.setColumns(10);
		}
		return txCuotaCarrera;
	}

	private JTextField getTxEdadFinCategoria() {
		if (txEdadFinCategoria == null) {
			txEdadFinCategoria = new JTextField();
			txEdadFinCategoria.setText("29");
			txEdadFinCategoria.setColumns(10);
		}
		return txEdadFinCategoria;
	}

	private JButton getBtAnadirCategoria() {
		if (btAnadirCategoria == null) {
			btAnadirCategoria = new JButton("A\u00F1adir categor\u00EDa");
			btAnadirCategoria.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					a�adeCategoria();
				}
			});
			btAnadirCategoria.setFont(new Font("Segoe UI Black", Font.BOLD, 14));
		}
		return btAnadirCategoria;
	}

	private JButton getBtCrearCarrera() {
		if (btCrearCarrera == null) {
			btCrearCarrera = new JButton("Crear carrera");
			btCrearCarrera.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					crearCarrera();
				}
			});
			btCrearCarrera.setFont(new Font("Segoe UI Black", Font.BOLD, 14));
		}
		return btCrearCarrera;
	}

	private JButton getBtResetCarrera() {
		if (btResetCarrera == null) {
			btResetCarrera = new JButton("Reset");
			btResetCarrera.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					resetearCamposCarrera();
				}

			});
			btResetCarrera.setFont(new Font("Segoe UI Black", Font.BOLD, 14));
		}
		return btResetCarrera;
	}

	private JButton getBtCargarTiempos() {
		if (btCargarTiempos == null) {
			btCargarTiempos = new JButton("Cargar tiempos");
			btCargarTiempos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cargarTiempos();
				}
			});
			btCargarTiempos.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
			btCargarTiempos.setForeground(new Color(184, 220, 245));
			btCargarTiempos.setBackground(new Color(50, 130, 181));
		}
		return btCargarTiempos;
	}

	private JButton getBtGenerarDorsales() {
		if (btGenerarDorsales == null) {
			btGenerarDorsales = new JButton("Generar Dorsales");
			btGenerarDorsales.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					generarDorsales();
				}
			});
			btGenerarDorsales.setForeground(new Color(184, 220, 245));
			btGenerarDorsales.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
			btGenerarDorsales.setBackground(new Color(50, 130, 181));
		}
		return btGenerarDorsales;
	}

	private JScrollPane getScrollPanePeriodos() {
		if (scrollPanePeriodos == null) {
			scrollPanePeriodos = new JScrollPane();
			scrollPanePeriodos.setViewportView(getTxPeriodos());
		}
		return scrollPanePeriodos;
	}

	private JLabel getLblPeriodos() {
		if (lblPeriodos == null) {
			lblPeriodos = new JLabel("Periodos");
			lblPeriodos.setFont(new Font("Segoe UI Black", Font.BOLD, 16));
		}
		return lblPeriodos;
	}

	private JLabel getLblCategorias() {
		if (lblCategorias == null) {
			lblCategorias = new JLabel("Categorias");
			lblCategorias.setFont(new Font("Segoe UI Black", Font.BOLD, 16));
		}
		return lblCategorias;
	}

	private JScrollPane getScrollPaneCategorias() {
		if (scrollPaneCategorias == null) {
			scrollPaneCategorias = new JScrollPane();
			scrollPaneCategorias.setViewportView(getTxCategorias());
		}
		return scrollPaneCategorias;
	}

	private JTextArea getTxCategorias() {
		if (txCategorias == null) {
			txCategorias = new JTextArea();
			txCategorias.setEditable(false);
		}
		return txCategorias;
	}

	private JTextArea getTxPeriodos() {
		if (txPeriodos == null) {
			txPeriodos = new JTextArea();
			txPeriodos.setEditable(false);
		}
		return txPeriodos;
	}

	private JMenuItem getMnItemEmail() {
		if (mnItemEmail == null) {
			mnItemEmail = new JMenuItem("Login");
			mnItemEmail.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cargarEmail();
				}
			});
		}
		return mnItemEmail;
	}

	// METODOS PARTICIPANTE
	private void cargarEmail() {
		String email_atleta = JOptionPane.showInputDialog(this, "Introduce tu email", "E-mail");
		if (Validadores.comprobarEmail(email_atleta)) {
			try {
				if (Check.atletaExists(email_atleta)) {
					email = email_atleta;
				} else {
					JOptionPane.showMessageDialog(this, "No estas registrado", "Error", JOptionPane.WARNING_MESSAGE);
				}
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(this, "Ha ocurrido un error", "Error", JOptionPane.WARNING_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(this, "Tu email no es valido", "Error", JOptionPane.WARNING_MESSAGE);
		}
	}

	private void mostrarPanelParticipante() {
		GuiLogic.cargarTodasCarrerasParticipante(tablaCarrerasParticipante);
		CardLayout cl = (CardLayout) (pnPrincipal.getLayout());
		cl.show(pnPrincipal, "pnParticipante");
	}

	private void mostrarCarrerasParticipante() {
		switch (getCbCarrerasParticipante().getSelectedIndex()) {
		case 0:
			mostrarTodasCarrerasParticipante();
			break;
		case 1:
			mostrarCarrerasPropiasParticipante();
			break;
		}
	}

	public void mostrarTodasCarrerasParticipante() {
		GuiLogic.cargarTodasCarrerasParticipante(getTablaCarrerasParticipante());
	}

	private void mostrarCarrerasPropiasParticipante() {
		String email_atleta;
		if (email == null) {
			email_atleta = JOptionPane.showInputDialog(this, "Introduce tu email", "E-mail");
		} else {
			email_atleta = email;
		}
		if (Validadores.comprobarEmail(email_atleta)) {
			try {
				if (Check.atletaExists(email_atleta)) {
					GuiLogic.cargarPropiasCarrerasParticipante(getTablaCarrerasParticipante(), email_atleta);
				} else {
					JOptionPane.showMessageDialog(this, "No estas inscrito en ninguna carrera", "Error",
							JOptionPane.WARNING_MESSAGE);
				}
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(this, "Ha ocurrido un error", "Error", JOptionPane.WARNING_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(this, "Tu email no es valido", "Error", JOptionPane.WARNING_MESSAGE);
		}

	}

	private void mostrarVentanaInscripcion() {
		if (carreraSeleccionadaParticipante()) {
			VentanaInscribirse v = new VentanaInscribirse(getCarreraSeleccionadaParticipante());
			v.setVisible(true);
		}
	}

	private String getCarreraSeleccionadaParticipante() {
		if (tablaCarrerasParticipante.getSelectedRow() == -1) {
			return null;
		}
		return tablaCarrerasParticipante.getValueAt(tablaCarrerasParticipante.getSelectedRow(), 0).toString();
	}

	private boolean carreraSeleccionadaParticipante() {
		String carrera = getCarreraSeleccionadaParticipante();
		if (carrera == null) {
			JOptionPane.showMessageDialog(this, "No se ha seleccionado ninguna carrera", "Error",
					JOptionPane.WARNING_MESSAGE);
			return false;
		} else {
			return true;
		}
	}

	private void pagar() {
		if (carreraSeleccionadaParticipante()) {
			String email_atleta;
			if (email == null) {
				email_atleta = JOptionPane.showInputDialog(this, "Introduce tu email", "E-mail");
			} else {
				email_atleta = email;
			}
			comprobarPuedePagar(getCarreraSeleccionadaParticipante(), email_atleta);
		}

	}

	private void comprobarPuedePagar(String id, String email) {
		if (puedePagar(id, email)) {
			VentanaEscogerPago pago = new VentanaEscogerPago(this, id, email);

			pago.setVisible(true);
		} else {
			JOptionPane.showMessageDialog(this, "Ya se ha realizado el pago sobre la carrera: " + id);
		}
	}

	private boolean puedePagar(String carrera_id, String email_atleta) {
		try {
			return Check.puedePagarInscripcion(carrera_id, email_atleta);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(this, "Ha ocurrido un error gestionando el pago", "Error",
					JOptionPane.WARNING_MESSAGE);
		}
		return false;
	}

	// METODOS ORGANIZADOR

	private void mostrarPanelOrganizador() {
		CardLayout cl = (CardLayout) (pnPrincipal.getLayout());
		cl.show(pnPrincipal, "pnOrganizador");
		mostrarPanelOrganizadorCarreras();
	}

	private void mostrarPanelOrganizadorInscritos() {
		if (carreraSeleccionadaOrganizador()) {
			String id = getCarreraSeleccionadaOrganizador();
			GuiLogic.cargarInscritosCarrera(id, tablaParticipantes);
			CardLayout cl = (CardLayout) (pnTablasOrganizador.getLayout());
			cl.show(pnTablasOrganizador, "pnParticipantesOrganizador");
		}
	}

	private void mostrarPanelOrganizadorCarreras() {
		GuiLogic.cargarCarrerasOrganizador(tablaCarrerasOrganizador);
		CardLayout cl = (CardLayout) (pnTablasOrganizador.getLayout());
		cl.show(pnTablasOrganizador, "pnCarrerasOrganizador");
	}

	private void mostrarPanelOrganizadorClasificacionesAbsolutas(String id) {
		GuiLogic.cargarClasificacionesAbsolutas(id, tablaClasificacionesAbsoluta);
		CardLayout cl = (CardLayout) (pnTablasOrganizador.getLayout());
		cl.show(pnTablasOrganizador, "pnClasificacionesAbsolutas");
	}

	private void mostrarPanelOrganizadorClasificacionesSexo(String id) {
		GuiLogic.cargarClasificacionesFemeninas(id, tablaClasificacionesHombre);
		GuiLogic.cargarClasificacionesMasculinas(id, tablaClasificacionesMujer);
		CardLayout cl = (CardLayout) (pnTablasOrganizador.getLayout());
		cl.show(pnTablasOrganizador, "pnClasificacionesSexo");
	}

	private void mostrarPanelOrganizadorCrearCarrera() {
		CardLayout cl = (CardLayout) (pnTablasOrganizador.getLayout());
		cl.show(pnTablasOrganizador, "pnCrearCarreras");

	}

	private void mostrarPanelOrganizadorClasificacionesCategoria(String idCarrera, String categoria) {
		GuiLogic.cargarClasificacionCategoria(tablaClasificacionesAbsoluta, idCarrera, categoria);
		CardLayout cl = (CardLayout) (pnTablasOrganizador.getLayout());
		cl.show(pnTablasOrganizador, "pnClasificacionesAbsolutas");
	}

	private void mostrarClasificaciones() {
		if (carreraSeleccionadaOrganizador()) {
			String idCarrera = getCarreraSeleccionadaOrganizador();
			switch (cbClasificaciones.getSelectedIndex()) {
			case 0:
				mostrarPanelOrganizadorClasificacionesAbsolutas(idCarrera);
				break;
			case 1:
				mostrarPanelOrganizadorClasificacionesSexo(idCarrera);
				break;
			default:
				String categoria = cbClasificaciones.getSelectedItem().toString();
				mostrarPanelOrganizadorClasificacionesCategoria(idCarrera, categoria);
			}
		}
	}

	public void comprobarIdCarreraValidaOrganizador(String id) {

		try {
			if (GuiLogic.comprobarIdValidaCarrera(id)) {
				getBtMostrarClasificaciones().setEnabled(true);
				getBtMostrarParticipantes().setEnabled(true);
			} else {
				getBtMostrarClasificaciones().setEnabled(false);
				getBtMostrarParticipantes().setEnabled(false);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Exito", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	private void vaciarCamposCrearCarrera() {
		// Resetea datos carrera
		getTxNombreCarrera().setText("");
		getTxFechaCarrera().setText("");
		getCbTipoCarrera().setSelectedIndex(0);
		getTxDistanciaCarrera().setText("");
		getTxPlazasCarrera().setText("");
		// Resetea plazos inscripcion
		vaciarCamposCategoria();
		// Resetea categorias
		vaciarCamposPlazoInscripcion();
	}

	private void vaciarCamposCategoria() {
		getTxNombreCategoria().setText("");
		getTxEdadInicioCategoria().setText("");
		getTxEdadFinCategoria().setText("");
	}

	private void vaciarCamposPlazoInscripcion() {
		getTxFechaInicioPlazo().setText("");
		getTxFechaFinPlazo().setText("");
		getTxCuotaCarrera().setText("");
	}

	private void crearCarrera() {
		if (comprobarCamposCarrera()) {
			try {
				GuiLogic.crearCarrera(getTxNombreCarrera().getText(), getTxFechaCarrera().getText(),
						getCbTipoCarrera().getSelectedItem().toString(), getTxDistanciaCarrera().getText(),
						getTxPlazasCarrera().getText(), carreraManager.getCategorias(), carreraManager.getPeriodos(),
						getChBoxListaEspera().isSelected(), getChBoxCancelacionInscripcion().isSelected());
				JOptionPane.showMessageDialog(this, "La carrera se ha creado con exito", "Exito",
						JOptionPane.INFORMATION_MESSAGE);
				vaciarCamposCrearCarrera();
			} catch (BusinessDataException e) {
				JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
			}
		}
	}

	private boolean comprobarCamposCarrera() {
		if (Validadores.comprobarNoVacio(getTxNombreCarrera().getText())
				&& Validadores.comprobarMayorNumero(getTxDistanciaCarrera().getText(), 0)
				&& Validadores.comprobarMayorNumero(getTxPlazasCarrera().getText(), 0)) {
			return true;
		} else {
			JOptionPane.showMessageDialog(this, "Comprueba los campos de la carrera", "Error",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}

	}

	private void resetearCamposCarrera() {
		vaciarCamposCrearCarrera();
		carreraManager.cleanCategorias();
		carreraManager.cleanPeriodos();
	}

	private void a�adePlazoInscripcion() {
		String fechaInicio = getTxFechaInicioPlazo().getText();
		String fechaFin = getTxFechaFinPlazo().getText();
		String cuota = getTxCuotaCarrera().getText();
		if (Validadores.comprobarMayorNumero(cuota, 0)
				&& Validadores.comprobarFechasValidas(getTxFechaCarrera().getText(), fechaInicio, fechaFin)) {
			try {
				carreraManager.addPeriodo(fechaInicio, fechaFin, Double.parseDouble(cuota));
				txPeriodos.setText(txPeriodos.getText() + "Inicio: " + txFechaInicioPlazo.getText() + " - Fin: "
						+ txFechaFinPlazo.getText() + " - Precio: " + txCuotaCarrera.getText() + "\n");
				vaciarCamposPlazoInscripcion();
				JOptionPane.showMessageDialog(this, "El plazo de inscripci�n ha sido creado", "�xito",
						JOptionPane.INFORMATION_MESSAGE);
			} catch (BusinessDataException e) {
				JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
				vaciarCamposPlazoInscripcion();
			}
		} else {
			JOptionPane.showMessageDialog(this, "Comprueba las fechas de los plazos", "Error",
					JOptionPane.WARNING_MESSAGE);
		}
	}

	private void a�adeCategoria() {
		String nombreCategoria = getTxNombreCategoria().getText();
		String edadInicio = getTxEdadInicioCategoria().getText();
		String edadFin = getTxEdadFinCategoria().getText();
		if (Validadores.comprobarMayor18Numero(edadInicio) && Validadores.comprobarMayor18Numero(edadFin)
				&& Validadores.comprobarEdadesCategoria(edadInicio, edadFin)) {
			try {
				carreraManager.addCategoria(nombreCategoria, Integer.parseInt(edadInicio), Integer.parseInt(edadFin));
				txCategorias.setText(txCategorias.getText() + "Categoria: " + txNombreCategoria.getText() + ". "
						+ txEdadInicioCategoria.getText() + " - " + txEdadFinCategoria.getText() + "\n");

				vaciarCamposCategoria();
				JOptionPane.showMessageDialog(this, "La categor�a se ha creado", "�xito",
						JOptionPane.INFORMATION_MESSAGE);
			} catch (BusinessDataException e) {
				JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
				vaciarCamposCategoria();
			}

		} else {
			JOptionPane.showMessageDialog(this, "Comprueba los campos de las categor�as", "Error",
					JOptionPane.WARNING_MESSAGE);
		}
	}

	private void generarDorsales() {
		if (carreraSeleccionadaOrganizador()) {
			if (GuiLogic.comprobarInscripcionesFinalizadas(getCarreraSeleccionadaOrganizador())) {
				String dorsalesReservados = JOptionPane.showInputDialog(this,
						"Introduce el n�mero de dorsales a reservar", "Dorsales");
				if (Validadores.comprobarMayorNumero(dorsalesReservados, -1)) {
					GuiLogic.generarDorsales(getCarreraSeleccionadaOrganizador(), Integer.parseInt(dorsalesReservados));
				} else {
					JOptionPane.showMessageDialog(this, "No se han reservado los dorsales correctamente", "Error",
							JOptionPane.WARNING_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(this, "La carrera aun no ha finalizado", "Error",
						JOptionPane.WARNING_MESSAGE);
			}
		}
	}

	private void cargarTiempos() {
		if (carreraSeleccionadaOrganizador()) {
			try {
				if (GuiLogic.comprobarCarreraFinalizada(getCarreraSeleccionadaOrganizador())) {
					JFileChooser fc = new JFileChooser();
					fc.setFileFilter(new FileNameExtensionFilter("Time Files", "tm"));
					int returnVal = fc.showOpenDialog(this);
					if (returnVal == JFileChooser.APPROVE_OPTION) {
						File file = fc.getSelectedFile();
						GuiLogic.cargaTiemposCarrera(getCarreraSeleccionadaOrganizador(), file);
					} else {
						JOptionPane.showMessageDialog(this, "No se ha seleccionado ningun archivo", "Error",
								JOptionPane.WARNING_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(this, "La carrera aun no ha finalizado", "Error",
							JOptionPane.WARNING_MESSAGE);
				}
			} catch (BusinessDataException e) {
				JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
			}
		}
	}

	// TODO
	private void cargarCategorias() {
		if (carreraSeleccionadaOrganizador()) {
			String[] aux = tablaCarrerasOrganizador.getValueAt(tablaCarrerasOrganizador.getSelectedRow(), 6).toString()
					.split(";");
			String[] categorias = new String[10];
			categorias[0] = "Absolutas";
			categorias[1] = "Por sexo";
			for (int i = 0; i < aux.length; i++) {
				categorias[i + 2] = aux[i].split(",")[0];
			}
			getCbClasificaciones().setModel(new DefaultComboBoxModel<String>(categorias));
		}
	}

	private String getCarreraSeleccionadaOrganizador() {
		if (tablaCarrerasOrganizador.getSelectedRow() == -1) {
			return null;
		}
		return tablaCarrerasOrganizador.getValueAt(tablaCarrerasOrganizador.getSelectedRow(), 0).toString();
	}

	private boolean carreraSeleccionadaOrganizador() {
		String carrera = getCarreraSeleccionadaOrganizador();
		if (carrera == null) {
			JOptionPane.showMessageDialog(this, "No se ha seleccionado ninguna carrera", "Error",
					JOptionPane.WARNING_MESSAGE);
			return false;
		} else {
			return true;
		}
	}

	private void inscribirClubOrganizador() {
		JFileChooser fc = new JFileChooser();
		fc.setFileFilter(new FileNameExtensionFilter("Fichero Lote Atletas", "fla"));
		int returnVal = fc.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			GuiLogic.inscribeClubCarrera(file);
		} else {
			JOptionPane.showMessageDialog(this, "No se ha seleccionado ningun archivo", "Error",
					JOptionPane.WARNING_MESSAGE);
		}
	}

	private JButton getBtInscribirClubOrganizador() {
		if (btInscribirClubOrganizador == null) {
			btInscribirClubOrganizador = new JButton("Inscribir club");
			btInscribirClubOrganizador.setForeground(new Color(184, 220, 245));
			btInscribirClubOrganizador.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
			btInscribirClubOrganizador.setBackground(new Color(50, 130, 181));
		}
		return btInscribirClubOrganizador;
	}

	private JCheckBox getChBoxListaEspera() {
		if (chBoxListaEspera == null) {
			chBoxListaEspera = new JCheckBox("Lista de espera");
		}
		return chBoxListaEspera;
	}

	private JCheckBox getChBoxCancelacionInscripcion() {
		if (chBoxCancelacionInscripcion == null) {
			chBoxCancelacionInscripcion = new JCheckBox("Cancelaci\u00F3n de inscripciones");
		}
		return chBoxCancelacionInscripcion;
	}
}
