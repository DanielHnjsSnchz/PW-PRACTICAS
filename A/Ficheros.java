package P1;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.io.IOException;
import java.lang.SecurityException;


public class Ficheros {

    Properties properties = new Properties();

    try{

        properties.load(new FileInputStream(new File("properties")));

    }
    catch (FileNotFoundException e){
        // TODO Auto-generated catch block
        e.printStackTrace();
    }catch (IOException a){
        // TODO Auto-generated catch block
        a.printStackTrace();
    }catch (SecurityException o){
        o.printStackTrace();
    }


    public Ficheros(){
    }

    public ArrayList<Kart> cargarFicheroKarts(){
    }

    public ArrayList<Pista> cargarFicheroPista(){
    }

    public ArrayList<Usuario> cargarFicheroUsuarios(){

        try{

            File f = new File(properties.get("USUARIOS"));

            FileReader fr = null;
            BufferedReader buffer = null;

            String lineaFichero = null;

            String[] lineaCampos;

            ArrayList<Usuario> arrayUsuario = new ArrayList<Usuario>();

            fr = new FileReader(f);
            buffer = new BufferedReader(fr);

            boolean coincide = false;

            Usuario usuarioaux;


            while ((lineaFichero = buffer.readLine()) != null) {
                usuarioaux = new Usuario();

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

                usuarioaux.setNombreApellidos(lineaCampos[0]);
                usuarioaux.setFecha(fecha);
                usuarioaux.setInscripcion(fechaInscripcion);
                usuarioaux.setCorreo(lineaCampos[3]);

                arrayUsuario.add(usuarioaux);
            }

            return arrayUsuario;

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }



    }

    public void escribirFicheroKarts(){
    }

    public void escribirFicheroPista(){
    }

    public void escribirFicheroUsuarios(){
    }
}
