package P1.reservas;

import P1.usuarios.Usuario;
import P1.pistas.Pista;
import java.time.*;

/**
 * Clase IndividualReservas.
 * @author Daniel Hinojosa Sanchez
 * @author Martin Del Rio Jimenez
 * @author Juan Antonio Galvez Jimenez 
 * @author Marta Rubio Sanchez
 * @author Miguel Castro Martin
 */
public class IndividualReservas extends CreadorReservas{
	/**	Obtiene reserva de tipo familiar. Asigna valores a todos sus atributos. */
	@Override
	public ReservaFamiliar crearReservaFamiliar(Usuario usuario, int duracion, Pista pista, double precio, double descuento, int numAdultos, int numInfantil) {
		ReservaFamiliar reserva = new ReservaFamiliar();
		reserva.setIdReservaUsuario(usuario);
		reserva.setFecha(LocalDate.now());
		reserva.setDuracion(duracion);
		reserva.setIdReservaPista(pista.getNombre());
		reserva.setPrecio(precio);
		reserva.setDescuento(descuento);
		reserva.setNumAdultos(numAdultos);
		reserva.setNumInfantil(numInfantil);
		return reserva;
	}
	
	/**	Obtiene reserva de tipo infantil. Asigna valores a todos sus atributos. */
	@Override
	public ReservaInfantil crearReservaInfantil(Usuario usuario, int duracion, Pista pista, double precio, double descuento, int numInfantil) {
		ReservaInfantil reserva = new ReservaInfantil();
		reserva.setIdReservaUsuario(usuario);
		reserva.setFecha(LocalDate.now());
		reserva.setDuracion(duracion);
		reserva.setIdReservaPista(pista.getNombre());
		reserva.setPrecio(precio);
		reserva.setDescuento(descuento);
		reserva.setNumInfantil(numInfantil);
		return reserva;
	}
	
	/**	Obtiene reserva de tipo adulto. Asigna valores a todos sus atributos. */
	@Override
	public ReservaAdultos crearReservaAdulto(Usuario usuario, int duracion, Pista pista, double precio, double descuento, int numAdultos) {
		ReservaAdultos reserva = new ReservaAdultos();
		reserva.setIdReservaUsuario(usuario);
		reserva.setFecha(LocalDate.now());
		reserva.setDuracion(duracion);
		reserva.setIdReservaPista(pista.getNombre());
		reserva.setPrecio(precio);
		reserva.setDescuento(descuento);
		reserva.setNumAdultos(numAdultos);
		return reserva;
	}
}