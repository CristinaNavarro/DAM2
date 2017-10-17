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
public class Jugador implements Runnable {

    //Atributos///////////////////////////////////////////////////
    private Thread hiloJugador;

    private int puntos;
    private long tiempo;
    private Marcador marcador;
    private final int TIRADAS = 20;
    private final int PREMIO = 6;
    private final int MINIMOESPERA = 1000;
    private final int MAXIMOESPERA = 3000;

    //Constructor/////////////////////////////////////////////////
    Jugador(String nombre, Marcador marcador) {
        this.puntos = 0;
        this.tiempo = 0;
        this.marcador = marcador;
        hiloJugador = new Thread(this);
        hiloJugador.setName(nombre);
        hiloJugador.start();
    }

    //Métodos/////////////////////////////////////////////////////
    public void run() {
        int dado;
        this.tiempo = System.currentTimeMillis();
        for(int i = 1; i <= TIRADAS; i++){
            dado = tirarDado();
            if(dado == PREMIO) this.puntos++;
            System.out.println(hiloJugador.getName() + " ha sacado un " + dado + " en la tirada " + i
                    + " con un total de " + this.puntos + " puntos");
        }
        this.tiempo = System.currentTimeMillis() - this.tiempo;
        marcador.envioHaciaMarcador(hiloJugador.getName(),this.puntos, this.tiempo);
    }

    //Halla un número aleatorio entre 1-6, además controla el tiempo de espera antes de una tirada
    private int tirarDado() {
        try {
            Thread.sleep((long) (Math.random()*MAXIMOESPERA)+MINIMOESPERA);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return (int) ((Math.random()*6)+1);
    }



}
