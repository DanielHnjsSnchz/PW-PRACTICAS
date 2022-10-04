package P1;

import java.util.Scanner;

public class MainMenu {

	public static void main(String[] args) {
		
		Scanner leer = new Scanner(System.in);
		GestorPistas gestorPistas = new GestorPistas();
		System.out.println("Esta es una pagina para hacer reservas de Karts para carreras");
		System.out.println("Introduzca 1 para acceder al menu de pistas");
		System.out.println("Introduzca 2 para acceder al menu de usuario");
		System.out.println("Introduzca 3 para acceder al menu de reservas");
		
		int opcion= leer.nextInt();
		
		if (opcion == 1) {
			gestorPistas.MenuPistas();
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
	}
}
