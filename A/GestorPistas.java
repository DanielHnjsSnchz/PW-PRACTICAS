package P1;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GestorPistas{

	private ArrayList<Pista> lista = new ArrayList<Pista>();
	
	public void MenuPistas() {
		int opcion;
		int aux;
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
					String nombre = leer.nextLine();
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
					
					Pista nuevapista = new Pista(nombre, estadoPista, dificultad, maxKarts);
					System.out.println(nuevapista.toString());
					
					break;
					
				case 2:
					System.out.println("Introduzca los datos necesarios para crear un kart.");
					System.out.println("ID:");
					int id = leer.nextInt();
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
					
					Kart nuevokart= new Kart(id, tipo, estadoKart);
					System.out.println(nuevokart.toString());

					break;
					
				case 3:
					
					break;
				case 4:
					ArrayList<Pista> pistasnoDisponibles =consultarPistasMantenimiento();				
					System.out.println(pistasnoDisponibles);
					break;
					
					
					
				
				
				
				case 6: 
					salir=true;
					break;
				default:
					break;
				
				}}catch (InputMismatchException e) {
					System.out.println("Debes insertar un numero");
					leer.next();
				}}
				
			
}
public ArrayList<Pista> consultarPistasMantenimiento(){
	ArrayList<Pista> pistasnoDisponibles = new ArrayList<Pista>();
	for (Pista l : lista) {
		if(l.getEstado()== false) {
			pistasnoDisponibles.add(l);
		}
	}
	return pistasnoDisponibles;
}
public ArrayList<Pista> consultarPistasparaNkarts(int nkart , Dificultad dificultad){
	ArrayList<Pista> consulta = new ArrayList<Pista>();

	return consulta;
}
}