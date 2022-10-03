package P1;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Date;

public class Usuario {
	private String nombreApellidos;
	private Date fechaNacimiento;
	private Date inscripcion;
	private String correo;			
	
	public Usuario() {	
	}
	
	public Usuario(String nombreApellidos, Date fechaNacimiento, String correo) {
		this.nombreApellidos = nombreApellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.inscripcion = new Date();
		this.correo = correo;
	}
	
	/*Date fecha = new Date(116,5,3)
	 * Se debe de calcular en el main y pasar una variable de tipo Date con cada parametro correcto
	 * Si no se le pasa parametros coge la hora del sistema
	 * @1 año - 1900 por defecto, si se le pone un valor se suma al 1900
	 * @2 mes - teniendo en cuenta que 0=enero
	 * @3 dia - dia del mes
	 * 
	 * El ejemplo de arriba se refiere al dia 3 de junio de 2016
	*/
	
	public String getNombreApellidos() {
		return nombreApellidos;
	}
	public void setNombreApellidos(String nombreApellidos) {
		this.nombreApellidos = nombreApellidos;
	}
	
	public Date getFecha() {
		return fechaNacimiento;
	}
	public void setFecha(Date fechaNacimiento) {	
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public Date getInscripcion() {
		return inscripcion;
	}
	public void setInscripcion(Date inscripcion) {
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
	
	public void calcularAntiguedad(){
		Date actual = new Date();
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(actual);
		int yearActual = calendar.get(Calendar.YEAR);
		calendar.setTime(this.inscripcion);
		int yearIns = calendar.get(Calendar.YEAR);
		
		int resultado = yearActual-yearIns;
		System.out.println("Lleva registrado " + resultado + " anios.");		
	}
	
	public boolean mayoriaEdad() {
		Date actual = new Date();
		Calendar calendarActual = new GregorianCalendar();
		calendarActual.setTime(actual);
		Calendar calendarNacimiento = new GregorianCalendar();
		calendarNacimiento.setTime(fechaNacimiento);
		
		int yearActual = calendarActual.get(Calendar.YEAR);
		int yearNacimiento = calendarNacimiento.get(Calendar.YEAR);
		
		if((yearActual-yearNacimiento)>=18) {
			if((yearActual-yearNacimiento)==18) {
				int mesActual = calendarActual.get(Calendar.MONTH);
				int mesNacimiento = calendarNacimiento.get(Calendar.MONTH);
				if(mesActual>=mesNacimiento) {
					if(mesActual==mesNacimiento) {
						int diaActual = calendarActual.get(Calendar.DAY_OF_MONTH);
						int diaNacimiento = calendarNacimiento.get(Calendar.DAY_OF_MONTH);
						if(diaActual>=diaNacimiento) {
							return true;
						}
						
					}
					return true;
				}
				
			}
			return true;
		}
		return false;
	}
}
