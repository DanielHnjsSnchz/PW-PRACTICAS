package P1;

import java.time.*;
import java.util.ArrayList;

/**
 * Clase BonoReservas.
 * @author Daniel Hinojosa Sanchez
 * @author Martin Del Rio Jimenez
 * @author Juan Antonio Galvez Jimenez 
 * @author Marta Rubio Sanchez
 * @author Miguel Castro Martin
 */
public class BonoReservas extends CreadorReservas{
	/** Lista de reservas del bono. */
	private ArrayList<Reserva> bono = new ArrayList<Reserva>();
	/** Identificador de la reserva. */
	private int id;
	/** Numero de la reserva dentro de bono. */
	private int numeroReserva;
	
	/**	Obtiene reserva de tipo familiar. Asigna valores a todos sus atributos. */
	@Override
	public ReservaFamiliar crearReservaFamiliar(Usuario usuario, int duracion, Pista pista, float precio, float descuento, int numAdultos, int numInfantil) {
		ReservaFamiliar reserva = new ReservaFamiliar();
		reserva.setIdReservaUsuario(usuario);
		reserva.setFecha(LocalDate.now());
		reserva.setDuracion(duracion);
		reserva.setIdReservaPista(pista.getNombre());
		reserva.setPrecio(precio);
		reserva.setDescuento(descuento);
		reserva.setNumAdultos(numAdultos);
		reserva.setNumInfantil(numInfantil);
		bono.add(reserva);
		return reserva;
	}
	
	/**	Obtiene reserva de tipo infantil. Asigna valores a todos sus atributos. */
	@Override
	public ReservaInfantil crearReservaInfantil(Usuario usuario, int duracion, Pista pista, float precio, float descuento, int numInfantil) {
		ReservaInfantil reserva = new ReservaInfantil();
		reserva.setIdReservaUsuario(usuario);
		reserva.setFecha(LocalDate.now());
		reserva.setDuracion(duracion);
		reserva.setIdReservaPista(pista.getNombre());
		reserva.setPrecio(precio);
		reserva.setDescuento(descuento);
		reserva.setNumInfantil(numInfantil);
		bono.add(reserva);
		return reserva;
	}
	
	/**	Obtiene reserva de tipo adulto. Asigna valores a todos sus atributos. */
	@Override
	public ReservaAdultos crearReservaAdulto(Usuario usuario, int duracion, Pista pista, float precio, float descuento, int numAdultos) {
		ReservaAdultos reserva = new ReservaAdultos();
		reserva.setIdReservaUsuario(usuario);
		reserva.setFecha(LocalDate.now());
		reserva.setDuracion(duracion);
		reserva.setIdReservaPista(pista.getNombre());
		reserva.setPrecio(precio);
		reserva.setDescuento(descuento);
		reserva.setNumAdultos(numAdultos);
		bono.add(reserva);
		return reserva;
	}
	
	/**
	 * Obtiene lista de reservas del bono.
	 *
	 * @return bono Lista de reservas del bono.
	 */
	public ArrayList<Reserva> getBono() {
		return this.bono;
	}
	
	/**
	 * Establece lista de reservas.
	 *
	 * @param bono Lista de reservas del bono.
	 */
	public void setBono(ArrayList<Reserva> bono) {
		this.bono = bono;
	}
	
	/**
	 * Obtiene identificador de la reserva.
	 * 
	 * @return id Entero con el identificador de la reserva.
	 */
	public int getId() {
		return this.id;
	}
	
	/**
	 * Establece identificador de la reserva.
	 *
	 * @param id Entero con el identificador de la reserva.
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Obtiene numero de la reserva dentro del bono.
	 * 
	 * @return numeroReserva Entero con el numero de la reserva dentro del bono.
	 */
	public int getNumeroReserva() {
		numeroReserva = bono.size();
		return this.numeroReserva;
	}
	
	/**
	 * Establece numero de la reserva dentro del bono.
	 *
	 * @param numeroReserva Entero con el numero de la reserva dentro del bono.
	 */
	public void setNumeroReserva(int numeroReserva) {
		this.numeroReserva = numeroReserva;
	}
	
}

