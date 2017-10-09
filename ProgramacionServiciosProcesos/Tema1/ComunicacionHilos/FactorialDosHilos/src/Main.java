/*
********Autor: Cristina Navarro*********************
********Fecha: 05/10/2017***************************
********Asignatura:AccesoADatos*********************
********Ejercicio:	Comunicar dos hilos mediante****
********  una tubería. De forma que el primer hilo**
******** mande un número a través de ella y el otro*
******** hilo calcule su factorial y lo visualice.**
*/

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Tuberia t = new Tuberia();
        HiloProductor hp = new HiloProductor(t);
        HiloReceptor hr = new HiloReceptor(t);

        hp.start();
        hp.join();
        hr.start();
    }
}
