package P1;

import java.time.*;

import java.time.temporal.ChronoUnit;

/**
 * Clase Usuario.
 * @author Daniel Hinojosa Sanchez
 * @author Martin Del Rio Jimenez
 * @author Juan Antonio Galvez Jimenez 
 * @author Marta Rubio Sanchez
 * @author Miguel Castro Martin
 */
public class Usuario {
	/** Nombre y apellidos del usuario. */
	private String nombreApellidos;
	/** Fecha de nacimiento del usuario. */
	private LocalDate fechaNacimiento;
	/** Fecha de registro del usuario. */
	private LocalDate inscripcion;
	/** Correo electronico del usuario.*/
	private String correo;	
	
	/**
	 * Constructor que permite instanciar un nuevo objeto de la clase Usuario.
	 */
	public Usuario() {	
	}
	
	/**
	 * Constructor parametrizado que permite instanciar un nuevo objeto de la clase Usuario.
	 *
	 * @param nombreApellidos Cadena de texto con el nombre y apellidos del usuario.
	 * @param fechaNacimiento Tipo LocalDate con la fecha de nacimiento del usuario.
	 * @param correo Cadena de texto con el correo electronico del usuario.
	 */
	public Usuario(String nombreApellidos, LocalDate fechaNacimiento, String correo) {
		this.nombreApellidos = nombreApellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.inscripcion = LocalDate.now();
		this.correo = correo;
	}
	
	/**
	 * Obtiene nombre y apellidos del usuario.
	 *
	 * @return nombreApellidos Cadena de texto con el nombre y apellidos del usuario.
	 */
	public String getNombreApellidos() {
		return this.nombreApellidos;
	}
	
	/**
	 * Establece nombre y apellidos del usuario.
	 *
	 * @param nombreApellidos Cadena de texto con el nombre y apellidos del usuario.
	 */
	public void setNombreApellidos(String nombreApellidos) {
		this.nombreApellidos = nombreApellidos;
	}
	
	/**
	 * Obtiene fecha de nacimiento del usuario.
	 *
	 * @return fechaNacimiento LocalDate con la fecha de nacimiento del usuario.
	 */
	public LocalDate getFecha() {
		return this.fechaNacimiento;
	}
	
	/**
	 * Establece fecha de nacimiento del usuario.
	 *
	 * @param fechaNacimiento LocalDate con la fecha de nacimiento del usuario.
	 */
	public void setFecha(LocalDate fechaNacimiento) {	
		this.fechaNacimiento = fechaNacimiento;
	}
	
	/**
	 * Obtiene fecha de inscripcion del usuario.
	 *
	 * @return inscripcion LocalDate con la fecha de inscripcion del usuario.
	 */
	public LocalDate getInscripcion() {
		return this.inscripcion;
	}
	
	/**
	 * Establece fecha de inscripcion del usuario.
	 *
	 * @param inscripcion LocalDate con la fecha de inscripcion del usuario.
	 */
	public void setInscripcion(LocalDate inscripcion) {
		this.inscripcion = inscripcion;
	}
	
	/**
	 * Obtiene correo electronico del usuario.
	 *
	 * @return correo Cadena de texto con el correo electronico del usuario.
	 */
	public String getCorreo() {
		return this.correo;
	}
	
	/**
	 * Establece correo electronico del usuario.
	 *
	 * @param correo Cadena de texto con el correo electronico del usuario.
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	/**
	 * Obtiene informacion del usuario.
	 * 
	 * @return infoUsuario Cadena de texto con la informacion del usuario.
	 */
	public String toString() {
		String infoUsuario = "Nombre y apellidos: " + this.nombreApellidos + "\tFecha nacimiento: " + this.fechaNacimiento + "\tFecha inscripcion: " + this.inscripcion + "\tCorreo electronico: " + this.correo;
		return infoUsuario;
	}
	
	/**
	 * Obtiene cantidad de años que lleva registrado el usuario.
	 * @return antiguedad Numero con la cantidad de años que lleva registrado.
	 */
	public long calcularAntiguedad(){
		long antiguedad;
			antiguedad=ChronoUnit.YEARS.between(this.inscripcion, LocalDate.now());
		return antiguedad;
	}
	
	/**
	 * Obtiene si el usuario es mayor de edad.
	 * @return Boolean Depende de si es mayor de edad o no.
	 */
	public boolean mayoriaEdad() {
		long edad;
		edad=ChronoUnit.YEARS.between(this.inscripcion, LocalDate.now());
		
		if(edad>=18)
			return true;
		else
			return false;
	}
}
