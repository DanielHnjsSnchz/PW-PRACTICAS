package P1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GestorReservas {
	
	public void MenuReservas() {
		Scanner leer = new Scanner(System.in);
		int opcion;
		boolean salir = false;

		while (!salir) {
			System.out.println("1.Reserva individual.\n2.Reserva en bono.\n3.Modificar reserva. \n4.Cancelar reserva. \n5.Consultar cantidad de reservas futuras. \n6.Consultar reservas para dia y pista. \n7.Salir");
			try {
				System.out.println("Introduce una opcion:");
				opcion = leer.nextInt();
				switch (opcion) {
				case 1:
					System.out.println("Introduzca los datos necesarios para crear una reserva.");
					System.out.println("Usuario que la realiza(correo):");
					leer.nextLine();
					String idUsuario = leer.nextLine();
					System.out.println("Duracion de la reserva: \n\t60 minutos. \n\t90 minutos. \n\t120 minutos.");
					int duracion=leer.nextInt();
					System.out.println("Pista a reservar(nombre):");
					leer.nextLine();
					String idPista=leer.nextLine();
					System.out.println("Cantidad de participantes:");
					int numKarts=leer.nextInt();
					System.out.println("¿Que tipo de reserva es? \n\t1.Infantil. \n\t2.Familiar. \n\t3.Adulto.");
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
					
/* Buscar el usuario en el sistema
 * Mirar que tipo de usuario es
 * Comprobar que el usuario puede reservar 
 * 
 * Buscar la pista en el sistema
 * Mirar que tipo de pista es
 * 
 * Comprobar que la pista corresponde con el tipo de reserva
 * Comprobar que el numero de karts de la pista es mayor a la cantidad de participantes
 * 
 * Comprobar ambiguedad del usuario para aplicar descuento
 * Establecer precio dependiendo del tiempo
 * Llamada a .precioFinal para mostrar precio final
 */
					
					break;
					
				case 2:
					
					break;
					
				case 3:
/*¿Que se puede modificar en la reserva? (fecha, pista, tipo, cantidad de participantes...)
 *¿Quien puede modificar la reserva? -- Supongo que la persona que la realiza
 */
 
					break;
				case 4:
/*¿Quien puede cancelar la reserva? -- Supongo que la persona que la realiza
* Pedir id de la reserva
* Buscar reserva en el array de reservas
* Pedir correo del usuario
* Comprobar que el id del usuario que creó la reserva es igual al introducido
* Eliminar reserva del array
*/
					break;
				case 5:
/* Se usa la fecha del sistema
 * Mostrar todas las reservas con fecha posterior a la actual
 * fechActual<reserva.getFecha()
 */
					break;
				case 6:
/* Introducir pista
 * Introducir dia
 * Comprobar que la pista existe
 * Comprobar si la pista esta reservada para el dia introducido
 */
					break;
				case 7: 
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
