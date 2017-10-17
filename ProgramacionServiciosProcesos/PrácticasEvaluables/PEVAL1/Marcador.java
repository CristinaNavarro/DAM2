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
class Marcador {

    //Atributos///////////////////////////////////////////////////////////////////
    private String ganador;
    private final int NUMEROJUGADORES;
    private String[] listaNombres;
    private int[] listaPuntuacion;
    private long[] listaTiempo;

    //Constructor//////////////////////////////////////////////////////////////////
    Marcador(int NUMEROJUGADORES){
        this.NUMEROJUGADORES = NUMEROJUGADORES;
        this.listaNombres = new String[NUMEROJUGADORES];
        this.listaPuntuacion = new int[NUMEROJUGADORES];
        this.listaTiempo = new long[NUMEROJUGADORES];
    }


    //Métodos//////////////////////////////////////////////////////////////////////
    //Recibe desde cada jugador su nombre, puntos y tiempo, guardando los datos en orden por nombre
    void envioHaciaMarcador(String nombre, int puntos, long tiempo) {
        int posicion = Integer.parseInt(nombre.substring(nombre.length()-1,nombre.length()));
        listaNombres[posicion-1] = nombre;
        listaPuntuacion[posicion-1] = puntos;
        listaTiempo[posicion-1] = tiempo;
        if(comprobarFinalizacion()){
            System.out.println("\n --- MARCADOR --- ");
            this.imprimirMarcador();
            this.decidirGanador();
            System.out.println("\n --- GANADOR ---");
            System.out.println("El ganador es " + this.ganador);
        }
    }

    //Imprime los resultados obtenidos por cada jugador
    private void imprimirMarcador() {
        for(int i = 0; i < listaPuntuacion.length; i++){
            System.out.println(listaNombres[i] + " -- " + listaPuntuacion[i] + " puntos en un tiempo de "
                    + listaTiempo[i] +"ms");
        }
    }

    //Examina y decide el ganador siendo este el jugador con mayor cantidad de puntos y,
    // en caso de empate, el que haya terminado antes sus tiradas
    private void decidirGanador() {
        this.ganador = listaNombres[0];
        for(int i = 1; i < listaPuntuacion.length; i++){
            if(listaPuntuacion[0] < listaPuntuacion[i]) {
                listaPuntuacion[0] = listaPuntuacion[i];
                this.ganador = listaNombres[i];
            }else if(listaPuntuacion[0] == listaPuntuacion[i]){
                if(listaTiempo[0] > listaTiempo[i]){
                    listaTiempo[0] = listaTiempo[i];
                    this.ganador = listaNombres[i];
                }
            }
        }
    }

    //Comprueba si existe algun null en algunos de los jugadores, significando esto que
    //no han terminado todos los jugadores
    private boolean comprobarFinalizacion(){
        boolean completo = true;
        for(int i = 0; i < NUMEROJUGADORES; i++){
            if (listaNombres[i] == null){
                completo = false;
            }
        }
        return completo;
    }
}
