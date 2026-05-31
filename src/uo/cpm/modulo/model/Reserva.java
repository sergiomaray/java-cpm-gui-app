package uo.cpm.modulo.model;

import java.util.Date;

public class Reserva {
	
	private static final int CAPACIDAD_MAX_HOTELES = 2;

	private static final int CAPACIDAD_MAX_APARTAMENTOS = 4;
	private Parque parqueSeleccionado;
	private Alojamiento alojamientoSeleccionado;
	
	//info parque
	private int numAdultos;
	private int numNinos;
	private Date fechaEntradaParque;
	private int diasParque;
	private boolean isParqueReservado;
	
	//info alojamiento
	private int numPersonasAlojamiento;
	private int nochesAlojamiento;
	private Date fechaEntradaAlojamiento;
	private boolean isAlojamientoReservado;
	
	private String nombreCliente;
	private String dniCliente;
	private String comentarioCliente;
	
	/*
	 * Clase reserva que contiene todos los datos de la reserva actual
	 */
	public Reserva() {
		inicializar();
	}

	public void inicializar() {
		this.parqueSeleccionado = null;
		this.alojamientoSeleccionado = null;
		this.numAdultos = 0;
		this.numNinos = 0;
		this.fechaEntradaParque = null;
		this.diasParque = 0;
		this.numPersonasAlojamiento = 0;
		this.nochesAlojamiento = 0;
		this.fechaEntradaAlojamiento = null;
		this.isAlojamientoReservado = false;
		this.isParqueReservado = false;
	}
	
	public double getPrecioEntradasParque() {
		if(parqueSeleccionado == null) {
			return 0;
		}else {
			return (parqueSeleccionado.getPrecioAdulto() * numAdultos + parqueSeleccionado.getPrecioNino() * numNinos) * diasParque;
		}
		
	}
	public double getPrecioAlojamiento() {
		if(alojamientoSeleccionado == null) {
			return 0;
		}else if(alojamientoSeleccionado.getTipo().equals("HO")) {
			return alojamientoSeleccionado.getPrecio()*nochesAlojamiento*numPersonasAlojamiento;
		}else {
			int numApartamentos = numPersonasAlojamiento / CAPACIDAD_MAX_APARTAMENTOS;
			if (numPersonasAlojamiento % CAPACIDAD_MAX_APARTAMENTOS != 0) {
				numApartamentos++;
			}
			return alojamientoSeleccionado.getPrecio() * nochesAlojamiento * numApartamentos;		
		}
		
	}
	
	public double getDescuento(Parque parqueOferta) {
		if(parqueSeleccionado != null && parqueOferta.getCodigo().equals(parqueSeleccionado.getCodigo())) {
			return 0.15*(getPrecioEntradasParque() + getPrecioAlojamiento());
		}else {
			return 0.0;
		}
	}
	
	public double getImporteTotal(Parque parqueOferta) {
		return (getPrecioEntradasParque() + getPrecioAlojamiento() - getDescuento(parqueOferta));
	}
	
	public void setParqueSeleccionado(Parque parqueSel) {
		this.parqueSeleccionado = parqueSel;
	}
	
	public Parque getParqueSeleccionado() {
		return this.parqueSeleccionado;
	}
	
	public void setAlojamientoSeleccionado(Alojamiento al) {
		this.alojamientoSeleccionado = al;
	}
	
	public Alojamiento getAlojamientoSeleccionado() {
		return this.alojamientoSeleccionado;
	}
	
	public void setDatosParque(int adultos, int ninos, int dias) {
		this.numAdultos = adultos;
		this.numNinos = ninos;
		this.diasParque = dias;
		
	}
	
	public void setFechaParque(Date fecha) {
		this.fechaEntradaParque = fecha;
	}
	
	public void setDatosAlojamiento(int personas, int noches) {
		this.numPersonasAlojamiento = personas;
		this.nochesAlojamiento = noches;
	}
	
	public void setFechaAlojamiento(Date fecha) {

		this.fechaEntradaAlojamiento = fecha;
	}
	
	public void setCliente(String name, String dni) {
		this.nombreCliente = name;
		this.dniCliente = dni;
	}
	
	public String getDniCliente() {
		return this.dniCliente;
	}
	
	public String getNombreCliente() {
		return this.nombreCliente;
	}
	
	public int getNumeroPersonasAlojamiento() {
		return this.numPersonasAlojamiento;
	}
	
	public int getNumAdultosParque() {
		return this.numAdultos;
	}
	
	public int getNumNinosParque() {
		return this.numNinos; 
	}
	public void seleccionarParque() {
		this.isParqueReservado = true;
	}
	
	public void seleccionarAlojamiento() {
		this.isAlojamientoReservado = true;
	}
	
	public boolean isAlojamientoReservado() {
		return this.isAlojamientoReservado;
	}
	
	public boolean isParqueReservado() {
		return this.isParqueReservado;
	}
	
	public Date getFechaEntradaParque() {
		return this.fechaEntradaParque;
	}

	public int getDiasParque() {
		return this.diasParque;
	}

	public int getNumAdultos() {
		return this.numAdultos;
	}
	
	public int getNumNinos() {
		return this.numNinos;
	}

	public Date getFechaEntradaAlojamiento() {
		return this.fechaEntradaAlojamiento;
	}

	public int getNumPersonasAlojamiento() {
		return this.numPersonasAlojamiento;
	}
	
	public int getNumNochesAlojamiento() {
		return this.nochesAlojamiento;
	}

	public String getHabitacionesAlojamiento() {
		if (alojamientoSeleccionado == null || numPersonasAlojamiento <= 0) {
			return "0";
		}
		
		int capacidad;
		
		
		if (alojamientoSeleccionado.getTipo().equals("HO")) {
			capacidad = CAPACIDAD_MAX_HOTELES; 
		} else {
			capacidad = CAPACIDAD_MAX_APARTAMENTOS; 
		}
		
		int numHabitaciones = numPersonasAlojamiento / capacidad;
		
		if (numPersonasAlojamiento % capacidad != 0) {
			numHabitaciones++;
		}
		return String.valueOf(numHabitaciones);
	}

	public String getComentarioCliente() {
		return comentarioCliente;
	}

	public void setComentarioCliente(String comentarioCliente) {
		this.comentarioCliente = comentarioCliente;
	}
	
}
