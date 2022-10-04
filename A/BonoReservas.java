package P1;
import java.util.ArrayList;

public class BonoReservas extends CreadorReservas{
	
	private ArrayList<Reserva> bono = new ArrayList<Reserva>();
	private int id;
	private int numeroReserva;
	
	@Override
	public ReservaFamiliar crearReservaFamiliar(Usuario usuario, int duracion, Pista pista, float precio, float descuento, int numAdultos, int numInfantil) {
		ReservaFamiliar reserva = new ReservaFamiliar();
		reserva.setIdReservaUsuario(usuario);
		reserva.setDuracion(duracion);
		reserva.setIdReservaPista(pista.getNombre());
		reserva.setPrecio(precio);
		reserva.setDescuento(descuento);
		reserva.setNumAdultos(numAdultos);
		reserva.setNumInfantil(numInfantil);
		bono.add(reserva);
		return reserva;
	}
	@Override
	public ReservaInfantil crearReservaInfantil(Usuario usuario, int duracion, Pista pista, float precio, float descuento, int numInfantil) {
		ReservaInfantil reserva = new ReservaInfantil();
		reserva.setIdReservaUsuario(usuario);
		reserva.setDuracion(duracion);
		reserva.setIdReservaPista(pista.getNombre());
		reserva.setPrecio(precio);
		reserva.setDescuento(descuento);
		reserva.setNumInfantil(numInfantil);
		bono.add(reserva);
		return reserva;
	}
	@Override
	public ReservaAdultos crearReservaAdulto(Usuario usuario, int duracion, Pista pista, float precio, float descuento, int numAdultos) {
		ReservaAdultos reserva = new ReservaAdultos();
		reserva.setIdReservaUsuario(usuario);
		reserva.setDuracion(duracion);
		reserva.setIdReservaPista(pista.getNombre());
		reserva.setPrecio(precio);
		reserva.setDescuento(descuento);
		reserva.setNumAdultos(numAdultos);
		bono.add(reserva);
		return reserva;
	}
	
	public ArrayList<Reserva> getBono() {
		return bono;
	}
	public void setBono(ArrayList<Reserva> bono) {
		this.bono = bono;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getNumeroReserva() {
		numeroReserva = bono.size();
		return numeroReserva;
	}
	public void setNumeroReserva(int numeroReserva) {
		this.numeroReserva = numeroReserva;
	}
	
}

