package uo.cpm.modulo.util;

import java.io.*;
import java.util.*;

import uo.cpm.modulo.model.Alojamiento;
import uo.cpm.modulo.model.Parque;


public abstract class FileUtil {

	public static void loadFile(String nombreFicheroEntradaParques, String nombreFicheroEntradaAlojamientos,
								List<Parque> parques, List<Alojamiento> alojamientos) {

		String linea;
		String[] datosParque = null;
		String[] datosAlojamiento = null;

		try {
			BufferedReader fichero = new BufferedReader(new FileReader(nombreFicheroEntradaParques));
			while (fichero.ready()) {
				linea = fichero.readLine();
				datosParque = linea.split("@");
				parques.add(new Parque(datosParque[0], datosParque[1], datosParque[2], datosParque[3], 
						datosParque[4], Double.parseDouble(datosParque[5]), Double.parseDouble(datosParque[6])));
			}
			fichero.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("El archivo no se ha encontrado.");
		} catch (IOException ioe) {
			new RuntimeException("Error de entrada/salida.");
		}
		
		try {
			BufferedReader fichero = new BufferedReader(new FileReader(nombreFicheroEntradaAlojamientos));
			while (fichero.ready()) {
				linea = fichero.readLine();
				datosAlojamiento = linea.split("@");
				alojamientos.add(new Alojamiento(datosAlojamiento[0], datosAlojamiento[1], Integer.parseInt(datosAlojamiento[2])
						, datosAlojamiento[3], datosAlojamiento[4], Double.parseDouble(datosAlojamiento[5])));
			}
			fichero.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("El archivo no se ha encontrado.");
		} catch (IOException ioe) {
			new RuntimeException("Error de entrada/salida.");
		}
	}

	public static void saveToFile(String contenido, String nombre) {
		try {
			BufferedWriter fichero = new BufferedWriter(new FileWriter("files/" + nombre + ".dat"));
			fichero.write(contenido);
			fichero.close();
		}

		catch (FileNotFoundException fnfe) {
			System.out.println("El archivo no se ha podido guardar");
		} catch (IOException ioe) {
			new RuntimeException("Error de entrada/salida");
		}
	}
}
