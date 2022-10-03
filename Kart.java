package P1;

public class Kart {
	private int id;
	private boolean tipo;
	private Estado estadoKart;

	public Kart() {
	}
	
	public Kart(int id, boolean tipo, Estado estadoKart) {
		this.id = id;
		this.tipo = tipo;
		this.estadoKart = estadoKart;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public boolean getTipo() {
		return tipo;
	}
	public void setTipo(boolean tipo) {
		this.tipo = tipo;
	}
	
	public Estado getEstado() {
		return estadoKart;
	}
	public void setEstado(Estado estadoKart) {
		this.estadoKart = estadoKart;
	}

	public String toString() {
		String infoKart = "ID: " + this.id + "\tTipo: " + this.tipo + "\tEstado: " + this.estadoKart;
		return infoKart;
	}
}
 