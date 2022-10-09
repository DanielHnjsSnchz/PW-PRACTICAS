package P1.reservas;

import P1.usuarios.Usuario;
import P1.pistas.Pista;
import P1.pistas.Dificultad;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDate;


public class GestorReservas {
	private ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
	private ArrayList<Reserva> listaReservas = new ArrayList<Reserva>();
	private ArrayList<Pista> listaPistas = new ArrayList<Pista>();
	private ArrayList<ReservaInfantil> listaReservaInfantil = new ArrayList<ReservaInfantil>();
	private ArrayList<ReservaAdultos> listaReservaAdultos = new ArrayList<ReservaAdultos>();
	private ArrayList<ReservaFamiliar> listaReservaFamiliar = new ArrayList<ReservaFamiliar>();
	
	Scanner leer = new Scanner(System.in);
	public GestorReservas() {
		
	}
	
	public void MenuReservas() {
		
		int opcion;
		boolean salir = false;

		while (!salir) {
			System.out.println("1.Reserva individual.\n2.Reserva en bono.\n3.Modificar reserva. \n4.Cancelar reserva. \n5.Consultar cantidad de reservas futuras. \n6.Consultar reservas para dia y pista. \n7.Salir");
			try {
				System.out.println("Introduce una opcion:");
				opcion = leer.nextInt();
				switch (opcion) {
				case 1:
					
					hacerReservaIndividual();
					
					
					
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
					hacerReservaBono();
					break;
					
				case 3:
					
					modificarReserva();
					
/*¿Que se puede modificar en la reserva? (fecha, pista, tipo, cantidad de participantes...)
 *¿Quien puede modificar la reserva? -- Supongo que la persona que la realiza
 */
 
					break;
				case 4:
					
					System.out.println("Usuario que la realizo(correo):");
					leer.nextLine();
					String idUsuario = leer.nextLine();
					if (!comprobarUsuarioAdulto(idUsuario, listaUsuarios)) {
						System.out.println("El usuario no se encuentra registrado o no es mayor de edad");
						System.exit(0);
					}
					else {
						System.out.println("Usuario correcto");
					}
					
					cancelarReserva(idUsuario);
					
					
/*¿Quien puede cancelar la reserva? -- Supongo que la persona que la realiza
* Pedir id de la reserva
* Buscar reserva en el array de reservas
* Pedir correo del usuario
* Comprobar que el id del usuario que creó la reserva es igual al introducido
* Eliminar reserva del array
*/
					break;
				case 5:
					System.out.println("Usuario que la realizo(correo):");
					leer.nextLine();
					String IdUsuario = leer.nextLine();
					if (!comprobarUsuarioAdulto(IdUsuario, listaUsuarios)) {
						System.out.println("El usuario no se encuentra registrado o no es mayor de edad");
						System.exit(0);
					}
					else {
						System.out.println("Usuario correcto");
					}
					
					mostrarReservas(IdUsuario);
					
/* Se usa la fecha del sistema
 * Mostrar todas las reservas con fecha posterior a la actual
 * fechActual<reserva.getFecha()
 */
					
					break;
				case 6:
					
					comprobarPista_Dia();
					 
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
	public boolean comprobarUsuarioAdulto(String idUsuario, ArrayList<Usuario> lista){
		for (Usuario u: lista) {
			if (u.getCorreo().contentEquals(idUsuario)) {
				if (u.mayoriaEdad()) {
					return true;
				}
			}
		}
	return false;	
	}
	
	public void hacerReservaIndividual(){
	System.out.println("Introduzca los datos necesarios para crear una reserva.");
	System.out.println("Usuario que la realiza(correo):");
	leer.nextLine();
	String idUsuario = leer.nextLine();
	if (!comprobarUsuarioAdulto(idUsuario, listaUsuarios)) {
		System.out.println("El usuario no se encuentra registrado o no es mayor de edad");
		System.exit(0);
	}
	else {
		System.out.println("Usuario correcto");
	}
	System.out.println("Duracion de la reserva: \n\t60 minutos. \n\t90 minutos. \n\t120 minutos.");
	int duracion=leer.nextInt();
	double precioReserva=0;
	
	if (duracion == 60) {
		precioReserva = 20;
		
	}
	
	else if (duracion == 90) {
		precioReserva = 30;
		
	}
	
	else if (duracion == 120) {
		precioReserva = 40;
		
	}
	else {
		System.out.println("No has introducido un valor valido");
		System.exit(0);
	}
	
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
	
	int comprobar=0;
	for (Pista p : listaPistas) {
		if (p.getNombre().equals(idPista) && p.getMaxKarts()>= numKarts && p.getDificultad() == dificultad ){
		System.out.println("La pista introducida puede ser reservada");
		comprobar=1;
		}
	}
	if ( comprobar == 0) {
		System.out.println("La pista introducida no se puede reservar o no existe");
		System.exit(0);
	}
	
	Usuario usuario = new Usuario();
	Pista pista = new Pista();
	
	for (Usuario u : listaUsuarios) {
		if (u.getCorreo().equals(idUsuario)) {
			usuario = u;
		}
		
	}
	
	for (Pista p : listaPistas) {
		if (p.getNombre().equals(idPista)) {
			pista = p;
		}
		
	}
	double descuento = 0;
	if (usuario.calcularAntiguedad() >= 2) {
		System.out.println("Se aplicara un descuento del 10% porque lleva mas de 2 anios registrado");
		descuento= 0.1;
	}
	
	IndividualReservas reservaIndividual = new IndividualReservas();
	if(dif==1) {
		reservaIndividual.crearReservaInfantil(usuario, duracion, pista, precioReserva, descuento , numKarts);
		System.out.println(reservaIndividual.toString()); 
	}
	else if(dif==2){
		int adults=0;
		int children=0;
		System.out.println("Introduce el numero de adultos en la carrera");
		leer.nextInt(adults);
		System.out.println("Introduce el numero de peques en la carrera");
		leer.nextInt(children);
		reservaIndividual.crearReservaFamiliar(usuario, duracion, pista, precioReserva, descuento , adults, children);
		System.out.println(reservaIndividual.toString()); 
	}
	else if(dif==3) {
		reservaIndividual.crearReservaAdulto(usuario, duracion, pista, precioReserva, descuento , numKarts);
		System.out.println(reservaIndividual.toString()); 
	}
	
}
	
	
	public void hacerReservaBono(){
		System.out.println("Introduzca los datos necesarios para crear una reserva.");
		System.out.println("Usuario que la realiza(correo):");
		leer.nextLine();
		String idUsuario = leer.nextLine();
		if (!comprobarUsuarioAdulto(idUsuario, listaUsuarios)) {
			System.out.println("El usuario no se encuentra registrado o no es mayor de edad");
			System.exit(0);
		}
		else {
			System.out.println("Usuario correcto");
		}
		System.out.println("Duracion de la reserva: \n\t60 minutos. \n\t90 minutos. \n\t120 minutos.");
		int duracion=leer.nextInt();
		double precioReserva=0;
		
		if (duracion == 60) {
			precioReserva = 20;
			
		}
		
		else if (duracion == 90) {
			precioReserva = 30;
			
		}
		
		else if (duracion == 120) {
			precioReserva = 40;
			
		}
		else {
			System.out.println("No has introducido un valor valido");
			System.exit(0);
		}
		
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
		
		int comprobar=0;
		for (Pista p : listaPistas) {
			if (p.getNombre().equals(idPista) && p.getMaxKarts()>= numKarts && p.getDificultad() == dificultad ){
			System.out.println("La pista introducida puede ser reservada");
			comprobar=1;
			}
		}
		if ( comprobar == 0) {
			System.out.println("La pista introducida no se puede reservar o no existe");
			System.exit(0);
		}
		
		Usuario usuario = new Usuario();
		Pista pista = new Pista();
		
		for (Usuario u : listaUsuarios) {
			if (u.getCorreo().equals(idUsuario)) {
				usuario = u;
			}
			
		}
		
		for (Pista p : listaPistas) {
			if (p.getNombre().equals(idPista)) {
				pista = p;
			}
			
		}
		double descuento = 0.05;
		
		BonoReservas reservaBono = new BonoReservas();
		if(dif==1) {
			reservaBono.crearReservaInfantil(usuario, duracion, pista, precioReserva, descuento , numKarts);
			System.out.println(reservaBono.toString()); 
		}
		else if(dif==2){
			int adults=0;
			int children=0;
			System.out.println("Introduce el numero de adultos en la carrera");
			leer.nextInt(adults);
			System.out.println("Introduce el numero de peques en la carrera");
			leer.nextInt(children);
			reservaBono.crearReservaFamiliar(usuario, duracion, pista, precioReserva, descuento , adults, children);
			System.out.println(reservaBono.toString()); 
		}
		else if(dif==3) {
			reservaBono.crearReservaAdulto(usuario, duracion, pista, precioReserva, descuento , numKarts);
			System.out.println(reservaBono.toString()); 
		}
		
	}
	
	@SuppressWarnings("static-access")
	public void modificarReserva() {
		System.out.println("Usuario que la realizo(correo):");
		leer.nextLine();
		String idUsuario = leer.nextLine();
		if (!comprobarUsuarioAdulto(idUsuario, listaUsuarios)) {
			System.out.println("El usuario no se encuentra registrado o no es mayor de edad");
			System.exit(0);
		}
		else {
			System.out.println("Usuario correcto");
		}
		
		System.out.println("¿Que tipo de reserva es? \n\t1.Infantil. \n\t2.Familiar. \n\t3.Adulto.");
		int dif=leer.nextInt();
		if(dif==1) {
			ReservaInfantil reserva = new ReservaInfantil();
			for (int i=0; i<listaReservaInfantil.size() ; i++)  {
				reserva=listaReservaInfantil.get(i);
				if (reserva.idReservaUsuario.equals(idUsuario))
					System.out.println("Introduce un intro en los parametros que no quieras cambiar");
					System.out.println("Correo: ");
					leer.nextLine();
					String correo = leer.nextLine();
					if (correo != "\n") {
						reserva.setIdReservaUsuario(correo);
					}
					System.out.println("Correo: ");
					
					System.out.println("Introduce un 0 si no quieres cambiar la fecha");
				    System.out.println("Dia: ");
					int dia=leer.nextInt();
					System.out.println("Mes: ");
					int mes=leer.nextInt();
					System.out.println("Year: ");
					int year=leer.nextInt();
					if (dia != 0 && mes != 0 && year != 0 ) {
						LocalDate fecha = null;
						fecha.of(year, mes, dia);
						reserva.setFecha(fecha);
					}
					System.out.println("Duracion de la reserva: \n\t60 minutos. \n\t90 minutos. \n\t120 minutos.");
					int duracion=leer.nextInt();
					reserva.setDuracion(duracion);
					if (duracion==60) {
						reserva.setPrecio(20);
					}
					else if (duracion==90) {
						reserva.setPrecio(30);
					}
					else if (duracion==120) {
						reserva.setPrecio(40);
					}
					System.out.println("Introduce el nombre de la nueva pista");
					leer.nextLine();
					String nombrepista= leer.nextLine();
					System.out.println("Introduce el numero de participantes");
					int numKarts = leer.nextInt();
					if (nombrepista != "\n") {
						for (Pista p : listaPistas) {
							if (p.getNombre().equals(nombrepista) && p.getMaxKarts()>= numKarts && p.getDificultad() == Dificultad.infantil) {
								reserva.setIdReservaPista(nombrepista);
							}
						}
					}		
					listaReservaInfantil.set(i,reserva);
			}
		}
		else if(dif==2) {
			ReservaFamiliar reserva = new ReservaFamiliar();
			for (int i=0; i<listaReservaFamiliar.size() ; i++)  {
				reserva=listaReservaFamiliar.get(i);
				if (reserva.idReservaUsuario.equals(idUsuario))
					System.out.println("Introduce un intro en los parametros que no quieras cambiar");
					System.out.println("Correo: ");
					leer.nextLine();
					String correo = leer.nextLine();
					if (correo != "\n") {
						reserva.setIdReservaUsuario(correo);
					}
					System.out.println("Correo: ");
					
					System.out.println("Introduce un 0 si no quieres cambiar la fecha");
				    System.out.println("Dia: ");
					int dia=leer.nextInt();
					System.out.println("Mes: ");
					int mes=leer.nextInt();
					System.out.println("Year: ");
					int year=leer.nextInt();
					if (dia != 0 && mes != 0 && year != 0 ) {
						LocalDate fecha = null;
						fecha.of(year, mes, dia);
						reserva.setFecha(fecha);
					}
					System.out.println("Duracion de la reserva: \n\t60 minutos. \n\t90 minutos. \n\t120 minutos.");
					int duracion=leer.nextInt();
					reserva.setDuracion(duracion);
					if (duracion==60) {
						reserva.setPrecio(20);
					}
					else if (duracion==90) {
						reserva.setPrecio(30);
					}
					else if (duracion==120) {
						reserva.setPrecio(40);
					}
					System.out.println("Introduce el nombre de la nueva pista");
					leer.nextLine();
					String nombrepista= leer.nextLine();
					System.out.println("Introduce el numero de participantes");
					int numKarts = leer.nextInt();
					if (nombrepista != "\n") {
						for (Pista p : listaPistas) {
							if (p.getNombre().equals(nombrepista) && p.getMaxKarts()>= numKarts && p.getDificultad() == Dificultad.infantil) {
								reserva.setIdReservaPista(nombrepista);
							}
						}
					}		
					listaReservaFamiliar.set(i,reserva);
			}
		}
		else if(dif==3) {
			{
				ReservaAdultos reserva = new ReservaAdultos();
				for (int i=0; i<listaReservaAdultos.size() ; i++)  {
					reserva=listaReservaAdultos.get(i);
					if (reserva.idReservaUsuario.equals(idUsuario))
						System.out.println("Introduce un intro en los parametros que no quieras cambiar");
						System.out.println("Correo: ");
						leer.nextLine();
						String correo = leer.nextLine();
						if (correo != "\n") {
							reserva.setIdReservaUsuario(correo);
						}
						System.out.println("Correo: ");
						
						System.out.println("Introduce un 0 si no quieres cambiar la fecha");
					    System.out.println("Dia: ");
						int dia=leer.nextInt();
						System.out.println("Mes: ");
						int mes=leer.nextInt();
						System.out.println("Year: ");
						int year=leer.nextInt();
						if (dia != 0 && mes != 0 && year != 0 ) {
							LocalDate fecha = null;
							fecha.of(year, mes, dia);
							reserva.setFecha(fecha);
						}
						System.out.println("Duracion de la reserva: \n\t60 minutos. \n\t90 minutos. \n\t120 minutos.");
						int duracion=leer.nextInt();
						reserva.setDuracion(duracion);
						if (duracion==60) {
							reserva.setPrecio(20);
						}
						else if (duracion==90) {
							reserva.setPrecio(30);
						}
						else if (duracion==120) {
							reserva.setPrecio(40);
						}
						System.out.println("Introduce el nombre de la pista");
						leer.nextLine();
						String nombrepista= leer.nextLine();
						System.out.println("Introduce el numero de participantes");
						int numKarts = leer.nextInt();
						if (nombrepista != "\n") {
							for (Pista p : listaPistas) {
								if (p.getNombre().equals(nombrepista) && p.getMaxKarts()>= numKarts && p.getDificultad() == Dificultad.infantil) {
									reserva.setIdReservaPista(nombrepista);
								}
							}
						}		
						listaReservaAdultos.set(i,reserva);
				}
			}
		}
		
		
		
	}
	
	public void cancelarReserva(String IdUsuario) {
		for (Reserva r: listaReservas) {
			if (r.getIdReservaUsuario().equals(IdUsuario)) {
				listaReservas.remove(r);
				System.out.println("Reserva cancelada con exito");
			}
			else {
				System.out.println("Error cancelando la reserva");
				System.exit(0);
			}
			
		}
		
	}
	
	public void mostrarReservas(String IdUsuario) {
		LocalDate fechaActual = null;
		fechaActual = LocalDate.now();
		for (Reserva r: listaReservas) {
			if (r.getIdReservaUsuario().equals(IdUsuario)) {
					if  (r.getFecha().compareTo(fechaActual) > 0) {
						System.out.println(r.toString());
					}
						
					}
				
			}
		
	}
	
	@SuppressWarnings("static-access")
	public void comprobarPista_Dia(){
		LocalDate fecha = null;
		
		System.out.println("Introduce el nombre de la pista");
		leer.nextLine();
		String nombrepista= leer.nextLine();
		System.out.println("Fecha: ");
		System.out.println("Dia: ");
		int dia=leer.nextInt();
		System.out.println("Mes: ");
		int mes=leer.nextInt();
		System.out.println("Year: ");
		int year=leer.nextInt();
		if (dia != 0 && mes != 0 && year != 0 ) {
			fecha.of(year, mes, dia);
		}
		for (Reserva r : listaReservas) {
				if (r.getFecha().compareTo(fecha)==0 && r.getIdReservaPista().equals(nombrepista)) {
					System.out.println(r.toString());
					
				}
		}
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
