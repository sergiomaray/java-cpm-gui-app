package uo.cpm.modulo.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import uo.cpm.modulo.model.*;
import uo.cpm.modulo.util.FileUtil;

/*
 * clase agecia que contiene una agencia de la que sacar los alojamientos, parques y el parque en oferta
 * y una clase reserva donde se modifican los datos de la reserva actual
 */
public class AgenciaService {

	public static final int NUMERO_CASILLAS = 5;
	private Agencia agencia;
	private Reserva reserva;
	
	private boolean premioConseguido;
	
	public AgenciaService() {
		this.agencia = new Agencia();
		this.reserva = new Reserva();
		premioConseguido = false;
	}
	
	public List<Parque> getParques(){
		return agencia.getListaParques();
	}
	
	public List<Alojamiento> getAlojamientosDeParqueSeleccionado(){
		List<Alojamiento> alojas = new ArrayList<>();
		if(reserva.getParqueSeleccionado() != null) {
			alojas = agencia.getAlojamientosDeParque(reserva.getParqueSeleccionado().getCodigo());
		}
		
		return alojas;
	}
	
	public void inicializarDatos(String fParques, String fAlojamientos) {
		agencia.recargarDatos(fParques, fAlojamientos);
		reserva.inicializar();
	}
	
	public void setParqueSeleccionado(Parque sel) {
		reserva.setParqueSeleccionado(sel);
	}
	
	public Parque getParqueSeleccionado() {
		return reserva.getParqueSeleccionado();
	}
	
	public void setAlojamientoSeleccionado(Alojamiento sel) {
		reserva.setAlojamientoSeleccionado(sel);
	}
	
	public boolean esParqueEnOferta(Parque sel) {
		return agencia.getParqueEnOferta().equals(sel);
	}
	
	public double getImporteTotal() {
		return reserva.getImporteTotal(agencia.getParqueEnOferta());
	}
	
	
	
	public Reserva getReserva() {
		return this.reserva;
	}
	
	public Parque getParqueEnOferta() {
		return agencia.getParqueEnOferta();
	}
	
	public Agencia getAgencia() {
		return this.agencia;
	}
	
	public List<Alojamiento> getAlojamientos(){
		return agencia.getListaAlojamientos();
	}

	public Alojamiento getAlojamientoSeleccionado() {
		return reserva.getAlojamientoSeleccionado();
	}
	
	public void iniciarNuevaReserva() {
	    this.reserva.inicializar(); 
	}
	
	public void setDatosParque(int adultos, int ninos, int dias) {
		reserva.setDatosParque(adultos, ninos, dias);
	}

	public double getPrecioParque() {
		return reserva.getPrecioEntradasParque();
	}

	public void setDatosAlojamiento(int personas, int noches) {
		reserva.setDatosAlojamiento(personas, noches);
		
	}

	public double getPrecioAlojamiento() {
		return reserva.getPrecioAlojamiento();
	}

	public void setDateParque(Date date) {
		reserva.setFechaParque(date);
		
	}

	public void setDateAlojamiento(Date date) {
		reserva.setFechaAlojamiento(date);
		
	}

	public int getPosicionPremio() {
		return ((int) (Math.random() * NUMERO_CASILLAS));
	}

	public void setPremioConseguido(boolean b) {
		this.premioConseguido = b;
		
	}
	
	public boolean isPremioConseguido() {
		return this.premioConseguido;
	}

