/*
********Autor: Cristina Navarro*********************
********Fecha: 05/10/2017***************************
********Asignatura:AccesoADatos*********************
********Ejercicio:	Comunicar dos hilos mediante una
********  tubería. De forma que el primer hilo mande
******** una cadena de texto. En la tubería sea*****
******** codificada mediante la codificación César**
******** y sea recibida por el segundo hilo,********
******** visualizando el texto encriptado en pantalla
*/

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Tuberia t = new Tuberia();
        HiloProductor hp = new HiloProductor(t);
        HiloReceptor hr = new HiloReceptor(t);
        hp.start();
        hp.join(); //sin esto, imprime lo que hay por defecto en lugar del string introducido
        hr.start();
    }
}
