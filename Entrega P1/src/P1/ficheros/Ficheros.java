package P1.ficheros;

import P1.karts.Kart;
import P1.karts.Estado;
import P1.pistas.Pista;
import P1.pistas.Dificultad;
import P1.usuarios.Usuario;
import P1.reservas.ReservaAdultos;
import P1.reservas.ReservaFamiliar;
import P1.reservas.ReservaInfantil;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Properties;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Ficheros{

    public Ficheros(){
    }

    //Probar con ArrayList<T>cargarFichero(String properties.getProperty()); (parametrizado)
    @SuppressWarnings({ "static-access"})
	public ArrayList<Kart> cargarFicheroKarts() throws FileNotFoundException, IOException{
    	Properties p = new Properties();
        p.load(new FileReader("config.properties"));
        File f = new File(p.getProperty("karts"));
    	FileReader fr = null;
    	BufferedReader buffer = null;
     	String lineaFichero = null;
     	String[] lineaCampos;
     	ArrayList<Kart> arrayKarts = new ArrayList<Kart>();

      	fr = new FileReader(f);
      	buffer = new BufferedReader(fr);
      	
       	Kart kart;
       	int id=0;
      	Estado estadoKart=Estado.mantenimiento;
      	boolean tipo = false;
      	
      	while((lineaFichero = buffer.readLine()) != null) {
          	kart = new Kart();
          	lineaCampos = lineaFichero.split(";");

         	if(lineaCampos[1]=="Adulto"){
            	tipo = true;
           	}
         	
         	estadoKart.valueOf(lineaCampos[2]);
          	id = Integer.parseInt(lineaCampos[0]);

          	kart.setId(id);
          	kart.setEstado(estadoKart);
        	kart.setTipo(tipo);
          	arrayKarts.add(kart);
      	}
      	buffer.close();
      	return arrayKarts;

    }

    @SuppressWarnings("static-access")
	public ArrayList<Pista> cargarFicheroPistaDisponibles()throws FileNotFoundException, IOException{
     	Properties p = new Properties();
     	p.load(new FileReader("config.properties.txt"));
      	File f = new File(p.getProperty("pistasDisponibles"));
       	FileReader fr = null;
       	BufferedReader buffer = null;
      	String lineaFichero = null;
      	String[] lineaCampos;
      	ArrayList<Pista> arrayPistasDisponibles = new ArrayList<Pista>();
      	fr = new FileReader(f);
       	buffer = new BufferedReader(fr);

      	Pista pista;
       	int maxkarts = 0;
       	Dificultad dificultad = Dificultad.infantil;
		boolean estadoPista = false;

      	while((lineaFichero = buffer.readLine()) != null) {
          	pista = new Pista();
          	lineaCampos = lineaFichero.split(";");

          	if(lineaCampos[1]=="Disponible"){
             	estadoPista = true;
          	}

          	dificultad.valueOf(lineaCampos[2]);
          	maxkarts = Integer.parseInt(lineaCampos[3]);

        	pista.setNombre(lineaCampos[0]);
        	pista.setEstado(estadoPista);
         	pista.setDificultad(dificultad);
          	pista.setMaxKarts(maxkarts);
	
	       	arrayPistasDisponibles.add(pista);
      	}
      	buffer.close();
      	return arrayPistasDisponibles;   
    }

	@SuppressWarnings("static-access")
	public ArrayList<Pista> cargarFicheroPistaNoDisponibles() throws FileNotFoundException, IOException {
		Properties p = new Properties();
		p.load(new FileReader("config.properties.txt"));
		File f = new File(p.getProperty("pistasNoDisponibles"));
		FileReader fr = null;
		BufferedReader buffer = null;
		String lineaFichero = null;
		String[] lineaCampos;
		ArrayList<Pista> arrayPistasNoDisponibles = new ArrayList<Pista>();

		fr = new FileReader(f);
		buffer = new BufferedReader(fr);

		Pista pista;
		int maxkarts = 0;
		Dificultad dificultad = Dificultad.infantil;
		boolean estadoPista = false;

		while((lineaFichero = buffer.readLine()) != null) {
			pista = new Pista();

			lineaCampos = lineaFichero.split(";");

			if(lineaCampos[1] == "Disponible") {
				estadoPista = true;
			}

			dificultad.valueOf(lineaCampos[2]);
			maxkarts = Integer.parseInt(lineaCampos[3]);

			pista.setNombre(lineaCampos[0]);
			pista.setEstado(estadoPista);
			pista.setDificultad(dificultad);
			pista.setMaxKarts(maxkarts);

			arrayPistasNoDisponibles.add(pista);
		}
		buffer.close();
		return arrayPistasNoDisponibles;
	}

	@SuppressWarnings("static-access")
	public ArrayList<Usuario> cargarFicheroUsuarios() throws FileNotFoundException, IOException {
		Properties p = new Properties();
		p.load(new FileReader("config.properties"));
		File f = new File(p.getProperty("usuarios"));
		FileReader fr = null;
		BufferedReader buffer = null;
		String lineaFichero = null;
		String[] lineaCampos;
		ArrayList<Usuario> arrayUsuario = new ArrayList<Usuario>();

		fr = new FileReader(f);
		buffer = new BufferedReader(fr);

		Usuario usuario;

		while((lineaFichero = buffer.readLine()) != null) {
			usuario = new Usuario();
			lineaCampos = lineaFichero.split(";");

			String[] stringfecha = lineaCampos[1].split("-");
			int year = Integer.parseInt(stringfecha[0]);
			int mes = Integer.parseInt(stringfecha[1]);
			int dia = Integer.parseInt(stringfecha[2]);
			LocalDate fecha = null;
			fecha.of(year, mes, dia);

			String[] stringfechaInscripcion = lineaCampos[2].split("-");
			int yearInscripcion = Integer.parseInt(stringfechaInscripcion[0]);
			int mesInscripcion = Integer.parseInt(stringfechaInscripcion[1]);
			int diaInscripcion = Integer.parseInt(stringfechaInscripcion[2]);
			LocalDate fechaInscripcion = null;
			fechaInscripcion.of(yearInscripcion, mesInscripcion, diaInscripcion);

			usuario.setNombreApellidos(lineaCampos[0]);
			usuario.setFecha(fecha);
			usuario.setInscripcion(fechaInscripcion);
			usuario.setCorreo(lineaCampos[3]);

			arrayUsuario.add(usuario);
		}
		buffer.close();
		return arrayUsuario;
	}
	
	@SuppressWarnings("static-access")
	public ArrayList<ReservaAdultos> cargarFicheroReservaAdulto()throws FileNotFoundException, IOException {
		Properties p = new Properties();
		p.load(new FileReader("config.properties"));
		File f = new File(p.getProperty("reservaAdulto"));
		FileReader fr = null;
		BufferedReader buffer = null;
		String lineaFichero = null;
		String[] lineaCampos;
		ArrayList<ReservaAdultos> arrayReserva = new ArrayList<ReservaAdultos>();

		fr = new FileReader(f);
		buffer = new BufferedReader(fr);

		ReservaAdultos reserva;

		while((lineaFichero = buffer.readLine()) != null) {
			reserva = new ReservaAdultos();
			lineaCampos = lineaFichero.split(";");

			String[] stringfecha = lineaCampos[1].split("-");
			int year = Integer.parseInt(stringfecha[0]);
			int mes = Integer.parseInt(stringfecha[1]);
			int dia = Integer.parseInt(stringfecha[2]);
			LocalDate fecha = null;
			fecha.of(year, mes, dia);
			int duracion = Integer.parseInt(lineaCampos[2]);
			double precio = Double.parseDouble(lineaCampos[4]);
			double descuento = Double.parseDouble(lineaCampos[5]);
			Usuario usuario = new Usuario();
			usuario.setCorreo(lineaCampos[0]);
			int numAdultos = Integer.parseInt(lineaCampos[6]);

			reserva.setIdReservaUsuario(usuario);
			reserva.setFecha(fecha);
			reserva.setDuracion(duracion);
			reserva.setIdReservaPista(lineaCampos[3]);
			reserva.setPrecio(precio);
			reserva.setDescuento(descuento);
			reserva.setNumAdultos(numAdultos);

			/*
			BonoReservas bono = new BonoReservas();
			int bonoId = Integer.parseInt(lineaCampos[7]);
			if(lineaCampos[7]!=0){

				bono.setId(bonoId);

			}
			*/
			arrayReserva.add(reserva);
		}
		buffer.close();
		return arrayReserva;
	}
	
	@SuppressWarnings("static-access")
	public ArrayList<ReservaInfantil> cargarFicheroReservaInfantil()throws FileNotFoundException, IOException {
		Properties p = new Properties();
		p.load(new FileReader("config.properties"));
		File f = new File(p.getProperty("reservaInfantil"));
		FileReader fr = null;
		BufferedReader buffer = null;
		String lineaFichero = null;
		String[] lineaCampos;
		ArrayList<ReservaInfantil> arrayReserva = new ArrayList<ReservaInfantil>();

		fr = new FileReader(f);
		buffer = new BufferedReader(fr);

		ReservaInfantil reserva;

		while((lineaFichero = buffer.readLine()) != null) {
			reserva = new ReservaInfantil();
			lineaCampos = lineaFichero.split(";");

			String[] stringfecha = lineaCampos[1].split("-");
			int year = Integer.parseInt(stringfecha[0]);
			int mes = Integer.parseInt(stringfecha[1]);
			int dia = Integer.parseInt(stringfecha[2]);
			LocalDate fecha = null;
			fecha.of(year, mes, dia);
			int duracion = Integer.parseInt(lineaCampos[2]);
			double precio = Double.parseDouble(lineaCampos[4]);
			double descuento = Double.parseDouble(lineaCampos[5]);
			Usuario usuario = new Usuario();
			usuario.setCorreo(lineaCampos[0]);
			int numInfantil = Integer.parseInt(lineaCampos[6]);

			reserva.setIdReservaUsuario(usuario);
			reserva.setFecha(fecha);
			reserva.setDuracion(duracion);
			reserva.setIdReservaPista(lineaCampos[3]);
			reserva.setPrecio(precio);
			reserva.setDescuento(descuento);
			reserva.setNumInfantil(numInfantil);

			/*
			BonoReservas bono = new BonoReservas();
			int bonoId = Integer.parseInt(lineaCampos[7]);
			if(lineaCampos[7]!=0){

				bono.setId(bonoId);

			}
			*/
			arrayReserva.add(reserva);
		}
		buffer.close();
		return arrayReserva;
	}
	
	@SuppressWarnings("static-access")
	public ArrayList<ReservaFamiliar> cargarFicheroReservaFamiliar()throws FileNotFoundException, IOException {
		Properties p = new Properties();
		p.load(new FileReader("config.properties"));
		File f = new File(p.getProperty("reservaFamiliar"));
		FileReader fr = null;
		BufferedReader buffer = null;
		String lineaFichero = null;
		String[] lineaCampos;
		ArrayList<ReservaFamiliar> arrayReserva = new ArrayList<ReservaFamiliar>();

		fr = new FileReader(f);
		buffer = new BufferedReader(fr);

		ReservaFamiliar reserva;

		while((lineaFichero = buffer.readLine()) != null) {
			reserva = new ReservaFamiliar();
			lineaCampos = lineaFichero.split(";");

			String[] stringfecha = lineaCampos[1].split("-");
			int year = Integer.parseInt(stringfecha[0]);
			int mes = Integer.parseInt(stringfecha[1]);
			int dia = Integer.parseInt(stringfecha[2]);
			LocalDate fecha = null;
			fecha.of(year, mes, dia);
			int duracion = Integer.parseInt(lineaCampos[2]);
			double precio = Double.parseDouble(lineaCampos[4]);
			double descuento = Double.parseDouble(lineaCampos[5]);
			Usuario usuario = new Usuario();
			usuario.setCorreo(lineaCampos[0]);
			int numAdultos = Integer.parseInt(lineaCampos[6]);
			int numInfantil = Integer.parseInt(lineaCampos[7]);

			reserva.setIdReservaUsuario(usuario);
			reserva.setFecha(fecha);
			reserva.setDuracion(duracion);
			reserva.setIdReservaPista(lineaCampos[3]);
			reserva.setPrecio(precio);
			reserva.setDescuento(descuento);
			reserva.setNumAdultos(numAdultos);
			reserva.setNumInfantil(numInfantil);

			/*
			BonoReservas bono = new BonoReservas();
			int bonoId = Integer.parseInt(lineaCampos[7]);
			if(lineaCampos[7]!=0){

				bono.setId(bonoId);

			}
			*/
			arrayReserva.add(reserva);
		}
		buffer.close();
		return arrayReserva;
	}
	
	@SuppressWarnings("null")
	public void escribirFicheroKarts(ArrayList<Kart> listaKarts) throws FileNotFoundException, IOException {
		Properties p = new Properties();
		p.load(new FileReader("config.properties"));
		File f = new File(p.getProperty("karts"));
		ArrayList<Kart> arrayKarts = null;
		arrayKarts = new Ficheros().cargarFicheroKarts();

		BufferedWriter bw = new BufferedWriter(new FileWriter(f));
		bw.write("");
		bw.close();

		FileWriter fw = null;
		fw = new FileWriter(f);

		String[] lineaUsuario = null;
		Kart kart;
		Estado estadoKart = Estado.mantenimiento;
		
		for(int i = 0; i < arrayKarts.size(); i++) {
			kart = arrayKarts.get(i);

			if(kart.getTipo() == true) {
				lineaUsuario[1] = "Adulto";
			}else {
				lineaUsuario[1] = "Infantil";
			}
			
			estadoKart = kart.getEstado();
			lineaUsuario[0] = String.valueOf(kart.getId());
			lineaUsuario[2] = estadoKart.name();

			fw.write(lineaUsuario[0] + ";" + lineaUsuario[1] + ";" + lineaUsuario[2] + "\n");
			// fw.write(useraux.toString(););
		}
		fw.close();
	}

    @SuppressWarnings("null")
	public void escribirFicheroPistaDisponibles(ArrayList<Pista> listaPistas)throws FileNotFoundException, IOException{
        Properties p = new Properties();
        p.load(new FileReader("config.properties"));
        File f = new File( p.getProperty("pistasDisponibles"));
        ArrayList<Pista> arrayPistaDisponibles = null;
        arrayPistaDisponibles = new Ficheros().cargarFicheroPistaDisponibles();

        BufferedWriter bw =new BufferedWriter(new FileWriter(f));
        bw.write("");
        bw.close();

        FileWriter fw = null;
        fw = new FileWriter(f);

        String[] lineaUsuario = null;
        Pista pista;
        Dificultad dificultad = Dificultad.infantil;

        for(int i=0; i<arrayPistaDisponibles.size();i++) {
            pista=arrayPistaDisponibles.get(i);

            if(pista.getEstado()==true) {
                lineaUsuario[1]="Disponible";
            }else {
                lineaUsuario[1]="NoDisponible";
            }

            dificultad = pista.getDificultad();

            lineaUsuario[0]= pista.getNombre();
            lineaUsuario[2]= dificultad.name();
            lineaUsuario[3]= String.valueOf(pista.getMaxKarts());

            fw.write(lineaUsuario[0] + ";" + lineaUsuario[1] + ";" + lineaUsuario[2] + ";" + lineaUsuario[3] + "\n");
            //fw.write(useraux.toString(););
        }
        fw.close();
    }

    @SuppressWarnings("null")
	public void escribirFicheroPistaNoDisponibles(ArrayList<Pista> listaPistasNoDisponibles)throws FileNotFoundException, IOException{
        Properties p = new Properties();
        p.load(new FileReader("config.properties"));
        File f = new File(p.getProperty("pistasNoDisponibles"));
        ArrayList<Pista> arrayPistaDisponibles = null;
        arrayPistaDisponibles = new Ficheros().cargarFicheroPistaNoDisponibles();

        BufferedWriter bw =new BufferedWriter(new FileWriter(f));
        bw.write("");
        bw.close();

        FileWriter fw = null;
        fw = new FileWriter(f);

        String[] lineaUsuario = null;
        Pista pista;
        Dificultad dificultad = Dificultad.infantil;

        for(int i=0; i<arrayPistaDisponibles.size();i++ ){
            pista=arrayPistaDisponibles.get(i);

            if(pista.getEstado()==true) {
                lineaUsuario[1]="Disponible";
            }else {
                lineaUsuario[1]="NoDisponible";
            }

            dificultad = pista.getDificultad();

            lineaUsuario[0]=pista.getNombre();
            lineaUsuario[2]=dificultad.name();
            lineaUsuario[3]=Integer.toString(pista.getMaxKarts());

            fw.write(lineaUsuario[0] + ";" + lineaUsuario[1] + ";" + lineaUsuario[2] + ";" + lineaUsuario[3] + "\n");
            //fw.write(useraux.toString(););
        }
        fw.close();
    }

    @SuppressWarnings("null")
    public void escribirFicheroUsuarios(ArrayList<Usuario> listaUsuarios)throws FileNotFoundException, IOException{
        Properties p = new Properties();
        p.load(new FileReader("config.properties"));
        File f = new File(p.getProperty("usuarios"));
        ArrayList<Usuario> arrayUsuario = null;
        arrayUsuario = new Ficheros().cargarFicheroUsuarios();

        BufferedWriter bw =new BufferedWriter(new FileWriter(f));
        bw.write("");
        bw.close();

        FileWriter fw = null;
        fw = new FileWriter(f);

        String[] lineaUsuario = null;
        Usuario usuario;
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-DD");
        String formattedStringNacimiento = null;
        String formattedStringInscripcion = null;

        for(int i=0; i<arrayUsuario.size();i++ ){
        	usuario=arrayUsuario.get(i);

            LocalDate fechaNacimiento = usuario.getFecha();
            LocalDate fechaInsc = usuario.getInscripcion();

            formattedStringNacimiento = fechaNacimiento.format(formatter);
            formattedStringInscripcion = fechaInsc.format(formatter);

            lineaUsuario[0]=usuario.getNombreApellidos();
            lineaUsuario[1]=formattedStringNacimiento;
            lineaUsuario[2]=formattedStringInscripcion;
            lineaUsuario[3]=usuario.getCorreo();

            fw.write(lineaUsuario[0] + ";" + lineaUsuario[1] + ";" + lineaUsuario[2] + ";" + lineaUsuario[3] + "\n");
            //fw.write(useraux.toString(););
        }
        fw.close();
    }
    
    @SuppressWarnings({ "static-access", "null" })
	public void escribirFicheroReservaAdulto(ArrayList<ReservaAdultos> listaReservaAdulto)throws FileNotFoundException, IOException{
		Properties p = new Properties();
		p.load(new FileReader("config.properties"));
		File f = new File(p.getProperty("reservaAdulto"));
		ArrayList<ReservaAdultos> arrayReserva = null;
		arrayReserva = new Ficheros().cargarFicheroReservaAdulto();

		BufferedWriter bw =new BufferedWriter(new FileWriter(f));
		bw.write("");
		bw.close();

		FileWriter fw = null;
		fw = new FileWriter(f);

		String[] lineaUsuario = null;
		ReservaAdultos reserva;

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-DD");
		String formattedStringFecha = null;

		for(int i=0; i<arrayReserva.size();i++ ){
			reserva=arrayReserva.get(i);

			LocalDate fechaNacimiento = reserva.getFecha();

			formattedStringFecha = fechaNacimiento.format(formatter);

			lineaUsuario[0]=reserva.getIdReservaUsuario();
			lineaUsuario[1]=formattedStringFecha;
			lineaUsuario[2]=Integer.toString(reserva.getDuracion());
			lineaUsuario[3]=reserva.getIdReservaPista();
			lineaUsuario[4]=Double.toString(reserva.getPrecio());
			lineaUsuario[5]=Double.toString(reserva.getDescuento());
			lineaUsuario[6]=Integer.toString(reserva.getNumAdultos());

			fw.write(lineaUsuario[0] + ";" + lineaUsuario[1] + ";" + lineaUsuario[2] + ";" + lineaUsuario[3] + ";" + lineaUsuario[4] + ";" + lineaUsuario[5] + ";" +lineaUsuario[6] + "\n");
			//fw.write(useraux.toString(););
		}
		fw.close();
	}
    
	@SuppressWarnings({ "static-access", "null" })
	public void escribirFicheroReservaInfantil(ArrayList<ReservaInfantil> listaReservaInfantil)throws FileNotFoundException, IOException{
		Properties p = new Properties();
		p.load(new FileReader("config.properties"));
		File f = new File(p.getProperty("reservaInfantil"));
		ArrayList<ReservaInfantil> arrayReserva = null;
		arrayReserva = new Ficheros().cargarFicheroReservaInfantil();

		BufferedWriter bw =new BufferedWriter(new FileWriter(f));
		bw.write("");
		bw.close();

		FileWriter fw = null;
		fw = new FileWriter(f);

		String[] lineaUsuario = null;
		ReservaInfantil reserva;

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-DD");
		String formattedStringFecha = null;

		for(int i=0; i<arrayReserva.size();i++ ){
			reserva=arrayReserva.get(i);

			LocalDate fechaNacimiento = reserva.getFecha();

			formattedStringFecha = fechaNacimiento.format(formatter);

			lineaUsuario[0]=reserva.getIdReservaUsuario();
			lineaUsuario[1]=formattedStringFecha;
			lineaUsuario[2]=Integer.toString(reserva.getDuracion());
			lineaUsuario[3]=reserva.getIdReservaPista();
			lineaUsuario[4]=Double.toString(reserva.getPrecio());
			lineaUsuario[5]=Double.toString(reserva.getDescuento());
			lineaUsuario[6]=Integer.toString(reserva.getNumInfantil());

			fw.write(lineaUsuario[0] + ";" + lineaUsuario[1] + ";" + lineaUsuario[2] + ";" + lineaUsuario[3] + ";" + lineaUsuario[4] + ";" + lineaUsuario[5] + ";" +lineaUsuario[6] + "\n");
			//fw.write(useraux.toString(););
		}
		fw.close();
	}
	@SuppressWarnings({ "static-access", "null" })
	public void escribirFicheroReservaFamiliar(ArrayList<ReservaFamiliar> listaReservaFamiliar)throws FileNotFoundException, IOException{
		Properties p = new Properties();
		p.load(new FileReader("config.properties"));
		File f = new File(p.getProperty("reservaFamiliar"));
		ArrayList<ReservaFamiliar> arrayReserva = null;
		arrayReserva = new Ficheros().cargarFicheroReservaFamiliar();

		BufferedWriter bw =new BufferedWriter(new FileWriter(f));
		bw.write("");
		bw.close();

		FileWriter fw = null;
		fw = new FileWriter(f);

		String[] lineaUsuario = null;
		ReservaFamiliar reserva;

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-DD");
		String formattedStringFecha = null;

		for(int i=0; i<arrayReserva.size();i++ ){
			reserva=arrayReserva.get(i);

			LocalDate fechaNacimiento = reserva.getFecha();

			formattedStringFecha = fechaNacimiento.format(formatter);

			lineaUsuario[0]=reserva.getIdReservaUsuario();
			lineaUsuario[1]=formattedStringFecha;
			lineaUsuario[2]=Integer.toString(reserva.getDuracion());
			lineaUsuario[3]=reserva.getIdReservaPista();
			lineaUsuario[4]=Double.toString(reserva.getPrecio());
			lineaUsuario[5]=Double.toString(reserva.getDescuento());
			lineaUsuario[6]=Integer.toString(reserva.getNumAdultos());
			lineaUsuario[7]=Integer.toString(reserva.getNumInfantil());


			fw.write(lineaUsuario[0] + ";" + lineaUsuario[1] + ";" + lineaUsuario[2] + ";" + lineaUsuario[3] + ";" + lineaUsuario[4] + ";" + lineaUsuario[5] + ";" +lineaUsuario[6] + ";" + lineaUsuario[7] + "\n");
			//fw.write(useraux.toString(););
		}
		fw.close();
	}
}
