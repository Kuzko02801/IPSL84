package gui.aplicacion;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import business.dataaccess.dto.carrera.Categoria;
import business.dataaccess.dto.carrera.Periodo;
import business.gui.CarreraManager;
import business.gui.GuiLogic;
import gui.validadores.Validadores;

public class VentanaApp extends JFrame {

	/**
	 * 
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaApp frame = new VentanaApp(ADMIN);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private static final long serialVersionUID = 1L;
	private JPanel pnPrincipal;
	private JPanel pnParticipante;
	private JPanel pnBotonesParticipante;
	private JPanel pnBotonesOrdenarParticipante;
	private JScrollPane scrollPaneTabla;
	private JTable tablaCarrerasParticipante;
	private JButton btOrdenar;
	private JComboBox<String> cbCarreras;
	private JMenuBar menuBar;
	private JMenu mnCuenta;
	private JMenu mnOrganizador;
	private JMenu mnParticipante;
	private JPanel pnBotonesInscribirseParticipante;
	private JButton btInscribirseParticipante;
	private JLabel lbIDCarreraParticipante;
	private JMenuItem mnItCuentaSalir;
	private JPanel pnOrganizador;
	private JPanel pnBotonesOrganizador;
	private JPanel pnBotonesOrdenarParticipante_1;
	private JButton btMostrarClasificaciones;
	private JComboBox<String> cbClasificaciones;
	private JPanel pnBotonesInscribirseParticipante_1;
	private JButton btMostrarParticipantes;
	private JLabel lbIDCarreraParticipante_1;
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
	private JTextField txIdCarreraValidaOrganizador;
	private JMenuItem mnItCuentaOrganizador;
	private JMenuItem mnItCuentaParticipante;
	private JButton btMostrarCarreras;
	private JPanel pnCrearCarrera;
	private JLabel lbPlazasCarrera;
	private JLabel lbTipoCarrera;
	private JLabel lbDistanciaCarrera;
	private JLabel lbNombreCarrera;
	private JLabel lbCrearCarrera;
	private JTextField txNombreCarrera;
	private JTextField txDistanciaCarrera;
	private JTextField txPlazasCarrera;
	private JComboBox<String> cbTipoCarrera;
	private JButton btCrearCarrera;
	private JButton btCrearCarreraOrganizador;
	private JTextField txIdCarreraValidaParticipante;

	public final static int ADMIN = 0;
	public final static int PARTICIPANTE = 1;
	private JLabel lbFechaCarrera;
	private JTextField txFechaCarrera;
	
	private CarreraManager carreraManager;
	
	private JLabel lblPeriodoInscripcion;
	private JLabel lblInicio;
	private JLabel lblFin;
	private JLabel lblCuota;
	private JTextField txtInicio;
	private JTextField txtFin;
	private JTextField txtCuota;
	private JButton btnAñadirPeriodo;

	/**
	 * Create the frame.
	 */
	public VentanaApp(int mode) {
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
		switch (mode) {
		case ADMIN:
			mostrarPanelOrganizador();
			getMnItCuentaParticipante().setEnabled(false);
			break;
		case PARTICIPANTE:
			mostrarPanelParticipante();
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
					.addGroup(gl_pnParticipante.createSequentialGroup().addContainerGap()
							.addGroup(gl_pnParticipante.createParallelGroup(Alignment.TRAILING)
									.addComponent(getScrollPaneTabla(), Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
											746, Short.MAX_VALUE)
									.addComponent(getPnBotonesParticipante(), Alignment.LEADING,
											GroupLayout.DEFAULT_SIZE, 746, Short.MAX_VALUE))
							.addContainerGap()));
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
			gl_pnBotonesParticipante.setHorizontalGroup(gl_pnBotonesParticipante.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_pnBotonesParticipante.createSequentialGroup()
							.addComponent(getPnBotonesOrdenarParticipante(), GroupLayout.DEFAULT_SIZE, 746,
									Short.MAX_VALUE)
							.addContainerGap())
					.addComponent(getPnBotonesInscribirseParticipante(), GroupLayout.DEFAULT_SIZE, 746,
							Short.MAX_VALUE));
			gl_pnBotonesParticipante
					.setVerticalGroup(
							gl_pnBotonesParticipante.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_pnBotonesParticipante.createSequentialGroup()
											.addComponent(getPnBotonesInscribirseParticipante(),
													GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(getPnBotonesOrdenarParticipante(), GroupLayout.PREFERRED_SIZE,
													37, GroupLayout.PREFERRED_SIZE)
											.addContainerGap(44, Short.MAX_VALUE)));
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
							.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(getCbCarreras(),
									GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(428)));
			gl_pnBotonesOrdenarParticipante
					.setVerticalGroup(gl_pnBotonesOrdenarParticipante.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_pnBotonesOrdenarParticipante.createParallelGroup(Alignment.BASELINE)
									.addComponent(getBtOrdenar(), GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
									.addComponent(getCbCarreras(), GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)));
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
			tablaCarrerasParticipante.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
				public void valueChanged(ListSelectionEvent event) {
					getBtInscribirseParticipante().setEnabled(true);
				}
			});
			tablaCarrerasParticipante.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
		        public void valueChanged(ListSelectionEvent event) {
		        	//TODO
		        	comprobarIdCarreraValidaParticipante(tablaCarrerasParticipante.getValueAt(
		        			tablaCarrerasParticipante.getSelectedRow(), 0).toString());
		        }
		    });
		}
		return tablaCarrerasParticipante;
	}

	private JButton getBtOrdenar() {
		if (btOrdenar == null) {
			btOrdenar = new JButton("Mostrar");
			btOrdenar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GuiLogic.mostrarCarrerasParticipante(getCbClasificaciones().getSelectedIndex(),
							tablaCarrerasParticipante);
				}
			});
			btOrdenar.setForeground(new Color(184, 220, 245));
			btOrdenar.setBackground(new Color(50, 130, 181));
		}
		return btOrdenar;
	}

	private JComboBox<String> getCbCarreras() {
		if (cbCarreras == null) {
			cbCarreras = new JComboBox<String>();
			cbCarreras.setForeground(new Color(184, 220, 245));
			cbCarreras.setBackground(new Color(50, 130, 181));
			cbCarreras
					.setModel(new DefaultComboBoxModel<String>(new String[] { "Todas las carreras", "Mis carreras" }));
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
			mnParticipante.setEnabled(false);
		}
		return mnParticipante;
	}

	private JPanel getPnBotonesInscribirseParticipante() {
		if (pnBotonesInscribirseParticipante == null) {
			pnBotonesInscribirseParticipante = new JPanel();
			pnBotonesInscribirseParticipante.setBackground(new Color(8, 46, 70));
			
			JButton btnPagar = new JButton("Pagar");
			btnPagar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					pagar();
				}
			});
			GroupLayout gl_pnBotonesInscribirseParticipante = new GroupLayout(pnBotonesInscribirseParticipante);
			gl_pnBotonesInscribirseParticipante.setHorizontalGroup(
				gl_pnBotonesInscribirseParticipante.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_pnBotonesInscribirseParticipante.createSequentialGroup()
						.addComponent(getBtInscribirseParticipante(), GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_pnBotonesInscribirseParticipante.createParallelGroup(Alignment.LEADING)
							.addComponent(getLbIDCarreraParticipante())
							.addGroup(gl_pnBotonesInscribirseParticipante.createSequentialGroup()
								.addComponent(btnPagar, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(getTxIdCarreraValidaParticipante(), GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)))
						.addGap(256))
			);
			gl_pnBotonesInscribirseParticipante.setVerticalGroup(
				gl_pnBotonesInscribirseParticipante.createParallelGroup(Alignment.TRAILING)
					.addGroup(gl_pnBotonesInscribirseParticipante.createSequentialGroup()
						.addComponent(getLbIDCarreraParticipante())
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_pnBotonesInscribirseParticipante.createParallelGroup(Alignment.BASELINE)
							.addComponent(getBtInscribirseParticipante(), GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
							.addComponent(btnPagar)))
					.addGroup(gl_pnBotonesInscribirseParticipante.createSequentialGroup()
						.addContainerGap(24, Short.MAX_VALUE)
						.addComponent(getTxIdCarreraValidaParticipante(), GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
			);
			pnBotonesInscribirseParticipante.setLayout(gl_pnBotonesInscribirseParticipante);
		}
		return pnBotonesInscribirseParticipante;
	}

	private JButton getBtInscribirseParticipante() {
		if (btInscribirseParticipante == null) {
			btInscribirseParticipante = new JButton("Inscribirse");
			btInscribirseParticipante.setEnabled(false);
			btInscribirseParticipante.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					inscribirsePagar();
				}
			});
			btInscribirseParticipante.setForeground(new Color(184, 220, 245));
			btInscribirseParticipante.setBackground(new Color(50, 130, 181));
		}
		return btInscribirseParticipante;
	}

	private JLabel getLbIDCarreraParticipante() {
		if (lbIDCarreraParticipante == null) {
			lbIDCarreraParticipante = new JLabel("ID CARRERA");
			lbIDCarreraParticipante.setForeground(new Color(184, 220, 245));
			lbIDCarreraParticipante.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		}
		return lbIDCarreraParticipante;
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
									.addComponent(getPnBotonesInscribirseParticipante_1(), Alignment.TRAILING,
											GroupLayout.PREFERRED_SIZE, 760, Short.MAX_VALUE)
									.addComponent(getPnBotonesOrdenarParticipante_1(), GroupLayout.PREFERRED_SIZE, 760,
											Short.MAX_VALUE))
							.addContainerGap()));
			gl_pnBotonesOrganizador
					.setVerticalGroup(gl_pnBotonesOrganizador.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_pnBotonesOrganizador.createSequentialGroup()
									.addComponent(getPnBotonesInscribirseParticipante_1(), GroupLayout.PREFERRED_SIZE,
											59, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(getPnBotonesOrdenarParticipante_1(), GroupLayout.PREFERRED_SIZE, 37,
											GroupLayout.PREFERRED_SIZE)
									.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
			pnBotonesOrganizador.setLayout(gl_pnBotonesOrganizador);
		}
		return pnBotonesOrganizador;
	}

	private JPanel getPnBotonesOrdenarParticipante_1() {
		if (pnBotonesOrdenarParticipante_1 == null) {
			pnBotonesOrdenarParticipante_1 = new JPanel();
			pnBotonesOrdenarParticipante_1.setBackground(new Color(8, 46, 70));
			GroupLayout gl_pnBotonesOrdenarParticipante_1 = new GroupLayout(pnBotonesOrdenarParticipante_1);
			gl_pnBotonesOrdenarParticipante_1
					.setHorizontalGroup(
							gl_pnBotonesOrdenarParticipante_1.createParallelGroup(Alignment.LEADING)
									.addGroup(
											gl_pnBotonesOrdenarParticipante_1.createSequentialGroup()
													.addComponent(getBtMostrarClasificaciones(),
															GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.UNRELATED)
													.addComponent(getCbClasificaciones(), GroupLayout.PREFERRED_SIZE,
															GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.UNRELATED)
													.addComponent(getBtCrearCarreraOrganizador(),
															GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
													.addGap(376)));
			gl_pnBotonesOrdenarParticipante_1.setVerticalGroup(gl_pnBotonesOrdenarParticipante_1
					.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_pnBotonesOrdenarParticipante_1.createParallelGroup(Alignment.BASELINE)
							.addComponent(getBtMostrarClasificaciones(), GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
							.addComponent(getCbClasificaciones(), GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
					.addComponent(getBtCrearCarreraOrganizador(), GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE));
			pnBotonesOrdenarParticipante_1.setLayout(gl_pnBotonesOrdenarParticipante_1);
		}
		return pnBotonesOrdenarParticipante_1;
	}

	private JButton getBtMostrarClasificaciones() {
		if (btMostrarClasificaciones == null) {
			btMostrarClasificaciones = new JButton("Mostrar clasificaciones");
			btMostrarClasificaciones.setEnabled(false);
			btMostrarClasificaciones.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarClasificaciones(tablaCarrerasOrganizador.getValueAt(tablaCarrerasOrganizador.getSelectedRow(), 0).toString());
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
			cbClasificaciones.setModel(new DefaultComboBoxModel<String>(new String[] { "Absolutas", "Por sexo" }));
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
						.addComponent(getBtMostrarCarreras(), GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(getBtMostrarParticipantes(), GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_pnBotonesInscribirseParticipante_1.createParallelGroup(Alignment.LEADING)
							.addComponent(getLbIDCarreraParticipante_1())
							.addGroup(gl_pnBotonesInscribirseParticipante_1.createSequentialGroup()
								.addGap(120)
								.addComponent(getTxIdCarreraValidaOrganizador(), GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)))
						.addGap(437))
			);
			gl_pnBotonesInscribirseParticipante_1.setVerticalGroup(
				gl_pnBotonesInscribirseParticipante_1.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_pnBotonesInscribirseParticipante_1.createSequentialGroup()
						.addComponent(getLbIDCarreraParticipante_1())
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_pnBotonesInscribirseParticipante_1.createParallelGroup(Alignment.BASELINE)
							.addComponent(getBtMostrarCarreras(), GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
							.addComponent(getBtMostrarParticipantes(), GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
							.addComponent(getTxIdCarreraValidaOrganizador(), GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)))
			);
			pnBotonesInscribirseParticipante_1.setLayout(gl_pnBotonesInscribirseParticipante_1);
		}
		return pnBotonesInscribirseParticipante_1;
	}

	private JButton getBtMostrarParticipantes() {
		if (btMostrarParticipantes == null) {
			btMostrarParticipantes = new JButton("Mostrar participantes");
			btMostrarParticipantes.setEnabled(false);
			btMostrarParticipantes.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarPanelOrganizadorParticipantes(tablaCarrerasOrganizador.getValueAt(tablaCarrerasOrganizador.getSelectedRow(), 0).toString());
				}
			});
			btMostrarParticipantes.setForeground(new Color(184, 220, 245));
			btMostrarParticipantes.setBackground(new Color(50, 130, 181));
		}
		return btMostrarParticipantes;
	}

	private JLabel getLbIDCarreraParticipante_1() {
		if (lbIDCarreraParticipante_1 == null) {
			lbIDCarreraParticipante_1 = new JLabel("ID CARRERA");
			lbIDCarreraParticipante_1.setForeground(new Color(184, 220, 245));
			lbIDCarreraParticipante_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		}
		return lbIDCarreraParticipante_1;
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
			tablaCarrerasOrganizador.setModel(new DefaultTableModel(new Object[][] {},
					new String[] { "ID carrera", "N\u00FAmero de inscritos", "Nombre carrera", "Fecha carrera",
							"Tipo carrera", "Distancia (km)", "Cuota Inscripci\u00F3n", "Fin inscripci\u00F3n",
							"Plazas" }));
			tablaCarrerasOrganizador.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
		        public void valueChanged(ListSelectionEvent event) {
		        	//TODO
		        	comprobarIdCarreraValidaOrganizador(tablaCarrerasOrganizador.getValueAt(tablaCarrerasOrganizador.getSelectedRow(), 0).toString());
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

	private JTextField getTxIdCarreraValidaOrganizador() {
		if (txIdCarreraValidaOrganizador == null) {
			txIdCarreraValidaOrganizador = new JTextField();
			txIdCarreraValidaOrganizador.setEditable(false);
			txIdCarreraValidaOrganizador.setColumns(10);
		}
		return txIdCarreraValidaOrganizador;
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
			gl_pnCrearCarrera.setHorizontalGroup(
				gl_pnCrearCarrera.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_pnCrearCarrera.createSequentialGroup()
						.addContainerGap(520, Short.MAX_VALUE)
						.addComponent(getBtCrearCarrera(), GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE)
						.addGap(39))
					.addGroup(gl_pnCrearCarrera.createSequentialGroup()
						.addGap(28)
						.addGroup(gl_pnCrearCarrera.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_pnCrearCarrera.createParallelGroup(Alignment.LEADING, false)
								.addComponent(getLbTipoCarrera(), GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(getLbPlazasCarrera(), GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(getLbDistanciaCarrera(), GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
								.addComponent(getLbFechaCarrera(), Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE))
							.addComponent(getLbNombreCarrera(), GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_pnCrearCarrera.createParallelGroup(Alignment.LEADING)
							.addComponent(getTxFechaCarrera(), GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
							.addComponent(getCbTipoCarrera(), 0, 185, Short.MAX_VALUE)
							.addComponent(getLbCrearCarrera(), GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
							.addComponent(getTxPlazasCarrera(), GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
							.addComponent(getTxDistanciaCarrera(), GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
							.addComponent(getTxNombreCarrera(), GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE))
						.addGap(66)
						.addGroup(gl_pnCrearCarrera.createParallelGroup(Alignment.LEADING)
							.addComponent(getLblPeriodoInscripcion())
							.addGroup(gl_pnCrearCarrera.createSequentialGroup()
								.addComponent(getLblInicio(), GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(getTxtInicio(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_pnCrearCarrera.createSequentialGroup()
								.addComponent(getLblFin(), GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(getTxtFin(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_pnCrearCarrera.createSequentialGroup()
								.addComponent(getLblCuota(), GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addGroup(gl_pnCrearCarrera.createParallelGroup(Alignment.LEADING, false)
									.addComponent(getBtnAñadirPeriodo(), GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(getTxtCuota()))))
						.addGap(138))
			);
			gl_pnCrearCarrera.setVerticalGroup(
				gl_pnCrearCarrera.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_pnCrearCarrera.createSequentialGroup()
						.addContainerGap()
						.addComponent(getLbCrearCarrera(), GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addGroup(gl_pnCrearCarrera.createParallelGroup(Alignment.TRAILING)
							.addComponent(getLbNombreCarrera(), GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
							.addGroup(gl_pnCrearCarrera.createParallelGroup(Alignment.BASELINE)
								.addComponent(getTxNombreCarrera(), GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
								.addComponent(getLblPeriodoInscripcion())))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_pnCrearCarrera.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_pnCrearCarrera.createSequentialGroup()
								.addGroup(gl_pnCrearCarrera.createParallelGroup(Alignment.LEADING)
									.addComponent(getTxDistanciaCarrera(), GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
									.addComponent(getLbDistanciaCarrera(), GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_pnCrearCarrera.createParallelGroup(Alignment.LEADING)
									.addComponent(getCbTipoCarrera(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(getLbTipoCarrera(), GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_pnCrearCarrera.createParallelGroup(Alignment.TRAILING)
									.addComponent(getLbPlazasCarrera(), Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
									.addComponent(getTxPlazasCarrera(), Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)))
							.addGroup(gl_pnCrearCarrera.createSequentialGroup()
								.addGroup(gl_pnCrearCarrera.createParallelGroup(Alignment.BASELINE)
									.addComponent(getLblInicio(), GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
									.addComponent(getTxtInicio(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_pnCrearCarrera.createParallelGroup(Alignment.BASELINE)
									.addComponent(getLblFin(), GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
									.addComponent(getTxtFin(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_pnCrearCarrera.createParallelGroup(Alignment.BASELINE)
									.addComponent(getLblCuota(), GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
									.addComponent(getTxtCuota(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(getBtnAñadirPeriodo())
								.addGap(1)))
						.addGroup(gl_pnCrearCarrera.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_pnCrearCarrera.createSequentialGroup()
								.addGap(150)
								.addComponent(getBtCrearCarrera()))
							.addGroup(gl_pnCrearCarrera.createSequentialGroup()
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(gl_pnCrearCarrera.createParallelGroup(Alignment.BASELINE)
									.addComponent(getLbFechaCarrera(), GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
									.addComponent(getTxFechaCarrera(), GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))))
						.addContainerGap())
			);
			pnCrearCarrera.setLayout(gl_pnCrearCarrera);
		}
		return pnCrearCarrera;
	}

	private JLabel getLbPlazasCarrera() {
		if (lbPlazasCarrera == null) {
			lbPlazasCarrera = new JLabel("Plazas carrera");
			lbPlazasCarrera.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		}
		return lbPlazasCarrera;
	}

	private JLabel getLbTipoCarrera() {
		if (lbTipoCarrera == null) {
			lbTipoCarrera = new JLabel("Tipo carrera");
			lbTipoCarrera.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		}
		return lbTipoCarrera;
	}

	private JLabel getLbDistanciaCarrera() {
		if (lbDistanciaCarrera == null) {
			lbDistanciaCarrera = new JLabel("Distancia carrera (km)");
			lbDistanciaCarrera.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		}
		return lbDistanciaCarrera;
	}

	private JLabel getLbNombreCarrera() {
		if (lbNombreCarrera == null) {
			lbNombreCarrera = new JLabel("Nombre carrera");
			lbNombreCarrera.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		}
		return lbNombreCarrera;
	}

	private JLabel getLbCrearCarrera() {
		if (lbCrearCarrera == null) {
			lbCrearCarrera = new JLabel("Crear carrera");
			lbCrearCarrera.setHorizontalAlignment(SwingConstants.CENTER);
			lbCrearCarrera.setFont(new Font("Tahoma", Font.PLAIN, 20));
		}
		return lbCrearCarrera;
	}

	private JTextField getTxNombreCarrera() {
		if (txNombreCarrera == null) {
			txNombreCarrera = new JTextField();
			txNombreCarrera.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					comprobarCamposCarrera();
				}
			});
			txNombreCarrera.setFont(new Font("Tahoma", Font.PLAIN, 12));
			txNombreCarrera.setColumns(10);
		}
		return txNombreCarrera;
	}

	private JTextField getTxDistanciaCarrera() {
		if (txDistanciaCarrera == null) {
			txDistanciaCarrera = new JTextField();
			txDistanciaCarrera.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					comprobarCamposCarrera();
				}
			});
			txDistanciaCarrera.setColumns(10);
		}
		return txDistanciaCarrera;
	}

	private JTextField getTxPlazasCarrera() {
		if (txPlazasCarrera == null) {
			txPlazasCarrera = new JTextField();
			txPlazasCarrera.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					comprobarCamposCarrera();
				}
			});
			txPlazasCarrera.setColumns(10);
		}
		return txPlazasCarrera;
	}

	private JComboBox<String> getCbTipoCarrera() {
		if (cbTipoCarrera == null) {
			cbTipoCarrera = new JComboBox<String>();
			cbTipoCarrera.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
			cbTipoCarrera.setModel(new DefaultComboBoxModel<String>(new String[] { "Asfalto", "Monta\u00F1a" }));
		}
		return cbTipoCarrera;
	}

	private JButton getBtCrearCarrera() {
		if (btCrearCarrera == null) {
			btCrearCarrera = new JButton("Crear carrera");
			btCrearCarrera.setEnabled(false);
			btCrearCarrera.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					crearCarrera();
				}
			});
			btCrearCarrera.setBackground(new Color(8, 46, 70));
			btCrearCarrera.setForeground(new Color(184, 220, 245));
			btCrearCarrera.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		}
		return btCrearCarrera;
	}

	private JButton getBtCrearCarreraOrganizador() {
		if (btCrearCarreraOrganizador == null) {
			btCrearCarreraOrganizador = new JButton("Crear carrera");
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

	private JTextField getTxIdCarreraValidaParticipante() {
		if (txIdCarreraValidaParticipante == null) {
			txIdCarreraValidaParticipante = new JTextField();
			txIdCarreraValidaParticipante.setText("No es v\u00E1lida");
			txIdCarreraValidaParticipante.setEditable(false);
			txIdCarreraValidaParticipante.setColumns(10);
		}
		return txIdCarreraValidaParticipante;
	}

	private JLabel getLbFechaCarrera() {
		if (lbFechaCarrera == null) {
			lbFechaCarrera = new JLabel("Fecha carrera");
			lbFechaCarrera.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		}
		return lbFechaCarrera;
	}

	private JTextField getTxFechaCarrera() {
		if (txFechaCarrera == null) {
			txFechaCarrera = new JTextField();
			txFechaCarrera.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					comprobarCamposCarrera();
				}
			});
			txFechaCarrera.setColumns(10);
		}
		return txFechaCarrera;
	}

	// METODOS

	private void mostrarPanelParticipante() {
		GuiLogic.cargarTodasCarrerasParticipante(tablaCarrerasParticipante);
		CardLayout cl = (CardLayout) (pnPrincipal.getLayout());
		cl.show(pnPrincipal, "pnParticipante");
	}

	private void mostrarPanelOrganizador() {
		// cargarCarrerasOrganizador();
		CardLayout cl = (CardLayout) (pnPrincipal.getLayout());
		cl.show(pnPrincipal, "pnOrganizador");
	}

	private void mostrarPanelOrganizadorCarreras() {
		GuiLogic.cargarCarrerasOrganizador(tablaCarrerasOrganizador);
		CardLayout cl = (CardLayout) (pnTablasOrganizador.getLayout());
		cl.show(pnTablasOrganizador, "pnCarrerasOrganizador");
	}

	private void mostrarPanelOrganizadorParticipantes(String id) {
		GuiLogic.cargarInscritosCarrera(id, tablaParticipantes);
		CardLayout cl = (CardLayout) (pnTablasOrganizador.getLayout());
		cl.show(pnTablasOrganizador, "pnParticipantesOrganizador");
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

	private void mostrarClasificaciones(String idCarrera) {
		switch (cbClasificaciones.getSelectedIndex()) {
		case 0:
			mostrarPanelOrganizadorClasificacionesAbsolutas(idCarrera);
			break;
		case 1:
			mostrarPanelOrganizadorClasificacionesSexo(idCarrera);
			break;
		}

	}

	public void comprobarIdCarreraValidaParticipante(String id) {
		if (GuiLogic.comprobarIdValidaCarrera(id)) {
			getTxIdCarreraValidaParticipante().setText("ID válida");
			getBtInscribirseParticipante().setEnabled(true);
		} else {
			getTxIdCarreraValidaParticipante().setText("ID no válida");
			getBtInscribirseParticipante().setEnabled(false);
		}
	}

	public void comprobarIdCarreraValidaOrganizador(String id) {
		
		if (GuiLogic.comprobarIdValidaCarrera(id)) {
			getTxIdCarreraValidaOrganizador().setText("ID válida");
			getBtMostrarClasificaciones().setEnabled(true);
			getBtMostrarParticipantes().setEnabled(true);
		} else {
			getTxIdCarreraValidaOrganizador().setText("ID no válida");
			getBtMostrarClasificaciones().setEnabled(false);
			getBtMostrarParticipantes().setEnabled(false);
		}
	}

	private void comprobarCamposCarrera() {
		if (Validadores.comprobarNoVacio(getTxNombreCarrera().getText())
				&& Validadores.comprobarMayor0(getTxCuotaCarrera().getText())
				&& Validadores.comprobarMayor0(getTxDistanciaCarrera().getText())
				&& Validadores.comprobarMayor0(getTxPlazasCarrera().getText())
				&& Validadores.comprobarFecha(getTxFechaApertura().getText())
				&& Validadores.comprobarFecha(getTxFechaCarrera().getText())
				&& Validadores.comprobarFecha(getTxFechaCierre().getText()) && Validadores.comprobarFechasValidas(
				getTxFechaCarrera().getText(), getTxFechaApertura().getText(), getTxFechaCierre().getText())) {
			getBtCrearCarrera().setEnabled(true);
		} else {
			getBtCrearCarrera().setEnabled(false);
		}

	}

	private void vaciarCamposCrearCarrera() {
		getTxNombreCarrera().setText("");
		getTxFechaCarrera().setText("");
		getCbTipoCarrera().setSelectedIndex(0);
		getTxDistanciaCarrera().setText("");
		getTxCuotaCarrera().setText("");
		getTxPlazasCarrera().setText("");
		getTxFechaCierre().setText("");
		getTxFechaApertura().setText("");
	}

	private void crearCarrera() {
		GuiLogic.crearCarrera(getTxNombreCarrera().getText(), getTxFechaCarrera().getText(),
				getCbTipoCarrera().getSelectedItem().toString(), getTxDistanciaCarrera().getText(),
				getTxCuotaCarrera().getText(), getTxPlazasCarrera().getText(), getTxFechaCierre().getText(),
				getTxFechaApertura().getText());
		vaciarCamposCrearCarrera();
		mostrarPanelOrganizadorCarreras();
	}

	private void inscribirsePagar() {
		VentanaInscribirse v = new VentanaInscribirse(tablaCarrerasParticipante.getValueAt(tablaCarrerasOrganizador.getSelectedRow(), 0).toString());
		v.setVisible(true);
	}
	
	private void pagar() {
		VentanaPedirEmailPago vpep = new VentanaPedirEmailPago(tablaCarrerasParticipante.getValueAt(tablaCarrerasOrganizador.getSelectedRow(), 0).toString());
		vpep.setVisible(true);
	}
	private JLabel getLblPeriodoInscripcion() {
		if (lblPeriodoInscripcion == null) {
			lblPeriodoInscripcion = new JLabel("Periodo de inscripci\u00F3n:");
			lblPeriodoInscripcion.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		}
		return lblPeriodoInscripcion;
	}
	private JLabel getLblInicio() {
		if (lblInicio == null) {
			lblInicio = new JLabel("Fecha de inicio:");
			lblInicio.setHorizontalAlignment(SwingConstants.RIGHT);
			lblInicio.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		}
		return lblInicio;
	}
	private JLabel getLblFin() {
		if (lblFin == null) {
			lblFin = new JLabel("Fecha de finalizaci\u00F3n:");
			lblFin.setHorizontalAlignment(SwingConstants.RIGHT);
			lblFin.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		}
		return lblFin;
	}
	private JLabel getLblCuota() {
		if (lblCuota == null) {
			lblCuota = new JLabel("Cuota:");
			lblCuota.setHorizontalAlignment(SwingConstants.RIGHT);
			lblCuota.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		}
		return lblCuota;
	}
	private JTextField getTxtInicio() {
		if (txtInicio == null) {
			txtInicio = new JTextField();
			txtInicio.setColumns(10);
		}
		return txtInicio;
	}
	private JTextField getTxtFin() {
		if (txtFin == null) {
			txtFin = new JTextField();
			txtFin.setColumns(10);
		}
		return txtFin;
	}
	private JTextField getTxtCuota() {
		if (txtCuota == null) {
			txtCuota = new JTextField();
			txtCuota.setColumns(10);
		}
		return txtCuota;
	}
	private JButton getBtnAñadirPeriodo() {
		if (btnAñadirPeriodo == null) {
			btnAñadirPeriodo = new JButton("A\u00F1adir");
			btnAñadirPeriodo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(txtInicio.getText().isBlank() || txtInicio.getText().isEmpty()) {
						txtInicio.grabFocus();						
					}
					if(txtFin.getText().isBlank() || txtInicio.getText().isEmpty()) {
						txtInicio.grabFocus();						
					}
					if(txtInicio.getText().isBlank() || txtInicio.getText().isEmpty()) {
						txtInicio.grabFocus();						
					}
						
				}
			});
			btnAñadirPeriodo.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		}
		return btnAñadirPeriodo;
	}
}
