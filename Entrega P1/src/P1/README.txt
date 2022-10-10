	Programación Web - Práctica 1

Daniel Hinojosa Sánchez - i02hisad@uco.es
Martín Del Río Jiménez - i02rijim@uco.es
Juan Antonio  Gálvez Jiménez - i02gajia@uco.es
Marta Rubio Sánchez - i82rusam@uco.es
Miguel Castro Martín - i82casmm@uco.es

	Uso del programa

Para el correcto uso del programa se debe tener en cuenta el fichero config.properties de configuración en el cual se introducen las parejas claves-valor del programa:

usuarios=usuarios.txt
pistasDisponibles=pistasDisponibles.txt
pistasNoDisponibles=pistasNoDisponibles.txt
karts=karts.txt
reservaAdulto=reservaAdulto.txt
reservaInfantil=reservaInfantil.txt
reservaFamiliar=reservaFamiliar.txt

"usuarios.txt" como fichero para guardar la información de los usuarios registrados en el sistema.
"pistasDisponibles.txt" como fichero para guardar la información de las pistas disponibles registradas en el sistema.
"pistasNoDisponibles.txt" como fichero para guardar la información de las pistas no disponibles registradas en el sistema.
"karts.txt" como fichero para guardar la información de los karts no asociados a ninguna pista pero si registrados en el sistema.
"reservaAdulto.txt"como fichero para guardar la información de las reservas de tipo adultor egistradas en el sistema.
"reservasInfantil.txt"como fichero para guardar la información de las reservas de tipo infantil registradas en el sistema.
"reservaFamiliar.txt"como fichero para guardar la información de las reservas de tipo familiar registradas en el sistema.

	Ejecución del programa
java -jar PW.jar