package P1;

public class Kart {
	private int id;
	private boolean tipo;		//True=adulto False=infantil
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
		String infoKart="";
		if(this.tipo==true) {
			infoKart = "ID: " + this.id + "\tTipo: Adulto" + "\tEstado: " + this.estadoKart;
		}
		else if(this.tipo==false) {
			infoKart = "ID: " + this.id + "\tTipo: Infantil" + "\tEstado: " + this.estadoKart;
		}
		return infoKart;
	}
}
 