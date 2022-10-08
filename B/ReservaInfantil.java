package P1;

/**
 * Clase ReservaInfantil.
 * @author Daniel Hinojosa Sanchez
 * @author Martin Del Rio Jimenez
 * @author Juan Antonio Galvez Jimenez 
 * @author Marta Rubio Sanchez
 * @author Miguel Castro Martin
 */
public class ReservaInfantil extends Reserva{
	/**	Numero de niños en la reserva. */
	private int numInfantil;

	/**
	 * Constructor que permite instanciar un nuevo objeto de la clase ReservaInfantil.
	 */
	public ReservaInfantil(){
		super();
	}

	/**
	 * Obtiene numero de niños en la reserva.
	 * 
	 * @return numInfantil Entero con el numero de niños en la reserva.
	 */
	public int getNumInfantil() {
		return this.numInfantil;
	}
	
	/**
	 * Establece numero de niños en la reserva.
	 *
	 * @param numInfantil Entero con el numero de niños en la reserva.
	 */
	public void setNumInfantil(int numInfantil) {
		this.numInfantil = numInfantil;
	}
	
	/**
	 * Obtiene informacion de la reserva de niños.
	 * 
	 * @return infoReserva Cadena de texto con la informacion de la reserva de niños.
	 */
	public String toString() {
		String infoReserva = "ID reserva: " + this.idReservaPista + "\tFecha: " + this.fecha + "\tDuracion: " + this.duracion + "\tPista: " + this.idReservaPista + "\tPrecio final: " + precioFinal() + "\tNumero infantil: " + this.numInfantil;
		return infoReserva;
	}
	
}