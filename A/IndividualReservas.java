package P1;

public class IndividualReservas extends CreadorReservas{

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
		return reserva;
	}
}