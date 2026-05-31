package uo.cpm.modulo.ui;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import uo.cpm.modulo.model.Parque;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelParque extends JPanel{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private VentanaPrincipal vp;
	private Parque parque;
	private JLabel lblDenominacion;
	private JLabel lblFotoParque;
	private JLabel lblPrecio;
	private boolean enDescuento;
	private JLabel lblUbicacion;
	private JPanel panelSeleccionar;
	private JButton btnSeleccionar;

	public PanelParque(VentanaPrincipal vp,  Parque parque) {
		this.vp = vp;
		this.parque = parque;
		this.enDescuento = vp.getAgenciaService().esParqueEnOferta(parque);
		
		setBorder(new LineBorder(Color.LIGHT_GRAY, 1));
		setBackground(Color.white);
		
		setPreferredSize(new Dimension(500, 110));
		setLayout(new GridLayout(1, 5, 0, 0));
		add(getLblDenominacion());
		add(getLblFotoParque());
		add(getLblUbicacion());
		add(getLblPrecio());
		add(getPanelSeleccionar());
		
		
	}
	
	private JLabel getLblDenominacion() {
		if (lblDenominacion == null) {
			lblDenominacion = new JLabel(parque.getDenominacion());
			if(enDescuento) {
				lblDenominacion.setForeground(Color.RED);
			}
			
		}
		return lblDenominacion;
	}
	private JLabel getLblFotoParque() {
		if (lblFotoParque == null) {
			lblFotoParque = new JLabel("");
			vp.adaptarImagenLabel(lblFotoParque, parque.getCodigo(), 90, 90);
			
		}
		return lblFotoParque;
	}
	
	private JLabel getLblPrecio() {
		if (lblPrecio == null) {
			lblPrecio = new JLabel("(" + parque.getPrecioAdulto() + " " + vp.getTextos().getString("moneda")
					+ " "  + "|" + parque.getPrecioNino() + " " + vp.getTextos().getString("moneda") + ")");
			if(enDescuento) {
				lblPrecio.setForeground(Color.RED);
			}
		}
		return lblPrecio;
	}
	private JLabel getLblUbicacion() {
		if (lblUbicacion == null) {
			lblUbicacion = new JLabel(parque.getPais() + " -> " + parque.getLocalidad());
			if(enDescuento) {
				lblUbicacion.setForeground(Color.RED);
			}
		}
		return lblUbicacion;
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
					vp.setParquedSelected(parque);
					vp.seleccionarParqueSeleccionado();
				}
			});
			if(enDescuento) {
				btnSeleccionar.setForeground(Color.RED);
			}
		}
		return btnSeleccionar;
	}
}
