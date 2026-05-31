package uo.cpm.modulo.model;

public class Alojamiento {
	
	private String codigo;
	private String tipo;		//HO -> hotel, AP -> apartamento, AH -> apartahotel
	private int  categoria;		//estrellas del alojamiento
	private String denominacion;
	private String codigoParque;	//código del parque que está asociado a este alojamiento
	private double precio;		//si es hotel precio por persona y noche; el resto es precio por noche
	private int capacidadMaxima;
	
	/*
	 * Clase alijamiento que contiene todos los atributos de el propio alojamiento
	 */
	public Alojamiento(String codigo, String tipo, int categoria, String denominacion,
			String codigoParque, double precio) {
		
		this.codigo = codigo;
		this.tipo = tipo;
		this.categoria = categoria;
		this.denominacion = denominacion;
		this.codigoParque = codigoParque;
		this.precio = precio;
		calcularCapacidad();
	}
	
	/*
	 * calcula la capacidad maxima por habitacion del alojamiento
	 */
	public void calcularCapacidad() {
		if(tipo.equals("HO")) {
			this.capacidadMaxima = 2;
		}else {
			this.capacidadMaxima = 4;
		}
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}

	public String getDenominacion() {
		return denominacion;
	}

	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}

	public String getCodigoParque() {
		return codigoParque;
	}

	public void setCodigoParque(String codigoParque) {
		this.codigoParque = codigoParque;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public int getCapacidadMaxima() {
		return this.capacidadMaxima;
	}
	
	@Override
	public String toString() {
		return denominacion;
	}
	
	

}
