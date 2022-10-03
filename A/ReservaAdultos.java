package P1;

public class ReservaAdultos extends Reserva{
	private int numAdultos;
	
	public ReservaAdultos() {
		super();
	}
	
	public int getNumAdultos() {
		return numAdultos;
	}
	public void setNumAdultos(int numAdultos) {
		this.numAdultos = numAdultos;
	}

	public String toString() {
		String infoReserva = "ID reserva: " + this.idReservaPista + "\tFecha: " + this.fecha + "\tDuracion: " + this.duracion + "\tPista: " + this.idReservaPista + "\tPrecio final: " + precioFinal() + "\tNumero adultos: " + this.numAdultos;
		return infoReserva;
	}
}