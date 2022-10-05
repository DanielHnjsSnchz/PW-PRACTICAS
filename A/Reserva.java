package P1;

import java.time.*;

public abstract class Reserva {
	
	protected String idReservaUsuario;
    protected LocalDate fecha;
    protected int duracion;
    protected String idReservaPista;
    protected float precio;
    protected float descuento;	//Debe ser guardado en decimales 10%-->0.1
	
	public Reserva() {
	}
	
    public String getIdReservaUsuario() {
		return idReservaUsuario;
	}
	public void setIdReservaUsuario(Usuario usuario) {
		this.idReservaUsuario = usuario.getCorreo();
	}

	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	
    public void setDuracion(int duracion) {
    	this.duracion = duracion;
    }
    public int getDuracion() {
    	return duracion;
    }

	public String getIdReservaPista() {
		return idReservaPista;
	}
	public void setIdReservaPista(String idReservaPista) {
		this.idReservaPista = idReservaPista;
	}
	
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public float getDescuento() {
		return descuento;
	}
	public void setDescuento(float descuento) {
		this.descuento = descuento;
	}
	
    /**Calculo del precio final de reserva de las pistas*/
	public float precioFinal()
	{
		float precioFin = this.precio*this.descuento;
		return precioFin;
	}
	
	public String toString() {
		String infoReserva = "ID reserva: " + this.idReservaPista + "\tFecha: " + this.fecha + "\tDuracion: " + this.duracion + "\tPista: " + this.idReservaPista + "\tPrecio final: " + precioFinal();
		return infoReserva;
	}
}