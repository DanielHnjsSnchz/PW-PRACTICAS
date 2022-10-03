package P1;

public class ReservaInfantil extends Reserva{ 
	private int numInfantil;

	public ReservaInfantil(){
		super();
	}

	public int getNumInfantil() {
		return this.numInfantil;
	}
	public void setNumInfantil(int numInfantil) {
		this.numInfantil = numInfantil;
	}
	
	public String toString() {
		String infoReserva = "ID reserva: " + this.idReservaPista + "\tFecha: " + this.fecha + "\tDuracion: " + this.duracion + "\tPista: " + this.idReservaPista + "\tPrecio final: " + precioFinal() + "\tNumero infantil: " + this.numInfantil;
		return infoReserva;
	}
	
}