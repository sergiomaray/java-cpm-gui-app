package uo.cpm.modulo.model;

public class Parque {
	private String codigo;
	private String denominacion;
	private String pais;
	private String localidad;
	private String descripcion;
	private double precioAdulto;
	private double precioNino;
	
	/*
	 * Clase parque que contiene todos los atributos de el propio parque
	 */
	public Parque(String codigo, String denominacion, String pais, String localidad,
			String descripcion, double precioAdulto, double precioNino) {
		
		this.codigo = codigo;
		this.denominacion = denominacion;
		this.descripcion = descripcion;
		this.localidad = localidad;
		this.pais = pais;
		this.precioAdulto = precioAdulto;
		this.precioNino = precioNino;
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public String getDenominacion() {
		return denominacion;
	}
	
	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}
	
	public String getPais() {
		return pais;
	}
	
	public void setPais(String pais) {
		this.pais = pais;
	}
	
	public String getLocalidad() {
		return localidad;
	}
	
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public double getPrecioAdulto() {
		return precioAdulto;
	}
	
	public void setPrecioAdulto(double precioAdulto) {
		this.precioAdulto = precioAdulto;
	}
	
	public double getPrecioNino() {
		return precioNino;
	}
	
	public void setPrecioNino(double precioNino) {
		this.precioNino = precioNino;
	}
	@Override
	public String toString() {
		return this.denominacion;
				
	}
	
	
	
	
}
