package P1;

/**
 * Clase ReservaAdultos.
 * @author Daniel Hinojosa Sanchez
 * @author Martin Del Rio Jimenez
 * @author Juan Antonio Galvez Jimenez 
 * @author Marta Rubio Sanchez
 * @author Miguel Castro Martin
 */
public class ReservaAdultos extends Reserva{
	/**	Numero de adultos en la reserva. */
	private int numAdultos;
	
	/**
	 * Constructor que permite instanciar un nuevo objeto de la clase ReservaAdultos.
	 */
	public ReservaAdultos() {
		super();
	}
	
	/**
	 * Obtiene numero de adultos en la reserva.
	 * 
	 * @return numAdultos Entero con el numero de adultos en la reserva.
	 */
	public int getNumAdultos() {
		return this.numAdultos;
	}
	
	/**
	 * Establece numero de adultos en la reserva.
	 *
	 * @param numAdultos Entero con el numero de adultos en la reserva.
	 */
	public void setNumAdultos(int numAdultos) {
		this.numAdultos = numAdultos;
	}

	/**
	 * Obtiene informacion de la reserva de adultos.
	 * 
	 * @return infoReserva Cadena de texto con la informacion de la reserva de adultos.
	 */
	public String toString() {
		String infoReserva = "ID reserva: " + this.idReservaPista + "\tFecha: " + this.fecha + "\tDuracion: " + this.duracion + "\tPista: " + this.idReservaPista + "\tPrecio final: " + precioFinal() + "\tNumero adultos: " + this.numAdultos;
		return infoReserva;
	}
}