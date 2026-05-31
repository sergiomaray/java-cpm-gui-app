package uo.cpm.modulo;

import java.awt.EventQueue;

import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.UIManager;

import uo.cpm.modulo.service.*;
import uo.cpm.modulo.ui.VentanaPrincipal;

public class Main {

	public static void main(String[] args) {
		final AgenciaService as = new AgenciaService();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(new FlatLightLaf());
					UIManager.put("Component.hideMnemonics", false);
					VentanaPrincipal frame = new VentanaPrincipal(as);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}