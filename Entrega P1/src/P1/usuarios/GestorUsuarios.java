package P1.usuarios;

import P1.ficheros.Ficheros;
import java.util.*;
import java.time.LocalDate;
import java.io.FileNotFoundException;
import java.io.IOException;

public class GestorUsuarios {
	private ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();	//Usuarios que estan registrados

	Scanner leer = new Scanner(System.in);

	@SuppressWarnings("static-access")
	public void MenuUsuarios() throws FileNotFoundException, IOException{
		int opcion;
		boolean salir = false;

		while (!salir) {
			System.out.println("1.Dar de alta a un usuario.\n2.Modificar un usuario.\n3.Modificar nombre y apellidos de un usuario.\n4.Modificar fecha de nacimiento de un usuario.\n5.Modificar correo de un usuario.\n6.Mostrar el listado de clientes.\n7.SALIR.\n");
			try {
				System.out.println("Introduce una opcion:");
				opcion = leer.nextInt();
				switch (opcion) {
				case 1:
					if(altaUsuario()) {
						System.out.println("Usuario dado de alta.");
					}
					else
						System.out.println("El usuario no ha podido ser dado de alta.");
					
					break;
					
				case 2:
					if(modificarUsuario()) {
						System.out.println("Usuario modificado.");
					}
					else
						System.out.println("El usuario no ha podido ser modificado.");
					break;
					
				case 3:
					if(modificarUsuarioNombre()) {
						System.out.println("Usuario modificado.");
					}
					else
						System.out.println("El usuario no ha podido ser modificado.");
					break;
					
				case 4:
					if(modificarUsuarioFecha()) {
						System.out.println("Usuario modificado.");
					}
					else
						System.out.println("El usuario no ha podido ser modificado.");
					break;
					
				case 5:
					if(modificarUsuarioCorreo()) {
						System.out.println("Usuario modificado.");
					}
					else
						System.out.println("El usuario no ha podido ser modificado.");
					break;
					
				case 6:
					listadoUsuarios();
					break;
					
				case 7:
					salir = true;
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

	@SuppressWarnings("static-access")
	public boolean altaUsuario() throws FileNotFoundException, IOException{
		Ficheros fichero = new Ficheros();
		
		System.out.println("\nIntroduzca el nombre y los apellidos del nuevo usuario:");
		leer.nextLine();
		String nombre = leer.nextLine();
		System.out.println("Introduzca el dia de nacimiento del usuario:");
		int dia = leer.nextInt();
		System.out.println("Introduzca el mes de nacimiento del usuario:");
		int mes = leer.nextInt();
		System.out.println("Introduzca el año de nacimiento del usuario:");
		int year = leer.nextInt();
		System.out.println("Introduzca el correo del nuevo usuario:");
		leer.nextLine();
		String correo = leer.nextLine();
		
		LocalDate fechaNacimientoFormatted = LocalDate.now();
		fechaNacimientoFormatted.of(year, mes, dia);

		listaUsuarios = fichero.cargarFicheroUsuarios();
		Usuario usuario = new Usuario();
		
		for(Usuario u : listaUsuarios) {
			usuario = u;

			if(usuario.getCorreo()==correo){
				System.out.print("Ya existe el usuario.");
				return false;
			}
		}
		LocalDate fechaInscripcion = LocalDate.now();
		usuario.setNombreApellidos(nombre);
		usuario.setFecha(fechaNacimientoFormatted);
		usuario.setInscripcion(fechaInscripcion);
		usuario.setCorreo(correo);

		listaUsuarios.add(usuario);
		fichero.escribirFicheroUsuarios(listaUsuarios);
		return true;
	}

	@SuppressWarnings("static-access")
	public boolean modificarUsuario() throws FileNotFoundException, IOException{
		Ficheros fichero = new Ficheros();
		
		Usuario usuario = new Usuario();

		System.out.println("Introduzca el correo antiguo del usuario a modificar:");
		leer.nextLine();
		String correoAntiguo = leer.nextLine();
		System.out.println("\nIntroduzca el nombre y los apellidos del nuevo usuario:");
		String nombre = leer.nextLine();
		System.out.println("Introduzca el dia de nacimiento del usuario:");
		int dia = leer.nextInt();
		System.out.println("Introduzca el mes de nacimiento del usuario:");
		int mes = leer.nextInt();
		System.out.println("Introduzca el año de nacimiento del usuario:");
		int year = leer.nextInt();
		System.out.println("Introduzca el correo del usuario a modificar:");
		leer.nextLine();
		String correoMod = leer.nextLine();
		
		LocalDate fechaNacimientoFormatted = LocalDate.now();
		fechaNacimientoFormatted.of(year,mes,dia);
		
		listaUsuarios = fichero.cargarFicheroUsuarios();
		
		for(int i = 0; i < listaUsuarios.size(); i++) {
			usuario = listaUsuarios.get(i);

			if(usuario.getCorreo()==correoAntiguo){
				usuario.setNombreApellidos(nombre);
				usuario.setFecha(fechaNacimientoFormatted);
				usuario.setCorreo(correoMod);

				listaUsuarios.set(i,usuario);
				fichero.escribirFicheroUsuarios(listaUsuarios);
				return true;
			}
		}
		return false;
	}

	public boolean modificarUsuarioNombre() throws FileNotFoundException, IOException{
		Ficheros fichero = new Ficheros();
		Usuario usuario = new Usuario();
		
		System.out.println("Introduzca el correo del usuario a modificar:");
		leer.nextLine();
		String correo = leer.nextLine();
		System.out.println("Introduzca el nombre y los apellidos:");
		String nombre = leer.nextLine();

		listaUsuarios = fichero.cargarFicheroUsuarios();
		for(int i = 0; i < listaUsuarios.size(); i++) {
			usuario = listaUsuarios.get(i);

			if(usuario.getCorreo()==correo){
				usuario.setNombreApellidos(nombre);
				
				listaUsuarios.set(i,usuario);
				fichero.escribirFicheroUsuarios(listaUsuarios);
				return true;
			}
		}
		return false;
	}

	@SuppressWarnings("static-access")
	public boolean modificarUsuarioFecha() throws FileNotFoundException, IOException{
		Ficheros fichero = new Ficheros();
		Usuario usuario = new Usuario();

		System.out.println("Introduzca el correo del usuario a modificar:");
		leer.nextLine();
		String correo = leer.nextLine();
		System.out.println("Introduzca el dia de nacimiento del usuario:");
		int dia = leer.nextInt();
		System.out.println("Introduzca el mes de nacimiento del usuario:");
		int mes = leer.nextInt();
		System.out.println("Introduzca el año de nacimiento del usuario:");
		int year = leer.nextInt();
		
		LocalDate fechaNacimientoFormatted = LocalDate.now();
		fechaNacimientoFormatted.of(year,mes,dia);

		listaUsuarios = fichero.cargarFicheroUsuarios();
		for(int i = 0; i < listaUsuarios.size(); i++) {
			usuario = listaUsuarios.get(i);

			if(usuario.getCorreo()==correo){
				usuario.setFecha(fechaNacimientoFormatted);

				listaUsuarios.set(i,usuario);
				fichero.escribirFicheroUsuarios(listaUsuarios);
				return true;
			}
		}
		return false;
	}

	public boolean modificarUsuarioCorreo() throws FileNotFoundException, IOException{
		Ficheros fichero = new Ficheros();
		Usuario usuario = new Usuario();

		System.out.println("Introduzca el correo antiguo del usuario a modificar:");
		leer.nextLine();
		String correoAntiguo = leer.nextLine();
		System.out.println("Introduzca el correo del usuario a modificar:");
		String correoMod = leer.nextLine();
		
		listaUsuarios = fichero.cargarFicheroUsuarios();
		for(int i = 0; i < listaUsuarios.size(); i++) {
			usuario = listaUsuarios.get(i);

			if(usuario.getCorreo()==correoAntiguo){
				usuario.setCorreo(correoMod);

				listaUsuarios.set(i,usuario);
				fichero.escribirFicheroUsuarios(listaUsuarios);
				return true;
			}
		}
		return false;
	}

	public void listadoUsuarios()throws FileNotFoundException, IOException{
		Ficheros fichero = new Ficheros();
		Usuario usuario = new Usuario();

		listaUsuarios = fichero.cargarFicheroUsuarios();

		for(int i = 0; i < listaUsuarios.size(); i++) {
			usuario = listaUsuarios.get(i);
			System.out.println(usuario.toString());
		}
	}

}


	


