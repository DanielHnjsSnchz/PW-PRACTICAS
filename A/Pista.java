package P1;

import java.util.ArrayList;

public class Pista {
	private String nombre;
	private boolean estadoPista;
	private Dificultad dificultad;
	private int maxKarts;
	private ArrayList<Kart> lista = new ArrayList<Kart>();
	
	public Pista() {
	}
	
	public Pista(String nombre, boolean estado, Dificultad dificultad, int maxKarts) {
		this.nombre = nombre;
		this.estadoPista = estado;
		this.dificultad = dificultad;
		this.maxKarts = maxKarts;
		lista.clear();
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean getEstado() {
		return estadoPista;
	}
	public void setEstado(boolean estado) {
		this.estadoPista = estado;
	}

	public Dificultad getDificultad() {
		return dificultad;
	}
	public void setDificultad(Dificultad dificultad) {
		this.dificultad = dificultad;
	}
	
	public int getMaxKarts() {
		return maxKarts;
	}
	public void setMaxKarts(int maxKarts) {
		this.maxKarts = maxKarts;
	}

	public ArrayList<Kart> getLista() {
		return lista;
	}
	public void setLista(ArrayList<Kart> lista) {
		this.lista = lista;
	}
	
	public String toString() {
		String infoPista = "Nombre: " + this.nombre + "\tEstado: " + this.estadoPista + "\tDificultad: " + this.dificultad + "\tMax Karts: " + this.maxKarts + "\tLista Karts asociados: " + this.lista;
		return infoPista;
	}
	
	public ArrayList<Kart> consultarKartsDisponibles(){
		ArrayList<Kart> kartsDisponibles = new ArrayList<Kart>();
		for (Kart l : lista) {
			if(l.getEstado()==Estado.disponible) {
				kartsDisponibles.add(l);
			}
		}
		return kartsDisponibles;
	}
	
	public void asociarKartAPista(Kart kart){
		if(kart.getTipo()==true) {		//kart adulto
			if(this.dificultad==Dificultad.familiar || this.dificultad==Dificultad.adulto) {
				lista.add(kart);
			}
		}
		else if(kart.getTipo()==false){		//kart infantil
			if(this.dificultad==Dificultad.familiar || this.dificultad==Dificultad.infantil) {
				lista.add(kart);
			}
		}
	}
}