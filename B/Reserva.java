package P1;

import java.time.*;

/**
 * Clase Reserva.
 * @author Daniel Hinojosa Sanchez
 * @author Martin Del Rio Jimenez
 * @author Juan Antonio Galvez Jimenez 
 * @author Marta Rubio Sanchez
 * @author Miguel Castro Martin
 */
public abstract class Reserva {
	/** Identificador del usuario que reserva. */
	protected String idReservaUsuario;
	/** Fecha de la reserva. */
	protected LocalDate fecha;
	/** Duracion de la reserva. */
	protected int duracion;
	/** Identificador de la pista que reserva. */
	protected String idReservaPista;
	/** Precio inicial de la reserva. */
	protected float precio;
	/** Descuento aplicado a la reserva(en decimal). */
	protected float descuento;
	
	/**
	 * Constructor que permite instanciar un nuevo objeto de la clase Reserva.
	 */
	public Reserva() {
	}
	
	/**
	 * Establece identificador del usuario que reserva.
	 *
	 * @param usuario Instancia de la clase usuario.
	 */
	public void setIdReservaUsuario(Usuario usuario) {
		this.idReservaUsuario = usuario.getCorreo();
	}
	/**
	 * Establece identificador del usuario que reserva.
	 *
	 * @param idReservaUsuario Cadena de texto con el identificador del usuario que reserva.
	 */
	public void setIdReservaUsuario(String idReservaUsuario) {
		this.idReservaUsuario = idReservaUsuario;
	}
    
   	 /**
	 * Establece identificador del usuario que reserva.
	 *
	 * @param usuario Cadena de texto con el identificador del usuario que reserva.
	 */
	public void setIdReservaUsuario(Usuario usuario) {
		this.idReservaUsuario = usuario.getCorreo();
	}

	/**
	 * Obtiene fecha de creacion de la reserva.
	 *
	 * @return fecha LocalDate con la fecha de creacion de la reserva.
	 */
	public LocalDate getFecha() {
		return this.fecha;
	}
	
	/**
	 * Establece fecha de creacion de la reserva.
	 *
	 * @param fecha LocalDate con la fecha de creacion de la reserva.
	 */
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	
	/**
	 * Obtiene duracion de la reserva.
	 * 
	 * @return duracion Entero con la duracion de la reserva.
	 */
	public int getDuracion() {
		return this.duracion;
	}
	
	/**
	 * Establece duracion de la reserva.
	 *
	 * @param duracion Entero con la duracion de la reserva.
	 */
    public void setDuracion(int duracion) {
    	this.duracion = duracion;
    }
    
    /**
	 * Obtiene identificador de la pista que reserva.
	 *
	 * @return idReservaPista Cadena de texto con el identificador de la pista que reserva.
	 */
	public String getIdReservaPista() {
		return this.idReservaPista;
	}
	
	/**
	 * Establece identificador de la pista que reserva.
	 *
	 * @param idReservaPista Cadena de texto con el identificador de la pista que reserva.
	 */
	public void setIdReservaPista(String idReservaPista) {
		this.idReservaPista = idReservaPista;
	}
	
	/**
	 * Obtiene precio de la reserva.
	 * 
	 * @return precio Decimal con el precio inicial de la reserva.
	 */
	public float getPrecio() {
		return this.precio;
	}
	
	/**
	 * Establece precio de la reserva.
	 *
	 * @param precio Decimal con el precio inicial de la reserva.
	 */
	public void setPrecio(float precio) {
		this.precio = precio;
	}

	/**
	 * Obtiene descuento de la reserva.
	 * 
	 * @return descuento Decimal con el descuento de la reserva.
	 */
	public float getDescuento() {
		return this.descuento;
	}
	
	/**
	 * Establece descuento de la reserva.
	 *
	 * @param descuento Decimal con el descuento de la reserva.
	 */
	public void setDescuento(float descuento) {
		this.descuento = descuento;
	}
	
	/**
	 * Obtiene precio final de la reserva(una vez aplicado el descuento al precio inicial).
	 * 
	 * @return precioFin Decimal con el precio final de la reserva.
	 */
	public float precioFinal()
	{
		float precioFin = this.precio*this.descuento;
		return precioFin;
	}
	
	/**
	 * Obtiene informacion de la reserva.
	 * 
	 * @return infoReserva Cadena de texto con la informacion de la reserva.
	 */
	public String toString() {
		String infoReserva = "ID reserva: " + this.idReservaPista + "\tFecha: " + this.fecha + "\tDuracion: " + this.duracion + "\tPista: " + this.idReservaPista + "\tPrecio final: " + precioFinal();
		return infoReserva;
	}
}
