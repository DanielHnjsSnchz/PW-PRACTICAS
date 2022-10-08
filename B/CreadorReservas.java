package P1;

/**
 * Clase CreadorReservas.
 * @author Daniel Hinojosa Sanchez
 * @author Martin Del Rio Jimenez
 * @author Juan Antonio Galvez Jimenez 
 * @author Marta Rubio Sanchez
 * @author Miguel Castro Martin
 */
public abstract class CreadorReservas {
	/** Cabezera del metodo crearReservaFamiliar. */
	public abstract ReservaFamiliar crearReservaFamiliar(Usuario usuario, int duracion, Pista pista, float precio, float descuento, int numAdultos, int numInfantil);
	/** Cabezera del metodo crearReservaInfantil. */
	public abstract ReservaInfantil crearReservaInfantil(Usuario usuario, int duracion, Pista pista, float precio, float descuento, int numInfantil);
	/** Cabezera del metodo crearReservaAdulto. */
	public abstract ReservaAdultos crearReservaAdulto(Usuario usuario, int duracion, Pista pista, float precio, float descuento, int numAdultos);
}
