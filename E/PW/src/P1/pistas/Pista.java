package P1.pistas;

import java.util.ArrayList;
import P1.karts.Kart;
import P1.karts.Estado;

/**
 * Clase Pista.
 * @author Daniel Hinojosa Sanchez
 * @author Martin Del Rio Jimenez
 * @author Juan Antonio Galvez Jimenez 
 * @author Marta Rubio Sanchez
 * @author Miguel Castro Martin
 */
public class Pista {
	/** Nombre de la pista. */
	private String nombre;
	/** Estado de la pista(True=Disponible/False=No disponible). */
	private boolean estadoPista;
	/** Dificultad de la pista(Infantil/Familiar/Adultos). */
	private Dificultad dificultad;
	/** Numero maximo de karts permitidos. */
	private int maxKarts;
	/** Lista de karts asociados a la pista. */
	private ArrayList<Kart> lista = new ArrayList<Kart>();
	
	/**
	 * Constructor que permite instanciar un nuevo objeto de la clase Pista.
	 */
	public Pista() {
	}
	
	/**
	 * Constructor parametrizado que permite instanciar un nuevo objeto de la clase Pista.
	 *
	 * @param nombre Cadena de texto con el nombre de la pista.
	 * @param estado Booleano con el estado de la pista.
	 * @param dificultad Enumeracion Dificultad con la dificultad de las pista.
	 * @param maxKarts Entero con la cantidad de karts maximos permitidos en la pista.
	 */
	public Pista(String nombre, boolean estado, Dificultad dificultad, int maxKarts) {
		this.nombre = nombre;
		this.estadoPista = estado;
		this.dificultad = dificultad;
		this.maxKarts = maxKarts;
		lista.clear();
	}

	/**
	 * Obtiene nombre de la pista.
	 *
	 * @return Cadena de texto con el nombre de la pista.
	 */
	public String getNombre() {
		return this.nombre;
	}
	
	/**
	 * Establece nombre de la pista.
	 *
	 * @param nombre Cadena de texto con el nombre de la pista.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene estado de la pista.
	 * 
	 * @return estadoPista Booleano con el estado de la pista.
	 */
	public boolean getEstado() {
		return this.estadoPista;
	}
	
	/**
	 * Establece estado de la pista.
	 *
	 * @param estado Booleano con el estado de la pista.
	 */
	public void setEstado(boolean estado) {
		this.estadoPista = estado;
	}

	/**
	 * Obtiene dificultad de la pista.
	 * 
	 * @return dificultad Enumeracion Dificultad con la dificultad de la pista.
	 */
	public Dificultad getDificultad() {
		return this.dificultad;
	}
	
	/**
	 * Establece dificultad de la pista.
	 *
	 * @param dificultad Enumeracion Dificultad con la dificultad de la pista.
	 */
	public void setDificultad(Dificultad dificultad) {
		this.dificultad = dificultad;
	}
	
	/**
	 * Obtiene maxKarts de la pista.
	 * 
	 * @return maxKarts Entero con la cantidad maxima de karts de la pista.
	 */
	public int getMaxKarts() {
		return this.maxKarts;
	}
	
	/**
	 * Establece maxKarts de la pista.
	 *
	 * @param maxKarts Entero con la cantidad maxima de karts de la pista.
	 */
	public void setMaxKarts(int maxKarts) {
		this.maxKarts = maxKarts;
	}

	/**
	 * Obtiene lista de la pista.
	 * 
	 * @return lista Lista con los karts de la pista.
	 */
	public ArrayList<Kart> getLista() {
		return this.lista;
	}
	
	/**
	 * Establece lista de la pista.
	 *
	 * @param lista Lista con los karts de la pista.
	 */
	public void setLista(ArrayList<Kart> lista) {
		this.lista = lista;
	}
	
	/**
	 * Obtiene informacion de la pista.
	 * 
	 * @return infoPista Cadena de texto con la informacion de la pista.
	 */
	public String toString() {
		String infoPista="";
		if(this.estadoPista==true) {
			infoPista = "Nombre: " + this.nombre + "\tEstado: Disponible \tDificultad: " + this.dificultad + "\tMax Karts: " + this.maxKarts + "\tLista Karts asociados: " + this.lista;
		}
		else if(this.estadoPista==false) {
			infoPista = "Nombre: " + this.nombre + "\tEstado: No disponible \tDificultad: " + this.dificultad + "\tMax Karts: " + this.maxKarts + "\tLista Karts asociados: " + this.lista;
		}
		return infoPista;
	}
	
	/**
	 * Obtiene lista de karts asociados a la pista que estan disponibles.
	 * @return kartsDisponibles Lista de kart sasociados a la pista que estan disponibles.
	 */
	public ArrayList<Kart> consultarKartsDisponibles(){
		ArrayList<Kart> kartsDisponibles = new ArrayList<Kart>();
		for (Kart l : lista) {
			if(l.getEstado()==Estado.disponible) {
				kartsDisponibles.add(l);
			}
		}
		return kartsDisponibles;
	}
	
	/**
	 * Obtiene si el kart es asociado a la pista.
	 * @param kart Kart a asociar
	 * @return Boolean Depende de si el kart es asociado a la pista o no.
	 */
	public boolean asociarKartAPista(Kart kart){
		if(kart.getTipo()==true) {		//kart adulto
			if(this.dificultad==Dificultad.familiar || this.dificultad==Dificultad.adulto) {
				lista.add(kart);
				return true;
			}
		}
		else if(kart.getTipo()==false){		//kart infantil
			if(this.dificultad==Dificultad.familiar || this.dificultad==Dificultad.infantil) {
				lista.add(kart);
				return true;
			}
		}
		return false;
	}
}