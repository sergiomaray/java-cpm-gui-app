package uo.cpm.modulo.ui;

import java.awt.*;
import java.util.List;
import java.util.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import uo.cpm.modulo.service.AgenciaService;
import uo.cpm.modulo.model.*;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

import com.toedter.calendar.JCalendar;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.net.URL;
import javax.help.HelpBroker;
import javax.help.HelpSet;
import java.text.DateFormat;

public class VentanaPrincipal extends JFrame {
	
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private AgenciaService as;
	private ResourceBundle textos;
	private JMenuBar barraMenu;
	private JMenu mnReiniciar;
	private JMenu mnOfertas;
	private JMenu mnAyuda;
	private JMenuItem mntmReiniciarReserva;
	private JMenuItem mntmOfertas;
	private JMenuItem mntmContenidos;
	private JSeparator separator;
	private JMenuItem mntmAcercaDe;
	private JPanel panelPrincipal;
	private JPanel panelNorte;
	private JButton btnParques;
	private JButton btnAlojamientos;
	private JPanel panelIdiomas;
	private JRadioButton rdbtnEspanol;
	private JRadioButton rdbtnIngles;
	private JLabel lblIconoPrincipal;
	private JTextArea textAreaDescripcion;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private IdiomaListener idiomaListener = new IdiomaListener();
	private JPanel panelParques;
	private JPanel panelFiltros;
	private JLabel lblTitulo;
	private JComboBox<String> comboBoxPais;
	private JComboBox<String> comboBoxLocalidad;
	private JSlider sliderPrecioMax;
	private JScrollPane scrollParques;
	private JPanel panelIntroParques;
	private JPanel panelIntermedioParques;
	private JLabel lblTenemosParques;
	private JComboBox<Parque> comboBoxInterParques;
	private JTextArea textAreaInfoParques;
	private JButton btnMasInfoParques;
	private JLabel lblPais;
	private JLabel lblLocalidad;
	private JLabel lblPrecioMaximo;
	private JTextField textFieldPrecioMax;
	private JCheckBox chckbxOferta;
	private JCheckBox chckbxTodos;
	private JPanel panelIntermedioAlojamientos;
	private JLabel lblTenemosAlojamientos;
	private JComboBox<Alojamiento> comboBoxInterAlojamientos;
	private JButton btnMasInfoAlojamientos;
	private JTextArea textAreaDescAlojamiento;
	private JPanel panelAlojamientos;
	private JScrollPane scrollPaneAlojamientos;
	private JPanel panelIntroAlojamientos;
	private JPanel panelFiltroAlojamientos;
	private JLabel lblTituloFiltrosAlojamientos;
	private JLabel lblFiltroTipo;
	private JComboBox<String> comboBoxFiltroTipo;
	private JLabel lblFiltroEstrellas;
	private JSpinner spinnerFiltroEstrellas;
	private JLabel lblPrecioMaxAloj;
	private JSlider sliderPrecioMaxAlojamientos;
	private JTextField textFieldSliderAlojamientos;
	private JPanel panelFiltrarPais;
	private JPanel panelFiltrarLocalidad;
	private JPanel panelPrecioMaxParques;
	private JPanel panelChecksParques;
	private JPanel panelParqueSeleccionado;
	private JTextArea textAreaDescParqueSeleccionado;
	private JLabel lblFotoParqueSeleccionado;
	private JButton btnReservarParqueSeleccionado;
	private JPanel panelAlojamientoSeleccionado;
	private JTextArea textAreaDescAlojamientoSeleccionado;
	private JLabel lblFotoAlojamientoSeleccionado;
	private JButton btnReservarAlojamientoSeleccionado;
	private JPanel panelReservarAlojamientoOParque;
	private JButton btnReservarAlojamiento;
	private JButton btnReservarParque;
	private JButton btnFormalizarReserva;
	private JPanel panelReservaParques;
	private JPanel panelReservaAlojamientos;
	private JLabel lblParqueAReservar;
	private JLabel lblEntradasAdultos;
	private JLabel lblEntradasNinos;
	private JSpinner spinnerNumeroEntradasAdulto;
	private JSpinner spinnerNumeroEntradasNino;
	private JLabel lblNumeroDiasParque;
	private JSpinner spinnerNumeroDiasParque;
	private JLabel lblPrecioParque;
	private JTextField textFieldPrecioParqueSeleccionado;
	private JLabel lblFechaEntrada;
	private JTextField textFieldFechaReservada;
	private JCalendar calendarFechaEntrada;
	private JButton btnReservarParqueSeleccionadoTotal;
	private JLabel lblAlojamientoAReservar;
	private JLabel lblPersonasAlojamiento;
	private JSpinner spinnerNumeroPersonasAlojamiento;
	private JLabel lblNumeroNoches;
	private JSpinner spinnerNumeroNochesAlojamiento;
	private JLabel lblPrecioAlojamiento;
	private JTextField textFieldPrecioAlojamientoSeleccionado;
	private JLabel lblFechaEntradaAlojamiento;
	private JTextField textFieldFechaReservadaAlojamiento;
	private com.toedter.calendar.JCalendar calendarFechaEntradaAlojamiento;
	private JButton btnReservarAlojamientoSeleccionadoTotal;
	private JPanel panelConfirmarReserva;
	private JLabel lblNombreCliente;
	private JLabel lblApellidosCliente;
	private JLabel lblDNI;
	private JLabel lblPrecioFinal;
	private JLabel lblComentario;
	private JTextArea textAreaComentario;
	private JTextArea textAreaResumenJustificacion;
	private JLabel lblJustificante;
	private JButton btnConfirmarReserva;
	private JButton btnCancelarReserva;
	private JTextField textFieldNombreCliente;
	private JTextField textFieldApellidosCliente;
	private JTextField textFieldDNICliente;
	private JTextField textFieldPrecio;
	private JScrollPane scrollPaneJustificacionReserva;
	private DescubreCasilla listenerJuego = new DescubreCasilla();
	private JPanel panelMiniJuego;
	private JLabel lblIntroMinijuego;
	private JPanel panelCasillasJuego;
	private ValidadorFoco validarFoco = new ValidadorFoco();
	private JScrollPane scrollComentario;
	private JScrollPane scrollInfoParques;
	private JScrollPane scrollDescAlojamiento;
	private JScrollPane scrollDescParqueSeleccionado;
	private JScrollPane scrollDescAlojamientoSelccionado;
	private JLabel lblHabitacionesAlojamiento;
	private JTextField textFieldNumeroHabitacionesAlojamiento;
	private JPanel panelPrecioMaxAlojamiento;
	private JPanel panelFiltroEstrellas;
	private JPanel panelFiltroTipoAlojamiento;
	
   
	/**
	 * Create the frame.
	 */
	public VentanaPrincipal(AgenciaService service) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/img/Icon.png")));
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				confirmarSalir();
			}
		});
		this.as = service;
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		setLocationRelativeTo(null);
		setTitle("Maray agency");
		Locale localizacion = Locale.getDefault(Locale.Category.FORMAT);
		localizar(localizacion);
		if(textos.getString("idioma").equals("english")) {
			getRdbtnIngles().setSelected(true);
		}else {
			getRdbtnEspanol().setSelected(true);
		}
		setJMenuBar(getBarraMenu());
		getContentPane().setLayout(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		contentPane.add(getPanelPrincipal(), "panelPrincipal");
		contentPane.add(getPanelParques(), "panelParques");
		contentPane.add(getPanelIntermedioParques(), "panelInterParques");
		contentPane.add(getPanelIntermedioAlojamientos(), "panelInterAlojamientos");
		contentPane.add(getPanelAlojamientos(), "panelAlojamientos");
		contentPane.add(getPanelParqueSeleccionado(), "panelParqueSeleccionado");
		contentPane.add(getPanelAlojamientoSeleccionado(), "panelAlojamientoSeleccionado");
		contentPane.add(getPanelReservarAlojamientoOParque(), "panelReservarAlojamientoOParque");
		contentPane.add(getPanelReservaParques(), "panelReservaParques");
		contentPane.add(getPanelReservaAlojamientos(), "panelReservaAlojamientos");
		contentPane.add(getPanelConfirmarReserva(), "panelConfirmarReserva");
		contentPane.add(getPanelMiniJuego(), "panelMinijuego");
		
		cargaAyuda();
		getBtnParques().requestFocusInWindow();
	}
	
	private class IdiomaListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String idioma = ((JRadioButton)e.getSource()).getActionCommand();
			localizar(new Locale(idioma));
			actualizarTextosPrincipal();
			
		}
		
	}
	
	private class ValidadorFoco extends FocusAdapter{
		@Override
		public void focusLost(FocusEvent e){
			validarBotonConfirmar();
			actualizarTextoResumen();
		}
	}
	
	private class DescubreCasilla implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {

			JButton botonPulsado = (JButton) e.getSource();

			int posicionPulsada = Integer.parseInt(botonPulsado.getActionCommand());

			int posicionPremio = as.getPosicionPremio();

			if (posicionPulsada == posicionPremio) {
				adaptarImagenBoton(botonPulsado, "premio", 130, 180);

				as.setPremioConseguido(true);

				JOptionPane.showMessageDialog(panelMiniJuego, textos.getString("mensaje_premio"),
						textos.getString("titulo_minijuego"), JOptionPane.INFORMATION_MESSAGE);

			} else {
				adaptarImagenBoton(botonPulsado, "fallo", 130, 180);
				JOptionPane.showMessageDialog(panelMiniJuego, textos.getString("mensaje_fallo"),
						textos.getString("titulo_minijuego"), JOptionPane.INFORMATION_MESSAGE);
			}

			as.guardarReservaEnFichero(textos, as.getReserva().getNombreCliente(), as.getReserva().getDniCliente());

			reiniciar();
		}
	}

	private void localizar(Locale localizacion) {
		textos = ResourceBundle.getBundle("rcs/textos", localizacion);
		
		
		
		String fParques = textos.getString("archivo_parques");
		String fAlojamientos = textos.getString("archivo_alojamientos");
		as.inicializarDatos(fParques, fAlojamientos);
	}

	private void adaptarImagenBoton(JButton jb, String nombreImagen, int ancho, int largo) {
		Image imgOriginal = ((new ImageIcon(VentanaPrincipal.class.getResource("/img/"+ nombreImagen + ".png")))).getImage();
		Image imgEscalada = imgOriginal.getScaledInstance(ancho, largo, Image.SCALE_SMOOTH);
		jb.setIcon(new ImageIcon(imgEscalada));
	}
	
	public void adaptarImagenLabel(JLabel lb, String nombreImagen, int ancho, int largo) {
		Image imgOriginal = ((new ImageIcon(VentanaPrincipal.class.getResource("/img/"+ nombreImagen + ".png")))).getImage();
		Image imgEscalada = imgOriginal.getScaledInstance(ancho, largo, Image.SCALE_SMOOTH);
		lb.setIcon(new ImageIcon(imgEscalada));
	}
	
	private void confirmarSalir() {
		if(JOptionPane.showConfirmDialog(this, textos.getString("confirmar_salir"), textos.getString("confirmar"), JOptionPane.YES_NO_OPTION)==0){
			System.exit(0);
		}
	}
	

	private JMenuBar getBarraMenu() {
		if (barraMenu == null) {
			barraMenu = new JMenuBar();
			barraMenu.add(getMnReiniciar());
			barraMenu.add(getMnOfertas());
			barraMenu.add(getMnAyuda());
		}
		return barraMenu;
	}
	private JMenu getMnReiniciar() {
		if (mnReiniciar == null) {
			mnReiniciar = new JMenu(textos.getString("reiniciar"));
			mnReiniciar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			mnReiniciar.setMnemonic('r');
			mnReiniciar.add(getMntmReiniciarReserva());
		}
		return mnReiniciar;
	}
	private JMenu getMnOfertas() {
		if (mnOfertas == null) {
			mnOfertas = new JMenu(textos.getString("ofertas"));
			mnOfertas.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			mnOfertas.setMnemonic('o');
			mnOfertas.add(getMntmOfertas());
		}
		return mnOfertas;
	}
	private JMenu getMnAyuda() {
		if (mnAyuda == null) {
			mnAyuda = new JMenu(textos.getString("ayuda"));
			mnAyuda.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			mnAyuda.setMnemonic('a');
			mnAyuda.add(getMntmContenidos());
			mnAyuda.add(getSeparator());
			mnAyuda.add(getMntmAcercaDe());
		}
		return mnAyuda;
	}
	private JMenuItem getMntmReiniciarReserva() {
		if (mntmReiniciarReserva == null) {
			mntmReiniciarReserva = new JMenuItem(textos.getString("reiniciar_reserva"));
			mntmReiniciarReserva.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			mntmReiniciarReserva.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					reiniciar();
				}
			});
			mntmReiniciarReserva.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_DOWN_MASK));
		}
		return mntmReiniciarReserva;
	}
	private JMenuItem getMntmOfertas() {
		if (mntmOfertas == null) {
			mntmOfertas = new JMenuItem(textos.getString("ofertas"));
			mntmOfertas.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			mntmOfertas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarOferta();
				}
			});
			mntmOfertas.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));
		}
		return mntmOfertas;
	}
	protected void mostrarOferta() {
		Parque oferta = as.getParqueEnOferta();
		if(oferta == null) {
			return;
		} 
		
		String imagen = "/img/" + oferta.getCodigo() + ".png";
		Image icono = (new ImageIcon(VentanaPrincipal.class.getResource(imagen))).getImage();
		Image imgEscalada = icono.getScaledInstance(150, 120, Image.SCALE_SMOOTH);
		Icon iconoFinal = new ImageIcon(imgEscalada);
		
		String mensajeBase = textos.getString("mensaje_oferta");
		String mensajeBase2 = textos.getString("mensaje_oferta2");
		String mensajeFinal = mensajeBase + " " + oferta.getDenominacion() + " " +mensajeBase2;
		
		JOptionPane.showMessageDialog(this, mensajeFinal, textos.getString("titulo_oferta"), JOptionPane.INFORMATION_MESSAGE, iconoFinal);
	}

	private JMenuItem getMntmContenidos() {
		if (mntmContenidos == null) {
			mntmContenidos = new JMenuItem(textos.getString("contenidos"));
			mntmContenidos.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			mntmContenidos.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		}
		return mntmContenidos;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
		}
		return separator;
	}
	private JMenuItem getMntmAcercaDe() {
		if (mntmAcercaDe == null) {
			mntmAcercaDe = new JMenuItem(textos.getString("acerca_de"));
			mntmAcercaDe.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			mntmAcercaDe.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null,
							textos.getString("info_acercade"), 
							textos.getString("acerca_de"), JOptionPane.INFORMATION_MESSAGE);
				}
			});
			mntmAcercaDe.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_DOWN_MASK));
		}
		return mntmAcercaDe;
	}
	private JPanel getPanelPrincipal() {
		if (panelPrincipal == null) {
			panelPrincipal = new JPanel();
			panelPrincipal.setLayout(null);
			panelPrincipal.add(getPanelNorte());
			panelPrincipal.add(getLblIconoPrincipal());
			panelPrincipal.add(getTextAreaDescripcion());
		}
		return panelPrincipal;
	}
	private JPanel getPanelNorte() {
		if (panelNorte == null) {
			panelNorte = new JPanel();
			panelNorte.setBounds(0, 0, 876, 147);
			panelNorte.setLayout(new GridLayout(0, 3, 0, 0));
			panelNorte.add(getBtnParques());
			panelNorte.add(getBtnAlojamientos());
			panelNorte.add(getPanelIdiomas());
			
		}
		return panelNorte;
	}
	private JButton getBtnParques() {
		if (btnParques == null) {
			btnParques = new JButton(textos.getString("parques"));
			btnParques.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			btnParques.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					creaPanelesParques();
					((CardLayout) contentPane.getLayout()).show(contentPane, "panelInterParques");
					actualizarTextosDetalle();
					actualizarCombos();
					filtrarParques();
				}
			});
			btnParques.setMnemonic('v');
			btnParques.setToolTipText(textos.getString("tooltip_parques"));
			btnParques.setHorizontalTextPosition(SwingConstants.CENTER);
			btnParques.setVerticalTextPosition(SwingConstants.BOTTOM);
			adaptarImagenBoton(btnParques, "PT001", 110, 90);
			
			
			
		}
		return btnParques;
	}
	private JButton getBtnAlojamientos() {
		if (btnAlojamientos == null) {
			btnAlojamientos = new JButton(textos.getString("alojamientos"));
			btnAlojamientos.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			btnAlojamientos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					((CardLayout) contentPane.getLayout()).show(contentPane, "panelInterAlojamientos");
					actualizarTextosDetalle();
					actualizarCombos();
				}
			});
			btnAlojamientos.setMnemonic('e');
			btnAlojamientos.setToolTipText(textos.getString("tooltip_alojamientos"));
			btnAlojamientos.setVerticalTextPosition(SwingConstants.BOTTOM);
			btnAlojamientos.setHorizontalTextPosition(SwingConstants.CENTER);
			adaptarImagenBoton(btnAlojamientos, "AL001", 110, 90);
		}
		return btnAlojamientos;
	}
	private JPanel getPanelIdiomas() {
		if (panelIdiomas == null) {
			panelIdiomas = new JPanel();
			panelIdiomas.setLayout(null);
			panelIdiomas.add(getRdbtnEspanol());
			panelIdiomas.add(getRdbtnIngles());
		}
		return panelIdiomas;
	}
	private JRadioButton getRdbtnEspanol() {
		if (rdbtnEspanol == null) {
			rdbtnEspanol = new JRadioButton(textos.getString("btn_espanol"));
			rdbtnEspanol.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			rdbtnEspanol.addActionListener(idiomaListener);
			rdbtnEspanol.setMnemonic('s');
			buttonGroup.add(rdbtnEspanol);
			rdbtnEspanol.setBounds(85, 47, 103, 21);
			rdbtnEspanol.setActionCommand("es");
		}
		return rdbtnEspanol;
	}
	private JRadioButton getRdbtnIngles() {
		if (rdbtnIngles == null) {
			rdbtnIngles = new JRadioButton(textos.getString("btn_ingles"));
			rdbtnIngles.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			rdbtnIngles.addActionListener(idiomaListener);
			rdbtnIngles.setMnemonic('i');
			buttonGroup.add(rdbtnIngles);
			rdbtnIngles.setBounds(85, 84, 112, 20);
			rdbtnIngles.setActionCommand("en");
		}
		return rdbtnIngles;
	}
	private JLabel getLblIconoPrincipal() {
		if (lblIconoPrincipal == null) {
			lblIconoPrincipal = new JLabel("");
			lblIconoPrincipal.setFocusable(false);
			lblIconoPrincipal.setHorizontalAlignment(SwingConstants.CENTER);
			lblIconoPrincipal.setBounds(0, 174, 290, 296);
			adaptarImagenLabel(lblIconoPrincipal, "Icon", 280, 300);
		}
		return lblIconoPrincipal;
	}
	private JTextArea getTextAreaDescripcion() {
		if (textAreaDescripcion == null) {
			textAreaDescripcion = new JTextArea();
			textAreaDescripcion.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			textAreaDescripcion.setFocusable(false);
			textAreaDescripcion.setEditable(false);
			textAreaDescripcion.setLineWrap(true);
			textAreaDescripcion.setBounds(300, 174, 576, 296);
			textAreaDescripcion.setText(textos.getString("descripcion_agencia"));
		}
		return textAreaDescripcion;
	}
	
	private void actualizarTextosPrincipal() {
		getMnReiniciar().setText(textos.getString("reiniciar"));
		getMnOfertas().setText(textos.getString("ofertas"));
		getMnAyuda().setText(textos.getString("ayuda"));
		
		getMntmReiniciarReserva().setText(textos.getString("reiniciar_reserva"));
		getMntmOfertas().setText(textos.getString("ofertas"));
		getMntmContenidos().setText(textos.getString("contenidos"));
		getMntmAcercaDe().setText(textos.getString("acerca_de"));
		
		getBtnParques().setText(textos.getString("parques"));
		getBtnAlojamientos().setText(textos.getString("alojamientos"));
		getRdbtnEspanol().setText(textos.getString("btn_espanol"));
		getRdbtnIngles().setText(textos.getString("btn_ingles"));
		getTextAreaDescripcion().setText(textos.getString("descripcion_agencia"));
		
		getLblTenemosAlojamientos().setText(textos.getString("tenemos_alojamientos"));
		getBtnMasInfoAlojamientos().setText(textos.getString("mas_informacion"));
		getLblTenemosParques().setText(textos.getString("tenemos_parques"));
		getBtnMasInfoParques().setText(textos.getString("mas_informacion"));
		
		Alojamiento seleccionado = (Alojamiento) getComboBoxInterAlojamientos().getSelectedItem();
		if (seleccionado != null) {
			getTextAreaDescAlojamiento().setText(generarDescripcionAlojamiento(seleccionado));
		}
	}
	
	private void actualizarTextosDetalle() {
		getLblTitulo().setText(textos.getString("filtros"));
		getChckbxOferta().setText(textos.getString("filtro_oferta"));
		getChckbxTodos().setText(textos.getString("filtro_todos"));
		getLblPais().setText(textos.getString("filtro_pais"));
		getLblLocalidad().setText(textos.getString("filtro_localidad"));
		getLblPrecioMaximo().setText(textos.getString("filtro_precio"));
	

		getLblTituloFiltrosAlojamientos().setText(textos.getString("filtros"));
		getLblFiltroTipo().setText(textos.getString("filtro_tipo"));
		getLblFiltroEstrellas().setText(textos.getString("filtro_estrellas"));
		getLblPrecioMaxAloj().setText(textos.getString("filtro_precio"));
		
		int index = getComboBoxFiltroTipo().getSelectedIndex();
		getComboBoxFiltroTipo().setModel(new DefaultComboBoxModel(modelTipo()));
		getComboBoxFiltroTipo().setSelectedIndex(index);
		
		getBtnReservarParqueSeleccionado().setText(textos.getString("reservar_parque_seleccionado"));
		getBtnReservarAlojamientoSeleccionado().setText(textos.getString("reservar_alojamiento_seleccionado"));
		
		getBtnReservarAlojamiento().setText(textos.getString("reservar_alojamientos"));
		getBtnReservarParque().setText(textos.getString("reservar_parques"));
		getBtnFormalizarReserva().setText(textos.getString("formalizar_reserva"));
		
		getLblEntradasAdultos().setText(textos.getString("numero_entradas_adulto"));
		getLblEntradasNinos().setText(textos.getString("numero_entradas_nino"));
		getLblNumeroDiasParque().setText(textos.getString("numero_dias_parque"));
		getLblPrecioParque().setText(textos.getString("precio_del_parque"));
		getlblFechaEntrada().setText(textos.getString("fecha_entrada_parque"));
		
		getBtnReservarParqueSeleccionadoTotal().setText(textos.getString("reservar"));
		
		getLblPersonasAlojamiento().setText(textos.getString("numero_personas"));
		getLblNumeroNoches().setText(textos.getString("numero_noches"));
		getLblPrecioAlojamiento().setText(textos.getString("precio_del_alojamiento"));
		
		getlblFechaEntradaAlojamiento().setText(textos.getString("fecha_entrada_alojamiento"));
		getBtnReservarAlojamientoSeleccionadoTotal().setText(textos.getString("reservar"));
		
		getLblNombreCliente().setText(textos.getString("nombre") + " *:");
		getLblApellidosCliente().setText(textos.getString("apellidos")+ " *:");
		getLblDNI().setText(textos.getString("dni")+ " *:");
		getLblPrecioFinal().setText(textos.getString("precio"));
		getLblComentario().setText(textos.getString("comentario"));
		getLblJustificante().setText(textos.getString("justificante"));
		getBtnConfirmarReserva().setText(textos.getString("confirmar"));
		getBtnCancelarReserva().setText(textos.getString("cancelar"));
		
		getLblIntroMinijuego().setText(textos.getString("introduccion_minijuego"));
		
		
		
	}
	
	private void actualizarCombos() {
		getComboBoxInterParques().setModel(new DefaultComboBoxModel(as.getParques().toArray()));
		getComboBoxPais().setModel(new DefaultComboBoxModel(as.getAgencia().getPaises()));
		getComboBoxLocalidad().setModel(new DefaultComboBoxModel(as.getAgencia().getLocalidades((String)getComboBoxPais().getSelectedItem())));
		getTextAreaInfoParques().setText(((Parque)getComboBoxInterParques().getSelectedItem()).getDescripcion());
		getComboBoxInterAlojamientos().setModel(new DefaultComboBoxModel(as.getAlojamientos().toArray()));
		actualizarFechaSeleccionadaParque();
		actualizarFechaSeleccionadaAlojamiento();
	}
	
	public ResourceBundle getTextos() {
		return this.textos;
	}
	
	public AgenciaService getAgenciaService() {
		return this.as;
	}
	
	private JPanel getPanelParques() {
		if (panelParques == null) {
			panelParques = new JPanel();
			panelParques.setLayout(new BorderLayout(10, 10));
			panelParques.add(getPanelFiltros(), BorderLayout.EAST);
			panelParques.add(getScrollParques(), BorderLayout.CENTER);
		}
		return panelParques;
	}
	private JPanel getPanelFiltros() {
		if (panelFiltros == null) {
			panelFiltros = new JPanel();
			panelFiltros.setPreferredSize(new Dimension(280, 0));
			panelFiltros.setLayout(new GridLayout(0, 1, 0, 0));
			panelFiltros.add(getLblTitulo());
			panelFiltros.add(getPanelFiltrarPais());
			panelFiltros.add(getPanelFiltrarLocalidad());
			panelFiltros.add(getPanelPrecioMaxParques());
			panelFiltros.add(getSliderPrecioMax());
			panelFiltros.add(getPanelChecksParques());
		}
		return panelFiltros;
	}
	private JLabel getLblTitulo() {
		if (lblTitulo == null) {
			lblTitulo = new JLabel(textos.getString("filtros"));
			lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
			lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 18));
		}
		return lblTitulo;
	}
	private JComboBox getComboBoxPais() {
		if (comboBoxPais == null) {
			comboBoxPais = new JComboBox();
			comboBoxPais.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			comboBoxPais.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					comboBoxLocalidad.setModel(new DefaultComboBoxModel(as.getAgencia().getLocalidades((String)getComboBoxPais().getSelectedItem())));
					filtrarParques();
				}
			});
			comboBoxPais.setModel(new DefaultComboBoxModel(as.getAgencia().getPaises()));
		}
		return comboBoxPais;
	}
	private JComboBox getComboBoxLocalidad() {
		if (comboBoxLocalidad == null) {
			comboBoxLocalidad = new JComboBox();
			comboBoxLocalidad.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			comboBoxLocalidad.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					filtrarParques();
				}
			});
			comboBoxLocalidad.setModel(new DefaultComboBoxModel(as.getAgencia().getLocalidades((String)getComboBoxPais().getSelectedItem())));
		}
		return comboBoxLocalidad;
	}
	private JSlider getSliderPrecioMax() {
		if (sliderPrecioMax == null) {
			sliderPrecioMax = new JSlider();
			sliderPrecioMax.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			sliderPrecioMax.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					getTextFieldPrecioMax().setText(String.valueOf(getSliderPrecioMax().getValue()));
					getChckbxTodos().setSelected(false);
					filtrarParques();
				}
			});
			sliderPrecioMax.setValue(60);
			sliderPrecioMax.setPaintTicks(true);
			sliderPrecioMax.setPaintLabels(true);
			sliderPrecioMax.setMinorTickSpacing(5);
			sliderPrecioMax.setMajorTickSpacing(15);
			sliderPrecioMax.setMaximum(60);
		}
		return sliderPrecioMax;
	}
	private JScrollPane getScrollParques() {
		if (scrollParques == null) {
			scrollParques = new JScrollPane();
			scrollParques.setViewportView(getPanelIntroParques());
		}
		return scrollParques;
	}
	private JPanel getPanelIntroParques() {
		if (panelIntroParques == null) {
			panelIntroParques = new JPanel();
			panelIntroParques.setLayout(new GridLayout(0, 1, 0, 0));
		}
		return panelIntroParques;
	}
	
	private void creaPanelesParques() {
		creaPanelesParques(as.getParques());
	}
	
	private void creaPanelesParques(List<Parque> listaAPintar) {
		getPanelIntroParques().removeAll();
		
		if(!listaAPintar.isEmpty()) {
			for (Parque p: listaAPintar) {
				PanelParque elemento = new PanelParque(this, p);
				getPanelIntroParques().add(elemento);
			}
		}
		getPanelIntroParques().revalidate();
		getPanelIntroParques().repaint();
		
		
	}
	private JPanel getPanelIntermedioParques() {
		if (panelIntermedioParques == null) {
			panelIntermedioParques = new JPanel();
			panelIntermedioParques.setLayout(null);
			panelIntermedioParques.add(getLblTenemosParques());
			panelIntermedioParques.add(getComboBoxInterParques());
			panelIntermedioParques.add(getBtnMasInfoParques());
			panelIntermedioParques.add(getScrollInfoParques());
		}
		return panelIntermedioParques;
	}
	private JLabel getLblTenemosParques() {
		if (lblTenemosParques == null) {
			lblTenemosParques = new JLabel(textos.getString("tenemos_parques"));
			lblTenemosParques.setBounds(112, 71, 358, 55);
			lblTenemosParques.setFont(new Font("Segoe UI", Font.BOLD, 18));
		
		}
		return lblTenemosParques;
	}
	private JComboBox getComboBoxInterParques() {
		if (comboBoxInterParques == null) {
			comboBoxInterParques = new JComboBox<Parque>();
			comboBoxInterParques.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			comboBoxInterParques.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					textAreaInfoParques.setText(((Parque)getComboBoxInterParques().getSelectedItem()).getDescripcion());
				}
			});
			comboBoxInterParques.setModel(new DefaultComboBoxModel(as.getParques().toArray()));
			comboBoxInterParques.setBounds(412, 71, 335, 55);
		}
		return comboBoxInterParques;
	}
	private JTextArea getTextAreaInfoParques() {
		if (textAreaInfoParques == null) {
			textAreaInfoParques = new JTextArea();
			textAreaInfoParques.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			textAreaInfoParques.setLineWrap(true);
			textAreaInfoParques.setBounds(412, 175, 335, 204);
			textAreaInfoParques.setText(((Parque)getComboBoxInterParques().getSelectedItem()).getDescripcion());
		}
		return textAreaInfoParques;
	}
	private JButton getBtnMasInfoParques() {
		if (btnMasInfoParques == null) {
			btnMasInfoParques = new JButton(textos.getString("mas_informacion"));
			btnMasInfoParques.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			btnMasInfoParques.setMnemonic('M');
			btnMasInfoParques.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					((CardLayout) contentPane.getLayout()).show(contentPane, "panelParques");
				}
			});
			btnMasInfoParques.setBounds(82, 210, 234, 82);
		}
		return btnMasInfoParques;
	}

	private JLabel getLblPais() {
		if (lblPais == null) {
			lblPais = new JLabel(textos.getString("filtro_pais"));
			lblPais.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			lblPais.setDisplayedMnemonic('p');
			lblPais.setLabelFor(getComboBoxPais());
		}
		return lblPais;
	}

	private JLabel getLblLocalidad() {
		if (lblLocalidad == null) {
			lblLocalidad = new JLabel(textos.getString("filtro_localidad"));
			lblLocalidad.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			lblLocalidad.setDisplayedMnemonic('l');
			lblLocalidad.setLabelFor(getComboBoxLocalidad());
		}
		return lblLocalidad;
	}
	private JLabel getLblPrecioMaximo() {
		if (lblPrecioMaximo == null) {
			lblPrecioMaximo = new JLabel(textos.getString("filtro_precio"));
			lblPrecioMaximo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		}
		return lblPrecioMaximo;
	}
	private JTextField getTextFieldPrecioMax() {
		if (textFieldPrecioMax == null) {
			textFieldPrecioMax = new JTextField();
			textFieldPrecioMax.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			textFieldPrecioMax.setEditable(false);
			textFieldPrecioMax.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				}
			});
			textFieldPrecioMax.setColumns(10);
		}
		return textFieldPrecioMax;
	}
	
	private JCheckBox getChckbxOferta() {
		if (chckbxOferta == null) {
			chckbxOferta = new JCheckBox(textos.getString("filtro_oferta"));
			chckbxOferta.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			chckbxOferta.setMnemonic('n');
			chckbxOferta.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					filtrarParques();
					getChckbxTodos().setSelected(false);
				}
			});
		}
		return chckbxOferta;
	}
	
	private JCheckBox getChckbxTodos() {
		if (chckbxTodos == null) {
			chckbxTodos = new JCheckBox(textos.getString("filtro_todos"));
			chckbxTodos.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			chckbxTodos.setMnemonic('T');
			chckbxTodos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(chckbxTodos.isSelected()) {
						getComboBoxPais().setSelectedIndex(0);		
						getSliderPrecioMax().setValue(getSliderPrecioMax().getMaximum());
						getChckbxOferta().setSelected(false);
						
						filtrarParques();
					}
				}
			});
		}
		return chckbxTodos;
	}
	
	private void filtrarParques() {
		Alojamiento alojamientoReservado = as.getAlojamientoSeleccionado();

		if (alojamientoReservado != null) {
			getComboBoxPais().setEnabled(false);
			getComboBoxLocalidad().setEnabled(false);
			getSliderPrecioMax().setEnabled(false);
			getChckbxOferta().setEnabled(false);
			getChckbxTodos().setEnabled(false);

		} else {
			getComboBoxPais().setEnabled(true);
			getComboBoxLocalidad().setEnabled(true);
			getSliderPrecioMax().setEnabled(true);
			getChckbxOferta().setEnabled(true);
			getChckbxTodos().setEnabled(true);
		}
		String paisSeleccionado = (String) getComboBoxPais().getSelectedItem();
		String localidadSeleccionada = (String) getComboBoxLocalidad().getSelectedItem();
		int precioMax = getSliderPrecioMax().getValue();
		boolean soloOfertas = getChckbxOferta().isSelected();

		List<Parque> filtrados = new ArrayList<>();
		for (Parque p : as.getParques()) {
			if (alojamientoReservado != null) {
				if (p.getCodigo().equals(alojamientoReservado.getCodigoParque())) {
					filtrados.add(p);
				}
				continue;
			}
			boolean checkPais = "-".equals(paisSeleccionado) || p.getPais().equals(paisSeleccionado);
			boolean checkLocalidad = "-".equals(localidadSeleccionada)
					|| p.getLocalidad().equals(localidadSeleccionada);
			boolean checkPrecio = p.getPrecioAdulto() <= precioMax;
			boolean checkOferta = !soloOfertas || as.esParqueEnOferta(p);

			if (checkLocalidad && checkOferta && checkPais && checkPrecio) {
				filtrados.add(p);
			}
		}

		creaPanelesParques(filtrados);
	}
	private JPanel getPanelIntermedioAlojamientos() {
		if (panelIntermedioAlojamientos == null) {
			panelIntermedioAlojamientos = new JPanel();
			panelIntermedioAlojamientos.setLayout(null);
			panelIntermedioAlojamientos.add(getLblTenemosAlojamientos());
			panelIntermedioAlojamientos.add(getComboBoxInterAlojamientos());
			panelIntermedioAlojamientos.add(getBtnMasInfoAlojamientos());
			panelIntermedioAlojamientos.add(getScrollDescAlojamiento());
		}
		return panelIntermedioAlojamientos;
	}
	private JLabel getLblTenemosAlojamientos() {
		if (lblTenemosAlojamientos == null) {
			lblTenemosAlojamientos = new JLabel(textos.getString("tenemos_alojamientos"));
			lblTenemosAlojamientos.setBounds(52, 85, 353, 57);
			lblTenemosAlojamientos.setFont(new Font("Segoe UI", Font.BOLD, 18));
		}
		return lblTenemosAlojamientos;
	}
	private JComboBox getComboBoxInterAlojamientos() {
		if (comboBoxInterAlojamientos == null) {
			comboBoxInterAlojamientos = new JComboBox();
			comboBoxInterAlojamientos.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			comboBoxInterAlojamientos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					getTextAreaDescAlojamiento().setText(generarDescripcionAlojamiento((Alojamiento)getComboBoxInterAlojamientos().getSelectedItem()));
				}
			});
			comboBoxInterAlojamientos.setBounds(415, 85, 295, 57);
			comboBoxInterAlojamientos.setModel(new DefaultComboBoxModel(as.getAlojamientos().toArray()));
		}
		return comboBoxInterAlojamientos;
	}
	private JButton getBtnMasInfoAlojamientos() {
		if (btnMasInfoAlojamientos == null) {
			btnMasInfoAlojamientos = new JButton(textos.getString("mas_informacion"));
			btnMasInfoAlojamientos.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			btnMasInfoAlojamientos.setMnemonic('M');
			btnMasInfoAlojamientos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					creaPanelesAlojamientos();
					((CardLayout) contentPane.getLayout()).show(contentPane, "panelAlojamientos");
					filtrarAlojamientos();
				}
			});
			btnMasInfoAlojamientos.setBounds(70, 220, 246, 72);
		}
		return btnMasInfoAlojamientos;
	}
	
	private String generarDescripcionAlojamiento(Alojamiento a) {
		if(a.getTipo().equals("HO")) {
			return textos.getString("texto_hotel");
		}else {
			return textos.getString("texto_nohotel");
		}
	}
	private JTextArea getTextAreaDescAlojamiento() {
		if (textAreaDescAlojamiento == null) {
			textAreaDescAlojamiento = new JTextArea(generarDescripcionAlojamiento((Alojamiento)getComboBoxInterAlojamientos().getSelectedItem()));
			textAreaDescAlojamiento.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			textAreaDescAlojamiento.setLineWrap(true);
			textAreaDescAlojamiento.setBounds(415, 185, 295, 108);
		}
		return textAreaDescAlojamiento;
	}
	private JPanel getPanelAlojamientos() {
		if (panelAlojamientos == null) {
			panelAlojamientos = new JPanel();
			panelAlojamientos.setLayout(new BorderLayout(10, 10));
			panelAlojamientos.add(getPanelFiltroAlojamientos(), BorderLayout.EAST);
			panelAlojamientos.add(getScrollPaneAlojamientos(), BorderLayout.CENTER);
		}
		return panelAlojamientos;
	}
	private JScrollPane getScrollPaneAlojamientos() {
		if (scrollPaneAlojamientos == null) {
			scrollPaneAlojamientos = new JScrollPane();
			scrollPaneAlojamientos.setViewportView(getPanelIntroAlojamientos());
		}
		return scrollPaneAlojamientos;
	}
	private JPanel getPanelIntroAlojamientos() {
		if (panelIntroAlojamientos == null) {
			panelIntroAlojamientos = new JPanel();
			panelIntroAlojamientos.setLayout(new GridLayout(0, 1, 0, 0));
		}
		return panelIntroAlojamientos;
	}
	private JPanel getPanelFiltroAlojamientos() {
		if (panelFiltroAlojamientos == null) {
			panelFiltroAlojamientos = new JPanel();
			panelFiltroAlojamientos.setPreferredSize(new Dimension(280, 0));
			panelFiltroAlojamientos.setLayout(new GridLayout(5, 1, 0, 0));
			panelFiltroAlojamientos.add(getLblTituloFiltrosAlojamientos());
			panelFiltroAlojamientos.add(getPanelFiltroTipoAlojamiento());
			panelFiltroAlojamientos.add(getPanelFiltroEstrellas());
			panelFiltroAlojamientos.add(getPanelPrecioMaxAlojamiento());
			panelFiltroAlojamientos.add(getSliderPrecioMaxAlojamientos());
		}
		return panelFiltroAlojamientos;
	}
	
	private JPanel getPanelPrecioMaxAlojamiento() {
		if(panelPrecioMaxAlojamiento == null) {
			panelPrecioMaxAlojamiento = new JPanel();
			panelPrecioMaxAlojamiento.setLayout(new GridLayout(1, 2, 0, 0));
			panelPrecioMaxAlojamiento.add(getLblPrecioMaxAloj());
			panelPrecioMaxAlojamiento.add(getTextFieldSliderAlojamientos()); 
		}
		return panelPrecioMaxAlojamiento;
	}

	private JPanel getPanelFiltroEstrellas() {
		if(panelFiltroEstrellas == null) {
			panelFiltroEstrellas = new JPanel();
			panelFiltroEstrellas.setLayout(new GridLayout(1, 2, 0, 0));
			panelFiltroEstrellas.add(getLblFiltroEstrellas());
			panelFiltroEstrellas.add(getSpinnerFiltroEstrellas());
		}
		return panelFiltroEstrellas;
	}

	private JPanel getPanelFiltroTipoAlojamiento() {
		if(panelFiltroTipoAlojamiento == null) {
			panelFiltroTipoAlojamiento = new JPanel();
			panelFiltroTipoAlojamiento.setLayout(new GridLayout(1, 2, 0, 0));
			panelFiltroTipoAlojamiento.add(getLblFiltroTipo());
			panelFiltroTipoAlojamiento.add(getComboBoxFiltroTipo());
		}
		return panelFiltroTipoAlojamiento;
	}

	private void creaPanelesAlojamientos() {
		creaPanelesAlojamientos(as.getAlojamientos());
	}
	
	private void creaPanelesAlojamientos(List<Alojamiento> listaAPintar) {
		getPanelIntroAlojamientos().removeAll();
		
		if(!listaAPintar.isEmpty()) {
			for (Alojamiento a: listaAPintar) {
				PanelAlojamiento elemento = new PanelAlojamiento(this, a);
				getPanelIntroAlojamientos().add(elemento);
			}
		}
		getPanelIntroAlojamientos().revalidate();
		getPanelIntroAlojamientos().repaint();
		
		
	}
	private JLabel getLblTituloFiltrosAlojamientos() {
		if (lblTituloFiltrosAlojamientos == null) {
			lblTituloFiltrosAlojamientos = new JLabel(textos.getString("filtros"));
			lblTituloFiltrosAlojamientos.setHorizontalAlignment(SwingConstants.CENTER);
			lblTituloFiltrosAlojamientos.setBounds(0, 10, 259, 39);
			lblTituloFiltrosAlojamientos.setFont(new Font("Segoe UI", Font.BOLD, 18));
		}
		return lblTituloFiltrosAlojamientos;
	}
	private JLabel getLblFiltroTipo() {
		if (lblFiltroTipo == null) {
			lblFiltroTipo = new JLabel(textos.getString("filtro_tipo"));
			lblFiltroTipo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			lblFiltroTipo.setBounds(10, 59, 91, 39);
			lblFiltroTipo.setDisplayedMnemonic('t');
	        lblFiltroTipo.setLabelFor(getComboBoxFiltroTipo());
		}
		return lblFiltroTipo;
	}
	
	private String[] modelTipo() {
		String[] result = new String[4];
		result[0] = "-";
		result[1] = textos.getString("hotel");
		result[2] = textos.getString("apartahotel");
		result[3] = textos.getString("apartamento");
		
		return result;
	}
	private JComboBox getComboBoxFiltroTipo() {
		if (comboBoxFiltroTipo == null) {
			comboBoxFiltroTipo = new JComboBox();
			comboBoxFiltroTipo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			comboBoxFiltroTipo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					filtrarAlojamientos();
				}
			});
			comboBoxFiltroTipo.setModel(new DefaultComboBoxModel(modelTipo()));
			comboBoxFiltroTipo.setBounds(111, 59, 148, 39);
		}
		return comboBoxFiltroTipo;
	}
	private JLabel getLblFiltroEstrellas() {
		if (lblFiltroEstrellas == null) {
			lblFiltroEstrellas = new JLabel(textos.getString("filtro_estrellas"));
			lblFiltroEstrellas.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			lblFiltroEstrellas.setBounds(0, 115, 98, 44);
			lblFiltroEstrellas.setDisplayedMnemonic('e');
	        lblFiltroEstrellas.setLabelFor(getSpinnerFiltroEstrellas());
		}
		return lblFiltroEstrellas;
	}
	private JSpinner getSpinnerFiltroEstrellas() {
		if (spinnerFiltroEstrellas == null) {
			spinnerFiltroEstrellas = new JSpinner();
			spinnerFiltroEstrellas.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			spinnerFiltroEstrellas.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					filtrarAlojamientos();
				}
			});
			spinnerFiltroEstrellas.setModel(new SpinnerNumberModel(0, 0, 5, 1));
			spinnerFiltroEstrellas.setBounds(175, 118, 48, 39);
		}
		return spinnerFiltroEstrellas;
	}
	private JLabel getLblPrecioMaxAloj() {
		if (lblPrecioMaxAloj == null) {
			lblPrecioMaxAloj = new JLabel(textos.getString("filtro_precio"));
			lblPrecioMaxAloj.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			lblPrecioMaxAloj.setBounds(0, 179, 114, 51);
		}
		return lblPrecioMaxAloj;
	}
	private JSlider getSliderPrecioMaxAlojamientos() {
		if (sliderPrecioMaxAlojamientos == null) {
			sliderPrecioMaxAlojamientos = new JSlider();
			sliderPrecioMaxAlojamientos.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			sliderPrecioMaxAlojamientos.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					getTextFieldSliderAlojamientos().setText(String.valueOf(getSliderPrecioMaxAlojamientos().getValue()));
					filtrarAlojamientos();
				}
			});
			sliderPrecioMaxAlojamientos.setPaintLabels(true);
			sliderPrecioMaxAlojamientos.setPaintTicks(true);
			sliderPrecioMaxAlojamientos.setMinorTickSpacing(10);
			sliderPrecioMaxAlojamientos.setMajorTickSpacing(50);
			sliderPrecioMaxAlojamientos.setMaximum(400);
			sliderPrecioMaxAlojamientos.setValue(400);
			sliderPrecioMaxAlojamientos.setBounds(0, 240, 259, 51);
		}
		return sliderPrecioMaxAlojamientos;
	}
	private JTextField getTextFieldSliderAlojamientos() {
		if (textFieldSliderAlojamientos == null) {
			textFieldSliderAlojamientos = new JTextField();
			textFieldSliderAlojamientos.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			textFieldSliderAlojamientos.setEditable(false);
			textFieldSliderAlojamientos.setBounds(123, 180, 75, 49);
			textFieldSliderAlojamientos.setColumns(10);
			textFieldSliderAlojamientos.setText(String.valueOf(getSliderPrecioMaxAlojamientos().getValue()));
		}
		return textFieldSliderAlojamientos;
	}
	
	private void filtrarAlojamientos() {
		Parque parqueSeleccionado = as.getParqueSeleccionado();

		if (parqueSeleccionado != null) {

			getComboBoxFiltroTipo().setEnabled(false);
			getSpinnerFiltroEstrellas().setEnabled(false);
			getSliderPrecioMaxAlojamientos().setEnabled(false);

		} else {
			getComboBoxFiltroTipo().setEnabled(true);
			getSpinnerFiltroEstrellas().setEnabled(true);
			getSliderPrecioMaxAlojamientos().setEnabled(true);
		}

		int precioMax = getSliderPrecioMaxAlojamientos().getValue();
		int estrellasMin = (Integer) getSpinnerFiltroEstrellas().getValue();
		int indiceTipo = getComboBoxFiltroTipo().getSelectedIndex();

		List<Alojamiento> filtrados = new ArrayList<>();

		for (Alojamiento a : as.getAlojamientos()) {

			if (parqueSeleccionado != null) {
				if (a.getCodigoParque().equals(parqueSeleccionado.getCodigo())) {
					filtrados.add(a);
				}
				continue;
			}

			boolean checkPrecio = a.getPrecio() <= precioMax;

			boolean checkEstrellas = a.getCategoria() >= estrellasMin;

			boolean checkTipo = false;
			String codigoTipo = a.getTipo();
			if (indiceTipo == 0 || indiceTipo == 1 && codigoTipo.equals("HO")
					|| indiceTipo == 2 && codigoTipo.equals("AH") || indiceTipo == 3 && codigoTipo.equals("AP")) {

				checkTipo = true;

			}

			if (checkPrecio && checkEstrellas && checkTipo) {
				filtrados.add(a);
			}
		}

		creaPanelesAlojamientos(filtrados);
	}
	
	public void setParquedSelected(Parque p) {
		as.setParqueSeleccionado(p);
	}
	
	
	private JPanel getPanelFiltrarPais() {
		if (panelFiltrarPais == null) {
			panelFiltrarPais = new JPanel();
			panelFiltrarPais.setLayout(new GridLayout(0, 2, 0, 0));
			panelFiltrarPais.add(getLblPais());
			panelFiltrarPais.add(getComboBoxPais());
		}
		return panelFiltrarPais;
	}
	private JPanel getPanelFiltrarLocalidad() {
		if (panelFiltrarLocalidad == null) {
			panelFiltrarLocalidad = new JPanel();
			panelFiltrarLocalidad.setLayout(new GridLayout(0, 2, 0, 0));
			panelFiltrarLocalidad.add(getLblLocalidad());
			panelFiltrarLocalidad.add(getComboBoxLocalidad());
		}
		return panelFiltrarLocalidad;
	}
	private JPanel getPanelPrecioMaxParques() {
		if (panelPrecioMaxParques == null) {
			panelPrecioMaxParques = new JPanel();
			panelPrecioMaxParques.setLayout(new GridLayout(0, 2, 0, 0));
			panelPrecioMaxParques.add(getLblPrecioMaximo());
			panelPrecioMaxParques.add(getTextFieldPrecioMax());
		}
		return panelPrecioMaxParques;
	}
	private JPanel getPanelChecksParques() {
		if (panelChecksParques == null) {
			panelChecksParques = new JPanel();
			panelChecksParques.setLayout(new GridLayout(1, 2, 0, 0));
			panelChecksParques.add(getChckbxOferta());
			panelChecksParques.add(getChckbxTodos());
		}
		return panelChecksParques;
	}
	private JPanel getPanelParqueSeleccionado() {
		if (panelParqueSeleccionado == null) {
			panelParqueSeleccionado = new JPanel();
			panelParqueSeleccionado.setLayout(null);
			panelParqueSeleccionado.add(getLblFotoParqueSeleccionado());
			panelParqueSeleccionado.add(getBtnReservarParqueSeleccionado());
			panelParqueSeleccionado.add(getScrollDescParqueSeleccionado());
		}
		return panelParqueSeleccionado;
	}
	
	private JTextArea getTextAreaDescParqueSeleccionado() {
		if (textAreaDescParqueSeleccionado == null) {
			textAreaDescParqueSeleccionado = new JTextArea();
			textAreaDescParqueSeleccionado.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			textAreaDescParqueSeleccionado.setEditable(false);
			textAreaDescParqueSeleccionado.setLineWrap(true);
			textAreaDescParqueSeleccionado.setBounds(46, 68, 314, 130);
		}
		return textAreaDescParqueSeleccionado;
	}
	private JLabel getLblFotoParqueSeleccionado() {
		if (lblFotoParqueSeleccionado == null) {
			lblFotoParqueSeleccionado = new JLabel("");
			lblFotoParqueSeleccionado.setBounds(46, 241, 314, 195);
			
		}
		return lblFotoParqueSeleccionado;
	}
	private JButton getBtnReservarParqueSeleccionado() {
		if (btnReservarParqueSeleccionado == null) {
			btnReservarParqueSeleccionado = new JButton(textos.getString("reservar_parque_seleccionado"));
			btnReservarParqueSeleccionado.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			btnReservarParqueSeleccionado.setMnemonic('e');
			btnReservarParqueSeleccionado.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					validarFormalizarReserva();
					((CardLayout) contentPane.getLayout()).show(contentPane, "panelReservarAlojamientoOParque");
				}
			});
			btnReservarParqueSeleccionado.setBounds(468, 163, 303, 113);
		}
		return btnReservarParqueSeleccionado;
	}

	public void seleccionarParqueSeleccionado() {
		getTextAreaDescParqueSeleccionado().setText(as.getParqueSeleccionado().getDescripcion());
		adaptarImagenLabel(lblFotoParqueSeleccionado, as.getParqueSeleccionado().getCodigo(), 300, 300);
		((CardLayout) contentPane.getLayout()).show(contentPane, "panelParqueSeleccionado");
		
	}
	private JPanel getPanelAlojamientoSeleccionado() {
		if (panelAlojamientoSeleccionado == null) {
			panelAlojamientoSeleccionado = new JPanel();
			panelAlojamientoSeleccionado.setLayout(null);
			panelAlojamientoSeleccionado.add(getLblFotoAlojamientoSeleccionado());
			panelAlojamientoSeleccionado.add(getBtnReservarAlojamientoSeleccionado());
			panelAlojamientoSeleccionado.add(getScrollDescAlojamientoSelccionado());
		}
		return panelAlojamientoSeleccionado;
	}
	private JTextArea getTextAreaDescAlojamientoSeleccionado() {
		if (textAreaDescAlojamientoSeleccionado == null) {
			textAreaDescAlojamientoSeleccionado = new JTextArea();
			textAreaDescAlojamientoSeleccionado.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			textAreaDescAlojamientoSeleccionado.setEditable(false);
			textAreaDescAlojamientoSeleccionado.setLineWrap(true);
			textAreaDescAlojamientoSeleccionado.setBounds(56, 63, 308, 144);
		}
		return textAreaDescAlojamientoSeleccionado;
	}
	private JLabel getLblFotoAlojamientoSeleccionado() {
		if (lblFotoAlojamientoSeleccionado == null) {
			lblFotoAlojamientoSeleccionado = new JLabel("");
			lblFotoAlojamientoSeleccionado.setBounds(69, 267, 317, 190);
		}
		return lblFotoAlojamientoSeleccionado;
	}
	private JButton getBtnReservarAlojamientoSeleccionado() {
		if (btnReservarAlojamientoSeleccionado == null) {
			btnReservarAlojamientoSeleccionado = new JButton(textos.getString("reservar_alojamiento_seleccionado"));
			btnReservarAlojamientoSeleccionado.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			btnReservarAlojamientoSeleccionado.setMnemonic('R');
			btnReservarAlojamientoSeleccionado.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					validarFormalizarReserva();
					((CardLayout) contentPane.getLayout()).show(contentPane, "panelReservarAlojamientoOParque");
				}
			});
			btnReservarAlojamientoSeleccionado.setBounds(486, 171, 281, 115);
		}
		return btnReservarAlojamientoSeleccionado;
	}
	
	private String generarDescripcionDetalladaAlojamiento(Alojamiento a) {
		String tipoTraducido = "";
		if ("HO".equals(a.getTipo()))
			tipoTraducido = textos.getString("hotel");
		else if ("AP".equals(a.getTipo()))
			tipoTraducido = textos.getString("apartamento");
		else
			tipoTraducido = textos.getString("apartahotel");

		return textos.getString("desc_aloj_ubicacion") + " " + as.getParqueDelAlojamiento(a) + ".\n"
				+ textos.getString("desc_aloj_tipo") + " " + tipoTraducido + " "
				+ textos.getString("desc_aloj_categoria") + " " + a.getCategoria() + " "
				+ textos.getString("desc_aloj_estrellas") + "\n\n" + textos.getString("desc_aloj_precio") + " "
				+ a.getPrecio() + "€.";
	}

	public void seleccionarAlejamientoSeleccionado() {
		
		getTextAreaDescAlojamientoSeleccionado().setText(generarDescripcionDetalladaAlojamiento(as.getAlojamientoSeleccionado()));
	}

	public void setAlojamientoSeleccionado(Alojamiento alojamiento) {
		as.setAlojamientoSeleccionado(alojamiento);
		adaptarImagenLabel(lblFotoAlojamientoSeleccionado, as.getAlojamientoSeleccionado().getCodigo(), 300, 300);
		((CardLayout) contentPane.getLayout()).show(contentPane, "panelAlojamientoSeleccionado");
	}
	
	private void reiniciar() {
		as.iniciarNuevaReserva();

		getComboBoxPais().setSelectedIndex(0);
		getComboBoxPais().setEnabled(true);
		getComboBoxLocalidad().setEnabled(true);
		getSliderPrecioMax().setValue(getSliderPrecioMax().getMaximum());
		getSliderPrecioMax().setEnabled(true);
		getChckbxOferta().setSelected(false);
		getChckbxOferta().setEnabled(true);
		getChckbxTodos().setSelected(false);
		getChckbxTodos().setEnabled(true);

		getComboBoxFiltroTipo().setSelectedIndex(0);
		getComboBoxFiltroTipo().setEnabled(true);
		getSpinnerFiltroEstrellas().setValue(0);
		getSpinnerFiltroEstrellas().setEnabled(true);
		getSliderPrecioMaxAlojamientos().setValue(getSliderPrecioMaxAlojamientos().getMaximum());
		getSliderPrecioMaxAlojamientos().setEnabled(true);

		getSpinnerNumeroEntradasAdulto().setValue(0);
		getSpinnerNumeroEntradasNino().setValue(0);
		getSpinnerNumeroDiasParque().setValue(0);
		getTextFieldPrecioParqueSeleccionado().setText("0");
		gettextFieldFechaReservada().setText(null);
		getBtnReservarParqueSeleccionadoTotal().setEnabled(false);
		getCalendarFechaEntrada().setDate(new Date());

		getSpinnerNumeroPersonasAlojamiento().setValue(0);
		getSpinnerNumeroNochesAlojamiento().setValue(0);
		getTextFieldPrecioAlojamientoSeleccionado().setText("0");
		gettextFieldFechaReservadaAlojamiento().setText(null);
		getBtnReservarAlojamientoSeleccionadoTotal().setEnabled(false);
		getCalendarFechaEntradaAlojamiento().setDate(new Date());

		getTextFieldNombreCliente().setText("");
		getTextFieldApellidosCliente().setText("");
		getTextFieldDNICliente().setText("");
		getTextAreaComentario().setText("");
		getTextFieldPrecio().setText("");
		getTextAreaResumenJustificacion().setText("");
		getBtnFormalizarReserva().setEnabled(false);
		getBtnReservarAlojamiento().setEnabled(true);
		getBtnReservarParque().setEnabled(true);

		((CardLayout) contentPane.getLayout()).show(contentPane, "panelPrincipal");

		creaPanelesParques(as.getParques());
		creaPanelesAlojamientos(as.getAlojamientos());
		getRootPane().setDefaultButton(null);
		getBtnParques().requestFocusInWindow();
	}
	
	private JPanel getPanelReservarAlojamientoOParque() {
		if (panelReservarAlojamientoOParque == null) {
			panelReservarAlojamientoOParque = new JPanel();
			panelReservarAlojamientoOParque.setLayout(null);
			panelReservarAlojamientoOParque.add(getBtnReservarAlojamiento());
			panelReservarAlojamientoOParque.add(getBtnReservarParque());
			panelReservarAlojamientoOParque.add(getBtnFormalizarReserva());
		}
		return panelReservarAlojamientoOParque;
	}

	private JButton getBtnReservarAlojamiento() {
		if (btnReservarAlojamiento == null) {
			btnReservarAlojamiento = new JButton(textos.getString("reservar_alojamientos"));
			btnReservarAlojamiento.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			btnReservarAlojamiento.setMnemonic('e');
			btnReservarAlojamiento.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (as.getAlojamientoSeleccionado() == null) {

						int respuesta = JOptionPane.showConfirmDialog(VentanaPrincipal.this,
								textos.getString("pregunta_alojamientos"), textos.getString("completar_reserva"),
								JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

						if (respuesta == JOptionPane.YES_OPTION) {
							filtrarAlojamientos();

							((CardLayout) contentPane.getLayout()).show(contentPane, "panelInterAlojamientos");
							actualizarTextosDetalle();
							actualizarCombos();

						} else {

						}

					} else {
						lblAlojamientoAReservar.setText(textos.getString("reservando_alojamiento") + " "
								+ as.getAlojamientoSeleccionado().getDenominacion() + ":");
						getBtnReservarAlojamiento().setEnabled(false);
						((CardLayout) contentPane.getLayout()).show(contentPane, "panelReservaAlojamientos");
					}
				}
			});
			btnReservarAlojamiento.setBounds(220, 120, 200, 60);
		}
		return btnReservarAlojamiento;
	}

	private JButton getBtnReservarParque() {
		if (btnReservarParque == null) {
			btnReservarParque = new JButton(textos.getString("reservar_parques"));
			btnReservarParque.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			btnReservarParque.setMnemonic('p');
			btnReservarParque.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (as.getParqueSeleccionado() == null) {

						int respuesta = JOptionPane.showConfirmDialog(VentanaPrincipal.this,
								textos.getString("pregunta_parques"), textos.getString("completar_reserva"),
								JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

						if (respuesta == JOptionPane.YES_OPTION) {
							filtrarParques();

							((CardLayout) contentPane.getLayout()).show(contentPane, "panelInterParques");
							actualizarTextosDetalle();
							actualizarCombos();

						} else {

						}

					} else {
						lblParqueAReservar.setText(textos.getString("reservando_parque") + " "
								+ as.getParqueSeleccionado().getDenominacion() + ":");
						getBtnReservarParque().setEnabled(false);
						((CardLayout) contentPane.getLayout()).show(contentPane, "panelReservaParques");
					}
				}
			});
			btnReservarParque.setBounds(460, 120, 200, 60);
		}
		return btnReservarParque;
	}
	private JButton getBtnFormalizarReserva() {
		if (btnFormalizarReserva == null) {
			btnFormalizarReserva = new JButton(textos.getString("formalizar_reserva"));
			btnFormalizarReserva.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			btnFormalizarReserva.setEnabled(false);
			btnFormalizarReserva.setMnemonic('Z');
			btnFormalizarReserva.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					getTextFieldPrecio().setText(String.valueOf(as.getImporteTotal()));
					actualizarTextoResumen();
					getRootPane().setDefaultButton(getBtnConfirmarReserva());
					((CardLayout) contentPane.getLayout()).show(contentPane, "panelConfirmarReserva");
					getTextFieldNombreCliente().requestFocus();
				}
			});
			btnFormalizarReserva.setBounds(340, 220, 200, 60);
		}
		return btnFormalizarReserva;
	}
	private JPanel getPanelReservaParques() {
		if (panelReservaParques == null) {
			panelReservaParques = new JPanel();
			panelReservaParques.setLayout(null);panelReservaParques.add(getlblParqueAReservar());
			panelReservaParques.add(getlblFechaEntrada());
			panelReservaParques.add(gettextFieldFechaReservada());
			panelReservaParques.add(getCalendarFechaEntrada());
			panelReservaParques.add(getLblEntradasAdultos());
			panelReservaParques.add(getSpinnerNumeroEntradasAdulto());
			panelReservaParques.add(getLblEntradasNinos());
			panelReservaParques.add(getSpinnerNumeroEntradasNino());
			panelReservaParques.add(getLblNumeroDiasParque());
			panelReservaParques.add(getSpinnerNumeroDiasParque());
			panelReservaParques.add(getLblPrecioParque());
			panelReservaParques.add(getTextFieldPrecioParqueSeleccionado());
			panelReservaParques.add(getBtnReservarParqueSeleccionadoTotal());
		}
		return panelReservaParques;
	}
	
	private JLabel getlblParqueAReservar() {
		if (lblParqueAReservar == null) {
			lblParqueAReservar = new JLabel();
			lblParqueAReservar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			lblParqueAReservar.setBounds(48, 25, 308, 56);
			
		}
		return lblParqueAReservar;
	}
	private JLabel getLblEntradasAdultos() {
		if (lblEntradasAdultos == null) {
			lblEntradasAdultos = new JLabel(textos.getString("numero_entradas_adulto"));
			lblEntradasAdultos.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			lblEntradasAdultos.setBounds(10, 106, 217, 49);
			lblEntradasAdultos.setDisplayedMnemonic('a');
	        lblEntradasAdultos.setLabelFor(getSpinnerNumeroEntradasAdulto());
		}
		return lblEntradasAdultos;
	}
	private JLabel getLblEntradasNinos() {
		if (lblEntradasNinos == null) {
			lblEntradasNinos = new JLabel(textos.getString("numero_entradas_nino"));
			lblEntradasNinos.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			lblEntradasNinos.setBounds(10, 165, 217, 49);
			lblEntradasNinos.setDisplayedMnemonic('n');
	        lblEntradasNinos.setLabelFor(getSpinnerNumeroEntradasNino());
		}
		return lblEntradasNinos;
	}
	private JSpinner getSpinnerNumeroEntradasAdulto() {
		if (spinnerNumeroEntradasAdulto == null) {
			spinnerNumeroEntradasAdulto = new JSpinner();
			spinnerNumeroEntradasAdulto.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			spinnerNumeroEntradasAdulto.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					as.setDatosParque((int)getSpinnerNumeroEntradasAdulto().getValue(), 
							(int)getSpinnerNumeroEntradasNino().getValue(), (int)getSpinnerNumeroDiasParque().getValue());
					getTextFieldPrecioParqueSeleccionado().setText(String.valueOf(as.getPrecioParque()));
					validarBotonReservaParque();
				}
			});
			spinnerNumeroEntradasAdulto.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
			spinnerNumeroEntradasAdulto.setBounds(228, 106, 46, 48);
		}
		return spinnerNumeroEntradasAdulto;
	}
	private JSpinner getSpinnerNumeroEntradasNino() {
		if (spinnerNumeroEntradasNino == null) {
			spinnerNumeroEntradasNino = new JSpinner();
			spinnerNumeroEntradasNino.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			spinnerNumeroEntradasNino.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					as.setDatosParque((int)getSpinnerNumeroEntradasAdulto().getValue(), 
							(int)getSpinnerNumeroEntradasNino().getValue(), (int)getSpinnerNumeroDiasParque().getValue());
					getTextFieldPrecioParqueSeleccionado().setText(String.valueOf(as.getPrecioParque()));
					validarBotonReservaParque();
				}
			});
			spinnerNumeroEntradasNino.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
			spinnerNumeroEntradasNino.setBounds(228, 165, 46, 48);
		}
		return spinnerNumeroEntradasNino;
	}
	private JLabel getLblNumeroDiasParque() {
		if (lblNumeroDiasParque == null) {
			lblNumeroDiasParque = new JLabel(textos.getString("numero_dias_parque"));
			lblNumeroDiasParque.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			lblNumeroDiasParque.setBounds(10, 224, 217, 49);
			lblNumeroDiasParque.setDisplayedMnemonic('d');
	        lblNumeroDiasParque.setLabelFor(getSpinnerNumeroDiasParque());
		}
		return lblNumeroDiasParque;
	}
	private JSpinner getSpinnerNumeroDiasParque() {
		if (spinnerNumeroDiasParque == null) {
			spinnerNumeroDiasParque = new JSpinner();
			spinnerNumeroDiasParque.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			spinnerNumeroDiasParque.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					as.setDatosParque((int)getSpinnerNumeroEntradasAdulto().getValue(), 
							(int)getSpinnerNumeroEntradasNino().getValue(), (int)getSpinnerNumeroDiasParque().getValue());
					getTextFieldPrecioParqueSeleccionado().setText(String.valueOf(as.getPrecioParque()));
					validarBotonReservaParque();
				}
			});
			spinnerNumeroDiasParque.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
			spinnerNumeroDiasParque.setBounds(228, 224, 46, 48);
		}
		return spinnerNumeroDiasParque;
	}
	private JLabel getLblPrecioParque() {
		if (lblPrecioParque == null) {
			lblPrecioParque = new JLabel(textos.getString("precio_del_parque"));
			lblPrecioParque.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			lblPrecioParque.setBounds(10, 297, 159, 49);
		}
		return lblPrecioParque;
	}
	private JTextField getTextFieldPrecioParqueSeleccionado() {
		if (textFieldPrecioParqueSeleccionado == null) {
			textFieldPrecioParqueSeleccionado = new JTextField();
			textFieldPrecioParqueSeleccionado.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			textFieldPrecioParqueSeleccionado.setHorizontalAlignment(SwingConstants.RIGHT);
			textFieldPrecioParqueSeleccionado.setText("0");
			textFieldPrecioParqueSeleccionado.setColumns(10);
			textFieldPrecioParqueSeleccionado.setBounds(178, 290, 96, 56);
		}
		return textFieldPrecioParqueSeleccionado;
	}
	private JLabel getlblFechaEntrada() {
		if (lblFechaEntrada == null) {
			lblFechaEntrada = new JLabel();
			lblFechaEntrada.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			lblFechaEntrada.setText(textos.getString("fecha_entrada_parque"));
			lblFechaEntrada.setBounds(366, 25, 180, 56);
		}
		return lblFechaEntrada;
	}
	private JTextField gettextFieldFechaReservada() {
		if (textFieldFechaReservada == null) {
			textFieldFechaReservada = new JTextField();
			textFieldFechaReservada.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			textFieldFechaReservada.setEditable(false);
			textFieldFechaReservada.setBounds(547, 25, 170, 56);
			actualizarFechaSeleccionadaParque();
		}
		return textFieldFechaReservada;
	}
	
	private JCalendar getCalendarFechaEntrada() {
	    if (calendarFechaEntrada == null) {
	        calendarFechaEntrada = new JCalendar();
	        calendarFechaEntrada.getYearChooser().getSpinner().setFont(new Font("Segoe UI", Font.PLAIN, 14));
	        calendarFechaEntrada.getMonthChooser().getSpinner().setFont(new Font("Segoe UI", Font.PLAIN, 14));
	        calendarFechaEntrada.setBorder(new LineBorder(new Color(0, 0, 0), 2));
	        calendarFechaEntrada.setBounds(380, 100, 370, 200);
	        calendarFechaEntrada.setWeekOfYearVisible(false);
	        calendarFechaEntrada.getDayChooser().setDecorationBackgroundVisible(false);
	        calendarFechaEntrada.setLocale(textos.getLocale());
	        calendarFechaEntrada.addPropertyChangeListener("calendar", new PropertyChangeListener() {
	        	
	            @Override
	            public void propertyChange(PropertyChangeEvent evt) {
	            	actualizarFechaSeleccionadaParque();
	            	validarBotonReservaParque();
	            }
	        });
	    }
	    return calendarFechaEntrada;
	}
	
	private void actualizarFechaSeleccionadaParque() {
		
	    Date fecha = getCalendarFechaEntrada().getDate();
	    
	    if (fecha != null) {
	        DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, textos.getLocale());
	        
	        gettextFieldFechaReservada().setText(df.format(fecha));
	    }
	}
	
    private void actualizarFechaSeleccionadaAlojamiento() {
		
	    Date fecha = getCalendarFechaEntradaAlojamiento().getDate();
	    
	    if (fecha != null) {
	        DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, textos.getLocale());
	        
	        gettextFieldFechaReservadaAlojamiento().setText(df.format(fecha));
	    }
	}
	
	private JButton getBtnReservarParqueSeleccionadoTotal() {
		if (btnReservarParqueSeleccionadoTotal == null) {
			btnReservarParqueSeleccionadoTotal = new JButton(textos.getString("reservar"));
			btnReservarParqueSeleccionadoTotal.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			btnReservarParqueSeleccionadoTotal.setEnabled(false);
			btnReservarParqueSeleccionadoTotal.setMnemonic('r');
			btnReservarParqueSeleccionadoTotal.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					as.setDateParque(getCalendarFechaEntrada().getDate());
					if(!getBtnFormalizarReserva().isEnabled()) {
						getBtnFormalizarReserva().setEnabled(true);
					}
					validarFormalizarReserva();
					((CardLayout) contentPane.getLayout()).show(contentPane, "panelReservarAlojamientoOParque");
				}
			});
			btnReservarParqueSeleccionadoTotal.setBounds(295, 382, 180, 56);
		}
		return btnReservarParqueSeleccionadoTotal;
	}
	

	protected void validarFormalizarReserva() {
		if(!((getBtnReservarAlojamiento().isEnabled() && as.getAlojamientoSeleccionado() != null)
				|| getBtnReservarParque().isEnabled() && as.getParqueSeleccionado() != null)) {
			if(!getBtnFormalizarReserva().isEnabled()) {
				getBtnFormalizarReserva().setEnabled(true);
			}
		}else {
			if(getBtnFormalizarReserva().isEnabled()) {
				getBtnFormalizarReserva().setEnabled(false);
			}
		}
		
	}

	private JPanel getPanelReservaAlojamientos() {
	    if (panelReservaAlojamientos == null) {
	        panelReservaAlojamientos = new JPanel();
	        panelReservaAlojamientos.setLayout(null);panelReservaAlojamientos.add(getlblAlojamientoAReservar());
	        panelReservaAlojamientos.add(getlblFechaEntradaAlojamiento());
	        panelReservaAlojamientos.add(gettextFieldFechaReservadaAlojamiento());
	        panelReservaAlojamientos.add(getCalendarFechaEntradaAlojamiento());
	        panelReservaAlojamientos.add(getLblPersonasAlojamiento());
	        panelReservaAlojamientos.add(getSpinnerNumeroPersonasAlojamiento());
	        panelReservaAlojamientos.add(getLblNumeroNoches());
	        panelReservaAlojamientos.add(getSpinnerNumeroNochesAlojamiento());
	        panelReservaAlojamientos.add(getLblPrecioAlojamiento());
	        panelReservaAlojamientos.add(getTextFieldPrecioAlojamientoSeleccionado());
	        panelReservaAlojamientos.add(getBtnReservarAlojamientoSeleccionadoTotal());
	        panelReservaAlojamientos.add(getLblHabitacionesAlojamiento());
	        panelReservaAlojamientos.add(getTextFieldNumeroHabitacionesAlojamiento());
	    }
	    return panelReservaAlojamientos;
	}

	private JLabel getlblAlojamientoAReservar() {
	    if (lblAlojamientoAReservar == null) {
	        lblAlojamientoAReservar = new JLabel();
	        lblAlojamientoAReservar.setBounds(10, 25, 308, 56);
	    }
	    return lblAlojamientoAReservar;
	}

	private JLabel getLblPersonasAlojamiento() {
	    if (lblPersonasAlojamiento == null) {
	        lblPersonasAlojamiento = new JLabel(textos.getString("numero_personas"));
	        lblPersonasAlojamiento.setFont(new Font("Segoe UI", Font.PLAIN, 14));
	        lblPersonasAlojamiento.setBounds(10, 106, 159, 49);
	        lblPersonasAlojamiento.setDisplayedMnemonic('p');
	        lblPersonasAlojamiento.setLabelFor(getSpinnerNumeroPersonasAlojamiento());
	    }
	    return lblPersonasAlojamiento;
	}

	private JSpinner getSpinnerNumeroPersonasAlojamiento() {
	    if (spinnerNumeroPersonasAlojamiento == null) {
	        spinnerNumeroPersonasAlojamiento = new JSpinner();
	        spinnerNumeroPersonasAlojamiento.setFont(new Font("Segoe UI", Font.PLAIN, 14));
	        spinnerNumeroPersonasAlojamiento.addChangeListener(new ChangeListener() {
	            public void stateChanged(ChangeEvent e) {
	            	
	                as.setDatosAlojamiento((int)getSpinnerNumeroPersonasAlojamiento().getValue(), 
	                        (int)getSpinnerNumeroNochesAlojamiento().getValue());
	                getTextFieldPrecioAlojamientoSeleccionado().setText(String.valueOf(as.getPrecioAlojamiento()));
	                getTextFieldNumeroHabitacionesAlojamiento().setText(as.getHabitacionesAlojamiento());
	                validarReservaAlojamiento();
	            }
	        });
	        spinnerNumeroPersonasAlojamiento.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
	        spinnerNumeroPersonasAlojamiento.setBounds(216, 107, 46, 48);
	    }
	    return spinnerNumeroPersonasAlojamiento;
	}

	private JLabel getLblNumeroNoches() {
	    if (lblNumeroNoches == null) {
	        lblNumeroNoches = new JLabel(textos.getString("numero_noches"));
	        lblNumeroNoches.setFont(new Font("Segoe UI", Font.PLAIN, 14));
	        lblNumeroNoches.setBounds(10, 165, 159, 49);
	        lblNumeroNoches.setDisplayedMnemonic('n');
	        lblNumeroNoches.setLabelFor(getSpinnerNumeroNochesAlojamiento());
	    }
	    return lblNumeroNoches;
	}

	private JSpinner getSpinnerNumeroNochesAlojamiento() {
	    if (spinnerNumeroNochesAlojamiento == null) {
	        spinnerNumeroNochesAlojamiento = new JSpinner();
	        spinnerNumeroNochesAlojamiento.setFont(new Font("Segoe UI", Font.PLAIN, 14));
	        spinnerNumeroNochesAlojamiento.addChangeListener(new ChangeListener() {
	            public void stateChanged(ChangeEvent e) {
	                as.setDatosAlojamiento((int)getSpinnerNumeroPersonasAlojamiento().getValue(), 
	                        (int)getSpinnerNumeroNochesAlojamiento().getValue());
	                getTextFieldPrecioAlojamientoSeleccionado().setText(String.valueOf(as.getPrecioAlojamiento()));
	                validarReservaAlojamiento();
	            }
	        });
	        spinnerNumeroNochesAlojamiento.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
	        spinnerNumeroNochesAlojamiento.setBounds(216, 166, 46, 48);
	    }
	    return spinnerNumeroNochesAlojamiento;
	}

	protected void validarReservaAlojamiento() {
		if((int)getSpinnerNumeroPersonasAlojamiento().getValue() > 0 && (int)getSpinnerNumeroNochesAlojamiento().getValue() > 0
				&& !getBtnReservarAlojamientoSeleccionadoTotal().isEnabled()) {
			getBtnReservarAlojamientoSeleccionadoTotal().setEnabled(true);
		}
		
	}

	private JLabel getLblPrecioAlojamiento() {
	    if (lblPrecioAlojamiento == null) {
	        lblPrecioAlojamiento = new JLabel(textos.getString("precio_del_alojamiento"));
	        lblPrecioAlojamiento.setFont(new Font("Segoe UI", Font.PLAIN, 14));
	        lblPrecioAlojamiento.setBounds(10, 300, 159, 49);
	    }
	    return lblPrecioAlojamiento;
	}

	private JTextField getTextFieldPrecioAlojamientoSeleccionado() {
	    if (textFieldPrecioAlojamientoSeleccionado == null) {
	        textFieldPrecioAlojamientoSeleccionado = new JTextField();
	        textFieldPrecioAlojamientoSeleccionado.setFont(new Font("Segoe UI", Font.PLAIN, 14));
	        textFieldPrecioAlojamientoSeleccionado.setHorizontalAlignment(SwingConstants.RIGHT);
	        textFieldPrecioAlojamientoSeleccionado.setText("0");
	        textFieldPrecioAlojamientoSeleccionado.setColumns(10);
	        textFieldPrecioAlojamientoSeleccionado.setBounds(178, 297, 96, 56);
	    }
	    return textFieldPrecioAlojamientoSeleccionado;
	}

	private JLabel getlblFechaEntradaAlojamiento() {
	    if (lblFechaEntradaAlojamiento == null) {
	        lblFechaEntradaAlojamiento = new JLabel();
	        lblFechaEntradaAlojamiento.setFont(new Font("Segoe UI", Font.PLAIN, 14));
	        lblFechaEntradaAlojamiento.setText(textos.getString("fecha_entrada_alojamiento"));
	        lblFechaEntradaAlojamiento.setBounds(347, 25, 239, 56);
	    }
	    return lblFechaEntradaAlojamiento;
	}

	private JTextField gettextFieldFechaReservadaAlojamiento() {
	    if (textFieldFechaReservadaAlojamiento == null) {
	        textFieldFechaReservadaAlojamiento = new JTextField();
	        textFieldFechaReservadaAlojamiento.setFont(new Font("Segoe UI", Font.PLAIN, 14));
	        textFieldFechaReservadaAlojamiento.setEditable(false);
	        textFieldFechaReservadaAlojamiento.setText((String) null);
	        textFieldFechaReservadaAlojamiento.setBounds(584, 25, 170, 56);
	        actualizarFechaSeleccionadaAlojamiento();
	    }
	    return textFieldFechaReservadaAlojamiento;
	}

	private JCalendar getCalendarFechaEntradaAlojamiento() {
	    if (calendarFechaEntradaAlojamiento == null) {
	        calendarFechaEntradaAlojamiento = new JCalendar();
	        calendarFechaEntradaAlojamiento.setBorder(new LineBorder(new Color(0, 0, 0), 2));
	        calendarFechaEntradaAlojamiento.setBounds(380, 100, 370, 200);
	        calendarFechaEntradaAlojamiento.setWeekOfYearVisible(false);
	        calendarFechaEntradaAlojamiento.getDayChooser().setDecorationBackgroundVisible(false);
	        calendarFechaEntradaAlojamiento.setLocale(textos.getLocale());
	        calendarFechaEntradaAlojamiento.addPropertyChangeListener("calendar", new PropertyChangeListener() {
	            @Override
	            public void propertyChange(PropertyChangeEvent evt) {
	                actualizarFechaSeleccionadaAlojamiento();
	            }
	        });
	    }
	    return calendarFechaEntradaAlojamiento;
	}

	

	private JButton getBtnReservarAlojamientoSeleccionadoTotal() {
	    if (btnReservarAlojamientoSeleccionadoTotal == null) {
	        btnReservarAlojamientoSeleccionadoTotal = new JButton(textos.getString("reservar"));
	        btnReservarAlojamientoSeleccionadoTotal.setFont(new Font("Segoe UI", Font.PLAIN, 14));
	        btnReservarAlojamientoSeleccionadoTotal.setEnabled(false);
	        btnReservarAlojamientoSeleccionadoTotal.setMnemonic('r');
	        btnReservarAlojamientoSeleccionadoTotal.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		as.setDateAlojamiento(getCalendarFechaEntradaAlojamiento().getDate());
	        		if(!getBtnFormalizarReserva().isEnabled()) {
						getBtnFormalizarReserva().setEnabled(true);
					}
	        		validarFormalizarReserva();
					((CardLayout) contentPane.getLayout()).show(contentPane, "panelReservarAlojamientoOParque");
	        	}
	        });
	        btnReservarAlojamientoSeleccionadoTotal.setBounds(295, 382, 180, 56);
	    }
	    return btnReservarAlojamientoSeleccionadoTotal;
	}
	
	private boolean checkReservaParque() {
		boolean checkPersonas = (int)getSpinnerNumeroEntradasAdulto().getValue() > 0 || (int)(getSpinnerNumeroEntradasNino().getValue()) > 0;
		boolean checkDias = (int)getSpinnerNumeroDiasParque().getValue() > 0;
		
		return checkPersonas && checkDias;
	}
	
	private void validarBotonReservaParque() {
	    boolean cumpleRequisitos = checkReservaParque();
	    getBtnReservarParqueSeleccionadoTotal().setEnabled(cumpleRequisitos);
	}
	
	
	
	
	private JPanel getPanelConfirmarReserva() {
		if (panelConfirmarReserva == null) {
			panelConfirmarReserva = new JPanel();
			panelConfirmarReserva.setLayout(null);
			panelConfirmarReserva.add(getLblNombreCliente());
	        panelConfirmarReserva.add(getLblApellidosCliente());
	        panelConfirmarReserva.add(getLblDNI());
	        panelConfirmarReserva.add(getLblPrecioFinal());
	        panelConfirmarReserva.add(getLblComentario());
	        panelConfirmarReserva.add(getLblJustificante());
	        panelConfirmarReserva.add(getTextFieldNombreCliente());
	        panelConfirmarReserva.add(getTextFieldApellidosCliente());
	        panelConfirmarReserva.add(getTextFieldDNICliente());
	        panelConfirmarReserva.add(getScrollComentario());
	        panelConfirmarReserva.add(getBtnConfirmarReserva());
	        panelConfirmarReserva.add(getBtnCancelarReserva());
	        panelConfirmarReserva.add(getTextFieldPrecio());           
	        panelConfirmarReserva.add(getScrollPaneJustificacionReserva());
		}
		
		return panelConfirmarReserva;
	}
	private JLabel getLblNombreCliente() {
		if (lblNombreCliente == null) {
			lblNombreCliente = new JLabel(textos.getString("nombre") + " *:");
			lblNombreCliente.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			lblNombreCliente.setBounds(10, 74, 105, 49);
			lblNombreCliente.setDisplayedMnemonic('n');
	        lblNombreCliente.setLabelFor(getTextFieldNombreCliente());
		}
		return lblNombreCliente;
	}
	private JLabel getLblApellidosCliente() {
		if (lblApellidosCliente == null) {
			lblApellidosCliente = new JLabel(textos.getString("apellidos")+ " *:");
			lblApellidosCliente.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			lblApellidosCliente.setBounds(10, 136, 130, 49);
			lblApellidosCliente.setDisplayedMnemonic('a');
	        lblApellidosCliente.setLabelFor(getTextFieldApellidosCliente());
		}
		return lblApellidosCliente;
	}
	private JLabel getLblDNI() {
		if (lblDNI == null) {
			lblDNI = new JLabel(textos.getString("dni") + " *:");
			lblDNI.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			lblDNI.setBounds(10, 208, 105, 49);
			lblDNI.setDisplayedMnemonic('d');
	        lblDNI.setLabelFor(getTextFieldDNICliente());
		}
		return lblDNI;
	}
	private JLabel getLblPrecioFinal() {
		if (lblPrecioFinal == null) {
			lblPrecioFinal = new JLabel(textos.getString("precio"));
			lblPrecioFinal.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			lblPrecioFinal.setBounds(238, 74, 130, 49);
		}
		return lblPrecioFinal;
	}
	private JLabel getLblComentario() {
		if (lblComentario == null) {
			lblComentario = new JLabel(textos.getString("comentario"));
			lblComentario.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			lblComentario.setBounds(238, 155, 130, 49);
			lblComentario.setDisplayedMnemonic('m');
	        lblComentario.setLabelFor(getTextAreaComentario());
		}
		return lblComentario;
	}
	private JTextArea getTextAreaComentario() {
		if (textAreaComentario == null) {
			textAreaComentario = new JTextArea();
			textAreaComentario.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			textAreaComentario.setLineWrap(true);
			textAreaComentario.setBounds(238, 209, 224, 142);
		}
		return textAreaComentario;
	}
	private JTextArea getTextAreaResumenJustificacion() {
		if (textAreaResumenJustificacion == null) {
			textAreaResumenJustificacion = new JTextArea();
			textAreaResumenJustificacion.setFont(new Font("Segoe UI", Font.PLAIN, 12));
			textAreaResumenJustificacion.setEditable(false);
			textAreaResumenJustificacion.setBounds(232, 183, 302, 318);
			actualizarTextoResumen();
		}
		return textAreaResumenJustificacion;
	}
	private JLabel getLblJustificante() {
		if (lblJustificante == null) {
			lblJustificante = new JLabel(textos.getString("justificante"));
			lblJustificante.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			lblJustificante.setBounds(544, 44, 130, 49);
		}
		return lblJustificante;
	}
	private JButton getBtnConfirmarReserva() {
		if (btnConfirmarReserva == null) {
			btnConfirmarReserva = new JButton(textos.getString("confirmar"));
			btnConfirmarReserva.setForeground(new Color(4, 166, 0));
			btnConfirmarReserva.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			btnConfirmarReserva.setEnabled(false);
			btnConfirmarReserva.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					as.getReserva().setCliente(getTextFieldNombreCliente().getText() + " " + getTextFieldApellidosCliente().getText(), getTextFieldDNICliente().getText());
					ponerCasillas();
					getRootPane().setDefaultButton(null);
					as.getReserva().setComentarioCliente(getTextAreaComentario().getText());
					((CardLayout) contentPane.getLayout()).show(contentPane, "panelMinijuego");
				}
			});
			btnConfirmarReserva.setBounds(73, 388, 161, 48);
		}
		return btnConfirmarReserva;
	}
	private JButton getBtnCancelarReserva() {
		if (btnCancelarReserva == null) {
			btnCancelarReserva = new JButton(textos.getString("cancelar"));
			btnCancelarReserva.setForeground(new Color(255, 0, 0));
			btnCancelarReserva.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			btnCancelarReserva.setMnemonic('c');
			btnCancelarReserva.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					reiniciar();
				}
			});
			btnCancelarReserva.setBounds(277, 388, 161, 48);
		}
		return btnCancelarReserva;
	}
	private JTextField getTextFieldNombreCliente() {
		if (textFieldNombreCliente == null) {
			textFieldNombreCliente = new JTextField();
			textFieldNombreCliente.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			textFieldNombreCliente.addFocusListener(validarFoco);
			textFieldNombreCliente.setBounds(90, 74, 123, 48);
			textFieldNombreCliente.setColumns(10);
		}
		return textFieldNombreCliente;
	}
	private JTextField getTextFieldApellidosCliente() {
		if (textFieldApellidosCliente == null) {
			textFieldApellidosCliente = new JTextField();
			textFieldApellidosCliente.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			textFieldApellidosCliente.addFocusListener(validarFoco);
			textFieldApellidosCliente.setColumns(10);
			textFieldApellidosCliente.setBounds(90, 137, 123, 48);
		}
		return textFieldApellidosCliente;
	}
	private JTextField getTextFieldDNICliente() {
		if (textFieldDNICliente == null) {
			textFieldDNICliente = new JTextField();
			textFieldDNICliente.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			textFieldDNICliente.addFocusListener(validarFoco);
			textFieldDNICliente.setColumns(10);
			textFieldDNICliente.setBounds(90, 209, 123, 48);
		}
		return textFieldDNICliente;
	}
	private JTextField getTextFieldPrecio() {
		if (textFieldPrecio == null) {
			textFieldPrecio = new JTextField();
			textFieldPrecio.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			textFieldPrecio.setHorizontalAlignment(SwingConstants.RIGHT);
			textFieldPrecio.setEditable(false);
			textFieldPrecio.setColumns(10);
			textFieldPrecio.setBounds(339, 74, 123, 48);
			textFieldPrecio.setText(String.valueOf(as.getImporteTotal()));
		}
		return textFieldPrecio;
	}
	
	private void actualizarTextoResumen() {
		String nombre = getTextFieldNombreCliente().getText();
		String apellidos = getTextFieldApellidosCliente().getText();
		String dni = getTextFieldDNICliente().getText();
		
		String justificacion = as.actualizarTextoResumen(textos, nombre, apellidos, dni);
		
		getTextAreaResumenJustificacion().setText(justificacion);
	}
	private JScrollPane getScrollPaneJustificacionReserva() {
		if (scrollPaneJustificacionReserva == null) {
			scrollPaneJustificacionReserva = new JScrollPane();
			scrollPaneJustificacionReserva.setBounds(526, 124, 340, 334);
			scrollPaneJustificacionReserva.setViewportView(getTextAreaResumenJustificacion());
		}
		return scrollPaneJustificacionReserva;
	}
	private JPanel getPanelMiniJuego() {
		if (panelMiniJuego == null) {
			panelMiniJuego = new JPanel();
			panelMiniJuego.setLayout(null);
			panelMiniJuego.add(getLblIntroMinijuego());
			panelMiniJuego.add(getPanelCasillasJuego());
		}
		return panelMiniJuego;
	}
	private JLabel getLblIntroMinijuego() {
		if (lblIntroMinijuego == null) {
			lblIntroMinijuego = new JLabel(textos.getString("introduccion_minijuego"));
			lblIntroMinijuego.setFont(new Font("Segoe UI", Font.BOLD, 16));
			lblIntroMinijuego.setBounds(82, 89, 604, 77);
		}
		return lblIntroMinijuego;
	}
	private JPanel getPanelCasillasJuego() {
		if (panelCasillasJuego == null) {
			panelCasillasJuego = new JPanel();
			panelCasillasJuego.setBorder(new LineBorder(new Color(128, 0, 64), 5));
			panelCasillasJuego.setBounds(186, 209, 537, 167);
			panelCasillasJuego.setLayout(new GridLayout(0, AgenciaService.NUMERO_CASILLAS, 0, 0));
			
		}
		return panelCasillasJuego;
	}
	
	private void ponerCasillas() {
		getPanelCasillasJuego().removeAll();
		for(int i = 0; i< AgenciaService.NUMERO_CASILLAS ;i++) {
			getPanelCasillasJuego().add(nuevoBoton(i));
		}
		
		getPanelCasillasJuego().revalidate();
	    getPanelCasillasJuego().repaint();
		
	}

	private JButton nuevoBoton(int i) {
		JButton btn = new JButton("");
		btn.setActionCommand(String.valueOf(i));
		btn.setToolTipText(textos.getString("click_desbloquear"));
		btn.addActionListener(listenerJuego);
		btn.setBorder(new LineBorder(new Color(128, 0, 64), 5));
		adaptarImagenBoton(btn, "regalo", 130, 180);
		return btn;
	}
	
	private void cargaAyuda() {

		URL hsURL;
		HelpSet hs;

		try {
			File fichero = new File("help/ayuda.hs");
			hsURL = fichero.toURI().toURL();
			hs = new HelpSet(null, hsURL);
		}

		catch (Exception e) {
			JOptionPane.showMessageDialog(this, textos.getString("error_ayuda"), textos.getString("titulo_error"),
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		HelpBroker hb = hs.createHelpBroker();
		hb.initPresentation();

		hb.enableHelpKey(getRootPane(), "intro", hs);
	}
	
	private void validarBotonConfirmar() {
		String nombre = getTextFieldNombreCliente().getText();
		String apellidos = getTextFieldApellidosCliente().getText();
		String dni = getTextFieldDNICliente().getText();

		boolean camposValidos = !nombre.isEmpty() && !apellidos.isEmpty() && !dni.isEmpty();

		getBtnConfirmarReserva().setEnabled(camposValidos);
	}
	private JScrollPane getScrollComentario() {
		if (scrollComentario == null) {
			scrollComentario = new JScrollPane();
			scrollComentario.setBounds(238, 209, 224, 142);
			scrollComentario.setViewportView(getTextAreaComentario());
		}
		return scrollComentario;
	}
	private JScrollPane getScrollInfoParques() {
		if (scrollInfoParques == null) {
			scrollInfoParques = new JScrollPane();
			scrollInfoParques.setBounds(412, 175, 335, 204);
			scrollInfoParques.setViewportView(getTextAreaInfoParques());
		}
		return scrollInfoParques;
	}
	private JScrollPane getScrollDescAlojamiento() {
		if (scrollDescAlojamiento == null) {
			scrollDescAlojamiento = new JScrollPane();
			scrollDescAlojamiento.setBounds(415, 185, 295, 108);
			scrollDescAlojamiento.setViewportView(getTextAreaDescAlojamiento());
		}
		return scrollDescAlojamiento;
	}
	private JScrollPane getScrollDescParqueSeleccionado() {
		if (scrollDescParqueSeleccionado == null) {
			scrollDescParqueSeleccionado = new JScrollPane();
			scrollDescParqueSeleccionado.setBounds(46, 68, 314, 130);
			scrollDescParqueSeleccionado.setViewportView(getTextAreaDescParqueSeleccionado());
		}
		return scrollDescParqueSeleccionado;
	}
	private JScrollPane getScrollDescAlojamientoSelccionado() {
		if (scrollDescAlojamientoSelccionado == null) {
			scrollDescAlojamientoSelccionado = new JScrollPane();
			scrollDescAlojamientoSelccionado.setBounds(56, 63, 308, 144);
			scrollDescAlojamientoSelccionado.setViewportView(getTextAreaDescAlojamientoSeleccionado());
		}
		return scrollDescAlojamientoSelccionado;
	}
	private JLabel getLblHabitacionesAlojamiento() {
		if (lblHabitacionesAlojamiento == null) {
			lblHabitacionesAlojamiento = new JLabel(textos.getString("habitaciones"));
			lblHabitacionesAlojamiento.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			lblHabitacionesAlojamiento.setBounds(10, 224, 159, 49);
		}
		return lblHabitacionesAlojamiento;
	}
	private JTextField getTextFieldNumeroHabitacionesAlojamiento() {
		if (textFieldNumeroHabitacionesAlojamiento == null) {
			textFieldNumeroHabitacionesAlojamiento = new JTextField();
			textFieldNumeroHabitacionesAlojamiento.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			textFieldNumeroHabitacionesAlojamiento.setHorizontalAlignment(SwingConstants.RIGHT);
			textFieldNumeroHabitacionesAlojamiento.setText("0");
			textFieldNumeroHabitacionesAlojamiento.setColumns(10);
			textFieldNumeroHabitacionesAlojamiento.setBounds(178, 224, 96, 56);
		}
		return textFieldNumeroHabitacionesAlojamiento;
	}
}




