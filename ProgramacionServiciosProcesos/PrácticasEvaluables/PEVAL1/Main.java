/*
********Autor: Cristina Navarro
********Fecha: 17/10/2017
********Asignatura: Programación de Servicios y Procesos
********Ejercicio:Desarrollar un programa en java que simule
********un juego de cuatro jugadores en el que cada uno de ellos
********tirará un dado a lo largo de 20 intentos.
********El juego lo ganará aquel jugador que obtenga más veces en
********la tirada un seis. En el caso que de empate, ganará el que
********haya lanzado más rápido todas sus tiradas.
********Condiciones: cada jugador tiene su dado y no lo comparte,
********existe un tiempo de espera entre tiradas (1000-3000ms),
********el programa deberá identificar en cada tirada de cada jugador,
********la puntuación obtenida y el total de seises que lleva y
********se debe indicar el jugador que ha ganado.
*/

public class Main {
    public static void main(String[] args) {
        final int NUMEROJUGADORES = 4; //permite elegir el número de jugadores de la partida
        Marcador marcador = new Marcador(NUMEROJUGADORES);

        //Creación de jugadores
        for(int i=0;i<NUMEROJUGADORES;i ++){
            new Jugador("Jugador " + (i+1), marcador);
        }
    }
}
