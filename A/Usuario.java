package P1;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class Usuario {
	private String nombreApellidos;
	private LocalDate fechaNacimiento;
	private LocalDate inscripcion;
	private String correo;			
	
	public Usuario() {	
	}
	
	public Usuario(String nombreApellidos, LocalDate fechaNacimiento, String correo) {
		this.nombreApellidos = nombreApellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.inscripcion = LocalDate.now();
		this.correo = correo;
	}

	public String getNombreApellidos() {
		return nombreApellidos;
	}
	public void setNombreApellidos(String nombreApellidos) {
		this.nombreApellidos = nombreApellidos;
	}
	
	public LocalDate getFecha() {
		return fechaNacimiento;
	}
	public void setFecha(LocalDate fechaNacimiento) {	
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public LocalDate getInscripcion() {
		return inscripcion;
	}
	public void setInscripcion(LocalDate inscripcion) {
		this.inscripcion = inscripcion;
	}
	
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	public String toString() {
		String infoUsuario = "Nombre y apellidos: " + this.nombreApellidos + "\tFecha nacimiento: " + this.fechaNacimiento + "\tFecha inscripcion: " + this.inscripcion + "\tCorreo electronico: " + this.correo;
		return infoUsuario;
	}
	
	public long calcularAntiguedad(){
		long antiguedad;
			antiguedad=ChronoUnit.YEARS.between(this.inscripcion, LocalDate.now());
		return antiguedad;
	}
	
	public boolean mayoriaEdad() {
		long edad;
		edad=ChronoUnit.YEARS.between(this.inscripcion, LocalDate.now());
		
		if(edad>=18)
			return true;
		else
			return false;
	}
}
