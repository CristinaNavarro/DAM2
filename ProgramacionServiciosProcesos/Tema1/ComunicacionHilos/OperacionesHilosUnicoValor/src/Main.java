/*
********Autor: Cristina Navarro*********************
********Fecha: 05/10/2017***************************
********Asignatura:AccesoADatos*********************
********Ejercicio:	Comunicar cuatro hilos mediante*
********  una tubería. Cada hilo accederá a un dato*
******** numérico compartido por todos, de forma****
******** que un hilo sumará una cantidad aleatoria,*
******** el otro restará otra cantidad aleatoria,***
******** otro multiplicará y el último dividirá.****
******** ¿Qué ocurre en algunas ocasiones con el****
******** resultado? ¿A qué se debe esto?************
******** Respuesta: ambos toman el valor sin que****
******** el otro haya terminado de operar, *********
******** entonces operan sobre la misma cifra y no**
******** tienen en cuenta que el otro hilo no ha****
******** terminado de operar.***********************
*/


public class Main {
    public static void main(String[] args) throws InterruptedException {
        Tuberia t = new Tuberia();
        Hilo h1 = new Hilo(t,"suma");
        Hilo h2 = new Hilo(t,"resta");
        Hilo h3 = new Hilo(t,"multiplicacion");
        Hilo h4 = new Hilo(t,"division");
        h1.start();
        h2.start();
        h3.start();
        h4.start();
    }
}
