package uo.cpm.modulo.ui;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import uo.cpm.modulo.model.Alojamiento;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelAlojamiento extends JPanel{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private VentanaPrincipal vp;
	private Alojamiento alojamiento;
	private JLabel lblDenominacion;
	private JLabel lblFotoAlojamiento;
	private JPanel panelSeleccionar;
	private JButton btnSeleccionar;
	private JLabel lblTipo;
	private JLabel lblEstrellas;
	private JLabel lblPrecio;

	public PanelAlojamiento(VentanaPrincipal vp,  Alojamiento alojamiento) {
		this.vp = vp;
		this.alojamiento = alojamiento;
		
		setBorder(new LineBorder(Color.LIGHT_GRAY, 1));
		setBackground(Color.white);
		
		setPreferredSize(new Dimension(500, 110));
		setLayout(new GridLayout(0, 6, 0, 0));
		add(getLblDenominacion());
		add(getLblFotoAlojamiento());
		add(getLblTipo());
		add(getLblEstrellas());
		add(getLblPrecio());
		add(getPanelSeleccionar());
		
		
	}
	
	private JLabel getLblDenominacion() {
		if (lblDenominacion == null) {
			lblDenominacion = new JLabel(alojamiento.getDenominacion());
			
		}
		return lblDenominacion;
	}
	private JLabel getLblFotoAlojamiento() {
		if (lblFotoAlojamiento == null) {
			lblFotoAlojamiento = new JLabel("");
			vp.adaptarImagenLabel(lblFotoAlojamiento, alojamiento.getCodigo(), 90, 90);
			
		}
		return lblFotoAlojamiento;
	}
	private JPanel getPanelSeleccionar() {
		if (panelSeleccionar == null) {
			panelSeleccionar = new JPanel();
			panelSeleccionar.setLayout(new GridBagLayout());
			panelSeleccionar.add(getBtnSeleccionar());
		}
		return panelSeleccionar;
	}
	private JButton getBtnSeleccionar() {
		if (btnSeleccionar == null) {
			btnSeleccionar = new JButton(vp.getTextos().getString("seleccionar"));
			btnSeleccionar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					vp.setAlojamientoSeleccionado(alojamiento);
					vp.seleccionarAlejamientoSeleccionado();
				}
			});
		}
		return btnSeleccionar;
	}
	private JLabel getLblTipo() {
		if (lblTipo == null) {
			lblTipo = new JLabel(getTipo());
		}
		return lblTipo;
	}
	private String getTipo() {
		switch(alojamiento.getTipo()) {
			case "HO":
				return vp.getTextos().getString("hotel");
			case "AH":
				return vp.getTextos().getString("apartahotel");
			case "AP":
				return vp.getTextos().getString("apartamento");
		}
		return null;
	}

	private JLabel getLblEstrellas() {
		if (lblEstrellas == null) {
			lblEstrellas = new JLabel(String.valueOf(alojamiento.getCategoria()) + " " + vp.getTextos().getString("estrellas"));
		}
		return lblEstrellas;
	}
	private JLabel getLblPrecio() {
		if (lblPrecio == null) {
			lblPrecio = new JLabel(alojamiento.getPrecio() + " " + vp.getTextos().getString("moneda"));
		}
		return lblPrecio;
	}
}
