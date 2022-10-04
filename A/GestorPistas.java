package P1;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GestorPistas extends MainMenu{

	private ArrayList<Pista> lista = new ArrayList<Pista>();
public void MenuReservas() {
			
			int opcion;
			int aux;
			boolean salir = false;
			Scanner leer = new Scanner(System.in);
			
				while (!salir) {
					
				
				String [] opciones = {"1.Crear pista" , "2.Crear kart" , "3.Asociar kart a pista" , "4.Pistas en mantenimiento", "5.Hacer consulta de pista libre para carrera", "6.Salir"};
				try {
					
				System.out.println("Introduce una opcion");
				opcion = leer.nextInt();
				switch (opcion) {
				case 1:
					Pista nuevapista = new Pista();
					System.out.println("Introduzca los datos necesarios para crear una pista");
					System.out.println("Nombre");
					nuevapista.setNombre(leer.nextLine());
					System.out.println("Estado pista: 1.disponible,\r\n"
							+ "	2.reservado o mantenimiento");
					aux=leer.nextInt();
					if(aux== 1) {
						nuevapista.setEstado(true);
					}
					else if(aux== 2) {
						nuevapista.setEstado(false);
					}
					System.out.println("Dificultad: 1.infantil,\r\n"
							+ "		2.familiar,\r\n"
							+ "		3.adulto");
					aux=leer.nextInt();
					if(aux==1) {
						nuevapista.setDificultad(Dificultad.infantil);
					}
					else if(aux==2) {
						nuevapista.setDificultad(Dificultad.familiar);
					}
					else if(aux==3) {
						nuevapista.setDificultad(Dificultad.adulto);
					}
					System.out.println("Numero max de karts permitidos");
					nuevapista.setMaxKarts(leer.nextInt());	
					break;
					
				case 2:
					Kart nuevokart= new Kart();
					System.out.println("Introduzca los datos necesarios para crear un kart");
					System.out.println("ID");
					nuevokart.setId(leer.nextInt());
					System.out.println("Tipo de Kart: 1.adultos,\r\n"
							+ "	2.niños");
					aux=leer.nextInt();
					if(aux== 1) {
						nuevokart.setTipo(true);
					}
					else if(aux== 2) {
						nuevokart.setTipo(false);
					}
					System.out.println("Estado del kart: 1.Disponible,\r\n"
							+ "		2.Reservado,\r\n"
							+ "		3.Mantenimiento");
					aux=leer.nextInt();
					if(aux ==1) {
						nuevokart.setEstado(Estado.disponible);
					}
					else if(aux ==2) {
						nuevokart.setEstado(Estado.reservado);
					}
					else if(aux==3) {
						nuevokart.setEstado(Estado.mantenimiento);
					}
									
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

