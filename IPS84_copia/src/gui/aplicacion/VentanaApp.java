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
import javax.swing.JCheckBox;
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
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
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

public class VentanaApp extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel pnPrincipal;
	private JPanel pnParticipante;
	private JPanel pnBotonesParticipante;
	private JPanel pnBotonesOrdenarParticipante;
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
	private static final boolean CON_LISTA = true;
	private static final boolean SIN_LISTA = false;

	private CarreraManager carreraManager;
	private String email;
	private JCheckBox chBoxListaEspera;
	private JCheckBox chBoxCancelacionInscripcion;
	private JPanel pnTiemposCorte;
	private JLabel lbKilometroPuntoCorte;
	private JTextField txKilometroCorte;
	private JLabel lbPuntoDeCorte;
	private JButton btnAadirPuntoDe;
	private JLabel lbPuntosCorte;
	private JScrollPane scrollPanePuntosCorte;
	private JTextArea txPuntosCorte;
	private JTextField txtPorcentajeADevolver;
	private JLabel lblFechaCancelacion;
	private JLabel lblCuota_1;
	private JTextField txtFechaMaxCancelacion;
	private JButton bntCancelarInscripcion;
	private JButton btInscribirClubPanel;
	private JPanel pnCardsParticipante;
	private JScrollPane scrollPaneTabla;
	private JTable tablaCarrerasParticipante;

	private JPanel pnClub;
	private JPanel pnFormularioClub;
	private JScrollPane scrollPaneParticipantesClub;
	private JTable tablaParticipantesClub;
	private JLabel lbDniAtletaClub;
	private JLabel lbNombreParticipante;
	private JLabel lblFechaDeNacimiento;
	private JLabel lbSexoAtletaClub;
	private JComboBox<String> cbSexoAtletaClub;
	private JTextField txFechaNacimientoAtletaClub;
	private JLabel lbNombreClub;
	private JTextField txNombreClub;
	private JSeparator separator;
	private JButton btCargarFicheroClub;
	private JSeparator separator_1;
	private JLabel lbEmailAtletaClub;
	private JTextField txEmailAtletaClub;
	private JTextField txDniAtletaClub;
	private JTextField txNombreAtletaClub;
	private JButton btAñadirParticipanteClub;
	private JButton btEliminarParticipanteClub;
	private JSeparator separator_1_1;
	private JButton btInscribirClub;

	/**
	 * Create the frame.
	 */
	public VentanaApp(int mode) {
		setTitle("Gestor carreras");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1042, 812);
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
			gl_pnParticipante.setHorizontalGroup(gl_pnParticipante.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_pnParticipante.createSequentialGroup().addContainerGap().addGroup(gl_pnParticipante
							.createParallelGroup(Alignment.LEADING)
							.addComponent(getPnCardsParticipante(), GroupLayout.DEFAULT_SIZE, 998, Short.MAX_VALUE)
							.addGroup(gl_pnParticipante
									.createSequentialGroup().addComponent(getPnBotonesParticipante(),
											GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addContainerGap()))));
			gl_pnParticipante.setVerticalGroup(gl_pnParticipante.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_pnParticipante.createSequentialGroup().addContainerGap()
							.addComponent(getPnBotonesParticipante(), GroupLayout.PREFERRED_SIZE, 93,
									GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(getPnCardsParticipante(), GroupLayout.DEFAULT_SIZE, 624, Short.MAX_VALUE)));
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
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(getCbCarrerasParticipante(), GroupLayout.PREFERRED_SIZE,
									GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(getBntCancelarInscripcion(),
									GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(501, Short.MAX_VALUE)));
			gl_pnBotonesOrdenarParticipante.setVerticalGroup(gl_pnBotonesOrdenarParticipante
					.createParallelGroup(Alignment.TRAILING)
					.addGroup(gl_pnBotonesOrdenarParticipante.createSequentialGroup()
							.addGroup(gl_pnBotonesOrdenarParticipante.createParallelGroup(Alignment.TRAILING)
									.addComponent(getBntCancelarInscripcion(), Alignment.LEADING,
											GroupLayout.PREFERRED_SIZE, 37, Short.MAX_VALUE)
									.addGroup(gl_pnBotonesOrdenarParticipante.createParallelGroup(Alignment.BASELINE)
											.addComponent(getBtOrdenar(), GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
											.addComponent(getCbCarrerasParticipante(), GroupLayout.DEFAULT_SIZE, 37,
													Short.MAX_VALUE)))
							.addGap(43)));
			pnBotonesOrdenarParticipante.setLayout(gl_pnBotonesOrdenarParticipante);
		}
		return pnBotonesOrdenarParticipante;
	}

	private JButton getBtOrdenar() {
		if (btOrdenar == null) {
			btOrdenar = new JButton("Mostrar");
			btOrdenar.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
			btOrdenar.addActionListener(new ActionListener() {
				@Override
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
					.setHorizontalGroup(
							gl_pnBotonesInscribirseParticipante.createParallelGroup(Alignment.LEADING)
									.addGroup(
											gl_pnBotonesInscribirseParticipante.createSequentialGroup()
													.addComponent(getBtInscribirseParticipante(),
															GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.UNRELATED)
													.addComponent(getBtPagarParticipante(), GroupLayout.PREFERRED_SIZE,
															137, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.UNRELATED)
													.addComponent(getBtInscribirClubPanel(), GroupLayout.PREFERRED_SIZE,
															186, GroupLayout.PREFERRED_SIZE)
													.addContainerGap(449, Short.MAX_VALUE)));
			gl_pnBotonesInscribirseParticipante.setVerticalGroup(gl_pnBotonesInscribirseParticipante
					.createParallelGroup(Alignment.TRAILING)
					.addGroup(gl_pnBotonesInscribirseParticipante.createSequentialGroup().addGap(25)
							.addGroup(gl_pnBotonesInscribirseParticipante.createParallelGroup(Alignment.BASELINE)
									.addComponent(getBtInscribirseParticipante(), GroupLayout.PREFERRED_SIZE, 24,
											Short.MAX_VALUE)
									.addComponent(getBtPagarParticipante(), GroupLayout.PREFERRED_SIZE, 24,
											Short.MAX_VALUE)
									.addComponent(getBtInscribirClubPanel(), GroupLayout.PREFERRED_SIZE, 24,
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
				@Override
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
				@Override
				public void actionPerformed(ActionEvent e) {
					inscribirse();
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
				@Override
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
					.addGroup(Alignment.TRAILING, gl_pnOrganizador.createSequentialGroup().addContainerGap()
							.addGroup(gl_pnOrganizador.createParallelGroup(Alignment.TRAILING)
									.addComponent(getPnBotonesOrganizador(), Alignment.LEADING,
											GroupLayout.DEFAULT_SIZE, 956, Short.MAX_VALUE)
									.addComponent(getPnTablasOrganizador(), Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
											956, Short.MAX_VALUE))
							.addContainerGap()));
			gl_pnOrganizador.setVerticalGroup(gl_pnOrganizador.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_pnOrganizador.createSequentialGroup().addGap(5)
							.addComponent(getPnBotonesOrganizador(), GroupLayout.PREFERRED_SIZE,
									GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(getPnTablasOrganizador(),
									GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
											.addComponent(getBtCargarTiempos()).addContainerGap(513, Short.MAX_VALUE)));
			gl_pnBotonesOrganizador2.setVerticalGroup(gl_pnBotonesOrganizador2.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_pnBotonesOrganizador2.createParallelGroup(Alignment.BASELINE)
							.addComponent(getBtCrearCarreraOrganizador(), GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
							.addComponent(getBtGenerarDorsales(), GroupLayout.PREFERRED_SIZE, 37,
									GroupLayout.PREFERRED_SIZE)
							.addComponent(getBtCargarTiempos(), GroupLayout.PREFERRED_SIZE, 37,
									GroupLayout.PREFERRED_SIZE)));
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
				@Override
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
				@Override
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
				@Override
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
		}
		return tablaClasificacionesHombre;
	}

	private JTable getTablaClasificacionesMujer() {
		if (tablaClasificacionesMujer == null) {
			tablaClasificacionesMujer = new JTable();
		}
		return tablaClasificacionesMujer;
	}

	private JMenuItem getMnItCuentaOrganizador() {
		if (mnItCuentaOrganizador == null) {
			mnItCuentaOrganizador = new JMenuItem("Organizador");
			mnItCuentaOrganizador.addActionListener(new ActionListener() {
				@Override
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
				@Override
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
				@Override
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
			pnCrearCarrera.setLayout(null);
			pnCrearCarrera.add(getPnDatosCarrera());
			pnCrearCarrera.add(getPnCategoriasCarrera());
			pnCrearCarrera.add(getPnTiemposCorte());
			pnCrearCarrera.add(getPnInscripcionCarrera());
			pnCrearCarrera.add(getBtCrearCarrera());
			pnCrearCarrera.add(getBtResetCarrera());
			pnCrearCarrera.add(getChBoxCancelacionInscripcion());
			pnCrearCarrera.add(getLbPuntosCorte());
			pnCrearCarrera.add(getScrollPanePeriodos());
			pnCrearCarrera.add(getLblPeriodos());
			pnCrearCarrera.add(getChBoxListaEspera());
			pnCrearCarrera.add(getLblFechaCancelacion());
			pnCrearCarrera.add(getTxtPorcentajeADevolver());
			pnCrearCarrera.add(getScrollPaneCategorias());
			pnCrearCarrera.add(getLblCategorias());
			pnCrearCarrera.add(getScrollPanePuntosCorte());
			pnCrearCarrera.add(getLblCuota_1());
			pnCrearCarrera.add(getTxtFechaMaxCancelacion());
		}
		return pnCrearCarrera;
	}

	private JButton getBtCrearCarreraOrganizador() {
		if (btCrearCarreraOrganizador == null) {
			btCrearCarreraOrganizador = new JButton("Crear carrera");
			btCrearCarreraOrganizador.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
			btCrearCarreraOrganizador.addActionListener(new ActionListener() {
				@Override
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
			lbDistanciaCarrera = new JLabel("Distancia carrera(km)");
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
			txNombreCarrera.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
			txNombreCarrera.setText("CarreraPrueba");
			txNombreCarrera.setColumns(10);
		}
		return txNombreCarrera;
	}

	private JTextField getTxFechaCarrera() {
		if (txFechaCarrera == null) {
			txFechaCarrera = new JTextField();
			txFechaCarrera.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
			txFechaCarrera.setText("2021/12/30");
			txFechaCarrera.setColumns(10);
		}
		return txFechaCarrera;
	}

	private JTextField getTxDistanciaCarrera() {
		if (txDistanciaCarrera == null) {
			txDistanciaCarrera = new JTextField();
			txDistanciaCarrera.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
			txDistanciaCarrera.setText("15");
			txDistanciaCarrera.setColumns(10);
		}
		return txDistanciaCarrera;
	}

	private JTextField getTxPlazasCarrera() {
		if (txPlazasCarrera == null) {
			txPlazasCarrera = new JTextField();
			txPlazasCarrera.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
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
			pnDatosCarrera.setBounds(10, 11, 461, 220);
			pnDatosCarrera.setBackground(new Color(70, 130, 180));
			GroupLayout gl_pnDatosCarrera = new GroupLayout(pnDatosCarrera);
			gl_pnDatosCarrera.setHorizontalGroup(gl_pnDatosCarrera.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_pnDatosCarrera.createSequentialGroup().addContainerGap()
							.addGroup(gl_pnDatosCarrera.createParallelGroup(Alignment.LEADING)
									.addComponent(getLbDatosCarrera())
									.addGroup(gl_pnDatosCarrera
											.createSequentialGroup().addGroup(gl_pnDatosCarrera
													.createParallelGroup(Alignment.TRAILING).addComponent(
															getLbDistanciaCarrera(), Alignment.LEADING,
															GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
													.addComponent(getLbFechaCarrera(), Alignment.LEADING,
															GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
													.addComponent(getLbNombreCarrera(), Alignment.LEADING,
															GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
													.addComponent(getLbTipoCarrera(), Alignment.LEADING,
															GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
													.addComponent(
															getLbPlazasMaximaCarrera(), Alignment.LEADING,
															GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE))
											.addPreferredGap(ComponentPlacement.RELATED)
											.addGroup(gl_pnDatosCarrera.createParallelGroup(Alignment.TRAILING)
													.addGroup(gl_pnDatosCarrera.createSequentialGroup()
															.addGroup(gl_pnDatosCarrera
																	.createParallelGroup(Alignment.TRAILING)
																	.addComponent(getTxNombreCarrera(),
																			Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
																			241, Short.MAX_VALUE)
																	.addComponent(getCbTipoCarrera(), 0, 241,
																			Short.MAX_VALUE))
															.addGap(0))
													.addGroup(gl_pnDatosCarrera.createSequentialGroup()
															.addComponent(getTxFechaCarrera(), GroupLayout.DEFAULT_SIZE,
																	225, Short.MAX_VALUE)
															.addPreferredGap(ComponentPlacement.RELATED))
													.addGroup(gl_pnDatosCarrera.createSequentialGroup()
															.addComponent(getTxDistanciaCarrera(),
																	GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
															.addPreferredGap(ComponentPlacement.RELATED))
													.addComponent(getTxPlazasCarrera(), GroupLayout.DEFAULT_SIZE, 241,
															Short.MAX_VALUE))))
							.addGap(10)));
			gl_pnDatosCarrera.setVerticalGroup(gl_pnDatosCarrera.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_pnDatosCarrera.createSequentialGroup().addGap(5).addComponent(getLbDatosCarrera())
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_pnDatosCarrera.createParallelGroup(Alignment.LEADING, false)
									.addGroup(gl_pnDatosCarrera.createSequentialGroup().addGap(4).addComponent(
											getTxNombreCarrera(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
											GroupLayout.PREFERRED_SIZE))
									.addComponent(getLbNombreCarrera(), GroupLayout.PREFERRED_SIZE, 23,
											GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_pnDatosCarrera.createParallelGroup(Alignment.BASELINE)
									.addComponent(getLbFechaCarrera(), GroupLayout.PREFERRED_SIZE, 23,
											GroupLayout.PREFERRED_SIZE)
									.addComponent(getTxFechaCarrera(), GroupLayout.PREFERRED_SIZE,
											GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_pnDatosCarrera.createParallelGroup(Alignment.LEADING, false)
									.addGroup(gl_pnDatosCarrera.createSequentialGroup().addGap(1).addComponent(
											getCbTipoCarrera(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
											GroupLayout.PREFERRED_SIZE))
									.addComponent(getLbTipoCarrera(), GroupLayout.PREFERRED_SIZE, 23,
											GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_pnDatosCarrera.createParallelGroup(Alignment.BASELINE)
									.addComponent(getLbDistanciaCarrera(), GroupLayout.PREFERRED_SIZE, 23,
											GroupLayout.PREFERRED_SIZE)
									.addComponent(getTxDistanciaCarrera(), GroupLayout.PREFERRED_SIZE,
											GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_pnDatosCarrera.createParallelGroup(Alignment.LEADING)
									.addComponent(getLbPlazasMaximaCarrera(), GroupLayout.PREFERRED_SIZE, 23,
											GroupLayout.PREFERRED_SIZE)
									.addGroup(gl_pnDatosCarrera.createSequentialGroup().addGap(2).addComponent(
											getTxPlazasCarrera(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
											GroupLayout.PREFERRED_SIZE)))
							.addGap(6)));
			pnDatosCarrera.setLayout(gl_pnDatosCarrera);
		}
		return pnDatosCarrera;
	}

	private JPanel getPnInscripcionCarrera() {
		if (pnInscripcionCarrera == null) {
			pnInscripcionCarrera = new JPanel();
			pnInscripcionCarrera.setBounds(477, 11, 509, 220);
			pnInscripcionCarrera.setBackground(new Color(70, 130, 180));
			GroupLayout gl_pnInscripcionCarrera = new GroupLayout(pnInscripcionCarrera);
			gl_pnInscripcionCarrera.setHorizontalGroup(gl_pnInscripcionCarrera.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_pnInscripcionCarrera.createSequentialGroup().addContainerGap()
							.addGroup(gl_pnInscripcionCarrera.createParallelGroup(Alignment.TRAILING)
									.addGroup(gl_pnInscripcionCarrera.createSequentialGroup()
											.addGroup(gl_pnInscripcionCarrera.createParallelGroup(Alignment.LEADING)
													.addComponent(getLbPeriodosInscripcion())
													.addGroup(gl_pnInscripcionCarrera.createSequentialGroup()
															.addComponent(getLbFechaInicio(), GroupLayout.DEFAULT_SIZE,
																	201, Short.MAX_VALUE)
															.addPreferredGap(ComponentPlacement.RELATED)
															.addComponent(getTxFechaInicioPlazo(),
																	GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
															.addGap(0)))
											.addGap(10))
									.addGroup(gl_pnInscripcionCarrera.createSequentialGroup()
											.addComponent(getLbFechaFin(), GroupLayout.DEFAULT_SIZE, 201,
													Short.MAX_VALUE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(getTxFechaFinPlazo(), GroupLayout.DEFAULT_SIZE, 263,
													Short.MAX_VALUE)
											.addContainerGap())
									.addGroup(
											gl_pnInscripcionCarrera.createSequentialGroup()
													.addComponent(getLbCuotaInscripcion(), GroupLayout.DEFAULT_SIZE,
															201, Short.MAX_VALUE)
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(getTxCuotaCarrera(), GroupLayout.DEFAULT_SIZE, 263,
															Short.MAX_VALUE)
													.addContainerGap())
									.addGroup(gl_pnInscripcionCarrera
											.createSequentialGroup().addComponent(getBtAnadirInscripcion(),
													GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
											.addContainerGap()))));
			gl_pnInscripcionCarrera.setVerticalGroup(gl_pnInscripcionCarrera.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_pnInscripcionCarrera.createSequentialGroup().addGap(5)
							.addComponent(getLbPeriodosInscripcion()).addGap(14)
							.addGroup(gl_pnInscripcionCarrera.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(getLbFechaInicio(), GroupLayout.DEFAULT_SIZE,
											GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(getTxFechaInicioPlazo(), GroupLayout.DEFAULT_SIZE, 27,
											Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_pnInscripcionCarrera.createParallelGroup(Alignment.LEADING, false)
									.addComponent(getLbFechaFin(), GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
											Short.MAX_VALUE)
									.addComponent(getTxFechaFinPlazo(), GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_pnInscripcionCarrera.createParallelGroup(Alignment.BASELINE)
									.addComponent(getTxCuotaCarrera(), GroupLayout.PREFERRED_SIZE, 26,
											GroupLayout.PREFERRED_SIZE)
									.addComponent(getLbCuotaInscripcion(), GroupLayout.PREFERRED_SIZE, 23,
											GroupLayout.PREFERRED_SIZE))
							.addGap(16).addComponent(getBtAnadirInscripcion(), GroupLayout.DEFAULT_SIZE,
									GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(72)));
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
			txFechaFinPlazo.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
			txFechaFinPlazo.setText("2021/12/22");
			txFechaFinPlazo.setColumns(10);
		}
		return txFechaFinPlazo;
	}

	private JTextField getTxFechaInicioPlazo() {
		if (txFechaInicioPlazo == null) {
			txFechaInicioPlazo = new JTextField();
			txFechaInicioPlazo.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
			txFechaInicioPlazo.setText("2021/12/20");
			txFechaInicioPlazo.setColumns(10);
		}
		return txFechaInicioPlazo;
	}

	private JPanel getPnCategoriasCarrera() {
		if (pnCategoriasCarrera == null) {
			pnCategoriasCarrera = new JPanel();
			pnCategoriasCarrera.setBounds(10, 242, 461, 191);
			pnCategoriasCarrera.setBackground(new Color(70, 130, 180));
			GroupLayout gl_pnCategoriasCarrera = new GroupLayout(pnCategoriasCarrera);
			gl_pnCategoriasCarrera.setHorizontalGroup(gl_pnCategoriasCarrera.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_pnCategoriasCarrera.createSequentialGroup().addContainerGap()
							.addGroup(gl_pnCategoriasCarrera.createParallelGroup(Alignment.TRAILING)
									.addComponent(getBtAnadirCategoria(), GroupLayout.DEFAULT_SIZE, 422,
											Short.MAX_VALUE)
									.addGroup(gl_pnCategoriasCarrera.createSequentialGroup()
											.addGroup(gl_pnCategoriasCarrera.createParallelGroup(Alignment.LEADING)
													.addGroup(gl_pnCategoriasCarrera.createSequentialGroup()
															.addComponent(getLbEdadFinCategoria(),
																	GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
															.addGap(90))
													.addGroup(gl_pnCategoriasCarrera.createSequentialGroup()
															.addComponent(getLbCategoriasCarrera(),
																	GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
															.addGap(151))
													.addGroup(gl_pnCategoriasCarrera.createSequentialGroup()
															.addGroup(gl_pnCategoriasCarrera
																	.createParallelGroup(Alignment.LEADING)
																	.addComponent(getLbNombreCategoria(),
																			GroupLayout.DEFAULT_SIZE, 124,
																			Short.MAX_VALUE)
																	.addComponent(getLbEdadInicioCategoria(),
																			GroupLayout.DEFAULT_SIZE, 124,
																			Short.MAX_VALUE))
															.addGap(151)))
											.addGroup(gl_pnCategoriasCarrera.createParallelGroup(Alignment.TRAILING)
													.addGroup(gl_pnCategoriasCarrera
															.createParallelGroup(Alignment.TRAILING)
															.addGroup(gl_pnCategoriasCarrera.createSequentialGroup()
																	.addPreferredGap(ComponentPlacement.RELATED)
																	.addComponent(getTxNombreCategoria(),
																			GroupLayout.DEFAULT_SIZE, 147,
																			Short.MAX_VALUE))
															.addComponent(getTxEdadInicioCategoria(),
																	GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE))
													.addGroup(gl_pnCategoriasCarrera.createSequentialGroup().addGap(1)
															.addComponent(getTxEdadFinCategoria(),
																	GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)))))
							.addContainerGap()));
			gl_pnCategoriasCarrera
					.setVerticalGroup(gl_pnCategoriasCarrera.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_pnCategoriasCarrera.createSequentialGroup().addGap(5)
									.addComponent(getLbCategoriasCarrera(), GroupLayout.DEFAULT_SIZE,
											GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_pnCategoriasCarrera.createParallelGroup(Alignment.BASELINE)
											.addComponent(getLbNombreCategoria(), GroupLayout.PREFERRED_SIZE, 23,
													GroupLayout.PREFERRED_SIZE)
											.addComponent(getTxNombreCategoria(), GroupLayout.PREFERRED_SIZE,
													GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_pnCategoriasCarrera.createParallelGroup(Alignment.BASELINE)
											.addComponent(getLbEdadInicioCategoria(), GroupLayout.PREFERRED_SIZE, 23,
													GroupLayout.PREFERRED_SIZE)
											.addComponent(getTxEdadInicioCategoria(), GroupLayout.PREFERRED_SIZE, 19,
													GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_pnCategoriasCarrera.createParallelGroup(Alignment.BASELINE)
											.addComponent(getLbEdadFinCategoria(), GroupLayout.PREFERRED_SIZE, 23,
													GroupLayout.PREFERRED_SIZE)
											.addComponent(getTxEdadFinCategoria(), GroupLayout.PREFERRED_SIZE, 19,
													GroupLayout.PREFERRED_SIZE))
									.addGap(15).addComponent(getBtAnadirCategoria()).addContainerGap()));
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
				@Override
				public void actionPerformed(ActionEvent e) {
					addPlazoInscripcion();
				}
			});
			btAnadirInscripcion.setFont(new Font("Segoe UI Black", Font.BOLD, 14));
		}
		return btAnadirInscripcion;
	}

	private JTextField getTxCuotaCarrera() {
		if (txCuotaCarrera == null) {
			txCuotaCarrera = new JTextField();
			txCuotaCarrera.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
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
				@Override
				public void actionPerformed(ActionEvent e) {
					addCategoria();
				}
			});
			btAnadirCategoria.setFont(new Font("Segoe UI Black", Font.BOLD, 14));
		}
		return btAnadirCategoria;
	}

	private JButton getBtCrearCarrera() {
		if (btCrearCarrera == null) {
			btCrearCarrera = new JButton("Crear carrera");
			btCrearCarrera.setBounds(481, 558, 509, 27);
			btCrearCarrera.addActionListener(new ActionListener() {
				@Override
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
			btResetCarrera.setBounds(481, 525, 509, 27);
			btResetCarrera.addActionListener(new ActionListener() {
				@Override
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
				@Override
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
				@Override
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
			scrollPanePeriodos.setBounds(477, 271, 254, 70);
			scrollPanePeriodos.setViewportView(getTxPeriodos());
		}
		return scrollPanePeriodos;
	}

	private JLabel getLblPeriodos() {
		if (lblPeriodos == null) {
			lblPeriodos = new JLabel("Periodos");
			lblPeriodos.setBounds(477, 242, 85, 23);
			lblPeriodos.setFont(new Font("Segoe UI Black", Font.BOLD, 16));
		}
		return lblPeriodos;
	}

	private JLabel getLblCategorias() {
		if (lblCategorias == null) {
			lblCategorias = new JLabel("Categorias");
			lblCategorias.setBounds(747, 242, 239, 23);
			lblCategorias.setFont(new Font("Segoe UI Black", Font.BOLD, 16));
		}
		return lblCategorias;
	}

	private JScrollPane getScrollPaneCategorias() {
		if (scrollPaneCategorias == null) {
			scrollPaneCategorias = new JScrollPane();
			scrollPaneCategorias.setBounds(737, 271, 249, 70);
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
				@Override
				public void actionPerformed(ActionEvent e) {
					cargarEmail();
				}
			});
		}
		return mnItemEmail;
	}

	private JCheckBox getChBoxListaEspera() {
		if (chBoxListaEspera == null) {
			chBoxListaEspera = new JCheckBox("Lista de espera");
			chBoxListaEspera.setBounds(736, 432, 254, 38);
			chBoxListaEspera.setFont(new Font("Segoe UI Black", Font.BOLD, 14));
		}
		return chBoxListaEspera;
	}

	private JCheckBox getChBoxCancelacionInscripcion() {
		if (chBoxCancelacionInscripcion == null) {
			chBoxCancelacionInscripcion = new JCheckBox("Cancelaci\u00F3n de inscripciones");
			chBoxCancelacionInscripcion.setBounds(477, 432, 254, 38);
			chBoxCancelacionInscripcion.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (chBoxCancelacionInscripcion.isSelected()) {
						txtPorcentajeADevolver.setEnabled(true);
						txtFechaMaxCancelacion.setEnabled(true);
					}

					else {
						txtPorcentajeADevolver.setEnabled(false);
						txtPorcentajeADevolver.setText("0");

						txtFechaMaxCancelacion.setEnabled(false);
						txtFechaMaxCancelacion.setText("yyyy/MM/dd");
					}

				}
			});
			chBoxCancelacionInscripcion.setFont(new Font("Segoe UI Black", Font.BOLD, 14));
		}
		return chBoxCancelacionInscripcion;
	}

	private JPanel getPnTiemposCorte() {
		if (pnTiemposCorte == null) {
			pnTiemposCorte = new JPanel();
			pnTiemposCorte.setBounds(10, 446, 461, 139);
			pnTiemposCorte.setBackground(new Color(70, 130, 180));
			GroupLayout gl_pnTiemposCorte = new GroupLayout(pnTiemposCorte);
			gl_pnTiemposCorte.setHorizontalGroup(gl_pnTiemposCorte.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_pnTiemposCorte.createSequentialGroup().addGroup(gl_pnTiemposCorte
							.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_pnTiemposCorte.createSequentialGroup().addContainerGap()
									.addGroup(gl_pnTiemposCorte.createParallelGroup(Alignment.TRAILING)
											.addGroup(gl_pnTiemposCorte.createSequentialGroup()
													.addComponent(getLbPuntoDeCorte(), GroupLayout.DEFAULT_SIZE,
															GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
													.addGap(298))
											.addGroup(gl_pnTiemposCorte.createSequentialGroup()
													.addComponent(getLbKilometroPuntoCorte(), GroupLayout.DEFAULT_SIZE,
															183, Short.MAX_VALUE)
													.addGap(91).addComponent(getTxKilometroCorte(),
															GroupLayout.PREFERRED_SIZE, 146,
															GroupLayout.PREFERRED_SIZE))))
							.addGroup(Alignment.TRAILING,
									gl_pnTiemposCorte.createSequentialGroup().addGap(151).addComponent(
											getBtnAadirPuntoDe(), GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)))
							.addContainerGap()));
			gl_pnTiemposCorte
					.setVerticalGroup(gl_pnTiemposCorte.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_pnTiemposCorte.createSequentialGroup().addGap(5)
									.addComponent(getLbPuntoDeCorte(), GroupLayout.DEFAULT_SIZE,
											GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_pnTiemposCorte.createParallelGroup(Alignment.BASELINE)
											.addComponent(getLbKilometroPuntoCorte(), GroupLayout.PREFERRED_SIZE, 23,
													GroupLayout.PREFERRED_SIZE)
											.addComponent(getTxKilometroCorte(), GroupLayout.PREFERRED_SIZE, 19,
													GroupLayout.PREFERRED_SIZE))
									.addGap(18).addComponent(getBtnAadirPuntoDe(), GroupLayout.PREFERRED_SIZE, 27,
											GroupLayout.PREFERRED_SIZE)
									.addGap(13)));
			pnTiemposCorte.setLayout(gl_pnTiemposCorte);
		}
		return pnTiemposCorte;
	}

	private JLabel getLbKilometroPuntoCorte() {
		if (lbKilometroPuntoCorte == null) {
			lbKilometroPuntoCorte = new JLabel("Kilometro");
			lbKilometroPuntoCorte.setFont(new Font("Segoe UI Black", Font.BOLD, 14));
		}
		return lbKilometroPuntoCorte;
	}

	private JTextField getTxKilometroCorte() {
		if (txKilometroCorte == null) {
			txKilometroCorte = new JTextField();
			txKilometroCorte.setColumns(10);
		}
		return txKilometroCorte;
	}

	private JLabel getLbPuntoDeCorte() {
		if (lbPuntoDeCorte == null) {
			lbPuntoDeCorte = new JLabel("Punto de corte");
			lbPuntoDeCorte.setFont(new Font("Segoe UI Black", Font.BOLD, 16));
		}
		return lbPuntoDeCorte;
	}

	private JButton getBtnAadirPuntoDe() {
		if (btnAadirPuntoDe == null) {
			btnAadirPuntoDe = new JButton("A\u00F1adir punto de corte");
			btnAadirPuntoDe.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					addPuntoCorte();
				}
			});
			btnAadirPuntoDe.setFont(new Font("Segoe UI Black", Font.BOLD, 14));
		}
		return btnAadirPuntoDe;
	}

	private JLabel getLbPuntosCorte() {
		if (lbPuntosCorte == null) {
			lbPuntosCorte = new JLabel("Puntos corte");
			lbPuntosCorte.setBounds(477, 347, 254, 23);
			lbPuntosCorte.setHorizontalAlignment(SwingConstants.LEFT);
			lbPuntosCorte.setFont(new Font("Segoe UI Black", Font.BOLD, 16));
		}
		return lbPuntosCorte;
	}

	private JScrollPane getScrollPanePuntosCorte() {
		if (scrollPanePuntosCorte == null) {
			scrollPanePuntosCorte = new JScrollPane();
			scrollPanePuntosCorte.setBounds(737, 347, 249, 79);
			scrollPanePuntosCorte.setViewportView(getTxPuntosCorte());
		}
		return scrollPanePuntosCorte;
	}

	private JTextArea getTxPuntosCorte() {
		if (txPuntosCorte == null) {
			txPuntosCorte = new JTextArea();
			txPuntosCorte.setEditable(false);
		}
		return txPuntosCorte;
	}

	private JButton getBtInscribirClubPanel() {
		if (btInscribirClubPanel == null) {
			btInscribirClubPanel = new JButton("Inscribir club");
			btInscribirClubPanel.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					mostrarPanelInscribirClubParticipante();
				}
			});
			btInscribirClubPanel.setForeground(new Color(184, 220, 245));
			btInscribirClubPanel.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
			btInscribirClubPanel.setBackground(new Color(50, 130, 181));
		}
		return btInscribirClubPanel;
	}

	private JPanel getPnCardsParticipante() {
		if (pnCardsParticipante == null) {
			pnCardsParticipante = new JPanel();
			pnCardsParticipante.setLayout(new CardLayout(0, 0));
			pnCardsParticipante.add(getScrollPaneTabla(), "panelCarreras");
			pnCardsParticipante.add(getPnClub(), "panelClub");

		}
		return pnCardsParticipante;
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
		}
		return tablaCarrerasParticipante;
	}

	private JPanel getPnClub() {
		if (pnClub == null) {
			pnClub = new JPanel();
			pnClub.setBackground(new Color(8, 46, 70));
			GroupLayout gl_pnClub = new GroupLayout(pnClub);
			gl_pnClub.setHorizontalGroup(gl_pnClub.createParallelGroup(Alignment.LEADING).addGroup(gl_pnClub
					.createSequentialGroup()
					.addComponent(getPnFormularioClub(), GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(getScrollPaneParticipantesClub(), GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
					.addContainerGap()));
			gl_pnClub.setVerticalGroup(gl_pnClub.createParallelGroup(Alignment.LEADING)
					.addComponent(getPnFormularioClub(), GroupLayout.DEFAULT_SIZE, 624, Short.MAX_VALUE)
					.addComponent(getScrollPaneParticipantesClub(), GroupLayout.DEFAULT_SIZE, 624, Short.MAX_VALUE));
			pnClub.setLayout(gl_pnClub);
		}
		return pnClub;
	}

	private JPanel getPnFormularioClub() {
		if (pnFormularioClub == null) {
			pnFormularioClub = new JPanel();
			pnFormularioClub.setForeground(new Color(220, 220, 220));
			pnFormularioClub.setBorder(new LineBorder(new Color(50, 130, 181), 2));
			pnFormularioClub.setBackground(new Color(8, 46, 70));
			GroupLayout gl_pnFormularioClub = new GroupLayout(pnFormularioClub);
			gl_pnFormularioClub.setHorizontalGroup(gl_pnFormularioClub.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_pnFormularioClub.createSequentialGroup().addContainerGap()
							.addGroup(gl_pnFormularioClub.createParallelGroup(Alignment.TRAILING)
									.addGroup(gl_pnFormularioClub.createSequentialGroup()
											.addComponent(getLbNombreClub(), GroupLayout.PREFERRED_SIZE, 183,
													GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
											.addComponent(getTxNombreClub(), GroupLayout.PREFERRED_SIZE, 190,
													GroupLayout.PREFERRED_SIZE))
									.addComponent(getSeparator(), GroupLayout.PREFERRED_SIZE, 480,
											GroupLayout.PREFERRED_SIZE)
									.addComponent(getSeparator_1(), GroupLayout.PREFERRED_SIZE, 480,
											GroupLayout.PREFERRED_SIZE)
									.addGroup(gl_pnFormularioClub.createSequentialGroup()
											.addComponent(getLbEmailAtletaClub(), GroupLayout.PREFERRED_SIZE, 183,
													GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
											.addComponent(getTxEmailAtletaClub(), GroupLayout.PREFERRED_SIZE, 238,
													GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_pnFormularioClub.createSequentialGroup()
											.addComponent(getLbDniAtletaClub(), GroupLayout.PREFERRED_SIZE, 183,
													GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
											.addComponent(getTxDniAtletaClub(), GroupLayout.PREFERRED_SIZE, 238,
													GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_pnFormularioClub.createSequentialGroup()
											.addGroup(gl_pnFormularioClub.createParallelGroup(Alignment.LEADING)
													.addComponent(getLbNombreParticipante(), GroupLayout.PREFERRED_SIZE,
															183, GroupLayout.PREFERRED_SIZE)
													.addComponent(getLblFechaDeNacimiento(), GroupLayout.PREFERRED_SIZE,
															183, GroupLayout.PREFERRED_SIZE))
											.addPreferredGap(ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
											.addGroup(gl_pnFormularioClub.createParallelGroup(Alignment.LEADING, false)
													.addComponent(getTxFechaNacimientoAtletaClub())
													.addComponent(getTxNombreAtletaClub(), GroupLayout.DEFAULT_SIZE,
															238, Short.MAX_VALUE)))
									.addGroup(gl_pnFormularioClub.createSequentialGroup()
											.addComponent(getLbSexoAtletaClub(), GroupLayout.PREFERRED_SIZE, 183,
													GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
											.addComponent(getCbSexoAtletaClub(), GroupLayout.PREFERRED_SIZE, 238,
													GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_pnFormularioClub.createSequentialGroup()
											.addComponent(getBtEliminarParticipanteClub())
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(getBtAñadirParticipanteClub()))
									.addComponent(getSeparator_1_1(), GroupLayout.PREFERRED_SIZE, 480,
											GroupLayout.PREFERRED_SIZE)
									.addComponent(getBtInscribirClub(), GroupLayout.PREFERRED_SIZE, 173,
											GroupLayout.PREFERRED_SIZE)
									.addComponent(getBtCargarFicheroClub(), Alignment.LEADING,
											GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
							.addContainerGap()));
			gl_pnFormularioClub.setVerticalGroup(gl_pnFormularioClub.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_pnFormularioClub.createSequentialGroup().addContainerGap()
							.addGroup(gl_pnFormularioClub.createParallelGroup(Alignment.BASELINE)
									.addComponent(getLbNombreClub(), GroupLayout.PREFERRED_SIZE, 34,
											GroupLayout.PREFERRED_SIZE)
									.addComponent(getTxNombreClub(), GroupLayout.PREFERRED_SIZE, 34,
											GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addComponent(getSeparator(), GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(getBtCargarFicheroClub(), GroupLayout.PREFERRED_SIZE, 35,
									GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(getSeparator_1(), GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_pnFormularioClub.createParallelGroup(Alignment.LEADING)
									.addComponent(getLbEmailAtletaClub(), GroupLayout.PREFERRED_SIZE, 34,
											GroupLayout.PREFERRED_SIZE)
									.addComponent(getTxEmailAtletaClub(), GroupLayout.PREFERRED_SIZE, 34,
											GroupLayout.PREFERRED_SIZE))
							.addGap(10)
							.addGroup(gl_pnFormularioClub.createParallelGroup(Alignment.BASELINE)
									.addComponent(getLbDniAtletaClub(), GroupLayout.PREFERRED_SIZE, 34,
											GroupLayout.PREFERRED_SIZE)
									.addComponent(getTxDniAtletaClub(), GroupLayout.PREFERRED_SIZE, 34,
											GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_pnFormularioClub.createParallelGroup(Alignment.BASELINE)
									.addComponent(getLbNombreParticipante(), GroupLayout.PREFERRED_SIZE, 34,
											GroupLayout.PREFERRED_SIZE)
									.addComponent(getTxNombreAtletaClub(), GroupLayout.PREFERRED_SIZE, 34,
											GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_pnFormularioClub.createParallelGroup(Alignment.BASELINE)
									.addComponent(getLblFechaDeNacimiento(), GroupLayout.PREFERRED_SIZE, 34,
											GroupLayout.PREFERRED_SIZE)
									.addComponent(getTxFechaNacimientoAtletaClub(), GroupLayout.PREFERRED_SIZE, 34,
											GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_pnFormularioClub.createParallelGroup(Alignment.BASELINE)
									.addComponent(getLbSexoAtletaClub(), GroupLayout.PREFERRED_SIZE, 34,
											GroupLayout.PREFERRED_SIZE)
									.addComponent(getCbSexoAtletaClub(), GroupLayout.PREFERRED_SIZE, 31,
											GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_pnFormularioClub.createParallelGroup(Alignment.LEADING)
									.addComponent(getBtAñadirParticipanteClub(), GroupLayout.PREFERRED_SIZE, 35,
											GroupLayout.PREFERRED_SIZE)
									.addComponent(getBtEliminarParticipanteClub(), GroupLayout.PREFERRED_SIZE, 35,
											GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addComponent(getSeparator_1_1(), GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 144, Short.MAX_VALUE)
							.addComponent(getBtInscribirClub(), GroupLayout.PREFERRED_SIZE, 35,
									GroupLayout.PREFERRED_SIZE)
							.addContainerGap()));
			pnFormularioClub.setLayout(gl_pnFormularioClub);
		}
		return pnFormularioClub;
	}

	private JScrollPane getScrollPaneParticipantesClub() {
		if (scrollPaneParticipantesClub == null) {
			scrollPaneParticipantesClub = new JScrollPane();
			scrollPaneParticipantesClub.setBorder(new LineBorder(new Color(50, 130, 181), 2));
			scrollPaneParticipantesClub.setViewportView(getTablaParticipantesClub());
		}
		return scrollPaneParticipantesClub;
	}

	private JTable getTablaParticipantesClub() {
		if (tablaParticipantesClub == null) {
			tablaParticipantesClub = new JTable();
		}
		return tablaParticipantesClub;
	}

	private JLabel getLbDniAtletaClub() {
		if (lbDniAtletaClub == null) {
			lbDniAtletaClub = new JLabel("DNI");
			lbDniAtletaClub.setForeground(new Color(184, 220, 245));
			lbDniAtletaClub.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
		}
		return lbDniAtletaClub;
	}

	private JLabel getLbNombreParticipante() {
		if (lbNombreParticipante == null) {
			lbNombreParticipante = new JLabel("Nombre y apellidos");
			lbNombreParticipante.setForeground(new Color(184, 220, 245));
			lbNombreParticipante.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
		}
		return lbNombreParticipante;
	}

	private JLabel getLblFechaDeNacimiento() {
		if (lblFechaDeNacimiento == null) {
			lblFechaDeNacimiento = new JLabel("Fecha de nacimiento");
			lblFechaDeNacimiento.setForeground(new Color(184, 220, 245));
			lblFechaDeNacimiento.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
		}
		return lblFechaDeNacimiento;
	}

	private JLabel getLbSexoAtletaClub() {
		if (lbSexoAtletaClub == null) {
			lbSexoAtletaClub = new JLabel("Sexo");
			lbSexoAtletaClub.setForeground(new Color(184, 220, 245));
			lbSexoAtletaClub.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
		}
		return lbSexoAtletaClub;
	}

	private JComboBox<String> getCbSexoAtletaClub() {
		if (cbSexoAtletaClub == null) {
			cbSexoAtletaClub = new JComboBox<String>();
			cbSexoAtletaClub.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
		}
		return cbSexoAtletaClub;
	}

	private JTextField getTxFechaNacimientoAtletaClub() {
		if (txFechaNacimientoAtletaClub == null) {
			txFechaNacimientoAtletaClub = new JTextField();
			txFechaNacimientoAtletaClub.setText("yyyy/MM/dd");
			txFechaNacimientoAtletaClub.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
			txFechaNacimientoAtletaClub.setColumns(10);
		}
		return txFechaNacimientoAtletaClub;
	}

	private JLabel getLbNombreClub() {
		if (lbNombreClub == null) {
			lbNombreClub = new JLabel("Nombre club");
			lbNombreClub.setForeground(new Color(184, 220, 245));
			lbNombreClub.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
		}
		return lbNombreClub;
	}

	private JTextField getTxNombreClub() {
		if (txNombreClub == null) {
			txNombreClub = new JTextField();
			txNombreClub.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
			txNombreClub.setColumns(10);
		}
		return txNombreClub;
	}

	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
		}
		return separator;
	}

	private JButton getBtCargarFicheroClub() {
		if (btCargarFicheroClub == null) {
			btCargarFicheroClub = new JButton("Cargar fichero");
			btCargarFicheroClub.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					cargarFicheroClub();
				}
			});
			btCargarFicheroClub.setForeground(new Color(184, 220, 245));
			btCargarFicheroClub.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
			btCargarFicheroClub.setEnabled(true);
			btCargarFicheroClub.setBackground(new Color(50, 130, 181));
		}
		return btCargarFicheroClub;
	}

	private JSeparator getSeparator_1() {
		if (separator_1 == null) {
			separator_1 = new JSeparator();
		}
		return separator_1;
	}

	private JLabel getLbEmailAtletaClub() {
		if (lbEmailAtletaClub == null) {
			lbEmailAtletaClub = new JLabel("E-mail");
			lbEmailAtletaClub.setForeground(new Color(184, 220, 245));
			lbEmailAtletaClub.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
		}
		return lbEmailAtletaClub;
	}

	private JTextField getTxEmailAtletaClub() {
		if (txEmailAtletaClub == null) {
			txEmailAtletaClub = new JTextField();
			txEmailAtletaClub.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
			txEmailAtletaClub.setColumns(10);
		}
		return txEmailAtletaClub;
	}

	private JTextField getTxDniAtletaClub() {
		if (txDniAtletaClub == null) {
			txDniAtletaClub = new JTextField();
			txDniAtletaClub.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
			txDniAtletaClub.setColumns(10);
		}
		return txDniAtletaClub;
	}

	private JTextField getTxNombreAtletaClub() {
		if (txNombreAtletaClub == null) {
			txNombreAtletaClub = new JTextField();
			txNombreAtletaClub.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
			txNombreAtletaClub.setColumns(10);
		}
		return txNombreAtletaClub;
	}

	private JButton getBtAñadirParticipanteClub() {
		if (btAñadirParticipanteClub == null) {
			btAñadirParticipanteClub = new JButton("A\u00F1adir participante");
			btAñadirParticipanteClub.setForeground(new Color(184, 220, 245));
			btAñadirParticipanteClub.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
			btAñadirParticipanteClub.setEnabled(true);
			btAñadirParticipanteClub.setBackground(new Color(50, 130, 181));
		}
		return btAñadirParticipanteClub;
	}

	private JButton getBtEliminarParticipanteClub() {
		if (btEliminarParticipanteClub == null) {
			btEliminarParticipanteClub = new JButton("Eliminar participante");
			btEliminarParticipanteClub.setForeground(new Color(184, 220, 245));
			btEliminarParticipanteClub.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
			btEliminarParticipanteClub.setEnabled(true);
			btEliminarParticipanteClub.setBackground(new Color(50, 130, 181));
		}
		return btEliminarParticipanteClub;
	}

	private JSeparator getSeparator_1_1() {
		if (separator_1_1 == null) {
			separator_1_1 = new JSeparator();
		}
		return separator_1_1;
	}

	private JButton getBtInscribirClub() {
		if (btInscribirClub == null) {
			btInscribirClub = new JButton("Inscribir club");
			btInscribirClub.setForeground(new Color(184, 220, 245));
			btInscribirClub.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
			btInscribirClub.setEnabled(true);
			btInscribirClub.setBackground(new Color(50, 130, 181));
		}
		return btInscribirClub;
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
			} catch (BusinessDataException e) {
				JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
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

	private void mostrarPanelCarrerasParticipante() {
		CardLayout cl = (CardLayout) (pnCardsParticipante.getLayout());
		cl.show(pnCardsParticipante, "panelCarreras");
	}

	private void mostrarPanelInscribirClubParticipante() {
		CardLayout cl = (CardLayout) (pnCardsParticipante.getLayout());
		cl.show(pnCardsParticipante, "panelClub");
	}

	private void mostrarCarrerasParticipante() {
		mostrarPanelCarrerasParticipante();
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
			} catch (BusinessDataException e) {
				JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(this, "Tu email no es valido", "Error", JOptionPane.WARNING_MESSAGE);
		}

	}

	private void inscribirse() {
		if (carreraSeleccionadaParticipante()) {
			try {
				/**
				 * Si la carrera esta llena se mira si tiene una lista de espera. Si la tiene se
				 * le pregunta al atleta si quiere meterse en la lista de espera. Si quiere se
				 * mete en la lista, si no se cancela la inscripcion.
				 */
				if (GuiLogic.isCarreraLlena(getCarreraSeleccionadaParticipante())) {
					if (GuiLogic.tieneListaEspera(getCarreraSeleccionadaParticipante())) {
						int result = JOptionPane.showConfirmDialog(this,
								"La carrera esta llena pero tiene una lista de espera, ï¿½quieres inscribirte en ella?",
								"alert", JOptionPane.OK_CANCEL_OPTION);
						if (result == JOptionPane.OK_OPTION) {
							mostrarVentanaInscripcion(CON_LISTA);
						}
					} else {
						JOptionPane.showMessageDialog(this, "La carrera esta llena.");
					}
				} else {
					mostrarVentanaInscripcion(SIN_LISTA);
				}

//				if (GuiLogic.isCarreraLlena(getCarreraSeleccionadaParticipante())) {
//					int result = JOptionPane.showConfirmDialog(this,
//							"La carrera esta llena pero tiene una lista de espera, ï¿½quieres inscribirte en ella?",
//							"alert", JOptionPane.OK_CANCEL_OPTION);
//					if (result == JOptionPane.OK_OPTION) {
//						mostrarVentanaInscripcion();
//					}
//				} else {
//					mostrarVentanaInscripcion();
//				}

			} catch (BusinessDataException e) {
				JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
			}
		}
	}

	private void mostrarVentanaInscripcion(boolean tieneLista) {

		if (carreraSeleccionadaParticipante()) {
			VentanaInscribirse v = new VentanaInscribirse(getCarreraSeleccionadaParticipante(), tieneLista);
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
			if ( estaATiempo(id, email)) {
				VentanaEscogerPago pago = new VentanaEscogerPago(this, id, email);
				pago.setVisible(true);
			}
			else {
				JOptionPane.showMessageDialog(this, "Fecha tardía para el pago de la carrera: " + id);
			}
		} else {
			JOptionPane.showMessageDialog(this, "Ya se ha realizado el pago sobre la carrera: " + id);
		}
	}

	private boolean estaATiempo(String id, String email) {
		return GuiLogic.pagoATiempo(id, email);
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

	private void cargarFicheroClub() {
		// TODO
		JFileChooser fc = new JFileChooser();
		fc.setFileFilter(new FileNameExtensionFilter("Fichero Lote Atletas", "fla"));
		int returnVal = fc.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			try {
				cargaTablaParticipantes(file);
			} catch (BusinessDataException e) {
				JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
			}
		} else if (returnVal == JFileChooser.CANCEL_OPTION) {
			JOptionPane.showMessageDialog(this, "No se ha seleccionado ningun archivo", "Error",
					JOptionPane.WARNING_MESSAGE);
		}
	}

	private void cargaTablaParticipantes(File file) throws BusinessDataException {
		tablaParticipantesClub.setModel(GuiLogic.cargaParticipantesClub(file, getTablaParticipantesClub()));
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
		} catch (BusinessDataException e) {
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
		// Resetea puntosCorte
		vaciarCamposPuntoCorte();
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

	private void vaciarCamposPuntoCorte() {
		getTxKilometroCorte().setText("");

	}

	private void crearCarrera() {
		if (comprobarCamposCarrera()) {
			try {
				GuiLogic.crearCarrera(getTxNombreCarrera().getText(), getTxFechaCarrera().getText(),
						getCbTipoCarrera().getSelectedItem().toString(), getTxDistanciaCarrera().getText(),
						getTxPlazasCarrera().getText(), carreraManager.getCategorias(), carreraManager.getPeriodos(),
						carreraManager.getPuntosCorte(), getChBoxListaEspera().isSelected(),
						getChBoxCancelacionInscripcion().isSelected(), getTxtPorcentajeADevolver().getText(),
						getTxtFechaMaxCancelacion().getText());
				JOptionPane.showMessageDialog(this, "La carrera se ha creado con exito", "Exito",
						JOptionPane.INFORMATION_MESSAGE);
				vaciarCamposCrearCarrera();
			} catch (BusinessDataException e) {
				JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
			}
		}
	}

	private boolean comprobarCamposCancelacion() {
		if (getChBoxCancelacionInscripcion().isSelected()) {
			return Validadores.comprobarNoVacio(getTxtPorcentajeADevolver().getText())
					&& Validadores.comprobarNoVacio(getTxtFechaMaxCancelacion().getText())
					&& Validadores.comprobarMayorNumero(getTxtPorcentajeADevolver().getText(), 0)
					&& Validadores.comprobarMenorNumero(getTxtPorcentajeADevolver().getText(), 101)
					&& Validadores.comprobarFecha(getTxtFechaMaxCancelacion().getText())
					&& Validadores.comprobarFechaCancelacion(carreraManager, getTxtFechaMaxCancelacion().getText(),
							getTxFechaCarrera().getText());

		}
		return true;

	}

	private boolean comprobarCamposCarrera() {
		if (Validadores.comprobarNoVacio(getTxNombreCarrera().getText())
				&& Validadores.comprobarMayorNumero(getTxDistanciaCarrera().getText(), 0)
				&& Validadores.comprobarMayorNumero(getTxPlazasCarrera().getText(), 0)
				&& comprobarCamposCancelacion()) {

			if (carreraManager.comprobarDistanciaKilometro(Integer.parseInt(getTxDistanciaCarrera().getText()))) {
				if (carreraManager.comprobarFechaCarrera(getTxFechaCarrera().getText())) {
					return true;
				} else {
					JOptionPane.showMessageDialog(this,
							"La fecha de la carrera colisiona con las fechas de inscripcion", "Error",
							JOptionPane.WARNING_MESSAGE);
					return false;
				}
			} else {
				JOptionPane.showMessageDialog(this, "La distancia de la carrera excede uno de los puntos de corte",
						"Error", JOptionPane.WARNING_MESSAGE);
				return false;
			}
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
		carreraManager.cleanPuntosCorte();
	}

	private void addPlazoInscripcion() {
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
				JOptionPane.showMessageDialog(this, "El plazo de inscripciï¿½n ha sido creado", "ï¿½xito",
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

	private void addCategoria() {
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
				JOptionPane.showMessageDialog(this, "La categoria se ha creado", "Exito",
						JOptionPane.INFORMATION_MESSAGE);
			} catch (BusinessDataException e) {
				JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
				vaciarCamposCategoria();
			}
		} else {
			JOptionPane.showMessageDialog(this, "Comprueba los campos de las categorias", "Error",
					JOptionPane.WARNING_MESSAGE);
		}
	}

	public void addPuntoCorte() {
		String kilometroPunto = getTxKilometroCorte().getText();
		String kilometroMaximo = getTxDistanciaCarrera().getText();
		if (Validadores.comprobarMayorNumero(kilometroPunto, 1)) {
			if (Validadores.comprobarMayorNumero(kilometroMaximo, 1)) {
				try {
					carreraManager.addPuntoCorte(Integer.parseInt(kilometroPunto), Integer.parseInt(kilometroMaximo));
					getTxPuntosCorte().setText(getTxPuntosCorte().getText() + "Kilometro: " + kilometroPunto + "\n");
					vaciarCamposPuntoCorte();
				} catch (BusinessDataException e) {
					JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(this, "Comprueba la distancia maxima", "Error",
						JOptionPane.WARNING_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(this, "Comprueba el kilometro", "Error", JOptionPane.WARNING_MESSAGE);
		}
	}

	private void generarDorsales() {
		if (carreraSeleccionadaOrganizador()) {
			if (GuiLogic.comprobarInscripcionesFinalizadas(getCarreraSeleccionadaOrganizador())) {
				String dorsalesReservados = JOptionPane.showInputDialog(this,
						"Introduce el numero de dorsales a reservar", "Dorsales");
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

	private JTextField getTxtPorcentajeADevolver() {
		if (txtPorcentajeADevolver == null) {
			txtPorcentajeADevolver = new JTextField();
			txtPorcentajeADevolver.setBounds(906, 486, 61, 28);
			txtPorcentajeADevolver.setText("1 - 100");
			txtPorcentajeADevolver.setEnabled(false);
			txtPorcentajeADevolver.setColumns(10);
		}
		return txtPorcentajeADevolver;
	}

	private JLabel getLblFechaCancelacion() {
		if (lblFechaCancelacion == null) {
			lblFechaCancelacion = new JLabel("Fecha maxima de cancelacion:");
			lblFechaCancelacion.setBounds(481, 488, 194, 23);
			lblFechaCancelacion.setHorizontalAlignment(SwingConstants.LEFT);
			lblFechaCancelacion.setFont(new Font("Segoe UI Black", Font.BOLD, 12));
		}
		return lblFechaCancelacion;
	}

	private JLabel getLblCuota_1() {
		if (lblCuota_1 == null) {
			lblCuota_1 = new JLabel("Porcentaje a devolver:");
			lblCuota_1.setBounds(747, 488, 149, 23);
			lblCuota_1.setHorizontalAlignment(SwingConstants.LEFT);
			lblCuota_1.setFont(new Font("Segoe UI Black", Font.BOLD, 12));
		}
		return lblCuota_1;
	}

	private JTextField getTxtFechaMaxCancelacion() {
		if (txtFechaMaxCancelacion == null) {
			txtFechaMaxCancelacion = new JTextField();
			txtFechaMaxCancelacion.setBounds(676, 486, 61, 28);
			txtFechaMaxCancelacion.setText("yyyy/MM/dd");
			txtFechaMaxCancelacion.setEnabled(false);
			txtFechaMaxCancelacion.setColumns(10);
		}
		return txtFechaMaxCancelacion;
	}

	private JButton getBntCancelarInscripcion() {
		if (bntCancelarInscripcion == null) {
			bntCancelarInscripcion = new JButton("<html>Cancelar<br>Inscripcion<html/>");
			bntCancelarInscripcion.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					cancelarInscripcion();
				}
			});
			bntCancelarInscripcion.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
			bntCancelarInscripcion.setForeground(new Color(184, 220, 245));
			bntCancelarInscripcion.setBackground(new Color(50, 130, 181));
		}
		return bntCancelarInscripcion;
	}

	private void cancelarInscripcion() {
		try {
			if (carreraSeleccionadaParticipante()) {
				String id_carrera = getCarreraSeleccionadaParticipante();
				if (checkHayCancelacion(id_carrera)) {
					if (email == null) {
						cargarEmail();
					}

					if (!Check.existeInscripcion(email, id_carrera)) {
						JOptionPane.showMessageDialog(this, "No estas inscrito en esta carrera.", "Error",
								JOptionPane.WARNING_MESSAGE);
						return;
					}

					String mensaje;

					if (!Check.estaInscripcionPagada(email, id_carrera)) {
						mensaje = "Se ha cancelado su inscripcion.";
					} else {
						Double cantidadPagada = GuiLogic.obtenerCantidadPagada(email, id_carrera);
						Double porcentajeDevolver = GuiLogic.porcentajeADevolver(id_carrera);
						mensaje = String.format("Su inscripcion ha sido cancelada, se le devolveran %.2f euros.",
								cantidadPagada * (porcentajeDevolver / 100));
					}

					cancelarInscripcion(email, id_carrera);

					JOptionPane.showMessageDialog(this, mensaje);
				} else {
					JOptionPane.showMessageDialog(this, "No se puede cancelar inscripciones en esta carrera.", "Error",
							JOptionPane.WARNING_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(this, "No se ha seleccionado ninguna carrera", "Error",
						JOptionPane.WARNING_MESSAGE);
			}
		} catch (BusinessDataException e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
		}
	}

	private void cancelarInscripcion(String email, String id_carrera) throws BusinessDataException {
		GuiLogic.cancelarInscripcion(email, id_carrera);
	}

	private boolean checkHayCancelacion(String id_carrera) throws BusinessDataException {
		return GuiLogic.tieneCancelacion(id_carrera);
	}

}