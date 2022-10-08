package P1;

/**
 * Clase ReservaFamiliar.
 * @author Daniel Hinojosa Sanchez
 * @author Martin Del Rio Jimenez
 * @author Juan Antonio Galvez Jimenez 
 * @author Marta Rubio Sanchez
 * @author Miguel Castro Martin
 */
public class ReservaFamiliar extends Reserva{
	/**	Numero de adultos en la reserva. */
	private int numAdultos;
	/**	Numero de niños en la reserva. */
	private int numInfantil;

	/**
	 * Constructor que permite instanciar un nuevo objeto de la clase ReservaFamiliar.
	 */
	public ReservaFamiliar(){
		super();
	}

	/**
	 * Obtiene numero de adultos en la reserva.
	 * 
	 * @return numAdultos Entero con el numero de adultos en la reserva.
	 */
	public int getNumAdultos(){
		return this.numAdultos;
	}
	
	/**
	 * Establece numero de adultos en la reserva.
	 *
	 * @param numAdultos Entero con el numero de adultos en la reserva.
	 */
	public void setNumAdultos(int numAdultos){
		this.numAdultos = numAdultos;
	}

	/**
	 * Obtiene numero de niños en la reserva.
	 * 
	 * @return numInfantil Entero con el numero de niños en la reserva.
	 */
	public int getNumInfantil(){
		return this.numInfantil;
	}
	
	/**
	 * Establece numero de niños en la reserva.
	 *
	 * @param numInfantil Entero con el numero de niños en la reserva.
	 */
	public void setNumInfantil(int numInfantil){
		this.numInfantil = numInfantil;
	}
	
	/**
	 * Obtiene informacion de la reserva familiar.
	 * 
	 * @return infoReserva Cadena de texto con la informacion de la reserva familiar.
	 */
	public String toString() {
		String infoReserva = "ID reserva: " + this.idReservaPista + "\tFecha: " + this.fecha + "\tDuracion: " + this.duracion + "\tPista: " + this.idReservaPista + "\tPrecio final: " + precioFinal() + "\tNumero adultos: " + this.numAdultos + "\tNumero infantil: " + this.numInfantil;
		return infoReserva;
	}
}