package P1;

/**
 * Clase Kart.
 * @author Daniel Hinojosa Sanchez
 * @author Martin Del Rio Jimenez
 * @author Juan Antonio Galvez Jimenez 
 * @author Marta Rubio Sanchez
 * @author Miguel Castro Martin
 */
public class Kart {
	/** Id del kart. */
	private int id;
	/** Tipo del kart(True=Adulto/False=Infantil). */
	private boolean tipo;
	/** Estado del kart(Disponible/Reservado/Mantenimiento). */
	private Estado estadoKart;

	/**
	 * Constructor que permite instanciar un nuevo objeto de la clase Kart.
	 */
	public Kart() {
	}
	
	/**
	 * Constructor parametrizado que permite instanciar un nuevo objeto de la clase Kart.
	 *
	 * @param id Entero con el id del kart.
	 * @param tipo Booleano con el tipo del kart.
	 * @param estadoKart Enumeracion Estado con el estado del kart.
	 */
	public Kart(int id, boolean tipo, Estado estadoKart) {
		this.id = id;
		this.tipo = tipo;
		this.estadoKart = estadoKart;
	}
	
	/**
	 * Obtiene id del kart.
	 *
	 * @return id Entero con el id del kart.
	 */
	public int getId() {
		return this.id;
	}
	
	/**
	 * Establece id del kart
	 *
	 * @param id Entero con el id del kart.
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Obtiene tipo del kart.
	 * 
	 * @return tipo Booleano con el tipo del kart.
	 */
	public boolean getTipo() {
		return this.tipo;
	}
	
	/**
	 * Establece tipo del kart.
	 *
	 * @param tipo Booleano con el tipo del kart.
	 */
	public void setTipo(boolean tipo) {
		this.tipo = tipo;
	}
	
	/**
	 * Obtiene estadoKart del kart.
	 * 
	 * @return estadoKart Enumeracion Estado con el estado del kart.
	 */
	public Estado getEstado() {
		return this.estadoKart;
	}
	
	/**
	 * Establece estadoKart del kart.
	 *
	 * @param  estadoKart Enumeracion Estado con el estado del kart */
	public void setEstado(Estado estadoKart) {
		this.estadoKart = estadoKart;
	}

	/**
	 * Obtiene informacion del kart.
	 * 
	 * @return infoKart Cadena de texto con la informacion del kart.
	 */
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
 