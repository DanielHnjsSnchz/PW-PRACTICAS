package P1;
import java.util.ArrayList;

public abstract class CreadorReservas {
	public abstract ReservaFamiliar crearReservaFamiliar(Usuario usuario, int duracion, Pista pista, float precio, float descuento, int numAdultos, int numInfantil);
	public abstract ReservaInfantil crearReservaInfantil(Usuario usuario, int duracion, Pista pista, float precio, float descuento, int numInfantil);
	public abstract ReservaAdultos crearReservaAdulto(Usuario usuario, int duracion, Pista pista, float precio, float descuento, int numAdultos);
	
	protected ArrayList<Reserva> reservas = new ArrayList<Reserva>();

	public ArrayList<Reserva> getReservas() {
		return reservas;
	}
	public void setReservas(ArrayList<Reserva> reservas) {
		this.reservas = reservas;
	}
}
