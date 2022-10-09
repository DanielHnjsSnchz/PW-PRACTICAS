package P1.main;

import P1.pistas.GestorPistas;
import P1.reservas.GestorReservas;
import P1.usuarios.GestorUsuarios;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class MainMenu {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		Scanner leer = new Scanner(System.in);
		boolean salir = false;
		GestorPistas gestorPistas = new GestorPistas();
		GestorReservas gestorReservas = new GestorReservas();
		GestorUsuarios gestorUsuarios = new GestorUsuarios();
		
		System.out.println("Esta es una pagina para hacer reservas de Karts para carreras.");
		System.out.println("1. Menu de pistas");
		System.out.println("2. Menu de usuario");
		System.out.println("3. Menu de reservas");
		System.out.println("0. Salir");
		
		int opcion= leer.nextInt();
		while(!salir) {
			switch(opcion) {
			case 1:
				gestorPistas.MenuPistas();
				break;
				
			case 2:
				gestorUsuarios.MenuUsuarios();
				break;
				
			case 3:
				gestorReservas.MenuReservas();
				break;
				
			case 0:
				salir = true;
				break;
			}
		}
		leer.close();	
	}
}
