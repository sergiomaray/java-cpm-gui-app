package uo.cpm.modulo.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import uo.cpm.modulo.util.FileUtil;

/*
 * Clase agencia que carga todos los parques y alojamientos y los guarda en dos listas diferentes.
 * Además calcula el parque en oferta actual.
 */
public class Agencia {
	
	private List<Parque> listaParques;
	private List<Alojamiento> listaAlojamientos;
	private Parque parqueEnOferta;
	
	public Agencia() {
		listaParques = new ArrayList<>();
		listaAlojamientos = new ArrayList<>();
		
	}

	public void recargarDatos(String ficheroParque, String ficheroAlojamiento) {
		String codigoOferta = null;
		if(parqueEnOferta != null) {
			codigoOferta = parqueEnOferta.getCodigo();
		}
		
		//recargamos ficheros
		listaParques.clear();
		listaAlojamientos.clear();
		FileUtil.loadFile(ficheroParque, ficheroAlojamiento, listaParques, listaAlojamientos);
		
		if(codigoOferta == null) {
			parqueOferta();			//si es la primera vez que abrimos la app creamos parque en oferta aleatoriamente
		}else {
			
			Parque rescatado = getParquePorCodigo(codigoOferta);
			
			if(rescatado != null) {
				parqueEnOferta = rescatado;
			}else {
				parqueOferta();				//si el parque e¡que estaba en oferta ya no está, buscamos otro por si cambiais los ficheros
			}
		}
		
	}
	
	/*
	 * Determina que parque esta en oferta sacando un numero aleatorio entre 0 y parques.size()-1
	 * la posicion que salga sera el parque en oferta
	 */
	private void parqueOferta() {
		if(!listaParques.isEmpty()) {
			Random r = new Random();
			int pos = r.nextInt(listaParques.size());
			parqueEnOferta = listaParques.get(pos);
		}
		
	}
	
	public List<Parque> getListaParques(){
		return this.listaParques;
	}
	
	public List<Alojamiento> getListaAlojamientos(){
		return this.listaAlojamientos;
	}
	
	public Parque getParqueEnOferta() {
		return this.parqueEnOferta;
	}
	
	/*
	 * Método que dado el codigo de un parque devuelve una lista de  todos los alojamientos que 
	 * tiene asociados
	 */
	public List<Alojamiento> getAlojamientosDeParque(String codigoParque){
		List<Alojamiento> alojamientosParque = new ArrayList<>();
		for(Alojamiento alo: this.listaAlojamientos) {
			if(alo.getCodigoParque().equals(codigoParque)) {
				alojamientosParque.add(alo);
			}
		}
		
		return alojamientosParque;
	}
	
	/*
	 * Método que dado el codigo de un parque devuelve ese parque
	 */
	public Parque getParquePorCodigo(String code) {
		for(Parque parq: this.listaParques) {
			if(parq.getCodigo().equals(code)) {
				return parq;
			}
		}
		return null;
	}
	
	/*
	 * Método que devuelve un array de todos los paises (para el combobox del filtro de pais de el panelParques)
	 * Antes de cambiar el arrayList a array usamos Collections.sort() para ordenar alfabeticamente el comboBox
	 */
	public String[] getPaises() {
		List<String> paises = new ArrayList<String>();
		for(Parque par: listaParques) {
			if(!paises.contains(par.getPais())) {
				paises.add(par.getPais());
			}
		}
		Collections.sort(paises);
		paises.add(0, "-");
		return paises.toArray(new String[0]);
	}
	
	/*
	 * Método que devuelve un array de todas las localidades del pais pasado como parámetro
	 * (para el combobox del filtro de localidad de el panelParques)
	 * Antes de cambiar el arrayList a array usamos Collections.sort() para ordenar alfabeticamente el comboBox
	 */
	public String[] getLocalidades(String pais) {
		if(pais.equals("-")) {
			String[] res = new String[1];
			res[0] = "-";
			return res;
		}
		List<String> localidades = new ArrayList<String>();
		for(Parque par: listaParques) {
			if(par.getPais().equals(pais) && !localidades.contains(par.getLocalidad())) {
				localidades.add(par.getLocalidad());
			}
		}
		Collections.sort(localidades);
		localidades.add(0, "-");
		return localidades.toArray(new String[0]);
	}

	/*
	 * Método que dado un alojamiento devuelve la denominacion de su parque asociado
	 */
	public String getParqueDelAlojamiento(Alojamiento a) {
		for(Parque p: listaParques) {
			if(a.getCodigoParque().equals(p.getCodigo())) {
				return p.getDenominacion();
			}
		}
		return null;
	}
}