	/*
	 * Método que recibe el textos para la internacionalizacion, el nombre y apellidos y el dni
	 * genera el texto a guardar como fichero de justificacion de la reserva
	 */
	public void guardarReservaEnFichero(ResourceBundle textos, String nombreCompleto, String dni) {

	    String fechaHoy = DateFormat.getDateInstance().format(new Date());

	    StringBuilder sb = new StringBuilder();

	    sb.append(textos.getString("nombre_empresa")).append("\n\n");
	    sb.append("------------------------------------------------------------\n");
	    sb.append(textos.getString("justificante_titulo")).append(" - ");
	    sb.append(fechaHoy).append(" - ");
	    if (getParqueSeleccionado() != null) {
	        sb.append(getParqueSeleccionado().getDenominacion());
	    }
	    sb.append("\n");
	    sb.append(dni).append(" - ").append(nombreCompleto);
	    sb.append("\n------------------------------------------------------------\n\n");

	    sb.append(textos.getString("titulo_datos_reserva")).append("\n\n");

	    if (getParqueSeleccionado() != null) {
	        Reserva r = getReserva();

	        sb.append(textos.getString("titulo_entradas")).append("\n");
	        sb.append(textos.getString("fecha_inicio")).append(": ")
	                .append(DateFormat.getDateInstance().format(r.getFechaEntradaParque())).append(" / ");
	        sb.append(textos.getString("num_dias")).append(": ").append(r.getDiasParque()).append("\n");

	        sb.append(textos.getString("num_adultos")).append(": ").append(r.getNumAdultos())
	                .append(" / ").append(textos.getString("num_ninos")).append(": ").append(r.getNumNinos()).append("\n");

	        sb.append("\n");
	    }

	    if (getAlojamientoSeleccionado() != null) {
	        Alojamiento a = getAlojamientoSeleccionado();
	        Reserva r = getReserva();

	        String tipo = textos.getString("alojamientos");
	        if ("HO".equals(a.getTipo()))
	            tipo = textos.getString("hotel");
	        else if ("AP".equals(a.getTipo()))
	            tipo = textos.getString("apartamento");
	        else if ("AH".equals(a.getTipo()))
	            tipo = textos.getString("apartahotel");

	        sb.append(textos.getString("titulo_alojamiento_seccion")).append("\n");
	        sb.append(textos.getString("alojamiento")).append(" ");
	        sb.append(a.getCodigo()).append(" / ");
	        sb.append(tipo).append(" / ").append(a.getCategoria() + " " + textos.getString("estrellas")).append(" / ");
	        sb.append(a.getDenominacion())
	                .append("\n");

	        sb.append(textos.getString("fecha_inicio")).append(": ")
	                .append(DateFormat.getDateInstance().format(r.getFechaEntradaAlojamiento())).append(" / ");

	        sb.append(textos.getString("numero_noches")).append(": ").append(r.getNumNochesAlojamiento()).append("\n");
	        sb.append(textos.getString("numero_personas")).append(": ").append(r.getNumPersonasAlojamiento()).append("\n");

	        sb.append("\n");
	    }

	    sb.append(textos.getString("titulo_importe")).append("\n\n");

	    sb.append(String.format("%s       \t\t\t %10.2f ",
	            textos.getString("resumen_entradas") + ":",
	            getReserva().getPrecioEntradasParque()) + textos.getString("moneda")+"\n");

	    sb.append(String.format("%s    \t\t\t %10.2f ",
	            textos.getString("resumen_alojamiento") + ":",
	            getReserva().getPrecioAlojamiento()) + textos.getString("moneda")+"\n");

	    double descuento = getReserva().getDescuento(getAgencia().getParqueEnOferta());
	    if (descuento > 0) {
	        sb.append(String.format("%s     \t\t %10.2f ",
	                textos.getString("resumen_descuento") + ":",
	                descuento)+ textos.getString("moneda")+"\n");
	    }
	    
	    if (premioConseguido) {
	        sb.append("\n").append(textos.getString("premio_conseguido"));
	    }
	    
	    double totalFinal = getReserva().getImporteTotal(getAgencia().getParqueEnOferta());

	    sb.append("\n");
	    sb.append("------------------------------------------\n");
	    
	    sb.append(String.format("%s    \t\t\t %10.2f ",
	            textos.getString("resumen_total") + ":",
	            totalFinal)+ textos.getString("moneda")+"\n");
	    if(!reserva.getComentarioCliente().isEmpty()) {
	    	sb.append("\n").append(textos.getString("comentario_cliente")).append("\n\n");
		    sb.append(reserva.getComentarioCliente());
	    }
	    
	    SimpleDateFormat sdfFichero = new java.text.SimpleDateFormat("yyyy_MM_dd_HH_mm");
	    String fechaHoraFichero = sdfFichero.format(new Date());

	    String nombreFichero = dni + "_" + fechaHoraFichero;
	    
	    FileUtil.saveToFile(sb.toString(), nombreFichero);
	}
	
