package P1;

public class ReservaFamiliar extends Reserva{
	private int numAdultos;
	private int numInfantil;

	public ReservaFamiliar(){
		super();
	}

	public int getNumAdultos(){
		return this.numAdultos;
	}
	public void setNumAdultos(int numAdultos){
		this.numAdultos = numAdultos;
	}

	public int getNumInfantil(){
		return this.numInfantil;
	}
	public void setNumInfantil(int numInfantil){
		this.numInfantil = numInfantil;
	}
	
	public String toString() {
		String infoReserva = "ID reserva: " + this.idReservaPista + "\tFecha: " + this.fecha + "\tDuracion: " + this.duracion + "\tPista: " + this.idReservaPista + "\tPrecio final: " + precioFinal() + "\tNumero adultos: " + this.numAdultos + "\tNumero infantil: " + this.numInfantil;
		return infoReserva;
	}
}