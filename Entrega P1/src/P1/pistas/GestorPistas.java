package P1.pistas;

import java.io.FileNotFoundException;
import P1.karts.Kart;
import P1.ficheros.Ficheros;
import P1.karts.Estado;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GestorPistas{
	private ArrayList<Pista> listaPistas = new ArrayList<Pista>();	//Pistas que estan disponibles
	private ArrayList<Pista> listaPistasNoDisponibles = new ArrayList<Pista>();	//Pistas que no estan disponibles
	private ArrayList<Kart> listaKarts = new ArrayList<Kart>();		//Karts que no estan asignados
	
	Scanner leer = new Scanner(System.in);
	
	public void MenuPistas() throws FileNotFoundException, IOException{
		int opcion;
		boolean salir = false;
		
		while (!salir) {	
			System.out.println("1.Crear pista.\n2.Crear kart.\n3.Asociar kart a pista.\n4.Pistas en mantenimiento.\n5.Hacer consulta de pista libre para carrera.\n6.Salir");
			try {
				System.out.println("Introduce una opcion:");
				opcion = leer.nextInt();
				switch (opcion) {
				case 1:
					if(crearPista()) {
						System.out.println("Se ha creado la pista.\n");
					}
					else
						System.out.println("No se ha creado la pista.\n");
					
					break;
					
				case 2:
					if(crearKart()) {
						System.out.println("Se ha creado el kart.\n");
					}
					else
						System.out.println("No se ha creado el kart.\n");
					
					break;
					
				case 3:
					kartAPista();
					
					break;
				case 4:
					Ficheros fichero = new Ficheros();
					listaPistasNoDisponibles = fichero.cargarFicheroPistaNoDisponibles();
					for(Pista p : listaPistasNoDisponibles) {
						System.out.println(p.toString());
					}
					
					break;
				case 5:
					buscarKartsYPista();
					
					break;
				case 6: 
					salir=true;
					break;
				default:
					 System.out.println("La opcion elegida no es valida.\n");
					break;
				}
			}catch (InputMismatchException e) {
					System.out.println("Debes insertar un numero");
					leer.next();
			}
		}
		leer.close();	
	}
	
	public boolean crearPista() throws FileNotFoundException, IOException{
		Ficheros fichero = new Ficheros();
		
		System.out.println("Introduzca los datos necesarios para crear una pista.");
		System.out.println("Nombre:");
		leer.nextLine();
		String nombrePista = leer.nextLine();
		
		System.out.println("Estado pista: \n\t1.Disponible. \n\t2.No disponible.");
		int estado=leer.nextInt();
		boolean estadoPista=false;
		if(estado==1) {
			estadoPista=true;
		}
		else if(estado==2) {
			estadoPista=false;
		}
		
		System.out.println("Dificultad: \n\t1.Infantil. \n\t2.Familiar. \n\t3.Adulto.");
		int dif=leer.nextInt();
		Dificultad dificultad = Dificultad.infantil;
		if(dif==1) {
			dificultad=Dificultad.infantil;
		}
		else if(dif==2){
			dificultad=Dificultad.familiar;
		}
		else if(dif==3) {
			dificultad=Dificultad.adulto;
		}
		
		System.out.println("Numero maximo de karts permitidos:");
		int maxKarts=leer.nextInt();
	
		Pista nuevaPista = new Pista(nombrePista, estadoPista, dificultad, maxKarts);
		if(estadoPista) {
			listaPistas = fichero.cargarFicheroPistaDisponibles();
			listaPistas.add(nuevaPista);
			fichero.escribirFicheroPistaDisponibles(listaPistas);
			return true;
		}
		else if (!estadoPista){
			listaPistasNoDisponibles = fichero.cargarFicheroPistaNoDisponibles();
			listaPistasNoDisponibles.add(nuevaPista);
			fichero.escribirFicheroPistaNoDisponibles(listaPistasNoDisponibles);
			return true;
		}	
		return false;
	}
	
	public boolean crearKart() throws FileNotFoundException, IOException{
		Ficheros fichero = new Ficheros();
		
		System.out.println("Introduzca los datos necesarios para crear un kart.");
		System.out.println("ID:");
		int idKart = leer.nextInt();
		
		System.out.println("Tipo de Kart: \n\t1.Adultos. \n\t2.Infantil.");
		int tip=leer.nextInt();
		boolean tipo = false;
		if(tip==1) {
			tipo=true;
		}
		else if(tip==2) {
			tipo=false;
		}
		
		System.out.println("Estado del kart: \n\t1.Disponible. \n\t2.Reservado. \n\t3.Mantenimiento.");
		int estadoK=leer.nextInt();
		Estado estadoKart = Estado.disponible;
		if(estadoK==1) {
			estadoKart=Estado.disponible;
		}
		else if(estadoK==2) {
			estadoKart=Estado.reservado;
		}
		else if(estadoK==3) {
			estadoKart=Estado.mantenimiento;
		}
		listaKarts = fichero.cargarFicheroKarts();
		Kart nuevoKart= new Kart(idKart, tipo, estadoKart);
		if(listaKarts.add(nuevoKart)) {
			fichero.escribirFicheroKarts(listaKarts);
			return true;
		}
		
		return false;
	}
	
	public void kartAPista() throws FileNotFoundException, IOException{
		Ficheros ficheroK = new Ficheros();
		Ficheros ficheroP = new Ficheros();
		
		System.out.println("Introduce ID del kart: ");
		int id = leer.nextInt();
		
		System.out.println("Introduce nombre de la pista: ");
		leer.nextLine();
		String nombre = leer.nextLine();
		
		Kart kart = new Kart();
		Pista pista = new Pista();
		
		listaKarts = ficheroK.cargarFicheroKarts();
		listaPistas = ficheroP.cargarFicheroPistaDisponibles();
		
		for(Kart l : listaKarts) {
			if(l.getId()==id) {
				kart=l;
			}
		}
		for(Pista m : listaPistas) {
			if(m.getNombre().equals(nombre)) {
				pista=m;
			}
		}
		
		listaPistas.remove(pista);
		if(pista.asociarKartAPista(kart)) {
			listaKarts.remove(kart);
			listaPistas.add(pista);
			ficheroK.escribirFicheroKarts(listaKarts);
			ficheroP.escribirFicheroPistaDisponibles(listaPistas);
			System.out.println("Kart asociado a pista.");
		}
		else {
			listaPistas.add(pista);
			ficheroP.escribirFicheroPistaDisponibles(listaPistas);
			System.out.println("El kart no se ha podido asociar a esa pista.");
		}
	}
	
	public void buscarKartsYPista() throws FileNotFoundException, IOException{
		Ficheros fichero = new Ficheros();
		
		System.out.println("Introduce cantidad de karts: ");
		int cantidad = leer.nextInt();
		System.out.println("Introduce tipo de la pista: \n\t1.Infantil. \n\t2.Familiar. \n\t3.Adulto.");
		int difficul=leer.nextInt();
		Dificultad difficulty = Dificultad.infantil;
		if(difficul==1) {
			difficulty=Dificultad.infantil;
		}
		else if(difficul==2){
			difficulty=Dificultad.familiar;
		}
		else if(difficul==3) {
			difficulty=Dificultad.adulto;
		}
		listaPistas = fichero.cargarFicheroPistaDisponibles();
		for(Pista p : listaPistas) {
			if(p.getMaxKarts()>=cantidad) {
				if(p.getDificultad()==difficulty) {
					System.out.println(p.toString());
				}
			}
		}
	}
	
}