	public String actualizarTextoResumen(ResourceBundle textos, String nombre, String apellidos, String dni) {
		String nombreCompleto = (nombre + " " + apellidos);

		if (nombre.isEmpty() && apellidos.isEmpty())
			nombreCompleto = textos.getString("placeholder_nombre");
		if (dni.isEmpty())
			dni = textos.getString("placeholder_dni");

		String fechaHoy = DateFormat.getDateInstance().format(new Date());

		StringBuilder sb = new StringBuilder();

		sb.append(textos.getString("nombre_empresa")).append("\n\n");
		sb.append("------------------------------------------------------------\n");
		sb.append(textos.getString("justificante_titulo")).append(" - ");
		sb.append(fechaHoy).append(" - ");
		if (getReserva().getParqueSeleccionado() != null) {
			sb.append(getReserva().getParqueSeleccionado().getDenominacion());
		}
		sb.append("\n");
		sb.append(textos.getString("justificante_dni")).append(": ").append(dni).append(" - ")
				.append(textos.getString("justificante_cliente")).append(": ").append(nombreCompleto);
		sb.append("\n------------------------------------------------------------\n\n");

		sb.append(textos.getString("titulo_datos_reserva")).append("\n\n");

		if (getParqueSeleccionado() != null && getReserva().getFechaEntradaParque() != null) {
			Reserva r = getReserva();

			sb.append(textos.getString("titulo_entradas")).append("\n");
			sb.append(textos.getString("fecha_inicio")).append(": ")
					.append(DateFormat.getDateInstance().format(r.getFechaEntradaParque())).append(" / ");
			sb.append(textos.getString("num_dias")).append(": ").append(r.getDiasParque()).append("\n");

			sb.append(textos.getString("num_adultos")).append(": ").append(r.getNumAdultos()).append(" / ")
					.append(textos.getString("num_ninos")).append(": ").append(r.getNumNinos()).append("\n");

			sb.append("\n");
		}

		if (getAlojamientoSeleccionado() != null && getReserva().getFechaEntradaAlojamiento() != null) {
			Alojamiento a = getAlojamientoSeleccionado();
			Reserva r = getReserva();

			String tipo = textos.getString("alojamientos"); 
			if ("HO".equals(a.getTipo()))
				tipo = textos.getString("hotel");
			else if ("AP".equals(a.getTipo()))
				tipo = textos.getString("apartamento");
			else if ("AH".equals(a.getTipo()))
				tipo = textos.getString("apartahotel");

			sb.append(textos.getString("titulo_alojamiento_seccion")).append("\n");
			sb.append(tipo).append(": ").append(a.getDenominacion()).append(" (").append(a.getCategoria())
					.append(")\n");

			sb.append(textos.getString("fecha_inicio")).append(": ")
					.append(DateFormat.getDateInstance().format(r.getFechaEntradaAlojamiento())).append("\n");

			sb.append(textos.getString("noches")).append(": ").append(r.getNumNochesAlojamiento()).append("\n");
			sb.append(textos.getString("personas")).append(": ").append(r.getNumPersonasAlojamiento()).append("\n");

			sb.append("\n");
		}

		sb.append(textos.getString("titulo_importe")).append("\n\n");

		sb.append(String.format("%s       \t\t\t %10.2f %s\n", textos.getString("resumen_entradas") + ":",
				getReserva().getPrecioEntradasParque(), textos.getString("moneda")));

		sb.append(String.format("%s   \t\t %10.2f %s\n", textos.getString("resumen_alojamiento") + ":",
				getReserva().getPrecioAlojamiento(), textos.getString("moneda")));

		double descuento = getReserva().getDescuento(getAgencia().getParqueEnOferta());
		if (descuento > 0) {
			sb.append(String.format("%s    \t\t -%10.2f %s\n", textos.getString("resumen_descuento") + ":", descuento, textos.getString("moneda")));
		}

		double totalFinal = getReserva().getImporteTotal(getAgencia().getParqueEnOferta());

		sb.append("\n");
		sb.append("------------------------------------------\n");
		sb.append(String.format("%s   \t\t %10.2f %s\n", textos.getString("resumen_total") + ":", totalFinal, textos.getString("moneda")));

		return sb.toString();
	}

	public String getHabitacionesAlojamiento() {
		return reserva.getHabitacionesAlojamiento();
	}

	public String getParqueDelAlojamiento(Alojamiento a) {
		return agencia.getParqueDelAlojamiento(a);
	}
}


