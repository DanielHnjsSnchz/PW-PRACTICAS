package P1.reservas;

import P1.ficheros.Ficheros;
import P1.usuarios.Usuario;
import P1.pistas.Pista;
import P1.pistas.Dificultad;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;

public class GestorReservas {

	private ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
	private ArrayList<Pista> listaPistas = new ArrayList<Pista>();
	private ArrayList<ReservaInfantil> listaReservaInfantil = new ArrayList<ReservaInfantil>();
	private ArrayList<ReservaAdultos> listaReservaAdultos = new ArrayList<ReservaAdultos>();
	private ArrayList<ReservaFamiliar> listaReservaFamiliar = new ArrayList<ReservaFamiliar>();
	
	Scanner leer = new Scanner(System.in);
	
	public void MenuReservas() throws FileNotFoundException, IOException {
		int opcion;
		boolean salir = false;

		while (!salir) {
			System.out.println("1.Reserva individual.\n2.Reserva en bono.\n3.Modificar reserva. \n4.Cancelar reserva. \n5.Consultar cantidad de reservas futuras. \n6.Consultar reservas para dia y pista. \n7.Salir.");
			try {
				System.out.println("Introduce una opcion:");
				opcion = leer.nextInt();
				switch (opcion) {
				case 1:
					hacerReservaIndividual();		
					break;
					
				case 2:
					hacerReservaBono();
					break;
					
				case 3:
					modificarReserva(); 
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
					break;
					
				case 6:
					comprobarPista_Dia();
					break;
					
				case 7:
					salir=true;
					break;
					
				default:
					System.out.println("La opcion elegida no es valida.");
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
	
	public void hacerReservaIndividual() throws FileNotFoundException, IOException{
		Ficheros ficheroU = new Ficheros();
		Ficheros ficheroP = new Ficheros();
		Ficheros ficheroR = new Ficheros();
		System.out.println("Introduzca los datos necesarios para crear una reserva.");
		System.out.println("Usuario que la realiza(correo):");
		leer.nextLine();
		String idUsuario = leer.nextLine();
		
		listaUsuarios = ficheroU.cargarFicheroUsuarios();
		if (!comprobarUsuarioAdulto(idUsuario, listaUsuarios)) {
			System.out.println("El usuario no se encuentra registrado o no es mayor de edad");
			System.exit(0);
		} else {
			System.out.println("Usuario correcto");
		}
		
		System.out.println("Duracion de la reserva: \n\t60 minutos. \n\t90 minutos. \n\t120 minutos.");
		int duracion = leer.nextInt();
		double precioReserva = 0;

		if (duracion == 60) {
			precioReserva = 20;
		}else if (duracion == 90) {
			precioReserva = 30;
		}else if (duracion == 120) {
			precioReserva = 40;
		}else {
			System.out.println("No has introducido un valor valido");
			System.exit(0);
		}

		System.out.println("Pista a reservar(nombre):");
		leer.nextLine();
		String idPista = leer.nextLine();
		System.out.println("Cantidad de participantes:");
		int numKarts = leer.nextInt();
		System.out.println("¿Que tipo de reserva es? \n\t1.Infantil. \n\t2.Familiar. \n\t3.Adulto.");
		int dif = leer.nextInt();
		Dificultad dificultad = Dificultad.infantil;
		if (dif == 1) {
			dificultad = Dificultad.infantil;
		}else if (dif == 2) {
			dificultad = Dificultad.familiar;
		}else if (dif == 3) {
			dificultad = Dificultad.adulto;
		}

		listaPistas = ficheroP.cargarFicheroPistaDisponibles();
		int comprobar = 0;
		for (Pista p : listaPistas) {
			if (p.getNombre().equals(idPista) && p.getMaxKarts() >= numKarts && p.getDificultad() == dificultad) {
				System.out.println("La pista introducida puede ser reservada");
				comprobar = 1;
			}
		}
		if (comprobar == 0) {
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
			descuento = 0.1;
		}

		IndividualReservas reservaIndividual = new IndividualReservas();
		if(dif == 1) {
			listaReservaInfantil = ficheroR.cargarFicheroReservaInfantil();
			listaReservaInfantil.add(reservaIndividual.crearReservaInfantil(usuario, duracion, pista, precioReserva, descuento, numKarts));
			ficheroR.escribirFicheroReservaInfantil(listaReservaInfantil);
			System.out.println(reservaIndividual.toString());
		}else if (dif == 2) {
			int adults = 0;
			int children = 0;
			System.out.println("Introduce el numero de adultos en la carrera");
			leer.nextInt(adults);
			System.out.println("Introduce el numero de peques en la carrera");
			leer.nextInt(children);
			
			listaReservaFamiliar = ficheroR.cargarFicheroReservaFamiliar();
			listaReservaFamiliar.add(reservaIndividual.crearReservaFamiliar(usuario, duracion, pista, precioReserva, descuento, adults, children));
			ficheroR.escribirFicheroReservaFamiliar(listaReservaFamiliar);
			System.out.println(reservaIndividual.toString());
		}else if (dif == 3) {
			listaReservaAdultos = ficheroR.cargarFicheroReservaAdulto();
			listaReservaAdultos.add(reservaIndividual.crearReservaAdulto(usuario, duracion, pista, precioReserva, descuento, numKarts));
			ficheroR.escribirFicheroReservaAdulto(listaReservaAdultos);
			System.out.println(reservaIndividual.toString());
		}
	}
	
	public void hacerReservaBono() throws FileNotFoundException, IOException{
		Ficheros ficheroU = new Ficheros();
		Ficheros ficheroP = new Ficheros();
		Ficheros ficheroR = new Ficheros();
		
		System.out.println("Introduzca los datos necesarios para crear una reserva.");
		System.out.println("Usuario que la realiza(correo):");
		leer.nextLine();
		String idUsuario = leer.nextLine();
		
		listaUsuarios = ficheroU.cargarFicheroUsuarios();
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
		
		if(duracion == 60) {
			precioReserva = 20;	
		}else if(duracion == 90) {
			precioReserva = 30;
		}else if(duracion == 120) {
			precioReserva = 40;
		}else {
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
		listaPistas = ficheroP.cargarFicheroPistaDisponibles();
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
			listaReservaInfantil = ficheroR.cargarFicheroReservaInfantil();
			listaReservaInfantil.add(reservaBono.crearReservaInfantil(usuario, duracion, pista, precioReserva, descuento , numKarts));
			ficheroR.escribirFicheroReservaInfantil(listaReservaInfantil);
			System.out.println(reservaBono.toString()); 
		}
		else if(dif==2){
			int adults=0;
			int children=0;
			System.out.println("Introduce el numero de adultos en la carrera");
			leer.nextInt(adults);
			System.out.println("Introduce el numero de peques en la carrera");
			leer.nextInt(children);
			listaReservaFamiliar = ficheroR.cargarFicheroReservaFamiliar();
			listaReservaFamiliar.add(reservaBono.crearReservaFamiliar(usuario, duracion, pista, precioReserva, descuento, adults, children));
			ficheroR.escribirFicheroReservaFamiliar(listaReservaFamiliar);
			System.out.println(reservaBono.toString()); 
		}
		else if(dif==3) {
			listaReservaAdultos = ficheroR.cargarFicheroReservaAdulto();
			listaReservaAdultos.add(reservaBono.crearReservaAdulto(usuario, duracion, pista, precioReserva, descuento, numKarts));
			ficheroR.escribirFicheroReservaAdulto(listaReservaAdultos);
			System.out.println(reservaBono.toString()); 
		}
	}
	
	@SuppressWarnings("static-access")
	public void modificarReserva() throws FileNotFoundException, IOException{
		Ficheros ficheroU = new Ficheros();
		Ficheros ficheroP = new Ficheros();
		Ficheros ficheroR = new Ficheros();
		
		System.out.println("Usuario que la realizo(correo):");
		leer.nextLine();
		String idUsuario = leer.nextLine();
		listaUsuarios = ficheroU.cargarFicheroUsuarios();
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
			listaReservaInfantil = ficheroR.cargarFicheroReservaInfantil();
			for (int i=0; i<listaReservaInfantil.size() ; i++)  {
				reserva=listaReservaInfantil.get(i);
				if (reserva.getIdReservaUsuario().equals(idUsuario))
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
					listaPistas = ficheroP.cargarFicheroPistaDisponibles();
					if (nombrepista != "\n") {
						for (Pista p : listaPistas) {
							if (p.getNombre().equals(nombrepista) && p.getMaxKarts()>= numKarts && p.getDificultad() == Dificultad.infantil) {
								reserva.setIdReservaPista(nombrepista);
							}
						}
					}		
					listaReservaInfantil.set(i,reserva);
			}
			ficheroR.escribirFicheroReservaInfantil(listaReservaInfantil);
		}
		else if(dif==2) {
			ReservaFamiliar reserva = new ReservaFamiliar();
			listaReservaFamiliar = ficheroR.cargarFicheroReservaFamiliar();
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
			ficheroR.escribirFicheroReservaFamiliar(listaReservaFamiliar);
		}
		else if(dif==3) {
				ReservaAdultos reserva = new ReservaAdultos();
				listaReservaAdultos = ficheroR.cargarFicheroReservaAdulto();
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
			ficheroR.escribirFicheroReservaAdulto(listaReservaAdultos);
		}
	
	public void cancelarReserva(String IdUsuario) throws FileNotFoundException, IOException{
		Ficheros ficheroA = new Ficheros();
		Ficheros ficheroF = new Ficheros();
		Ficheros ficheroI = new Ficheros();
		listaReservaAdultos = ficheroA.cargarFicheroReservaAdulto();
		listaReservaFamiliar = ficheroF.cargarFicheroReservaFamiliar();
		listaReservaInfantil = ficheroI.cargarFicheroReservaInfantil();
		
		for (Reserva r: listaReservaAdultos) {
			if (r.getIdReservaUsuario().equals(IdUsuario)) {
				listaReservaAdultos.remove(r);
				System.out.println("Reserva cancelada con exito");
			}
		}
		for (Reserva r: listaReservaFamiliar) {
			if (r.getIdReservaUsuario().equals(IdUsuario)) {
				listaReservaFamiliar.remove(r);
				System.out.println("Reserva cancelada con exito");
			}
		}
		for (Reserva r: listaReservaInfantil) {
			if (r.getIdReservaUsuario().equals(IdUsuario)) {
				listaReservaInfantil.remove(r);
				System.out.println("Reserva cancelada con exito");
			}
		}
	}

	public void mostrarReservas(String IdUsuario) throws FileNotFoundException, IOException{
		Ficheros ficheroA = new Ficheros();
		Ficheros ficheroF = new Ficheros();
		Ficheros ficheroI = new Ficheros();
		listaReservaAdultos = ficheroA.cargarFicheroReservaAdulto();
		listaReservaFamiliar = ficheroF.cargarFicheroReservaFamiliar();
		listaReservaInfantil = ficheroI.cargarFicheroReservaInfantil();
		
		LocalDate fechaActual = null;
		fechaActual = LocalDate.now();
		for (Reserva r: listaReservaAdultos) {
			if (r.getIdReservaUsuario().equals(IdUsuario)) {
				if  (r.getFecha().compareTo(fechaActual) > 0) {
					System.out.println(r.toString());
				}	
			}	
		}
		for (Reserva r: listaReservaFamiliar) {
			if (r.getIdReservaUsuario().equals(IdUsuario)) {
				if  (r.getFecha().compareTo(fechaActual) > 0) {
					System.out.println(r.toString());
				}	
			}	
		}
		for (Reserva r: listaReservaInfantil) {
			if (r.getIdReservaUsuario().equals(IdUsuario)) {
				if  (r.getFecha().compareTo(fechaActual) > 0) {
					System.out.println(r.toString());
				}	
			}	
		}
	}
	
	@SuppressWarnings("static-access")
	public void comprobarPista_Dia() throws FileNotFoundException, IOException{
		Ficheros ficheroA = new Ficheros();
		Ficheros ficheroF = new Ficheros();
		Ficheros ficheroI = new Ficheros();
		listaReservaAdultos = ficheroA.cargarFicheroReservaAdulto();
		listaReservaFamiliar = ficheroF.cargarFicheroReservaFamiliar();
		listaReservaInfantil = ficheroI.cargarFicheroReservaInfantil();
		
		LocalDate fecha = null;
		
		System.out.println("Introduce el nombre de la pista");
		leer.nextLine();
		String nombrepista= leer.nextLine();
		System.out.println("Introduce fecha: ");
		System.out.println("Dia: ");
		int dia=leer.nextInt();
		System.out.println("Mes: ");
		int mes=leer.nextInt();
		System.out.println("Año: ");
		int year=leer.nextInt();
		if (dia != 0 && mes != 0 && year != 0 ) {
			fecha.of(year, mes, dia);
		}
		for (Reserva r : listaReservaAdultos) {
			if (r.getFecha().compareTo(fecha)==0 && r.getIdReservaPista().equals(nombrepista)) {
				System.out.println(r.toString());	
			}
		}
		for (Reserva r : listaReservaFamiliar) {
			if (r.getFecha().compareTo(fecha)==0 && r.getIdReservaPista().equals(nombrepista)) {
				System.out.println(r.toString());	
			}
		}
		for (Reserva r : listaReservaInfantil) {
			if (r.getFecha().compareTo(fecha)==0 && r.getIdReservaPista().equals(nombrepista)) {
				System.out.println(r.toString());	
			}
		}
	}	
}
