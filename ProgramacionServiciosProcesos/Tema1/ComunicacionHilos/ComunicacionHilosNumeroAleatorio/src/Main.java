/*
********Autor: Cristina Navarro*********************
********Fecha: 04/10/2017***************************
********Asignatura:AccesoADatos*********************
********Ejercicio:	Comunicar dos hilos mediante****
******** una tubería. De forma que los hilos********
******** accedan a un número compartido y los*******
******** incrementen en número aleatorio. Los hilos*
******** deben identificarse al realizar la*********
******** operación.*********************************
*/

public class Main {
    public static void main(String[] args) {
        Tuberia t = new Tuberia();
        Hilo h1 = new Hilo(t,"Hola");
        Hilo h2 = new Hilo(t,"Adios");
        h1.start();
        h2.start();
    }
}
