package P1;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GestorPistas{

	private ArrayList<Pista> listaPistas = new ArrayList<Pista>();	//Pistas que estan disponibles
	private ArrayList<Pista> listaPistasNoDisponibles = new ArrayList<Pista>();	//Pistas que no estan disponibles
	private ArrayList<Kart> listaKarts = new ArrayList<Kart>();		//Karts que no estan asignados
	public void MenuPistas() {
		int opcion;
		boolean salir = false;
		Scanner leer = new Scanner(System.in);

		while (!salir) {	
			System.out.println("1.Crear pista.\n2.Crear kart.\n3.Asociar kart a pista.\n4.Pistas en mantenimiento.\n5.Hacer consulta de pista libre para carrera.\n6.Salir");
			try {
				System.out.println("Introduce una opcion:");
				opcion = leer.nextInt();
				switch (opcion) {
				case 1:
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
					if(estado==1) {
						listaPistas.add(nuevaPista);
					}
					else if(estado==2){
						listaPistasNoDisponibles.add(nuevaPista);
					}	
					System.out.println(nuevaPista.toString());
					break;
					
				case 2:
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
					
					Kart nuevoKart= new Kart(idKart, tipo, estadoKart);
					listaKarts.add(nuevoKart);
					System.out.println(nuevoKart.toString());

					break;
					
				case 3:
					System.out.println("Introduce ID del kart: ");
					int id = leer.nextInt();
					System.out.println("Introduce nombre de la pista: ");
					leer.nextLine();
					String nombre = leer.nextLine();
					Kart kart = new Kart();
					Pista pista = new Pista();
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
					if(pista.asociarKartAPista(kart)) {
						System.out.println("Kart asociado a pista.");
						listaKarts.remove(kart);
					}
					else {
						System.out.println("El kart no se ha podido asociar a esa pista.");
					}
					
					break;
				case 4:
					for(Pista p : listaPistasNoDisponibles) {
						System.out.println(p.toString());
					}
					break;
				case 5:
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
					
					for(Pista p : listaPistas) {
						if(p.getMaxKarts()>=cantidad) {
							System.out.println("cantidad correcta");
							if(p.getDificultad()==difficulty) {
								System.out.println("dificultad correcta");
								System.out.println(p.toString());
							}
						}
					}
					break;
				case 6: 
					salir=true;
					break;
				default:
					break;
				}
			}catch (InputMismatchException e) {
					System.out.println("Debes insertar un numero");
					leer.next();
			}
		}
		leer.close();
	}
}